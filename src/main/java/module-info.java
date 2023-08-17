module Almacen {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    exports model;
    exports controller;
    exports main;
    opens controller;
}