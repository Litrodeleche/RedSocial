import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Comentario {
	private String publicacion;
    private String autor;
    private LocalDateTime fechaPublicacion;
    private String contenido;

    public Comentario() {
 
    }

    public String getAutor() {
        return autor;
    }

    public String getContenido() {
        return contenido;
    }
    
    public LocalDateTime getFechaPublicacion() {
    	return fechaPublicacion;
    }

	@Override
	public String toString() {
		return autor + ";"+ fechaPublicacion+ ";"+ contenido;
	}
	public void guardarEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Comentarios.txt", true))) {
            // Agregar el comentario al archivo
            writer.write(this.toString());
            writer.newLine();  // Agregar nueva línea para el próximo comentario
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
