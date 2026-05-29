package modelo;

public class Rubro {
    private String nombre;
    private boolean estado;

    public Rubro(String nombre) {
        this.nombre = nombre;
        this.estado = true;
    }

    public String getNombre() {
        return nombre;
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
        return nombre;
    }
}