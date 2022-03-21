package com.jhorman.desafiocerticom.controllers;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.jhorman.desafiocerticom.dto.ClienteDto;
import com.jhorman.desafiocerticom.models.ClienteModel;
import com.jhorman.desafiocerticom.services.ClienteService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
  
  @Autowired
  ClienteService clienteService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping(path = "/listar")
  public ArrayList<ClienteDto> listarClientes() {
    ArrayList<ClienteModel> clientes = clienteService.listarClientes();
    return clientes.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
  }

  @PostMapping(path = "/guardar")
  public void guardarCliente(@RequestBody ClienteModel cliente) {
    clienteService.guardarCliente(cliente);
  }

  private ClienteDto convertToDto(ClienteModel cliente) {
    ClienteDto clienteDto = modelMapper.map(cliente, ClienteDto.class);
    return clienteDto;
  }
}
