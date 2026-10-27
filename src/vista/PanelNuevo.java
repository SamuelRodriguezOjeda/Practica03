
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelNuevo extends JPanel {

    private JTextField txtNumero;
    private JTextField txtNombre;
    private JTextField txtPuntos;
    private JTextField txtFecha;

    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JLabel lblError;

    public PanelNuevo() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(
                20, 20, 20, 20));

        // Formulario
        JPanel panelFormulario =
                new JPanel(new GridLayout(4, 2, 10, 10));

        panelFormulario.add(new JLabel("Número de cliente:"));
        txtNumero = new JTextField();
        panelFormulario.add(txtNumero);

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Puntos:"));
        txtPuntos = new JTextField();
        panelFormulario.add(txtPuntos);

        panelFormulario.add(
                new JLabel("Fecha de nacimiento (dd/MM/yyyy):"));
        txtFecha = new JTextField();
        panelFormulario.add(txtFecha);

        add(panelFormulario, BorderLayout.CENTER);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());

        btnGuardar = new JButton("Guardar");
        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);

        add(panelBotones, BorderLayout.SOUTH);

        // Mensajes de error
        lblError = new JLabel(" ");
        lblError.setForeground(Color.RED);
        add(lblError, BorderLayout.NORTH);

        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    public int getNumero() {
        return Integer.parseInt(txtNumero.getText().trim());
    }

    public String getNombre() {
        return txtNombre.getText().trim();
    }

    public float getPuntos() {
        return Float.parseFloat(txtPuntos.getText().trim());
    }

    public String getFecha() {
        return txtFecha.getText().trim();
    }

    public void limpiarCampos() {
        txtNumero.setText("");
        txtNombre.setText("");
        txtPuntos.setText("");
        txtFecha.setText("");
        lblError.setForeground(Color.RED);
        lblError.setText(" ");
    }

    public void mostrarError(String mensaje) {
        lblError.setForeground(Color.RED);
        lblError.setText(mensaje);
    }

    public void mostrarMensaje(String mensaje) {
        lblError.setForeground(new Color(0, 128, 0));
        lblError.setText(mensaje);
    }

    public void addGuardarListener(ActionListener l) {
        btnGuardar.addActionListener(l);
    }
}
