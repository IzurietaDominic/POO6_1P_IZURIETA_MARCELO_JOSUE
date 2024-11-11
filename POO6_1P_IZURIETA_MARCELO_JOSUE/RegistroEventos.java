import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;   


public class RegistroEventos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Ingrese   
 el nombre del evento: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la ubicación de la residencia: ");
        String ubicacion = scanner.nextLine();

        System.out.print("Ingrese la fecha del evento (dd/MM/yyyy): ");
        try {
            Date fecha = sdf.parse(scanner.nextLine());

            System.out.print("Ingrese la cantidad de personas esperadas: ");
            int numPersonas = scanner.nextInt();

            Evento evento = new Evento(nombre, ubicacion, fecha, numPersonas);

            try (FileWriter writer = new FileWriter("eventos.txt", true)) {
                writer.write(evento.toString() + "\n");
                System.out.println("Evento registrado exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Fecha inválida. Por favor, ingrese la fecha en formato dd/MM/yyyy");
        }
    }
}
