--------------------------------------------------------
-- Archivo creado  - sábado-junio-27-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for View VIEW_OFERTA_VUELOS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "BAD115"."VIEW_OFERTA_VUELOS" ("VUELO", "AEROLINEA", "ESCALAS", "ORIGEN", "DESTINO", "HORAATERRIZAJE", "DURACIÓN", "HORADESPEGUE", "CLASE", "PRECIO") AS 
  SELECT
  v.CODIGO AS Vuelo,
  al.NOMBRE_CORTO AS Aerolinea,
  v.TIENE_ESCALA AS Escalas,
  FN_AEROPUERTO_POR_DESTINO(v.ID_ORIGEN) AS Origen,
  FN_AEROPUERTO_POR_DESTINO(V.ID_DESTINO) AS Destino,
  v.HORA_ATERRIZAJE_PROGRAMADA AS HoraAterrizaje,
  FN_DURACION_VUELO(V.HORA_ATERRIZAJE, V.HORA_DESPEGUE) AS Duración,
  v.HORA_DESPEGUE AS HoraDespegue,
  cl.NOMBRE_CLASE AS Clase,
  pr.PRECIO AS Precio

FROM TB_VUELO v
LEFT JOIN TB_AEROLINEA al 
      ON al.ID_AEROLINEA= v.ID_AEROLINEA
LEFT JOIN TB_AVION av     
      ON av.ID_AEROLINEA= al.ID_AEROLINEA
LEFT JOIN TB_CAPACIDAD cp   
      ON cp.ID_AVION = av.id
LEFT JOIN TB_PRECIO pr 
      ON pr.ID_CAPACIDAD = CP.ID_CAPACIDAD
LEFT JOIN TB_CLASE cl 
      ON CL.ID_CLASE = CP.ID_CLASE;
