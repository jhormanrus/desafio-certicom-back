package com.jhorman.desafiocerticom.repositories;

import java.util.ArrayList;
import java.util.Date;

import com.jhorman.desafiocerticom.models.VentaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends CrudRepository<VentaModel, Long> {

  public abstract ArrayList<VentaModel> findByFecha(Date fecha);
  
}
