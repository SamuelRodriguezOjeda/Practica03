
package controlador;

import java.util.ArrayList;
import java.util.Comparator;
import modelo.Cliente;

public class ListaClientes extends ArrayList<Cliente> {

    private int actual;

    public ListaClientes() {
        super();
        actual = -1;
    }

    // Comprobar si está vacía
    public boolean esVacia() {
        return isEmpty();
    }

    // Avanzar al siguiente cliente
    public boolean avanzar() {
        if (actual < size() - 1) {
            actual++;
            return true;
        }
        return false;
    }

    // Retroceder al anterior
    public boolean retroceder() {
        if (actual > 0) {
            actual--;
            return true;
        }
        return false;
    }

    // Ir al primero
    public void irAlPrimero() {
        actual = isEmpty() ? -1 : 0;
    }

    // Ir al último
    public void irAlUltimo() {
        actual = isEmpty() ? -1 : size() - 1;
    }

    // Comprobar si es el primero
    public boolean esPrimero() {
        return !isEmpty() && actual == 0;
    }

    // Comprobar si es el último
    public boolean esUltimo() {
        return !isEmpty() && actual == size() - 1;
    }

    // Obtener el cliente actual
    public Cliente obtenerActual() {
        if (actual < 0 || actual >= size()) {
            return null;
        }
        return get(actual);
    }

    // Añadir un cliente
    public void anadirCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException(
                    "El cliente no puede ser null");
        }

        add(cliente);

        if (actual == -1) {
            actual = 0;
        }
    }

    // Borrar el cliente actual
    public void borrarCliente() {
        if (actual >= 0 && actual < size()) {
            remove(actual);

            if (isEmpty()) {
                actual = -1;
            } else if (actual >= size()) {
                actual = size() - 1;
            }
        }
    }

    // Ordenar por número de cliente
    public void ordenarPorNumero() {
        Cliente seleccionado = obtenerActual();

        sort(Comparator.comparingInt(Cliente::getNumero));

        if (isEmpty()) {
            actual = -1;
        } else if (seleccionado != null) {
            actual = indexOf(seleccionado);
        } else {
            actual = 0;
        }
    }

    // Obtener el índice actual
    public int getActual() {
        return actual;
    }

    // Cambiar el índice actual
    public void setActual(int actual) {
        if (actual >= 0 && actual < size()) {
            this.actual = actual;
        }
    }
}
