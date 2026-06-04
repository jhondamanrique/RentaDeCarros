import java.util.LinkedList;
import java.util.Scanner;

public class GestionContratos {
    Validaciones v = new Validaciones();

    public LinkedList<ContratoRenting> RegistrarContrato(LinkedList<Cliente> ListaClientes,
            LinkedList<Vehiculo> ListaVehiculos, LinkedList<ContratoRenting> ListaContratos, Scanner sc) {
        boolean continuar = true;
        while (continuar) {
            ContratoRenting o = new ContratoRenting();
            System.out.println("Ingrese el ID del contrato (solo numeros) ");
            int IdContrato = v.ValidarEnteroPositivo(sc);
            ContratoRenting ContratoEncontrado = v.BuscarEnContratos(ListaContratos, IdContrato);
            if (v.ValidarExistencia(ContratoEncontrado)) {
                continue;
            }
            o.setIdContrato(IdContrato);
            System.out.println("Ingrese la cedula del cliente ");
            int Cedula = v.ValidarCedulaInt(sc);
            Cliente ClienteEncontrado = v.BuscarEnClientes(ListaClientes, Cedula);
            if (v.ValidarExistencia(ClienteEncontrado)) {
                if (v.ContratoActivo(ClienteEncontrado.isContratoActivo())) {
                    continue;
                }
            }
            o.setCedulaCliente(Cedula);
            System.out.println("Ingrese la placa del vehiculo ");
            String Placa = v.TextoAlfanumerico(sc);
            Vehiculo VehiculoEncontrado = v.BuscarEnVehiculos(ListaVehiculos, Placa);
            if (v.ValidarExistencia(VehiculoEncontrado)) {
                if (v.ContratoActivo(VehiculoEncontrado.isContratoActivo())) {
                    continue;
                }
            }
            o.setPlacaVehiculo(Placa);
            VehiculoEncontrado.setContratoActivo(true);
            o.setValorTotal(v.AsignacionFechas(o, VehiculoEncontrado.getPrecioDiario(), 1));
            ListaContratos.add(o);
            System.out.println("Quiere seguir ingresando contratos?");
            System.out.println("\n 1) Si.\n 2) No.");
            int opt = v.ValidarRango(1, 2, sc);
            if (opt == 2) {
                continuar = false;
            }
        }
        return ListaContratos;
    }

    public LinkedList<ContratoRenting> ModificarContrato(LinkedList<ContratoRenting> ListaContratos,
            LinkedList<Cliente> ListaClientes, LinkedList<Vehiculo> ListaVehiculos, Scanner sc) {
        boolean Control = true;
        Vehiculo VehiculoEncontrado = null;

        while (Control) {
            System.out.println("Que contrato desea modificar ");
            int Contrato = v.ValidarEnteroPositivo(sc);
            for (ContratoRenting c : ListaContratos) {
                if (Contrato == c.getIdContrato()) {
                    System.out.println("Que desea modificar del contrato? ");// SI SE CAMBIA EL FORMATO DE LAS FECHAS,
                                                                             // QUITAR EL TOTAL DE DIAS Y VALOR TOTAL
                    System.out.println(" 1. Cliente \n 2. Placa Vehiculo \n 3. Fechas \n 4. ID Contrato");
                    int Cambio = v.ValidarRango(1, 4, sc);
                    switch (Cambio) {
                        case 1:
                            System.out.println("Ingrese la cedula que va a cambiar ");
                            int Cedula = v.ValidarCedulaInt(sc);
                            Cliente encontrado = v.BuscarEnClientes(ListaClientes, Cedula);
                            if (encontrado != null) {
                                System.out.println("Ingrese la cedula nueva: ");
                                int CedulaNueva = v.ValidarCedulaInt(sc);
                                Cliente clienteduplicado = v.BuscarEnClientes(ListaClientes, CedulaNueva);
                                if (v.ContratoActivo(clienteduplicado.isContratoActivo())) {
                                    continue;
                                }
                                if (clienteduplicado != null) {
                                    System.out.println(
                                            "No se puede repetir cedulas. Ya existe un cliente con esta cedula ");
                                    break;
                                }
                                c.setCedulaCliente(CedulaNueva);
                                System.out.println("CAMBIO EXITOSO");
                                Control = false;
                            }
                            break;

                        case 2:
                            System.out.println("Ingrese la Placa a cambiar: ");
                            String Placa = v.TextoAlfanumerico(sc);
                            VehiculoEncontrado = v.BuscarEnVehiculos(ListaVehiculos, Placa);
                            if (VehiculoEncontrado != null) {
                                System.out.println("Ingrese la Placa nueva: ");
                                String PlacaNueva = v.TextoAlfanumerico(sc);
                                Vehiculo placaduplicada = v.BuscarEnVehiculos(ListaVehiculos, PlacaNueva);
                                if (v.ContratoActivo(placaduplicada.isContratoActivo())) {
                                    continue;
                                }
                                if (placaduplicada != null) {
                                    System.out
                                            .println("No puede repetir Placas, Ya existe un vehiculo con esta placa ");
                                    break;
                                }
                                c.setPlacaVehiculo(PlacaNueva);
                                System.out.println("CAMBIO EXITOSO");
                                Control = false;
                            } else {
                                System.out.println("Escriba una Placa correcta");
                            }
                            break;

                        case 3:
                            c.setValorTotal(v.AsignacionFechas(c, VehiculoEncontrado.getPrecioDiario(), 2));
                            System.out.println("El valor total se ha cambiado por el cambio de fechas");
                            Control = false;
                            break;

                        default:
                            System.out.println("Ingrese la cedula nueva: ");
                            int ContratoNuevo = v.ValidarEnteroPositivo(sc);
                            ContratoRenting contratoduplicado = v.BuscarEnContratos(ListaContratos, ContratoNuevo);
                            if (contratoduplicado != null) {
                                System.out
                                        .println("No se puede repetir cedulas. Ya existe un cliente con esta cedula ");
                                break;
                            }
                            c.setIdContrato(ContratoNuevo);
                            break;
                    }
                } else {
                    System.out.println("Ese contrato no existe");
                }
            }
        }
        return ListaContratos;
    }

    public LinkedList<ContratoRenting> FinalizarContrato(LinkedList<ContratoRenting> ListaContratos,
            LinkedList<Vehiculo> ListaVehiculos, Scanner sc, LinkedList<Cliente> ListaClientes) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Ingrese el contrato a finalizar ");
            int Contrato = v.ValidarEnteroPositivo(sc);
            ContratoRenting encontrado = v.BuscarEnContratos(ListaContratos, Contrato);
            if (encontrado != null) {
                Cliente C = v.BuscarEnClientes(ListaClientes, encontrado.getCedulaCliente());
                Vehiculo V = v.BuscarEnVehiculos(ListaVehiculos, encontrado.getPlacaVehiculo());
                if (C != null)
                    C.setContratoActivo(false);
                if (V != null)
                    V.setContratoActivo(false);
                ListaContratos.removeIf(cont -> Contrato == cont.getIdContrato());
                System.out.println("CONTRATO ELIMINADO");
                continuar = false;
            } else {
                System.out.println("Contrato no encontrado, intente de nuevo");
            }
        }
        return ListaContratos;
    }

    public void BuscarContrato(LinkedList<ContratoRenting> ListaContratos, Scanner sc,
            LinkedList<Cliente> ListaClientes) {
        System.out.println("Ingrese el ID del contrato que desea mirar su informacion ");
        int IdContrato = v.ValidarEnteroPositivo(sc);
        ContratoRenting contrato = v.BuscarEnContratos(ListaContratos, IdContrato);
        boolean continuar = true;
        while (continuar) {

            if (contrato != null) {

                Cliente cliente = v.BuscarEnClientes(ListaClientes, contrato.getCedulaCliente());
                System.out.println("ID de contrato: " + contrato.getIdContrato());
                System.out.println("ID de cliente " + contrato.getCedulaCliente());

                if (cliente != null) {
                    System.out.println("Nombre de cliente: " + cliente.getNombre() + " " + cliente.getApellido());
                } else {
                    System.out.println("Nombre de cliente: [Cliente no registrado]");
                }

                System.out.println("Vehiculo con placa: " + contrato.getPlacaVehiculo());
                System.out.println("Inicio del Renting: " + contrato.getFechaInicio());
                System.out.println("Fin del Renting: " + contrato.getFechaFin());
                System.out.println("Dias del Renting: " + contrato.getTotalDias());
                System.out.println("Valor del Renting: " + contrato.getValorTotal());

                continuar = false;
            } else {
                System.out.println("Contrato no encontrado, intente de nuevo");
            }
        }
    }
}

