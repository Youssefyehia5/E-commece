package com.jmc.bitcart.Controllers.Client;

import com.jmc.bitcart.DatabaseManger;
import com.jmc.bitcart.Models.Order;
import com.jmc.bitcart.Models.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductController {

    @FXML
    public VBox productBox;
    public Label descriptionLabel;
    public Label userName;
    public Label pNameLbl;
    public Label isAvailableLbl;
    public Label pPriceLbl;
    public Button remove;
    public Label quantatiy;
    public Button add;
    public Button placeorder;
private Order order;
private Product product;

public void initializeOrder(Order order) {
    this.order = order;

}


    // Method to set the cloned VBox
    public void setProductBox(VBox clonedBox) {
        productBox.getChildren().add(clonedBox);
     quantatiy.setText("1");
    }
    public  void setUserName(String userName) {
        this.userName.setText(userName);

    }
    public void setPName(String pName) throws Exception {
       this.pNameLbl.setText("Name:"+pName);

    }
    public void setIsAvailable(String pName) throws Exception {

        try {
            Connection con= DatabaseManger.getConnection();
            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM  product");


            boolean isValid=false;
            while (resultSet.next()) {

                String CheckPname=  resultSet.getString("name");


                if(CheckPname.equalsIgnoreCase(pName) ) {

                   double price =resultSet.getDouble("price");
                  int stock =resultSet.getInt("stock");
                    pPriceLbl.setText("Price:"+price+"$");
                    String description="description: "+resultSet.getString("description");
                    String formattedText = insertNewlines(description, 35);
                    descriptionLabel.setText(formattedText);
                    product=new Product();
                    product.setName(pName);
                    product.setPrice(price);
                    product.setDescription(description);
                    product.setId(resultSet.getInt("product_id"));

//                    order.products.add(new Product(resultSet.getString("name"),price,description));
// intilize products
                    if (stock>0){
isAvailableLbl.setText(" In Stock: "+stock+" item");
isAvailableLbl.setStyle("-fx-text-fill: green;");
                    } else {
                        isAvailableLbl.setText(" Not In Stock: ");
                        isAvailableLbl.setStyle("-fx-text-fill: red;");
                    }


                }


            }} catch (Exception e) {
            throw new RuntimeException(e);
        }}
    public static String insertNewlines(String text, int charLimit) {
        StringBuilder formatted = new StringBuilder();
        int length = text.length();

        for (int i = 0; i < length; i += charLimit) {
            if (i + charLimit < length) {
                formatted.append(text, i, i + charLimit).append("\n");
            } else {
                formatted.append(text.substring(i)); // Add the remainder
            }
        }

        return formatted.toString();
    }

public void quantityIncrement(javafx.scene.input.MouseEvent event){
        String prevQuantity=quantatiy.getText();
     int quantitynum=(Integer.parseInt(prevQuantity))+1;
     String newQuantity=Integer.toString(quantitynum);
     quantatiy.setText( newQuantity);


}
    public void quantityDecrement(javafx.scene.input.MouseEvent event){

        String prevQuantity=quantatiy.getText();
        if (Integer.parseInt(prevQuantity)>1) {
            int quantitynum = (Integer.parseInt(prevQuantity)) - 1;
            String newQuantity = Integer.toString(quantitynum);
            quantatiy.setText(newQuantity);

        }

    }
    public void addToOrder(javafx.scene.input.MouseEvent event) throws Exception {
product.setQuantity(Integer.parseInt(quantatiy.getText()));
        setOrder(product);


try{
    String Insert_QUERY_Order = "INSERT INTO order_product (product_id,order_id,quantity,price,total_price) values(?,?,?,?,?)";
    Connection connection = DatabaseManger.getConnection();
    double totalPrice=product.getPrice()*product.getQuantity();
    PreparedStatement Insertstatemet = connection.prepareStatement(Insert_QUERY_Order);
    Insertstatemet.setInt(1, product.getId());
    Insertstatemet.setInt(2, order.getId());
    Insertstatemet.setInt(3, product.getQuantity());
    Insertstatemet.setDouble(4, product.getPrice());
    Insertstatemet.setDouble(5, totalPrice);
    int count = Insertstatemet.executeUpdate();

}catch (Exception e) {
    throw new RuntimeException(e);
}



    }
    public void setOrder(Product product)  {
        if (this.order == null) {
            this.order = new Order(); // Initialize the order if it is null
        }
        this.order.products.add(product); // Assuming products is a list in the Order class

    }
  public Order getOrder(){
        return this.order;
  }



}





