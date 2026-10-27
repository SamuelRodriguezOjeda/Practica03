
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelVisualizar extends JPanel {

    private JLabel lblPosicion;
    private JLabel lblNumero;
    private JLabel lblNombre;
    private JLabel lblPuntos;
    private JLabel lblFecha;
    private JLabel lblError;

    private JButton btnPrimero;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnUltimo;
    private JButton btnBorrar;
    private JButton btnOrdenar;

    public PanelVisualizar() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Posicion del cliente
        lblPosicion = new JLabel(
                "No hay clientes", SwingConstants.CENTER);
        add(lblPosicion, BorderLayout.NORTH);

        // Datos del cliente
        JPanel panelDatos = new JPanel(
                new GridLayout(4, 2, 10, 10));

        panelDatos.add(new JLabel("Número:"));
        lblNumero = new JLabel("-");
        panelDatos.add(lblNumero);

        panelDatos.add(new JLabel("Nombre:"));
        lblNombre = new JLabel("-");
        panelDatos.add(lblNombre);

        panelDatos.add(new JLabel("Puntos:"));
        lblPuntos = new JLabel("-");
        panelDatos.add(lblPuntos);

        panelDatos.add(new JLabel("Fecha de nacimiento:"));
        lblFecha = new JLabel("-");
        panelDatos.add(lblFecha);

        add(panelDatos, BorderLayout.CENTER);

        // Mensajes de error
        lblError = new JLabel(" ");
        lblError.setForeground(Color.RED);

        // Primera fila de botones
        JPanel panelNavegacion = new JPanel(new FlowLayout());

        btnPrimero = new JButton("Primero");
        btnAnterior = new JButton("Anterior");
        btnSiguiente = new JButton("Siguiente");
        btnUltimo = new JButton("Último");

        panelNavegacion.add(btnPrimero);
        panelNavegacion.add(btnAnterior);
        panelNavegacion.add(btnSiguiente);
        panelNavegacion.add(btnUltimo);

        // Segunda fila de botones
        JPanel panelAcciones = new JPanel(new FlowLayout());

        btnBorrar = new JButton("Borrar");
        btnOrdenar = new JButton("Ordenar por número");

        panelAcciones.add(btnBorrar);
        panelAcciones.add(btnOrdenar);

        // Panel inferior con las dos filas y los errores
        JPanel panelInferior = new JPanel(new BorderLayout());

        panelInferior.add(lblError, BorderLayout.NORTH);
        panelInferior.add(panelNavegacion, BorderLayout.CENTER);
        panelInferior.add(panelAcciones, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);

        // Eventos de los botones
        btnPrimero.addActionListener(e -> {
            // El controlador gestionará este evento.
        });
    }

    // Mostrar los datos de un cliente
    public void mostrarCliente(
            String numero,
            String nombre,
            String puntos,
            String fecha,
            int posicion,
            int total) {

        lblPosicion.setText(
                "Cliente " + posicion + " de " + total);

        lblNumero.setText(numero);
        lblNombre.setText(nombre);
        lblPuntos.setText(puntos);
        lblFecha.setText(fecha);

        lblError.setText(" ");
    }

    // Limpiar los datos
    public void limpiar() {
        lblPosicion.setText("No hay clientes");
        lblNumero.setText("-");
        lblNombre.setText("-");
        lblPuntos.setText("-");
        lblFecha.setText("-");
        lblError.setText(" ");
    }

    // Mostrar errores en rojo
    public void mostrarError(String mensaje) {
        lblError.setForeground(Color.RED);
        lblError.setText(mensaje);
    }

    // Activar o desactivar botones
    public void actualizarBotones(
            boolean primero,
            boolean ultimo,
            boolean hayClientes) {

        btnPrimero.setEnabled(hayClientes && !primero);
        btnAnterior.setEnabled(hayClientes && !primero);
        btnSiguiente.setEnabled(hayClientes && !ultimo);
        btnUltimo.setEnabled(hayClientes && !ultimo);
        btnBorrar.setEnabled(hayClientes);
        btnOrdenar.setEnabled(hayClientes);
    }

    // Listeners para conectar con el controlador
    public void addPrimeroListener(ActionListener l) {
        btnPrimero.addActionListener(l);
    }

    public void addAnteriorListener(ActionListener l) {
        btnAnterior.addActionListener(l);
    }

    public void addSiguienteListener(ActionListener l) {
        btnSiguiente.addActionListener(l);
    }

    public void addUltimoListener(ActionListener l) {
        btnUltimo.addActionListener(l);
    }

    public void addBorrarListener(ActionListener l) {
        btnBorrar.addActionListener(l);
    }

    public void addOrdenarListener(ActionListener l) {
        btnOrdenar.addActionListener(l);
    }
}
