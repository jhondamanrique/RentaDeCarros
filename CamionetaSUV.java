public class CamionetaSUV extends Vehiculo {
    private String Traccion;
    private float CapacidadMaletero;
    public CamionetaSUV(){
    }
    public CamionetaSUV(String placa, String marca, int modelo, float precioDiario,
            String estado, String traccion, float capacidadMaletero){
        super(placa, marca, modelo, precioDiario, estado);
        Traccion = traccion;
        CapacidadMaletero = capacidadMaletero;
    }
    public String getTraccion(){
        return Traccion;
    }
    public void setTraccion(String traccion){
        Traccion = traccion;
    }
    public float getCapacidadMaletero(){
        return CapacidadMaletero;
    }
    public void setCapacidadMaletero(float capacidadMaletero){
        CapacidadMaletero = capacidadMaletero;
    }
    public void mostrarVehiculo(){
        super.mostrarVehiculo();
        System.out.println("Tracción: " + Traccion);
        System.out.println("Capacidad maletero: " + CapacidadMaletero);
    }
}