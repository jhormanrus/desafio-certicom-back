package com.jhorman.desafiocerticom.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name="venta")
public class VentaModel {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(unique=true, nullable=false)
  private Long id;

  @Column(nullable=false)
  private Date fecha;

  @OneToMany(mappedBy="venta")
  private List<DetalleVentaModel> detalleVentas;

  @ManyToOne
  @JoinColumn(name="id_cliente")
  private ClienteModel cliente;

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

  public List<DetalleVentaModel> getDetalleVentas() {
    return detalleVentas;
  }

  public void setDetalleVentas(List<DetalleVentaModel> detalleVentas) {
    this.detalleVentas = detalleVentas;
  }

  public ClienteModel getCliente() {
    return cliente;
  }

  public void setCliente(ClienteModel cliente) {
    this.cliente = cliente;
  }

}
