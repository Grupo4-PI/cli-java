package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MostrarDado extends javax.swing.JFrame {

    public MostrarDado() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mostrarTudo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        outputLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mostrarTudo.setBackground(new java.awt.Color(66, 45, 16));
        mostrarTudo.setFont(new java.awt.Font("Gadugi", 1, 15)); // NOI18N
        mostrarTudo.setForeground(java.awt.Color.white);
        mostrarTudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/databaseicon.png"))); // NOI18N
        mostrarTudo.setText("Dados");
        mostrarTudo.setAlignmentY(0.0F);
        mostrarTudo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(131, 88, 32))); // NOI18N
        mostrarTudo.setBorderPainted(false);
        mostrarTudo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarTudo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        mostrarTudo.setDefaultCapable(false);
        mostrarTudo.setFocusPainted(false);
        mostrarTudo.setFocusable(false);
        mostrarTudo.setIconTextGap(12);
        mostrarTudo.setRequestFocusEnabled(false);
        mostrarTudo.setVerifyInputWhenFocusTarget(false);
        mostrarTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTudoActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarTudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 121, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HardSystems.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, 62));

        outputLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundImage.png"))); // NOI18N
        outputLogin.setText("jLabel1");
        getContentPane().add(outputLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTudoActionPerformed
        DbMostrarDado mdado = new DbMostrarDado();
        Looca looca = new Looca();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://nocrash.database.windows.net:1433;database=NoCrash;encrypt=true;trustServerCertificate=false", "nocrash", "#Gfgrupo4");
            Statement stm = con.createStatement();

            Integer qtdDiscoJ = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();
            for (int i = 0; i < qtdDiscoJ; i++) {

                Disco disco = looca.getGrupoDeDiscos().getDiscos().get(i);
                String modelo = disco.getModelo();
                String serial = disco.getSerial();
                Long bytesEscrita = disco.getBytesDeEscritas() / 1000;
                Long bytesLeitura = disco.getBytesDeLeitura() / 1000;
                Long escritas = disco.getEscritas() / 1000;
                Long leituras = disco.getLeituras() / 1000;
                Long tamanho = disco.getTamanho() / 1000000000;
                Long tamanhoAtualFila = disco.getTamanhoAtualDaFila();
                Long tempoTransferencia = disco.getTempoDeTransferencia() / 1000;
                System.out.println(serial);
                stm.execute("INSERT INTO Disco (modelo, serial, bytesEscrita, bytesLeitura, escritas, leituras, tamanho, tamanhoAtualFila, tempoTransferencia,  fkHardware) "
                        + "VALUES ('" + modelo + "','" + serial + "','" + bytesEscrita + "','" + bytesLeitura + "','" + escritas + "','" + leituras + "','" + tamanho + "','" + tamanhoAtualFila + "','" + tempoTransferencia + "','" + mdado.getIdMaquina() + "')");
            }
            stm.execute("INSERT INTO Dado (memoriaDisponivel , usoProcessador, fkHardware) "
                    + "VALUES ('" + mdado.getEmUso() + "','" + mdado.getUsop() + "','" + mdado.getIdMaquina() + "')");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MostrarDado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mostrarTudoActionPerformed

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
            java.util.logging.Logger.getLogger(MostrarDado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarDado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton mostrarTudo;
    private javax.swing.JLabel outputLogin;
    // End of variables declaration//GEN-END:variables
}
