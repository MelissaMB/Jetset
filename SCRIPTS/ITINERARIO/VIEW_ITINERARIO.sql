--------------------------------------------------------
-- Archivo creado  - sábado-junio-27-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for View VIEW_ITINERARIO
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "BAD115"."VIEW_ITINERARIO" ("Aerolinea", "IdVuelo", "Vuelo", "Origen", "Destino", "Hora Programada", "Hora Real", "Estado") AS 
  SELECT
	TB_AEROLINEA.NOMBRE_CORTO AS "Aerolinea",
	TB_VUELO.ID_VUELO AS "IdVuelo",
	TB_VUELO.CODIGO AS "Vuelo",
	FN_AEROPUERTO_POR_DESTINO(TB_VUELO.ID_ORIGEN) AS "Origen",
	FN_AEROPUERTO_POR_DESTINO(TB_VUELO.ID_DESTINO) AS "Destino",
	TB_VUELO.HORA_ATERRIZAJE AS "Hora Programada",
	CURRENT_TIMESTAMP AS "Hora Real",
	TB_ESTADO_VUELO.ESTADO_VUELO AS "Estado"
	FROM TB_VUELO
	LEFT JOIN TB_AEROLINEA ON TB_VUELO.ID_AEROLINEA=TB_AEROLINEA.ID_AEROLINEA
	LEFT JOIN TB_DESTINO ON TB_VUELO.ID_DESTINO=TB_DESTINO.ID_DESTINO --AND TB_VUELO.ID_ORIGEN=TB_DESTINO.ID_DESTINO
	LEFT JOIN TB_AEROPUERTO ON TB_DESTINO.ID_AEROPUERTO= TB_AEROPUERTO.ID_AEROPUERTO
	LEFT JOIN TB_ESTADO_VUELO ON TB_VUELO.ID_ESTADO_VUELO= TB_ESTADO_VUELO.ID_ESTADO_VUELO;
