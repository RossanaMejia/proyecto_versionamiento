package com.rossana.aa2ev01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO con operaciones CRUD para la entidad Usuario.
 */
public class UsuarioDAO {

    public void insertar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (id, nombre, email) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getEmail());
            stmt.executeUpdate();
            System.out.println("Usuario insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    public List<Usuario> consultar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, email FROM usuarios";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre=?, email=? WHERE id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setInt(3, usuario.getId());
            int updated = stmt.executeUpdate();
            if (updated > 0) System.out.println("Usuario actualizado.");
            else System.out.println("No se encontró el usuario con id: " + usuario.getId());
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int deleted = stmt.executeUpdate();
            if (deleted > 0) System.out.println("Usuario eliminado.");
            else System.out.println("No se encontró el usuario con id: " + id);
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
}