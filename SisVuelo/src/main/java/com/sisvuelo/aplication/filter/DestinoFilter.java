package com.sisvuelo.aplication.filter;

import com.sisvuelo.aplication.model.Aerolinea;
import com.sisvuelo.aplication.model.Aeropuerto;


public class DestinoFilter {

private Integer id;
private Aerolinea aerolinea;
private Aeropuerto aeropuerto;


public Integer getId() {
  return this.id;
}
public void setId(Integer id) {
  this.id = id;
}
public Aerolinea getAerolinea() {
  return this.aerolinea;
}
public void setAerolinea(Aerolinea aerolinea) {
  this.aerolinea = aerolinea;
}
public Aeropuerto getAeropuerto() {
  return this.aeropuerto;
}
public void setAeropuerto(Aeropuerto aeropuerto) {
  this.aeropuerto = aeropuerto;
}



}
