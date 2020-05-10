# Configuración de JetSet  #
***
## HERRAMIENTAS  ##
1. JDK 1.8
2. Oracle 11g Express 11.2.0.2.0
3. SpringTools 4

## PASOS  ##
1. Clonar proyecto desde github y crear rama local desarrollo **seguir la wiki**: *https://github.com/MelissaMB/Jetset/wiki/Flujo-de-trabajo-de-GIT-para-proyecto-%22Sistema-de-Vuelos:-JETSET%22*
2. Descargar dependencias de Maven para les descargue su repositorio local de dependencias
3. Ejecutar Script de Creacion de Usuario "CREATEUSER_ROLES_GRANT_TO_BAD115.sql"
4. Ejecutar Script de Creacion de Base de Datos "jetset.sql", que se encuentra en el repositorio
(les creara el esquema de la base de datos).

   Usuario:BAD115
   
   Pass:grupo02
   
5. Incluir odbc de Oracle en sus repositorio maven local (ojdbc6)
   a añaden en sus librerias externas de proyecto. Para la conexión a la base de datos
6. Construir proyecto y correr.


Nota: el proyecto corre en el puerto 8081 (si desean modificarlo pueden hacerlo en el applition.properties)
