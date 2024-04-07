module rw.app.project {
    requires javafx.controls;
    requires javafx.fxml;


    opens rw.app.project to javafx.fxml;
    exports rw.app.project;
}