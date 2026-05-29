package modelo;

public class GradoEstudioArreglo {
    private GradoEstudio[] grados;
    private int indice;

    public GradoEstudioArreglo(int tamanio) {
        this.grados = new GradoEstudio[tamanio];
        this.indice = 0;
    }

    public boolean add(GradoEstudio g) {
        if (this.indice < this.grados.length) {
            this.grados[this.indice] = g;
            this.indice++;
            return true;
        }
        return false;
    }

    public GradoEstudio[] getGrados() {
        GradoEstudio[] result = new GradoEstudio[this.indice];
        for (int i = 0; i < this.indice; i++) {
            result[i] = this.grados[i];
        }
        return result;
    }

    public GradoEstudio getGrado(String descripcion) {
        for (int i = 0; i < this.indice; i++) {
            if (this.grados[i].getDescripcion().equalsIgnoreCase(descripcion)) {
                return this.grados[i];
            }
        }
        return null;
    }
}