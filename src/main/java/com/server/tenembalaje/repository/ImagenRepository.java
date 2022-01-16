package com.server.tenembalaje.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.tenembalaje.entity.Imagen;



@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
    List<Imagen> findByOrderById();
    Imagen findByImagenUrl(String imagenUrl);
}
