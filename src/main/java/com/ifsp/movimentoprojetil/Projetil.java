package com.ifsp.movimentoprojetil;

import java.lang.Math;

public class Projetil {
    
    private double altura;
    private double angulo;
    private double velocidade;
    private double massa;
    private double aceleracao;
    
    public Projetil() {
        
    }
    
    public Projetil(double altura, double angulo, double velocidade, double massa, double aceleracao) {
        this.k(1);
        this.altura = altura;
        this.angulo = angulo;
        this.velocidade = velocidade;
        this.massa = massa;
        this.aceleracao = aceleracao;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
    
    public double getAngulo() {
        return angulo;
    }
    
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
    
    public double getVelocidade() {
        return velocidade;
    }
    
    public void setMassa(double massa) {
        this.massa = massa;
    }
    
    public double getMassa() {
        return massa;
    }
    
    public void setAceleracao(double aceleracao) {
        this.aceleracao = aceleracao;
    }
    
    public double getAceleracao() {
        return aceleracao;
    }
    
    public double k(double raio) {
        return (3.0 * (1.8 * Math.pow(10, -5))) / (4.0 * raio * 1.2);
    }
    
}
