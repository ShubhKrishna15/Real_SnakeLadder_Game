module com.example.real_snake_ladder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.real_snake_ladder to javafx.fxml;
    exports com.example.real_snake_ladder;
}