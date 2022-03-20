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

  @OneToMany(mappedBy="idVenta")
  private List<DetalleVentaModel> detalleVentas;

  @ManyToOne
  @JoinColumn(name="id_cliente")
  private ClienteModel idCliente;

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

  public ClienteModel getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(ClienteModel idCliente) {
    this.idCliente = idCliente;
  }

}
