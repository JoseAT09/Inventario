package vista;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Archivos;

/**
 *
 * @author josea
 */
public class CompraVista extends javax.swing.JDialog {

    Archivos conexion;
    ArrayList<String> listaProductos;
    ArrayList<String> listaCompras;
    private boolean producNew = false;

    /**
     * Creates new form CompraVista
     */
    public CompraVista(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public CompraVista(java.awt.Frame parent, boolean modal, Archivos conexion, ArrayList<String> productos, ArrayList<String> compras) {
        super(parent, modal);
        this.conexion = conexion;
        this.listaProductos = productos;
        this.listaCompras = compras;
        initComponents();
        actualizarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrin = new javax.swing.JPanel();
        labelCompra = new javax.swing.JLabel();
        boxProduc = new javax.swing.JComboBox<>();
        fieldPrecioCompra = new javax.swing.JTextField();
        fieldCantidad = new javax.swing.JTextField();
        labelProductos = new javax.swing.JLabel();
        labelPrecioCompra = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        btnAddProduc = new javax.swing.JButton();
        scrollListaCompras = new javax.swing.JScrollPane();
        listCompras = new javax.swing.JList<>();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelCompra.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        labelCompra.setText("COMPRA");

        fieldPrecioCompra.setText("0");
        fieldPrecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPrecioCompraActionPerformed(evt);
            }
        });

        fieldCantidad.setText("1");
        fieldCantidad.setToolTipText("");
        fieldCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCantidadActionPerformed(evt);
            }
        });

        labelProductos.setText("Productos");

        labelPrecioCompra.setText("Precio Compra");

        labelCantidad.setText("Cantidad");

        btnAddProduc.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btnAddProduc.setText("+");
        btnAddProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProducActionPerformed(evt);
            }
        });

        scrollListaCompras.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        scrollListaCompras.setViewportView(listCompras);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrinLayout = new javax.swing.GroupLayout(panelPrin);
        panelPrin.setLayout(panelPrinLayout);
        panelPrinLayout.setHorizontalGroup(
            panelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrinLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrinLayout.createSequentialGroup()
                        .addGroup(panelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelPrinLayout.createSequentialGroup()
                                .addGroup(panelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPrinLayout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(labelProductos))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrinLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(boxProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddProduc)))
                                .addGap(32, 32, 32)
                                .addGroup(panelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPrecioCompra))
                                .addGap(26, 26, 26)
                                .addGroup(panelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelCantidad))
                                .addGap(47, 47, 47)
                                .addComponent(btnRegistrar))
                            .addComponent(scrollListaCompras))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrinLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelCompra)
                        .addGap(150, 150, 150))))
        );
        panelPrinLayout.setVerticalGroup(
            panelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrinLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProductos)
                    .addComponent(labelPrecioCompra)
                    .addComponent(labelCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddProduc)
                    .addComponent(boxProduc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRegistrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(scrollListaCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProducActionPerformed
        // TODO add your handling code here:
        String nomPro = (String) JOptionPane.showInputDialog("Ingrese el nombre del producto");
        if (nomPro != null && nomPro.length() > 2) {
            int id = boxProduc.getItemCount() + 1;
            boxProduc.addItem(id + " " + nomPro);
            boxProduc.setSelectedItem(id + " " + nomPro);
            producNew = true;
        } else {
            JOptionPane.showMessageDialog(this, "No se agrego el producto!");
        }
    }//GEN-LAST:event_btnAddProducActionPerformed

    private void fieldCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCantidadActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_fieldCantidadActionPerformed

    private void fieldPrecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPrecioCompraActionPerformed
        // TODO add your handling code here:
        /*try {

            int total = (int) (1.1 * Integer.parseInt(fieldPrecioCompra.getText()));
            fieldPrecioVenta.setText(String.valueOf(total));
        } catch (Exception e) {
            System.out.println("EFE"); 
        }*/
    }//GEN-LAST:event_fieldPrecioCompraActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */
    private void actualizarDatos() {

        /*for (String p : listaProductos) {
            String[] datos = p.split(";");
            boxProduc.addItem(datos[0]);
        }*/
    }

    public JComboBox<String> getBoxProduc() {
        return boxProduc;
    }

    public JButton getBtnAddProduc() {
        return btnAddProduc;
    }

    public JTextField getFieldCantidad() {
        return fieldCantidad;
    }

    public JTextField getFieldPrecioCompra() {
        return fieldPrecioCompra;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public boolean getNewProduc() {
        return producNew;
    }

    public void falseNewProduc() {
        producNew = false;
    }

    public JList<String> getListaCompras() {
        return listCompras;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxProduc;
    private javax.swing.JButton btnAddProduc;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField fieldCantidad;
    private javax.swing.JTextField fieldPrecioCompra;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCompra;
    private javax.swing.JLabel labelPrecioCompra;
    private javax.swing.JLabel labelProductos;
    private javax.swing.JList<String> listCompras;
    private javax.swing.JPanel panelPrin;
    private javax.swing.JScrollPane scrollListaCompras;
    // End of variables declaration//GEN-END:variables
}