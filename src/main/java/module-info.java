module com.example.hibernatelayered {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.hibernatelayered to javafx.fxml;
    exports com.example.hibernatelayered;
}