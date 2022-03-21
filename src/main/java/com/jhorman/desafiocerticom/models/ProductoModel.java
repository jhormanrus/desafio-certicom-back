package com.jhorman.desafiocerticom.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class ProductoModel {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(unique=true, nullable=false)
  private Long id;

  @Column(nullable=false)
  private String nombre;

  @Column(nullable=false)
  private Double precio;

  @Column(columnDefinition = "tinyint default 1", nullable=false)
  private int estado;

  @OneToMany(mappedBy="producto")
  private List<DetalleVentaModel> detalleVentas;

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

  public List<DetalleVentaModel> getDetalleVentas() {
    return detalleVentas;
  }

  public void setDetalleVentas(List<DetalleVentaModel> detalleVentas) {
    this.detalleVentas = detalleVentas;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

}
