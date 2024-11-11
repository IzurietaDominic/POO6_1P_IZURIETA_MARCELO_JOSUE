import java.io.*;
import java.util.*;

public class Residencia {
    private String villa;
    private int manzana;
    private int numerocasa;
    private List<Contactos> contactos;
    private List<Vehiculos> vehiculos;

    public Residencia(String villa, int manzana, int numerocasa) {
        this.villa = villa;
        this.manzana = manzana;
        this.numeroCasa = numerocasa;
        this.contactos = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
    }

    public String getVilla() {
        return villa;
    }

    public int getManzana() {
        return manzana;
    }

    public int getNumerocasa(){
        return numerocasa;
    }

    public void AgregarContacto(Contactos c) {
        contactos.add(c);
    }

    public void AgregarVehiculo(Vehiculos v) {
        vehiculos.add(v);
    }

    public void GuardarContacto() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contactos.txt", true))) { // 'true' para agregar, no sobrescribir
                for (Contactos c : contactos) {
                writer.write("Nombre: " + c.getNombre() + " Número: " + c.getNumero());
                writer.newLine();
    
                // Guardar los vehículos asociados al contacto
                writer.write("Vehículos:");
                writer.newLine();
                for (Vehiculos v : vehiculos) {
                    writer.write(v.toString());
                    writer.newLine();
                }
    
                // Separador entre contactos
                writer.write("----");
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los contactos.");
        }
    }    
}
