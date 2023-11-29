
public class PerfilUsuario {
	private String Nombre;
	private String Foto;
    private int Telefono;
    private String FechaNa;
    private String Estado;
    private String Interes;
    
    
	public PerfilUsuario(String nombre, String foto,int telefono, String fechaNa,String estado,String interes) {
		this.Nombre = nombre;
		this.Foto=foto;
		this.Telefono = telefono;
		this.FechaNa = fechaNa;
		this.Estado = estado;
		this.Interes = interes;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public int getTelefono() {
		return Telefono;
	}


	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public String getFoto() {
		return Foto;
	}


	public void setFoto(String foto) {
		Foto = foto;
	}


	public String getFechaNa() {
		return FechaNa;
	}


	public void setFechaNa(String fechaNa) {
		FechaNa = fechaNa;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}


	public String getInteres() {
		return Interes;
	}


	public void setInteres(String interes) {
		Interes = interes;
	}
	
	

     
}
