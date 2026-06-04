import java.util.LinkedList;
import java.util.Scanner;

public class MenuPrincipal {
    public static void Menu(){

        Scanner sc = new Scanner(System.in);
        Validaciones v = new Validaciones();

        LinkedList<Cliente> VClientes = new LinkedList<>();
        LinkedList<Vehiculo> VVehiculos = new LinkedList<>();
        LinkedList<ContratoRenting> VContratos = new LinkedList<>();
        System.out.println("Sistema Renting de Carros - Menu Principal");

        boolean seguir = true;
        int opt = 0;

        while (seguir){
            System.out.println("\n========Sistema Renting de Carros=========");
            System.out.println("1) Gestion de clientes");
            System.out.println("2) Gestion de vehiculos");
            System.out.println("3) Gestion de contratos de renting");
            System.out.println("4) Imprimir informe general");
            System.out.println("5) Salir del sistema");
            System.out.println("Seleccione una opción:");
            opt = v.ValidarEnteroPositivo(sc);
            opt = v.ValidarRango(1, 5, sc);
            switch (opt){
                case 1:
                    MenuClientes.Menu(VClientes, VVehiculos, VContratos);
                    break;
                case 2:
                    MenuVehiculos.Menu(VVehiculos, VContratos,VClientes);
                    break;
                case 3:
                    MenuContratos.Menu(VClientes, VVehiculos, VContratos);
                    break;
                case 4:
                    Informe.ImprimirInforme(VClientes, VVehiculos, VContratos);
                    break;
                case 5:
                    seguir = false;
                    System.out.println("Gracias por usar el sistema Renting de Carros. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no valida, intentar nuevamente");
            }
        }
    }

}