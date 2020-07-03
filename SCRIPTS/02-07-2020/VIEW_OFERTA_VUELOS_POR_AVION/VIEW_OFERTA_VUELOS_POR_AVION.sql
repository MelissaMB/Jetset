--------------------------------------------------------
-- Archivo creado  - jueves-julio-02-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for View VIEW_OFERTA_VUELOS_POR_AVION
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "BAD115"."VIEW_OFERTA_VUELOS_POR_AVION" ("ID_VUELO", "VUELO", "ID_AEROLINEA", "AEROLINEA", "ESCALAS", "ORIGEN", "DESTINO", "HORA_ATERRIZAJE", "DURACION", "HORA_DESPEGUE", "AVION", "CAPACIDAD", "RESERVAS", "DISPONIBLES") AS 
  SELECT
  V.ID_VUELO AS Id_Vuelo,
  V.CODIGO AS Vuelo,
  V.ID_AEROLINEA AS Id_Aerolinea,
  AL.NOMBRE_CORTO AS Aerolinea,
  CASE V.TIENE_ESCALA WHEN 0 THEN 'No' WHEN 1 THEN 'Sí' END AS Escalas,
  FN_AEROPUERTO_POR_DESTINO(v.ID_ORIGEN) AS Origen,
  FN_AEROPUERTO_POR_DESTINO(V.ID_DESTINO) AS Destino,
  V.HORA_ATERRIZAJE AS Hora_Aterrizaje,
  FN_DURACION_VUELO(V.HORA_ATERRIZAJE, V.HORA_DESPEGUE) AS Duracion,
  V.HORA_DESPEGUE AS Hora_Despegue,
  AV.ID AS Avion,
  FN_CAPACIDAD_POR_AVION(V.ID) AS Capacidad,
  FN_RESERVAS_POR_VUELO(V.ID_VUELO) AS Reservas,
  (FN_CAPACIDAD_POR_AVION(V.ID) - FN_RESERVAS_POR_VUELO(V.ID_VUELO)) Disponibles

FROM TB_VUELO V
LEFT JOIN TB_AEROLINEA AL
      ON AL.ID_AEROLINEA= V.ID_AEROLINEA
LEFT JOIN TB_AVION AV     
      ON AV.ID= V.ID;
