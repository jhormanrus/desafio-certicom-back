package com.jhorman.desafiocerticom.services;

import java.util.ArrayList;

import com.jhorman.desafiocerticom.models.ClienteModel;
import com.jhorman.desafiocerticom.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

  @Autowired
  ClienteRepository clienteRepository;

  public ArrayList<ClienteModel> listarClientes() {
    return (ArrayList<ClienteModel>) clienteRepository.findAll();
  }

  public void guardarCliente(ClienteModel cliente) {
    clienteRepository.save(cliente);
  }
  
}
