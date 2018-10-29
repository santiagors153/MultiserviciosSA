/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.ColeccionProducto;
import Controladores.ControladorHistorial;
import Modelo.Productos;
import Modelo.TipoMovimiento;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class MultiserVi extends javax.swing.JPanel {
    static ResultSet res;
    protected ColeccionProducto cp;
    protected ControladorHistorial ch;
    DefaultTableModel modelo;
    String resultado;
    /**
     * Creates new form Principal
     */
    public MultiserVi() {
        initComponents();
        cp = new ColeccionProducto();
        ch = new ControladorHistorial("HistorialUsuario.txt");
        ch.lee();
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoFecha = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtCodProducto = new javax.swing.JTextField();
        cboTipoProducto = new javax.swing.JComboBox<>();
        txtProducto = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtAnioMov = new javax.swing.JTextField();
        txtMesMov = new javax.swing.JTextField();
        txtDiaMov = new javax.swing.JTextField();
        rbtEntrada = new javax.swing.JRadioButton();
        rbtSalida = new javax.swing.JRadioButton();
        txtCantidad = new javax.swing.JTextField();
        txtUnidad = new javax.swing.JTextField();
        txtFechaVencimiento = new javax.swing.JTextField();
        txtNroLote = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        btnProducto = new javax.swing.JButton();
        btnOperacion = new javax.swing.JButton();
        btnBusca = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbTablaStock = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        btnBusca1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbTablaHistorial = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtSalidaStcok = new javax.swing.JTextArea();

        setToolTipText("");
        setAutoscrolls(true);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        txtCodProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Codigo Producto"));
        jPanel2.add(txtCodProducto);

        cboTipoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar tipo de Producto", "Bebible", "Solido" }));
        jPanel2.add(cboTipoProducto);

        txtProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));
        jPanel2.add(txtProducto);

        txtCosto.setBorder(javax.swing.BorderFactory.createTitledBorder("Costo"));
        jPanel2.add(txtCosto);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimientos"));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        txtAnioMov.setBorder(javax.swing.BorderFactory.createTitledBorder("Año"));
        jPanel4.add(txtAnioMov);

        txtMesMov.setBorder(javax.swing.BorderFactory.createTitledBorder("Mes"));
        txtMesMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesMovActionPerformed(evt);
            }
        });
        jPanel4.add(txtMesMov);

        txtDiaMov.setBorder(javax.swing.BorderFactory.createTitledBorder("Dia"));
        jPanel4.add(txtDiaMov);

        GrupoFecha.add(rbtEntrada);
        rbtEntrada.setText("Entrada");
        jPanel4.add(rbtEntrada);

        GrupoFecha.add(rbtSalida);
        rbtSalida.setText("Salida");
        jPanel4.add(rbtSalida);

        txtCantidad.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad"));
        jPanel4.add(txtCantidad);

        txtUnidad.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidad"));
        jPanel4.add(txtUnidad);

        jPanel2.add(jPanel4);

        txtFechaVencimiento.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Vencimiento"));
        jPanel2.add(txtFechaVencimiento);

        txtNroLote.setBorder(javax.swing.BorderFactory.createTitledBorder("N° Lote"));
        jPanel2.add(txtNroLote);

        txtProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedor"));
        jPanel2.add(txtProveedor);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        txtSalida.setEditable(false);
        txtSalida.setColumns(20);
        txtSalida.setRows(5);
        jScrollPane1.setViewportView(txtSalida);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnProducto.setText("Producto");
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });
        jPanel5.add(btnProducto);

        btnOperacion.setText("Operacion");
        btnOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperacionActionPerformed(evt);
            }
        });
        jPanel5.add(btnOperacion);

        btnBusca.setText("Buscar");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });
        jPanel5.add(btnBusca);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel5.add(btnLimpiar);

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Operciones", jPanel1);

        jPanel6.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel6AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));
        jPanel6.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jtbTablaStock.setAutoCreateRowSorter(true);
        jtbTablaStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Tipo Producto", "Nombre", "Precio", "Anio Movimiento", "Mes Movimiento", "Dia Movimiento", "Tipo Movimiento", "Cantidad", "Unidad ", "Fecha Vencimiento", "N° Lote", "Proveedor", "Stock"
            }
        ));
        jtbTablaStock.setEnabled(false);
        jScrollPane2.setViewportView(jtbTablaStock);

        jPanel6.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jLabel1.setText("By SanNics");
        jPanel8.add(jLabel1);

        jPanel6.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Productos", jPanel6);

        jPanel3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder("Año de Busqueda"));
        jPanel9.add(jTextField1);

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder("Mes de Busqueda"));
        jPanel9.add(jTextField2);

        jPanel3.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        btnBusca1.setText("Busca");
        btnBusca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusca1ActionPerformed(evt);
            }
        });
        jPanel10.add(btnBusca1);

        jButton4.setText("Stock");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton4);

        jPanel3.add(jPanel10, java.awt.BorderLayout.PAGE_END);

        jtbTablaHistorial.setAutoCreateRowSorter(true);
        jtbTablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tipo Movimiento", "Codigo", "Tipo Producto", "Nombre Producto", "Precio", "Anio Mov", "MesMov", "Dia Mov", "Fecha Vencimiento", "Proveedor", "Unidad", "N°Lote", "Cantidad"
            }
        ));
        jtbTablaHistorial.setEnabled(false);
        jScrollPane4.setViewportView(jtbTablaHistorial);

        jPanel3.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        txtSalidaStcok.setEditable(false);
        txtSalidaStcok.setColumns(20);
        txtSalidaStcok.setRows(5);
        jScrollPane5.setViewportView(txtSalidaStcok);

        jPanel3.add(jScrollPane5, java.awt.BorderLayout.LINE_END);

        jTabbedPane1.addTab("Historial de Productos", jPanel3);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    private void txtMesMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesMovActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesMovActionPerformed
    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        if(leeTipoMovimiento().equalsIgnoreCase("Fallo") && leeTipoProducto()==0){
            JOptionPane.showMessageDialog(null, "Ingrese el tipo de Entrada y/o Producto");
        }else{
            try{
                validacionCosto();
                validarCantidad();
                validarNroLote();
            }catch(InputMismatchException e){
                JOptionPane.showMessageDialog(null, "Error Fatal, Llamar al Programador");
            }finally{}    
        }
        
            Productos p = new Productos(leeTipoMovimiento(),leeCodigoProducto(), leeTipoProducto(),leeProducto(),leeAnioMov(), leeMesMovi(), leeDiaMov(), leeFechaVencimiento(), leeProveedor(), leeUnidad(), leeNroLote(), leeCosto(), leeCantidad(), leeStock());
            if(p.EntradaProducto()==true){
                Salida(p);
                ch.agrega(p);
                ch.grabar();
             JOptionPane.showMessageDialog(null, "Producto Ingresado Exitosamente");   
            }else{
                JOptionPane.showMessageDialog(null, "No se Ingreso el Producto");
            }
        
    }//GEN-LAST:event_btnProductoActionPerformed
    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        // TODO add your handling code here:
        int pos = cp.busca(leeCodigoProducto());
        if(pos==-1){
            Mensaje();
        }else{
            Productos p = cp.obtiene(pos);
            cboTipoProducto.setSelectedIndex(p.getTipoProducto());
            txtProducto.setText(p.getNomProducto());
            txtCosto.setText(p.getPrecio()+"");
            txtAnioMov.setText(p.getAnioMov()+"");
            txtMesMov.setText(p.getMesMov()+"");
            txtDiaMov.setText(p.getDiaMov()+"");
            if(p.getTipoMovimento().equalsIgnoreCase("Entrada")){
                rbtEntrada.isSelected();
            }else if(p.getTipoMovimento().equalsIgnoreCase("Salida")){
                rbtSalida.isSelected();
            }else{
                Mensaje();
            }
            txtCantidad.setText(p.getCant()+"");
            txtUnidad.setText(p.getUnidad());
            txtFechaVencimiento.setText(p.getFechaVencimiento());
            txtNroLote.setText(p.getNroLote()+"");
            txtProveedor.setText(p.getProveedor());
        }
    }//GEN-LAST:event_btnBuscaActionPerformed
    private void jPanel6AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel6AncestorAdded
        // TODO add your handling code here:
        cp.Elimina();
        LinkedList<Productos> pars = cp.select();
        System.out.println(cp.tamaño());
        for(int i=0; i<cp.tamaño();i++){
        jtbTablaStock.setValueAt(cp.obtiene(i).getCodigoProd(), i, 0);
        jtbTablaStock.setValueAt(cp.obtiene(i).getTipoProducto(), i, 1);
        jtbTablaStock.setValueAt(cp.obtiene(i).getNomProducto(), i, 2);
        jtbTablaStock.setValueAt(cp.obtiene(i).getPrecio(), i, 3);
        jtbTablaStock.setValueAt(cp.obtiene(i).getAnioMov(), i, 4);
        jtbTablaStock.setValueAt(cp.obtiene(i).getMesMov(), i, 5);
        jtbTablaStock.setValueAt(cp.obtiene(i).getDiaMov(), i, 6);
        jtbTablaStock.setValueAt(cp.obtiene(i).getTipoMovimento(), i, 7);
        jtbTablaStock.setValueAt(cp.obtiene(i).getCant(), i, 8);
        jtbTablaStock.setValueAt(cp.obtiene(i).getUnidad(), i, 9);
        jtbTablaStock.setValueAt(cp.obtiene(i).getFechaVencimiento(), i, 10);
        jtbTablaStock.setValueAt(cp.obtiene(i).getNroLote(), i, 11);
        jtbTablaStock.setValueAt(cp.obtiene(i).getProveedor(), i, 12);
        jtbTablaStock.setValueAt(cp.obtiene(i).getStock(), i, 13);
        }
    }//GEN-LAST:event_jPanel6AncestorAdded

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtCodProducto.setText("");
        txtProducto.setText("");
        txtCosto.setText("");
        txtAnioMov.setText("");
        txtMesMov.setText("");
        txtDiaMov.setText("");
        txtUnidad.setText("");
        txtCantidad.setText("");
        txtFechaVencimiento.setText("");
        txtNroLote.setText("");
        txtProveedor.setText("");
        cboTipoProducto.setSelectedIndex(0);
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperacionActionPerformed
        // TODO add your handling code here:
        if(leeTipoMovimiento().equalsIgnoreCase("Fallo")){
            JOptionPane.showMessageDialog(null, "Ingrese el tipo de Entrada");
        }else if(leeTipoProducto()==0){
            JOptionPane.showMessageDialog(null, "Ingrese el tipo de Producto");

        }else{
            try{
                validacionCosto();
                validarCantidad();
                validarNroLote();
            }catch(InputMismatchException e){
                JOptionPane.showMessageDialog(null, "Error Fatal, Llamar al Programador");
            }finally{}
        Productos p = new Productos(leeTipoMovimiento(), leeCodigoProducto(), leeTipoProducto(), leeProducto(), leeAnioMov(), leeMesMovi(), leeDiaMov(), leeFechaVencimiento(), leeProveedor(), leeUnidad(), leeNroLote(), leeCosto(),leeCantidad(),leeStock());        
        Productos s = new Productos(leeCodigoProducto(), leeCantidad());
        if(leeTipoMovimiento().equals("Entrada")){
            if(s.EntradaStock()==true){
                Salida(p);
                ch.agrega(p);
                ch.grabar();
                JOptionPane.showMessageDialog(null, "Operacion de Ingreso Exitosa");
            }else{
                JOptionPane.showMessageDialog(null, "Error, no se Pudo Aumentar los Datos");
            }
        }else if(leeTipoMovimiento().equals("Salida")){
            if(s.SalidaStock()==true){
                Salida(p);
                ch.agrega(p);
                ch.grabar();
                JOptionPane.showMessageDialog(null, "Operacion de salida Exitosa");
            }else{
                JOptionPane.showMessageDialog(null, "Error, no se pudo Restar los Datos");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error Fatal, Reiniciar Programa");
        }
        }
    }//GEN-LAST:event_btnOperacionActionPerformed

    private void jPanel3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel3AncestorAdded
        // TODO add your handling code here:
        for(int i=0; i<ch.tamaño();i++){
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getTipoMovimento(), i, 0);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getCodigoProd(), i, 1);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getTipoProducto(), i, 2);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getNomProducto(), i, 3);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getPrecio(), i, 4);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getAnioMov(), i, 5);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getMesMov(), i, 6);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getDiaMov(), i, 7);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getFechaVencimiento(), i, 8);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getProveedor(), i, 9);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getUnidad(), i, 10);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getNroLote(), i, 11);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getCant(), i, 12);
        }
        
    }//GEN-LAST:event_jPanel3AncestorAdded

    private void btnBusca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusca1ActionPerformed
        // TODO add your handling code here:
        Productos p = new Productos(leeTipoMovimiento(), leeCodigoProducto(), leeTipoProducto(), leeProducto(), leeAnioMov(), leeMesMovi(), leeDiaMov(), leeFechaVencimiento(), leeProveedor(), leeUnidad(), leeNroLote(), leeCosto(),leeCantidad(),leeStock());
        for(int i=0; i<ch.tamaño();i++){
        if(leeMesMovi()==ch.obtiene(i).getMesMov() && leeAnioMov()==ch.obtiene(i).getAnioMov()){
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getCodigoProd(), i, 0);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getTipoProducto(), i, 1);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getNomProducto(), i, 2);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getPrecio(), i, 3);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getAnioMov(), i, 4);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getMesMov(), i, 5);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getDiaMov(), i, 6);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getTipoMovimento(), i, 7);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getCant(), i, 8);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getUnidad(), i, 9);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getFechaVencimiento(), i, 10);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getNroLote(), i, 11);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getProveedor(), i, 12);
        jtbTablaHistorial.setValueAt(ch.obtiene(i).getStock(), i, 13);
        }
        }
    }//GEN-LAST:event_btnBusca1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        double entrada=0, salida=0,stock=0, ca=0, pre=0;
        Productos p = new Productos(leeTipoMovimiento(), leeCodigoProducto(), leeTipoProducto(), leeProducto(), leeAnioMov(), leeMesMovi(), leeDiaMov(), leeFechaVencimiento(), leeProveedor(), leeUnidad(), leeNroLote(), leeCosto(),leeCantidad(),leeStock());
        for(int i=0; i<ch.tamaño(); i++){
            pre=ch.obtiene(i).getPrecio();
            ca=ch.obtiene(i).getCant();
            if(leeMesMovi()==ch.obtiene(i).getMesMov() && leeAnioMov()==ch.obtiene(i).getAnioMov()){
                if(ch.obtiene(i).getTipoMovimento().equals("Entrada")){
                    entrada=entrada+ca;
                }else if(ch.obtiene(i).getTipoMovimento().equals("Salida")){
                    salida=salida+ca;
                }else{
                    JOptionPane.showMessageDialog(null, "No hay datos ");
                }
                stock=entrada*pre;
            }
            txtSalidaStcok.setText(" ");
            Imprime2("Cantidad Entrante: "+entrada);
            Imprime2("Cantidad Saliente: "+salida);
            Imprime2("Total: "+stock);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    public String leeCodigoProducto(){
        return txtCodProducto.getText();
    }
    public String leeProducto(){
        return txtProducto.getText();
    }
    public double leeCosto(){
        return Double.parseDouble(txtCosto.getText());
    }
    public void validacionCosto(){
        try{
            leeCosto();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de Sintaxis en el campo de 'Costos'");
        }finally{}
    }
    public int leeAnioMov(){
        return Integer.parseInt(txtAnioMov.getText());
    }
    public int leeMesMovi(){
        return Integer.parseInt(txtMesMov.getText());
    }
    public int leeDiaMov(){
        return Integer.parseInt(txtDiaMov.getText());
    }
    public String leeUnidad(){
        return txtUnidad.getText();
    }
    public double leeCantidad(){
        return Double.parseDouble(txtCantidad.getText());
    }
    public void validarCantidad(){
        try{
            leeCantidad();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de sintaxis en el campo de 'Cantidad'");
        }finally{}
    }
    public String leeFechaVencimiento(){
        return txtFechaVencimiento.getText();
    }
    public int leeNroLote(){
        return Integer.parseInt(txtNroLote.getText());
    }
    public void validarNroLote(){
        try{
            leeNroLote();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error de Sintaxis en el campo de 'N° de Lote'");
        }finally{}
    }
    public String leeProveedor(){
        return txtProveedor.getText();
    }
    public int leeTipoProducto(){
        int tipoProducto= 0;
            tipoProducto=cboTipoProducto.getSelectedIndex();
        return tipoProducto;
    }
    public String leeTipoMovimiento(){
        String Resultado;
            if(rbtEntrada.isSelected())
                Resultado="Entrada";
            else if (rbtSalida.isSelected())
                Resultado="Salida";
            else
                Resultado="Fallo";
        
        return Resultado;
    }
    public double leeStock(){
        return Double.parseDouble(txtCantidad.getText());
    }
    public void Mensaje(){
        JOptionPane.showMessageDialog(null, "Erro de Sintaxis");
    }
    public void Mensaje1(){
        JOptionPane.showMessageDialog(null, "Producto Existente");
    }
    public void Mensaje2(){
        JOptionPane.showMessageDialog(null, "Producto Inexistente");
    }
    public void Imprime(String i){
        txtSalida.append(i+"\n");
    }
    public void Salida(Productos p){
        Imprime("************************\n"+p.Informe());
    }
    public void lista(){
        txtSalida.setText("Codigo Producto\tTipo Produco\tProducto\tCosto\tAnio Movimineto\tMes Movimiento\tDia Movimiento\tTipo Entrada\tCantidad\tUnidad\tFecha Vencimineto\tN° Lote\tProveedor\tStock\n");
        for(int i=0;i<cp.tamaño();i++){
        Productos p = cp.obtiene(i);
            Imprime(p.getCodigoProd()+"\t\t"+p.getTipoProducto()+"\t"+p.getNomProducto()+"\t"+p.getPrecio()+"\t"+p.getAnioMov()+"\t\t"+p.getMesMov()+"\t\t"+p.getDiaMov()+"\t"+p.getTipoMovimento()+"\t"+p.getCant()+"\t"+p.getUnidad()+"\t"+p.getFechaVencimiento()+"\t\t"+p.getNroLote()+"\t"+p.getProveedor()+"\t"+p.getStock());
            txtSalida.append("\n");
    }
    }
    public void Imprime2(String s){
        txtSalidaStcok.append(s+"\n");
    }
    /*public double Stock(){
        double stock=0;
        if(leeTipoMovimiento().equalsIgnoreCase("Entrada")){
            
        }
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.ButtonGroup GrupoFecha;
    public static javax.swing.JButton btnBusca;
    public static javax.swing.JButton btnBusca1;
    public static javax.swing.JButton btnLimpiar;
    public static javax.swing.JButton btnOperacion;
    public static javax.swing.JButton btnProducto;
    public static javax.swing.JComboBox<String> cboTipoProducto;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel10;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel5;
    public static javax.swing.JPanel jPanel6;
    public static javax.swing.JPanel jPanel7;
    public static javax.swing.JPanel jPanel8;
    public static javax.swing.JPanel jPanel9;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JTable jtbTablaHistorial;
    public static javax.swing.JTable jtbTablaStock;
    public static javax.swing.JRadioButton rbtEntrada;
    public static javax.swing.JRadioButton rbtSalida;
    public static javax.swing.JTextField txtAnioMov;
    public static javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtCodProducto;
    public static javax.swing.JTextField txtCosto;
    public static javax.swing.JTextField txtDiaMov;
    public static javax.swing.JTextField txtFechaVencimiento;
    public static javax.swing.JTextField txtMesMov;
    public static javax.swing.JTextField txtNroLote;
    public static javax.swing.JTextField txtProducto;
    public static javax.swing.JTextField txtProveedor;
    public static javax.swing.JTextArea txtSalida;
    public static javax.swing.JTextArea txtSalidaStcok;
    public static javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables
}
