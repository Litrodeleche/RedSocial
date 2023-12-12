package Login;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;


public class RedSocial {
    private Map<String, Users> usuarios; 

    public RedSocial() {
        this.usuarios = new HashMap<>();
    }
    
    public void agregarUsuario(Users usuario) {
    	usuarios.put(usuario.getUsuario(), usuario);
    	guardarUsuarios();
    }
    
    public void guardarUsuarios() {
        try  {
        	PrintWriter bw = new PrintWriter(new FileWriter(NombreArchivos.TXT_USUARIOS,true));
            for (Users u : usuarios.values()) {
                bw.println(u.getUsuario()+","+u.getContraseña());
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Users obtenerUsuario(String usuario) {
        return usuarios.get(usuario);
    }
    
    static boolean busqueda(String usario){
		ArrayList<Users> usuario = new ArrayList<Users>();
		boolean encontrado = false;
		try {
			BufferedReader lector = new BufferedReader(new FileReader(NombreArchivos.TXT_USUARIOS));
			String linea;
			while ((linea = lector.readLine()) != null) {
				String [] datos = linea.split(",");
				String user = datos[0];
				String password =datos[1];
				Users u = new Users(user, password);
				usuario.add(u);
				if (u.getUsuario().equals(usario)) {
					 encontrado = true;
					 return encontrado;
				}
			}
			lector.close();
		}catch( IOException ioe ) {
			JOptionPane.showMessageDialog(null," no se pudo leer el archivo.");
		}
		return encontrado;
	}
    
	static boolean iniciosesion(String usario,String contras){
		ArrayList<Users> usuario = new ArrayList<Users>();
		boolean encontrado = false;
		try {
			BufferedReader lector = new BufferedReader(new FileReader(NombreArchivos.TXT_USUARIOS));
			String linea;
			while ((linea = lector.readLine()) != null) {
				String [] datos = linea.split(",");
				String user = datos[0];
				String password =datos[1];
				Users u = new Users(user, password);
				usuario.add(u);
				if (u.getUsuario().equals(usario) && u.getContraseña().equals(contras)) {
					 encontrado = true;
					 return encontrado;
				}
			}
			lector.close();
		}catch( IOException ioe ) {
			JOptionPane.showMessageDialog(null," no se pudo leer el archivo.");
		}
		return encontrado;
	}

    /*public void agregarContacto(String telUsuario, String telContacto) {
        Users usuario = usuarios.get(telUsuario);
        Users contacto = usuarios.get(telContacto);

        if (usuario != null && contacto != null) {
            usuario.agregarContacto(contacto);
            System.out.println("Contacto agregado con éxito.");
        } else {
            System.out.println("Usuario o contacto no encontrado.");
        }
    }*/

    public void agregarAmigo(String telUsuario, String telAmigo) {
        Users usuario = usuarios.get(telUsuario);
        Users amigo = usuarios.get(telAmigo);

        if (usuario != null && amigo != null) {
            usuario.agregarAmigo(amigo);
            System.out.println("Amigo agregado con éxito.");
        } else {
            System.out.println("Usuario o amigo no encontrado.");
        }
    }

    public void mostrarPublicaciones(String usuario) {
        Users u = usuarios.get(usuario);
        if (u != null) {
            System.out.println("Publicaciones de " + u.getUsuario() + ":");
            for (Publicacion publicacion : u.getPublicaciones()) {
                System.out.println(publicacion.getContenido());
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
    
    public Users buscarUsuarioPorNombre(String nombre) {
        for (Users usuario : usuarios.values()) {
            PerfilUsuario perfil = usuario.obtenerPerfil();
            if (perfil != null && perfil.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null; 
    }

    public Users buscarUsuarioPorIntereses(String interes) {
        for (Users usuario : usuarios.values()) {
            PerfilUsuario perfil = usuario.obtenerPerfil();
            if (perfil != null && perfil.getInteres().equalsIgnoreCase(interes)) {
                return usuario;
            }
        }
        return null;
    }
}
