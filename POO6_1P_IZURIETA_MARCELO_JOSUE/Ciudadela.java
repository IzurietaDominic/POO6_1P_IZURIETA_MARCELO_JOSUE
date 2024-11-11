import java.io.*;
import java.util.*;


public class Ciudadela {
    private String nombre;
    private List<Etapa> etapas;
    private String archivoEtapas;

    // Constructor que inicializa el nombre de la ciudadela y el archivo de etapas
    public Ciudadela(String nombre, String archivoEtapas) {
        this.nombre = nombre; 
        this.etapas = new ArrayList<>();  
        this.archivoEtapas = archivoEtapas;  
    }

    // Metodo para agregar una nueva etapa a la lista de etapas de la ciudadela
    public void AgregarEtapa(Etapa e) {
        etapas.add(e);  // Añade el objeto 'e' (de tipo Etapa) a la lista 'etapas'
    }

    // Metodo para buscar una etapa por su nombre
    public Etapa BuscarEtapa(String nombre) {
        // Recorre todas las etapas en la lista 'etapas'
        for (Etapa etapa : etapas) {
            // Si el nombre de la etapa coincide con el nombre proporcionado
            if (etapa.getNombre().equals(nombre)) {
                return etapa;  // Retorna la etapa encontrada
            }
        }
        return null;  
    }


    // Metodo para guardar todas las etapas en el archivo especificado por 'archivoEtapas'
    public void GuardarEtapa() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoEtapas))) {
            // Recorre todas las etapas en la lista 'etapas'
            for (Etapa etapa : etapas) {
                writer.write("Etapa: "+ etapa.getNombre());  // Escribe el nombre de la etapa en el archivo
                writer.newLine();  // Añade una nueva línea después de escribir el nombre
            }
        } catch (IOException e) {
            System.out.println("Error al guardar las etapas.");  // Si ocurre un error al guardar el archivo, muestra un mensaje
        }
    }
}
