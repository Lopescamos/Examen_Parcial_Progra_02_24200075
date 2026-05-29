package controller;

public class Cliente {
    private String ruc;
    private String razonSocial;
    private String email;
    private String contacto;
    private String telefono;
    private String clave;
    private Rubro rubro;
    private Oferta[] ofertas;
    private int indiceOfertas;

    public Cliente(String ruc, String razonSocial, String email, String contacto, String telefono, Rubro rubro) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.email = email;
        this.contacto = contacto;
        this.telefono = telefono;
        this.rubro = rubro;
        this.clave = generarClave(ruc);
        this.ofertas = new Oferta[20];
        this.indiceOfertas = 0;
    }

    private String generarClave(String ruc) {
        return ruc.substring(0, 4) + "2024";
    }

    public String getRuc() {
        return ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getEmail() {
        return email;
    }

    public String getContacto() {
        return contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getClave() {
        return clave;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public boolean ingresar(String email, String clave) {
        return this.email.equals(email) && this.clave.equals(clave);
    }

    public boolean agregarOferta(Oferta oferta) {
        if (this.indiceOfertas < this.ofertas.length) {
            this.ofertas[this.indiceOfertas] = oferta;
            this.indiceOfertas++;
            return true;
        }
        return false;
    }

    public boolean eliminarOferta(Oferta oferta) {
        for (int i = 0; i < this.indiceOfertas; i++) {
            if (this.ofertas[i] == oferta) {
                for (int j = i; j < this.indiceOfertas - 1; j++) {
                    this.ofertas[j] = this.ofertas[j + 1];
                }
                this.indiceOfertas--;
                return true;
            }
        }
        return false;
    }

    public Oferta[] getOfertas() {
        Oferta[] result = new Oferta[this.indiceOfertas];
        for (int i = 0; i < this.indiceOfertas; i++) {
            result[i] = this.ofertas[i];
        }
        return result;
    }

    @Override
    public String toString() {
        return razonSocial + " (" + ruc + ")";
    }
}