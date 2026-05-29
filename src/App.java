import controlador.ControladorLogin;
import general.Sistema;
import modelo.GradoEstudio;
import modelo.Rubro;
import view.FrmLogin;

public class App {
    public static void main(String[] args) {
        Sistema.rubros.add(new Rubro("Tecnologia"));
        Sistema.rubros.add(new Rubro("Finanzas"));
        Sistema.rubros.add(new Rubro("Salud"));
        Sistema.rubros.add(new Rubro("Educacion"));
        Sistema.rubros.add(new Rubro("Retail"));

        Sistema.grados.add(new GradoEstudio("Bachiller"));
        Sistema.grados.add(new GradoEstudio("Magister"));
        Sistema.grados.add(new GradoEstudio("Doctor"));
        Sistema.grados.add(new GradoEstudio("Tecnico"));

        FrmLogin fLogin = new FrmLogin();
        ControladorLogin controlador = new ControladorLogin(fLogin);
        controlador.iniciar();
    }
}