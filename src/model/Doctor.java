package model;

/**
 * Clase que representa a un doctor del hospital.
 * Hereda de la clase Persona.
 * 
 * @author Jose Zamora & Dagoberto Gonzalez
 */
public class Doctor extends Persona {

    /**
     * ATRIBUTOS ADICIONALES
     */
    private String especialidad;
    private int añosExperiencia;
    private String codigoMedico;
    private String horarioAtencion;

    /**
     * Constructor vacío.
     */
    public Doctor() {
        super();
    }

    /**
     * Constructor sobrecargado.
     * 
     * @param id identificador del doctor
     * @param nombre nombre del doctor
     * @param edad edad del doctor
     * @param especialidad especialidad médica
     * @param añosExperiencia años de experiencia
     * @param codigoMedico código médico profesional
     * @param horarioAtencion horario de atención
     */
    public Doctor(String id, String nombre, int edad, String correo, String especialidad, int añosExperiencia,
			String codigoMedico, String horarioAtencion) {
		super(id, nombre, edad, correo);
		this.especialidad = especialidad;
		this.añosExperiencia = añosExperiencia;
		this.codigoMedico = codigoMedico;
		this.horarioAtencion = horarioAtencion;
	}

    /**
     * Obtiene la especialidad del doctor.
     * 
     * @return especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }


	/**
     * Establece la especialidad del doctor.
     * 
     * @param especialidad nueva especialidad
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene los años de experiencia del doctor.
     * 
     * @return años de experiencia
     */
    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    /**
     * Establece los años de experiencia del doctor.
     * 
     * @param añosExperiencia nuevos años de experiencia
     */
    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    /**
     * Obtiene el código médico del doctor.
     * 
     * @return código médico
     */
    public String getCodigoMedico() {
        return codigoMedico;
    }

    /**
     * Establece el código médico del doctor.
     * 
     * @param codigoMedico nuevo código médico
     */
    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    /**
     * Obtiene el horario de atención del doctor.
     * 
     * @return horario de atención
     */
    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    /**
     * Establece el horario de atención del doctor.
     * 
     * @param horarioAtencion nuevo horario de atención
     */
    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

 
    
}