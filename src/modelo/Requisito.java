package modelo;

public class Requisito {
    private int orden;
    private String descripcion;
    private boolean estado;

    public Requisito(int orden, String descripcion) {
        this.orden = orden;
        this.descripcion = descripcion;
        this.estado = true;
    }

    public int getOrden() {
        return orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public boolean habilitar() {
        this.estado = true;
        return true;
    }

    public boolean deshabilitar() {
        this.estado = false;
        return true;
    }

    @Override
    public String toString() {
        return orden + " - " + descripcion;
    }
}