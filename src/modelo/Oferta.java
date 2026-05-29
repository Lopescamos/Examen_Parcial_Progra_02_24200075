package modelo;

import java.util.Date;

public class Oferta {
    private String puesto;
    private String descripcion;
    private String area;
    private Date fechaInicio;
    private Date fechaTermino;
    private Requisito[] requisitos;
    private int indiceRequisitos;

    public Oferta(String puesto, String descripcion, String area, Date fechaInicio, Date fechaTermino) {
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.area = area;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.requisitos = new Requisito[10];
        this.indiceRequisitos = 0;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getArea() {
        return area;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public boolean agregarRequisito(int orden, String descripcion) {
        if (this.indiceRequisitos < this.requisitos.length) {
            this.requisitos[this.indiceRequisitos] = new Requisito(orden, descripcion);
            this.indiceRequisitos++;
            return true;
        }
        return false;
    }

    public Requisito[] getRequisitos() {
        Requisito[] result = new Requisito[this.indiceRequisitos];
        for (int i = 0; i < this.indiceRequisitos; i++) {
            result[i] = this.requisitos[i];
        }
        return result;
    }

    public boolean eliminarRequisito(int orden) {
        for (int i = 0; i < this.indiceRequisitos; i++) {
            if (this.requisitos[i].getOrden() == orden) {
                for (int j = i; j < this.indiceRequisitos - 1; j++) {
                    this.requisitos[j] = this.requisitos[j + 1];
                }
                this.indiceRequisitos--;
                return true;
            }
        }
        return false;
    }

    public boolean isActiva() {
        Date hoy = new Date();
        return hoy.after(fechaInicio) && hoy.before(fechaTermino);
    }

    @Override
    public String toString() {
        return puesto + " - " + area;
    }
}