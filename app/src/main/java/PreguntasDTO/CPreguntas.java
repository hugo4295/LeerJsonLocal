package PreguntasDTO;

public class CPreguntas {
    String Pregunta;
    String Respuesta_a;
    String Respuesta_b;
    String Respuesta_c;
    String Respuesta;

    public CPreguntas(String pregunta, String respuesta_a, String respuesta_b, String respuesta_c, String respuesta) {
        Pregunta = pregunta;
        Respuesta_a = respuesta_a;
        Respuesta_b = respuesta_b;
        Respuesta_c = respuesta_c;
        Respuesta = respuesta;
    }

    public CPreguntas() {
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String pregunta) {
        Pregunta = pregunta;
    }

    public String getRespuesta_a() {
        return Respuesta_a;
    }

    public void setRespuesta_a(String respuesta_a) {
        Respuesta_a = respuesta_a;
    }

    public String getRespuesta_b() {
        return Respuesta_b;
    }

    public void setRespuesta_b(String respuesta_b) {
        Respuesta_b = respuesta_b;
    }

    public String getRespuesta_c() {
        return Respuesta_c;
    }

    public void setRespuesta_c(String respuesta_c) {
        Respuesta_c = respuesta_c;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String respuesta) {
        Respuesta = respuesta;
    }
}
