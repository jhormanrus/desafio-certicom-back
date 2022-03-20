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

  @OneToMany(mappedBy="idProducto")
  private List<DetalleVentaModel> detalleVentas;

}
