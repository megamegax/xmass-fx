module app {
    exports com.hunyadym;

    requires java.logging;
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires kotlin.stdlib;
    opens com.hunyadym.controllers;
}