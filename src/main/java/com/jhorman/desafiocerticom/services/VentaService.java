package com.jhorman.desafiocerticom.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jhorman.desafiocerticom.models.DetalleVentaModel;
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

  public List<DetalleVentaModel> buscarDetalleVentaPorId(Long id) {
    return ventaRepository.findById(id).get().getDetalleVentas();
  }

  public ArrayList<VentaModel> listarVentasPorFecha(Date fecha) {
    return ventaRepository.findByFecha(fecha);
  }
  
}
