package com.jmc.bitcart.Controllers.Client;

import com.jmc.bitcart.Models.Product;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.awt.*;

public class ItemsController {
    @FXML
    private HBox box;

    @FXML
    private ImageView productImage;

    @FXML
    private Label productName;

    @FXML
    private Label sellerName;

    private String [] colors = {"B9E5FF","BDB2FE","FB9AA8","FF5056"};

    public void setData(Product product) {
        Image image = new Image(getClass().getResourceAsStream(product.getImageSrc()));
        productImage.setImage(image);

        productName.setText(product.getName());
        sellerName.setText(product.getSeller());
        box.setStyle("-fx-background-color: "+ Color.web(colors[(int)(Math.random()*colors.length)])+";" +
                "-fx-background-radius: 15;" +
                "-fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 10);");

    }

}
