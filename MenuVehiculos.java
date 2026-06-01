import java.util.LinkedList;
import java.util.Scanner;

public class MenuVehiculos {
    public static void Menu(LinkedList<Vehiculo> vehiculos, LinkedList<ContratoRenting> contratos) {

        Scanner sc = new Scanner(System.in);
        Validaciones v = new Validaciones();
        GestionVehiculos gv = new GestionVehiculos();

        boolean seguir = true;
        int opt = 0;

        while (seguir) {
            System.out.println("\n========= GESTION DE VEHICULOS =========");
            System.out.println("1) Registrar vehiculo");
            System.out.println("2) Modificar vehiculo");
            System.out.println("3) Eliminar vehiculo");
            System.out.println("4) Buscar vehiculo");
            System.out.println("5) Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            opt = v.ValidarEntero(sc);
            opt = v.ValidarRango(1, 5, sc);

            switch (opt) {
                case 1:
                    gv.RegistrarVehiculo(vehiculos, sc);
                    break;

                case 2:
                    gv.ModificarVehiculo(vehiculos, sc);
                    break;

                case 3:
                    gv.EliminarVehiculo(vehiculos, contratos, sc);
                    break;

                case 4:
                    gv.BuscarVehiculo(vehiculos, sc);
                    break;

                case 5:
                    seguir = false;
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}
