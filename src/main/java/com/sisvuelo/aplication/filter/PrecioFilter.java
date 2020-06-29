package com.sisvuelo.aplication.filter;

import com.sisvuelo.aplication.model.Clase;
import com.sisvuelo.aplication.model.Vuelo;


public class PrecioFilter {

private Integer id;
private Clase clase;
private Vuelo vuelo;
private float precio;


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
public Vuelo getVuelo() {
  return this.vuelo;
}
public void setVuelo(Vuelo vuelo) {
  this.vuelo = vuelo;
}
public float getPrecio() {
  return this.precio;
}
public void setPrecio(float precio) {
  this.precio = precio;
}



}
