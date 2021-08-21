
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



public final class mant_articulo extends javax.swing.JFrame {

    conectar ob = new conectar();
    Connection con = ob.conexion();
   
  
    public mant_articulo() throws ClassNotFoundException, SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
       //this.txtestado_art.setText("Disponible");
        this.cargar_datos();
       // this.numero_serial=0;
       this.num_serial();
       
    }    
     
    //guardar los datos registrados en la tabla inventario
    public void guardar_datos(){
         String sql = "INSERT INTO inventario_art(descri_art,cant_art,costo_art,estado_art)"
                 + "VALUES('"+txtdescri_art.getText()+"','"+txtcant_art.getText()+"'"
                 + ",'"+txtcosto_art.getText()+"','"+cbestado_art.getSelectedItem()+"')";
         try{
              PreparedStatement pre = con.prepareStatement(sql);
              
              pre.executeUpdate();
              
              JOptionPane.showMessageDialog(null,"Registro guardado");
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex);
         }
        
    }
    
    //cargar los datos de la tabla invertario
    public void cargar_datos(){
        String sql = "SELECT id_art,descri_art,cant_art,costo_art,estado_art  FROM inventario_art";
                
        String registro[] = new String[5];
        DefaultTableModel modelo = (DefaultTableModel) t_articulo.getModel();
        modelo.getDataVector().clear();
        
            try{
                 Statement cr = con.createStatement();
                 
                 ResultSet rs = cr.executeQuery(sql);
                 
                 while(rs.next()){
                   registro[0] = rs.getString("id_art");
                   registro[1] = rs.getString("descri_art");
                   registro[2] = rs.getString("cant_art");
                   registro[3] = rs.getString("costo_art");
                   registro[4] = rs.getString("estado_art");
                   
                   modelo.addRow(registro);
                 }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex);
            }
       
        
        t_articulo.setModel(modelo);
    }
    
    //modificar inventario
    public void modificar(){
        
        try{
            String sql = "UPDATE inventario_art SET descri_art='"+txtdescri_art.getText()+"'"
                + ",cant_art='"+txtcant_art.getText()+"',costo_art='"+txtcosto_art.getText()+"'"
                + ",estado_art='"+cbestado_art.getSelectedItem()+"' WHERE id_art='"+txtid_art.getText()+"'";

            PreparedStatement pre = con.prepareStatement(sql);
        pre.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        
        
    }
    
    //numero del contador de la base de datos
    public void num_serial(){
        String numero2_serial = "";
        String sql = "SELECT num_serial FROM contador";    
        try{
            Statement cr = con.createStatement();        
            ResultSet rs = cr.executeQuery(sql);
            rs.next();
            
                numero2_serial = String.valueOf(rs.getString("num_serial"));
                numero_serial = Integer.valueOf(numero2_serial);
                numero_serial+=1; 
                                
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        } 
        
    }
    
    //genereal serial
    public void general_serial(){
        String registros2[] = new String[4];
        DefaultTableModel modelo2 = (DefaultTableModel) t_serial.getModel();
        modelo2.getDataVector().clear();
        int vuelta = Integer.valueOf(txtcant_art.getText());
       
      for(int i = 0;i < vuelta; i++){
        registros2[0] = txtid_art.getText();
        registros2[1] = txtid_art.getText();
        registros2[2] = txtdescri_art.getText();
        registros2[3] = "UTS"+String.valueOf(numero_serial);
        modelo2.addRow(registros2);
        t_serial.setModel(modelo2);
        numero_serial+=1;
     }
       numero_serial-=1;
    }
    
    //insertar serial en base de datos
    public void insertar_serial(){
        for(int i = 0; i < t_serial.getRowCount(); i++){
            try{
                String sql = "INSERT INTO serial_articulo(id_art,descri_art,id_serial,estado) "
                        + " VALUES('"+t_serial.getValueAt(i, 0)+"','"+t_serial.getValueAt(i, 2)+"',"
                        + "'"+t_serial.getValueAt(i, 3)+"','"+cbestado_art.getSelectedItem()+"')";  
                PreparedStatement pre = con.prepareStatement(sql);
              
                pre.executeUpdate();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            } 
            
        }
    }
   //imprimir ticket
    public void funcion_imprimir_ticket(){
        ArrayList lista = new ArrayList();
        
        for(int i = 0; i < t_serial.getRowCount(); i++){
            imprimir_ticket ob = new imprimir_ticket(t_serial.getValueAt(i, 0)+"" ,t_serial.getValueAt(i,1)+""
                    ,t_serial.getValueAt(i, 2)+"",t_serial.getValueAt(i, 3)+"" );
            lista.add(ob);
        }
         JasperReport jr=null;
        try{
    
             jr=(JasperReport) JRLoader.loadObjectFromFile("ticket.jasper");
        
            HashMap parametro= new HashMap();
            
            parametro.put("empresa", compañia);
           // parametro.put("depertamento","AudioVisuales Utesa");
            JasperPrint jp = JasperFillManager.fillReport(jr,parametro,new JRBeanCollectionDataSource(lista));
            JasperViewer jv = new JasperViewer(jp,false);
            
            JasperPrintManager jpm = JasperPrintManager.getInstance(DefaultJasperReportsContext.getInstance());
            jv.setVisible(true);
            
        }catch(JRException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    
        
        
    }
     public void limpiar(){
        txtid_art.setText("");
        txtdescri_art.setText("");
        txtcant_art.setText("");
        txtcosto_art.setText("");
        cbestado_art.setSelectedItem("Disponible");
    } 

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        label_id = new javax.swing.JLabel();
        txtid_art = new javax.swing.JTextField();
        txtdescri_art = new javax.swing.JTextField();
        label_descri = new javax.swing.JLabel();
        label_cant = new javax.swing.JLabel();
        label_costo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcant_art = new javax.swing.JTextField();
        txtcosto_art = new javax.swing.JTextField();
        cbestado_art = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnregistrar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btngeneral_serial = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_articulo = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        t_serial = new javax.swing.JTable();
        titulo1 = new javax.swing.JLabel();
        atras = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventario");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_id.setText("Id articulo");
        jPanel1.add(label_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txtid_art.setText(" ");
        txtid_art.setEnabled(false);
        jPanel1.add(txtid_art, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 155, -1));

        txtdescri_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescri_artActionPerformed(evt);
            }
        });
        jPanel1.add(txtdescri_art, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 155, -1));

        label_descri.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_descri.setText("Descripcion");
        jPanel1.add(label_descri, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        label_cant.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_cant.setText("Cantidad");
        jPanel1.add(label_cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        label_costo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_costo.setText("Costo");
        jPanel1.add(label_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Estado");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtcant_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcant_artActionPerformed(evt);
            }
        });
        jPanel1.add(txtcant_art, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 155, -1));

        txtcosto_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcosto_artActionPerformed(evt);
            }
        });
        jPanel1.add(txtcosto_art, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 155, -1));

        cbestado_art.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible" }));
        jPanel1.add(cbestado_art, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 150, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 310, 220));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnregistrar.setBackground(new java.awt.Color(255, 153, 51));
        btnregistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnregistrar.setText("Registrar");
        btnregistrar.setContentAreaFilled(false);
        btnregistrar.setFocusCycleRoot(true);
        btnregistrar.setOpaque(true);
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 139, 30));

        btnactualizar.setBackground(new java.awt.Color(255, 153, 51));
        btnactualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.setContentAreaFilled(false);
        btnactualizar.setFocusCycleRoot(true);
        btnactualizar.setOpaque(true);
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 139, 30));

        btngeneral_serial.setBackground(new java.awt.Color(255, 153, 51));
        btngeneral_serial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btngeneral_serial.setText("General serial");
        btngeneral_serial.setContentAreaFilled(false);
        btngeneral_serial.setFocusCycleRoot(true);
        btngeneral_serial.setOpaque(true);
        btngeneral_serial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngeneral_serialActionPerformed(evt);
            }
        });
        jPanel2.add(btngeneral_serial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 138, 30));

        btnlimpiar.setBackground(new java.awt.Color(255, 153, 51));
        btnlimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.setContentAreaFilled(false);
        btnlimpiar.setFocusCycleRoot(true);
        btnlimpiar.setOpaque(true);
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 138, 30));

        btnimprimir.setBackground(new java.awt.Color(255, 153, 51));
        btnimprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnimprimir.setText("Imprimir");
        btnimprimir.setContentAreaFilled(false);
        btnimprimir.setFocusCycleRoot(true);
        btnimprimir.setOpaque(true);
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });
        jPanel2.add(btnimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 138, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 230, 220));

        t_articulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id articulo", "Descripcion", "Cantidad", "Costo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_articulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_articuloMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(t_articulo);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 329, 539, 193));

        t_serial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id art", "Id art", "Descripcion", "Id serial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(t_serial);
        if (t_serial.getColumnModel().getColumnCount() > 0) {
            t_serial.getColumnModel().getColumn(0).setMinWidth(130);
            t_serial.getColumnModel().getColumn(0).setMaxWidth(130);
            t_serial.getColumnModel().getColumn(1).setMinWidth(0);
            t_serial.getColumnModel().getColumn(1).setMaxWidth(0);
            t_serial.getColumnModel().getColumn(2).setMinWidth(0);
            t_serial.getColumnModel().getColumn(2).setMaxWidth(0);
            t_serial.getColumnModel().getColumn(3).setMinWidth(130);
            t_serial.getColumnModel().getColumn(3).setMaxWidth(130);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 101, 263, 420));

        titulo1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titulo1.setForeground(new java.awt.Color(51, 204, 0));
        titulo1.setText("Mantenimiento de Articulo");
        getContentPane().add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 560, -1));

        atras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        atras.setForeground(new java.awt.Color(206, 184, 54));
        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-izquierda-40.png"))); // NOI18N
        atras.setText("Volver");
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
        });
        getContentPane().add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdescri_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescri_artActionPerformed
        
        if(txtdescri_art.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtdescri_art.requestFocus();
            
        }else{
            this.txtcant_art.requestFocus();
        }
    }//GEN-LAST:event_txtdescri_artActionPerformed

    private void txtcant_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcant_artActionPerformed
    
        if(txtcant_art.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtcant_art.requestFocus();
        }else{
            this.txtcosto_art.requestFocus();
        }
    }//GEN-LAST:event_txtcant_artActionPerformed

    private void txtcosto_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcosto_artActionPerformed
       if(this.txtcosto_art.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtcosto_art.requestFocus();
        }else{
            this.cbestado_art.requestFocus();
        }
    }//GEN-LAST:event_txtcosto_artActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
       
         if(txtdescri_art.getText().equals("") || txtcant_art.getText().equals("")
                 || txtcosto_art.getText().equals("") || cbestado_art.getSelectedItem().equals("")){
                        
            if(txtdescri_art.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtdescri_art.requestFocus();
            }
            if(txtcant_art.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtcant_art.requestFocus();
            }
            if(txtcosto_art.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtcosto_art.requestFocus();
            }
            if(cbestado_art.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            cbestado_art.requestFocus();
            }
            
        }
        else{
            guardar_datos();
            cargar_datos();
            limpiar();
       }
        
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void t_articuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_articuloMouseClicked
        
        int index = t_articulo.getSelectedRow();
        
        if(index>=0){
            txtid_art.setText(t_articulo.getValueAt(index, 0).toString());
            txtdescri_art.setText(t_articulo.getValueAt(index, 1).toString());
            txtcant_art.setText(t_articulo.getValueAt(index, 2).toString());
            txtcosto_art.setText(t_articulo.getValueAt(index, 3).toString());
            cbestado_art.setSelectedItem(t_articulo.getValueAt(index, 4).toString());
        }
    }//GEN-LAST:event_t_articuloMouseClicked

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
       
         if(txtdescri_art.getText().equals("") || txtcant_art.getText().equals("")
                 || txtcosto_art.getText().equals("") || cbestado_art.getSelectedItem().equals("")){
                        
            if(txtdescri_art.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtdescri_art.requestFocus();
            }
            if(txtcant_art.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtcant_art.requestFocus();
            }
            if(txtcosto_art.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtcosto_art.requestFocus();
            }
            if(cbestado_art.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            cbestado_art.requestFocus();
            }
            
        }
        else{
            modificar();
            cargar_datos();
            limpiar();
       }
        
        
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btngeneral_serialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngeneral_serialActionPerformed
       
       
        if(txtdescri_art.getText().equals("") || txtcant_art.getText().equals("")
                 || txtcosto_art.getText().equals("") || cbestado_art.getSelectedItem().equals("")){
                        
            if(txtdescri_art.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtdescri_art.requestFocus();
            }
            if(txtcant_art.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtcant_art.requestFocus();
            }
            if(txtcosto_art.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtcosto_art.requestFocus();
            }
            if(cbestado_art.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            cbestado_art.requestFocus();
            }
        }else{
            num_serial();
           general_serial();
           insertar_serial();
       
           try{
            String sql2 = "UPDATE contador SET num_serial='"+numero_serial+"'";
            PreparedStatement pre = con.prepareStatement(sql2);
            pre.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
       }
       
       
    }//GEN-LAST:event_btngeneral_serialActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        this.funcion_imprimir_ticket();
        
        
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        mantenimiento ob = new mantenimiento();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_atrasMouseClicked

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atras;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btngeneral_serial;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JComboBox<String> cbestado_art;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_cant;
    private javax.swing.JLabel label_costo;
    private javax.swing.JLabel label_descri;
    private javax.swing.JLabel label_id;
    private javax.swing.JTable t_articulo;
    private javax.swing.JTable t_serial;
    private javax.swing.JLabel titulo1;
    private javax.swing.JTextField txtcant_art;
    private javax.swing.JTextField txtcosto_art;
    private javax.swing.JTextField txtdescri_art;
    private javax.swing.JTextField txtid_art;
    // End of variables declaration//GEN-END:variables

    int numero_serial=0;
    String compañia = "Universidad Tecnologica de Santiago"
                    + "\n Sistema Corporativo Utesa";
}
