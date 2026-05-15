package org.example.dao;

import org.example.model.Partida;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartidaDAOImpl implements PartidaDAO {

    private final Connection connection;

    public PartidaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Partida partida) {

        String sql = "INSERT INTO PARTIDA(id_jugador,id_categoria,dificultad,puntaje_total,aciertos,total_preguntas) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, partida.getId_jugador());
            stmt.setInt(2, partida.getId_categoria());
            stmt.setString(3, partida.getDificultad());
            stmt.setInt(4, partida.getPuntaje_total());
            stmt.setInt(5, partida.getAciertos());
            stmt.setInt(6, partida.getTotal_preguntas());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Partida leer(int id) {

        String sql = "SELECT * FROM PARTIDA WHERE id_partida=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Partida(
                        rs.getInt("id_partida"),
                        rs.getInt("id_jugador"),
                        rs.getInt("id_categoria"),
                        rs.getString("dificultad"),
                        rs.getInt("puntaje_total"),
                        rs.getInt("aciertos"),
                        rs.getInt("total_preguntas")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void actualizar(Partida partida) {

        String sql = "UPDATE PARTIDA SET id_jugador=?, id_categoria=?, dificultad=?, puntaje_total=?, aciertos=?, total_preguntas=? WHERE id_partida=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, partida.getId_jugador());
            stmt.setInt(2, partida.getId_categoria());
            stmt.setString(3, partida.getDificultad());
            stmt.setInt(4, partida.getPuntaje_total());
            stmt.setInt(5, partida.getAciertos());
            stmt.setInt(6, partida.getTotal_preguntas());
            stmt.setInt(7, partida.getId_partida());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM PARTIDA WHERE id_partida=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Partida> listar() {

        List<Partida> lista = new ArrayList<>();

        String sql = "SELECT * FROM PARTIDA";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                lista.add(new Partida(
                        rs.getInt("id_partida"),
                        rs.getInt("id_jugador"),
                        rs.getInt("id_categoria"),
                        rs.getString("dificultad"),
                        rs.getInt("puntaje_total"),
                        rs.getInt("aciertos"),
                        rs.getInt("total_preguntas")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}