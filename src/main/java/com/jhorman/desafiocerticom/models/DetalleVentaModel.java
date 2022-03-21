package com.jhorman.desafiocerticom.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_venta")
public class DetalleVentaModel {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(unique=true, nullable=false)
  private Long id;

  @Column(nullable=false)
  private int cantidad;

  @ManyToOne
  @JoinColumn(name="id_venta")
  private VentaModel venta;

  @ManyToOne
  @JoinColumn(name="id_producto")
  private ProductoModel producto;

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

  public VentaModel getVenta() {
    return venta;
  }

  public void setVenta(VentaModel venta) {
    this.venta = venta;
  }

  public ProductoModel getProducto() {
    return producto;
  }

  public void setProducto(ProductoModel producto) {
    this.producto = producto;
  }

}
