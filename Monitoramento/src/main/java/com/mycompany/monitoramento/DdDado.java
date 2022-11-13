package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;

public class DdDado {

    Looca looca = new Looca();

    private Long emUso = looca.getMemoria().getDisponivel();
    private Integer qtdDisco = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();
    private Double usop = looca.getProcessador().getUso();
    private String idMaquina = looca.getProcessador().getId();

    public Long getEmUso() {
        return emUso;
    }

    public void setEmUso(Long emUso) {
        this.emUso = emUso;
    }

    public Integer getQtdDisco() {
        return qtdDisco;
    }

    public void setQtdDisco(Integer qtdDisco) {
        this.qtdDisco = qtdDisco;
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
