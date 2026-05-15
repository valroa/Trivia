package org.example.dao;

import org.example.model.Respuesta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RespuestaDAOImpl implements RespuestaDAO {

    private final Connection connection;

    public RespuestaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Respuesta respuesta) {

        String sql = "INSERT INTO RESPUESTA(id_partida,id_pregunta,respuesta_jugador,es_correcta,tiempo_respuesta) VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, respuesta.getId_partida());
            stmt.setInt(2, respuesta.getId_pregunta());
            stmt.setString(3, respuesta.getRespuesta_jugador());
            stmt.setBoolean(4, respuesta.isEs_correcta());
            stmt.setInt(5, respuesta.getTiempo_respuesta());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Respuesta leer(int id) {

        String sql = "SELECT * FROM RESPUESTA WHERE id_respuesta=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Respuesta(
                        rs.getInt("id_respuesta"),
                        rs.getInt("id_partida"),
                        rs.getInt("id_pregunta"),
                        rs.getString("respuesta_jugador"),
                        rs.getBoolean("es_correcta"),
                        rs.getInt("tiempo_respuesta")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void actualizar(Respuesta respuesta) {

        String sql = "UPDATE RESPUESTA SET id_partida=?, id_pregunta=?, respuesta_jugador=?, es_correcta=?, tiempo_respuesta=? WHERE id_respuesta=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, respuesta.getId_partida());
            stmt.setInt(2, respuesta.getId_pregunta());
            stmt.setString(3, respuesta.getRespuesta_jugador());
            stmt.setBoolean(4, respuesta.isEs_correcta());
            stmt.setInt(5, respuesta.getTiempo_respuesta());
            stmt.setInt(6, respuesta.getId_respuesta());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM RESPUESTA WHERE id_respuesta=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Respuesta> listar() {

        List<Respuesta> lista = new ArrayList<>();

        String sql = "SELECT * FROM RESPUESTA";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                lista.add(new Respuesta(
                        rs.getInt("id_respuesta"),
                        rs.getInt("id_partida"),
                        rs.getInt("id_pregunta"),
                        rs.getString("respuesta_jugador"),
                        rs.getBoolean("es_correcta"),
                        rs.getInt("tiempo_respuesta")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
