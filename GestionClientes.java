import java.util.LinkedList;
import java.util.Scanner;

public class GestionClientes {
    Validaciones v = new Validaciones();

    public LinkedList<Cliente> RegistrarCliente(LinkedList<Cliente> ListaClientes, Scanner sc) {
        boolean Bandera = true;

        while (Bandera) {
            Cliente c = new Cliente();
            System.out.println("Ingrese la Cedula del cliente ");
            int Cedula = v.ValidarCedulaInt(sc);
            Cliente encontrado = v.BuscarEnClientes(ListaClientes, Cedula);
            if (v.ValidarExistencia(encontrado)) {
                continue;
            }
            c.setCedula(Cedula);
            System.out.println("Ingrese el Nombre ");
            c.setNombre(v.Solotexto(sc));
            System.out.println("Ingrese el apellido ");
            c.setApellido(v.Solotexto(sc));
            System.out.println("Ingrese el telefono");
            c.setTelefono(v.ValidarEnteroPositivo(sc));
            System.out.println("Ingrese la direccion ");
            c.setDireccion(v.TextoNoVacio(sc));
            System.out.println("Tiene licencia \n 1) Si.\n 2) No.");
            int TieneLicencia = v.ValidarRango(1, 2, sc);
            if (TieneLicencia == 2) {
                System.out.println("Que el cliente vuelva cuando tenga licencia ");
                continue;
            }
            c.setLicencia(true);
            c.setContratoActivo(false);
            ListaClientes.add(c);
            System.out.println("Quiere seguir ingresando clientes?");
            System.out.println("\n 1) Si.\n 2) No.");
            int opt = v.ValidarRango(1, 2, sc);
            if (opt == 2) {
                Bandera = false;
            }
        }
        return ListaClientes;
    }

    public LinkedList<Cliente> ModificarCliente(LinkedList<Cliente> ListaClientes, Scanner sc) {
        System.out.println("Ingrese la cedula que desea modificar ");
        int ced = v.ValidarCedulaInt(sc);
        Cliente encontrado = v.BuscarEnClientes(ListaClientes, ced);
        if (v.ValidarExistencia(encontrado) == false) {
            System.out.println("Esta cedula no existe.");
            return ListaClientes;
        }
        for (Cliente cdCliente : ListaClientes) {
            if (ced == cdCliente.getCedula()) {
                System.out.println("Que desea modificar? ");
                System.out.println("1) Nombre ");
                System.out.println("2) Apellido ");
                System.out.println("3) Telefono ");
                System.out.println("4) Direccion ");
                System.out.println("5) Si tiene licencia ");
                System.out.println("6) Cedula ");
                int opt = v.ValidarRango(1, 6, sc);
                switch (opt) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre ");
                        String NuevoNombre = v.Solotexto(sc);
                        cdCliente.setNombre(NuevoNombre);
                        System.out.println("CAMBIO EXITOSO");
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo apellido ");
                        String NuevoApellido = v.Solotexto(sc);
                        cdCliente.setApellido(NuevoApellido);
                        System.out.println("CAMBIO EXITOSO");
                        break;
                    case 3:
                        System.out.println("Ingrese el nuevo telefono ");
                        int NuevoTelefono = v.ValidarEnteroPositivo(sc);
                        cdCliente.setTelefono(NuevoTelefono);
                        System.out.println("CAMBIO EXITOSO");
                        break;
                    case 4:
                        System.out.println("Ingrese la nueva direccion ");
                        String NuevaDireccion = v.TextoNoVacio(sc);
                        cdCliente.setDireccion(NuevaDireccion);
                        System.out.println("CAMBIO EXITOSO");
                        break;
                    case 5:
                        System.out.println("Está seguro que la persona no tiene licencia? ");
                        System.out.println("\n 1) Si.\n 2) No.");
                        int seg = v.ValidarRango(1, 2, sc);
                        if (seg == 1) {
                            cdCliente.setLicencia(false);
                            System.out.println("CAMBIO EXITOSO");
                        } else {
                            System.out.println("Entonces preguntele no joda");
                        }
                        break;
                    default:
                        System.out.println("Ingrese la cedula nueva: ");
                        int CedulaNueva = v.ValidarCedulaInt(sc);
                        Cliente clienteduplicado = v.BuscarEnClientes(ListaClientes, CedulaNueva);
                        if (clienteduplicado != null) {
                            System.out.println("No se puede repetir cedulas. Ya existe un cliente con esta cedula ");
                            break;
                        }
                        cdCliente.setCedula(CedulaNueva);
                        System.out.println("CAMBIO EXITOSO");
                        break;
                }
            }
        }
        return ListaClientes;
    }

    public LinkedList<Cliente> EliminarCliente(LinkedList<Cliente> ListaClientes,
            LinkedList<ContratoRenting> ListaContratos, Scanner sc, LinkedList<Vehiculo> ListaVehiculos) {
        System.out.println("Ingrese la cedula que desea eliminar ");
        int ced = v.ValidarCedulaInt(sc);
        Cliente encontrado = v.BuscarEnClientes(ListaClientes, ced);
        if (v.ValidarExistencia(encontrado) == false) {
            System.out.println("Esta cedula no existe.");
            return ListaClientes;
        }
        if (encontrado.isContratoActivo()) {
            System.out.println(
                    "No se puede eliminar porque tiene un contrato activo. Desea eliminar el contrato? \n 1) Si. \n 2). No ");
            int opt = v.ValidarRango(1, 2, sc);
            if (opt == 1) {
                GestionContratos gc = new GestionContratos();
                gc.FinalizarContrato(ListaContratos, ListaVehiculos, sc, ListaClientes);
            } else {
                return ListaClientes;
            }
        }
        ListaClientes.removeIf(c -> ced == c.getCedula());
        ListaContratos.removeIf(cont -> ced == cont.getCedulaCliente());
        return ListaClientes;
    }

    public void BuscarCliente(LinkedList<Cliente> ListaClientes, Scanner sc) {
        System.out.println("Ingrese la cedula que desea ver su informacion ");
        int ced = v.ValidarCedulaInt(sc);
        Cliente encontrado = v.BuscarEnClientes(ListaClientes, ced);
        if (v.ValidarExistencia(encontrado) == false) {
            System.out.println("Esta cedula no existe.");
            return;
        }
        for (Cliente cliente : ListaClientes) {
            if (ced == cliente.getCedula()) {
                System.out.println("Cedula: " + cliente.getCedula());
                System.out.println("Nombre Completo: " + cliente.getNombre() + " " + cliente.getApellido());
                System.out.println("Telefono: " + cliente.getTelefono());
                System.out.println("Direccion " + cliente.getDireccion());
            }
        }
    }
}
