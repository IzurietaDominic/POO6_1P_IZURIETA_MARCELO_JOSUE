import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class RegistroVisitantes {
    // Suponemos que tienes una lista o alguna otra estructura para almacenar los eventos
    private List<Evento> eventos = new ArrayList<>();

    public void registrarVisitantes() {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Ingrese la fecha del evento (dd/mm/aaaa): ");
        String fechaEvento = scanner.nextLine();

      
        List<Evento> eventosDelDia = buscarEventosPorFecha(fechaEvento);
        if (eventosDelDia.isEmpty()) {
            System.out.println("No hay eventos programados para esa fecha.");
            return;
        }
        System.out.println("Eventos encontrados:");
        for (int i = 0; i < eventosDelDia.size(); i++) {
            System.out.println(i + 1 + ". " + eventosDelDia.get(i).getNombre());
        }

       
        System.out.print("Ingrese el número del evento: ");
        int indiceEvento = scanner.nextInt() - 1;
        Evento eventoSeleccionado = eventosDelDia.get(indiceEvento);

        // 4. Mostrar información del evento
        System.out.println("Información del evento:");
        System.out.println(eventoSeleccionado.toString());

        // 5. Registrar visitantes
        List<Visitante> visitantes = new ArrayList<>();
        System.out.println("Ingrese los datos de los visitantes:");
        while (true) {
            Visitante visitante = new Visitante();
            
            visitantes.add(visitante);

            System.out.print("¿Desea ingresar otro visitante? (s/n): ");
            if (!scanner.next().equalsIgnoreCase("s")) {
                break;
            }
        }

        
        guardarVisitantesEnArchivo(visitantes, "visitantesEsperados.txt");
    }

    
    private List<Evento> buscarEventosPorFecha(String fechaBuscada) {
    List<Evento> eventosEncontrados = new ArrayList<>();
    for (Evento evento : eventos) {
        if (evento.getFecha().equals(fechaBuscada)) {
            eventosEncontrados.add(evento);
        }
    }
    return eventosEncontrados;
}

   
    private void guardarVisitantesEnArchivo(List<Visitante> visitantes, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            // Escribir la información de cada visitante en el archivo
            for (Visitante visitante : visitantes) {
                writer.println(visitante.toString());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
}
