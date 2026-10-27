
package controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import modelo.Cliente;
import vista.PanelNuevo;
import vista.PanelVisualizar;
import vista.VistaClientes;

public class ControladorClientes {

    private ListaClientes lista;
    private VistaClientes vista;

    private DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);

    public ControladorClientes(
            ListaClientes lista, VistaClientes vista) {

        this.lista = lista;
        this.vista = vista;

        // Eventos del menú
        vista.addVisualizarListener(e -> {
            vista.mostrarPanelVisualizar();
            mostrarCliente();
        });

        vista.addNuevoListener(e -> {
            vista.mostrarPanelNuevo();
        });

        vista.addSalirListener(e -> System.exit(0));

        // Eventos del panel visualizar
        PanelVisualizar pv = vista.getPanelVisualizar();

        pv.addPrimeroListener(e -> {
            lista.irAlPrimero();
            mostrarCliente();
        });

        pv.addAnteriorListener(e -> {
            lista.retroceder();
            mostrarCliente();
        });

        pv.addSiguienteListener(e -> {
            lista.avanzar();
            mostrarCliente();
        });

        pv.addUltimoListener(e -> {
            lista.irAlUltimo();
            mostrarCliente();
        });

        pv.addBorrarListener(e -> {
            lista.borrarCliente();
            mostrarCliente();
        });

        pv.addOrdenarListener(e -> {
            lista.ordenarPorNumero();
            mostrarCliente();
        });

        // Evento del panel nuevo
        PanelNuevo pn = vista.getPanelNuevo();
        pn.addGuardarListener(e -> guardarCliente());

        mostrarCliente();
    }

    // Mostrar el cliente actual
    private void mostrarCliente() {

        PanelVisualizar panel = vista.getPanelVisualizar();
        Cliente cliente = lista.obtenerActual();

        if (cliente == null) {
            panel.limpiar();
            panel.actualizarBotones(false, false, false);
            return;
        }

        panel.mostrarCliente(
                String.valueOf(cliente.getNumero()),
                cliente.getNombre(),
                String.valueOf(cliente.getPuntos()),
                cliente.getFechaNacimiento().format(formato),
                lista.getActual() + 1,
                lista.size()
        );

        panel.actualizarBotones(
                lista.esPrimero(),
                lista.esUltimo(),
                true
        );
    }

    // Guardar un cliente nuevo
    private void guardarCliente() {

        PanelNuevo panel = vista.getPanelNuevo();

        try {
            int numero = panel.getNumero();
            String nombre = panel.getNombre();
            float puntos = panel.getPuntos();

            if (numero <= 0) {
                throw new IllegalArgumentException(
                        "El número debe ser positivo");
            }

            if (nombre.isBlank()) {
                throw new IllegalArgumentException(
                        "Debes introducir un nombre");
            }

            if (Float.isNaN(puntos)
                    || Float.isInfinite(puntos)
                    || puntos < 0 || puntos > 1000) {

                throw new IllegalArgumentException(
                        "Los puntos deben estar entre 0 y 1000");
            }

            LocalDate fecha;

            try {
                fecha = LocalDate.parse(
                        panel.getFecha(), formato);

            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException(
                        "Fecha incorrecta. Usa dd/MM/yyyy");
            }

            if (fecha.getYear() < 1900
                    || fecha.getYear() > 2015) {

                throw new IllegalArgumentException(
                        "El año debe estar entre 1900 y 2015");
            }

            Cliente cliente = new Cliente(
                    numero, nombre, puntos, fecha);

            lista.anadirCliente(cliente);
            lista.ordenarPorNumero();

            // Seleccionar el cliente recién añadido
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) == cliente) {
                    lista.setActual(i);
                    break;
                }
            }

            panel.limpiarCampos();
            vista.mostrarPanelVisualizar();
            mostrarCliente();

        } catch (NumberFormatException ex) {
            panel.mostrarError(
                    "Número y puntos deben ser numéricos");

        } catch (IllegalArgumentException ex) {
            panel.mostrarError(ex.getMessage());
        }
    }
}
