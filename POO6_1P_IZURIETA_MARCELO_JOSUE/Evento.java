
import java.util.list;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Evento {
private String fecha;
private Residencia ubicacion;
private String nombreEvento;
private int visitantes;
private List<Visitantes> visitantesEsperados;
    
    // costructor
    
    public Evento(String fecha, Residencia ubicacion, String nombreEvento, List<Visitantes> visitantesEsperados) {
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

    public List<Visitantes> getVisitantesEsperados() {
        return visitantesEsperados;
    }

    public void setVisitantesEsperados(<any> visitantesEsperados) {
        this.visitantesEsperados = visitantesEsperados;
    }
    
    
    public void agregarVisitante(Visitantes visitante) {
        visitantesEsperados.add(visitante);
        visitantes++; 
    }
    public void guardarEvento() {
        try (FileWriter writer = new FileWriter("Evento.txt", true)) {
            writer.write(fecha + "," + ubicacion.getDireccion() + "," + nombreEvento + "," + visitantes + "\n");
        } catch (IOException e) {
            System.err.println("Error al guardar el evento: " + e.getMessage());
        }    

}}
