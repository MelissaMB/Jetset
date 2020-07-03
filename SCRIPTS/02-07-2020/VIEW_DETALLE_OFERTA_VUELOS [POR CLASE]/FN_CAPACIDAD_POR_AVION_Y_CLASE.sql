--------------------------------------------------------
-- Archivo creado  - jueves-julio-02-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Function FN_CAPACIDAD_POR_AVION_Y_CLASE
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BAD115"."FN_CAPACIDAD_POR_AVION_Y_CLASE" 
(P_ID_AVION IN NUMBER, P_ID_CLASE IN NUMBER)
RETURN INT
IS
V_CAPACIDAD NUMBER(10,0);
BEGIN
  SELECT CP.CANTIDAD
    INTO V_CAPACIDAD
    FROM TB_AVION A
    LEFT JOIN TB_CAPACIDAD CP
         ON A.ID = CP.ID_AVION
   WHERE A.ID = P_ID_AVION
     AND CP.ID_CLASE = P_ID_CLASE;
  RETURN V_CAPACIDAD;
END;

/
