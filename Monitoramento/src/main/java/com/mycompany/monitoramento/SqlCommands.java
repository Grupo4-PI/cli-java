package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;

public class SqlCommands {

    DbHardware database = new DbHardware();
    DdDado mdado = new DdDado();
    Looca looca = new Looca();

    public String insertHardware(String token) {
        return "INSERT INTO Hardware(idHardware ,nomeProcessador, "
                + "fabricante, frequencia, memoriaTotal, qntDisco, fkDesktop)  VALUES ('"
                + database.getIdMaquina() + "','" + database.getNomeProcessador() + "','"
                + database.getFabricante() + "','" + database.getFrequencia() + "','"
                + database.getMemoriaTotal() + "','" + database.getQntDisco() + "','" + " " + token + "');";
    }

    public String updateHardware(String token) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE Hardware SET");
        sb.append(" nomeProcessador = '").append(database.getNomeProcessador()).append("'");
        sb.append(", fabricante = '").append(database.getFabricante()).append("'");
        sb.append(", frequencia = ").append(database.getFrequencia());
        sb.append(", memoriaTotal = ").append(database.getMemoriaTotal());
        sb.append(", qntDisco = ").append(database.getQntDisco());
        sb.append(" WHERE fkDesktop = ' ").append(token).append("';");

        return sb.toString();
    }

    public String selectHardware(String token) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM Hardware where fkDesktop = ' ").append(token).append("';");

        return sb.toString();
    }

    public String insertDisco(Integer indice) {
        StringBuilder sb = new StringBuilder();
        Disco disco = looca.getGrupoDeDiscos().getDiscos().get(indice);
        sb.append("INSERT INTO Disco (modelo, serial,bytesEscrita, bytesLeitura,escritas,leituras,");
        sb.append("tamanho, tamanhoAtualFila, tempoTransferencia,  fkHardware) VALUES ('");
        sb.append(disco.getModelo()).append("','").append(disco.getSerial()).append("',");
        sb.append(disco.getBytesDeEscritas() / 1024 / 1024 / 1024).append(",");
        sb.append(disco.getBytesDeLeitura() / 1024 / 1024 / 1024).append(",");
        sb.append(disco.getEscritas() / 1024 / 1024 / 1024).append(",");
        sb.append(disco.getLeituras() / 1024 / 1024 / 1024).append(",");
        sb.append(disco.getTamanho() / 1000000000).append(",");
        sb.append(disco.getTamanhoAtualDaFila()).append(",");
        sb.append(disco.getTempoDeTransferencia() / 1024).append(",'").append(mdado.getIdMaquina()).append("');");

        return sb.toString();
    }

    public String updateDisco(Integer indice) {
        StringBuilder sb = new StringBuilder();
        Disco disco = looca.getGrupoDeDiscos().getDiscos().get(indice);
        sb.append("UPDATE Disco SET modelo = '").append(disco.getModelo()).append("',");
        sb.append("bytesEscrita =").append(disco.getBytesDeEscritas() / 1024 / 1024 / 1024).append(",");
        sb.append("bytesLeitura =").append(disco.getBytesDeLeitura() / 1024 / 1024 / 1024).append(",");
        sb.append("escritas =").append(disco.getEscritas() / 1024 / 1024 / 1024).append(",");
        sb.append("leituras =").append(disco.getLeituras()).append(",");
        sb.append("tamanho =").append(disco.getTamanho() / 1000000000).append(",");
        sb.append("tamanhoAtualFila =").append(disco.getTamanhoAtualDaFila()).append(",");
        sb.append("tempoTransferencia =").append(disco.getTempoDeTransferencia() / 1024);
        sb.append(" WHERE serial = '").append(disco.getSerial()).append("';");

        return sb.toString();
    }

    public String selectDesktop(String token) {
        return "SELECT idDesktop FROM Desktop WHERE idDesktop = '" + " " + token + "';";
    }

    public String selectEmailSenha(String email, String senha) {
        return "SELECT emailUsuario, senha FROM Usuario WHERE emailUsuario='" + email + "' and senha ='" + senha + "';";
    }

    public String selectNome(String email, String senha) {
        return "SELECT nomeUsuario WHERE emailUsuario='" + email + "' and senha ='" + senha + "';";
    }

    public String insertDados() {
        return "INSERT INTO Dado (memoriaDisponivel , usoProcessador, fkHardware) "
                + "VALUES ('" + mdado.getEmUso() + "','" + mdado.getUsop() + "','" + mdado.getIdMaquina() + "');";
    }
}
