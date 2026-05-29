package controller;

import general.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Oferta;
import modelo.Postulante;
import view.FrmPostulacion;

public class ControladorPostulacion {
    private FrmPostulacion vista;

    public ControladorPostulacion(FrmPostulacion vista) {
        this.vista = vista;
        cargarOfertas();

        this.vista.button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = vista.jTable1.getSelectedRow();
                if (fila < 0) {
                    JOptionPane.showMessageDialog(vista, "Seleccione una oferta");
                    return;
                }

                Oferta[] activas = Sistema.ofertas.getOfertasActivas();
                if (fila >= activas.length) return;

                Postulante postulante = (Postulante) Sistema.conectado;
                boolean resultado = postulante.postular(activas[fila]);

                if (resultado) {
                    JOptionPane.showMessageDialog(vista, "Postulacion registrada correctamente");
                } else {
                    JOptionPane.showMessageDialog(vista, "No se pudo registrar la postulacion");
                }
            }
        });

        this.vista.jTable1.getSelectionModel().addListSelectionListener(e -> {
            int fila = vista.jTable1.getSelectedRow();
            if (fila >= 0) {
                Oferta[] activas = Sistema.ofertas.getOfertasActivas();
                if (fila < activas.length) {
                    vista.textField1.setText(activas[fila].getPuesto());
                    vista.textField2.setText(activas[fila].getArea());
                }
            }
        });
    }

    private void cargarOfertas() {
        DefaultTableModel model = (DefaultTableModel) vista.jTable1.getModel();
        model.setRowCount(0);
        Oferta[] activas = Sistema.ofertas.getOfertasActivas();
        for (Oferta o : activas) {
            model.addRow(new Object[]{o.getPuesto(), o.getArea()});
        }
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}