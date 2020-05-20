package com.sisvuelo.aplication.filter;

import com.sisvuelo.aplication.model.Marca;


public class ModeloFilter {

private Integer id;
private Marca marca;
private String nombre;


public Integer getId() {
  return this.id;
}
public void setId(Integer id) {
  this.id = id;
}
public Marca getMarca() {
  return this.marca;
}
public void setMarca(Marca marca) {
  this.marca = marca;
}
public String getNombre() {
  return this.nombre;
}
public void setNombre(String nombre) {
  this.nombre = nombre;
}



}
