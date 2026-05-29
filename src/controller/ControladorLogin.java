package controller;

import general.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Postulante;
import view.FrmEmpresa;
import view.FrmLogin;
import view.FrmOferta;
import view.FrmPostulante;

public class ControladorLogin {
    private FrmLogin vista;

    public ControladorLogin(FrmLogin vista) {
        this.vista = vista;

        this.vista.button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = vista.textField1.getText();
                String clave = new String(vista.jPasswordField1.getPassword());

                Cliente cliente = Sistema.clientes.ingresar(email, clave);
                if (cliente != null) {
                    Sistema.conectado = cliente;
                    Sistema.tipoConectado = "CLIENTE";
                    vista.dispose();
                    FrmOferta fOferta = new FrmOferta();
                    ControladorOferta ctrl = new ControladorOferta(fOferta);
                    ctrl.iniciar();
                    return;
                }

                Postulante postulante = Sistema.postulantes.ingresar(email, clave);
                if (postulante != null) {
                    Sistema.conectado = postulante;
                    Sistema.tipoConectado = "POSTULANTE";
                    vista.dispose();
                    view.FrmPostulacion fPost = new view.FrmPostulacion();
                    ControladorPostulacion ctrl = new ControladorPostulacion(fPost);
                    ctrl.iniciar();
                    return;
                }

                JOptionPane.showMessageDialog(vista, "Credenciales incorrectas");
            }
        });

        this.vista.button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmEmpresa fEmpresa = new FrmEmpresa();
                ControladorEmpresa ctrl = new ControladorEmpresa(fEmpresa);
                ctrl.iniciar();
            }
        });

        this.vista.button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmPostulante fPostulante = new FrmPostulante();
                ControladorPostulante ctrl = new ControladorPostulante(fPostulante);
                ctrl.iniciar();
            }
        });
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}