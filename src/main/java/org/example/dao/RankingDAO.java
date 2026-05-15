package org.example.dao;

import org.example.model.Ranking;

import java.util.List;

public interface RankingDAO {

    void crear(Ranking ranking);

    Ranking leer(int id);

    void actualizar(Ranking ranking);

    void eliminar(int id);

    List<Ranking> listar();
}