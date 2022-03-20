package com.jhorman.desafiocerticom.controllers;

import java.util.ArrayList;

import com.jhorman.desafiocerticom.models.ClienteModel;
import com.jhorman.desafiocerticom.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
  
  @Autowired
  ClienteService clienteService;

  @GetMapping()
  public ArrayList<ClienteModel> listarClientes() {
    return clienteService.listarClientes();
  }

  @PostMapping()
  public void guardarCliente(@RequestBody ClienteModel cliente) {
    clienteService.guardarCliente(cliente);
  }
}
