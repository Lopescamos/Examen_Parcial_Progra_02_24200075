package modelo;

public class OfertaArreglo {
    private Oferta[] ofertas;
    private int indice;

    public OfertaArreglo(int tamanio) {
        this.ofertas = new Oferta[tamanio];
        this.indice = 0;
    }

    public boolean add(Oferta o) {
        if (this.indice < this.ofertas.length) {
            this.ofertas[this.indice] = o;
            this.indice++;
            return true;
        }
        return false;
    }

    public boolean eliminar(Oferta o) {
        for (int i = 0; i < this.indice; i++) {
            if (this.ofertas[i] == o) {
                for (int j = i; j < this.indice - 1; j++) {
                    this.ofertas[j] = this.ofertas[j + 1];
                }
                this.indice--;
                return true;
            }
        }
        return false;
    }

    public Oferta[] getOfertas() {
        Oferta[] result = new Oferta[this.indice];
        for (int i = 0; i < this.indice; i++) {
            result[i] = this.ofertas[i];
        }
        return result;
    }

    public Oferta[] getOfertasActivas() {
        int count = 0;
        for (int i = 0; i < this.indice; i++) {
            if (this.ofertas[i].isActiva()) count++;
        }
        Oferta[] result = new Oferta[count];
        int j = 0;
        for (int i = 0; i < this.indice; i++) {
            if (this.ofertas[i].isActiva()) {
                result[j] = this.ofertas[i];
                j++;
            }
        }
        return result;
    }
}