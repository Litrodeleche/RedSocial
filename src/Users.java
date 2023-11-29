import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Users {
    private String Usuario;
    private String Contraseña;
    private Map<String, PerfilUsuario> Perfiles;
    private Map<String,Contacto> contactos;
    private List<Publicacion> publicaciones;
    private Queue<String> solicitudesAmistad;
    private Set<String> amigosEnComun;
     
	public Users(String usuario, String contraseña) {
		this.Usuario = usuario;
		this.Contraseña = contraseña;
		this.Perfiles = new HashMap<>();
        this.contactos = new HashMap<>();
        this.publicaciones = new LinkedList<>();
        this.solicitudesAmistad = new LinkedList<>();
        this.amigosEnComun = new HashSet<>();
	}
	
	public String getUsuario() {
		return Usuario;
	}
	
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	
	public String getContraseña() {
		return Contraseña;
	}
	
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public PerfilUsuario obtenerPerfil() {
        return Perfiles.get(Usuario);
    }

    public void agregarPerfil(PerfilUsuario perfil) {
    	Perfiles.put(Usuario, perfil);
        guardarPerfil();
    }

    public void guardarPerfil() {
        try  {
            PrintWriter bw = new PrintWriter(new FileWriter(NombreArchivos.TXT_PERFILES,true));
            for (PerfilUsuario u : Perfiles.values()) {
                bw.println(Usuario+","+u.getNombre()+","+u.getFoto()+","+u.getTelefono()+","+u.getFechaNa()+","+u.getEstado()+","+u.getInteres());
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    


    public void agregarContacto(Contacto contacto) {
        guardarContacto();
    }
    public void guardarContacto() {
        try {
            PrintWriter bw = new PrintWriter(new FileWriter(NombreArchivos.TXT_CONTACTOS, true));
            for (Contacto u : contactos.values()) {
                bw.println(Usuario + "," + u.getUsuario() + "," + u.getTelefono());
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void enviarSolicitudAmistad(String usuarioDestino) {
        guardarSolicitud(usuarioDestino);
    }

    public void guardarSolicitud(String destino) {
        try {
            PrintWriter bw = new PrintWriter(new FileWriter(NombreArchivos.TXT_SOLICITUDES, true));
                bw.println(Usuario + "->" + destino);
                bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Solicitudes(String usuario){
        try {
            BufferedReader lector = new BufferedReader(new FileReader(NombreArchivos.TXT_SOLICITUDES));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String [] datos = linea.split("->");
                String user = datos[0];
                String destino =datos[1];
                if (usuario==destino){
                    solicitudesAmistad.offer(destino);
                }
            }
            lector.close();
        }catch( IOException ioe ) {
            JOptionPane.showMessageDialog(null," no se pudo leer el archivo.");
        }
       // return solicitud;
    }

   /* public void procesarSolicitudes(RedSocial redSocial) {
        while (!solicitudesAmistad.isEmpty()) {
            String remitenteUsuario = solicitudesAmistad.poll();
            Users remitente = redSocial.obtenerUsuario(remitenteUsuario);

            if (remitente != null) {
                System.out.println("¡Tienes una solicitud de amistad de " + remitenteUsuario + "!");
                System.out.println("Aceptar solicitud? (Sí/No)");

                // Simular entrada del usuario (puedes modificar esta parte según tu interfaz de usuario)
                String respuestaUsuario = "Sí"; // Puedes cambiar esto según la entrada real del usuario

                if (respuestaUsuario.equalsIgnoreCase("Sí")) {
                    // Aceptar solicitud de amistad
                    agregarContacto(remitenteUsuario);
                    remitente.agregarContacto(Usuario);
                    System.out.println("Ahora eres amigo de " + remitenteUsuario + "!");
                } else {
                    System.out.println("Has rechazado la solicitud de amistad de " + remitenteUsuario + ".");
                }
            } else {
                System.out.println("Error: No se encontró el usuario con correo " + remitenteUsuario);
            }
        }
    }

    public void aceptarSolicitudAmistad() {
        if (!solicitudesAmistad.isEmpty()) {
            Users solicitante = solicitudesAmistad.poll();
            amigos.add(solicitante);
            solicitante.getAmigos().add(this);
        }
    }*/

    public void actualizarAmigosEnComun() {
        Set<String> nuevosAmigosEnComun = obtenerAmigosEnComun();
        amigosEnComun.clear();
        amigosEnComun.addAll(nuevosAmigosEnComun);
    }
    private Set<String> obtenerAmigosEnComun() {
        Set<String> amigosEnComun = new HashSet<>(contactos.keySet());

        // Iterar sobre los contactos del usuario actual
        for (Map.Entry<String, Contacto> entry : contactos.entrySet()) {
            String correoContacto = entry.getKey();

            // Verificar si el contacto también está en los contactos del otro usuario
            for (Users otroUsuario : RedSocial.usuarios.values()) {
                if (otroUsuario != this && otroUsuario.contactos.containsKey(correoContacto)) {
                    amigosEnComun.add(correoContacto);
                }
            }
        }
        return amigosEnComun;
    }

    public void realizarPublicacion(String contenido) {
        Publicacion publicacion = new Publicacion(this, contenido);
        publicaciones.add(publicacion);
    }
}
