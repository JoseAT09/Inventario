package vista;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import modelo.Archivos;

/**
 *
 * @author josea
 */
public class HomeVista extends javax.swing.JFrame {

        
    //Archivos conexion = new Archivos();
    //ArrayList<String> listaProductos = new ArrayList();
    //ArrayList<String> listaClientes = new ArrayList();
    //ArrayList<String> listaCompras = new ArrayList();

    /**
     * Creates new form HomeVista
     */

    public HomeVista() {
        initComponents();
        setImgLabel(this.labelImg, "src/icon/inven1.png");
        //actualizarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrin = new javax.swing.JPanel();
        btnCompra = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        labelImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INVENTARIO");

        btnCompra.setText("Compra");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        btnInventario.setText("Inventario");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnClientes.setText("Clientes");

        btnVenta.setText("Venta");

        labelImg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelPrinLayout = new javax.swing.GroupLayout(jPanelPrin);
        jPanelPrin.setLayout(jPanelPrinLayout);
        jPanelPrinLayout.setHorizontalGroup(
            jPanelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrinLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPrinLayout.createSequentialGroup()
                        .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnInventario)
                        .addGap(30, 30, 30)
                        .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        jPanelPrinLayout.setVerticalGroup(
            jPanelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrinLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(labelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed

    }//GEN-LAST:event_btnCompraActionPerformed
    /*
    private void actualizarDatos() {
        try { 
            String[] datosClientes = conexion.leerDatos("Clientes").split("\n");
            for (String registro : datosClientes) {
                String[] datos = registro.split(";");
                listaClientes.add(datos[1]);    
            }
            String[] datosProductos = conexion.leerDatos("Productos").split("\n");
            for (String registro : datosProductos) {
                String[] datos = registro.split(";");
                listaProductos.add(registro);
            }
            String[] datosCompra = conexion.leerDatos("Compras").split("\n");
            for (String registro : datosCompra) {
                String[] datos = registro.split(";");
                listaCompras.add(registro);
            }
        } catch (Exception e) {
            System.out.println("EFE");
        }
    }*/
    private void setImgLabel(JLabel lbl, String ruta) {
        ImageIcon img = new ImageIcon(ruta);
        Icon icon = new ImageIcon(img.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(icon);
        this.repaint();
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnClientes;
    public javax.swing.JButton btnCompra;
    public javax.swing.JButton btnInventario;
    public javax.swing.JButton btnVenta;
    private javax.swing.JPanel jPanelPrin;
    private javax.swing.JLabel labelImg;
    // End of variables declaration//GEN-END:variables
}
