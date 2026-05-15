package org.example.dao;

import org.example.model.Ranking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RankingDAOImpl implements RankingDAO {

    private final Connection connection;

    public RankingDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Ranking ranking) {

        String sql = "INSERT INTO RANKING(id_jugador,puntaje,posicion) VALUES (?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, ranking.getId_jugador());
            stmt.setInt(2, ranking.getPuntaje());
            stmt.setInt(3, ranking.getPosicion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ranking leer(int id) {

        String sql = "SELECT * FROM RANKING WHERE id_ranking=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Ranking(
                        rs.getInt("id_ranking"),
                        rs.getInt("id_jugador"),
                        rs.getInt("puntaje"),
                        rs.getInt("posicion")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void actualizar(Ranking ranking) {

        String sql = "UPDATE RANKING SET id_jugador=?, puntaje=?, posicion=? WHERE id_ranking=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, ranking.getId_jugador());
            stmt.setInt(2, ranking.getPuntaje());
            stmt.setInt(3, ranking.getPosicion());
            stmt.setInt(4, ranking.getId_ranking());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM RANKING WHERE id_ranking=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ranking> listar() {

        List<Ranking> lista = new ArrayList<>();

        String sql = "SELECT * FROM RANKING";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                lista.add(new Ranking(
                        rs.getInt("id_ranking"),
                        rs.getInt("id_jugador"),
                        rs.getInt("puntaje"),
                        rs.getInt("posicion")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}