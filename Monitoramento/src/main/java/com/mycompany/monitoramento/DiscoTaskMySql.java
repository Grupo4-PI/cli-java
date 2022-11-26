/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guh_a
 */
public class DiscoTaskMySql extends TimerTask{
    private Looca looca;
    private SqlCommands comandos;
    
     public DiscoTaskMySql() {
        this.comandos = new SqlCommands();
        this.looca = new Looca();
    }
    @Override
    public void run() {
        Integer quantidadeDeDiscos = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://nocrash.database.windows.net:1433;database=NoCrash;encrypt=true;trustServerCertificate=false", "nocrash", "#Gfgrupo4");
            Statement stm = con.createStatement();

            try {
                for (int i = 0; i < quantidadeDeDiscos; i++) {
                    stm.execute(comandos.insertDisco(i));
                    System.out.println("insert local");
                }
            } catch (SQLException ex) {
                for (int i = 0; i < quantidadeDeDiscos; i++) {
                    stm.execute(comandos.updateDisco(i));
                    System.out.println("update local");
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DadoTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
