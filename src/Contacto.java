class Contacto {


    String Usuario;
    int Telefono;
    Contacto siguienteContacto;

    public Contacto(String usuario,int telefono) {
        this.Usuario = usuario;
        this.Telefono=telefono;
        this.siguienteContacto = null;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }
}