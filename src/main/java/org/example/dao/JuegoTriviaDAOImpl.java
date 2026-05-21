package org.example.dao;

import org.example.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JuegoTriviaDAOImpl implements JuegoTriviaDAO {

    private final JugadorDAO jugadorDAO;
    private final CategoriaDAO categoriaDAO;
    private final PreguntaDAO preguntaDAO;
    private final PartidaDAO partidaDAO;
    private final RespuestaDAO respuestaDAO;
    private final RankingDAO rankingDAO;
    private final Scanner scanner;

    private static final int[] PUNTAJES = {100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000};

    public JuegoTriviaDAOImpl(JugadorDAO jugadorDAO, CategoriaDAO categoriaDAO, PreguntaDAO preguntaDAO, PartidaDAO partidaDAO, RespuestaDAO respuestaDAO, RankingDAO rankingDAO, Scanner scanner) {
        this.jugadorDAO = jugadorDAO;
        this.categoriaDAO = categoriaDAO;
        this.preguntaDAO = preguntaDAO;
        this.partidaDAO = partidaDAO;
        this.respuestaDAO = respuestaDAO;
        this.rankingDAO = rankingDAO;
        this.scanner = scanner;
    }

    @Override
    public void iniciarJuego() {

        System.out.print("Ingrese su ID de jugador: ");
        int idJugador = scanner.nextInt();
        scanner.nextLine();

        Jugador jugador = jugadorDAO.leer(idJugador);

        if (jugador == null) {
            System.out.println("Jugador no encontrado.");
            return;
        }

        System.out.println("Bienvenido, " + jugador.getNombre() + "!");

        List<Categoria> categorias = categoriaDAO.listar();

        if (categorias.isEmpty()) {
            System.out.println("No hay categorias disponibles.");
            return;
        }

        System.out.println("    CATEGORIAS    ");

        for (Categoria c : categorias) {
            System.out.println(c.getId_categoria() + ". " + c.getNombre());
        }

        System.out.print("Seleccione una categoria: ");
        int idCategoria = scanner.nextInt();
        scanner.nextLine();

        System.out.println("    DIFICULTAD    ");
        System.out.println("1. facil");
        System.out.println("2. medio");
        System.out.println("3. dificil");
        System.out.print("Seleccione dificultad: ");
        int opDif = scanner.nextInt();
        scanner.nextLine();

        String dificultad;

        switch (opDif) {

            case 1:
                dificultad = "Facil";
                break;

            case 2:
                dificultad = "Medio";
                break;

            case 3:
                dificultad = "Dificil";
                break;

            default:
                dificultad = "Facil";
        }

        List<Pregunta> todasPreguntas = preguntaDAO.listar();
        List<Pregunta> preguntas = new ArrayList<>();

        for (Pregunta p : todasPreguntas) {

            if (p.getId_categoria() == idCategoria && p.getDificultad().equalsIgnoreCase(dificultad)) {
                preguntas.add(p);
            }
        }

        if (preguntas.isEmpty()) {
            System.out.println("No hay preguntas para esa categoria y dificultad.");
            return;
        }

        Collections.shuffle(preguntas);

        if (preguntas.size() > 10) {
            preguntas = preguntas.subList(0, 10);
        }

        int puntajeTotal = 0;
        int aciertos = 0;
        int totalPreguntas = preguntas.size();
        long tiempoInicio = System.currentTimeMillis();

        // Lista temporal para guardar respuestas despues de crear la partida
        List<Respuesta> respuestasTemp = new ArrayList<>();

        for (int i = 0; i < preguntas.size(); i++) {

            Pregunta pregunta = preguntas.get(i);
            int puntajePregunta = PUNTAJES[Math.min(i, PUNTAJES.length - 1)];

            System.out.println("Pregunta " + (i + 1) + " de " + totalPreguntas + " | Vale: $" + puntajePregunta);
            System.out.println(pregunta.getTexto_pregunta());
            System.out.println("A. " + pregunta.getOpcion_a());
            System.out.println("B. " + pregunta.getOpcion_b());
            System.out.println("C. " + pregunta.getOpcion_c());
            System.out.println("D. " + pregunta.getOpcion_d());
            System.out.print("Tu respuesta (A/B/C/D): ");

            long tiempoRespuestaInicio = System.currentTimeMillis();
            String respuestaJugador = scanner.nextLine().trim().toUpperCase();
            int tiempoRespuesta = (int) ((System.currentTimeMillis() - tiempoRespuestaInicio) / 1000);

            boolean esCorrecta = respuestaJugador.equals(pregunta.getRespuesta_correcta().toUpperCase());

            if (esCorrecta) {

                puntajeTotal += puntajePregunta;
                aciertos++;
                System.out.println("CORRECTO! +$" + puntajePregunta);

            } else {

                System.out.println("INCORRECTO. La respuesta era: " + pregunta.getRespuesta_correcta());
            }

            // Guardar temporalmente sin id_partida todavia
            respuestasTemp.add(new Respuesta(
                    0,
                    0,
                    pregunta.getId_pregunta(),
                    respuestaJugador,
                    esCorrecta,
                    tiempoRespuesta
            ));
        }

        long tiempoFin = System.currentTimeMillis();
        int tiempoDuracion = (int) ((tiempoFin - tiempoInicio) / 1000);

        // Primero crear la partida
        Partida partida = new Partida(
                0,
                idJugador,
                idCategoria,
                dificultad,
                puntajeTotal,
                aciertos,
                totalPreguntas,
                tiempoDuracion
        );

        partidaDAO.crear(partida);

        // Obtener el id_partida recien creado
        Partida ultimaPartida = null;
        List<Partida> todasPartidas = partidaDAO.listar();

        for (int i = todasPartidas.size() - 1; i >= 0; i--) {

            if (todasPartidas.get(i).getId_jugador() == idJugador) {
                ultimaPartida = todasPartidas.get(i);
                break;
            }
        }

        // Ahora guardar las respuestas con el id_partida real
        if (ultimaPartida != null) {

            for (Respuesta r : respuestasTemp) {

                r.setId_partida(ultimaPartida.getId_partida());
                respuestaDAO.crear(r);
            }
        }

        // Actualizar puntaje del jugador
        jugador.setPuntaje_total(jugador.getPuntaje_total() + puntajeTotal);
        jugadorDAO.actualizar(jugador);

        // Actualizar ranking
        List<Ranking> rankings = rankingDAO.listar();
        boolean yaEstaEnRanking = false;

        for (Ranking r : rankings) {

            if (r.getId_jugador() == idJugador) {

                if (puntajeTotal > r.getPuntaje()) {

                    r.setPuntaje(puntajeTotal);
                    rankingDAO.actualizar(r);
                }

                yaEstaEnRanking = true;
                break;
            }
        }

        if (!yaEstaEnRanking) {
            rankingDAO.crear(new Ranking(0, idJugador, puntajeTotal, 0));
        }

        // Recalcular posiciones
        List<Ranking> rankingActualizado = rankingDAO.listar();

        rankingActualizado.sort((a, b) -> b.getPuntaje() - a.getPuntaje());

        for (int i = 0; i < rankingActualizado.size(); i++) {

            rankingActualizado.get(i).setPosicion(i + 1);
            rankingDAO.actualizar(rankingActualizado.get(i));
        }

        System.out.println("FIN DEL JUEGO");
        System.out.println("Jugador: " + jugador.getNombre());
        System.out.println("Aciertos: " + aciertos + "/" + totalPreguntas);
        System.out.println("Puntaje esta partida: $" + puntajeTotal);
        System.out.println("Puntaje total acumulado: $" + jugador.getPuntaje_total());
        System.out.println("Tiempo: " + tiempoDuracion + " segundos");
    }

    @Override
    public void mostrarRanking() {

        List<Ranking> rankings = rankingDAO.listar();

        if (rankings.isEmpty()) {

            System.out.println("No hay registros en el ranking todavia.");
            return;
        }

        rankings.sort((a, b) -> b.getPuntaje() - a.getPuntaje());

        System.out.println("==========================================");
        System.out.println("        RANKING DE JUGADORES             ");
        System.out.println("==========================================");
        System.out.println("POSICION  | JUGADOR                | PUNTAJE");
        System.out.println("------------------------------------------");

        for (Ranking r : rankings) {

            Jugador jugador = jugadorDAO.leer(r.getId_jugador());
            String nombreJugador;

            if (jugador != null) {

                nombreJugador = jugador.getNombre();

            } else {

                nombreJugador = "Desconocido";
            }

            System.out.printf("%-4d | %-22s | $%d%n",
                    r.getPosicion(),
                    nombreJugador,
                    r.getPuntaje());
        }

    }
}