package com.jhorman.desafiocerticom.services;

import java.util.ArrayList;
import java.util.Date;

import com.jhorman.desafiocerticom.models.VentaModel;
import com.jhorman.desafiocerticom.repositories.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {

  @Autowired
  private VentaRepository ventaRepository;

  public void guardarVenta(VentaModel venta) {
    ventaRepository.save(venta);
  }

  public ArrayList<VentaModel> listarVentas() {
    return (ArrayList<VentaModel>) ventaRepository.findAll();
  }

  public VentaModel buscarVentaPorId(Long id) {
    return ventaRepository.findById(id).get();
  }

  public ArrayList<VentaModel> listarVentasPorFecha(Date fecha) {
    return ventaRepository.findByFecha(fecha);
  }
  
}
