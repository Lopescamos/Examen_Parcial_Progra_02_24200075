package modelo;

public class RubroArreglo {
    private Rubro[] rubros;
    private int indice;

    public RubroArreglo(int tamanio) {
        this.rubros = new Rubro[tamanio];
        this.indice = 0;
    }

    public boolean add(Rubro r) {
        if (this.indice < this.rubros.length) {
            this.rubros[this.indice] = r;
            this.indice++;
            return true;
        }
        return false;
    }

    public Rubro[] getRubros() {
        Rubro[] result = new Rubro[this.indice];
        for (int i = 0; i < this.indice; i++) {
            result[i] = this.rubros[i];
        }
        return result;
    }

    public Rubro getRubro(String nombre) {
        for (int i = 0; i < this.indice; i++) {
            if (this.rubros[i].getNombre().equalsIgnoreCase(nombre)) {
                return this.rubros[i];
            }
        }
        return null;
    }
}