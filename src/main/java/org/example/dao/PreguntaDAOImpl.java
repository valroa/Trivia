package org.example.dao;

import org.example.model.Pregunta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreguntaDAOImpl implements PreguntaDAO {

    private final Connection connection;

    public PreguntaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Pregunta pregunta) {

        String sql = "INSERT INTO PREGUNTA(id_categoria,texto_pregunta,opcion_a,opcion_b,opcion_c,opcion_d,respuesta_correcta,dificultad) VALUES (?,?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, pregunta.getId_categoria());
            stmt.setString(2, pregunta.getTexto_pregunta());
            stmt.setString(3, pregunta.getOpcion_a());
            stmt.setString(4, pregunta.getOpcion_b());
            stmt.setString(5, pregunta.getOpcion_c());
            stmt.setString(6, pregunta.getOpcion_d());
            stmt.setString(7, pregunta.getRespuesta_correcta());
            stmt.setString(8, pregunta.getDificultad());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pregunta leer(int id) {

        String sql = "SELECT * FROM PREGUNTA WHERE id_pregunta=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Pregunta(
                        rs.getInt("id_pregunta"),
                        rs.getInt("id_categoria"),
                        rs.getString("texto_pregunta"),
                        rs.getString("opcion_a"),
                        rs.getString("opcion_b"),
                        rs.getString("opcion_c"),
                        rs.getString("opcion_d"),
                        rs.getString("respuesta_correcta"),
                        rs.getString("dificultad")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void actualizar(Pregunta pregunta) {

        String sql = "UPDATE PREGUNTA SET id_categoria=?, texto_pregunta=?, opcion_a=?, opcion_b=?, opcion_c=?, opcion_d=?, respuesta_correcta=?, dificultad=? WHERE id_pregunta=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, pregunta.getId_categoria());
            stmt.setString(2, pregunta.getTexto_pregunta());
            stmt.setString(3, pregunta.getOpcion_a());
            stmt.setString(4, pregunta.getOpcion_b());
            stmt.setString(5, pregunta.getOpcion_c());
            stmt.setString(6, pregunta.getOpcion_d());
            stmt.setString(7, pregunta.getRespuesta_correcta());
            stmt.setString(8, pregunta.getDificultad());
            stmt.setInt(9, pregunta.getId_pregunta());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM PREGUNTA WHERE id_pregunta=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pregunta> listar() {

        List<Pregunta> lista = new ArrayList<>();

        String sql = "SELECT * FROM PREGUNTA";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                lista.add(new Pregunta(
                        rs.getInt("id_pregunta"),
                        rs.getInt("id_categoria"),
                        rs.getString("texto_pregunta"),
                        rs.getString("opcion_a"),
                        rs.getString("opcion_b"),
                        rs.getString("opcion_c"),
                        rs.getString("opcion_d"),
                        rs.getString("respuesta_correcta"),
                        rs.getString("dificultad")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
