import java.util.LinkedList;
import java.util.Scanner;

public class MenuContratos {
    public static void Menu(LinkedList<Cliente> clientes, LinkedList<Vehiculo> vehiculos, LinkedList<ContratoRenting> contratos) {

        Scanner sc = new Scanner(System.in);
        Validaciones v = new Validaciones();
        GestionContratos gr = new GestionContratos();

        boolean seguir = true;
        int opt = 0;

        while (seguir) {
            System.out.println("\n========= GESTION DE CONTRATOS =========");
            System.out.println("1) Registrar nuevo contrato");
            System.out.println("2) Modificar contrato");
            System.out.println("3) Finalizar contrato (devolucion)");
            System.out.println("4) Buscar contrato");
            System.out.println("5) Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            opt = v.ValidarRango(1, 5,sc);

            switch (opt) {
                case 1:
                    gr.RegistrarContrato(clientes, vehiculos, contratos, sc);
                    break;

                case 2:
                    gr.ModificarContrato(contratos, sc);
                    break;

                case 3:
                    gr.FinalizarContrato(contratos, vehiculos, sc);
                    break;

                case 4:
                    gr.BuscarContrato(contratos, sc);
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
