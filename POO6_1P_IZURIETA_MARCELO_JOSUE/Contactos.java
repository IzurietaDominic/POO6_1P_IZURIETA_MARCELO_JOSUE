
public class Contactos {
    private String nombre;
    private String telefono;
    private Residencia residencia;
    
    //constructor

    public Contactos(String nombre, String telefono, Residencia residencia) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.residencia = residencia;
    }
    
    // getters y settters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }
    
    






}


