module com.example.elaborazione_csv {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.elaborazione_csv to javafx.fxml;
    exports com.example.elaborazione_csv;
}