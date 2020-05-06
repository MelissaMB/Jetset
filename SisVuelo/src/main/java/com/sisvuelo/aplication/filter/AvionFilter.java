package com.sisvuelo.aplication.filter;



public class AvionFilter {

private Integer id;
private String nombre;
private Integer anioFabricacion;
private boolean estado;


public Integer getId() {
  return this.id;
}
public void setId(Integer id) {
  this.id = id;
}
public String getNombre() {
  return this.nombre;
}
public void setNombre(String nombre) {
  this.nombre = nombre;
}
public Integer getAnioFabricacion() {
  return this.anioFabricacion;
}
public void setAnioFabricacion(Integer anioFabricacion) {
  this.anioFabricacion = anioFabricacion;
}
public boolean isEstado() {
  return this.estado;
}
public void setEstado(boolean estado) {
  this.estado = estado;
}



}
