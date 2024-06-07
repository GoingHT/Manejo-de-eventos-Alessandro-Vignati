/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ale.interfazeventos;

/**
 *
 * @author Ale
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class InterfazEventos extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JButton btnGuardar, btnLimpiar, btnAgregarEmpleado;

    public InterfazEventos() {
        setTitle("Gestión de Empleados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel(new Object[][] {}, new Object[]{"Nombre", "Apellido", "Cédula", "Cantidad Hijos", "Sueldo"});
        table = new JTable(model);

        btnGuardar = new JButton("Guardar");
        btnLimpiar = new JButton("Limpiar");
        btnAgregarEmpleado = new JButton("Agregar Empleado");

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnAgregarEmpleado);
        add(panelBotones, BorderLayout.SOUTH);

        btnAgregarEmpleado.addActionListener(e -> agregarEmpleado());

        btnGuardar.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(this, "¿Desea guardar la información?", "Guardar Información", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Datos guardados");
            }
        });

        btnLimpiar.addActionListener(e -> {
            int option = JOptionPane.showOptionDialog(this,
                    "¿Está seguro que desea limpiar todos los parámetros?",
                    "Limpiar Parámetros",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    "No"
            );
            if (option == JOptionPane.YES_OPTION) {
                model.setRowCount(0);
            }
        });

        setVisible(true);
    }

   private void agregarEmpleado() {
    String tipoEmpleado = JOptionPane.showInputDialog("Ingrese el tipo de empleado (por hora, temporal, planta permanente):");
    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del empleado:");
    String cedula = JOptionPane.showInputDialog("Ingrese la cédula del empleado:");

    int cantidadHijos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de hijos del empleado:"));
    double sueldo = 0;

    switch (tipoEmpleado.toLowerCase()) {
        case "por hora":
            int horasTrabajadas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de horas trabajadas en el mes:"));
            sueldo = Empleado.calcularSueldoPorHora(horasTrabajadas);
            break;
        case "temporal":
            sueldo = Empleado.calcularSueldoTemporal(cantidadHijos);
            break;
        case "planta permanente":
            int anosAntiguedad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la antigüedad en años:"));
            sueldo = Empleado.calcularSueldoPlantaPermanente(cantidadHijos, anosAntiguedad);
            break;
        default:
            JOptionPane.showMessageDialog(null, "Tipo de empleado desconocido.");
            return;
    }

    model.addRow(new Object[]{nombre, apellido, cedula, cantidadHijos, sueldo});
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazEventos());
    }
}