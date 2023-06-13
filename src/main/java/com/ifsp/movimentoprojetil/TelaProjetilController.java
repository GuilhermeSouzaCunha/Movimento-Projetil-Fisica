/*
 *  nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 *  nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java
 */
package com.ifsp.movimentoprojetil;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Guilherme
 */
public class TelaProjetilController implements Initializable {
    
    private double y, x, time, vyf, vxf, moduloVelocidade;
    private Stage primaryStage;
    
    @FXML
    private TextField inputDiametro, inputAlturaInicial, inputAceleracaoQueda, inputVelocidadeInicial, inputAngulo, inputMassa;
    @FXML
    private Button btStar, btReset;
    @FXML
    private Label lbResul1, lbResul2, lbDuracao, lbResul3, lbResul4;
    @FXML
    private RadioButton rButtonPosicao, rButtonVelocidade;
    @FXML
    private Label lbD1, lbD2, lbD3, lbD4, lbE1, lbE2, lbE3, lbE4;
    @FXML
    private Circle circulo;
    
    Projetil p = new Projetil();
    Trajetoria t = new Trajetoria();
    TempoTrajetoria tt = new TempoTrajetoria();
    
    public void calcular(ActionEvent event) throws InterruptedException {
        
        t.setVelocidade(Double.parseDouble(inputVelocidadeInicial.getText()));
        t.setAngulo(Double.parseDouble(inputAngulo.getText()));
        t.setAceleracao(Double.parseDouble(inputAceleracaoQueda.getText()));
        t.setAltura(Double.parseDouble(inputAlturaInicial.getText()));
        t.setDiametro(Double.parseDouble(inputDiametro.getText()));
        t.setMassa(Double.parseDouble(inputMassa.getText()));
        
        lbResul2.setText(String.format("%.2f", t.alturaMaxima()));
        lbResul1.setText(String.format("%.2f", t.alcance()));
        
        time = 0;
        Thread thread = new Thread(() -> {
        y = t.getAltura();
        while (y >= 0) {
            double anguloRadianos = t.getAngulo() * (Math.PI/180);
            x = t.getVelocidade() * Math.cos(Math.toRadians(t.getAngulo())) * time;
            y = t.getAltura() + t.getVelocidade() * Math.sin(Math.toRadians(t.getAngulo())) * time - 0.5 * t.getAceleracao() * Math.pow(time, 2);
            vyf = t.getVelocidade() * Math.sin(anguloRadianos) - (t.getAceleracao() * time);
            vxf = t.getVelocidade() * Math.cos(anguloRadianos);
            moduloVelocidade = Math.sqrt(Math.pow(vxf, 2) + Math.pow(vyf, 2));
            
            Platform.runLater(() -> lbDuracao.setText(String.format("%.2f", time)));
            Platform.runLater(() -> lbResul3.setText(String.format("%.2f", x)));
            Platform.runLater(() -> lbResul4.setText(String.format("%.2f", y)));
            time += 0.01; 
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        });
        thread.start();
 
        //circulo.setRadius(t.getDiametro());
        Path path = new Path();
        path.getElements().add(new MoveTo(0, -(5 * t.getAltura())));
        path.getElements().add(new CubicCurveTo(0, -100, 100, -100, 200, 0));
        double distance = 300;
        double duration = distance / 30;

        PathTransition transition = new PathTransition(Duration.seconds(duration), path, circulo);
        transition.setCycleCount(1);

        transition.play();
    }
    
    public void getResul(ActionEvent event) {
        if(rButtonPosicao.isSelected()) {
            lbD1.setText("Alcance horizontal:");
            lbD2.setText("Altura máxima:");
            lbD3.setText("X (horizontal):");
            lbD4.setVisible(true);
            
            lbE1.setText("m");
            lbE2.setText("m");
            lbE3.setText("m");
            lbE4.setVisible(true);
            
            lbResul1.setText(String.format("%.2f", t.alcance()));
            lbResul2.setText(String.format("%.2f", t.alturaMaxima()));
            lbResul3.setText(String.format("%.2f", x));
            lbResul4.setVisible(true);
        } else if (rButtonVelocidade.isSelected()) {
            lbD1.setText("Vy (vertical):");
            lbD2.setText("Vx (horizontal):");
            lbD3.setText("Módulo da velocidade:");
            lbD4.setVisible(false);
            
            lbE1.setText("m/s");
            lbE2.setText("m/s");
            lbE3.setText("m/s");
            lbE4.setVisible(false);
            
            lbResul1.setText(String.format("%.2f", vyf));
            lbResul2.setText(String.format("%.2f", vxf));
            lbResul3.setText(String.format("%.2f", moduloVelocidade));
            lbResul4.setVisible(false);
        }
    }
    
    public void reset(ActionEvent event) throws InterruptedException {
        // Limpar o conteúdo do TextField
        lbResul1.setText("");
        lbResul2.setText("");
        lbResul3.setText("");
        lbResul4.setText("");
        lbDuracao.setText("");
        
        // Limpar o conteúdo do Label
        inputVelocidadeInicial.setText("");
        inputAceleracaoQueda.setText("");
        inputAlturaInicial.setText("");
        inputAngulo.setText("");
        inputDiametro.setText("");
        inputMassa.setText("");
        
        // Reiniciar a simulação chamando o método calcular(ActionEvent event)
        calcular(event);

        // Fechar a instância anterior da aplicação
        primaryStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
