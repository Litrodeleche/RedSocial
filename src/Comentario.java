public class Comentario {
    private Users autor;
    private String contenido;

    public Comentario(Users autor, String contenido) {
        this.autor = autor;
        this.contenido = contenido;
    }

    public Users getAutor() {
        return autor;
    }

    public String getContenido() {
        return contenido;
    }
}
