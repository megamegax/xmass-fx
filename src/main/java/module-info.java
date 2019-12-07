module com.hunyadym {
    exports com.hunyadym;
    exports com.hunyadym.controllers;

    requires java.logging;
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    opens com.hunyadym.controllers;
}