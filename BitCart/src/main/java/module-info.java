module BitCart {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens com.jmc.bitcart to javafx.fxml;
    exports com.jmc.bitcart;
    exports com.jmc.bitcart.Controllers;
    exports com.jmc.bitcart.Controllers.Admin;
    exports com.jmc.bitcart.Controllers.Client;
    exports com.jmc.bitcart.Models;
    exports com.jmc.bitcart.Views;

}