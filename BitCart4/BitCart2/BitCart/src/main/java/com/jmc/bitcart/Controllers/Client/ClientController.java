package com.jmc.bitcart.Controllers.Client;

import com.jmc.bitcart.Models.Order;
import com.jmc.bitcart.Models.Product;
import com.jmc.bitcart.Models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ClientController{


private Product product;
    private List<Product> products;
    public VBox iphone15Pro;
    public VBox lenovoLoqBox;
    public VBox playStation5Box;
    public VBox nvidiaRtx4090Box;
    public VBox samsungS24Box;
    public VBox samsungTvQledBox;
    public VBox samsungWasher7LBox;
    public VBox viaomiRedmiA3Box;
    public VBox arieteHeaterBox;
    public VBox oraimoFreebudsBox;
    public VBox samsungRefrigeratorBox;
    public VBox xiaomiMiBox;
    public VBox panasonicCoolerBox;
    public VBox tornadoHandBlenderBox;
    public VBox sharpAirFryerBox;
    public VBox galaxyA55Box;
    public VBox redmiWatch3Box;
    public VBox lgTvBox;
    public VBox samsungMicrowaveBox;
    public VBox coffeMachineBox;
    public VBox gShapeBox;
    public VBox iphone15Pro1;
    public VBox lenovoLoqBox1;
    public VBox playStation5Box1;
    public VBox nvidiaRtx4090Box1;
    public VBox samsungS24Box1;

    public Label userName;
    public VBox description;
    public Label desclabel;
    public VBox samsungTvQledBox1;
    public BorderPane borderPane;
private User user;
 private Order order;


    public ClientController() {
    }
    public void setUser(User user){
       this.user = user;
       userName.setText(user.getName());
if(this.order==null)
    order = new Order();

    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setOrder(Order order){
        this.order = order;
}


    private VBox cloneVBox(VBox original) {
        VBox clonedBox = new VBox();

        // Copy VBox properties
        clonedBox.setSpacing(original.getSpacing());
        clonedBox.setAlignment(original.getAlignment());
        clonedBox.setPadding(original.getPadding());
        clonedBox.setStyle(original.getStyle());
        clonedBox.getStyleClass().addAll(original.getStyleClass());
        clonedBox.setPrefSize(400, 400);


        // Clone child nodes
        for (javafx.scene.Node child : original.getChildren()) {
            if (child instanceof Label) {
                // Clone Label
                Label originalLabel = (Label) child;
                Label clonedLabel = new Label(originalLabel.getText());

                // Set size of the Label to 300x300
                clonedLabel.setPrefSize(300, 300);

                // Copy other properties
                clonedLabel.setFont(originalLabel.getFont());
                clonedLabel.setStyle(originalLabel.getStyle());
                clonedLabel.getStyleClass().addAll(originalLabel.getStyleClass());

                clonedBox.getChildren().add(clonedLabel);

            } else if (child instanceof javafx.scene.image.ImageView) {
                // Clone ImageView
                javafx.scene.image.ImageView originalImageView = (javafx.scene.image.ImageView) child;
                javafx.scene.image.ImageView clonedImageView = new javafx.scene.image.ImageView(originalImageView.getImage());

                // Set size of the ImageView to 300x300
                clonedImageView.setFitWidth(300);
                clonedImageView.setFitHeight(300);

                // Maintain original properties
                clonedImageView.setPreserveRatio(false); // Allow stretching to fit 300x300
                clonedImageView.setStyle(originalImageView.getStyle());
                clonedImageView.getStyleClass().addAll(originalImageView.getStyleClass());

                clonedBox.getChildren().add(clonedImageView);

            } else if (child instanceof VBox) {
                // Clone nested VBox
                VBox nestedClone = cloneVBox((VBox) child);
                clonedBox.getChildren().add(nestedClone);

            } else {
                System.out.println("Unsupported child type: " + child.getClass().getSimpleName());
            }
        }

        return clonedBox;
    }






    public void handleBoxClick(javafx.scene.input.MouseEvent event) throws Exception {
        // Step 1: Identify the source VBox that triggered the event
        VBox originalBox = (VBox) event.getSource();

        // Step 2: Clone the VBox
        VBox clonedBox = cloneVBox(originalBox);

        // Step 3: Load the Product.fxml and its controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Client/Product.fxml"));
        Parent root = loader.load();
System.out.println(originalBox.getId());
        // Step 4: Pass the cloned VBox to the ProductController
        ProductController productController = loader.getController();
        productController.setPName(originalBox.getId());
        productController.setProductBox(clonedBox);
        if (this.order == null) {
            this.order = new Order();} // Initialize the order if it is null
        productController.initializeOrder(this.order);
        productController.setUserName(userName.getText());
        productController.setPName(originalBox.getId());
        productController.setIsAvailable(originalBox.getId());
        productController.setUserName(user.getName());



        // Step 5: Open a new stage for the Product view
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

}


}

