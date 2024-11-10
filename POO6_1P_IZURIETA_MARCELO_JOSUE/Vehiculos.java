import java.util.Objects;

public class Vehiculos {
    private String placa;
    private String propietario;
    private boolean estado;

    public Vehiculos(String placa, String propietario, boolean estado) {
        this.placa = placa;
        this.propietario = propietario;
        this.estado = estado;
    }

    // *getter de placa */
    public String getPlaca() {
        return placa;
    }

    // *getter de Propietario */
    public String getPropietario() {
        return propietario;
    }

    // *getter de Estado */
    public boolean getEstado() {
        return estado;
    }

    // *Setter de Placa */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // *Setter de Propietario */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    // *Setter de Estado */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // *toString de la clase vehiculo */
    @Override
    public String toString() {
        return "Vehículo [placa=" + placa + ", propietario=" + propietario + ", estado=" + estado + "]";
    }

    // * equals de Vehiculos*/
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;  
        }
        if (o == null || getClass() != o.getClass()) {
            return false;  
        }
        Vehiculos other = (Vehiculos) o;  
        return placa.equals(other.placa) && propietario.equals(other.propietario) && estado == other.estado;
        
    }
    //*hashcode de vehiculos */
     @Override
    public int hashCode() {
        return Objects.hash(placa);
    }
}
