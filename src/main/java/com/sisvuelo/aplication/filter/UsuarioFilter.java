package com.sisvuelo.aplication.filter;

import java.util.Date;
import com.sisvuelo.aplication.model.Rol;


public class UsuarioFilter {

private Integer id;
private String email;
private String password;
private Date fechaCreacion;
private Rol rol;


public Integer getId() {
  return this.id;
}
public void setId(Integer id) {
  this.id = id;
}
public String getEmail() {
  return this.email;
}
public void setEmail(String email) {
  this.email = email;
}
public String getPassword() {
  return this.password;
}
public void setPassword(String password) {
  this.password = password;
}
public Date getFechaCreacion() {
  return this.fechaCreacion;
}
public void setFechaCreacion(Date fechaCreacion) {
  this.fechaCreacion = fechaCreacion;
}
public Rol getRol() {
  return this.rol;
}
public void setRol(Rol rol) {
  this.rol = rol;
}



}
