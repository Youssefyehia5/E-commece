module BitCart {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    requires java.desktop;

    opens com.jmc.bitcart to javafx.fxml;
    exports com.jmc.bitcart;
    exports com.jmc.bitcart.Controllers;
    exports com.jmc.bitcart.Controllers.Admin;
    exports com.jmc.bitcart.Controllers.Client;
    exports com.jmc.bitcart.Models;
    exports com.jmc.bitcart.Views;
    opens com.jmc.bitcart.Models to javafx.fxml;

}