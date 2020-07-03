--------------------------------------------------------
-- Archivo creado  - jueves-julio-02-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Function FN_AEROPUERTO_POR_DESTINO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BAD115"."FN_AEROPUERTO_POR_DESTINO" 
(P_ID_DESTINO IN INT)
RETURN VARCHAR
IS
  V_NOMBRE_AEROPUERTO VARCHAR(250);
BEGIN
  SELECT NOMBRE_AEROPUERTO
    INTO V_NOMBRE_AEROPUERTO
    FROM TB_AEROPUERTO
   WHERE ID_AEROPUERTO = (SELECT ID_AEROPUERTO FROM TB_DESTINO WHERE ID_DESTINO = P_ID_DESTINO);
  RETURN V_NOMBRE_AEROPUERTO;
END;

/
