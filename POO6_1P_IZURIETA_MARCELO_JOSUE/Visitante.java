    import java.util.Objects;

public class Visitante {

    private String nombre;
    private String documentoIdentidad;
    private String telefono;
    private Residencia residenciaDestino;
    private boolean autorizado;

    //*  Constructor */
    public Visitante(String nombre, String documentoIdentidad, String telefono) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        //this.residenciaDestino = residenciaDestino;
        this.autorizado = false; 
    }

    //* Getters y Setters */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Residencia getResidenciaDestino() {
        return residenciaDestino;
    }

    public void setResidenciaDestino(Residencia residenciaDestino) {
        this.residenciaDestino = residenciaDestino;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    //*  Método para dar autorización al visitante */
    public void darAutorizacion() {
        this.autorizado = true;
    }

    //* Método para mostrar los datos del visitante*/
    public void mostrarDatos() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Documento de Identidad: " + this.documentoIdentidad);
        System.out.println("Teléfono: " + this.telefono);
        System.out.println("Residencia de destino: " + (this.residenciaDestino != null ? this.residenciaDestino.getVilla() : "No asignada"));
        System.out.println("Autorizado para ingresar: " + (this.autorizado ? "Sí" : "No"));
    }

    //* Método equals para comparar dos objetos Visitante */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Visitante visitante = (Visitante) obj;
        return Objects.equals(documentoIdentidad, visitante.documentoIdentidad);
    }

    //* Método hashCode*/
    @Override
    public int hashCode() {
        return Objects.hash(documentoIdentidad);
    }

    //*Método toString para obtener una representación en forma de cadena*/
    @Override
    public String toString() {
        return "Visitante{" +
                "nombre='" + nombre + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", residenciaDestino=" + (residenciaDestino != null ? residenciaDestino.getVilla() : "No asignada") +
                ", autorizado=" + autorizado +
                '}';
    }
}



    

