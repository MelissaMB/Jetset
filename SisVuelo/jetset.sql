--------------------------------------------------------
-- Archivo creado  - lunes-mayo-04-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence NATIVE
--------------------------------------------------------

   CREATE SEQUENCE  "BAD115"."NATIVE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table AVION
--------------------------------------------------------

  CREATE TABLE "BAD115"."AVION" 
   (	"ID" NUMBER(10,0), 
	"ANIO_FABRICACION" NUMBER(10,0), 
	"ESTADO" NUMBER(1,0), 
	"NOMBRE" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ROL
--------------------------------------------------------

  CREATE TABLE "BAD115"."ROL" 
   (	"ID" NUMBER(10,0), 
	"DESCRIPCION" VARCHAR2(255 CHAR), 
	"NOMBRE" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "BAD115"."USUARIO" 
   (	"ID" NUMBER(10,0), 
	"EMAIL" VARCHAR2(255 CHAR), 
	"FECHA_CREACION" TIMESTAMP (6), 
	"PASSWORD" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into BAD115.AVION
SET DEFINE OFF;
Insert into BAD115.AVION (ID,ANIO_FABRICACION,ESTADO,NOMBRE) values (1,2009,1,'BOING 776');
Insert into BAD115.AVION (ID,ANIO_FABRICACION,ESTADO,NOMBRE) values (2,2009,1,'BOING 776');
Insert into BAD115.AVION (ID,ANIO_FABRICACION,ESTADO,NOMBRE) values (3,2009,1,'BOING 776');
Insert into BAD115.AVION (ID,ANIO_FABRICACION,ESTADO,NOMBRE) values (4,2009,1,'BOING 776');
Insert into BAD115.AVION (ID,ANIO_FABRICACION,ESTADO,NOMBRE) values (5,2013,1,'BOING 77632');
REM INSERTING into BAD115.ROL
SET DEFINE OFF;
Insert into BAD115.ROL (ID,DESCRIPCION,NOMBRE) values (6,'Administrar funciones del sistema','Administrador');
Insert into BAD115.ROL (ID,DESCRIPCION,NOMBRE) values (7,'Administrador de base de datos','DBA');
REM INSERTING into BAD115.USUARIO
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C007660
--------------------------------------------------------

  CREATE UNIQUE INDEX "BAD115"."SYS_C007660" ON "BAD115"."AVION" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007662
--------------------------------------------------------

  CREATE UNIQUE INDEX "BAD115"."SYS_C007662" ON "BAD115"."ROL" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007664
--------------------------------------------------------

  CREATE UNIQUE INDEX "BAD115"."SYS_C007664" ON "BAD115"."USUARIO" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table AVION
--------------------------------------------------------

  ALTER TABLE "BAD115"."AVION" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BAD115"."AVION" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ROL
--------------------------------------------------------

  ALTER TABLE "BAD115"."ROL" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BAD115"."ROL" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "BAD115"."USUARIO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BAD115"."USUARIO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "BAD115"."USUARIO" ADD CONSTRAINT "FK7W8613OSJS8YTJGOTF6TWO7A2" FOREIGN KEY ("ID")
	  REFERENCES "BAD115"."ROL" ("ID") ENABLE;