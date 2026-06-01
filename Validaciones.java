import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class Validaciones {
    public int ValidarEntero(Scanner sc){
        while(!sc.hasNextInt()){
            System.out.println("Por favor, ingrese un número entero.");
            sc.nextLine();
        }
        int Num = sc.nextInt();
        sc.nextLine();
        return Num;
    }
    public int ValidarRango(int n1, int n2, Scanner sc){
        int Num = 0;
        while(Num < n1 || Num > n2){
            System.out.println("Por favor, ingrese un numero entre " + n1 + " y " + n2 + ".");
            Num = ValidarEntero(sc);
        }
        return Num;
    }
    public String TextoNoVacio(Scanner sc){
        String Dato = sc.nextLine();
        if(Dato.trim().isEmpty()){
            System.out.println("El campo no puede estar vacio.");
            return TextoNoVacio(sc);
        }
        return Dato;
    }
    public String SoloNumeros(Scanner sc){
        String Entrega = "";
        boolean Validar = true;
        while(Validar){
            try{
                Entrega = TextoNoVacio(sc);
                Integer.parseInt(Entrega);
                Validar = false;
            }catch(NumberFormatException e){
                System.out.println("Ingrese solo numeros por favor.");
            }
        }
        return Entrega;
    }
    public String SoloTexto(Scanner sc){
        String Entrega = "";
        boolean Validar = true;
        while(Validar){
            Entrega = TextoNoVacio(sc);
            if(Entrega.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")){
                Validar = false;
            }else{
                System.out.println("Ingrese un texto valido");
            }
        }
        return Entrega;
    }
    public String TextoAlfanumerico(Scanner sc){
        String Entrega = "";
        boolean Validar = true;
        while(Validar){
            Entrega = TextoNoVacio(sc);
            if(Entrega.matches("^[a-zA-Z0-9]+$")){
                Validar = false;
            }else{
                System.out.println("Ingrese solo letras y numeros, sin caracteres especiales.");
            }
        }
        return Entrega;
    }
    public float ValidarDecimal(Scanner sc){
        float Num = 0;
        boolean Validar = true;
        while(Validar){
            try{
                Num = Float.parseFloat(TextoNoVacio(sc));
                Validar = false;
            }catch(NumberFormatException e){
                System.out.println("Ingrese un número decimal válido.");
            }
        }
        return Num;
    }
    public float ValidarDecimalPositivo(Scanner sc){
        float Num = ValidarDecimal(sc);
        while(Num <= 0){
            System.out.println("Ingrese un valor positivo.");
            Num = ValidarDecimal(sc);
        }
        return Num;
    }
    public int ValidarEnteroPositivo(Scanner sc){
        int Num = ValidarEntero(sc);
        while(Num <= 0){
            System.out.println("Ingrese un número entero positivo.");
            Num = ValidarEntero(sc);
        }
        return Num;
    }
    public String ValidarEstadoVehiculo(Scanner sc){
        String Estado = "";
        boolean Validar = true;
        while(Validar){
            Estado = TextoNoVacio(sc).toLowerCase();
            if(Estado.equals("disponible") || Estado.equals("alquilado")){
                Validar = false;
            }else{
                System.out.println("Ingrese un estado válido: disponible o alquilado.");
            }
        }
        return Estado;
    }
    public String ValidarTipoCombustible(Scanner sc){
        String TipoCombustible = "";
        boolean Validar = true;
        while(Validar){
            TipoCombustible = TextoNoVacio(sc).toLowerCase();
            if(TipoCombustible.equals("gasolina") || TipoCombustible.equals("diesel") || TipoCombustible.equals("diésel") || TipoCombustible.equals("electrico") || TipoCombustible.equals("eléctrico")){
                Validar = false;
            }else{
                System.out.println("Ingrese un tipo de combustible válido: gasolina, diésel o eléctrico.");
            }
        }
        return TipoCombustible;
    }
    public String ValidarTransmision(Scanner sc){
        String Transmision = "";
        boolean Validar = true;
        while(Validar){
            Transmision = TextoNoVacio(sc).toLowerCase();
            if(Transmision.equals("automatica") || Transmision.equals("automática") || Transmision.equals("manual")){
                Validar = false;
            }else{
                System.out.println("Ingrese una transmisión válida: automática o manual.");
            }
        }
        return Transmision;
    }
    public String ValidarTraccion(Scanner sc){
        String Traccion = "";
        boolean Validar = true;
        while(Validar){
            Traccion = TextoNoVacio(sc).toLowerCase();
            if(Traccion.equals("4x2") || Traccion.equals("4x4")){
                Validar = false;
            }else{
                System.out.println("Ingrese una tracción válida: 4x2 o 4x4.");
            }
        }
        return Traccion;
    }
    public LocalDate SolicitarFechaValida(Scanner sc, String mensaje){
        DateTimeFormatter Formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(true){
            System.out.println(mensaje + " (Formato: DD/MM/AAAA): ");
            String Entrada = sc.next();
            sc.nextLine();
            try{
                LocalDate FechaParseada = LocalDate.parse(Entrada, Formateador);
                int Anio = FechaParseada.getYear();
                if(Anio < 2025 || Anio > 2030){
                    System.out.println("El año " + Anio + " no es válido para el sistema.");
                    continue;
                }
                return FechaParseada;
            }catch(DateTimeParseException e){
                System.out.println("Error: formato inválido o fecha inexistente en el calendario. Intente de nuevo.");
            }
        }
    }
}