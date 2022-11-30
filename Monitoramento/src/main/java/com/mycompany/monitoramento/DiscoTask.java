package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiscoTask extends TimerTask {

    private SqlCommands comandos;
    private Looca looca;
    private String token;

    public DiscoTask(String token) {
        this.comandos = new SqlCommands();
        this.looca = new Looca();
        this.token = token;
    }

    @Override
    public void run() {
        System.out.println("Executou!!! disco");

        Integer quantidadeDeDiscos = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://nocrash.database.windows.net:1433;database=NoCrash;encrypt=true;trustServerCertificate=false", "nocrash", "#Gfgrupo4");
            Statement stm = con.createStatement();

            try {
                for (int i = 0; i < quantidadeDeDiscos; i++) {
                    stm.execute(comandos.insertDisco(i, token));
                    System.out.println("insert azure");
                }
            } catch (SQLException ex) {
                for (int i = 0; i < quantidadeDeDiscos; i++) {
                    stm.execute(comandos.updateDisco(i, token));
                    System.out.println("update azure");
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DadoTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
