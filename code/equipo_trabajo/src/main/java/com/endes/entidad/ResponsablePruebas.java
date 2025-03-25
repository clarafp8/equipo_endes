package com.endes.entidad;

public class ResponsablePruebas extends Personal {
    private int bugsDetectados;
    
    /**
     * Constructor para la clase ResponsablePruebas.
     *
     * @param dni        Número de identificación del responsable.
     * @param nombre     Nombre del responsable.
     * @param apellidos  Apellidos del responsable.
     * @param sueldoBase Sueldo base del responsable.
     * @param bugsDetectados  Número de bugsDetectados.
     * @throws IllegalArgumentException Si la categoría es menor que 1.
     */

    public ResponsablePruebas(String dni, String nombre, double sueldoBase, int bugsDetectados) {
        super(dni, nombre, sueldoBase);
        setBugsDetectados(bugsDetectados);
    }
    
    /**
     * Obtiene los bugs Detectados.
     *
     * @return Número de bugs Detectados.
     */

    public int getBugsDetectados() {
        return bugsDetectados;
    }
    
    /**
     * Establece unos nuevos bugs detectados.
     *
     * @param bugsDetectados nuevo numero de bugs detectados.
     * @throws IllegalArgumentException Si el número de bugs detectados es negativo.
     */
    public void setBugsDetectados(int bugsDetectados) {
        if (bugsDetectados < 0) {
            throw new IllegalArgumentException("El número de bugs detectados no puede ser negativo.");
        }
        this.bugsDetectados = bugsDetectados;
    }
   
    /**
     * Calcula el extra del sueldo basado en el número de bugs que detecte el responsable de Pruebas.
     *
     * @return Incremento del sueldo basado en el número de bugs que encuentre el responsable de Pruebas.
     */
    @Override
    public double calcularProductividad() {
        return getSueldoBase() * (1 + 0.02 * bugsDetectados);
    }
}
