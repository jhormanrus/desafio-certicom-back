package com.jhorman.desafiocerticom.services;

import java.util.ArrayList;

import com.jhorman.desafiocerticom.models.ProductoModel;
import com.jhorman.desafiocerticom.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

  @Autowired
  private ProductoRepository productoRepository;

  public void guardarProducto(ProductoModel producto) {
    productoRepository.save(producto);
  }
  
  public ArrayList<ProductoModel> listarProductos() {
    return (ArrayList<ProductoModel>) productoRepository.findAll();
  }
  
  public void eliminarProducto(Long id) {
    productoRepository.deleteById(id);
  }
  
}
