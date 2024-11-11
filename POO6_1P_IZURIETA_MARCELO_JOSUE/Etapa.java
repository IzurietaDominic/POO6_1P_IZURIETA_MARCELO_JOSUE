import java.io.*;
import java.util.*;



public class Etapa {
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private List<Residencia> residencias;
    private List<Evento> eventos;

    //*Constructor de Etapa */
    public Etapa(String nombre, String ubicacion, String descripcion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.residencias = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }


    //*Agregar residencia a Etapa */
    public void AgregarResidencia(Residencia r) {
        residencias.add(r);
    }
    //*Agregar un evento a la etapa */
    public void registrarEvento(Evento evento) {
        eventos.add(evento);
    }

    //*Guardar Residencia en Etapa */
    public void guardarResidencias() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("residencias.txt",true))) {
            for (Residencia residencia : residencias) {
                writer.write("Nombre de la villa: " + residencia.getVilla());
                writer.newLine();
                writer.write("numero de Manzana: " + residencia.getManzana());
                writer.newLine();
                writer.write("ubicacion: " + residencia.getUbicacion());
                writer.newLine();
                writer.write("----");  // Separador entre residencias
                writer.newLine();
            }
            //System.out.println("Residencias guardadas en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar las residencias");
            e.printStackTrace();
        }
    }


    //*Buscar residencia por nombre */
    public Residencia BuscarResidencia(String villa) {
        for (Residencia residencia : residencias) {
            if (residencia.getVilla().equals(villa)) {
                return residencia;
            }
        }
        return null;
    }
    //*Buscar eventos por fecha especifica */
    public List<Evento> buscarEventosPorFecha(String fecha) {
        List<Evento> eventosFecha = new ArrayList<>();
        for (Evento evento : eventos) {
            if (evento.getFecha().equals(fecha)) {
                eventosFecha.add(evento);
            }
        }
        return eventosFecha;
    }


    

    
    //*Equals de Etapa  */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etapa etapa = (Etapa) o;
        return Objects.equals(nombre, etapa.nombre) &&
               Objects.equals(ubicacion, etapa.ubicacion) &&
               Objects.equals(descripcion, etapa.descripcion);
    }

    //*Hashcode de Etapa */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, ubicacion, descripcion);
    }

    //*toString de Etapa */
    @Override
    public String toString() {
        return "Etapa{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }


   

    //*Getter de Nombre */
    public String getNombre() {
        return nombre;
    }
    //*Getter de ubicacion */
    public String getUbicacion() {
        return ubicacion;
    }
    //*Getter de Descripcion */
    public String getDescripcion() {
        return descripcion;
    }

    public List<Residencia> getResidencias() {
        return residencias;
    }


    //*Setter de Nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //*Setter de ubicacion */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    //*Setter de Descripcion */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



public void cargarResidenciasDesdeArchivo() {
    try (BufferedReader br = new BufferedReader(new FileReader("residencias.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("Nombre de la villa:")) {
                String villa = line.substring(line.indexOf(":") + 1).trim();

                line = br.readLine();
                int manzana = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());

                line = br.readLine();
                String ubicacion = line.substring(line.indexOf(":") + 1).trim();

                // Crear una nueva instancia de Residencia con los datos leídos
                Residencia residencia = new Residencia(villa, ubicacion, manzana);
                this.residencias.add(residencia); // Agregar la residencia a la lista
            }

            // Saltar el separador si existe (----)
            br.readLine();
        }
    } catch (IOException e) {
        System.out.println("Error al cargar residencias desde el archivo: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error en el formato del archivo de residencias: " + e.getMessage());
    }
}

    





    


}

