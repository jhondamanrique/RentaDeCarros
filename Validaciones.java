import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Scanner;

public class Validaciones {
    Scanner sc = new Scanner(System.in);
    public int ValidarEntero(Scanner sc){
        while(!sc.hasNextInt()){
            System.out.println("Por favor, ingrese un número entero.");
            sc.nextLine();
        }

        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

    public int ValidarRango(int n1, int n2, Scanner sc){
        int num = ValidarEntero(sc);

        while(num < n1 || num > n2){
            System.out.println("Ingrese un número entre " + n1 + " y " + n2);
            num = ValidarEntero(sc);
        }

        return num;
    }

    public String Solotexto(Scanner sc){
        
        String entrega = "";
        boolean validar = true;

        while(validar){
            entrega = TextoNoVacio(sc);

            if(entrega.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")){
                validar = false;
            }
            else{
                System.out.println("Ingrese un texto valido");
            }
        }
        return entrega;

        }

    public String TextoNoVacio(Scanner sc){
        String dato = sc.nextLine();

        if(dato.trim().isEmpty()){
            System.out.println("El campo no puede estar vacío.");
            return TextoNoVacio(sc);
        }

        return dato;
    }

    public String SoloNumeros(Scanner sc){
        String dato = TextoNoVacio(sc);

        if(!dato.matches("\\d+")){
            System.out.println("Ingrese solo números.");
            return SoloNumeros(sc);
        }

        return dato;
    }

    public String SoloTexto(Scanner sc){
        String dato = TextoNoVacio(sc);

        if(!dato.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")){
            System.out.println("Ingrese solo letras.");
            return SoloTexto(sc);
        }

        return dato;
    }

    public String TextoAlfanumerico(Scanner sc){
        String dato = TextoNoVacio(sc);

        if(!dato.matches("^[a-zA-Z0-9]+$")){
            System.out.println("Solo letras y números.");
            return TextoAlfanumerico(sc);
        }

        return dato;
    }

    public float ValidarDecimal(Scanner sc){

        try{
            return Float.parseFloat(TextoNoVacio(sc));
        }
        catch(NumberFormatException e){
            System.out.println("Ingrese un decimal válido.");
            return ValidarDecimal(sc);
        }
    }

    public float ValidarDecimalPositivo(Scanner sc){

        float num = ValidarDecimal(sc);

        if(num <= 0){
            System.out.println("Ingrese un valor positivo.");
            return ValidarDecimalPositivo(sc);
        }

        return num;
    }

    public int ValidarEnteroPositivo(Scanner sc){

        int num = ValidarEntero(sc);

        if(num <= 0){
            System.out.println("Ingrese un entero positivo.");
            return ValidarEnteroPositivo(sc);
        }

        return num;
    }

    public String ValidarEstadoVehiculo(Scanner sc){

        String estado = TextoNoVacio(sc).toLowerCase();

        if(estado.equals("disponible") || estado.equals("alquilado")){
            return estado;
        }

        System.out.println("Ingrese disponible o alquilado.");
        return ValidarEstadoVehiculo(sc);
    }

    public String ValidarTipoCombustible(Scanner sc){

        String tipo = TextoNoVacio(sc).toLowerCase();

        if(tipo.equals("gasolina") ||
           tipo.equals("diesel") ||
           tipo.equals("diésel") ||
           tipo.equals("electrico") ||
           tipo.equals("eléctrico")){
            return tipo;
        }

        System.out.println("Ingrese gasolina, diésel o eléctrico.");
        return ValidarTipoCombustible(sc);
    }

    public String ValidarTransmision(Scanner sc){

        String tipo = TextoNoVacio(sc).toLowerCase();

        if(tipo.equals("manual") ||
           tipo.equals("automatica") ||
           tipo.equals("automática")){
            return tipo;
        }

        System.out.println("Ingrese manual o automática.");
        return ValidarTransmision(sc);
    }

    public String ValidarTraccion(Scanner sc){

        String traccion = TextoNoVacio(sc);

        if(traccion.equals("4x2") || traccion.equals("4x4")){
            return traccion;
        }

        System.out.println("Ingrese 4x2 o 4x4.");
        return ValidarTraccion(sc);
    }

    public LocalDate SolicitarFechaValida(Scanner sc, String mensaje){

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while(true){

            System.out.println(mensaje);
            String fechaTexto = sc.nextLine();

            try{

                LocalDate fecha =
                        LocalDate.parse(fechaTexto, formato);

                int anio = fecha.getYear();

                if(anio < 2025 || anio > 2030){
                    System.out.println("Año fuera de rango.");
                    continue;
                }

                return fecha;

            }catch(DateTimeParseException e){
                System.out.println("Fecha inválida.");
            }
        }
    }

    // ==========================
    // BUSQUEDAS
    // ==========================

    public Cliente BuscarEnClientes(
            LinkedList<Cliente> clientes,
            int cedula){

        for(Cliente c : clientes){

            if(String.valueOf(c.getCedula()).equals(cedula)){
                return c;
            }
        }

        return null;
    }

    public Vehiculo BuscarEnVehiculos(
            LinkedList<Vehiculo> vehiculos,
            String placa){

        for(Vehiculo v : vehiculos){

            if(v.getPlaca().equalsIgnoreCase(placa)){
                return v;
            }
        }

        return null;
    }

    public ContratoRenting BuscarEnContratos(
            LinkedList<ContratoRenting> contratos,
            int idContrato){

        for(ContratoRenting c : contratos){

            if(c.getIdContrato() == idContrato){
                return c;
            }
        }

        return null;
    }

    // ==========================
    // VALIDACIONES DE EXISTENCIA
    // ==========================

    public boolean ValidarExistencia(Object obj){

        if(obj != null){
            System.out.println("El registro ya existe.");
            return true;
        }

        return false;
    }

    public boolean ContratoActivo(boolean estado){

        if(estado){
            System.out.println("Ya tiene contrato activo.");
            return true;
        }

        return false;
    }

    // ==========================
    // FECHAS CONTRATO
    // ==========================

   public float AsignacionFechas(ContratoRenting c, float precioDiario, int choice) {
    LocalDate nuevaFechaInicio = c.getFechaInicio();
    LocalDate nuevaFechaFin = c.getFechaFin();
    Validaciones v = new Validaciones();

    switch (choice) {
        case 1: 
            nuevaFechaInicio = v.SolicitarFechaValida(sc, "Ingrese la fecha inicial");
            while (true) {
                nuevaFechaFin = v.SolicitarFechaValida(sc, "Ingrese la fecha final");
                if (nuevaFechaFin.isBefore(nuevaFechaInicio)) {
                    System.out.println("Error: La fecha final no puede ser anterior a la inicial.");
                } 
                else {
                    break;
                }
            }
            c.setFechaInicio(nuevaFechaInicio);
            c.setFechaFin(nuevaFechaFin);
            System.out.println("FECHAS ASIGNADAS CON ÉXITO");
            break;

        default:
            System.out.println("¿Qué fecha quiere cambiar?\n 1. Fecha inicial \n 2. Fecha final \n 3. Las 2");
            int opt = ValidarRango(1, 3, sc); 
            
            switch (opt) {
                case 1:
                    while (true) {
                        nuevaFechaInicio = v.SolicitarFechaValida(sc, "Ingrese la nueva fecha inicial");
                        if (c.getFechaFin() != null && nuevaFechaInicio.isAfter(c.getFechaFin())) {
                            System.out.println("Error: La nueva fecha inicial no puede ser posterior a la fecha final actual (" + c.getFechaFin() + ").");
                        } else {
                            break;
                        }
                    }
                    c.setFechaInicio(nuevaFechaInicio);
                    System.out.println(" FECHA INICIAL CAMBIADA CON ÉXITO");
                    break;

                case 2: // Cambiar solo final
                    while (true) {
                        nuevaFechaFin = v.SolicitarFechaValida(sc, "Ingrese la nueva fecha final");
                        if (c.getFechaInicio() != null && nuevaFechaFin.isBefore(c.getFechaInicio())) {
                            System.out.println("Error: La nueva fecha final no puede ser anterior a la fecha inicial actual (" + c.getFechaInicio() + ").");
                        } else {
                            break;
                        }
                    }
                    c.setFechaFin(nuevaFechaFin);
                    System.out.println("✨ FECHA FINAL CAMBIADA CON ÉXITO");
                    break;

                default: // Cambiar ambas
                    nuevaFechaInicio = v.SolicitarFechaValida(sc, "Ingrese la nueva fecha inicial");
                    while (true) {
                        nuevaFechaFin = v.SolicitarFechaValida(sc, "Ingrese la nueva fecha final");
                        if (nuevaFechaFin.isBefore(nuevaFechaInicio)) {
                            System.out.println("Error: La nueva fecha final no puede ser anterior a la nueva inicial.");
                        } else {
                            break;
                        }
                    }
                    c.setFechaInicio(nuevaFechaInicio);
                    c.setFechaFin(nuevaFechaFin);
                    System.out.println("AMBAS FECHAS CAMBIADAS CON ÉXITO");
                    break;
            }
            break;
    }
    long totaldias = ChronoUnit.DAYS.between(c.getFechaInicio(), c.getFechaFin());
    c.setTotalDias((int) totaldias); 
    System.out.println("Total de días actualizado: " + totaldias);
    return totaldias * precioDiario;
}
}