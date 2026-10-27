
import controlador.ControladorClientes;
import controlador.ListaClientes;
import java.time.LocalDate;
import javax.swing.SwingUtilities;
import modelo.Cliente;
import vista.VistaClientes;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ListaClientes lista = new ListaClientes();

            lista.anadirCliente(new Cliente(
                    1, "Ana Lopez", 150,
                    LocalDate.of(1992, 5, 14)));

            lista.anadirCliente(new Cliente(
                    2, "Luis Perez", 320,
                    LocalDate.of(1985, 8, 20)));

            lista.anadirCliente(new Cliente(
                    3, "Marta Ruiz", 90,
                    LocalDate.of(2001, 3, 10)));

            lista.anadirCliente(new Cliente(
                    4, "Pablo Gomez", 450,
                    LocalDate.of(1978, 11, 2)));

            lista.anadirCliente(new Cliente(
                    5, "Lucia Torres", 200,
                    LocalDate.of(1999, 1, 25)));

            lista.ordenarPorNumero();
            lista.irAlPrimero();

            VistaClientes vista = new VistaClientes();

            new ControladorClientes(lista, vista);

            vista.setVisible(true);
        });
    }
}
