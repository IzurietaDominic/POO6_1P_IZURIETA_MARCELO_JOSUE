import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Vehiculos_Residente extends Vehiculos {
    private Residente residente;
    public static int n = 1;

    // * constructor del vehiculo residente */
    public Vehiculos_Residente(Residente residente, String placa, String propietario, boolean estado) {
        super(placa, propietario, estado);
        this.residente = residente;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;

    }

    // *toString que muestra la información del vehiculo residente */
    @Override
    public String toString() {
        return "Vehículo Residente [placa=" + getPlaca() + ", propietario=" + getPropietario() + ", estado="
                + getEstado() +
                ", residente=" + residente + "]";
    }

    // *muestra la informacion del propietario */
    private void mostrarInformacionPropietario() {
        System.out.println("Propietario del Vehículo: " + getPropietario());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Residencia: " + residente.getNumeroResidencia());
        System.out.println("Ubicación: " + residente.getDireccionResidencia());
    }

    // *Registra el ingreso */
    public void RegistarIngeso() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la placa del vehiculo:");
        String placaIngresada = sc.nextLine();
        if (placaIngresada.equalsIgnoreCase(getPlaca())) { // !!!!!
            if (!getEstado()) {
                setEstado(true);
                System.out.println("Ingreso registrado para el vehículo: " + getPlaca());

                mostrarInformacionPropietario();
                guardarRegistro("ingreso");
            } else {
                System.out.println("El vehículo ya se encuentra dentro de la ciudadela.");

            }
        } else {
            System.out.println("La placa ingresada no coincide con la del vehículo.");
        }

    }

    // *Registra la salida */
    public void RegistarSalida() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la placa del vehículo: ");
        String placaIngresada = sc.nextLine();
        if (placaIngresada.equalsIgnoreCase(getPlaca())) {
            if (getEstado()) {
                setEstado(false); // Cambia el estado a fuera
                System.out.println("Salida registrada para el vehículo con placa: " + getPlaca());
                mostrarInformacionPropietario();
                guardarRegistro("Salida");
            } else {
                System.out.println("El vehículo ya se encuentra fuera de la ciudadela.");
            }
        } else {
            System.out.println("La placa ingresada no coincide con la del vehículo.");
        }
    }

    // *Crea el archivo si es la primera vez y guarda los ingreos */
    public void guardarRegistro(String tipoMovimiento) {
        try (FileWriter fw = new FileWriter("residentes.txt", true);
                PrintWriter pw = new PrintWriter(fw)) {
            pw.println("Acceso n :" + Vehiculos_Residente.n);
            pw.println("Movimiento: " + tipoMovimiento);
            pw.println("Placa: " + getPlaca());
            pw.println("Propietario: " + getPropietario());
            pw.println("Residencia: " + residente.getNumeroResidencia());
            pw.println("Direccion de la Residencia: " + residente.getDireccionResidencia());
            pw.println("Estado actual: " + getEstado());
            pw.println("--------------");
            Vehiculos_Residente.n += 1;
        } catch (IOException e) {
            System.out.println("Error al guardar el registro en residentes.txt: " + e.getMessage());
        }
    }

}
