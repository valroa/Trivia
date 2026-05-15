package org.example.dao;

import org.example.model.Respuesta;

import java.util.List;

public interface RespuestaDAO {

    void crear(Respuesta respuesta);

    Respuesta leer(int id);

    void actualizar(Respuesta respuesta);

    void eliminar(int id);

    List<Respuesta> listar();
}
