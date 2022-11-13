package com.mycompany.monitoramento;

public class SqlCommands {

    DbDadosHardware database = new DbDadosHardware();
    StringBuilder sb = new StringBuilder();
    DbMostrarDadoDisco dado = new DbMostrarDadoDisco();
    DbMostrarDado mdado = new DbMostrarDado();

    public String insertHardware(String token) {
        return "INSERT INTO Hardware(idHardware ,nomeProcessador, "
                + "fabricante, frequencia, memoriaTotal, qntDisco, fkDesktop)  VALUES ('"
                + database.getIdMaquina() + "','" + database.getNomeProcessador() + "','"
                + database.getFabricante() + "','" + database.getFrequencia() + "','"
                + database.getMemoriaTotal() + "','" + database.getQntDisco() + "','" + " " + token + "')";
    }

    public String updateHardware(String token) {
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
        sb.append("SELECT * FROM Hardware where fkDesktop = ' ").append(token).append("';");

        return sb.toString();
    }

    public String insertDisco() {
        sb.append("INSERT INTO Disco (modelo, serial,bytesExcrita, bytesLeitura,escritas,leituras,");
        sb.append("tamanho, tamanhoAtualFila, tempoTransferencia,  fkHardware) VALUES ('");
        sb.append(dado.getModelo()).append("','").append(dado.getSerial()).append("',");
        sb.append(dado.getBytesEscrita()).append(",").append(dado.getBytesLeitura()).append(",");
        sb.append(dado.getEscritas()).append(",").append(dado.getLeituras()).append(",");
        sb.append(dado.getTamanho()).append(",").append(dado.getTamanhoAtualFila()).append(",");
        sb.append(dado.getTempoTransferencia()).append(",").append(mdado.getIdMaquina()).append(");");
        
        return sb.toString();
    }
    
    public String selectDesktop(String token) {
    return "SELECT idDesktop FROM Desktop WHERE idDesktop = '" + " " + token + "'";
    }
    
    public String selectEmailSenha(String email, String senha) {
        return "select emailUsuario, senha from Usuario where emailUsuario='" + email + "' and senha ='" + senha + "'";
    }
    
    public String selectNome(String email, String senha) {
        return "SELECT nomeUsuario WHERE emailUsuario='" + email + "' and senha ='" + senha + "'";
    }
    
    public String insertDados() {
        return "INSERT INTO Dado (memoriaDisponivel , usoProcessador, fkHardware) "
                    + "VALUES ('" + mdado.getEmUso() + "','" + mdado.getUsop() + "','" + mdado.getIdMaquina() + "')";
    }
}
