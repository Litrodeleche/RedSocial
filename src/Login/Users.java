package Login;

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
    private LinkedList<Contacto> contactos;
    private List<Users> amigos;
    private List<Publicacion> publicaciones;
    private Queue<String> solicitudesAmistad;
    private Set<String> amigosEnComun;
     
	public Users(String usuario, String contraseña) {
		this.Usuario = usuario;
		this.Contraseña = contraseña;
		this.Perfiles = new HashMap<>();
        this.contactos = new LinkedList<>();
        this.amigos = new LinkedList<>();
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
	
	public LinkedList<Contacto> getContactos() {
        return contactos;
    }

    public List<Users> getAmigos() {
        return amigos;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }
    
    
    public void agregarContacto(String usuario) {
        Contacto nuevoContacto = new Contacto(usuario);
        contactos.add(nuevoContacto);
    }

    public void eliminarContacto(String usuario) {
        Contacto contactoAEliminar = new Contacto(usuario);
        contactos.remove(contactoAEliminar);
    }

    public void agregarAmigo(Users amigo) {
        amigos.add(amigo);
    }

    public void realizarPublicacion(String contenido) {
        Publicacion publicacion = new Publicacion(this, contenido);
        publicaciones.add(publicacion);
    }
    
    public void agregarPerfil(PerfilUsuario perfil) {
        Perfiles.put(Usuario, perfil);
        guardarPerfil();
    }
    
    public void guardarPerfil() {
        try  {
        	PrintWriter bw = new PrintWriter(new FileWriter(NombreArchivos.TXT_PERFILES,true));
            for (PerfilUsuario u : Perfiles.values()) {
                bw.println(Usuario+","+u.getNombre()+","+u.getTelefono()+u.getFechaNa()+","+u.getEstado()+","+u.getInteres());
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PerfilUsuario obtenerPerfil() {
        return Perfiles.get(Usuario);
    }
    
    public void enviarSolicitudAmistad(String usuarioDestino) {
        solicitudesAmistad.add(usuarioDestino);
    }

    public void procesarSolicitudes(RedSocial redSocial) {
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
    
    /*public void aceptarSolicitudAmistad() {
        if (!solicitudesAmistad.isEmpty()) {
            Users solicitante = solicitudesAmistad.poll();
            amigos.add(solicitante);
            solicitante.getAmigos().add(this);
        }
    }*/
    
    public Set<String> obtenerAmigosEnComun(Users otroUsuario) {
        Set<String> amigosEnComun = new HashSet<>(this.amigosEnComun);
        amigosEnComun.retainAll(otroUsuario.amigosEnComun);
        return amigosEnComun;
    }
}
