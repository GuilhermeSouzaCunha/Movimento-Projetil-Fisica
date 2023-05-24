module com.ifsp.movimentoprojetil {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.ifsp.movimentoprojetil to javafx.fxml;
    exports com.ifsp.movimentoprojetil;
}
