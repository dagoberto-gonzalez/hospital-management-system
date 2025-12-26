package model;


import java.util.Date;

/**
 * Clase que representa una cita médica en el hospital.
 * Asocia un Paciente con un Doctor en una fecha y hora específicas.
 * 
 * @author Jose Zamora & Dagoberto Gonzalez
 */
public class Cita {

    /**
     * ATRIBUTOS
     */
    private String idCita;
    private Date fecha;
    private String hora;
    private String motivo;
    private Paciente paciente;
    private Doctor doctor;

    /**
     * Constructor vacío.
     */
    public Cita() {
    }

    /**
     * Constructor sobrecargado.
     * 
     * @param idCita identificador de la cita
     * @param fecha fecha de la cita
     * @param hora hora de la cita (formato: HH:mm)
     * @param motivo motivo de la consulta
     * @param paciente paciente asociado a la cita
     * @param doctor doctor asociado a la cita
     */
    public Cita(String idCita, Date fecha, String hora, String motivo, Paciente paciente, Doctor doctor) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.paciente = paciente;
        this.doctor = doctor;
    }

    /**
     * Obtiene el ID de la cita.
     * 
     * @return id de la cita
     */
    public String getIdCita() {
        return idCita;
    }

    /**
     * Establece el ID de la cita.
     * 
     * @param idCita nuevo id
     */
    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    /**
     * Obtiene la fecha de la cita.
     * 
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la cita.
     * 
     * @param fecha nueva fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de la cita.
     * 
     * @return hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * Establece la hora de la cita.
     * 
     * @param hora nueva hora
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el motivo de la cita.
     * 
     * @return motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Establece el motivo de la cita.
     * 
     * @param motivo nuevo motivo
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene el paciente asociado a la cita.
     * 
     * @return paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Establece el paciente asociado a la cita.
     * 
     * @param paciente nuevo paciente
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Obtiene el doctor asociado a la cita.
     * 
     * @return doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Establece el doctor asociado a la cita.
     * 
     * @param doctor nuevo doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

 
}
