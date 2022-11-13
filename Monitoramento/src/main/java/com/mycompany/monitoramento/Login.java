package com.mycompany.monitoramento;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
        System.out.println("\n|Realize seu login para continuar|\n");

        while (true) {
            System.out.println("Digite seu email: ");
            String email = scanner.next();
            System.out.println("Digite a senha: ");
            String senha = scanner.next();

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection(
                        "jdbc:sqlserver://nocrash.database.windows.net:1433;database=nocrash;"
                        + "encrypt=true;trustServerCertificate=false", "nocrash", "#Gfgrupo4");

                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql.selectEmailSenha(email, senha));

                if (rs.next()) {
                    System.out.println("Bem vindo!"
                            + stm.executeQuery(sql.selectNome(email, senha)).getCursorName());
                    System.out.println("\nDigite seu token: ");
                    String token = scanner.next();
                    ResultSet rsToken = stm.executeQuery(sql.selectDesktop(token));

                    if (rsToken.next()) {
                        ResultSet verificarHardware = stm.executeQuery(sql.selectHardware(token));
                        if (!verificarHardware.next()) {
                            stm.execute(sql.insertHardware(token));
                            System.out.println("Foi Insert");
                        } else {
                            stm.execute(sql.insertHardware(token));
                            System.out.println("Foi Update");
                        }

                        System.out.println("Tudo certo! vamos capturar os dados da sua desktop agora...");
                        stm.execute(sql.insertDisco());
                        stm.execute(sql.insertDados());
                        try {
                            DatabaseMySql db = new DatabaseMySql();
                            db.inserirDados();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Token inválido!");
                    }
                } else {
                    System.out.println("Nome ou senha incorretos!");
                }
                con.close();
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                if (email.isEmpty() || senha.isEmpty()) {
                    System.out.println("Preencha todos os campos!");
                } else {
                    System.out.println("Nome ou senha incorreto!");
                }
            }
        }
    }
}
