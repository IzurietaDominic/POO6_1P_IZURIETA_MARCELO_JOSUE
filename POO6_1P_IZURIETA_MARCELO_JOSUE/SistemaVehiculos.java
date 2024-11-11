import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SistemaVehiculos {
    // ... otras clases y variables

    public void opcion8() throws IOException {
        // Obtener la lista de vehículos de la ciudadela
        List<Vehiculo> todosLosVehiculos = ciudadela.obtenerTodosLosVehiculos();

        // Contar vehículos de visitantes y residentes
        int visitantes = contarVehiculos(todosLosVehiculos, "visitante");
        int residentes = contarVehiculos(todosLosVehiculos, "residente");

        // Crear el archivo y escribir el reporte
        FileWriter writer = new FileWriter("vehiculos.txt");
        writer.write("Reporte de Vehículos\n");
        writer.write("--------------------\n");
        writer.write("Visitantes: " + visitantes + "\n");
        writer.write("Residentes: " + residentes + "\n");
        writer.close();

        System.out.println("Reporte generado exitosamente en vehiculos.txt");
    }

    private int contarVehiculos(List<Vehiculo> vehiculos, String tipo) {
        int contador = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getTipo().equals(tipo)) {
                contador++;
            }
        }
        return contador;
    }
}
