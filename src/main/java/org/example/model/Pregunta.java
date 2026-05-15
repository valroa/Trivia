package org.example.model;

public class Pregunta {

    private int id_pregunta;
    private int id_categoria;
    private String texto_pregunta;
    private String opcion_a;
    private String opcion_b;
    private String opcion_c;
    private String opcion_d;
    private String respuesta_correcta;
    private String dificultad;

    public Pregunta() {
    }

    public Pregunta(int id_pregunta, int id_categoria, String texto_pregunta, String opcion_a, String opcion_b, String opcion_c, String opcion_d, String respuesta_correcta, String dificultad) {
        this.id_pregunta = id_pregunta;
        this.id_categoria = id_categoria;
        this.texto_pregunta = texto_pregunta;
        this.opcion_a = opcion_a;
        this.opcion_b = opcion_b;
        this.opcion_c = opcion_c;
        this.opcion_d = opcion_d;
        this.respuesta_correcta = respuesta_correcta;
        this.dificultad = dificultad;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getTexto_pregunta() {
        return texto_pregunta;
    }

    public void setTexto_pregunta(String texto_pregunta) {
        this.texto_pregunta = texto_pregunta;
    }

    public String getOpcion_a() {
        return opcion_a;
    }

    public void setOpcion_a(String opcion_a) {
        this.opcion_a = opcion_a;
    }

    public String getOpcion_b() {
        return opcion_b;
    }

    public void setOpcion_b(String opcion_b) {
        this.opcion_b = opcion_b;
    }

    public String getOpcion_c() {
        return opcion_c;
    }

    public void setOpcion_c(String opcion_c) {
        this.opcion_c = opcion_c;
    }

    public String getOpcion_d() {
        return opcion_d;
    }

    public void setOpcion_d(String opcion_d) {
        this.opcion_d = opcion_d;
    }

    public String getRespuesta_correcta() {
        return respuesta_correcta;
    }

    public void setRespuesta_correcta(String respuesta_correcta) {
        this.respuesta_correcta = respuesta_correcta;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "id_pregunta=" + id_pregunta +
                ", id_categoria=" + id_categoria +
                ", texto_pregunta='" + texto_pregunta + '\'' +
                ", opcion_a='" + opcion_a + '\'' +
                ", opcion_b='" + opcion_b + '\'' +
                ", opcion_c='" + opcion_c + '\'' +
                ", opcion_d='" + opcion_d + '\'' +
                ", respuesta_correcta='" + respuesta_correcta + '\'' +
                ", dificultad='" + dificultad + '\'' +
                '}';
    }
}
