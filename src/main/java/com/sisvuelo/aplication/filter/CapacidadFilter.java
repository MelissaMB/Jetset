package com.sisvuelo.aplication.filter;

import com.sisvuelo.aplication.model.Clase;
import com.sisvuelo.aplication.model.Avion;


public class CapacidadFilter {

private Integer id;
private Clase clase;
private Avion avion;
private Integer cantidad;


public Integer getId() {
  return this.id;
}
public void setId(Integer id) {
  this.id = id;
}
public Clase getClase() {
  return this.clase;
}
public void setClase(Clase clase) {
  this.clase = clase;
}
public Avion getAvion() {
  return this.avion;
}
public void setAvion(Avion avion) {
  this.avion = avion;
}
public Integer getCantidad() {
  return this.cantidad;
}
public void setCantidad(Integer cantidad) {
  this.cantidad = cantidad;
}



}
