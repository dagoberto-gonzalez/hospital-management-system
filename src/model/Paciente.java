package model;

/**
 * Clase que representa a un paciente del hospital.
 * Hereda de la clase Persona.
 * 
 * @author Jose Zamora & Dagoberto Gonzalez
 */
public class Paciente extends Persona {

    /**
     * ATRIBUTOS ADICIONALES
     */
    private String tipoSangre;
    private String padecimiento;
    private String alergias;
    private double peso;
    private double altura;

    /**
     * Constructor vacío.
     */
    public Paciente() {
        super();
    }

    /**
     * Constructor sobrecargado.
     * 
     * @param id identificador del paciente
     * @param nombre nombre del paciente
     * @param edad edad del paciente
     * @param tipoSangre tipo de sangre del paciente
     * @param padecimiento padecimiento o enfermedad actual
     * @param alergias alergias conocidas del paciente
     * @param peso peso del paciente en kg
     * @param altura altura del paciente en metros
     */
    public Paciente(String id, String nombre, int edad, String correo, String tipoSangre, String padecimiento,
			String alergias, double peso, double altura) {
		super(id, nombre, edad, correo);
		this.tipoSangre = tipoSangre;
		this.padecimiento = padecimiento;
		this.alergias = alergias;
		this.peso = peso;
		this.altura = altura;
	}

    /**
     * Obtiene el tipo de sangre del paciente.
     * 
     * @return tipo de sangre
     */
    public String getTipoSangre() {
        return tipoSangre;
    }

	/**
     * Establece el tipo de sangre del paciente.
     * 
     * @param tipoSangre nuevo tipo de sangre
     */
    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    /**
     * Obtiene el padecimiento del paciente.
     * 
     * @return padecimiento
     */
    public String getPadecimiento() {
        return padecimiento;
    }

    /**
     * Establece el padecimiento del paciente.
     * 
     * @param padecimiento nuevo padecimiento
     */
    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }

    /**
     * Obtiene las alergias del paciente.
     * 
     * @return alergias
     */
    public String getAlergias() {
        return alergias;
    }

    /**
     * Establece las alergias del paciente.
     * 
     * @param alergias nuevas alergias
     */
    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    /**
     * Obtiene el peso del paciente.
     * 
     * @return peso en kg
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso del paciente.
     * 
     * @param peso nuevo peso en kg
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene la altura del paciente.
     * 
     * @return altura en metros
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Establece la altura del paciente.
     * 
     * @param altura nueva altura en metros
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

 
}