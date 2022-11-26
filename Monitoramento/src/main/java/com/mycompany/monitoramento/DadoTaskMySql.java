/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoramento;

import java.sql.SQLException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guh_a
 */
public class DadoTaskMySql extends TimerTask {

    private SqlCommands comandos;

    public DadoTaskMySql() {
        this.comandos = new SqlCommands();

    }

    @Override
    public void run() {
        try {
            DatabaseMySql db = new DatabaseMySql();
            try {
               
                db.inserirDados();
                 System.out.println("Inseriu dados local");
            } catch (Exception e) {
                System.out.println("\n| Erro ao Inserir os dados no bd mysql |"
                        + "- Verifique a conexão\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DadoTaskMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
