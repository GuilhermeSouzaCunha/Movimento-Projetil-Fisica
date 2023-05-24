package com.ifsp.movimentoprojetil;

import java.lang.Math;

public class Trajetoria extends Projetil{
    
    public Trajetoria () {
        
    }
    
    public Trajetoria(double altura, double angulo, double velocidade, double massa, double aceleracao) {
        super(altura, angulo, velocidade, massa, aceleracao);
    }
    
    public double velocidadeHorizontal() {
        return super.getVelocidade() * Math.cos(super.getAngulo());
    }
    
    public double velocidadeVertical() {
        return super.getVelocidade() * Math.sin(Math.tan(super.getAngulo()));
    }
    
    public double alturaMaxima() {
        return (super.getAltura() + (super.getVelocidade() * velocidadeVertical())) / (2 * super.getAceleracao()); 
    }
    
    public double tempoAlturaMaxima() {
        return velocidadeHorizontal() / super.getAceleracao();
    }
    
    public double tempoTotalVoo() {
        return 2 * velocidadeVertical() / super.getAceleracao();
    }
    
    public double alcance() {
        return velocidadeHorizontal() * tempoTotalVoo();
    }
    
    
    
}
