package com.rossana.aa2ev01;

/**
 * Clase de prueba para ejecutar las operaciones CRUD con JDBC.
 * Ejecuta este main desde tu IDE.
 */
public class MainApp {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        // INSERT
        Usuario u1 = new Usuario(1, "Rossana Mejia", "rossana@example.com");
        dao.insertar(u1);

        // SELECT
        System.out.println("Usuarios en BD:");
        dao.consultar().forEach(System.out::println);

        // UPDATE
        u1.setNombre("Rossana M. Chantre");
        u1.setEmail("rossana.chantre@example.com");
        dao.actualizar(u1);

        // SELECT nuevamente
        System.out.println("Después de actualizar:");
        dao.consultar().forEach(System.out::println);

        // DELETE
        dao.eliminar(1);

        // SELECT final
        System.out.println("Después de eliminar:");
        dao.consultar().forEach(System.out::println);
    }
}