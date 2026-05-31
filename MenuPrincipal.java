public class MenuPrincipal {
    private Validaciones v = new Validaciones();
    public void mostrarMenuPrincipal(){
        int opcion;
        do{
            System.out.println("===== SISTEMA RENTING CARROS =====");
            System.out.println("1. Gestión clientes");
            System.out.println("2. Gestión vehículos");
            System.out.println("3. Gestión contratos");
            System.out.println("4. Informe general");
            System.out.println("5. Salir");
            opcion = v.leerNumero();
            switch(opcion){
                case 1:
                    System.out.println("Gestión clientes");
                    break;
                case 2:
                    System.out.println("Gestión vehículos");
                    break;
                case 3:
                    System.out.println("Gestión contratos");
                    break;
                case 4:
                    System.out.println("Informe");
                    break;
                case 5:
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }while(opcion != 5);
    }
}