

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Evento {
private String fecha;
private Residencia ubicacion;
private String nombreEvento;
private int visitantes;
private List<Visitante> visitantesEsperados;
    
    // costructor
    
    public Evento(String fecha, Residencia ubicacion, String nombreEvento, List<Visitante> visitantesEsperados) {
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.nombreEvento = nombreEvento;
        this.visitantesEsperados = visitantesEsperados;
        this.visitantes = 0; 
}

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Residencia getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Residencia ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public int getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(int visitantes) {
        this.visitantes = visitantes;
    }

    public List<Visitante> getVisitantesEsperados() {
        return visitantesEsperados;
    }

    public void setVisitantesEsperados(List<Visitante> visitantesEsperados) {
    if (visitantesEsperados == null) {
        this.visitantesEsperados = new ArrayList<>();
    } else {
        this.visitantesEsperados = visitantesEsperados;
    }
}
    
    
    public void agregarVisitante(Visitante visitante) {
        visitantesEsperados.add(visitante);
        visitantes++; 
    }
    //*Guardar Evento */
    public void guardarEvento() {
        try (FileWriter writer = new FileWriter("Evento.txt", true)) {
            // Guardar los detalles del evento
            writer.write("Fecha: " + fecha + "\n");
            writer.write("Ubicación: " + ubicacion.getUbicacion() + "\n");
            writer.write("Nombre del Evento: " + nombreEvento + "\n");
            writer.write("Visitantes esperados: " + visitantes + "\n");
    
            // Guardar los detalles de los visitantes
            if (visitantesEsperados != null && !visitantesEsperados.isEmpty()) {
                for (Visitante visitante : visitantesEsperados) {
                    writer.write("Visitante: " + visitante.getNombre() + "\n");
                    writer.write("Documento de Identidad: " + visitante.getDocumentoIdentidad() + "\n");
                    writer.write("Teléfono: " + visitante.getTelefono() + "\n");
                    writer.write("Residencia de Destino: " + 
                                 (visitante.getResidenciaDestino() != null ? visitante.getResidenciaDestino().getVilla() : "No asignada") + "\n");
                    writer.write("Autorizado: " + (visitante.isAutorizado() ? "Sí" : "No") + "\n");
                    writer.write("--------------\n"); // Separador entre visitantes
                }
            }
    
            writer.write("--------------\n"); // Separador entre eventos
        } catch (IOException e) {
            System.err.println("Error al guardar el evento: " + e.getMessage());
        }
    }
}
