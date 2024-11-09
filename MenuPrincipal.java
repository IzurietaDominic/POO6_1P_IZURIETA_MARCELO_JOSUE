/*
 * @JosueMartinez
 * Descripcion: 
 * Menu de opciones del proyecto incluido la clase etapa donde esta tiene getters y setters,
 * tambien el metodo para guardar el documento.
 */

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class MenuPrincipal {
    private Scanner scanner = new Scanner(System.in);
    
    public void menu(){
        int opcion;

        do {
            System.out.println("Menú de opciones");
            System.out.println("1. Etapa");
            System.out.println("2. Residencia por Etapa");
            System.out.println("3. Contactos por Residencia");
            System.out.println("4. Registro de Evento por Residencia");
            System.out.println("5. Registro de Listado de Visitantes por Evento");
            System.out.println("6. Registro de Ingreso o Salida de Vehículos de Residentes");
            System.out.println("7. Registro de Ingreso o Salida de Vehículos de Visitantes");
            System.out.println("8. Mostrar Listado de Vehículos por Residencia");
            System.out.println("Digite 0 para salir del menu");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    registrarEtapa();
                    break;
                case 2:
                    registrarResidencia();
                    break;
                case 3:
                    registrarContacto();
                    break;
                case 4:
                    registrarEvento();
                    break;
                case 5:
                    registrarVisitantesEvento();
                    break;
                case 6:
                    registrarIngresoSalidaResidente();
                    break;
                case 7:
                    registrarIngresoSalidaVisitante();
                    break;
                case 8:
                    mostrarListadoVehiculos();
                    break;
                case 0:
                    System.out.println("Saliendo del menu");
                    break;
                default: 
                    System.out.println("Ingrese el digito correctamente!");
            }
        } while(opcion != 0);
    }
}

class Etapa {
    private String nombre;
    private String ubicacion;
    //private int numeroCasas;
    public Etapa(String nombre, String ubicacion){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    //GETTERS AND SETTERS
    public String getNombre(){
        return nombre;
    }  
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getUbicacion(){
        return ubicacion;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    public String toString(){
        return "Etapa: "+nombre+", ubicacion: "+ubicacion;
    }

    //ARCHIVO
    public void guardarEtapa() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("etapas.txt", true))) {
            writer.write(this.toString() + "\n"); //No se cierra para que se pueda ingresar datos.
        } catch (IOException e) {
            System.out.println("Error al guardar etapa: " + e.getMessage());
        }
    }
}