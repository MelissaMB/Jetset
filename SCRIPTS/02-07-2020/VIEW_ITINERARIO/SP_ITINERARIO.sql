--------------------------------------------------------
-- Archivo creado  - jueves-julio-02-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure SP_ITINERARIO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BAD115"."SP_ITINERARIO" (pAerolinea VARCHAR2, pOrigen VARCHAR2, pDestino VARCHAR2, pCodigo VARCHAR2, pFecha VARCHAR2)
IS
vIdVuelo		NUMBER(10,0);
vEstado			VARCHAR2(50);
vHoraProgramada	TIMESTAMP(6);
vMensaje1		VARCHAR2(100) := 'Vuelo PROGRAMADO y RETRASADO';
vMensaje2		VARCHAR2(100) := 'Vuelo PROGRAMADO y A TIEMPO';

CURSOR C_ITINERARIO IS
  SELECT id_vuelo, estado_vuelo, hora_aterrizaje
    FROM VIEW_ITINERARIO
   WHERE Aerolinea LIKE pAerolinea
     AND origen    LIKE pOrigen
     AND destino   LIKE pDestino
     AND id_vuelo   LIKE pCodigo
     AND hora_aterrizaje LIKE pFecha;

BEGIN
	OPEN C_ITINERARIO;
	LOOP
		FETCH C_ITINERARIO INTO vIdVuelo, vEstado, vHoraProgramada;
		EXIT WHEN C_ITINERARIO%NOTFOUND;
		IF UPPER(vEstado) = 'PROGRAMADO' THEN
			IF CURRENT_TIMESTAMP >= vHoraProgramada THEN
				DBMS_OUTPUT.put_line(vIdVuelo || ' ' || vHoraProgramada || ' ' || vMensaje1);
				UPDATE TB_VUELO
				   SET ID_ESTADO_VUELO = 1
				 WHERE ID_VUELO = vIdVuelo;
			ELSE
				DBMS_OUTPUT.put_line(vIdVuelo || ' ' || vHoraProgramada || ' ' || vMensaje2);
				UPDATE TB_VUELO
				   SET ID_ESTADO_VUELO = 2
				 WHERE ID_VUELO = vIdVuelo;
			END IF;
		ELSE
			DBMS_OUTPUT.put_line(vIdVuelo || ' ' || vHoraProgramada || ' Vuelo ' || vEstado);
		END IF;
	END LOOP;
	CLOSE C_ITINERARIO;
END;

/
