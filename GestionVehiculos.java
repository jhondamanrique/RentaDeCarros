import java.util.LinkedList;
import java.util.Scanner;

public class GestionVehiculos {
    Validaciones v = new Validaciones();

    public LinkedList<Vehiculo> RegistrarVehiculo(LinkedList<Vehiculo> ListaVehiculos, Scanner sc) {

        boolean continuar = true;
        int choice = 0;
        while (continuar) {

            System.out.println("Ingrese la placa del vehiculo ");
            String Placa = v.TextoAlfanumerico(sc);
            Vehiculo VehiculoEncontrado = v.BuscarEnVehiculos(ListaVehiculos, Placa);
            if (v.ValidarExistencia(VehiculoEncontrado)) {
                continue;
            }
            System.out.println("Ingrese la marca ");
            String Marca = v.TextoNoVacio(sc);
            System.out.println("Ingrese el modelo");
            int Modelo = v.ValidarEnteroPositivo(sc);
            System.out.println("Ingrese el precio diario del vehiculo ");
            float PrecioDiario = v.ValidarDecimalPositivo(sc);
            boolean ContratoActivo = false;
            System.out.println("Que está ingresando\n 1) Carro Sedan \n 2) Camioneta SUV");
            int opt = v.ValidarRango(1, 2, sc);
            Vehiculo NuevoVehiculo = null;

            switch (opt) {
                case 1:
                    System.out.println("Ingrese el tipo de combustible ");
                    String TipoCombustible = v.TextoNoVacio(sc);
                    System.out.println("Ingrese el tipo de transmision ");
                    String Transmision = v.TextoNoVacio(sc);
                    NuevoVehiculo = new CarroSedan(Placa, Marca, Modelo, PrecioDiario, ContratoActivo, TipoCombustible,
                            Transmision);
                    System.out.println("Quiere seguir ingresando vehiculos? \n 1) Si \n 2) No");
                    choice = v.ValidarRango(1, 2, sc);
                    if (choice == 2) {
                        continuar = false;
                    }
                    break;

                default:
                    System.out.println("Ingrese el tipo de traccion ");
                    String Traccion = v.TextoAlfanumerico(sc);
                    System.out.println("Ingrese la capacidad de maletero ");
                    int capacidad = v.ValidarEnteroPositivo(sc);
                    NuevoVehiculo = new CamionetaSUV(Placa, Marca, Modelo, PrecioDiario, ContratoActivo, Traccion,
                            capacidad);
                    System.out.println("Quiere seguir ingresando vehiculos? \n 1) Si \n 2) No");
                    choice = v.ValidarRango(1, 2, sc);
                    if (choice == 2) {
                        continuar = false;
                    }
                    break;
            }
            if (NuevoVehiculo != null) {
                ListaVehiculos.add(NuevoVehiculo);
                System.out.println("Vehiculo ingresado");
            } else {
                System.out.println("El vehiculo no ha sido ingresado por datos nulos");
            }

            System.out.println("Quiere seguir ingresando vehiculos? \n 1) Si \n 2) No");
            choice = v.ValidarRango(1, 2, sc);
            if (choice == 2) {
                continuar = false;
            }
        }
        return ListaVehiculos;
    }

    public LinkedList<Vehiculo> ModificarVehiculo(LinkedList<Vehiculo> ListaVehiculos, Scanner sc) {
        boolean Control = true;
        Vehiculo VehiculoEncontrado = null;
        while (Control) {
            System.out.println("Ingrese la placa del vehiculo que desea modificar ");
            String Placa = v.TextoAlfanumerico(sc);
            VehiculoEncontrado = v.BuscarEnVehiculos(ListaVehiculos, Placa);
            if (v.ValidarExistencia(VehiculoEncontrado) == false) {
                System.out.println("El vehiculo no está en la lista ");
                continue;
            }
            for (Vehiculo carro : ListaVehiculos) {
                if (Placa.equalsIgnoreCase(carro.getPlaca())) {
                    System.out.println("Que desea modificar del vehiculo? ");
                    System.out.println(
                            " 1. Marca \n 2. Modelo \n 3. Precio diario \n 4. Atributos específicos \n 5. Placa");

                    int Cambio = v.ValidarRango(1, 5, sc);
                    switch (Cambio) {
                        case 1:
                            System.out.println("Ingrese la Marca: ");
                            String Marca = v.TextoNoVacio(sc);
                            carro.setMarca(Marca);
                            break;

                        case 2:
                            System.out.println("Ingrese el Modelo: ");
                            int Modelo = v.ValidarEnteroPositivo(sc);
                            carro.setModelo(Modelo);
                            break;

                        case 3:
                            System.out.println("Ingrese el Precio diario: ");
                            float Precio = v.ValidarDecimalPositivo(sc);
                            carro.setPrecioDiario(Precio);
                            break;

                        case 4:
                            if (carro instanceof CarroSedan) {
                                CamionetaSUV SUV = (CamionetaSUV) carro;
                                System.out.println("Modificando SUV");
                                System.out.println("Ingrese el tipo de traccion ");
                                SUV.setTipoTraccion(v.TextoNoVacio(sc));
                                System.out.println("Ingrese la capacidad del maletero ");
                                SUV.setCapacidadMaletero(v.ValidarEnteroPositivo(sc));
                            } else {
                                CarroSedan Sedan = (CarroSedan) carro;
                                System.out.println("Modificando Sedan");
                                System.out.println("Ingrese el tipo de combustible ");
                                Sedan.setTipoCombustible(v.TextoAlfanumerico(sc));
                                System.out.println("Ingrese el tipo de transmision ");
                                Sedan.setTransmision(v.TextoNoVacio(sc));
                            }
                            break;

                        default:
                            System.out.println("Ingrese la placa nueva: ");
                            String PlacaNueva = v.TextoAlfanumerico(sc);
                            Vehiculo placaduplicada = v.BuscarEnVehiculos(ListaVehiculos, PlacaNueva);
                            if(placaduplicada != null){
                                System.out.println("No se puede repetir cedulas. Ya existe un cliente con esta cedula ");
                                break;}
                            carro.setPlaca(PlacaNueva);
                            break;
                    }
                }
            }
        }
        return ListaVehiculos;
    }

    public LinkedList<Vehiculo> EliminarVehiculo(LinkedList<Vehiculo> ListaVehiculos,
            LinkedList<ContratoRenting> ListaContratos, Scanner sc, LinkedList<Cliente> ListaClientes) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Ingrese la placa del vehiculo a eliminar ");
            String Placa = v.TextoAlfanumerico(sc);
            Vehiculo encontrado = v.BuscarEnVehiculos(ListaVehiculos, Placa);
            if (encontrado != null) {
                if (encontrado.isContratoActivo()){
                    System.out.println("No se puede eliminar porque tiene un contrato activo. Desea eliminar el contrato? \n 1) Si. \n 2). No ");
                    int opt = v.ValidarRango(1, 2, sc);
                    if (opt == 1){
                        GestionContratos gc = new GestionContratos();
                        gc.FinalizarContrato(ListaContratos, ListaVehiculos, sc, ListaClientes);
                    }
                    else{
                        return ListaVehiculos;
                    }
                }
                ListaVehiculos.removeIf(v -> Placa.equalsIgnoreCase(v.getPlaca()));
                System.out.println("VEHICULO ELIMINADO");
                continuar = false;
            } else {
                System.out.println("Contrato no encontrado, intente de nuevo");
            }
        }
        return ListaVehiculos;
    }

    public void BuscarVehiculo(LinkedList<Vehiculo> ListaVehiculos, Scanner sc) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese la placa del vehiculo que desea mirar su informacion ");
            String Placa = v.TextoAlfanumerico(sc);
            Vehiculo vehiculo = v.BuscarEnVehiculos(ListaVehiculos, Placa);
            if (vehiculo != null) {
                System.out.println("Marca: " + vehiculo.getMarca());
                System.out.println("Modelo: " + vehiculo.getModelo());
                System.out.println("Placa: " + vehiculo.getPlaca());
                System.out.println("Precio diario: " + vehiculo.getPrecioDiario());
                if (vehiculo instanceof CarroSedan) {
                    CamionetaSUV SUV = (CamionetaSUV) vehiculo;
                    System.out.println("Traccion: " + SUV.getTipoTraccion());
                    System.out.println("Capacidad de maletero: " + SUV.getCapacidadMaletero());
                } else {
                    CarroSedan Sedan = (CarroSedan) vehiculo;
                    System.out.println("Tipo de combustible: " + Sedan.getTipoCombustible());
                    System.out.println("Transmision: " + Sedan.getTransmision());
                }
                continuar = false;
            } else {
                System.out.println("Vehiculo no encontrado, intente de nuevo");
            }
        }
    }
}

