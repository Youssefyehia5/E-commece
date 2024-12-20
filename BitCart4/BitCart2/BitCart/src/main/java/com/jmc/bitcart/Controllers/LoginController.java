package com.jmc.bitcart.Controllers;

import com.jmc.bitcart.Controllers.Client.ClientController;
import com.jmc.bitcart.DatabaseManger;
import com.jmc.bitcart.Models.Order;
import com.jmc.bitcart.Models.Product;
import com.jmc.bitcart.Models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    public Label login_email_lbl;
    public TextField login_email_fld;
    public Label login_password_lbl;
    public TextField login_password_fld;
    public Button login_btn;
    public Label register_name_lbl;
    public TextField register_name_fld;
    public Label register_email_lbl;
    public TextField register_email_fld;
    public Label register_phone_lbl;
    public TextField register_phone_fld;
    public Label register_password_lbl;
    public TextField register_password_fld;
    public Button register_btn;
    User newUser;
String alertName;
private Order order;
    private List<Product> products;




    public void handleLoginClick(javafx.event.ActionEvent event) throws Exception {
        // Retrieve data from the text fields
        String email = login_email_fld.getText();
        String password = login_password_fld.getText();

        try {
            Connection con= DatabaseManger.getConnection();
            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM  users");


            boolean isValid=false;
            while (resultSet.next()) {

                String CheckEmail=  resultSet.getString("email");
                String CheckPassword= resultSet.getString("password");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                int userId = resultSet.getInt("user_id");
                alertName= name;
              alertName=  alertName.toUpperCase();
                if(CheckEmail.equals(email) && CheckPassword.equals(password)) {
                    newUser = new User(name,email,password,phone);
                    newUser.setId(userId);
                    order=new Order();
                    setOrder(order);
                    order.setUser(newUser);
                    products=new ArrayList<>();
                    System.out.println(order);

loadClientView(newUser);




                    System.out.println(newUser);
                    isValid=true;
                    break;

                }

            }
            if (isValid) {
                // Show success message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login Success");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully logged in!"+" "+ alertName);
                alert.showAndWait();
            } else {
                // Show error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid email or password.");
                alert.showAndWait();
            }


            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Add further logic (e.g., authentication)
    }
    public void handleRegisterClick() {
        boolean isValid = true;
        String CheckEmail = "";
        String CheckPhone = " ";

        String name = register_name_fld.getText();
        String email = register_email_fld.getText();
        String PHONE = register_phone_fld.getText();
        String password = register_password_fld.getText();

        String Insert_QUERY = "INSERT INTO users (name,email,phone,password) values(?,?,?,?)";
        String Check_Query = "SELECT * FROM users";

        try {
            Connection connection = DatabaseManger.getConnection();

            PreparedStatement Insertstatemet = connection.prepareStatement(Insert_QUERY);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Check_Query);

            while (resultSet.next()) {
                CheckEmail = resultSet.getString("email");
                CheckPhone = resultSet.getString("phone");
                if (CheckEmail.equals(email) || CheckPhone.equals(PHONE)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                Insertstatemet.setString(1, name);
                Insertstatemet.setString(2, email);
                Insertstatemet.setString(3, PHONE);
                Insertstatemet.setString(4, password);

                int count = Insertstatemet.executeUpdate();

                // Success alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registration Successful");
                alert.setHeaderText(null);
                alert.setContentText(count + " record(s) inserted successfully!");
                alert.showAndWait();
            } else {
                // Error alerts for duplicate email or phone
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Registration Error");
                alert.setHeaderText("Validation Error");
                if (CheckEmail.equals(email)) {
                    alert.setContentText("The email address is already registered.");
                } else if (CheckPhone.equals(PHONE)) {
                    alert.setContentText("The phone number is already registered.");
                }
                alert.showAndWait();
            }

        } catch (SQLException e) {
            // Database error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText("An error occurred");
            alert.setContentText("Unable to process the registration. Please try again later.");
            alert.showAndWait();
            e.printStackTrace();
        } catch (Exception e) {
            // General error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An unexpected error occurred");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            e.printStackTrace();

        }

    }
    public String getUSerName() {
        return newUser.getName();
    }
    private void loadClientView(User user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Client/Client.fxml"));
            Parent root = loader.load();

            // Get the ClientController instance
            ClientController clientController = loader.getController();

            // Pass the User object
            clientController.setUser(user);
            clientController.setOrder(order);


            Stage stage = (Stage) login_email_fld.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOrder(Order order) throws Exception {


try {
    String Insert_QUERY_Order = "INSERT INTO orderr (user_id,order_date,total_amount,status) values(?,?,?,?)";



    Connection connection = DatabaseManger.getConnection();
    PreparedStatement Insertstatemet = connection.prepareStatement(Insert_QUERY_Order);


    LocalDateTime now = LocalDateTime.now();
    double totalamount = 0.0;


    Insertstatemet.setInt(1, newUser.getId());
    Insertstatemet.setString(2, now.toString());
    Insertstatemet.setDouble(3, totalamount);
    Insertstatemet.setString(4, "Pending");

    int count = Insertstatemet.executeUpdate();
    String Select_Query = "SELECT * FROM orderr WHERE order_date = (SELECT MAX(order_date) FROM orderr) ";
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(Select_Query);
    resultSet.next();
    this.order.id = resultSet.getInt("order_id");
System.out.println(order.id);






} catch (Exception e) {
    throw new RuntimeException(e);
}



    }






}



