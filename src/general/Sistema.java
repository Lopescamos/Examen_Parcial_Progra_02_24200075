package general;

import modelo.ClienteArreglo;
import modelo.GradoEstudioArreglo;
import modelo.OfertaArreglo;
import modelo.PostulanteArreglo;
import modelo.RubroArreglo;

public class Sistema {
    public static ClienteArreglo clientes = new ClienteArreglo(50);
    public static PostulanteArreglo postulantes = new PostulanteArreglo(100);
    public static RubroArreglo rubros = new RubroArreglo(20);
    public static GradoEstudioArreglo grados = new GradoEstudioArreglo(10);
    public static OfertaArreglo ofertas = new OfertaArreglo(100);
    public static Object conectado = null;
    public static String tipoConectado = "";
}