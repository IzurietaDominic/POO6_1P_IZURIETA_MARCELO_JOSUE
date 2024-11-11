import java.io.*;
import java.util.*;


public class Etapa {
    private String nombre;
    private int numero;
    private List<Residencia> residencias;
    private String archivoResidencias;

    public Etapa(String nombre) {
        this.nombre = nombre;
        this.residencias = new ArrayList<>();
        this.archivoResidencias = nombre + "_residencias.txt";
    }

    public String getNombre() {
        return nombre;
    }

    public void AgregarResidencia(Residencia r) {
        residencias.add(r);
    }

    public Residencia BuscarResidencia(String villa) {
        for (Residencia residencia : residencias) {
            if (residencia.getVilla().equals(villa)) {
                return residencia;
            }
        }
        return null;
    }


    public void GuardarResidencia() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoResidencias))) {
            for (Residencia residencia : residencias) {
                writer.write("Nombre de la Villa: "+ residencia.getVilla() + ", Numero de la Manzana: " + residencia.getManzana());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar las residencias.");
        }
    }

}
