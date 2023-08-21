/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Detalle;
import Modelo.LoginDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import Modelo.login;
import Modelo.producto;
import Modelo.productoDAO;
import Modelo.proveedor;
import Modelo.proveedorDAO;
import Reportes.Excel;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stalin
 */
public class Sistema extends javax.swing.JFrame {
    proveedor pr = new proveedor();
    proveedorDAO PrDao = new proveedorDAO();
    producto pro = new producto();
    productoDAO ProDao = new productoDAO();
    Venta v = new Venta();
    VentaDAO VDao = new VentaDAO();
    Detalle Dv = new Detalle();
    login lg = new login();
    LoginDAO login = new LoginDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();
    int item;
    double TotalPagar = 0.00;
    
    public Sistema() {
        initComponents();
    } 
    
    public Sistema(login priva){
        initComponents();
        this.setLocationRelativeTo(null);
        txtId_prov.setVisible(false);
        ProDao.ConsultarProveedor(cbxProveedor);
        ProDao.ConsultarProveedor(cbxnom_provee);
        txtIdprod.setVisible(false);
        txtIdVenta.setVisible(false);

        if(priva.getRol().equals("Asistente")){
            btnProvee.setEnabled(false);
            btnPro.setEnabled(false);
        }
    }
    
    public void ListarProveedor(){
        List<proveedor> Listarpr = PrDao.listarProveedor();
        modelo = (DefaultTableModel) TableProveedor.getModel();
        Object[] ob = new Object[5];
        for (int i=0; i < Listarpr.size(); i++){
            ob[0] = Listarpr.get(i).getId_prov();
            ob[1] = Listarpr.get(i).getRuc();
            ob[2] = Listarpr.get(i).getNombre_pv();
            ob[3] = Listarpr.get(i).getTelefono_pv();
            ob[4] = Listarpr.get(i).getDireccion_pv();
            modelo.addRow(ob);
        }
        TableProveedor.setModel(modelo);
    }
   
    public void ListarProducto(){
        List<producto> Listarpro = ProDao.listarProducto();
        modelo = (DefaultTableModel) TableProducto.getModel();
        Object[] ob = new Object[6];
        for (int i=0; i < Listarpro.size(); i++){
            ob[0] = Listarpro.get(i).getId_prod();
            ob[1] = Listarpro.get(i).getCodigo();
            ob[2] = Listarpro.get(i).getNombre_prod();
            ob[3] = Listarpro.get(i).getProveedor_prod();
            ob[4] = Listarpro.get(i).getStock();
            ob[5] = Listarpro.get(i).getPrecio();
            modelo.addRow(ob);
        }
        TableProducto.setModel(modelo);
    }

    public void LimpiarTable(){
        for (int i=0; i< modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    public void ListarVentas(){
        List<Venta> ListarVenta = VDao.Listarventas();
        modelo = (DefaultTableModel) ReportVentas.getModel();
        Object[] obt = new Object[4];
        for (int i=0; i < ListarVenta.size(); i++){
            obt[0] = ListarVenta.get(i).getId_v();
            obt[1] = ListarVenta.get(i).getProducto();
            obt[2] = ListarVenta.get(i).getProveedor();
            obt[3] = ListarVenta.get(i).getTotal();
            modelo.addRow(obt);
        }
        ReportVentas.setModel(modelo);
    }    
    
    public void ListarUsuarios(){
        List<login> Listar = login.ListarUsuarios();
        modelo = (DefaultTableModel) TableUser.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < Listar.size(); i++) {
            ob[0] = Listar.get(i).getId_u();
            ob[1] = Listar.get(i).getNombre_u();
            ob[2] = Listar.get(i).getCorreo_u();
            ob[3] = Listar.get(i).getRol();
            modelo.addRow(ob);
        }
        TableUser.setModel(modelo);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnVenta = new javax.swing.JButton();
        btnProvee = new javax.swing.JButton();
        btnVen = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnPro = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtcodV = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtStockV = new javax.swing.JTextField();
        txtPrecioV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVenta = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        LabelTotal = new javax.swing.JLabel();
        btnEliminarV = new javax.swing.JButton();
        cbxnom_provee = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableUser = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtnom_user = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cbxrol = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableProveedor = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtnom_pro = new javax.swing.JTextField();
        txt_dir = new javax.swing.JTextField();
        txt_tele = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        txtId_prov = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableProducto = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        txtprod = new javax.swing.JTextField();
        txtcant = new javax.swing.JTextField();
        txtprec = new javax.swing.JTextField();
        cbxProveedor = new javax.swing.JComboBox<>();
        btnguardar_pro = new javax.swing.JButton();
        btnactua_pro = new javax.swing.JButton();
        btndelet_pro = new javax.swing.JButton();
        btnnuevo_pro = new javax.swing.JButton();
        btnexcel = new javax.swing.JButton();
        txtIdprod = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ReportVentas = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        btnPdf = new javax.swing.JButton();
        txtIdVenta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo_pdf.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        btnVenta.setBackground(new java.awt.Color(248, 210, 170));
        btnVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nventa.png"))); // NOI18N
        btnVenta.setText("Nueva Venta");
        btnVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 197, 170, 60));

        btnProvee.setBackground(new java.awt.Color(169, 206, 84));
        btnProvee.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProvee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/proveedor.png"))); // NOI18N
        btnProvee.setText("Proveedor");
        btnProvee.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnProvee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveeActionPerformed(evt);
            }
        });
        getContentPane().add(btnProvee, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 170, 50));

        btnVen.setBackground(new java.awt.Color(137, 243, 130));
        btnVen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/compras.png"))); // NOI18N
        btnVen.setText("Ventas");
        btnVen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnVen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenActionPerformed(evt);
            }
        });
        getContentPane().add(btnVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 170, 50));

        btnUser.setBackground(new java.awt.Color(139, 132, 245));
        btnUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Clientes.png"))); // NOI18N
        btnUser.setText("Usuarios");
        btnUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnUser.setPreferredSize(new java.awt.Dimension(149, 49));
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 170, 50));

        btnPro.setBackground(new java.awt.Color(243, 147, 217));
        btnPro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        btnPro.setText("Productos");
        btnPro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProActionPerformed(evt);
            }
        });
        getContentPane().add(btnPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 170, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane2.setToolTipText("");
        jTabbedPane2.setAutoscrolls(true);
        jTabbedPane2.setDoubleBuffered(true);
        jTabbedPane2.setFocusCycleRoot(true);
        jTabbedPane2.setFocusTraversalPolicyProvider(true);
        jTabbedPane2.setInheritsPopupMenu(true);
        jTabbedPane2.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(249, 228, 199));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Código:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Descripción:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Cant:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Precio:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Stock Disponible:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        txtcodV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodVKeyPressed(evt);
            }
        });
        jPanel2.add(txtcodV, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 52, 30));

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        jPanel2.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 196, 30));

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 52, 31));

        txtStockV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockVActionPerformed(evt);
            }
        });
        jPanel2.add(txtStockV, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 80, 30));

        txtPrecioV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVActionPerformed(evt);
            }
        });
        jPanel2.add(txtPrecioV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 80, 30));

        TableVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        TableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCION", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(TableVenta);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 530, 190));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Nombre:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/money.png"))); // NOI18N
        jLabel15.setText("Total a Pagar:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, -1));

        btnGenerar.setBackground(new java.awt.Color(214, 248, 199));
        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/print.png"))); // NOI18N
        btnGenerar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, -1, -1));

        LabelTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelTotal.setText("-----");
        jPanel2.add(LabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, -1, 20));

        btnEliminarV.setBackground(new java.awt.Color(249, 98, 98));
        btnEliminarV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminarV.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarV.setText("Eliminar Venta");
        btnEliminarV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnEliminarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarV, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 140, 40));

        jPanel2.add(cbxnom_provee, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 160, 30));

        jTabbedPane2.addTab("", jPanel2);

        jPanel3.setBackground(new java.awt.Color(167, 175, 253));

        TableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre:", "Correo:", "Rol:"
            }
        ));
        jScrollPane2.setViewportView(TableUser);

        jPanel7.setBackground(new java.awt.Color(229, 229, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/login11.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Correo Electrónico:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Password:");

        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Nombre:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Rol:");

        cbxrol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Asistente" }));

        btnRegistrar.setBackground(new java.awt.Color(0, 166, 19));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cbxrol, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtnom_user, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnom_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxrol, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        jTabbedPane2.addTab("", jPanel3);

        jPanel4.setBackground(new java.awt.Color(252, 231, 184));

        TableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RUC", "PROVEEDOR", "TELEFONO", "DIRECCION"
            }
        ));
        TableProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableProveedor);

        jPanel8.setBackground(new java.awt.Color(252, 246, 193));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icono_prov.png"))); // NOI18N
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("RUC:");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Nombre:");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Telefono:");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Dirección:");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));
        jPanel8.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 163, 29));
        jPanel8.add(txtnom_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 163, 29));
        jPanel8.add(txt_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 163, 29));
        jPanel8.add(txt_tele, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 163, 29));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnguardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel8.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 60, 40));

        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnactualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        jPanel8.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 60, 40));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btneliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel8.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 60, 40));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N
        btnnuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel8.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 60, 40));
        jPanel8.add(txtId_prov, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 20, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("", jPanel4);

        jPanel5.setBackground(new java.awt.Color(228, 173, 248));

        TableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo", "Producto", "Proveedor", "Cantidad", "Precio"
            }
        ));
        TableProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TableProducto);

        jPanel9.setBackground(new java.awt.Color(252, 197, 219));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icono_prod.png"))); // NOI18N
        jPanel9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Código:");
        jPanel9.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Producto:");
        jPanel9.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Cantidad:");
        jPanel9.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Proveedor:");
        jPanel9.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Precio:");
        jPanel9.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));
        jPanel9.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 160, 30));
        jPanel9.add(txtprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 160, 30));
        jPanel9.add(txtcant, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 160, 30));
        jPanel9.add(txtprec, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 160, 30));

        cbxProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedorActionPerformed(evt);
            }
        });
        jPanel9.add(cbxProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 160, 30));

        btnguardar_pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnguardar_pro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnguardar_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar_proActionPerformed(evt);
            }
        });
        jPanel9.add(btnguardar_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 60, 40));

        btnactua_pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnactua_pro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnactua_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactua_proActionPerformed(evt);
            }
        });
        jPanel9.add(btnactua_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 60, 40));

        btndelet_pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btndelet_pro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btndelet_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelet_proActionPerformed(evt);
            }
        });
        jPanel9.add(btndelet_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 60, 40));

        btnnuevo_pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N
        btnnuevo_pro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnnuevo_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevo_proActionPerformed(evt);
            }
        });
        jPanel9.add(btnnuevo_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 60, 40));

        btnexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel.png"))); // NOI18N
        btnexcel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcelActionPerformed(evt);
            }
        });
        jPanel9.add(btnexcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 40, -1));
        jPanel9.add(txtIdprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 40, 30));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("", jPanel5);

        jPanel6.setBackground(new java.awt.Color(245, 248, 150));

        ReportVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCTO", "PROVEEDOR", "TOTAL"
            }
        ));
        ReportVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReportVentasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(ReportVentas);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel34.setText("REPORTE DE VENTAS");

        btnPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        btnPdf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel34)
                        .addGap(70, 70, 70)
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("", jPanel6);

        jPanel1.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 540));
        jTabbedPane2.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 640, 540));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/encabezado.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 980, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/encabezado.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/encabezado.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 980, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/encabezado.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 980, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtStockVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockVActionPerformed

    private void txtPrecioVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if(!"".equals(txtRuc.getText()) || !"".equals(txtnom_pro.getText()) || !"".equals(txt_dir.getText()) || !"".equals(txt_tele.getText())){
            pr.setRuc(Integer.parseInt(txtRuc.getText()));
            pr.setNombre_pv(txtnom_pro.getText());
            pr.setDireccion_pv(txt_dir.getText());
            pr.setTelefono_pv(Integer.parseInt(txt_tele.getText()));
            PrDao.RegistrarProveedor(pr);
            LimpiarTable();
            LimpiarProveedor();
            ListarProveedor();
            JOptionPane.showMessageDialog(null, "Se ha registrado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Los campos se encuentran vacíos");
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnProveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveeActionPerformed
        jTabbedPane2.setSelectedIndex(2);
        LimpiarTable();
        ListarProveedor();
    }//GEN-LAST:event_btnProveeActionPerformed

    private void TableProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProveedorMouseClicked
        int fila = TableProveedor.rowAtPoint(evt.getPoint());
        txtId_prov.setText(TableProveedor.getValueAt(fila, 0).toString());
        txtRuc.setText(TableProveedor.getValueAt(fila, 1).toString());
        txtnom_pro.setText(TableProveedor.getValueAt(fila, 2).toString());
        txt_tele.setText(TableProveedor.getValueAt(fila, 3).toString());
        txt_dir.setText(TableProveedor.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_TableProveedorMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if(!"".equals(txtRuc.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
            if (pregunta == 0){
                int ruc = Integer.parseInt(txtRuc.getText());
                PrDao.EliminarProveedor(ruc);
                LimpiarTable();
                LimpiarProveedor();
                ListarProveedor();
                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        if ("".equals(txtId_prov.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtId_prov.getText()) || !"".equals(txtRuc.getText()) || !"".equals(txtnom_pro.getText()) || !"".equals(txt_tele.getText()) || !"".equals(txt_dir.getText())){
                pr.setId_prov(Integer.parseInt(txtId_prov.getText()));
                pr.setRuc(Integer.parseInt(txtRuc.getText()));
                pr.setNombre_pv(txtnom_pro.getText());
                pr.setTelefono_pv(Integer.parseInt(txt_tele.getText()));
                pr.setDireccion_pv(txt_dir.getText());
                PrDao.ModificarProveedor(pr);
                LimpiarTable();
                LimpiarProveedor();
                ListarProveedor();
                JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "Los campos están vacios");
            }
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        LimpiarProveedor();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardar_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar_proActionPerformed
        if(!"".equals(txtcod.getText()) || !"".equals(txtprod.getText()) || !"".equals(txtcant.getText()) || !"".equals(txtprec.getText()) || !"".equals(cbxProveedor.getSelectedItem())){
            pro.setCodigo(txtcod.getText());
            pro.setNombre_prod(txtprod.getText());
            pro.setStock(Integer.parseInt(txtcant.getText()));
            pro.setPrecio(Double.parseDouble(txtprec.getText()));
            pro.setProveedor_prod(cbxProveedor.getSelectedItem().toString());
            ProDao.RegistrarProductos(pro);
            JOptionPane.showMessageDialog(null, "Los Productos se han registrado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Sus campos están vacíos");
        }
    }//GEN-LAST:event_btnguardar_proActionPerformed

    private void btnProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProActionPerformed
        jTabbedPane2.setSelectedIndex(3);
        LimpiarTable();
        ListarProducto();
    }//GEN-LAST:event_btnProActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        jTabbedPane2.setSelectedIndex(1);
        LimpiarTable();
        ListarUsuarios();
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        jTabbedPane2.setSelectedIndex(0);
        LimpiarTable();
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnVenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenActionPerformed
        jTabbedPane2.setSelectedIndex(4);
        LimpiarTable();
        ListarVentas();
    }//GEN-LAST:event_btnVenActionPerformed

    private void btnactua_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactua_proActionPerformed
        if ("".equals(txtIdprod.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtIdprod.getText()) || !"".equals(txtcod.getText()) || !"".equals(txtprod.getText()) || !"".equals(cbxProveedor.getSelectedItem()) || !"".equals(txtcant.getText()) || !"".equals(txtprec.getText())){
                pro.setId_prod(Integer.parseInt(txtIdprod.getText()));
                pro.setCodigo(txtcod.getText());
                pro.setNombre_prod(txtprod.getText());
                pro.setProveedor_prod(cbxProveedor.getSelectedItem().toString());
                pro.setStock(Integer.parseInt(txtcant.getText()));
                pro.setPrecio(Double.parseDouble(txtprec.getText()));
                ProDao.ModificarProductos(pro);
                LimpiarTable();
                ListarProducto();
                LimpiarProducto();
                JOptionPane.showMessageDialog(null, "Producto Modificado");
            }else{
                JOptionPane.showMessageDialog(null, "Los campos están vacios");
            }
        }
    }//GEN-LAST:event_btnactua_proActionPerformed

    private void TableProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductoMouseClicked
        int fila = TableProducto.rowAtPoint(evt.getPoint());
        txtIdprod.setText(TableProducto.getValueAt(fila, 0).toString());
        txtcod.setText(TableProducto.getValueAt(fila, 1).toString());
        txtprod.setText(TableProducto.getValueAt(fila, 2).toString());
        cbxProveedor.setSelectedItem(TableProducto.getValueAt(fila, 3).toString());
        txtcant.setText(TableProducto.getValueAt(fila, 4).toString());
        txtprec.setText(TableProducto.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TableProductoMouseClicked

    private void btndelet_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelet_proActionPerformed
        if(!"".equals(txtIdprod.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
            if (pregunta == 0){
                int id_prod = Integer.parseInt(txtIdprod.getText());
                ProDao.EliminarProductos(id_prod);
                LimpiarTable();
                LimpiarProducto();
                ListarProducto();
                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            }
        }
    }//GEN-LAST:event_btndelet_proActionPerformed

    private void btnnuevo_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevo_proActionPerformed
        LimpiarProducto();
    }//GEN-LAST:event_btnnuevo_proActionPerformed

    private void btnexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcelActionPerformed
        Excel.reporte();
    }//GEN-LAST:event_btnexcelActionPerformed

    private void txtcodVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodVKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (!"".equals(txtcodV.getText())){
                String codigo = txtcodV.getText();
                pro = ProDao.BuscarPro(codigo);
                if (pro.getNombre_prod() != null) {
                    txtDescripcion.setText(""+pro.getNombre_prod());
                    txtPrecioV.setText("" + pro.getPrecio());
                    txtStockV.setText("" + pro.getStock());
                    txtCantidad.requestFocus();
                }else{
                    LimpiarVenta();
                    txtcodV.requestFocus();                
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese el codigo del producto");
                txtcodV.requestFocus();
            }
        }
    }//GEN-LAST:event_txtcodVKeyPressed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtCantidad.getText())){
                String codigo = txtcodV.getText();
                String descripcion = txtDescripcion.getText();
                int cant = Integer.parseInt(txtCantidad.getText());
                double precio = Double.parseDouble(txtPrecioV.getText());
                double total = cant * precio;
                int stock = Integer.parseInt(txtStockV.getText());
                if (stock >= cant){
                    item = item + 1;
                    tmp = (DefaultTableModel) TableVenta.getModel();
                    for (int i = 0; i < TableVenta.getRowCount(); i++){
                        if(TableVenta.getValueAt(i,1).equals(txtDescripcion.getText())) {
                            JOptionPane.showMessageDialog(null, "El producto ya se encuentra registrado");
                            return;
                        }
                    }
                    ArrayList lista = new ArrayList();
                    lista.add(item);
                    lista.add(codigo);
                    lista.add(descripcion);
                    lista.add(cant);
                    lista.add(precio);
                    lista.add(total);
                    Object[] O = new Object[5];
                    O[0] = lista.get(1);
                    O[1] = lista.get(2);
                    O[2] = lista.get(3);
                    O[3] = lista.get(4);
                    O[4] = lista.get(5);
                    tmp.addRow(O);
                    TableVenta.setModel(tmp);
                    TotalPagar();
                    LimpiarVenta();
                    txtcodV.requestFocus();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Stock no disponible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad");
            }
        }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void btnEliminarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVActionPerformed
        modelo = (DefaultTableModel) TableVenta.getModel();
        modelo.removeRow(TableVenta.getSelectedRow());
        TotalPagar();
        txtcodV.requestFocus();
    }//GEN-LAST:event_btnEliminarVActionPerformed

    private void cbxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProveedorActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if(TableVenta.getRowCount() > 0){
            if (!"".equals(cbxnom_provee.getSelectedItem())) {
                RegistrarVenta();
                RegistrarDetalle();
                ActualizarStock();
                pdf();
                LimpiarTableVenta(); 
                LimpiarProveedorV();
            }else{
                JOptionPane.showMessageDialog(null, "Debes buscar un Proveedor");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay productos en la venta");
        }

    }//GEN-LAST:event_btnGenerarActionPerformed

    private void ReportVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportVentasMouseClicked
        int fila = ReportVentas.rowAtPoint(evt.getPoint());
        txtIdVenta.setText(ReportVentas.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_ReportVentasMouseClicked

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        try {
            int id = Integer.parseInt(txtIdVenta.getText());
            File file = new File("src/pdf/venta "+id+".pdf");
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPdfActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtCorreo.getText().equals("") || txtnom_user.getText().equals("") || txtpass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos");
        }else{
            String correo = txtCorreo.getText();
            String pass = txtpass.getText();
            String nom = txtnom_user.getText();
            String rol = cbxrol.getSelectedItem().toString();
            lg.setNombre_u(nom);
            lg.setCorreo_u(correo);
            lg.setPass_u(pass);
            lg.setRol(rol);
            login.RegistrarUser(lg);
            JOptionPane.showMessageDialog(null, "Usuario Registrado");
            LimpiarTable();
            ListarUsuarios();           
            nuevoUsuario();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JTable ReportVentas;
    private javax.swing.JTable TableProducto;
    private javax.swing.JTable TableProveedor;
    private javax.swing.JTable TableUser;
    private javax.swing.JTable TableVenta;
    private javax.swing.JButton btnEliminarV;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnPro;
    private javax.swing.JButton btnProvee;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton btnVen;
    private javax.swing.JButton btnVenta;
    private javax.swing.JButton btnactua_pro;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btndelet_pro;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnexcel;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardar_pro;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnnuevo_pro;
    private javax.swing.JComboBox<String> cbxProveedor;
    private javax.swing.JComboBox<String> cbxnom_provee;
    private javax.swing.JComboBox<String> cbxrol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtId_prov;
    private javax.swing.JTextField txtIdprod;
    private javax.swing.JTextField txtPrecioV;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtStockV;
    private javax.swing.JTextField txt_dir;
    private javax.swing.JTextField txt_tele;
    private javax.swing.JTextField txtcant;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtcodV;
    private javax.swing.JTextField txtnom_pro;
    private javax.swing.JTextField txtnom_user;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtprec;
    private javax.swing.JTextField txtprod;
    // End of variables declaration//GEN-END:variables
    private void LimpiarProveedor(){
        txtRuc.setText("");
        txtnom_pro.setText("");
        txt_tele.setText("");
        txt_dir.setText("");
    }
    
    private void LimpiarProducto(){
        txtIdprod.setText("");
        txtcod.setText("");
        txtprod.setText("");
        cbxProveedor.setSelectedItem(null);
        txtcant.setText("");
        txtprec.setText("");
    }
    
    private void TotalPagar(){
        TotalPagar = 0.00;
        int numFila = TableVenta.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(TableVenta.getModel().getValueAt(i, 4)));
            TotalPagar = TotalPagar + cal;
        }
        LabelTotal.setText(String.format("%.2f", TotalPagar));    
    }   
    
    private void LimpiarVenta(){
        txtcodV.setText("");
        txtDescripcion.setText("");
        txtCantidad.setText("");
        txtPrecioV.setText("");
        txtStockV.setText("");
        cbxnom_provee.setSelectedItem(null);
    }
    
    private void RegistrarVenta(){
        String proveedor = cbxnom_provee.getSelectedItem().toString();
        String producto = pro.getNombre_prod();
        double total = TotalPagar;
        v.setProducto(producto);
        v.setProveedor(proveedor);
        v.setTotal(total);
        VDao.RegistrarVenta(v);
    }
     
    private void RegistrarDetalle(){
        int id = VDao.IdVenta();
        for (int i = 0; i < TableVenta.getRowCount(); i++) {
            String cod = TableVenta.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(TableVenta.getValueAt(i, 2).toString());
            double precio = Double.parseDouble(TableVenta.getValueAt(i, 3).toString());
            int id_det = 1;
            Dv.setCod_pro(cod);
            Dv.setCantidad(cant);
            Dv.setPrecio(precio);
            Dv.setId_det(id_det);
            VDao.RegistrarDetalle(Dv);
        }
    } 
    
    private void ActualizarStock(){
        for (int i = 0; i < TableVenta.getRowCount(); i++) {
            String codigo = TableVenta.getValueAt(i, 0).toString();
            int cantidad = Integer.parseInt(TableVenta.getValueAt(i, 2).toString());
            pro = ProDao.BuscarPro(codigo);
            int StockActual = pro.getStock() - cantidad;
            VDao.ActualizarStock(StockActual, codigo);
        }
    }
    
    private void LimpiarTableVenta(){
        tmp = (DefaultTableModel) TableVenta.getModel();
        int fila = TableVenta.getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
    }

    private void LimpiarProveedorV(){
        cbxnom_provee.setSelectedItem("");
    }
    
    private void pdf(){
        try {
            int id = VDao.IdVenta();
            FileOutputStream archivo;
            File file = new File("src/pdf/venta " + id + ".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/img/logo_pdf1.png");
            
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Font parrafo = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.ITALIC);
            Font parrafo1 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font titulo = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);

            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Factura: " + id + "\n" + "Fecha: "+ new SimpleDateFormat("dd-MM-yyyy").format(date)+"\n\n");
            
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEncabezado = new float[]{25f, 40f, 60f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            Encabezado.addCell(img);
            
            String ruc = "1312154645";
            String nom = "SMAY";
            String tel = "0999649650";
            String dir = "Ecuador - Macas";
            
            Encabezado.addCell("");
            Encabezado.addCell("Ruc: "+ruc+ "\nNombre: " + nom + "\nTelefono: " + tel + "\nDireccion: " + dir);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            
            Paragraph pro = new Paragraph();
            pro.add(Chunk.NEWLINE);
            pro.add(new Phrase("Datos de los Productos" + "\n\n", titulo));
            pro.setAlignment(Element.ALIGN_CENTER);
            doc.add(pro);
            
            PdfPTable tablepro = new PdfPTable(4);
            tablepro.setWidthPercentage(100);
            tablepro.getDefaultCell().setBorder(0);
            float[] Columnapro = new float[]{20f, 50f, 30f, 40f};
            tablepro.setWidths(Columnapro);
            tablepro.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell pro1 = new PdfPCell(new Phrase("\nCantidad\n", negrita));
            PdfPCell pro2 = new PdfPCell(new Phrase("\nProducto\n" , negrita));
            PdfPCell pro3 = new PdfPCell(new Phrase("\nPrecio Unitario\n", negrita));
            PdfPCell pro4 = new PdfPCell(new Phrase("\nPrecio Total\n", negrita));
            pro1.setBorder(0);
            pro2.setBorder(0);
            pro3.setBorder(0);
            pro4.setBorder(0);
            tablepro.addCell(pro1);
            tablepro.addCell(pro2);
            tablepro.addCell(pro3);
            tablepro.addCell(pro4);
            
            for (int i = 0; i < TableVenta.getRowCount(); i++) {
                String producto = TableVenta.getValueAt(i, 1).toString();
                String cantidad = TableVenta.getValueAt(i, 2).toString();
                String precio = TableVenta.getValueAt(i, 3).toString();
                String total = TableVenta.getValueAt(i, 4).toString();
                
                tablepro.addCell("\n" + cantidad);
                tablepro.addCell("\n" + producto);
                tablepro.addCell("\n" + precio);
                tablepro.addCell("\n" + total);            
            }
            
            doc.add(tablepro);
            
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add(new Phrase("\n\nTotal a Pagar: "+ TotalPagar, negrita));
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("\n\n");
            firma.add(new Phrase("\n\nCancelacion y Firma\n\n", parrafo1));
            firma.add("------------------------");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add(new Phrase("\n\nGracias por su Compra", parrafo));
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);            
            
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            System.out.println(e.toString());
        }
    }
    
    private void nuevoUsuario(){
        txtnom_user.setText("");
        txtCorreo.setText("");
        txtpass.setText("");
    }
}

