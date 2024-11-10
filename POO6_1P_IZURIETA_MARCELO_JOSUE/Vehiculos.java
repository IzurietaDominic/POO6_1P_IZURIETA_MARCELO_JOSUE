public class Vehiculos {
    private String placa;
    private String propietario;
    private String estado;

    public Vehiculos(String placa, String propietario, String estado) {
        this.placa = placa;
        this.propietario = propietario;
        this.estado = estado;
    }
    //*getter de placa */
    public String getPlaca() {
        return placa;
    }
    //*getter de Propietario */
    public String getPropietario() {
        return propietario;
    }
    //*getter de Estado */
    public String getEstado() {
        return estado;
    }
    //*Setter de Placa */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    //*Setter de Propietario */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    //*Setter de Estado */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    //*toString de la clase vehiculo */
    @Override
    public String toString() {
        return "Vehículo [placa=" + placa + ", propietario=" + propietario + ", estado=" + estado + "]";
    }

}