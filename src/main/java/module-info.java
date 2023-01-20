module com.example.sevenwonders {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires com.google.common;
    requires lombok;


    opens com.example.sevenwonders to javafx.fxml;
    exports com.example.sevenwonders;
    exports com.example.sevenwonders.Cards;
    opens com.example.sevenwonders.Cards to javafx.fxml;
}