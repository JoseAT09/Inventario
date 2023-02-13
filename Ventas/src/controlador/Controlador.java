package controlador;

import conex.Conexion;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.*;
import vista.*;

/**
 *
 * @author josea
 */
public class Controlador implements ActionListener {

    private final HomeVista ventanaHome;
    private VentaVista ventVenta;
    private CompraVista ventCompra;
    private InvenVista ventInventario;

    private Conexion cn;
    private Statement st;
    private ResultSet rs;

    private Archivos conexion = new Archivos();
    private ArrayList<Producto> listaProductos = new ArrayList();
    private ArrayList<Cliente> listaClientes = new ArrayList();
    private ArrayList<String> listaCompras = new ArrayList();

    public Controlador() {

        cargaDatos();
        ventanaHome = new HomeVista();
        //setImgLabel(ventanaHome.getLabelImg(), "src/icon/inventario.png");
        ventanaHome.setVisible(true);
        accion();
    }

    public final void accion() {
        ventanaHome.btnCompra.addActionListener(this);
        ventanaHome.btnVenta.addActionListener(this);
        ventanaHome.btnInventario.addActionListener(this);
        ventanaHome.btnClientes.addActionListener(this);
    }

    private void selectProdVenta(String pro) {

        for (Producto lisPro : listaProductos) {
            String[] prod = ventVenta.getBoxProductos().getSelectedItem().toString().split(" ");
            if (Integer.parseInt(prod[0]) == lisPro.getId()) {
                int cant = Integer.parseInt(ventVenta.getFieldCantProducto().getText());
                int val = precioVenta(lisPro);
                int total = val * cant;
                ventVenta.getFieldValorProducto().setText(String.valueOf(val));
                ventVenta.getFieldTotalProduc().setText(String.valueOf(total));
            }
        }
    }

    private int precioVenta(Producto pro) {

        int preComp = pro.getPrecioPromedio();
        int total = (int) (preComp * 1.1);
        return total;
    }

    private void cargarVentanaVenta() {
        ventVenta = new VentaVista(ventanaHome, true);
        ventVenta.getBoxProductos().addActionListener(this);
        ventVenta.getBtnVender().addActionListener(this);

        for (Producto pro : listaProductos) {
            ventVenta.getBoxProductos().addItem(pro.getId() + " " + pro.getNombre());
        }
        for (Cliente cl : listaClientes) {
            if (cl.getId() != 0) {
                ventVenta.getBoxClientes().addItem(String.valueOf(cl.getId() + "-" + cl.getNombre() + " " + cl.getApellido()));
            }
        }
        ventVenta.setVisible(true);

    }

    private void cargarVentanaCompra() {
        ventCompra = new CompraVista(ventanaHome, true);
        ventCompra.getBoxProduc().addActionListener(this);
        ventCompra.getBtnRegistrar().addActionListener(this);

        for (Producto pro : listaProductos) {
            ventCompra.getBoxProduc().addItem(pro.getId() + " " + pro.getNombre());
        }
        listarMovimientos();
        ventCompra.setVisible(true);
    }

    private void cargarVentanaInventario() {
        ventInventario = new InvenVista(ventanaHome, true);
        ventInventario.getBtnArqueo().addActionListener(this);
        ventInventario.getBtnArqueo().setEnabled(false);
        listarInventario();
        ventInventario.getListInventario().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ventInventario.getBtnArqueo().setEnabled(true);
            }
        });
        ventInventario.setVisible(true);
    }

    private void registrarVenta() {
        int cant = Integer.parseInt(ventVenta.getFieldCantProducto().getText());
        int val = Integer.parseInt(ventVenta.getFieldValorProducto().getText());
        String[] client = ventVenta.getBoxClientes().getSelectedItem().toString().split("-");
        String[] prod = ventVenta.getBoxProductos().getSelectedItem().toString().split(" ");
        try {
            cn = new Conexion();
            st = cn.getConnection().createStatement();
            rs = st.executeQuery("select * from producto WHERE id_Producto = '" + prod[0] + "';");
            rs.next();
            int newCant = rs.getInt("cantidad") - cant;
            if (newCant >= 0) {
                st.executeUpdate("UPDATE producto SET cantidad = '" + newCant + "' WHERE id_Producto = '" + prod[0] + "';");
                st.executeUpdate("INSERT INTO movimientos (id_Cliente,id_Producto,id_Tipo,cantidad,valor_Unitario) VALUES ('" + client[0] + "', '" + prod[0] + "',2,'" + cant + "','" + val + "');");
                JOptionPane.showMessageDialog(ventVenta, "La Venta se ha registrado correctamente!");
                ventVenta.dispose();
            } else {
                JOptionPane.showMessageDialog(ventVenta, "No hay suficiente Stock");
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.out.println("EFE: " + e);
        }
    }

    private void registrarCompra() {
        int cant = Integer.parseInt(ventCompra.getFieldCantidad().getText());
        int val = Integer.parseInt(ventCompra.getFieldPrecioCompra().getText());
        String[] prod = ventCompra.getBoxProduc().getSelectedItem().toString().split(" ");
        try {
            cn = new Conexion();
            st = cn.getConnection().createStatement();
            if (ventCompra.getNewProduc()) {
                st.executeUpdate("INSERT INTO producto (nombre,precio_Promedio,cantidad) VALUES ('" + prod[1] + "','" + val + "','" + cant + "');");
                ventCompra.falseNewProduc();
            } else {

                rs = st.executeQuery("select * from producto WHERE id_Producto = '" + prod[0] + "';");
                rs.next();
                int newCant = rs.getInt("cantidad") + cant;
                int newValor = (rs.getInt("cantidad") * rs.getInt("precio_Promedio") + val * cant) / newCant;
                st.executeUpdate("UPDATE producto SET cantidad = '" + newCant + "' WHERE id_Producto = '" + prod[0] + "';");
                st.executeUpdate("UPDATE producto SET precio_Promedio = '" + newValor + "' WHERE id_Producto = '" + prod[0] + "';");
            }
            st.executeUpdate("INSERT INTO movimientos (id_Cliente,id_Producto,id_Tipo,cantidad,valor_Unitario) VALUES ('" + 0 + "', '" + prod[0] + "',1,'" + cant + "','" + val + "');");
            listarMovimientos();
            JOptionPane.showMessageDialog(ventCompra, "La Compra se ha registrado correctamente!");

            cn.getConnection().close();
        } catch (Exception e) {
            System.out.println("EFE: " + e);
        }
    }

    private void listarMovimientos() {
        String[] prod = ventCompra.getBoxProduc().getSelectedItem().toString().split(" ");
        try {
            cn = new Conexion();
            st = cn.getConnection().createStatement();
            rs = st.executeQuery("select * from movimientos WHERE id_Producto = '" + prod[0] + "' and id_Tipo = 1;");
            DefaultListModel<String> modelo = new DefaultListModel<>();
            ventCompra.getListaCompras().setModel(modelo);
            while (rs.next()) {
                modelo.addElement(rs.getInt("id") + "     " + rs.getInt("id_Cliente") + "     " + rs.getInt("id_Producto") + "    " + rs.getInt("id_Tipo") + "    " + rs.getInt("cantidad") + "    " + rs.getInt("valor_Unitario"));
            }
            cn.getConnection().close();
        } catch (Exception e) {

        }
    }

    private void listarInventario() {
        try {
            cn = new Conexion();
            st = cn.getConnection().createStatement();
            rs = st.executeQuery("select * from producto");
            DefaultListModel<String> modelo = new DefaultListModel<>();
            ventInventario.getListInventario().setModel(modelo);
            while (rs.next()) {
                modelo.addElement(rs.getInt("id_Producto") + "     " + rs.getString("nombre") + "     " + rs.getInt("precio_Promedio") + "    " + rs.getInt("cantidad"));
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.out.println("EFE Inven");
        }
    }

    private void realizarArqueo() {
        try {
            String[] prod = ventInventario.getListInventario().getSelectedValue().split("     ");
            int cant = Integer.parseInt(JOptionPane.showInputDialog(ventInventario, "Ingrese la cantidad correcta:",
                    "Está Corrigiendo: " + prod[1], JOptionPane.QUESTION_MESSAGE));
            int val = Integer.parseInt(JOptionPane.showInputDialog(ventInventario, "Ingrese el valor correcto:",
                    "Está Corrigiendo: " + prod[1], JOptionPane.QUESTION_MESSAGE));
            cn = new Conexion();
            st = cn.getConnection().createStatement();
            if (cant != -1 && val != -1) {

                rs = st.executeQuery("select * from producto WHERE id_Producto = '" + prod[0] + "';");
                rs.next();
                st.executeUpdate("UPDATE producto SET cantidad = '" + cant + "' WHERE id_Producto = '" + prod[0] + "';");
                st.executeUpdate("UPDATE producto SET precio_Promedio = '" + val + "' WHERE id_Producto = '" + prod[0] + "';");
                st.executeUpdate("INSERT INTO movimientos (id_Cliente,id_Producto,id_Tipo,cantidad,valor_Unitario) VALUES ('" + 0 + "', '" + prod[0] + "',3,'" + cant + "','" + val + "');");
                listarInventario();
                JOptionPane.showMessageDialog(ventCompra, "La Modificación se ha registrado correctamente!");
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.out.println("EFE: " + e);
        }
    }

    private void cargaDatos() {

        try {
            cn = new Conexion();
            st = cn.getConnection().createStatement();
            rs = st.executeQuery("select * from Cliente");
            while (rs.next()) {
                int id_Client = rs.getInt("id_Cliente");
                String name = rs.getString("first_Name");
                String last_Name = rs.getString("last_Name");

                listaClientes.add(new Cliente(id_Client, name, last_Name));
            }
            rs = st.executeQuery("select * from Producto");
            while (rs.next()) {
                int id_Produc = rs.getInt("id_Producto");
                String name = rs.getString("nombre");
                int precio = rs.getInt("precio_Promedio");
                int cant = rs.getInt("cantidad");
                listaProductos.add(new Producto(id_Produc, name, precio, cant));
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.out.println("EFE: " + e);
        }
    }
    
    private void setImgLabel(JLabel lbl, String ruta) {
        ImageIcon img = new ImageIcon(ruta);
        Icon icon = new ImageIcon(img.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(icon);
        ventanaHome.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object evt = e.getSource();
        try {

            if (evt.equals(ventanaHome.btnVenta)) {
                cargarVentanaVenta();
            }
            if (evt.equals(ventanaHome.btnCompra)) {
                cargarVentanaCompra();
            }
            if (evt.equals(ventanaHome.btnInventario)) {
                //JOptionPane.showMessageDialog(ventanaHome, "Esta función todavia está en desarrollo", "LO SENTIMOS!", 1);
                cargarVentanaInventario();
            }
            if (evt.equals(ventanaHome.btnClientes)) {
                JOptionPane.showMessageDialog(ventanaHome, "Esta función todavia está en desarrollo", "LO SENTIMOS!", 1);
            }
            if (evt.equals(ventCompra.getBtnRegistrar())) {
                registrarCompra();
                listarMovimientos();
            }
            if (evt.equals(ventCompra.getBoxProduc())) {
                listarMovimientos();
            }
            if (evt.equals(ventVenta.getBoxProductos())) {
                selectProdVenta(String.valueOf(ventVenta.getBoxProductos().getSelectedItem()));
            }
            if (evt.equals(ventVenta.getBtnVender())) {
                registrarVenta();
            }
            if (evt.equals(ventInventario.getBtnArqueo())) {
                realizarArqueo();
            }
            if (evt.equals(ventInventario.getListInventario())) {
                ventInventario.getBtnArqueo().setEnabled(true);
            }
        } catch (Exception ex) {

        }
    }
}
