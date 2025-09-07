# AA2_EV01 - Módulo JDBC (Java + MySQL)

## Requisitos
- JDK 11+ (recomendado JDK 17)
- MySQL 8.x en local
- Conector JDBC de MySQL (mysql-connector-j-8.x.x.jar)
- IDE (IntelliJ / NetBeans / Eclipse)

## Pasos rápidos
1. Importar el proyecto en el IDE.
2. Ejecutar `db.sql` en MySQL para crear la BD y la tabla.
3. En `ConexionBD.java` ajustar URL, USER y PASSWORD.
4. Agregar el `mysql-connector-j-8.x.x.jar` al classpath del proyecto.
5. Ejecutar `MainApp` y validar las operaciones CRUD en la consola.
6. Versionar el proyecto con Git y súbelo a GitHub.

## Notas
- La tabla usada es `usuarios` con campos `id`, `nombre`, `email`.
- El paquete base es `com.rossana.aa2ev01`.
