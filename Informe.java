import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Informe {
    
    public static void ImprimirInforme(LinkedList<Cliente> clientes, LinkedList<Vehiculo> vehiculos, LinkedList<ContratoRenting> contratos) {

        try {
            FileWriter archivo = new FileWriter("InformeGeneralRenting.txt");
            PrintWriter escribir = new PrintWriter(archivo);

            escribir.println("=========================================================");
            escribir.println("         INFORME GENERAL - SISTEMA RENTING DE CARROS");
            escribir.println("=========================================================\n");

            // ===================== CLIENTES =====================
            escribir.println("--------------- CLIENTES REGISTRADOS ----------------");
            escribir.println("Total clientes: " + clientes.size());
            escribir.println("");

            if (clientes.isEmpty()) {
                escribir.println("No hay clientes registrados.\n");
            } else {
                for (Cliente c : clientes) {
                    escribir.println(c.toString());
                }
                escribir.println("");
            }

            // ===================== VEHICULOS =====================
            escribir.println("--------------- VEHICULOS REGISTRADOS ----------------");
            escribir.println("Total vehiculos: " + vehiculos.size());
            escribir.println("");

            if (vehiculos.isEmpty()) {
                escribir.println("No hay vehiculos registrados.\n");
            } else {
                for (Vehiculo v : vehiculos) {
                    escribir.println(v.toString());
                }
                escribir.println("");
            }

            // ===================== CONTRATOS =====================
            escribir.println("--------------- CONTRATOS REGISTRADOS ----------------");
            escribir.println("Total contratos: " + contratos.size());
            escribir.println("");

            if (contratos.isEmpty()) {
                escribir.println("No hay contratos registrados.\n");
            } else {
                for (ContratoRenting cr : contratos) {
                    escribir.println(cr.toString());
                }
                escribir.println("");
            }

            escribir.println("=========================================================");
            escribir.println("                 FIN DEL INFORME GENERAL");
            escribir.println("=========================================================");

            escribir.close();

            System.out.println("\n Informe generado correctamente en el archivo:");
            System.out.println(" InformeGeneralRenting.txt");

        } catch (Exception e) {
            System.out.println("Error al generar el archivo: " + e.getMessage());
        }
    }
}