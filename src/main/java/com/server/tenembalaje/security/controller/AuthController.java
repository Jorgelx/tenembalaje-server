package com.server.tenembalaje.security.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.tenembalaje.security.dto.JwtDto;
import com.server.tenembalaje.security.dto.LoginUsuario;
import com.server.tenembalaje.security.dto.NuevoUsuario;
import com.server.tenembalaje.security.entity.Rol;
import com.server.tenembalaje.security.entity.Usuario;
import com.server.tenembalaje.security.enums.RolNombre;
import com.server.tenembalaje.security.jwt.JwtProvider;
import com.server.tenembalaje.security.service.RolService;
import com.server.tenembalaje.security.service.UsuarioService;
import com.server.tenembalaje.utils.Mensaje;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RolService rolService;

	@Autowired
	JwtProvider jwtProvider;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/new")
	public ResponseEntity<?> newUser(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("El email o contraseña es invalido"), HttpStatus.BAD_REQUEST);
		
		if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("El nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
		
		if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity(new Mensaje("El email ya existe"), HttpStatus.BAD_REQUEST);
		
		Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
				nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
		
		Set<Rol> roles = new HashSet<>();
		
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
		if (nuevoUsuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
		usuario.setRoles(roles);
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("Usuario creado"), HttpStatus.CREATED);
	}
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @PostMapping("/login")
	public ResponseEntity<JwtDto> loggin(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("Usuario o contraseña no son correctos"), HttpStatus.BAD_REQUEST);

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(
						loginUsuario.getNombreUsuario() , loginUsuario.getPassword()));
	
		 SecurityContextHolder.getContext().setAuthentication(authentication);
		 
		 String jwt = jwtProvider.generateToken(authentication);
		 
		 UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
	        return new ResponseEntity(jwtDto, HttpStatus.OK);
	}
}
