package com.server.tenembalaje.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.tenembalaje.security.entity.Rol;
import com.server.tenembalaje.security.enums.RolNombre;

@Repository
public interface  RolRepository extends JpaRepository <Rol, Integer>{
	Optional<Rol> findByRolNombre(RolNombre rolNombre);
	

}
