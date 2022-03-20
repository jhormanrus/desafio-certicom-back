package com.jhorman.desafiocerticom.controllers;

import java.util.ArrayList;

import com.jhorman.desafiocerticom.models.ProductoModel;
import com.jhorman.desafiocerticom.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

  @Autowired
  private ProductoService productoService;

  @GetMapping("/listar")
  public ArrayList<ProductoModel> listarProductos() {
    return productoService.listarProductos();
  }

  @PostMapping("/guardar")
  public void guardarProducto(ProductoModel producto) {
    productoService.guardarProducto(producto);
  }

  @DeleteMapping("/eliminar")
  public void eliminarProducto(Long id) {
    productoService.eliminarProducto(id);
  }
  
}
