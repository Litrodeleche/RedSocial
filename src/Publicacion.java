import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Publicacion {
    private String autor;
    private String contenido;
    private LocalDateTime fechaPublicacion;
    private List<Comentario> comentarios;

    public Publicacion(String autor, String contenido) {
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

	@Override
	public String toString() {
		return autor + ";" + fechaPublicacion + ";" +contenido;
	}
	public void guardarEnArchivo() {
        String nombreArchivo = "Publicaciones.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            // Escribir la representación en cadena de la publicación en el archivo
            writer.write(this.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}