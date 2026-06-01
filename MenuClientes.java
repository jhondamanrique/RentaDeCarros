import java.util.LinkedList;
import java.util.Scanner;

public class MenuClientes {
    public static void Menu(LinkedList<Cliente> clientes, LinkedList<Vehiculo> vehiculos, LinkedList<ContratoRenting> contratos){
        Scanner sc = new Scanner(System.in);
        Validaciones v = new Validaciones();
        GestionClientes gc = new GestionClientes();

        boolean seguir = true;
        int opt = 0;

        while (seguir){
            System.out.println("=========Gestion de Clientes=========");
            System.out.println("1) Registrar cliente");
            System.out.println("2) Modificar cliente");
            System.out.println("3) Eliminar cliente");
            System.out.println("4) Buscar cliente");
            System.err.println("5) Volver al menu principal");
            System.out.println("Seleccione una opción:");
            opt = v.ValidarEntero(sc);
            opt = v.ValidarRango(1, 5, opt, sc);
            switch (opt){
                case 1:
                    gc.RegistrarCliente(clientes, sc);
                    break;
                case 2:
                    gc.ModificarCliente(clientes, sc);
                    break;
                case 3:
                    gc.EliminarCliente(clientes, contratos, sc);
                    break;
                case 4:
                    gc.BuscarCliente(clientes, sc);
                    break;
                case 5:
                    seguir = false;
                    System.out.println("Volviendo al menu principal...");
                    break;
            }
        }
    }
}
