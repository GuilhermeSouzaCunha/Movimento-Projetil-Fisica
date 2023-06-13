package com.ifsp.movimentoprojetil;

import java.lang.Math;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.AnimationTimer;

public class Trajetoria extends Projetil{
    
    public Trajetoria () {
    }
    
    public Trajetoria(double altura, double angulo, double velocidade, double massa, double aceleracao, double diametro) {
        super(altura, angulo, velocidade, massa, aceleracao, diametro);
    }
    
    public double velocidadeHorizontal() {
        double anguloRadianos = super.getAngulo() * (Math.PI/180);
        return super.getVelocidade() * Math.cos(anguloRadianos);
    }
    
    public double velocidadeVertical() {
        double anguloRadianos = super.getAngulo() * (Math.PI/180);
        return super.getVelocidade() * Math.sin(anguloRadianos);
    }
    
    public double alturaMaxima() {
        double anguloRadianos = super.getAngulo() * (Math.PI/180);
        return Math.pow((super.getVelocidade() * Math.sin(anguloRadianos)), 2) / (2 * super.getAceleracao()); 
    }
    
    public double alcance() {
        double anguloRadianos = super.getAngulo() * (Math.PI/180);
        return (Math.pow(super.getVelocidade(), 2) * Math.sin(anguloRadianos*2)) / super.getAceleracao(); 
    }
    
    public double tempoAlturaMaxima() {
        return velocidadeHorizontal() / super.getAceleracao();
    }
 
    public double tempoTotalVoo() {
        return (2 * super.getVelocidade() * Math.sin(Math.toRadians(super.getAngulo()))) / super.getAceleracao();
    }
    
    public double areaSecaoTransversal() {
        return Math.PI * Math.pow(super.getDiametro(), 2);
    }
    
    public double densidadeAr() {
        return (1013.25 / (8.314 * 288.15));
    }
    
}
