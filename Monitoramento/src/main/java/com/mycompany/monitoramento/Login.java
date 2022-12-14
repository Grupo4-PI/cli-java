package com.mycompany.monitoramento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Timer;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SqlCommands sql = new SqlCommands();

        System.out.println("SEJA BEM-VINDO AO");

        System.out.println(" _____     __	________   ________   __  ____     __       _______   __    __      ________   __         __\n"
                + "|     \\   |  | |   __	| |  ______| |  |/    |   /  \\     |   ____| |  |  |  |    |  ______| |  |       |  |\n"
                + "|  |\\  \\  |  | |  |  |	| |  |       |   _____|  / || \\    |  |____  |  |__|  |    |  |       |  |       |  |\n"
                + "|  | \\  \\ |  | |  |  |	| |  |       |  |       /  __  \\   |___    | |   __   |    |  |       |  |       |  |\n"
                + "|  |  \\  \\|  | |  |__|	| |  |_____  |  |      /  /  \\  \\   ___|   | |  |  |  |    |  |_____  |  |_____  |  |\n"
                + "|__|   \\_____| |________| |________| |__|     /__/    \\__\\ |_______| |__|  |__|    |________| |________| |__|");

        System.out.println("\nOBS: Essa aplicação fará a captura dos dados da sua máquina\n"
                + "para assim você poder ter acesso aos seus dados no dashboard do nosso site.");
        System.out.println("\n| Realize seu login para continuar |\n");

        while (true) {
            System.out.println("Digite seu email: ");
            String email = scanner.next();
            System.out.println("\nDigite sua senha: ");
            String senha = scanner.next();

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                try ( Connection con = DriverManager.getConnection(
                        "jdbc:sqlserver://nocrash.database.windows.net:1433;database=nocrash;"
                        + "encrypt=true;trustServerCertificate=false", "nocrash", "#Gfgrupo4")) {
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(sql.selectEmailSenha(email, senha));

                    if (rs.next()) {
                        System.out.println("\n| Bem vindo ao NoCrash |");
                        System.out.println("\nDigite o token da sua desktop: ");
                        String token = scanner.next();
                        ResultSet rsToken = stm.executeQuery(sql.selectDesktop(token));

                        if (rsToken.next()) {
                            ResultSet verificarHardware = stm.executeQuery(sql.selectHardware(token));

                            if (!verificarHardware.next()) {
                                stm.execute(sql.insertHardware(token));
                            } else {
                                stm.execute(sql.updateHardware(token));
                            }
                            System.out.println("\nTudo certo! vamos capturar os dados da sua desktop agora...\n\n");

                            try {
                                DatabaseMySql db = new DatabaseMySql();
                                try {
                                    db.insertHardware(token);
                                } catch (Exception ex) {
                                    try {
                                        db.updateHardware(token);
                                    } catch (Exception e) {
                                    }
                                }
                                try {
                                    Timer timer = new Timer("Insert Dados");
                                    timer.schedule(new DadoTask(token), 1_000, 9_000);
                                    timer.schedule(new DadoTaskMySql(token), 1_000, 10_000);

                                } catch (Exception e) {
                                    System.out.println("\n| Erro ao Inserir os dados no bd mysql |"
                                            + "- Verifique a conexão\n");
                                }
                                try {
                                    Timer timer = new Timer("Insert Disco");
                                    timer.schedule(new DiscoTaskMySql(token), 1_000, 10_000);
                                    timer.schedule(new DiscoTask(token), 1_000, 10_000);

                                } catch (Exception ex) {

                                    System.out.println("\n| Erro ao Inserir os dados do disco no bd mysql "
                                            + "- Verifique a conexão |\n");

                                }
                            } catch (SQLException e) {
                                System.out.println("\n| Erro ao conectar com o MySql |\n");
                            }
                        } else {
                            System.out.println("\nToken inválido!\n");
                        }
                    } else {
                        System.out.println("\nNome ou senha incorretos!\n");
                    }
                }
            } catch (ClassNotFoundException | SQLException e) {
                if (email.isEmpty() || senha.isEmpty()) {
                    System.out.println("\nPreencha todos os campos!");
                } else {
                    System.out.println("\n| Ocorreu algum erro por aqui! |\n");
                }
            }
        }
    }
}
