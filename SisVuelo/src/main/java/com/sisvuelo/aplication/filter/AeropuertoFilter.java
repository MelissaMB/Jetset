package com.sisvuelo.aplication.filter;

import com.sisvuelo.aplication.model.Ciudad;


public class AeropuertoFilter {

private Integer id;
private Ciudad ciudad;
private String codigo;
private String nombre;
private String telefono;
private String Responsable;
private Integer numeroBahias;
private Integer numeroHangares;
private boolean estado;


public Integer getId() {
  return this.id;
}
public void setId(Integer id) {
  this.id = id;
}
public Ciudad getCiudad() {
  return this.ciudad;
}
public void setCiudad(Ciudad ciudad) {
  this.ciudad = ciudad;
}
public String getCodigo() {
  return this.codigo;
}
public void setCodigo(String codigo) {
  this.codigo = codigo;
}
public String getNombre() {
  return this.nombre;
}
public void setNombre(String nombre) {
  this.nombre = nombre;
}
public String getTelefono() {
  return this.telefono;
}
public void setTelefono(String telefono) {
  this.telefono = telefono;
}
public String getResponsable() {
  return this.Responsable;
}
public void setResponsable(String Responsable) {
  this.Responsable = Responsable;
}
public Integer getNumeroBahias() {
  return this.numeroBahias;
}
public void setNumeroBahias(Integer numeroBahias) {
  this.numeroBahias = numeroBahias;
}
public Integer getNumeroHangares() {
  return this.numeroHangares;
}
public void setNumeroHangares(Integer numeroHangares) {
  this.numeroHangares = numeroHangares;
}
public boolean isEstado() {
  return this.estado;
}
public void setEstado(boolean estado) {
  this.estado = estado;
}



}
