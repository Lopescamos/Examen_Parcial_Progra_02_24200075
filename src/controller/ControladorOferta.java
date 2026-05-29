package controller;

import general.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Oferta;
import view.FrmOferta;

public class ControladorOferta {
    private FrmOferta vista;

    public ControladorOferta(FrmOferta vista) {
        this.vista = vista;

        this.vista.button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String puesto = vista.textField1.getText().trim();
                String area = vista.textField2.getText().trim();
                String descripcion = vista.textField3.getText().trim();
                String requisito = vista.textField4.getText().trim();

                if (puesto.isEmpty() || area.isEmpty() || descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "Complete los campos obligatorios");
                    return;
                }

                Cliente cliente = (Cliente) Sistema.conectado;
                Date inicio = new Date();
                Date termino = new Date(inicio.getTime() + (30L * 24 * 60 * 60 * 1000));

                Oferta oferta = new Oferta(puesto, descripcion, area, inicio, termino);
                if (!requisito.isEmpty()) {
                    oferta.agregarRequisito(1, requisito);
                }

                cliente.agregarOferta(oferta);
                Sistema.ofertas.add(oferta);

                JOptionPane.showMessageDialog(vista, "Oferta registrada correctamente");
                limpiar();
            }
        });
    }

    private void limpiar() {
        vista.textField1.setText("");
        vista.textField2.setText("");
        vista.textField3.setText("");
        vista.textField4.setText("");
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}