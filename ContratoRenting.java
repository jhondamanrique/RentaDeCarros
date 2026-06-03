import java.time.LocalDate;

public class ContratoRenting {
    private int IdContrato;
    private int  CedulaCliente;
    private String PlacaVehiculo;
    private LocalDate FechaInicio;
    private LocalDate FechaFin;
    private int TotalDias;
    private float ValorTotal;
    public ContratoRenting(){
    }
    public ContratoRenting(int idContrato, int cedulaCliente, String placaVehiculo, LocalDate fechaInicio, LocalDate fechaFin, int totalDias, float valorTotal){
        IdContrato = idContrato;
        CedulaCliente = cedulaCliente;
        PlacaVehiculo = placaVehiculo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        TotalDias = totalDias;
        ValorTotal = valorTotal;
    }
    public int getIdContrato(){
        return IdContrato;
    }
    public void setIdContrato(int idContrato){
        IdContrato = idContrato;
    }
    public int  getCedulaCliente(){
        return CedulaCliente;
    }
    public void setCedulaCliente(int cedulaCliente){
        CedulaCliente = cedulaCliente;
    }
    public String getPlacaVehiculo(){
        return PlacaVehiculo;
    }
    public void setPlacaVehiculo(String placaVehiculo){
        PlacaVehiculo = placaVehiculo;
    }
    public LocalDate getFechaInicio(){
        return FechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio){
        FechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin(){
        return FechaFin;
    }
    public void setFechaFin(LocalDate fechaFin){
        FechaFin = fechaFin;
    }
    public int getTotalDias(){
        return TotalDias;
    }
    public void setTotalDias(int totalDias){
        TotalDias = totalDias;
    }
    public float getValorTotal(){
        return ValorTotal;
    }
    public void setValorTotal(float valorTotal){
        ValorTotal = valorTotal;
    }
    public void mostrarContrato(){
        System.out.println("Id contrato: " + IdContrato);
        System.out.println("Cedula cliente: " + CedulaCliente);
        System.out.println("Placa vehículo: " + PlacaVehiculo);
        System.out.println("Fecha inicio: " + FechaInicio);
        System.out.println("Fecha fin: " + FechaFin);
        System.out.println("Total días: " + TotalDias);
        System.out.println("Valor total: " + ValorTotal);
    }
}