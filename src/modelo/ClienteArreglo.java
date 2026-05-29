package modelo;

public class ClienteArreglo {
    private Cliente[] clientes;
    private int indice;

    public ClienteArreglo(int tamanio) {
        this.clientes = new Cliente[tamanio];
        this.indice = 0;
    }

    public boolean add(Cliente c) {
        if (this.indice < this.clientes.length) {
            this.clientes[this.indice] = c;
            this.indice++;
            return true;
        }
        return false;
    }

    public Cliente ingresar(String email, String clave) {
        for (int i = 0; i < this.indice; i++) {
            if (this.clientes[i].ingresar(email, clave)) {
                return this.clientes[i];
            }
        }
        return null;
    }

    public boolean existeRuc(String ruc) {
        for (int i = 0; i < this.indice; i++) {
            if (this.clientes[i].getRuc().equals(ruc)) {
                return true;
            }
        }
        return false;
    }

    public Cliente[] getClientes() {
        Cliente[] result = new Cliente[this.indice];
        for (int i = 0; i < this.indice; i++) {
            result[i] = this.clientes[i];
        }
        return result;
    }
}