package com.jhorman.desafiocerticom.dto;

public class DetalleVentaDto {

  private Long id;
  private int cantidad;
  private ProductoDto producto;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public int getCantidad() {
    return cantidad;
  }
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
  public ProductoDto getProducto() {
    return producto;
  }
  public void setProducto(ProductoDto producto) {
    this.producto = producto;
  }
  
}
