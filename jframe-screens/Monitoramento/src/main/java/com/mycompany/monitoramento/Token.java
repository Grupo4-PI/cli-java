package com.mycompany.monitoramento;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.Image;

public class Token extends javax.swing.JFrame {

    public Token() {
        initComponents();
        setResizable(false);
        setTitle("HardSystems | Token Insert");
        URL caminhoImagem;
        Image iconeTitulo;
        caminhoImagem = this.getClass().getClassLoader().getResource("logoHS.png");
        iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        TokenInserido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoToken = new javax.swing.JButton();
        outputLogin = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HardSystems.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 62));

        TokenInserido.setBackground(new java.awt.Color(222, 222, 222));
        TokenInserido.setFont(new java.awt.Font("Gadugi", 0, 15)); // NOI18N
        TokenInserido.setActionCommand("<Not Set>");
        TokenInserido.setAlignmentX(0.0F);
        TokenInserido.setAlignmentY(0.0F);
        TokenInserido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(151, 101, 37), 3));
        TokenInserido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TokenInseridoActionPerformed(evt);
            }
        });
        getContentPane().add(TokenInserido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 316, 32));

        jLabel2.setBackground(new java.awt.Color(151, 101, 37));
        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 15)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Insira o Token da Máquina:");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, 30));

        botaoToken.setBackground(new java.awt.Color(66, 45, 16));
        botaoToken.setFont(new java.awt.Font("Gadugi", 1, 15)); // NOI18N
        botaoToken.setForeground(java.awt.Color.white);
        botaoToken.setIcon(new javax.swing.ImageIcon(getClass().getResource("/verify.png"))); // NOI18N
        botaoToken.setText("Verificar");
        botaoToken.setAlignmentY(0.0F);
        botaoToken.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(131, 88, 32))); // NOI18N
        botaoToken.setBorderPainted(false);
        botaoToken.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoToken.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        botaoToken.setDefaultCapable(false);
        botaoToken.setFocusPainted(false);
        botaoToken.setFocusable(false);
        botaoToken.setIconTextGap(12);
        botaoToken.setRequestFocusEnabled(false);
        botaoToken.setVerifyInputWhenFocusTarget(false);
        botaoToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTokenActionPerformed(evt);
            }
        });
        getContentPane().add(botaoToken, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 121, 40));

        outputLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundImage.png"))); // NOI18N
        outputLogin.setText("jLabel1");
        getContentPane().add(outputLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TokenInseridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TokenInseridoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TokenInseridoActionPerformed

    private void botaoTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTokenActionPerformed
        // TODO add your handling code here: String emailUsuario = textLogin.getText();

        String token = TokenInserido.getText();
        Database database = new Database();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://nocrash.database.windows.net:1433;database=NoCrash;encrypt=true;trustServerCertificate=false", "nocrash", "#Gfgrupo4");
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(
                    "select idDesktop from Desktop where idDesktop = '" + " " + token + "'");

            if (rs.next()) {
                dispose();
                MostrarDado page = new MostrarDado();
                page.show();
                String sqlInsert = "";
                StringBuilder sb = new StringBuilder();

                sb.append("SELECT * FROM Hardware where fkDesktop = ' ").append(token).append("';");
                ResultSet verificarHardware = stm.executeQuery(sb.toString());

                if (!verificarHardware.next()) {
                    sqlInsert
                            = "INSERT INTO Hardware(idHardware ,nomeProcessador, "
                            + "fabricante, frequencia, memoriaTotal, qntDisco, fkDesktop)  VALUES ('"
                            + database.getIdMaquina() + "','" + database.getNomeProcessador() + "','"
                            + database.getFabricante() + "','" + database.getFrequencia() + "','"
                            + database.getMemoriaTotal() + "','" + database.getQntDisco() + "','" + " " + token + "')";
                } else {
                    sb.append("UPDATE Hardware SET");
                    sb.append(" nomeProcessador = '").append(database.getNomeProcessador()).append("'");
                    sb.append(", fabricante = '").append(database.getFabricante()).append("'");
                    sb.append(", frequencia = ").append(database.getFrequencia());
                    sb.append(", memoriaTotal = ").append(database.getMemoriaTotal());
                    sb.append(", qntDisco = ").append(database.getQntDisco());
                    sb.append(" WHERE fkDesktop = ' ").append(token).append("';");

                    sqlInsert = sb.toString();
                }
                stm.execute(sqlInsert);
            } else {
                JOptionPane.showMessageDialog(this, "Token Inválido!");
                TokenInserido.setText("");
            }
            con.close();
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            if (token.length() == 0) {
                outputLogin.setText("Preencha o campo...");
            } else {
                outputLogin.setText("Usuário ou senha incorretos...");
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_botaoTokenActionPerformed

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
            java.util.logging.Logger.getLogger(Token.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Token.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Token.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Token.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Token().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TokenInserido;
    private javax.swing.JButton botaoToken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel outputLogin;
    // End of variables declaration//GEN-END:variables
}
