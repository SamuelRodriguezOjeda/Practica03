
package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VistaClientes extends JFrame {

    private CardLayout tarjetas;
    private JPanel panelPrincipal;

    private PanelVisualizar panelVisualizar;
    private PanelNuevo panelNuevo;

    private JMenuItem itemVisualizar;
    private JMenuItem itemNuevo;
    private JMenuItem itemSalir;

    public VistaClientes() {
        super("Gestión de clientes");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Crear los paneles
        tarjetas = new CardLayout();
        panelPrincipal = new JPanel(tarjetas);

        panelVisualizar = new PanelVisualizar();
        panelNuevo = new PanelNuevo();

        panelPrincipal.add(panelVisualizar, "visualizar");
        panelPrincipal.add(panelNuevo, "nuevo");

        add(panelPrincipal, BorderLayout.CENTER);

        // Crear el menú
        JMenuBar barraMenu = new JMenuBar();
        JMenu menu = new JMenu("Clientes");

        itemVisualizar = new JMenuItem("Visualizar");
        itemNuevo = new JMenuItem("Nuevo");
        itemSalir = new JMenuItem("Salir");

        menu.add(itemVisualizar);
        menu.add(itemNuevo);
        menu.addSeparator();
        menu.add(itemSalir);

        barraMenu.add(menu);
        setJMenuBar(barraMenu);

        // Tamaño fijo de la ventana
        setPreferredSize(new Dimension(735, 440));
        pack();

        setLocationRelativeTo(null);
    }

    public void mostrarPanelVisualizar() {
        tarjetas.show(panelPrincipal, "visualizar");
    }

    public void mostrarPanelNuevo() {
        tarjetas.show(panelPrincipal, "nuevo");
    }

    public PanelVisualizar getPanelVisualizar() {
        return panelVisualizar;
    }

    public PanelNuevo getPanelNuevo() {
        return panelNuevo;
    }

    // Eventos del menú
    public void addVisualizarListener(ActionListener l) {
        itemVisualizar.addActionListener(l);
    }

    public void addNuevoListener(ActionListener l) {
        itemNuevo.addActionListener(l);
    }

    public void addSalirListener(ActionListener l) {
        itemSalir.addActionListener(l);
    }
}
