module Almacen {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires kernel;
    requires layout;
    exports model;
    exports controller;
    exports main;
    opens controller;
}