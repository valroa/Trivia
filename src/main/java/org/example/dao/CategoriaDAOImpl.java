package org.example.dao;

import org.example.model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {

    private final Connection connection;

    public CategoriaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Categoria categoria) {

        String sql = "INSERT INTO CATEGORIA(nombre, descripcion, color) VALUES (?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNombre());
            stmt.setString(2, categoria.getDescripcion());
            stmt.setString(3, categoria.getColor());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Categoria leer(int id) {

        String sql = "SELECT * FROM CATEGORIA WHERE id_categoria = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("color")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void actualizar(Categoria categoria) {

        String sql = "UPDATE CATEGORIA SET nombre=?, descripcion=?, color=? WHERE id_categoria=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNombre());
            stmt.setString(2, categoria.getDescripcion());
            stmt.setString(3, categoria.getColor());
            stmt.setInt(4, categoria.getId_categoria());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM CATEGORIA WHERE id_categoria=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Categoria> listar() {

        List<Categoria> lista = new ArrayList<>();

        String sql = "SELECT * FROM CATEGORIA";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                lista.add(new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("color")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
