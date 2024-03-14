module org.example.tipcalc {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tipcalc to javafx.fxml;
    exports org.example.tipcalc;
}