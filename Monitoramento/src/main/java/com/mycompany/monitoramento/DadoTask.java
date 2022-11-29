/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoramento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DadoTask extends TimerTask {

    private SqlCommands comandos;

    public DadoTask() {
        this.comandos = new SqlCommands();

    }

    @Override
    public void run() {
        try {
            DdDado mdado = new DdDado();
            System.out.println("executou dado azure");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://nocrash.database.windows.net:1433;database=NoCrash;encrypt=true;trustServerCertificate=false", "nocrash", "#Gfgrupo4");
            Statement stm = con.createStatement();

            stm.execute("INSERT INTO Dado (memoriaDisponivel , usoProcessador, fkHardware) "
                + "VALUES ('" + mdado.getEmUso() + "','" + mdado.getUsop() + "','" + mdado.getIdMaquina() + "');");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DadoTask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
