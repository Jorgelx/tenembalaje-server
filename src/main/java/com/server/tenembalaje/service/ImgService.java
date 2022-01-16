package com.server.tenembalaje.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.tenembalaje.entity.Imagen;
import com.server.tenembalaje.repository.ImagenRepository;



@Service
@Transactional
public class ImgService {
	
	 	@Autowired
	    ImagenRepository imagenRepository;

	    public List<Imagen> list(){
	        return imagenRepository.findByOrderById();
	    }

	    public Optional<Imagen> getOne(int id){
	        return imagenRepository.findById(id);
	    }

	    public void save(Imagen imagen){
	        imagenRepository.save(imagen);
	    }

	    public void delete(int id){
	        imagenRepository.deleteById(id);
	    }

	    public boolean exists(int id){
	        return imagenRepository.existsById(id);
	    }
	    

	    public Imagen getByUrl(String url){
	        return imagenRepository.findByImagenUrl(url);
	    }
}
