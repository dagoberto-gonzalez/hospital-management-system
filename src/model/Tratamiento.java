package model;

/**
 * Clase que representa un tratamiento médico en el hospital.
 * Asocia un tratamiento con un Paciente y un Doctor.
 * 
 * @author Jose Zamora & Dagoberto Gonzalez
 */
public class Tratamiento {

    /**
     * ATRIBUTOS
     */
    private String idTratamiento;
    private String medicamento;
    private String dosis;
    private String duracion;
    private String instrucciones;
    private Paciente paciente;
    private Doctor doctor;

    /**
     * Constructor vacío.
     */
    public Tratamiento() {
    }

    /**
     * Constructor sobrecargado.
     * 
     * @param idTratamiento identificador único del tratamiento
     * @param medicamento medicamento recetado
     * @param dosis dosis del medicamento
     * @param duracion duración del tratamiento
     * @param instrucciones instrucciones adicionales
     * @param paciente paciente asociado al tratamiento
     * @param doctor doctor que prescribe el tratamiento
     */
    public Tratamiento(String idTratamiento, String medicamento, String dosis, String duracion, 
                       String instrucciones, Paciente paciente, Doctor doctor) {
        this.idTratamiento = idTratamiento;
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.duracion = duracion;
        this.instrucciones = instrucciones;
        this.paciente = paciente;
        this.doctor = doctor;
    }

    /**
     * Obtiene el ID del tratamiento.
     * 
     * @return id del tratamiento
     */
    public String getIdTratamiento() {
        return idTratamiento;
    }

    /**
     * Establece el ID del tratamiento.
     * 
     * @param idTratamiento nuevo id
     */
    public void setIdTratamiento(String idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    /**
     * Obtiene el medicamento del tratamiento.
     * 
     * @return medicamento
     */
    public String getMedicamento() {
        return medicamento;
    }

    /**
     * Establece el medicamento del tratamiento.
     * 
     * @param medicamento nuevo medicamento
     */
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    /**
     * Obtiene la dosis del tratamiento.
     * 
     * @return dosis
     */
    public String getDosis() {
        return dosis;
    }

    /**
     * Establece la dosis del tratamiento.
     * 
     * @param dosis nueva dosis
     */
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    /**
     * Obtiene la duración del tratamiento.
     * 
     * @return duración
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración del tratamiento.
     * 
     * @param duracion nueva duración
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * Obtiene las instrucciones del tratamiento.
     * 
     * @return instrucciones
     */
    public String getInstrucciones() {
        return instrucciones;
    }

    /**
     * Establece las instrucciones del tratamiento.
     * 
     * @param instrucciones nuevas instrucciones
     */
    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    /**
     * Obtiene el paciente asociado al tratamiento.
     * 
     * @return paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Establece el paciente asociado al tratamiento.
     * 
     * @param paciente nuevo paciente
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Obtiene el doctor que prescribe el tratamiento.
     * 
     * @return doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Establece el doctor que prescribe el tratamiento.
     * 
     * @param doctor nuevo doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

 
   
}