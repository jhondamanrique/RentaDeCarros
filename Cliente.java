public class Cliente {
    private String Cedula;
    private String Nombre;
    private String Apellido;
    private int Telefono;
    private String Direccion;
    private boolean Licencia;
    private boolean ContratoActivo;

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public boolean isLicencia() {
        return Licencia;
    }

    public void setLicencia(boolean licencia) {
        Licencia = licencia;
    }

    public boolean isContratoActivo() {
        return ContratoActivo;
    }

    public void setContratoActivo(boolean contratoActivo) {
        ContratoActivo = contratoActivo;
    }
    public void mostrarCliente() {
        System.out.println("Cedula: " + Cedula);
        System.out.println("Nombre: " + Nombre);
        System.out.println("Apellido: " + Apellido);
        System.out.println("Telefono: " + Telefono);
        System.out.println("Direccion: " + Direccion);
        System.out.println("Licencia: " + Licencia);
    }

}
