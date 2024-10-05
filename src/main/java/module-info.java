module name.ulbricht.javafx {

    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports name.ulbricht.javafx;
    exports name.ulbricht.javafx.ui.img;

    exports name.ulbricht.javafx.ui to javafx.fxml;

    opens name.ulbricht.javafx.ui to javafx.fxml;
    opens name.ulbricht.javafx.ui.img;
}
