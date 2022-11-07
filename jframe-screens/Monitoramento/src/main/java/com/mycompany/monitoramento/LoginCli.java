/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoramento;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class LoginCli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer i = 0;
        Database database = new Database();
        while(i < 1){
      
            
            System.out.println("Digite seu email: ");
            String email = scanner.next();
            System.out.println("Digite a senha: ");
            String senha = scanner.next();
            
            
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://nocrash.database.windows.net:1433;database=nocrash;encrypt=true;trustServerCertificate=false", "nocrash", "#Gfgrupo4");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(
                    "select emailUsuario, senha from Usuario where emailUsuario='" + email + "' and senha ='" + senha + "'");

            if (rs.next()) {
                System.out.println("Bem vindo! " + email);
                 System.out.println("\nDigite seu token: ");
                 String token = scanner.next();
                 
                     ResultSet rsToken = stm.executeQuery(
                    "select idDesktop from Desktop where idDesktop = '" + " " + token + "'");

            if (rsToken.next()) {
               
                MostrarDado page = new MostrarDado();
               
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
                    System.out.println("Foi insert");
                } else {
                    sb.append("UPDATE Hardware SET");
                    sb.append(" nomeProcessador = '").append(database.getNomeProcessador()).append("'");
                    sb.append(", fabricante = '").append(database.getFabricante()).append("'");
                    sb.append(", frequencia = ").append(database.getFrequencia());
                    sb.append(", memoriaTotal = ").append(database.getMemoriaTotal());
                    sb.append(", qntDisco = ").append(database.getQntDisco());
                    sb.append(" WHERE fkDesktop = ' ").append(token).append("';");

                    sqlInsert = sb.toString();
                    System.out.println("Foi update");
                }
                stm.execute(sqlInsert);
                
                
                
            } else {
                System.out.println("Token invalido");
               
            }
         
               
            } else {
                System.out.println("nome ou senha incorretas");
               
            }
            con.close();
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            if (email.length() == 0 || senha.length() == 0) {
                System.out.println("Preencha todos os campos");
            } else {
                System.out.println("Nome ou senha incorretas");
              
            }
        }
            
        }
    }
}
