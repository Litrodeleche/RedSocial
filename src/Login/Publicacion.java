package Login;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Publicacion {
    private Users autor;
    private String contenido;
    private LocalDateTime fechaPublicacion;
    private List<Comentario> comentarios;

    public Publicacion(Users autor, String contenido) {
        this.autor = autor;
        this.contenido = contenido;
        this.fechaPublicacion = LocalDateTime.now();
        this.comentarios = new ArrayList<>();
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }
    
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }
}