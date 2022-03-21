package com.jhorman.desafiocerticom.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.jhorman.desafiocerticom.dto.DetalleVentaDto;
import com.jhorman.desafiocerticom.dto.VentaDto;
import com.jhorman.desafiocerticom.models.DetalleVentaModel;
import com.jhorman.desafiocerticom.models.VentaModel;
import com.jhorman.desafiocerticom.services.ClienteService;
import com.jhorman.desafiocerticom.services.VentaService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/venta")
public class VentaController {

  @Autowired
  VentaService ventaService;

  @Autowired
  ClienteService clienteService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping(path = "/listar")
  public ArrayList<VentaDto> listarVentas() {
    ArrayList<VentaModel> ventas = ventaService.listarVentas();
    return ventas.stream().map((venta) -> convertVentaToDto(venta)).collect(Collectors.toCollection(ArrayList::new));
  }

  @GetMapping(path = "/listarPorFecha/{fecha}")
  public ArrayList<VentaDto> listarVentasPorFecha(@PathVariable("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
    ArrayList<VentaModel> ventas = ventaService.listarVentasPorFecha(fecha);
    return ventas.stream().map((venta) -> convertVentaToDto(venta)).collect(Collectors.toCollection(ArrayList::new));
  }

  @GetMapping(path = "/detalle/{id}")
  public ArrayList<DetalleVentaDto> detalleVentaPorId(@PathVariable("id") Long id) {
    List<DetalleVentaModel> detallesVenta = ventaService.buscarDetalleVentaPorId(id);
    return detallesVenta.stream().map((detalleVenta) -> convertDetalleVentaToDto(detalleVenta)).collect(Collectors.toCollection(ArrayList::new));
  }

  @PostMapping(path = "/guardar")
  public void guardarVenta(@RequestBody VentaModel venta) {
    ventaService.guardarVenta(venta);
  }
  
  private VentaDto convertVentaToDto(VentaModel venta) {
    VentaDto ventaDto = modelMapper.map(venta, VentaDto.class);
    ventaDto.setTotal(venta.getDetalleVentas().stream().mapToDouble(detalle -> detalle.getCantidad() * detalle.getProducto().getPrecio()).sum());
    return ventaDto;
  }

  private DetalleVentaDto convertDetalleVentaToDto(DetalleVentaModel detalleVenta) {
    DetalleVentaDto detalleVentaDto = modelMapper.map(detalleVenta, DetalleVentaDto.class);
    return detalleVentaDto;
  }
}
