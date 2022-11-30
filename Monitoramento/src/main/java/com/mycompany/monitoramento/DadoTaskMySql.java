package com.mycompany.monitoramento;

import java.sql.SQLException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DadoTaskMySql extends TimerTask {

    private SqlCommands comandos;
    private String token = "";
    public DadoTaskMySql(String token) {
        this.comandos = new SqlCommands();
        this.token = token;
    }

    @Override
    public void run() {
        try {
            DatabaseMySql db = new DatabaseMySql();
            try {
                db.inserirDados(token);
                 System.out.println("Inseriu dados local");
            } catch (Exception e) {
                System.out.println("\n| Erro ao Inserir os dados no bd mysql |"
                        + "- Verifique a conexão\n");
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DadoTaskMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
