import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Vehiculos_Visitante extends Vehiculos {
    public static int n = 1;
    private Visitante visitante;
    private boolean autorizado;
    int contadorRegistros =1;

    public Vehiculos_Visitante(String placa, String propietario, boolean estado, Visitante visitante) {
        super(placa, propietario, estado);
        this.visitante = visitante;
        this.autorizado = visitante.isAutorizado();
    }

    // *Registrar ingreso */
    public void registrarIngreso() {
        System.out.println("Registrando ingreso del vehículo: " + getPlaca());
        guardarRegistro("Ingreso");
    }

    // *Registrar salida */
    public void registrarSalida() {
        // Lógica para registrar la salida
        System.out.println("Registrando salida del vehículo: " + getPlaca());
        // Llamada para guardar el registro en el archivo
        guardarRegistro("Salida");
    }

    // *Solicitar autorizacion, visitante no autorizado */
    public void solicitarAutorizacion() {
        System.out.println("Llamando al residente para obtener autorización...");
        visitante.darAutorizacion();
        System.out.println("Visitante autorizado.");
    }

    // *Registrar en archivo */
    private void registrarEnArchivo(String tipoRegistro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("visitantes.txt", true))) {
            writer.write(tipoRegistro + " - Visitante: " + visitante.getNombre() + ", Placa: " + getPlaca());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al registrar la entrada/salida del vehículo: " + e.getMessage());
        }
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    // *toString */
    @Override
    public String toString() {
        return "Vehículo Visitante [placa=" + getPlaca() + ", propietario=" + getPropietario() + ", estado="
                + getEstado() + ", visitante=" + visitante.getNombre() + ", autorizado=" + autorizado + "]";
    }

    // *equals */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Vehiculos_Visitante that = (Vehiculos_Visitante) o; 
        return autorizado == that.autorizado && visitante.equals(that.visitante);
    }

    // *hashcode */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), visitante);
    }

    //* Guardar registros */
    public void guardarRegistro(String tipo) {
        // Crear el archivo si no existe
        try {
            File archivo = new File("visitantes.txt");
            if (!archivo.exists()) {
                boolean archivoCreado = archivo.createNewFile();
                if (archivoCreado) {
                    System.out.println("Archivo 'visitantes.txt' creado con éxito.");
                } else {
                    System.out.println("El archivo ya existe.");
                }
            }

            // Crear un FileWriter en modo append para agregar al archivo sin sobrescribir
            try (FileWriter writer = new FileWriter(archivo, true)) {
                // Guardar el número de registro (ej: Registro N° 1, Registro N° 2, etc.)
                String registro = "Registro N° " + contadorRegistros + "\n";
                registro += tipo + " - Vehículo: " + getPlaca() + ", Visitante: " + visitante.getNombre() + "\n";
                registro += "--------------\n"; // Línea divisoria

                // Escribir el registro en el archivo
                writer.write(registro);
                System.out.println("Registro de " + tipo.toLowerCase() + " guardado exitosamente en visitantes.txt");

                // Incrementar el contador de registros
                contadorRegistros++;
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

}
