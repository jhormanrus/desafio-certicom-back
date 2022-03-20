package com.jhorman.desafiocerticom.controllers;

import java.util.ArrayList;
import java.util.Date;

import com.jhorman.desafiocerticom.models.VentaModel;
import com.jhorman.desafiocerticom.services.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venta")
public class VentaController {

  @Autowired
  VentaService ventaService;

  @GetMapping(path = "/listar")
  public ArrayList<VentaModel> listarVentas() {
    return ventaService.listarVentas();
  }

  @GetMapping(path = "/listarPorFecha")
  public ArrayList<VentaModel> listarVentasPorFecha(Date fecha) {
    return ventaService.listarVentasPorFecha(fecha);
  }

  @GetMapping(path = "/buscarPorId")
  public VentaModel buscarVentaPorId(Long id) {
    return ventaService.buscarVentaPorId(id);
  }

  @PostMapping(path = "/guardar")
  public void guardarVenta(VentaModel venta) {
    ventaService.guardarVenta(venta);
  }
  
}
