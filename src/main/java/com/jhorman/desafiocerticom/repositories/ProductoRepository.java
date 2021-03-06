package com.jhorman.desafiocerticom.repositories;

import java.util.ArrayList;

import com.jhorman.desafiocerticom.models.ProductoModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long> {

  public abstract ArrayList<ProductoModel> findByEstado(int estado);
  
}
