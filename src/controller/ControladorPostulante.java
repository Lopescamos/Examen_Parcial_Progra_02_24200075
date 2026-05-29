package controller;

import general.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.GradoEstudio;
import modelo.Postulante;
import view.FrmPostulante;

public class ControladorPostulante {
    private FrmPostulante vista;

    public ControladorPostulante(FrmPostulante vista) {
        this.vista = vista;
        cargarGrados();

        this.vista.button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = vista.textField1.getText().trim();
                String nombres = vista.textField2.getText().trim();
                String apellidos = vista.textField3.getText().trim();
                String direccion = vista.textField4.getText().trim();
                String gradoDesc = (String) vista.jComboBox1.getSelectedItem();

                if (email.isEmpty() || nombres.isEmpty() || apellidos.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "Complete todos los campos");
                    return;
                }

                if (Sistema.postulantes.existeEmail(email)) {
                    JOptionPane.showMessageDialog(vista, "El email ya esta registrado");
                    return;
                }

                Postulante postulante = new Postulante(email, nombres, apellidos, direccion, new Date());
                GradoEstudio grado = Sistema.grados.getGrado(gradoDesc);
                if (grado != null) {
                    postulante.asignarGradoEstudio(grado);
                }
                Sistema.postulantes.add(postulante);

                JOptionPane.showMessageDialog(vista, "Postulante registrado. Clave: " + postulante.getClave());
                vista.dispose();
            }
        });
    }

    private void cargarGrados() {
        vista.jComboBox1.removeAllItems();
        GradoEstudio[] grados = Sistema.grados.getGrados();
        for (GradoEstudio g : grados) {
            vista.jComboBox1.addItem(g.getDescripcion());
        }
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}