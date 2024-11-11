import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ciudadela ciudadela = new Ciudadela("Ciudadela Principal");
        Residente residente1 = new Residente("1234", "Juan Pérez", "Calle Ficticia 123");
        Vehiculos_Residente vehiculoResidente1 = new Vehiculos_Residente(residente1, "ABC123", "Juan Pérez", false);
        

        int eleccion;

        System.out.println("Bienvenido al menu principal de nuestro sistema \n Escoja las siguientes 8 opciones:");

        do {
            System.out.println("Opcion 1___Etapa");
            System.out.println("Opcion 2___Residencia");
            System.out.println("Opcion 3___Contactos por Residencia");
            System.out.println("Opcion 4___Registro de Evento por Residencia ");
            System.out.println("Opcion 5___Registro de Listado de Visitantes por Evento ");
            System.out.println("Opcion 6___Registro de Ingreso o Salida de Vehículos de Residentes  ");
            System.out.println("Opcion 7___Registro de Ingreso o Salida de Vehículos de Visitantes  ");
            System.out.println("Opcion 8___Mostrar Listado de Vehículos por Residencia  ");
            System.out.println("Opcion 9___Salir del sistema  ");
            eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Ha elegido la opcion 1");
                    int opcion1;
                    sc.nextLine();
                    do {

                        System.out.print("Nombre de la etapa: ");
                        String nombreEtapa = sc.nextLine();
                        System.out.print("Ubicación de la etapa: ");
                        String ubicacionEtapa = sc.nextLine();
                        System.out.print("Descripción de la etapa: ");
                        String descripcionEtapa = sc.nextLine();
                        Etapa nuevaEtapa = new Etapa(nombreEtapa, ubicacionEtapa, descripcionEtapa);
                        ciudadela.AgregarEtapa(nuevaEtapa);
                        ciudadela.GuardarEtapa();

                        System.out.println("Etapa guardada exitosamente.");
                        System.out.println("\nSi desea agregar otra etapa, escriba 1");
                        System.out.println("Si desea volver al menú principal, escriba 0");
                        opcion1 = sc.nextInt();
                        sc.nextLine();
                        if (opcion1 != 0 && opcion1 != 1) {
                            System.out.println("Opción inválida. Intente nuevamente.");
                        }
                    } while (opcion1 != 0);

                    System.out.println("Regresando al menú principal...");
                    break;

                case 2:
                    System.out.println("Ha elegido la opcion 2");
                    int opcion2;
                    sc.nextLine();
                    ciudadela.cargarEtapasDesdeArchivo();

                    do {

                        System.out.print("Nombre de la Villa: ");
                        String villa = sc.nextLine();
                        System.out.print("Ubicación de la Residencia: ");
                        String ubicacion = sc.nextLine();
                        System.out.print("Manzana de la Residencia: ");
                        int manzana = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Seleccione la etapa para la residencia:");
                        // Imprimir las etapas existentes
                        for (Etapa etapa : ciudadela.getEtapas()) {
                            System.out.println(etapa.getNombre());
                        }
                        System.out.print("Ingrese el nombre de la etapa: ");

                        String etapaSeleccionada = sc.nextLine();
                        Etapa etapa = ciudadela.BuscarEtapa(etapaSeleccionada);

                        if (etapa != null) {
                            // Crear la residencia y agregarla a la etapa seleccionada
                            Residencia residencia = new Residencia(villa, ubicacion, manzana);
                            etapa.AgregarResidencia(residencia);

                            etapa.guardarResidencias();

                            System.out.println("Residencia registrada con éxito.");
                        } else {
                            System.out.println("Etapa no encontrada. Intente de nuevo.");
                        }
                        System.out.print("¿Desea registrar otra residencia en esta etapa? (1 = Sí, 0 = No): ");
                        opcion2 = sc.nextInt();
                        sc.nextLine();
                    } while (opcion2 != 0);

                    break;

                case 3:
                    System.out.println("Ha elegido la opcion 3");
                    ciudadela.cargarEtapasDesdeArchivo();
                    for (Etapa etapa : ciudadela.getEtapas()) {
                        etapa.cargarResidenciasDesdeArchivo(); 
                    }
                     
                    System.out.println("Seleccione una residencia:");
                    if (ciudadela.getEtapas().size() > 0 && !ciudadela.getEtapas().get(0).getResidencias().isEmpty()) {
                        System.out.println("Seleccione una residencia:");
                        
                        for (Residencia residencia : ciudadela.getEtapas().get(0).getResidencias()) {
                            System.out.println("Residencia: " + residencia.getVilla());
                        }
                        sc.nextLine();


                        // Pedir al usuario que ingrese el nombre de la villa seleccionada
                        System.out.print("Ingrese el nombre de la residencia para ver sus contactos: ");
                        String villaSeleccionada = sc.nextLine().trim();

                        // Buscar la residencia seleccionada
                        Residencia residenciaSeleccionada = null; // Asegúrate de inicializar la variable antes de
                                                                  // usarla
                        for (Residencia residencia : ciudadela.getEtapas().get(0).getResidencias()) {
                            if (residencia.getVilla().trim().equalsIgnoreCase(villaSeleccionada.trim())) {
                                residenciaSeleccionada = residencia;
                                break; // Si la encontramos, salimos del ciclo
                            }
                        }

                        // Si se encontró la residencia, mostrar los contactos
                        if (residenciaSeleccionada != null) {
                            residenciaSeleccionada.mostrarContactos();
                        } else {
                            System.out.println("Residencia no encontrada.");
                        }
                    } else {
                        System.out.println("No hay residencias registradas.");
                    }

                    break;
                case 4:
                    System.out.println("Ha elegido la opcion 4");
                    break;
                case 5:
                    System.out.println("Ha elegido la opcion 5");
                    break;
                case 6:
                    System.out.println("Ha elegido la opcion 6");
                    int opcion6;

                    do {
                        System.out.println(
                                "Si va a registrar el ingreso de un vehiculo residente, escriba 1 \n Si va registrar la salida de un vehiculo residente escriba 2 \n Si desea volver al menu principal escriba 0 ");
                        opcion6 = sc.nextInt();
                        switch (opcion6) {

                            case 1:

                                vehiculoResidente1.RegistarIngeso();

                                break;
                            case 2:
                                vehiculoResidente1.RegistarSalida();
                                ;

                                break;
                            case 0:
                                System.out.println("Regresando al menú principal...");

                                break;
                            default:
                                System.out.println("Por favor, intentelo nuevamente");
                                break;
                        }
                        System.out.println("");

                    } while (opcion6 != 0);
                    break;

                case 7:
                    System.out.println("Ha elegido la opcion 7");
                    break;
                case 8:
                    System.out.println("Ha elegido la opcion 8");
                    ciudadela.mostrarVehiculosPorResidencia();
                    break;
                case 9:
                    System.out.println("Saliendo...........\ntenga un buen dia");
                    break;
                default:
                    System.out.println("Opcion invalida\nIntentelo nuevamente");
                    break;
            }
            System.out.println("");
        } while (eleccion != 9);
        sc.close();
    }
}
