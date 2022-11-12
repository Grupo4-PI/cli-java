package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;

public class Database {

    Looca looca = new Looca();

    private String idMaquina = looca.getProcessador().getId();
    String nomeProcessador = looca.getProcessador().getNome();
    private String fabricante = looca.getProcessador().getFabricante();
    private Long frequencia = looca.getProcessador().getFrequencia();
    private Long memoriaTotal = looca.getMemoria().getTotal();
    private Integer qntDisco = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();

    public Looca getLooca() {
        return looca;
    }

    public void setLooca(Looca looca) {
        this.looca = looca;
    }

    public String getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(String idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNomeProcessador() {
        return nomeProcessador;
    }

    public void setNomeProcessador(String nomeProcessador) {
        this.nomeProcessador = nomeProcessador;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Long getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Long frequencia) {
        this.frequencia = frequencia;
    }

    public Long getMemoriaTotal() {
        return memoriaTotal;
    }

    public void setMemoriaTotal(Long memoriaTotal) {
        this.memoriaTotal = memoriaTotal;
    }

    public Integer getQntDisco() {
        return qntDisco;
    }

    public void setQntDisco(Integer qntDisco) {
        this.qntDisco = qntDisco;
    }
}
