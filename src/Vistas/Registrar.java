/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Conexiones.conexion;
import Procedimientos.NuevoUsuario;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.font.TextAttribute;
import java.net.URI;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesús Mendoza
 */
public class Registrar extends javax.swing.JFrame {

    /**
     * Creates new form Registrar
     */
    
            int _x,_y;
             //COMPONENTES DEL SEGUNDO PLANO
            private ImageIcon imgIcon;
            private TrayIcon trayIcon;
            private SystemTray sysTray;
            
    public Registrar() {
        initComponents();
        this.setLocationRelativeTo(null);        //COLOCAR LA APP EN EL CENTRO
        imgIcon = new ImageIcon(getClass().getResource("../Img/corazon.png")); //IMAGEN QUE SERÁ USADA COMO ICONO
        try {
            setIconImage(imgIcon.getImage());         //MANDAR IMAGEN AL FRAME
        } catch (Exception e) {
        }
        this.setTitle("VITA DATA"); //TÍTULO DE LA APP
        instanciarTray(); //LLAMADO DEL MÉTODO AL INICIAR LA APP (DESDE ENTONCES LA APP YA SE ENCUENTRA EN SEGUNDO PLANO (VER A DETALLE ESTE MÉTODO)
        btnAceptar.setEnabled(false);
        checkVerify.setSelected(false);
        //Link
        Font font = lblLink.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_DOTTED);
        lblLink.setFont(font.deriveFont(attributes));
    }
    
    //MÉTODO PARA INSTANCIAR SYSTEM TRAY
    private void instanciarTray(){
        //ANTES DE ESTA LINEA DE CODIGO DEBERÁ CREARSE UN POPUP MENÚ EN AWT DE JAVA
        //SE INGRESA LA IMAGEN DE ICONO, UN TOOLTIP Y EL POPUP ANTES MENCIONADO QUE SERÁN LAS OPCIONES DEL USUARIO EN SEGUNDO PLANO
        trayIcon = new TrayIcon(imgIcon.getImage(), "VITA DATA", popup);
        //ACOPLAR ICONO
        trayIcon.setImageAutoSize(true);
        //INSTANCIAR SYSTEM TRAY
        sysTray = SystemTray.getSystemTray();
        initSysTray(); //MANDAR A SEGUNDO PLANO LA APP DESDE QUE SE INICIA
    }
    
    private void initSysTray(){
        try {
            //SOLO SE INICIALIZA SI EL SISTEMA SOPORTA SYSTEM TRAY
            if(SystemTray.isSupported()){
                //SE AGREGA LA VARIABLE QUE CONTIENE EL ÍCONO, TOOLTIP Y POPUP
                sysTray.add(trayIcon);
                //OCULTAR LA VENTANA
                this.setVisible(false);
            }
        } catch (Exception e) {
            //EN CASO DE ERROR, MOSTRARLO
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new java.awt.PopupMenu();
        open = new java.awt.MenuItem();
        exit = new java.awt.MenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtUser = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        txtMail = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtInd = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        txtPass = new org.edisoncor.gui.passwordField.PasswordFieldRoundBackground();
        txtPass2 = new org.edisoncor.gui.passwordField.PasswordFieldRoundBackground();
        jLabel4 = new javax.swing.JLabel();
        txtCed = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        checkVerify = new javax.swing.JCheckBox();
        lblLink = new javax.swing.JLabel();
        txtName = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        popup.setLabel("popupMenu1");

        open.setLabel("Abrir aplicación");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        popup.add(open);

        exit.setLabel("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        popup.add(exit);

        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(87, 169, 154));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(236, 244, 243));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtUser.setDescripcion("Nombre de usuario");
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        txtMail.setDescripcion("example@vitadata.com.mx");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Correo*:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Usuario*:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Confirmar*:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Indicio:");

        txtInd.setDescripcion("Indicio de contraseña");

        txtPass.setDescripcion("Contraseña");

        txtPass2.setDescripcion("Confirmar contraseña");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Contraseña*:");

        txtCed.setDescripcion("####### ");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Cedula*:");

        btnSalir.setBackground(new java.awt.Color(85, 81, 81));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR");
        btnSalir.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnSalirFocusGained(evt);
            }
        });
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalirKeyPressed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(85, 81, 81));
        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("ACEPTAR");
        btnAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnAceptarFocusGained(evt);
            }
        });
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceptarKeyPressed(evt);
            }
        });

        checkVerify.setBackground(new java.awt.Color(255, 255, 255));
        checkVerify.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkVerifyItemStateChanged(evt);
            }
        });
        checkVerify.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkVerifyStateChanged(evt);
            }
        });
        checkVerify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkVerifyMouseClicked(evt);
            }
        });

        lblLink.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblLink.setForeground(new java.awt.Color(0, 102, 153));
        lblLink.setLabelFor(checkVerify);
        lblLink.setText("Aceptar términos y condiciones de uso");
        lblLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLinkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLinkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLinkMouseExited(evt);
            }
        });

        txtName.setDescripcion("Ingrese su nombre completo");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Nombre*:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkVerify)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblLink, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCed, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInd, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(58, 58, 58)
                                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(31, 31, 31)
                                .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCed, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkVerify)
                    .addComponent(lblLink, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Century Gothic", 3, 36)); // NOI18N
        jLabel8.setText("REGISTRAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        initSysTray(); //MANDAR A SEGUNDO PLANO LA APP CUANDO SE PULSE SALIR EN LA VENTANA
    }//GEN-LAST:event_formWindowClosed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        //SI SE REQUIERE, SE PUEDE OCULTAR EL ICONO DE SEGUNDO PLANO
        //sysTray.remove(trayIcon);
        //MOSTRAR VENTANA
        this.setVisible(true);
    }//GEN-LAST:event_openActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        _x=evt.getX();
        _y=evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point _p = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(_p.x-_x,_p.y-_y);
    }//GEN-LAST:event_formMouseDragged

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnSalirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnSalirFocusGained

    }//GEN-LAST:event_btnSalirFocusGained

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked

    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        sysTray.remove(trayIcon);
        LogIn log = new LogIn();
        this.setVisible(false);
        log.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        
    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnAceptarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAceptarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarFocusGained

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       conexion connect = new conexion();
       NuevoUsuario dts = new NuevoUsuario();
       
       String user = txtUser.getText();
       String pass = txtPass.getText();
       String pass2 = txtPass2.getText();
       String mail = txtMail.getText();
       String ind = txtInd.getText();
       String name = txtName.getText();
       String ced = txtCed.getText();

       if(ind.isEmpty()){
           ind = "ninguno";
       }
       
       dts.setName(name);
       dts.setUser(user);
       dts.setPass(pass);
       dts.setMail(mail);
       dts.setCed(ced);
       dts.setInd(ind);
       
       if(user.length() > 7){
           if(pass.length() > 7 ){
               if(pass.equals(pass2)){
                   if (mail.contains("@") && mail.contains(".com") && mail.contains("mail")) {
                       if (!name.isEmpty()) {
                           if (ced.length() == 7) {
                               try {
                                   
                                   connect.nuevoUsuario(dts);
                                   sysTray.remove(trayIcon);
                                   LogIn log = new LogIn();
                                   this.setVisible(false);
                                   log.setVisible(true);
                                   
                               } catch (Exception e) {
                                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
                                   System.out.println("Error: " + e.getMessage());
                               }
                           } else {
                               JOptionPane.showMessageDialog(null, "Favor de ingresar una cédula válida", "Cédula incorrecta", JOptionPane.ERROR_MESSAGE);
                               checkVerify.setSelected(false);
                           }
                       } else {
                           JOptionPane.showMessageDialog(null, "Favor de ingresar su nombre", "Nombre incorrecto", JOptionPane.ERROR_MESSAGE);
                           checkVerify.setSelected(false);
                       }
                   } else {
                       JOptionPane.showMessageDialog(null, "Favor de ingresar un correo válido", "Correo incorrecto", JOptionPane.ERROR_MESSAGE);
                       checkVerify.setSelected(false);
                   }
               }else{
                   JOptionPane.showMessageDialog(null, "Asegúrese de que las contraseñas coincidan", "Contraseña incorrecta", JOptionPane.ERROR_MESSAGE);
                   checkVerify.setSelected(false);
               }
           }else{
               JOptionPane.showMessageDialog(null,"Favor de ingresar una contraseña mayor a 7 caracteres", "Contraseña incorrecta", JOptionPane.ERROR_MESSAGE);
               checkVerify.setSelected(false);
           }
       }else{
           JOptionPane.showMessageDialog(null,"Favor de ingresar un usuario mayor a 7 caracteres", "Usuario incorrecto", JOptionPane.ERROR_MESSAGE);
           checkVerify.setSelected(false);
       }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarKeyPressed

    private void checkVerifyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkVerifyStateChanged
        
    }//GEN-LAST:event_checkVerifyStateChanged

    private void checkVerifyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkVerifyItemStateChanged
       
    }//GEN-LAST:event_checkVerifyItemStateChanged

    private void lblLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLinkMouseClicked
        //String link = "https://app-1501208568.000webhostapp.com/";
        String link = "http://loginlock.260mb.net";
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_lblLinkMouseClicked

    private void checkVerifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkVerifyMouseClicked

       String user = txtUser.getText();
       String pass = txtPass.getText();
       String pass2 = txtPass2.getText();
       String mail = txtMail.getText();
       String name = txtName.getText();
       String ced = txtCed.getText();
       
       if(user.length() > 7){
           if(pass.length() > 7 ){
               if(pass.equals(pass2)){
                   if (mail.contains("@") && mail.contains(".com") && mail.contains("mail")) {
                       if (!name.isEmpty()) {
                           if (ced.length() == 7) {
                               if (checkVerify.isSelected()) {
                                   btnAceptar.setEnabled(true);
                               } else {
                                   btnAceptar.setEnabled(false);
                               }
                           } else {
                               JOptionPane.showMessageDialog(null, "Favor de ingresar los datos marcados con (*) correctamente", "Cédula incorrecta", JOptionPane.ERROR_MESSAGE);
                               checkVerify.setSelected(false);
                           }
                       } else {
                           JOptionPane.showMessageDialog(null, "Favor de ingresar los datos marcados con (*) correctamente", "Nombre incorrecto", JOptionPane.ERROR_MESSAGE);
                           checkVerify.setSelected(false);
                       }
                   } else {
                       JOptionPane.showMessageDialog(null, "Favor de ingresar un correo válido", "Correo incorrecto", JOptionPane.ERROR_MESSAGE);
                       checkVerify.setSelected(false);
                   }
               }else{
                   JOptionPane.showMessageDialog(null, "Asegúrese de que las contraseñas coincidan", "Contraseña incorrecta", JOptionPane.ERROR_MESSAGE);
                   checkVerify.setSelected(false);
               }
           }else{
               JOptionPane.showMessageDialog(null,"Favor de ingresar una contraseña mayor a 7 caracteres", "Contraseña incorrecta", JOptionPane.ERROR_MESSAGE);
               checkVerify.setSelected(false);
           }
       }else{
           JOptionPane.showMessageDialog(null,"Favor de ingresar los datos marcados con (*) correctamente", "Usuario incorrecto", JOptionPane.ERROR_MESSAGE);
           checkVerify.setSelected(false);
       }
        
        
    }//GEN-LAST:event_checkVerifyMouseClicked

    private void lblLinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLinkMouseEntered
        Font font = lblLink.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblLink.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblLinkMouseEntered

    private void lblLinkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLinkMouseExited
        Font font = lblLink.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_DOTTED);
        lblLink.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblLinkMouseExited

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
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox checkVerify;
    private java.awt.MenuItem exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblLink;
    private java.awt.MenuItem open;
    private java.awt.PopupMenu popup;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtCed;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtInd;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtMail;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtName;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundBackground txtPass;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundBackground txtPass2;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtUser;
    // End of variables declaration//GEN-END:variables
}