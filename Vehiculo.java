public class Vehiculo {
    private String Placa;
    private String Marca;
    private int Modelo;
    private float PrecioDiario;
    private String Estado;
    private boolean ContratoActivo;
    public Vehiculo(){
    }
    public Vehiculo(String placa, String marca, int modelo, float precioDiario, boolean ContratoActivo) {
        this.Placa = placa;
        this.Marca = marca;
        this.Modelo = modelo;
        this.PrecioDiario = precioDiario;
        this.ContratoActivo = ContratoActivo;
    }
    
    public String getPlaca(){
        return Placa;
    }
    public void setPlaca(String placa){
        Placa = placa;
    }
    public String getMarca(){
        return Marca;
    }
    public void setMarca(String marca){
        Marca = marca;
    }
    public int getModelo(){
        return Modelo;
    }
    public void setModelo(int modelo){
        Modelo = modelo;
    }
    public float getPrecioDiario(){
        return PrecioDiario;
    }
    public void setPrecioDiario(float precioDiario){
        PrecioDiario = precioDiario;
    }
    public String getEstado(){
        return Estado;
    }
    public void setEstado(String estado){
        Estado = estado;
    }
    public void mostrarVehiculo(){
        System.out.println("Placa: " + Placa);
        System.out.println("Marca: " + Marca);
        System.out.println("Modelo: " + Modelo);
        System.out.println("Precio diario: " + PrecioDiario);
        System.out.println("Estado: " + Estado);
    }
    public boolean isContratoActivo() {
        return ContratoActivo;
    }
    public void setContratoActivo(boolean contratoActivo) {
        ContratoActivo = contratoActivo;
    }
}