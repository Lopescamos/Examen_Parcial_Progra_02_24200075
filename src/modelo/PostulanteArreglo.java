package modelo;

public class PostulanteArreglo {
    private Postulante[] postulantes;
    private int indice;

    public PostulanteArreglo(int tamanio) {
        this.postulantes = new Postulante[tamanio];
        this.indice = 0;
    }

    public boolean add(Postulante p) {
        if (this.indice < this.postulantes.length) {
            this.postulantes[this.indice] = p;
            this.indice++;
            return true;
        }
        return false;
    }

    public Postulante ingresar(String email, String clave) {
        for (int i = 0; i < this.indice; i++) {
            if (this.postulantes[i].ingresar(email, clave)) {
                return this.postulantes[i];
            }
        }
        return null;
    }

    public boolean existeEmail(String email) {
        for (int i = 0; i < this.indice; i++) {
            if (this.postulantes[i].getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public Postulante[] getPostulantes() {
        Postulante[] result = new Postulante[this.indice];
        for (int i = 0; i < this.indice; i++) {
            result[i] = this.postulantes[i];
        }
        return result;
    }
}