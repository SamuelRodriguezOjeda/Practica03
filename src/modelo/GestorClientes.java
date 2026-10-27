
package modelo;

import java.util.ArrayList;

public class GestorClientes {

    private final ArrayList<Cliente> clientes = new ArrayList<>();

    public void añadir(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente get(int indice) {
        return clientes.get(indice);
    }

    public int total() {
        return clientes.size();
    }
}
