package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class mant_profesor2 extends javax.swing.JFrame {
    //objeto de la clases conectar y variable tipo Connection
conectar cc = new conectar(); 
   Connection cn;
   
    public mant_profesor2() throws ClassNotFoundException {
        this.cn = cc.conexion();
        initComponents();
        this.setLocationRelativeTo(null);
        cargar_datos();
    }

     //guardar datos introducido
    public void guardar_datos(){
       
        try {
            String sql="INSERT INTO tabla_profesor(matricula,nom_prof,ape_prof,sex_prof,password,acceso) VALUE('"+txtmatricula.getText()+"'"
                    + ",'"+txtnom_prof.getText()+"','"+txtape_prof.getText()+"','"+txtsex_prof.getText()+"'"
                    + ",'"+txtpass.getText()+"','"+cbacceso.getSelectedItem()+"')";
            PreparedStatement in = cn.prepareStatement(sql);                  
            in.executeUpdate();
            //-----------------------------------------------------------------
            String sql2="INSERT INTO login(user_matri,pass,acceso) VALUES('"+txtmatricula.getText()+"'"
                    + ",'"+txtpass.getText()+"','"+cbacceso.getSelectedItem()+"')";
             
              PreparedStatement in2 = cn.prepareStatement(sql2);
               in2.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos registrado");
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        cargar_datos();
        
    }
 
    //buscar datos en la base de datos
    public void buscar_datos(){
        String sql = "SELECT  matricula,nom_prof,ape_prof,sex_prof,password,acceso FROM tabla_profesor WHERE matricula='"+txtmatricula.getText()+"'";
        String registro[] = new String[5];

        try{
            /*createStatement crea una solicitud*/
            Statement st = cn.createStatement();
            
            /*resultset tomara los resultado de la tabla
            executeQuery trae los datos de la base de datos*/
            ResultSet rs = st.executeQuery(sql);
            
            /*mientra el resultado traido puedas enviarlo al resgistro 
            sigo dando vuelta en cambio8 termina el ciclo*/
            while (rs.next()){
            registro[0] = rs.getString("matricula");
            registro[1] = rs.getString("nom_prof");
            registro[2] = rs.getString("ape_prof");
            registro[3] = rs.getString("sex_prof");
            registro[4] = rs.getString("password");
            registro[5] = rs.getString("acceso");
            }            
            
            txtmatricula.setText(registro[0]);
            txtnom_prof.setText(registro[1]);
            txtape_prof.setText(registro[2]);
            txtsex_prof.setText(registro[3]);   
            txtpass.setText(registro[4]);
            cbacceso.setSelectedItem(registro[5]);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        cargar_datos();
    }
    // String sql = "SELECT matricula,nom_est,ape_est,sex_est,password,acceso FROM tabla_estudiante";
       
 public void cargar_datos(){
        String sql = "SELECT matricula,nom_prof,ape_prof,sex_prof,password,acceso FROM tabla_profesor";
       //String sql = "SELECT id_art,descri_art,cant_art,costo_art,estado_art  FROM inventario";
                
        String registro[] = new String[6];
        DefaultTableModel modelo = (DefaultTableModel) t_profesor.getModel();
        modelo.getDataVector().clear();
        
            try{
                 //Statement cr = cn.createStatement();                 
                 //ResultSet rs = cr.executeQuery(sql);
                 
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
            
                 while(rs.next()){
                   registro[0] = rs.getString("matricula");
                   registro[1] = rs.getString("nom_prof");
                   registro[2] = rs.getString("ape_prof");
                   registro[3] = rs.getString("sex_prof");
                   registro[4] = rs.getString("password");
                   registro[5] = rs.getString("acceso");
                   
                   modelo.addRow(registro);
                 }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex);
            } 
        
        t_profesor.setModel(modelo);
    }
    
    //actualizar datos
    public void actualizar_datos(){
        try {
            String sql="UPDATE tabla_profesor SET nom_prof='"+txtnom_prof.getText()+"',"
                    + "ape_prof='"+txtape_prof.getText()+"',sex_prof='"+txtsex_prof.getText()+"',"
                    +"password='"+txtpass.getText()+"',acceso='"+cbacceso.getSelectedItem()+"' where matricula='"+txtmatricula.getText()+"'";           
            PreparedStatement in = cn.prepareStatement(sql);                  
            in.executeUpdate();
            //-------------------------------------------------------------------
           
            JOptionPane.showMessageDialog(null,"Datos actualizado");
                      
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
      
    }
    
   
    //limpiara los text field
    public void limpiar(){
        txtmatricula.setText("");
        txtnom_prof.setText("");
        txtape_prof.setText("");
        txtsex_prof.setText("");
        this.txtpass.setText("");
        txtmatricula.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jp_fondo = new javax.swing.JPanel();
        btnlimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtmatricula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnom_prof = new javax.swing.JTextField();
        txtape_prof = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtsex_prof = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbacceso = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        btnactualizar = new javax.swing.JButton();
        atras = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        btnregistrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        t_profesor = new javax.swing.JTable();

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

        jButton2.setText("Salir");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_fondo.setForeground(new java.awt.Color(255, 255, 255));
        jp_fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnlimpiar.setBackground(new java.awt.Color(255, 153, 51));
        btnlimpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnlimpiar.setText("Limpiar ");
        btnlimpiar.setContentAreaFilled(false);
        btnlimpiar.setOpaque(true);
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        jp_fondo.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 150, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos profesor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Matricula");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 66, -1));

        txtmatricula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtmatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmatriculaKeyReleased(evt);
            }
        });
        jPanel2.add(txtmatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 30, 190, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtnom_prof.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txtnom_prof, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 190, -1));

        txtape_prof.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txtape_prof, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 190, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Apellido");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        txtsex_prof.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txtsex_prof, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 190, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Sexo");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 37, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Acceso");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 60, -1));

        cbacceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Secundario", "Administrador" }));
        jPanel2.add(cbacceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 190, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Contraseña");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        txtpass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 190, -1));

        jp_fondo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 310, 210));

        btnactualizar.setBackground(new java.awt.Color(255, 153, 51));
        btnactualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnactualizar.setText("Actualizar Datos");
        btnactualizar.setContentAreaFilled(false);
        btnactualizar.setOpaque(true);
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        jp_fondo.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 150, 30));

        atras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        atras.setForeground(new java.awt.Color(206, 184, 54));
        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-izquierda-40.png"))); // NOI18N
        atras.setText("Volver");
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
        });
        jp_fondo.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(51, 204, 0));
        titulo.setText("Mantenimiento de Profesor");
        jp_fondo.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 560, -1));

        btnregistrar.setBackground(new java.awt.Color(255, 153, 51));
        btnregistrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnregistrar.setText("Registrar");
        btnregistrar.setContentAreaFilled(false);
        btnregistrar.setOpaque(true);
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        jp_fondo.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 150, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Buscar ");
        jp_fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 51, -1));

        txtbuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jp_fondo.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 190, 20));

        t_profesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Apellido", "Sexo", "Contraseña", "Acceso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_profesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_profesorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(t_profesor);

        jp_fondo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 620, 200));

        getContentPane().add(jp_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void txtmatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmatriculaKeyReleased
//        this.buscar_datos();
    }//GEN-LAST:event_txtmatriculaKeyReleased

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        actualizar_datos();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        mantenimiento ob = new mantenimiento();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_atrasMouseClicked

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
      
         guardar_datos();
         cargar_datos();
         limpiar();
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        buscar_datos();
        //cargar_datos();
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void t_profesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_profesorMouseClicked
        int index = t_profesor.getSelectedRow();

        if(index>=0){
            this.txtmatricula.setText(t_profesor.getValueAt(index, 0).toString());
            this.txtnom_prof.setText(t_profesor.getValueAt(index, 1).toString());
            this.txtape_prof.setText(t_profesor.getValueAt(index, 2).toString());
            this.txtsex_prof.setText(t_profesor.getValueAt(index, 3).toString());
            this.txtpass.setText(t_profesor.getValueAt(index, 4).toString());
            this.cbacceso.setSelectedItem(t_profesor.getValueAt(index, 5));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_profesorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atras;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JComboBox<String> cbacceso;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jp_fondo;
    private javax.swing.JTable t_profesor;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtape_prof;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtmatricula;
    private javax.swing.JTextField txtnom_prof;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtsex_prof;
    // End of variables declaration//GEN-END:variables
}
