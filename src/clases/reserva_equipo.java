
package clases;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public final class reserva_equipo extends javax.swing.JFrame {
  //variables globares 
    String fecha = "";
  conectar ob = new conectar();
  Connection cn ;//variable tipo Connection
    public reserva_equipo() throws ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
        cn = ob.conexion();
       cargar_datos_ocupados();
    }

    //buscar datos del estudiante
     public void buscar_datos_persona(){
        String sql = "SELECT nom_est,ape_est FROM tabla_estudiante WHERE matricula='"+txtmatricula.getText()+"'";
        String registro[] = new String[5];

        try{
            /*createStatement crea una solicitud*/
            Statement st = cn.createStatement();
            
            /*resultset tomara los resultado de la tabla.
            executeQuery trae los datos de la base de datos*/
            ResultSet rs = st.executeQuery(sql);
            
            /*mientra el resultado traido puedas enviarlo al resgistro 
            sigo dando vuelta en cambio8 termina el ciclo*/
            while (rs.next()){
            registro[0] = rs.getString("nom_est");
            registro[1] = rs.getString("ape_est");
            }            
            
            txtnombre.setText(registro[0]);
            txtapellido.setText(registro[1]);   
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
      //cargar_datos();
    }
     
    public void bucar_datos_articulo(){
        //extraer fecha
         java.util.Date dfecha = jfecha.getDate();
         SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
         fecha= formato.format(dfecha); 
         
         
        String sql2 = "SELECT desde,hasta,serial FROM reserva WHERE fecha='"+fecha+"' "
                + " AND horario='"+cbhorario.getSelectedItem()+"'";
        String registro[] = new String[5];
        
        try{
            Statement cr = cn.createStatement();
            ResultSet rs = cr.executeQuery(sql2);
                 
            while(rs.next()){
            //registro[2] = rs.getString("desde");
            //registro[3] = rs.getString("hasta");  
            registro[0] = rs.getString("serial");
            int desde = Integer.valueOf(rs.getString("desde"));    
            int hasta = Integer.valueOf(rs.getString("hasta"));  
            int txtdesde = Integer.valueOf(txthora_desde.getText());
            int txthasta = Integer.valueOf(txthora_hasta.getText());
            
                    if(txtdesde<=desde && txthasta>=hasta /*&& (txthasta<=desde && txthasta>=hasta) */){
                        String sql3 = "UPDATE serial_articulo SET estado='Disponible' WHERE id_serial='"+registro[0]+"'";   
                            try{
                                PreparedStatement pre = cn.prepareStatement(sql3);
                                pre.executeUpdate();
                                pre.close();                            
                           }catch(SQLException ex){
                                JOptionPane.showMessageDialog(null,ex);
                            }  
                    }else{                        
                           String sql3 = "UPDATE serial_articulo SET estado='Ocupado' WHERE id_serial='"+registro[0]+"'";   
                           try{
                                PreparedStatement pre2 = cn.prepareStatement(sql3);
                                pre2.executeUpdate();
                                pre2.close();
                            }catch(SQLException ex){
                                JOptionPane.showMessageDialog(null,ex);
                            }  
                        }       
                    }
                
            cargar_datos();
             
           }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex);
        }
    }
     
     //cargar datos de la tabla equipos disponible
     public void cargar_datos(){
        String sql = "SELECT * FROM serial_articulo WHERE estado='Disponible' ";
                
        String registro[] = new String[4];
        DefaultTableModel modelo = (DefaultTableModel) t_equipo.getModel();
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
      
        t_equipo.setModel(modelo);
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
     
    
     //guardara los datos de la reserva
     public void reserva (){
        //extrear fecha        
        Date dfecha = jfecha.getDate();
        java.sql.Date datesql = new java.sql.Date(dfecha.getTime());
        
        int matricula = Integer.valueOf(txtmatricula.getText());
        int desde  = Integer.valueOf(txthora_desde.getText());
        int hasta  = Integer.valueOf(txthora_hasta.getText());
        
        String sql ="INSERT INTO reserva(matricula,fecha,horario,desde,hasta,id_edificio,id_nivel,aula,serial,estado) "
                + "VALUES('"+matricula+"','"+datesql+"','"+cbhorario.getSelectedItem()+"','"+desde+"','"+hasta+"',"
                + "'"+cbedificio.getSelectedItem()+"','"+cbnivel.getSelectedItem()+"','"+cbaula.getSelectedItem()+"',"
                + "'"+txtserial.getText()+"','Ocupado')";
        try{
            try (PreparedStatement pre = cn.prepareStatement(sql)) {
                pre.executeUpdate();
                pre.close();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        } 
        
        //actualizar el estado del serial en la tabla serial_articulo
       String sql3 = "UPDATE serial_articulo SET estado='Ocupado' WHERE id_serial='"+txtserial.getText()+"'";   
          
            try{
            try (PreparedStatement pre = cn.prepareStatement(sql3)) {
                pre.executeUpdate();
                pre.close();
            }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex);
            }      
     }
     
    //detalle de reserva
     public void detalle_reserva(){  
        //trae la informacion de la tabla reserva, 1er try-catch
        String sql1 = "SELECT id_reserva,desde,hasta,serial,estado FROM reserva WHERE estado='Ocupado'";
        String registro[] = new String[5];
        
        int desde = 0;
        int hasta = 0;
        int id_reserva = 0;
        
        try{
            ResultSet rs;
            try (Statement st = cn.createStatement()) {
                rs = st.executeQuery(sql1);
                while(rs.next()){
                    id_reserva = Integer.valueOf(rs.getString("id_reserva"));
                    desde = Integer.valueOf(rs.getString("desde"));
                    hasta = Integer.valueOf(rs.getString("hasta"));
                    registro[0] = rs.getString("serial");
                    registro[1] = rs.getString("estado");
                }
            }
         rs.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        } 
        
        //introducir esos valores en la tabla detalle reserva, 2do try-catch
        // int index1 = t_equipo.getSelectedRow();
        int id_art = Integer.valueOf(txtid_art.getText());
        
         String sql2 = "INSERT INTO detalle_reserva(id_reserva,id_art,desde,hasta,serial_art,estado) "
                 + "VALUES('"+id_reserva+"','"+id_art+"','"+desde+"','"+hasta+"','"+txtserial.getText()+"',"
                 + " 'Ocupado') ";
          try{
            try (PreparedStatement pre = cn.prepareStatement(sql2)) {
                pre.executeUpdate();
                pre.close();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
            
        }

     }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_fondo = new javax.swing.JPanel();
        titulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        atras = new javax.swing.JLabel();
        p_InformacionPersonal = new javax.swing.JPanel();
        txtapellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtmatricula = new javax.swing.JTextField();
        cbusuario = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        p_DatosReserva = new javax.swing.JPanel();
        jfecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txthora_desde = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbhorario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txthora_hasta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbnivel = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbedificio = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbaula = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbtipo = new javax.swing.JComboBox<>();
        btnbuscar = new javax.swing.JButton();
        p_ArticulosDisponible = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_equipo = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txtid_art = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtdescri = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtserial = new javax.swing.JTextField();
        btnreservar1 = new javax.swing.JButton();
        p_ArticulosOcupado = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_equipo_ocupado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p_fondo.setBackground(new java.awt.Color(153, 255, 153));
        p_fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titulo1.setForeground(new java.awt.Color(51, 204, 0));
        titulo1.setText("Reserva de Equipos");
        p_fondo.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 380, -1));

        jLabel1.setBackground(new java.awt.Color(204, 204, 0));
        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel1.setText("Derechos Reservados 2-16-1286, 2018");
        jLabel1.setOpaque(true);
        p_fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 650, -1, 20));

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

        p_InformacionPersonal.setBackground(new java.awt.Color(153, 255, 153));
        p_InformacionPersonal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Informacion Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        p_InformacionPersonal.setForeground(new java.awt.Color(255, 255, 255));
        p_InformacionPersonal.setToolTipText("Informacion Personal");
        p_InformacionPersonal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtapellido.setOpaque(false);
        p_InformacionPersonal.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Apellido");
        p_InformacionPersonal.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nombre");
        p_InformacionPersonal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        txtnombre.setOpaque(false);
        p_InformacionPersonal.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Usuario");
        p_InformacionPersonal.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        txtmatricula.setOpaque(false);
        txtmatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmatriculaKeyReleased(evt);
            }
        });
        p_InformacionPersonal.add(txtmatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 150, -1));

        cbusuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbusuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante ", "Profesor " }));
        p_InformacionPersonal.add(cbusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Matricula");
        p_InformacionPersonal.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        p_fondo.add(p_InformacionPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 340, 140));

        p_DatosReserva.setBackground(new java.awt.Color(153, 255, 153));
        p_DatosReserva.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos para la reserva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        p_DatosReserva.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        p_DatosReserva.add(jfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fecha");
        p_DatosReserva.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Hora desde");
        p_DatosReserva.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 80, -1));
        p_DatosReserva.add(txthora_desde, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Horario");
        p_DatosReserva.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        cbhorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM", " " }));
        p_DatosReserva.add(cbhorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 140, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Hora hasta");
        p_DatosReserva.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));
        p_DatosReserva.add(txthora_hasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 140, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nivel");
        p_DatosReserva.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        cbnivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        p_DatosReserva.add(cbnivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 140, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Edificio");
        p_DatosReserva.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        cbedificio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));
        p_DatosReserva.add(cbedificio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Aula");
        p_DatosReserva.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        cbaula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        p_DatosReserva.add(cbaula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 140, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Tipo de Equipo");
        p_DatosReserva.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        cbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data show", "Laptop", "Pantalla" }));
        p_DatosReserva.add(cbtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 140, -1));

        btnbuscar.setBackground(new java.awt.Color(255, 153, 51));
        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.setContentAreaFilled(false);
        btnbuscar.setOpaque(true);
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        p_DatosReserva.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 300, 30));

        p_fondo.add(p_DatosReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 340, 250));

        p_ArticulosDisponible.setBackground(new java.awt.Color(153, 255, 153));
        p_ArticulosDisponible.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Equipos Disponible", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        p_ArticulosDisponible.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_equipo.setModel(new javax.swing.table.DefaultTableModel(
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
        t_equipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_equipoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_equipo);

        p_ArticulosDisponible.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 370, 230));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Id Articulo");
        p_ArticulosDisponible.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 20));
        p_ArticulosDisponible.add(txtid_art, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Describcion");
        p_ArticulosDisponible.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 80, 20));
        p_ArticulosDisponible.add(txtdescri, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 130, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Serial");
        p_ArticulosDisponible.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 50, 20));
        p_ArticulosDisponible.add(txtserial, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 110, -1));

        btnreservar1.setBackground(new java.awt.Color(255, 153, 51));
        btnreservar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnreservar1.setText("Reservar");
        btnreservar1.setContentAreaFilled(false);
        btnreservar1.setOpaque(true);
        btnreservar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreservar1ActionPerformed(evt);
            }
        });
        p_ArticulosDisponible.add(btnreservar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 370, 30));

        p_fondo.add(p_ArticulosDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 390, 390));

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
        jScrollPane2.setViewportView(t_equipo_ocupado);

        p_ArticulosOcupado.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 710, 150));

        p_fondo.add(p_ArticulosOcupado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 750, 180));

        getContentPane().add(p_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        menu ob = new menu();

        ob.setMinimumSize(new Dimension(0,0));
        ob.setVisible(true);
        dispose();
    }//GEN-LAST:event_atrasMouseClicked

    private void txtmatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmatriculaKeyReleased
       this.buscar_datos_persona();
      
    }//GEN-LAST:event_txtmatriculaKeyReleased

    private void btnreservar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreservar1ActionPerformed
        if (txtmatricula.getText().equals("")) {
             JOptionPane.showMessageDialog(this,"Llene el campo matricula");
             return;
         }
         if (txtnombre.getText().equals("")) {
             JOptionPane.showMessageDialog(this,"Llene el campo nombre");
             return;
         }
         if (txtapellido.getText().equals("")) {
             JOptionPane.showMessageDialog(this,"Llene el campo apellido");
             return;
         }
         if (txtserial.getText().equals("")) {
             JOptionPane.showMessageDialog(this,"Llene el campo serial");
             return;
         }
         else{
            this.reserva();
            this.detalle_reserva();
         }
        this.cargar_datos();
        cargar_datos_ocupados();
        
    }//GEN-LAST:event_btnreservar1ActionPerformed

    private void t_equipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_equipoMouseClicked
        int index = t_equipo.getSelectedRow();
        
        if(index>=0){
           this.txtid_art.setText(t_equipo.getValueAt(index,0).toString());
           this.txtdescri.setText(t_equipo.getValueAt(index,1).toString());
           this.txtserial.setText(t_equipo.getValueAt(index,2).toString());
        }
    }//GEN-LAST:event_t_equipoMouseClicked

    private void t_equipo_ocupadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_equipo_ocupadoMouseClicked
        int index = t_equipo_ocupado.getSelectedRow();

        if(index>=0){
            //  this.txtid_art.setText(t_equipo.getValueAt(index,0).toString());
            // this.txtdescri.setText(t_equipo.getValueAt(index,1).toString());
            //this.txtserial.setText(t_equipo.getValueAt(index,2).toString());
        }
    }//GEN-LAST:event_t_equipo_ocupadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
      
        this.cargar_datos();
        cargar_datos_ocupados();
    }//GEN-LAST:event_btnbuscarActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atras;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnreservar1;
    private javax.swing.JComboBox<String> cbaula;
    private javax.swing.JComboBox<String> cbedificio;
    private javax.swing.JComboBox<String> cbhorario;
    private javax.swing.JComboBox<String> cbnivel;
    private javax.swing.JComboBox<String> cbtipo;
    private javax.swing.JComboBox<String> cbusuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jfecha;
    private javax.swing.JPanel p_ArticulosDisponible;
    private javax.swing.JPanel p_ArticulosOcupado;
    private javax.swing.JPanel p_DatosReserva;
    private javax.swing.JPanel p_InformacionPersonal;
    private javax.swing.JPanel p_fondo;
    private javax.swing.JTable t_equipo;
    private javax.swing.JTable t_equipo_ocupado;
    private javax.swing.JLabel titulo1;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtdescri;
    private javax.swing.JTextField txthora_desde;
    private javax.swing.JTextField txthora_hasta;
    private javax.swing.JTextField txtid_art;
    private javax.swing.JTextField txtmatricula;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtserial;
    // End of variables declaration//GEN-END:variables

}
