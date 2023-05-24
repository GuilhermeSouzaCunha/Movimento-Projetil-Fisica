/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ifsp.movimentoprojetil;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author samsung
 */
public class TelaProjetilController implements Initializable {

    @FXML
    private TextField inputDiametro;
    @FXML
    private TextField inputAlturaInicial;
    @FXML
    private TextField inputAceleracaoQueda;
    @FXML
    private TextField inputVelocidadeInicial;
    @FXML
    private TextField inputAngulo;
    @FXML
    private TextField inputMassa;
    @FXML
    private ComboBox<?> boxObjProjetil;
    @FXML
    private Button btReset;
    @FXML
    private Button btStar;
    @FXML
    private Button btSalvar;
    @FXML
    private Label lbPosicaoX;
    @FXML
    private Label lbPosicaoY;

    Projetil p = new Projetil();
    Trajetoria t = new Trajetoria();
    
    public void calcular (ActionEvent event) {
        t.setVelocidade(Double.parseDouble(inputVelocidadeInicial.getText()));
        t.setAngulo(Double.parseDouble(inputAngulo.getText()));
        System.out.println(t.velocidadeHorizontal());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
