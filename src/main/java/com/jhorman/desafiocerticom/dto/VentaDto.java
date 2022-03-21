package com.jhorman.desafiocerticom.dto;

import java.util.Date;

public class VentaDto {

  private Long id;
  private Date fecha;
  private ClienteDto cliente;
  private Double total;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Date getFecha() {
    return fecha;
  }
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }
  public ClienteDto getCliente() {
    return cliente;
  }
  public void setCliente(ClienteDto cliente) {
    this.cliente = cliente;
  }
  public Double getTotal() {
    return total;
  }
  public void setTotal(Double total) {
    this.total = total;
  }
  
}
