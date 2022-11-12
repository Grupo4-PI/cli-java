package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;
import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setResizable(false);
        setTitle("HardSystems | Login");

        URL caminhoImagem;
        Image iconeTitulo;
        caminhoImagem = this.getClass().getClassLoader().getResource("logoHS.png");
        iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        passwordLogin = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textLogin = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        outputLogin = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(151, 101, 37));
        jLabel2.setText("Senha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 248, -1, -1));

        passwordLogin.setBackground(new java.awt.Color(222, 222, 222));
        passwordLogin.setFont(new java.awt.Font("Gadugi", 1, 15)); // NOI18N
        passwordLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(151, 101, 37), 3));
        passwordLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordLoginActionPerformed(evt);
            }
        });
        jPanel1.add(passwordLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 275, 316, 32));

        btnLogin.setBackground(new java.awt.Color(66, 45, 16));
        btnLogin.setFont(new java.awt.Font("Gadugi", 1, 15)); // NOI18N
        btnLogin.setForeground(java.awt.Color.white);
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/door 1.png"))); // NOI18N
        btnLogin.setText("Entrar");
        btnLogin.setAlignmentY(0.0F);
        btnLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(131, 88, 32))); // NOI18N
        btnLogin.setBorderPainted(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnLogin.setDefaultCapable(false);
        btnLogin.setFocusPainted(false);
        btnLogin.setFocusable(false);
        btnLogin.setIconTextGap(12);
        btnLogin.setRequestFocusEnabled(false);
        btnLogin.setVerifyInputWhenFocusTarget(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 370, 121, 36));

        jLabel4.setBackground(new java.awt.Color(151, 101, 37));
        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(151, 101, 37));
        jLabel4.setText("Email:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 171, -1, -1));

        textLogin.setBackground(new java.awt.Color(222, 222, 222));
        textLogin.setFont(new java.awt.Font("Gadugi", 0, 15)); // NOI18N
        textLogin.setActionCommand("<Not Set>");
        textLogin.setAlignmentX(0.0F);
        textLogin.setAlignmentY(0.0F);
        textLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(151, 101, 37), 3));
        textLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLoginActionPerformed(evt);
            }
        });
        jPanel1.add(textLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 198, 316, 32));

        jPanel2.setBackground(new java.awt.Color(66, 45, 16));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/introductionContainerTop.jpg"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(66, 45, 16));
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonCadastro.jpg"))); // NOI18N
        jButton1.setAlignmentY(0.0F);
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setRequestFocusEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 0, -1, -1));

        jLabel6.setBackground(new java.awt.Color(151, 101, 37));
        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ContainerHelloFunc.png"))); // NOI18N
        jLabel6.setAlignmentY(0.0F);
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 104, 316, 34));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HardSystems.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 24, -1, 62));

        outputLogin.setBackground(java.awt.Color.white);
        outputLogin.setFont(new java.awt.Font("Gadugi", 0, 15)); // NOI18N
        outputLogin.setForeground(java.awt.Color.red);
        outputLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(outputLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 325, 316, 29));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundImage.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLoginActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String emailUsuario = textLogin.getText();
        String senha = passwordLogin.getText();


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://nocrash.database.windows.net:1433;database=nocrash;encrypt=true;trustServerCertificate=false", "nocrash", "#Gfgrupo4");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(
                    "select emailUsuario, senha from Usuario where emailUsuario='" + emailUsuario + "' and senha ='" + senha + "'");

            if (rs.next()) {
                dispose();
                Token page = new Token();
                page.show();
            } else {
                JOptionPane.showMessageDialog(this, "nome ou senha incorretas..");
                textLogin.setText("");
                passwordLogin.setText("");
            }
            con.close();
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            if (emailUsuario.length() == 0 || senha.length() == 0) {
                outputLogin.setText("Preencha todos os campos...");
            } else {
                outputLogin.setText("Usuário ou senha incorretos...");
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    public JPasswordField getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin(JPasswordField passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    public JTextField getTextLogin() {
        return textLogin;
    }

    public void setTextLogin(JTextField textLogin) {
        this.textLogin = textLogin;
    }

    private void passwordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordLoginActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel outputLogin;
    private javax.swing.JPasswordField passwordLogin;
    private javax.swing.JTextField textLogin;
    // End of variables declaration//GEN-END:variables
}
