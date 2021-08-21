
package clases;

import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;



public class menu extends javax.swing.JFrame {

    
    public menu() {
        initComponents();
        this.setLocationRelativeTo(null);
//        this.setSize(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_fondo = new javax.swing.JPanel();
        btn_mant = new javax.swing.JButton();
        btn_con = new javax.swing.JButton();
        titulo1 = new javax.swing.JLabel();
        btn_pro = new javax.swing.JButton();
        cerrar = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_fondo.setBackground(new java.awt.Color(153, 255, 153));
        jp_fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_mant.setBackground(new java.awt.Color(153, 255, 153));
        btn_mant.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_mant.setForeground(new java.awt.Color(0, 204, 51));
        btn_mant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mantenimiento.png"))); // NOI18N
        btn_mant.setText("Mantenimiento");
        btn_mant.setAutoscrolls(true);
        btn_mant.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_mant.setContentAreaFilled(false);
        btn_mant.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_mant.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_mant.setName(""); // NOI18N
        btn_mant.setOpaque(true);
        btn_mant.setSelected(true);
        btn_mant.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_mant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_mantMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_mantMouseExited(evt);
            }
        });
        btn_mant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mantActionPerformed(evt);
            }
        });
        jp_fondo.add(btn_mant, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 320, 380));

        btn_con.setBackground(new java.awt.Color(153, 255, 153));
        btn_con.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_con.setForeground(new java.awt.Color(0, 204, 51));
        btn_con.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consulta.png"))); // NOI18N
        btn_con.setText("Consultar/Liberar Equipos");
        btn_con.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_con.setContentAreaFilled(false);
        btn_con.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_con.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_con.setOpaque(true);
        btn_con.setSelected(true);
        btn_con.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_con.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_conMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_conMouseExited(evt);
            }
        });
        btn_con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conActionPerformed(evt);
            }
        });
        jp_fondo.add(btn_con, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 320, 380));

        titulo1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        titulo1.setForeground(new java.awt.Color(51, 204, 0));
        titulo1.setText("AudioVisuales UTESA");
        jp_fondo.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 520, -1));

        btn_pro.setBackground(new java.awt.Color(153, 255, 153));
        btn_pro.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_pro.setForeground(new java.awt.Color(0, 204, 51));
        btn_pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proceso.png"))); // NOI18N
        btn_pro.setText("Reservaciones de equipos");
        btn_pro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_pro.setContentAreaFilled(false);
        btn_pro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_pro.setDefaultCapable(false);
        btn_pro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_pro.setName(""); // NOI18N
        btn_pro.setOpaque(true);
        btn_pro.setSelected(true);
        btn_pro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_pro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_proMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_proMouseExited(evt);
            }
        });
        btn_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proActionPerformed(evt);
            }
        });
        jp_fondo.add(btn_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 350, 380));

        cerrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-ventana-negro.png"))); // NOI18N
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        jp_fondo.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 20, 20));

        minimizar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimizar-la-ventana-30.png"))); // NOI18N
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        jp_fondo.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 20, 20));

        getContentPane().add(jp_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_mantMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mantMouseEntered
        this.btn_mant.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_mantMouseEntered

    private void btn_mantMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mantMouseExited
        this.btn_mant.setBackground(new Color(153,255,153));
    }//GEN-LAST:event_btn_mantMouseExited

    private void btn_conMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_conMouseEntered
        this.btn_con.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_conMouseEntered

    private void btn_conMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_conMouseExited
        this.btn_con.setBackground(new Color(153,255,153));
    }//GEN-LAST:event_btn_conMouseExited

    private void btn_proMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_proMouseEntered
        this.btn_pro.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_proMouseEntered

    private void btn_proMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_proMouseExited
        this.btn_pro.setBackground(new Color(153,255,153));
    }//GEN-LAST:event_btn_proMouseExited

    private void btn_mantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mantActionPerformed
        mantenimiento ob = new mantenimiento();
       
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_mantActionPerformed

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_cerrarMouseClicked

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        menu ob = new menu();
       
//        ob.setMinimumSize(new Dimension(0,0));
        
//        ob.setVisible(false);
        
    }//GEN-LAST:event_minimizarMouseClicked

    private void btn_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proActionPerformed
      
        try {
           reserva_equipo  ob = new reserva_equipo();
            ob.setVisible(true);
            dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btn_proActionPerformed

    private void btn_conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conActionPerformed
        try {
            consulta ob = new consulta();
            ob.setVisible(true);
            dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_conActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_con;
    private javax.swing.JButton btn_mant;
    private javax.swing.JButton btn_pro;
    private javax.swing.JLabel cerrar;
    private javax.swing.JPanel jp_fondo;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
