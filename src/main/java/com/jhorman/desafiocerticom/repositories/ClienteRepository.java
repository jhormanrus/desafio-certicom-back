package com.jhorman.desafiocerticom.repositories;

import com.jhorman.desafiocerticom.models.ClienteModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long> {

  
  
}
