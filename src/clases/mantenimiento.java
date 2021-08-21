
package clases;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class mantenimiento extends javax.swing.JFrame {

   
    public mantenimiento() {
        initComponents();
        btn_mant_est.setText("<html>Mantenimiento </br> De Estudiantes </html>");
        btn_mant_prof.setText("<html>Mantenimiento </br> De Profesores </html>");
        btn_mant_art.setText("<html>Mantenimiento </br> De Articulos </html>");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo1 = new javax.swing.JLabel();
        btn_mant_est = new javax.swing.JButton();
        btn_mant_prof = new javax.swing.JButton();
        btn_mant_art = new javax.swing.JButton();
        cerrar = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        atras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        titulo1.setForeground(new java.awt.Color(51, 204, 0));
        titulo1.setText("Mantenimiento");
        jPanel1.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 480, -1));

        btn_mant_est.setBackground(new java.awt.Color(153, 255, 153));
        btn_mant_est.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_mant_est.setForeground(new java.awt.Color(51, 204, 0));
        btn_mant_est.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_mant_est.setContentAreaFilled(false);
        btn_mant_est.setOpaque(true);
        btn_mant_est.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_mant_estMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_mant_estMouseExited(evt);
            }
        });
        btn_mant_est.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mant_estActionPerformed(evt);
            }
        });
        jPanel1.add(btn_mant_est, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 270, 330));

        btn_mant_prof.setBackground(new java.awt.Color(153, 255, 153));
        btn_mant_prof.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_mant_prof.setForeground(new java.awt.Color(51, 204, 0));
        btn_mant_prof.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_mant_prof.setContentAreaFilled(false);
        btn_mant_prof.setOpaque(true);
        btn_mant_prof.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_mant_profMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_mant_profMouseExited(evt);
            }
        });
        btn_mant_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mant_profActionPerformed(evt);
            }
        });
        jPanel1.add(btn_mant_prof, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 270, 330));

        btn_mant_art.setBackground(new java.awt.Color(153, 255, 153));
        btn_mant_art.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_mant_art.setForeground(new java.awt.Color(51, 204, 0));
        btn_mant_art.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_mant_art.setContentAreaFilled(false);
        btn_mant_art.setOpaque(true);
        btn_mant_art.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_mant_artMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_mant_artMouseExited(evt);
            }
        });
        btn_mant_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mant_artActionPerformed(evt);
            }
        });
        jPanel1.add(btn_mant_art, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 270, 330));

        cerrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-ventana-negro.png"))); // NOI18N
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        jPanel1.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 20, 20));

        minimizar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimizar-la-ventana-30.png"))); // NOI18N
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        jPanel1.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 20, 20));

        atras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        atras.setForeground(new java.awt.Color(206, 184, 54));
        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-izquierda-40.png"))); // NOI18N
        atras.setText("Menu Principal");
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
        });
        jPanel1.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_mant_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mant_profActionPerformed
  
        try {
            mant_profesor2 ob = new mant_profesor2();
            ob.setVisible(true);
           dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
       // this.dispose();
    }//GEN-LAST:event_btn_mant_profActionPerformed

    private void btn_mant_estActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mant_estActionPerformed
        try {
            mant_estudiante ob = new mant_estudiante();
            ob.setVisible(true);  
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        
    }//GEN-LAST:event_btn_mant_estActionPerformed

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_cerrarMouseClicked

    private void btn_mant_estMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mant_estMouseEntered
        btn_mant_est.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_mant_estMouseEntered

    private void btn_mant_estMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mant_estMouseExited
        btn_mant_est.setBackground(new Color(153,255,153));
    }//GEN-LAST:event_btn_mant_estMouseExited

    private void btn_mant_profMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mant_profMouseEntered
        btn_mant_prof.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_mant_profMouseEntered

    private void btn_mant_profMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mant_profMouseExited
        btn_mant_prof.setBackground(new Color(153,255,153));
    }//GEN-LAST:event_btn_mant_profMouseExited

    private void btn_mant_artMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mant_artMouseEntered
       btn_mant_art.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_mant_artMouseEntered

    private void btn_mant_artMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mant_artMouseExited
       btn_mant_art.setBackground(new Color(153,255,153));
    }//GEN-LAST:event_btn_mant_artMouseExited

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        
    }//GEN-LAST:event_minimizarMouseClicked

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        menu ob = new menu();
       
        ob.setMinimumSize(new Dimension(0,0));
        ob.setVisible(true);
    }//GEN-LAST:event_atrasMouseClicked

    private void btn_mant_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mant_artActionPerformed
        try {
            mant_articulo ob = new mant_articulo();
            ob.setVisible(true);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(mantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btn_mant_artActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atras;
    private javax.swing.JButton btn_mant_art;
    private javax.swing.JButton btn_mant_est;
    private javax.swing.JButton btn_mant_prof;
    private javax.swing.JLabel cerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
