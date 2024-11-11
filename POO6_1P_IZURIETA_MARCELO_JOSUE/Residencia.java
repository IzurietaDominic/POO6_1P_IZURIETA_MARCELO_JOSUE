
import java.util.ArrayList;
import java.util.List;
public class Residencia {
    private String villa;
    private int manzana;
    private List<Residentes> residentes;
    private List<Contactos> contactos;
    private List<Vehiculos> vehiculos;

    public Residencia(String villa, int manzana) {
        this.villa = villa;
        this.manzana = manzana;
        this.residentes = new ArrayList<>();
        this.contactos = new ArrayList<>();
        this.vehiculos = new ArrayList<>(); }

    public Residencia(String villa, int manzana, List<Residentes> residentes, List<Contactos> contactos, List<Vehiculos> vehiculos) {
        this.villa = villa;
        this.manzana = manzana;
        this.residentes = residentes;
        this.contactos = contactos;
        this.vehiculos = vehiculos;
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

    public List<Residentes> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Residentes> residentes) {
        this.residentes = residentes;
    }

    public List<Contactos> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contactos> contactos) {
        this.contactos = contactos;
    }

    public List<Vehiculos> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculos> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    // funciones personalizadas de la clase residencia 
    
     public void agregarContacto(Contactos c) {
        contactos.add(c);
    }

    public void registrarEvento(Eventos e) {
        
    }

    public void agregarVehiculo(Vehiculos v) {
        vehiculos.add(v);
    }

    public void guardarContacto() {
        
    }




}
