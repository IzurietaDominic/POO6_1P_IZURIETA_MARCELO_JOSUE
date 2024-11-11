import java.io.*;
import java.util.*;

public class Ciudadela {
    private String nombre;
    private List<Etapa> etapas;
    // private String archivoEtapas;

    // * Constructor que inicializa el nombre de la ciudadela y el archivo de
    // etapas*/
    public Ciudadela(String nombre) {
        this.nombre = nombre;
        this.etapas = new ArrayList<>();
        // this.archivoEtapas = archivoEtapas;
    }

    // *Getter de nombre*/
    public String getNombre() {
        return nombre;
    }

    // *Getter de Etapas */
    public List<Etapa> getEtapas() {
        return etapas;
    }

    // *Getter de ArchivoEtapas */
    /*
     * public String getArchivoEtapas() {
     * return archivoEtapas;
     * }
     * //*Setter de nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // *Setter de Etapas */
    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    // *Setter de ArchivoEtapas */
    /*
     * public void setArchivoEtapas(String archivoEtapas) {
     * this.archivoEtapas = archivoEtapas;
     * }
     * 
     * 
     * //* Metodo para agregar una nueva etapa a la lista de etapas de la ciudadela
     */
    public void AgregarEtapa(Etapa e) {
        etapas.add(e); // Añade el objeto 'e' (de tipo Etapa) a la lista 'etapas'
    }

    // Metodo para buscar una etapa por su nombre
    public Etapa BuscarEtapa(String nombre) {
        // Recorre todas las etapas en la lista 'etapas'
        for (Etapa etapa : etapas) {
            // Si el nombre de la etapa coincide con el nombre proporcionado
            if (etapa.getNombre().equals(nombre)) {
                return etapa; // Retorna la etapa encontrada
            }
        }
        return null;
    }
    
    // Metodo para guardar todas las etapas en el archivo especificado por
    // 'archivoEtapas'
    public void GuardarEtapa() {
        int n = 1;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("etapas.txt", true))) {
            // Recorre todas las etapas en la lista 'etapas'
            for (Etapa etapa : etapas) {
                writer.write("Etapa"+n+":"+ etapa.getNombre());
                writer.newLine();
                writer.write("Ubicación: " + etapa.getUbicacion());
                writer.newLine();
                writer.write("Descripción: " + etapa.getDescripcion()); 
                writer.newLine();
                writer.write("-----------------------------------------"); 
                writer.newLine();
                n ++;
            }
        } catch (IOException e) {
            System.out.println("Error al guardar las etapas."); 
                                                            
        }
    }

    // *Equals para comparar objeto de tipo ciudadela */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Ciudadela ciudadela = (Ciudadela) obj;
        return Objects.equals(nombre, ciudadela.nombre) &&
                Objects.equals(etapas, ciudadela.etapas);
        // Objects.equals(archivoEtapas, ciudadela.archivoEtapas);
    }

    // *toString de ciudadela */
    public String toString() {
        return "Ciudadela{" +
                "nombre='" + nombre + '\'' +
                // ", archivoEtapas='" + archivoEtapas + '\'' +
                ", etapas=" + etapas +
                '}';
    }

    // *hashCode de ciudadela */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, etapas);
    }



    public void cargarEtapasDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("etapas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("Etapa")) {  // Asegúrate de que el archivo contiene una identificación para cada etapa
                    String nombreEtapa = linea.split(":")[1].trim(); // Obtener el nombre de la etapa
                    String ubicacion = reader.readLine().split(":")[1].trim(); // Leer ubicación
                    String descripcion = reader.readLine().split(":")[1].trim(); // Leer descripción
                    Etapa etapa = new Etapa(nombreEtapa, ubicacion, descripcion);
                    etapas.add(etapa);  
                    reader.readLine(); // Leer la línea separadora
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar las etapas.");
            e.printStackTrace();
        }
    }


    

    
}
