package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;

public class DbMostrarDado {

    Looca looca = new Looca();

    private Long emUso = looca.getMemoria().getDisponivel();
    private Integer qtdDiscoJ = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();
    private Double usop = looca.getProcessador().getUso();
    private String idMaquina = looca.getProcessador().getId();

    public Long getEmUso() {
        return emUso;
    }

    public void setEmUso(Long emUso) {
        this.emUso = emUso;
    }

    public Integer getQtdDiscoJ() {
        return qtdDiscoJ;
    }

    public void setQtdDiscoJ(Integer qtdDiscoJ) {
        this.qtdDiscoJ = qtdDiscoJ;
    }

    public Double getUsop() {
        return usop;
    }

    public void setUsop(Double usop) {
        this.usop = usop;
    }

    public String getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(String idMaquina) {
        this.idMaquina = idMaquina;
    }
}
