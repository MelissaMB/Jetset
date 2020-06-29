--------------------------------------------------------
-- Archivo creado  - domingo-junio-28-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Function FN_RESERVAS_POR_VUELO_Y_CLASE
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BAD115"."FN_RESERVAS_POR_VUELO_Y_CLASE" 
(P_ID_VUELO IN NUMBER, P_ID_CLASE IN NUMBER)
RETURN INT
IS
V_RESERVAS INT;
BEGIN
  SELECT SUM(CANTIDAD)
    INTO V_RESERVAS
    FROM TB_RESERVA
   WHERE ID_VUELO = P_ID_VUELO
     AND ID_CLASE = P_ID_CLASE
     AND ID_ESTATUS_RESERVA = 1;
  RETURN V_RESERVAS;
END;

/
