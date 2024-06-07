/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ale.interfazeventos;

/**
 *
 * @author Ale
 */
public class Empleado {
    private static final double SUEDO_BASE_HORA = 100;
    private static final double SUEDO_BASE_TEMPORAL = 18000;
    private static final double ADICIONAL_HIJO = 1000;
    private static final double COMPLEMENTO_ANTIGUEDAD = 1000;

    // Método para calcular el sueldo de empleados por hora
    public static double calcularSueldoPorHora(int horasTrabajadas) {
        return SUEDO_BASE_HORA * horasTrabajadas;
    }

    // Método para calcular el sueldo de empleados temporales
    public static double calcularSueldoTemporal(int cantidadHijos) {
        return SUEDO_BASE_TEMPORAL + (cantidadHijos * ADICIONAL_HIJO);
    }

    // Método para calcular el sueldo de empleados de planta permanente
    public static double calcularSueldoPlantaPermanente(int cantidadHijos, int anosAntiguedad) {
        return SUEDO_BASE_TEMPORAL + (cantidadHijos * ADICIONAL_HIJO) + (anosAntiguedad * COMPLEMENTO_ANTIGUEDAD);
    }
}