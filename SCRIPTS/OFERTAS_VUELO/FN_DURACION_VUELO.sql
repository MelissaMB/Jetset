--------------------------------------------------------
-- Archivo creado  - sábado-junio-27-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Function FN_DURACION_VUELO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BAD115"."FN_DURACION_VUELO" 
(P_HORA_ATERRIZAJE IN TIMESTAMP, P_HORA_DESPEGUE IN TIMESTAMP)
RETURN VARCHAR
IS
V_DURACION VARCHAR(250);
BEGIN
  V_DURACION := extract(HOUR FROM P_HORA_ATERRIZAJE - P_HORA_DESPEGUE ) || ':' || extract(MINUTE FROM P_HORA_ATERRIZAJE - P_HORA_DESPEGUE );
  
  RETURN V_DURACION;
END FN_DURACION_VUELO;

/
