
package clases;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fernando Escoboza
 */
public class consulta extends javax.swing.JFrame {
 conectar ob = new conectar();
  Connection cn  ;
    public consulta() throws ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
        cn = ob.conexion();
        cargar_datos_ocupados();
    }
     public void cargar_datos_ocupados(){
        String sql = "SELECT * FROM serial_articulo WHERE estado='Ocupado' ";
                
        String registro[] = new String[4];
        DefaultTableModel modelo = (DefaultTableModel) t_equipo_ocupado.getModel();
        modelo.getDataVector().clear();
        
            try{
                 Statement cr = cn.createStatement();
                 ResultSet rs = cr.executeQuery(sql);
                 
                 while(rs.next()){
                   registro[0] = rs.getString("id_art");
                   registro[1] = rs.getString("descri_art");
                   registro[2] = rs.getString("id_serial");    
                   registro[3] = rs.getString("estado");  
                  
                   modelo.addRow(registro);
                 }                 
                 
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex);
            }
      
        t_equipo_ocupado.setModel(modelo);
    }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_fondo = new javax.swing.JPanel();
        titulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        atras = new javax.swing.JLabel();
        p_ArticulosOcupado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_equipo_ocupado = new javax.swing.JTable();
        btnconsultar = new javax.swing.JButton();
        btnliberar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p_fondo.setBackground(new java.awt.Color(153, 255, 153));
        p_fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titulo1.setForeground(new java.awt.Color(51, 204, 0));
        titulo1.setText("Equipos Ocupados");
        p_fondo.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 350, -1));

        jLabel1.setBackground(new java.awt.Color(204, 204, 0));
        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel1.setText("Derechos Reservados 2-16-1286, 2018");
        jLabel1.setOpaque(true);
        p_fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 540, -1, 20));

        atras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        atras.setForeground(new java.awt.Color(206, 184, 54));
        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-izquierda-40.png"))); // NOI18N
        atras.setText("Menu Principal");
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
        });
        p_fondo.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        p_ArticulosOcupado.setBackground(new java.awt.Color(153, 255, 153));
        p_ArticulosOcupado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Equipos Ocupado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        p_ArticulosOcupado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_equipo_ocupado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id  articulo", "Describcion articulo", "Serial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_equipo_ocupado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_equipo_ocupadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_equipo_ocupado);

        p_ArticulosOcupado.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 740, 350));

        p_fondo.add(p_ArticulosOcupado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 760, 390));
        p_ArticulosOcupado.getAccessibleContext().setAccessibleName("Equipos Ocupados");

        btnconsultar.setBackground(new java.awt.Color(255, 153, 51));
        btnconsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnconsultar.setText("Consultar");
        btnconsultar.setContentAreaFilled(false);
        btnconsultar.setOpaque(true);
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });
        p_fondo.add(btnconsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 230, 30));

        btnliberar.setBackground(new java.awt.Color(255, 153, 51));
        btnliberar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnliberar.setText("Liberar");
        btnliberar.setContentAreaFilled(false);
        btnliberar.setOpaque(true);
        btnliberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnliberarActionPerformed(evt);
            }
        });
        p_fondo.add(btnliberar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 220, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(p_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(p_fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        menu ob = new menu();

        ob.setMinimumSize(new Dimension(0,0));
        ob.setVisible(true);
        dispose();
    }//GEN-LAST:event_atrasMouseClicked

    private void t_equipo_ocupadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_equipo_ocupadoMouseClicked
//        int index = t_equipo_ocupado.getSelectedRow();
//
//        if(index>=0){
//          //  this.txtid_art.setText(t_equipo.getValueAt(index,0).toString());
//           // this.txtdescri.setText(t_equipo.getValueAt(index,1).toString());
//            //this.txtserial.setText(t_equipo.getValueAt(index,2).toString());
//        }
    }//GEN-LAST:event_t_equipo_ocupadoMouseClicked

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
       cargar_datos_ocupados();
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnliberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnliberarActionPerformed
       int index = t_equipo_ocupado.getSelectedRow();

        if(index>=0){
            String serial = t_equipo_ocupado.getValueAt(index,2).toString();
            String sql = "UPDATE serial_articulo SET estado='Disponible' WHERE id_serial='"+serial+"'";  
            String sql2 = "DELETE FROM reserva WHERE serial='"+serial+"'";  
            String sql3 = "UPDATE serial_articulo SET estado='Disponible' WHERE id_serial='"+serial+"'";   
             
            try{
                PreparedStatement pre = cn.prepareStatement(sql);
                pre.executeUpdate();
                pre.close();
                
                 PreparedStatement pre2 = cn.prepareStatement(sql2);
                pre2.executeUpdate();
                pre2.close();
                
                PreparedStatement pre3 = cn.prepareStatement(sql3);
                pre3.executeUpdate();
                pre3.close();     
                cargar_datos_ocupados();
                
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex);
            }  
            
           
            
          //  this.txtid_art.setText(t_equipo.getValueAt(index,0).toString());
           // this.txtdescri.setText(t_equipo.getValueAt(index,1).toString());
            //this.txtserial.setText(t_equipo.getValueAt(index,2).toString());
        }

    }//GEN-LAST:event_btnliberarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atras;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btnliberar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel p_ArticulosOcupado;
    private javax.swing.JPanel p_fondo;
    private javax.swing.JTable t_equipo_ocupado;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
