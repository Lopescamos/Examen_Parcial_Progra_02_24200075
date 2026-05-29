package modelo;

import java.util.Date;

public class Postulante {
    private String email;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Date nacimiento;
    private String clave;
    private GradoEstudio gradoEstudio;
    private Postulacion[] postulaciones;
    private int indicePostulaciones;

    public Postulante(String email, String nombres, String apellidos, String direccion, Date nacimiento) {
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.clave = generarClave(email);
        this.postulaciones = new Postulacion[50];
        this.indicePostulaciones = 0;
    }

    private String generarClave(String email) {
        return email.substring(0, 3) + "2024";
    }

    public String getEmail() {
        return email;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public String getClave() {
        return clave;
    }

    public GradoEstudio getGradoEstudio() {
        return gradoEstudio;
    }

    public boolean ingresar(String email, String clave) {
        return this.email.equals(email) && this.clave.equals(clave);
    }

    public boolean asignarGradoEstudio(GradoEstudio grado) {
        this.gradoEstudio = grado;
        return true;
    }

    public boolean postular(Oferta oferta) {
        if (this.indicePostulaciones < this.postulaciones.length) {
            this.postulaciones[this.indicePostulaciones] = new Postulacion(oferta);
            this.indicePostulaciones++;
            return true;
        }
        return false;
    }

    public boolean anularPostulacion(Postulacion postulacion) {
        for (int i = 0; i < this.indicePostulaciones; i++) {
            if (this.postulaciones[i] == postulacion) {
                this.postulaciones[i].anular();
                return true;
            }
        }
        return false;
    }

    public Postulacion[] getPostulaciones() {
        Postulacion[] result = new Postulacion[this.indicePostulaciones];
        for (int i = 0; i < this.indicePostulaciones; i++) {
            result[i] = this.postulaciones[i];
        }
        return result;
    }

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }
}