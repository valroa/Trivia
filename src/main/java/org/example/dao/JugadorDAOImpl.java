package org.example.dao;

import org.example.model.Jugador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAOImpl implements JugadorDAO {

    private final Connection connection;

    public JugadorDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Jugador jugador) {

        String sql = "INSERT INTO JUGADOR(nombre,email,puntaje_total) VALUES (?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, jugador.getNombre());
            stmt.setString(2, jugador.getEmail());
            stmt.setInt(3, jugador.getPuntaje_total());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Jugador leer(int id) {

        String sql = "SELECT * FROM JUGADOR WHERE id_jugador = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Jugador(
                        rs.getInt("id_jugador"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getInt("puntaje_total")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void actualizar(Jugador jugador) {

        String sql = "UPDATE JUGADOR SET nombre=?, email=?, puntaje_total=? WHERE id_jugador=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, jugador.getNombre());
            stmt.setString(2, jugador.getEmail());
            stmt.setInt(3, jugador.getPuntaje_total());
            stmt.setInt(4, jugador.getId_jugador());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM JUGADOR WHERE id_jugador=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Jugador> listar() {

        List<Jugador> lista = new ArrayList<>();

        String sql = "SELECT * FROM JUGADOR";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                lista.add(new Jugador(
                        rs.getInt("id_jugador"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getInt("puntaje_total")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}