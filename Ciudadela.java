/*
 * @JosueMartinez
 */

// Importación de las clases
import java.util.List; 
import java.util.ArrayList; 
import java.io.FileWriter; 
import java.io.IOException;

//Clase Ciudadela
public class Ciudadela {

    // Atributos
    private String nombre;  // Nombre de la ciudadela
    private List<Etapa> etapas;  // Lista de etapas de la ciudadela

    // Constructor de la clase Ciudadela, que recibe un nombre y crea una lista vacía de etapas
    public Ciudadela(String nombre) {
        this.nombre = nombre;
        this.etapas = new ArrayList<>();  // Inicializa la lista de etapas
    }

    // Metodo para agregar una nueva etapa a la lista de etapas
    public void AgregarEtapa(Etapa e) {
        etapas.add(e);  // Añade la etapa a la lista
    }

    // Metodo para buscar una etapa por su nombre en la lista de etapas
    public Etapa BuscarEtapa(String n) {
        // Recorre todas las etapas en la lista
        for (Etapa e : etapas) {
            // Si el nombre de la etapa coincide con el parámetro, la retorna
            if (e.getNombre().equals(n)) {
                return e; 
            }
        }
        // Si no se encuentra ninguna etapa con ese nombre, retorna null
        return null;
    }

    // Metodo para guardar las etapas en un archivo llamado "etapas.txt"
    // El metodo guarda el nombre de cada etapa en el archivo
    public void GuardarEtapa() {
        try (FileWriter fw = new FileWriter("etapas.txt", true)) {
            // Recorre la lista de etapas
            for (Etapa e : etapas) {
                // Escribe el nombre de cada etapa en el archivo, seguido de un salto de línea
                fw.write(e.getNombre() + "\n");
            }
        } catch (IOException ex) {
            // Si ocurre un error imprime el error
            ex.printStackTrace();
        }
    }
}
