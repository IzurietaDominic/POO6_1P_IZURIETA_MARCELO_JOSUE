import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ciudadela ciudadela = new Ciudadela("Ciudadela Principal");
        

        Residente residente1 = new Residente("1234", "Juan Pérez", "Calle Ficticia 123");
        Vehiculos_Residente vehiculoResidente1 = new Vehiculos_Residente(residente1, "ABC123", "Juan Pérez", false);
        Visitante visitante1 = new Visitante("Maria García", "documento", "4567");
        Vehiculos_Visitante vehiculoVisitante1 = new Vehiculos_Visitante("XYZ789", "Maria García", false, visitante1);

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

                        System.out.print("Ingrese el nombre de la residencia para ver sus contactos: ");
                        String villaSeleccionada = sc.nextLine().trim();

                        Residencia residenciaSeleccionada = null;

                        for (Residencia residencia : ciudadela.getEtapas().get(0).getResidencias()) {
                            if (residencia.getVilla().trim().equalsIgnoreCase(villaSeleccionada.trim())) {
                                residenciaSeleccionada = residencia;
                                break;
                            }
                        }

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
                    sc.nextLine();
                    ciudadela.cargarEtapasDesdeArchivo();
                    System.out.print("Ingrese el nombre del evento: ");
                    String nombreEvento = sc.nextLine();
                    System.out.print("Ingrese la fecha del evento (formato dd/mm/yyyy): ");
                    String fechaEvento = sc.nextLine();
                    System.out.println("Seleccione una residencia de la ciudadela para el evento:");
                    for (Etapa etapa : ciudadela.getEtapas()) {
                        for (Residencia residencia : etapa.getResidencias()) {
                            System.out.println("Residencia: " + residencia.getVilla());
                        }
                    }
                    System.out.print("Ingrese el nombre de la residencia donde se llevará a cabo el evento: ");
                    String villaSeleccionada = sc.nextLine().trim();

                    Residencia residenciaSeleccionada = null;
                    for (Etapa etapa : ciudadela.getEtapas()) {
                        for (Residencia residencia : etapa.getResidencias()) {
                            if (residencia.getVilla().trim().equalsIgnoreCase(villaSeleccionada.trim())) {
                                residenciaSeleccionada = residencia;
                                break;
                            }
                        }
                        if (residenciaSeleccionada != null) {
                            break;
                        }
                    }

                    if (residenciaSeleccionada != null) {
                        System.out.print("Ingrese la cantidad de personas esperadas para el evento: ");
                        int cantidadVisitantes = sc.nextInt();
                        sc.nextLine();

                        List<Visitante> visitantesEsperados = new ArrayList<>();
                        for (int i = 0; i < cantidadVisitantes; i++) {
                            System.out.println("Ingrese los detalles del visitante " + (i + 1) + ":");
                            System.out.print("Nombre del visitante: ");
                            String nombreVisitante = sc.nextLine();
                            System.out.print("Documento de identidad: ");
                            String documentoVisitante = sc.nextLine();
                            System.out.print("Teléfono del visitante: ");
                            String telefonoVisitante = sc.nextLine();

                            Visitante visitante = new Visitante(nombreVisitante, documentoVisitante, telefonoVisitante);
                            visitantesEsperados.add(visitante);
                        }

                        Evento nuevoEvento = new Evento(fechaEvento, residenciaSeleccionada, nombreEvento,
                                visitantesEsperados);

                        nuevoEvento.guardarEvento();

                        System.out.println("El evento ha sido registrado exitosamente.");
                    } else {
                        System.out.println(
                                "Residencia no encontrada. Asegúrese de haber ingresado el nombre correctamente.");
                    }

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
                    int opcion7;
                    do {
                        System.out.println(
                                "Si va a registrar el ingreso de un vehículo visitante, escriba 1\n" +
                                        "Si va a registrar la salida de un vehículo visitante, escriba 2\n" +
                                        "Si desea volver al menú principal, escriba 0");
                        opcion7 = sc.nextInt();

                        switch (opcion7) {
                            case 1:
                                System.out.println("Ingrese la placa del vehículo visitante: ");
                                String placaIngreso = sc.next();
                                if (vehiculoVisitante1.getPlaca().equals(placaIngreso)) {
                                    System.out.println("Vehículo encontrado.");
                                    System.out.println("Eventos del día disponibles:");
                                    System.out.println("Evento 1: Fiesta Familiar - 5 PM");
                                    System.out.println("Evento 2: Reunión Comunitaria - 7 PM");
                                    System.out.println("Visitantes autorizados: ");
                                    System.out.println("1. Maria García (Autorizada)");

                                    if (vehiculoVisitante1.isAutorizado()) {
                                        vehiculoVisitante1.registrarIngreso(); // Se llama y guarda el registro
                                    } else {
                                        vehiculoVisitante1.solicitarAutorizacion();
                                        vehiculoVisitante1.registrarIngreso(); // Se llama y guarda el registro
                                    }
                                } else {
                                    System.out.println("Vehículo no encontrado.");
                                }
                                break;

                            case 2:
                                System.out
                                        .println("Ingrese la placa del vehículo visitante para registrar su salida: ");
                                String placaSalida = sc.next();
                                if (vehiculoVisitante1.getPlaca().equals(placaSalida)) {
                                    vehiculoVisitante1.registrarSalida(); // Se llama y guarda el registro de salida
                                } else {
                                    System.out.println("Vehículo no encontrado.");
                                }
                                break;

                            case 0:
                                System.out.println("Regresando al menú principal...");
                                break;

                            default:
                                System.out.println("Opción inválida. Intente nuevamente.");
                                break;
                        }
                    } while (opcion7 != 0);
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
