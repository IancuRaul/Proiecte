module com.example.tema_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tema_1 to javafx.fxml;
    exports com.example.tema_1;
}