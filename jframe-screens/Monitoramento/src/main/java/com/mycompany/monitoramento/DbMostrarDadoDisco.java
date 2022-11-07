package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;

public class DbMostrarDadoDisco {

    Looca looca = new Looca();

    private Disco disco = (Disco) looca.getGrupoDeDiscos().getDiscos();
    private String modelo = disco.getModelo();
    private String serial = disco.getSerial();
    private Long bytesEscrita = disco.getBytesDeEscritas() / 10000;
    private Long bytesLeitura = disco.getBytesDeLeitura() / 10000;
    private Long escritas = disco.getEscritas() / 10000;
    private Long leituras = disco.getLeituras() / 10000;
    private Long tamanho = disco.getTamanho() / 1000000000;
    private Long tamanhoAtualFila = disco.getTamanhoAtualDaFila();
    private Long tempoTransferencia = disco.getTempoDeTransferencia() / 1000;

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;

    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Long getBytesEscrita() {
        return bytesEscrita;
    }

    public void setBytesEscrita(Long bytesEscrita) {
        this.bytesEscrita = bytesEscrita;
    }

    public Long getBytesLeitura() {
        return bytesLeitura;
    }

    public void setBytesLeitura(Long bytesLeitura) {
        this.bytesLeitura = bytesLeitura;
    }

    public Long getEscritas() {
        return escritas;
    }

    public void setEscritas(Long escritas) {
        this.escritas = escritas;
    }

    public Long getLeituras() {
        return leituras;
    }

    public void setLeituras(Long leituras) {
        this.leituras = leituras;
    }

    public Long getTamanho() {
        return tamanho;
    }

    public void setTamanho(Long tamanho) {
        this.tamanho = tamanho;
    }

    public Long getTamanhoAtualFila() {
        return tamanhoAtualFila;
    }

    public void setTamanhoAtualFila(Long tamanhoAtualFila) {
        this.tamanhoAtualFila = tamanhoAtualFila;
    }

    public Long getTempoTransferencia() {
        return tempoTransferencia;
    }

    public void setTempoTransferencia(Long tempoTransferencia) {
        this.tempoTransferencia = tempoTransferencia;
    }
}
