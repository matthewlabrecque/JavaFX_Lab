module com.example.lab14_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab14_javafx to javafx.fxml;
    exports com.example.lab14_javafx;
}