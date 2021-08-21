package clases;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {

    conectar cc = new conectar();
    Connection con = cc.conexion();
    
    //objeto de la clase menu
  
    public login() throws ClassNotFoundException, SQLException{
        initComponents();
        this.setLocationRelativeTo(null);
        //this.btningresar.requestDefaultFocus();
    }
      menu ob2 = new menu();
       mantenimiento ob = new mantenimiento();
                 
    public void validacion_usuario(){     
        try{
            String sql = "SELECT user_matri,pass,acceso FROM login where user_matri='"+txtusuario.getText()+"' AND pass='"+txtpassword.getText()+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                String acceso=rs.getString("acceso");
                if(acceso.equalsIgnoreCase("administrador")){
                ob2.setVisible(true);
                this.setVisible(false);
                }
                else if (acceso.equalsIgnoreCase("secundario")){
                ob2.setVisible(true);
                ob.setVisible(false);
                this.setVisible(false);
                }
            
            }else{
                JOptionPane.showMessageDialog(null,"Matricula, usuario incorrecto y/o \n"
                        + " no existe estudiante");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
  

    @Override
    public void setName(String string) {
        super.setName(string); //To change body of generated methods, choose Tools | Templates.
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jp_login = new javax.swing.JPanel();
        linea1 = new javax.swing.JLabel();
        linea2 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        btnsalir = new javax.swing.JButton();
        btningresar = new javax.swing.JButton();
        txtusuario = new javax.swing.JTextField();
        usuario = new javax.swing.JLabel();
        contra = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOGIN");
        setName("frame_login"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(0, 204, 51));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_login.setBackground(new java.awt.Color(255, 255, 255));
        jp_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        linea1.setText("__________________________________");
        jp_login.add(linea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        linea2.setText("__________________________________");
        jp_login.add(linea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 206, 20));

        txtpassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtpassword.setBorder(null);
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpasswordKeyTyped(evt);
            }
        });
        jp_login.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 204, 30));

        btnsalir.setBackground(new java.awt.Color(255, 255, 255));
        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(0, 204, 51));
        btnsalir.setText("Salir");
        btnsalir.setContentAreaFilled(false);
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jp_login.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 80, -1));

        btningresar.setBackground(new java.awt.Color(255, 255, 255));
        btningresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btningresar.setForeground(new java.awt.Color(0, 204, 51));
        btningresar.setText("Ingresar");
        btningresar.setBorder(null);
        btningresar.setContentAreaFilled(false);
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        btningresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btningresarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btningresarKeyTyped(evt);
            }
        });
        jp_login.add(btningresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 110, 30));

        txtusuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtusuario.setBorder(null);
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        jp_login.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 204, 30));

        usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        usuario.setForeground(new java.awt.Color(0, 204, 51));
        usuario.setText("Usuario");
        jp_login.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        contra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        contra.setForeground(new java.awt.Color(0, 204, 51));
        contra.setText("Contraseña");
        jp_login.add(contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 51));
        jLabel2.setText("LOGIN");
        jp_login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 160, 40));

        fondo.add(jp_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 420, 310));

        titulo1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titulo1.setForeground(new java.awt.Color(255, 255, 255));
        titulo1.setText("AudioVisuales UTESA");
        fondo.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 410, -1));

        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        if(txtusuario.getText().equals("") || txtpassword.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
        }else{
            this.validacion_usuario();
        }
    }//GEN-LAST:event_btningresarActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        if(txtusuario.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtusuario.requestFocus();
        }else{
            this.txtpassword.requestFocus();
        }
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        if(txtpassword.getText().equals("")){
            
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            txtpassword.requestFocus();    
        }
     
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void btningresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btningresarKeyPressed
        
        if(evt.getKeyChar() == '\n'){
            if(txtusuario.getText().equals("") || txtpassword.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
           }else{
            this.validacion_usuario();
           }
        }
        
    }//GEN-LAST:event_btningresarKeyPressed

    private void btningresarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btningresarKeyTyped
       if(evt.getKeyChar() == '\n'){
            if(txtusuario.getText().equals("") || txtpassword.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
           }else{
            this.validacion_usuario();
           }
        }
    }//GEN-LAST:event_btningresarKeyTyped

    private void txtpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyTyped
        
    }//GEN-LAST:event_txtpasswordKeyTyped

    private void txtpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyReleased
//       if(evt.getKeyCode() == KeyEvent.VK_ENTER ){
//            if(evt.getKeyChar() == '\n'){
//            if(txtusuario.getText().equals("") || txtpassword.getText().equals("")){
//            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
//           }else{
//            this.validacion_usuario();
//           }
//        }
//        }
    }//GEN-LAST:event_txtpasswordKeyReleased

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER ){
            if(evt.getKeyChar() == '\n'){
            if(txtusuario.getText().equals("") || txtpassword.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
           }else{
            this.validacion_usuario();
           }
        }
        }
    }//GEN-LAST:event_txtpasswordKeyPressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new login().setVisible(true);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btningresar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel contra;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jp_login;
    private javax.swing.JLabel linea1;
    private javax.swing.JLabel linea2;
    private javax.swing.JLabel titulo1;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusuario;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
