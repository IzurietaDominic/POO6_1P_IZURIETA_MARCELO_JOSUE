import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                    break;
                case 2:
                    System.out.println("Ha elegido la opcion 2");
                    break;
                case 3:
                    System.out.println("Ha elegido la opcion 3");
                    break;
                case 4:
                    System.out.println("Ha elegido la opcion 4");
                    break;
                case 5:
                    System.out.println("Ha elegido la opcion 5");
                    break;
                case 6:
                    System.out.println("Ha elegido la opcion 6");
                    int opcion;
                    
                    do {
                        System.out.println(
                            "Si va a registrar el ingreso de un vehiculo residente, escriba 1 \n Si va registrar la salida de un vehiculo residente escriba 2 \n Si desea volver al menu principal escriba 0 ");
                            opcion = sc.nextInt();
                            switch (opcion) {
                           
                            case 1:
                            
                            vehiculoResidente1.RegistarIngeso();
                            
                                break;
                            case 2:
                            vehiculoResidente1.RegistarSalida();;
                            
                                break;
                            case 0:
                            System.out.println("Regresando al menú principal...");

                                break;
                            default:
                                System.out.println("Por favor, intentelo nuevamente");
                                break;
                        }
                        System.out.println("");

                        
                    } while (opcion != 0);
                    break;

                case 7:
                    System.out.println("Ha elegido la opcion 7");
                    break;
                case 8:
                    System.out.println("Ha elegido la opcion 8");
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
