
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Residencia {
    private String villa;
    private String ubicacion;
    private int manzana;
    private List<Residente> residentes;
    private List<Contactos> contactos;
    private List<Vehiculos> vehiculoResidente;
    private List<Evento> eventos;
    

    //*Constructor Residencia */
    public Residencia(String villa, String ubicacion,int manzana) {
        this.villa = villa;
        this.ubicacion = ubicacion;
        this.manzana = manzana;
        this.contactos = new ArrayList<>();
        this.vehiculoResidente = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }
    //*Agregar contacto a la residencia */
    public void agregarContacto(Contactos contacto) {
        contactos.add(contacto);
    }

    //*Mostrar contactos de la residencia */
    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados para esta residencia.");
        } else {
            System.out.println("Contactos de la residencia:");
            for (Contactos contacto : contactos) {
                System.out.println(contacto.toString());
            }
        }
    }
    public String getVilla() {
        return villa;
    }

    public void setVilla(String villa) {
        this.villa = villa;
    }

    public int getManzana() {
        return manzana;
    }

    public void setManzana(int manzana) {
        this.manzana = manzana;
    }

    public List<Residente> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Residente> residentes) {
        this.residentes = residentes;
    }

    public List<Contactos> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contactos> contactos) {
        this.contactos = contactos;
    }

    public List<Vehiculos> getVehiculos() {
        return vehiculoResidente;
    }

    public void setVehiculos(List<Vehiculos> vehiculoResidente) {
        this.vehiculoResidente = vehiculoResidente;
    }

    public String getUbicacion(){
        return ubicacion;
    }
    
    public void setUbicacion( String ubicacion){
        this.ubicacion = ubicacion;
    }
    // funciones personalizadas de la clase residencia 
    

    public void registrarEvento(Evento e) {
        eventos.add(e);
        
    }
    public void agregarVehiculo(Vehiculos v) {
        vehiculoResidente.add(v);
    }

    public void guardarContacto() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contactos.txt", true))) {
            for (Contactos contacto : contactos) {
                writer.write("Residencia: " + villa);
                writer.newLine();
                writer.write("Nombre: " + contacto.getNombre());
                writer.newLine();
                writer.write("Teléfono: " + contacto.getTelefono());
                writer.newLine();
                writer.write("----");
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los contactos.");
            e.printStackTrace();
        }
        
    }

    




}
