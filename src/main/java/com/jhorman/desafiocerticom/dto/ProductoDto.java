package com.jhorman.desafiocerticom.dto;

public class ProductoDto {

  private Long id;
  private String nombre;
  private Double precio;
  private int estado;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public Double getPrecio() {
    return precio;
  }
  public void setPrecio(Double precio) {
    this.precio = precio;
  }
  public int getEstado() {
    return estado;
  }
  public void setEstado(int estado) {
    this.estado = estado;
  }
  
}
