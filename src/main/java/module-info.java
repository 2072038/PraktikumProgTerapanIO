module com.pterapan.demoio {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pterapan.demoio to javafx.fxml;
    exports com.pterapan.demoio;
}