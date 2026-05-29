package modelo;

import java.util.Date;

public class Postulacion {
    private Date fecha;
    private boolean anulado;
    private Date fechaAnulacion;
    private Oferta oferta;

    public Postulacion(Oferta oferta) {
        this.oferta = oferta;
        this.fecha = new Date();
        this.anulado = false;
        this.fechaAnulacion = null;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean isAnulado() {
        return anulado;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void anular() {
        this.anulado = true;
        this.fechaAnulacion = new Date();
    }

    @Override
    public String toString() {
        return oferta.getPuesto() + " - " + fecha;
    }
}