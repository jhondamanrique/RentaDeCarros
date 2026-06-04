public class CamionetaSUV extends Vehiculo {
    private String TipoTraccion;
    private float CapacidadMaletero;
    public CamionetaSUV(){
    }
    public CamionetaSUV(String placa, String marca, int modelo, float precioDiario, boolean ContratoActivo, String tipoTraccion, int capacidadMaletero) {
        super(placa, marca, modelo, precioDiario, ContratoActivo);
        TipoTraccion = tipoTraccion;
        CapacidadMaletero = capacidadMaletero;
    }
    public String getTipoTraccion(){
        return TipoTraccion;
    }
    public void setTipoTraccion(String tipoTraccion){
        TipoTraccion = tipoTraccion;
    }
    public float getCapacidadMaletero(){
        return CapacidadMaletero;
    }
    public void setCapacidadMaletero(float capacidadMaletero){
        CapacidadMaletero = capacidadMaletero;
    }
    public void mostrarVehiculo(){
        super.mostrarVehiculo();
        System.out.println("Tracción: " + TipoTraccion);
        System.out.println("Capacidad maletero: " + CapacidadMaletero);
    }
}