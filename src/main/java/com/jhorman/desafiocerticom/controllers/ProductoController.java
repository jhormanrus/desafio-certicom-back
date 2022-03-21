package com.jhorman.desafiocerticom.controllers;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.jhorman.desafiocerticom.dto.ProductoDto;
import com.jhorman.desafiocerticom.models.ProductoModel;
import com.jhorman.desafiocerticom.services.ProductoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/producto")
public class ProductoController {

  @Autowired
  private ProductoService productoService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping("/listar")
  public ArrayList<ProductoDto> listarProductos() {
    ArrayList<ProductoModel> productos = productoService.listarProductos();
    return productos.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
  }

  @PostMapping("/guardar")
  public void guardarProducto(@RequestBody ProductoModel producto) {
    productoService.guardarProducto(producto);
  }

  @DeleteMapping("/eliminar/{id}")
  public void eliminarProducto(@PathVariable("id") Long id) {
    productoService.eliminarProducto(id);
  }
  
  private ProductoDto convertToDto(ProductoModel producto) {
    ProductoDto productoDto = modelMapper.map(producto, ProductoDto.class);
    return productoDto;
  }
}
