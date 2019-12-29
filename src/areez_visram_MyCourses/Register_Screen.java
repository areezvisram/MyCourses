package areez_visram_MyCourses;

/*Name: Areez Visram
Date: Tuesday, June 11th 2018
ICS4U1 - Kosh
ISU - My Courses*/

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class Register_Screen {
	
	//Declaring a final private Pane
	private final Pane rootPane;
	
	//Declaring a new pane 
	Pane root = new Pane();
	
	//Creating an ArrayList of type Account, to store information for the account
	static ArrayList<Account> Accounts = new ArrayList<Account>();

	//Variable Declaration
	String username;
	String password;
	String confirmpassword;
	String filename = "Accounts.txt";
	static Stage primaryStage;

	//Constructor for the register screen
	public Register_Screen() {
		
		//Setting the final private Pane to a new BorderPane
		rootPane = new BorderPane();
		
		//Declaring a new stage for the register screen
		primaryStage = new Stage();
		
		//Setting the title for the register screen
		primaryStage.setTitle("Register For An Account");
		
		//Declaring the font to be used for some objects in the register screen
		Font introfont = new Font("Times New Roman", 25);

		//Declaring the MyCourses logo image as a new image
		Image logo = new Image("/img/MyCourses Logo.png");	

		//Declaring a new ImageView object of name selectedImage
		ImageView selectedImage = new ImageView();	
		
		//Setting the ImageView object to the just created logo image
		selectedImage.setImage(logo);

		//Setting the (x,y) location of the image on the screen
		selectedImage.setLayoutX(125);
		selectedImage.setLayoutY(0);
		
		//Declaring a new label object to tell user to register for an account
		Label register_account = new Label("Register for a MyCourses Account Now:");
		
		//Setting the style and font of the label
		register_account.setStyle("-fx-font-weight: bold");
		register_account.setStyle("-fx-text-fill: black");
		register_account.setFont(Font.font("Times New Roman", 20));
		
		//Setting the (x,y) location of the label
		register_account.setLayoutX(80);
		register_account.setLayoutY(150);

		//Declaring a new Label object for username
		Label username_label = new Label("Username:");

		//Setting the style and font of the text of the label
		username_label.setStyle("-fx-font-weight: bold");
		username_label.setStyle("-fx-text-fill: black");
		username_label.setFont(introfont);

		//Setting the (x,y) location of the label on the screen
		username_label.setLayoutX(10);
		username_label.setLayoutY(245);	
		
		//Declaring a new TextField for the username to be entered
		TextField username_TextField = new TextField();
		
		//Setting the style and font of the text in the TextField
		username_TextField.setStyle("-fx-text-fill: black");
		username_TextField.setStyle("-fx-font-weight: none");
		username_TextField.setFont(introfont);

		//Setting the (x,y) location of the TextField on the screen
		username_TextField.setLayoutX(130);
		username_TextField.setLayoutY(235);
		
		//Declaring a new label object for the password
		Label password_label = new Label("Password:");
		
		//Setting the style and font of the label
		password_label.setStyle("-fx-font-weight: bold");
		password_label.setStyle("-fx-text-fill: black");
		password_label.setFont(introfont);

		//Setting the (x,y) location of the label on the screen
		password_label.setLayoutX(10);
		password_label.setLayoutY(300);	
		
		//Declaring a new PasswordField object for the password to be entered
		PasswordField password_Field = new PasswordField();
		
		//Setting the style and font of the text in the PasswordField
		password_Field.setStyle("-fx-text-fill: black");
		password_Field.setStyle("-fx-font-weight: none");
		password_Field.setFont(introfont);

		//Setting the (x,y) location of the TextField on the screen
		password_Field.setLayoutX(130);
		password_Field.setLayoutY(290);
		
		//Declaring a new label object to confirm the password
		Label confirm_password = new Label("Confirm Password:");
		
		//Setting the style and font of the label
		confirm_password.setStyle("-fx-font-weight: bold");
		confirm_password.setStyle("-fx-text-fill: black");
		confirm_password.setFont(Font.font("Times New Roman", 16.5));

		//Setting the (x,y) location of the label on the screen
		confirm_password.setLayoutX(1);
		confirm_password.setLayoutY(360);	

		//Declaring a new PasswordField object to confirm password
		PasswordField confirm_password_Field = new PasswordField();
		
		//Setting the style and font of the text in the PasswordField
		confirm_password_Field.setStyle("-fx-text-fill: black");
		confirm_password_Field.setStyle("-fx-font-weight: none");
		confirm_password_Field.setFont(introfont);

		//Setting the (x,y) location of the TextField on the screen
		confirm_password_Field.setLayoutX(130);
		confirm_password_Field.setLayoutY(345);
		
		//Declaring a new button object for the user to confirm their registration
		Button register_button = new Button ("REGISTER NOW");
		
		//Setting the style and font of the button
		register_button.setStyle("-fx-text-fill: black");
		register_button.setFont(Font.font("Franklin Gothic Heavy", 27));		
		
		//Setting the (x,y) location of the button
		register_button.setLayoutX(150);
		register_button.setLayoutY(420);
		
		//Code to be executed when the button is clicked
		register_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				
				//Get the input entered into the text fields and assign them to their correct variable
				password = password_Field.getText();
				confirmpassword = confirm_password_Field.getText();
				username = username_TextField.getText();
				
				//Creating a new account object
				Account a = new Account (username, password); 
				
				//Adding the account object to the ArrayList
				Accounts.add(a);
				
				//Check to make sure passwords entered match
				if (password.equals(confirmpassword)) {
					
					//Try catch block to write text to file
					try (FileWriter fw = new FileWriter("Accounts.txt", true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter out = new PrintWriter(bw))
							{
							out.println(a.getusername());
							out.println(a.getpassword());
							out.close();
						
					//Catch to make sure file is written to properly	
					} catch(IOException ex) {
						System.out.println("Error writing to file "+ filename);
					} 
					

					
					//Go back to intro screen so user can log in with their registered account
					Intro_Screen i = new Intro_Screen();
					i.start(primaryStage);
					
					//Close and hide the register screen
					Stage s = (Stage) register_button.getScene().getWindow();
					s.close();
					
				}else {
					//If the passwords don't match, must register again
					primaryStage.hide();

				}
			}
		});

		
		//Setting the colour of the background of the screen
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		//Adding all the objects to the screen so they appear
		root.getChildren().add(selectedImage);
		root.getChildren().add(register_account);
		root.getChildren().add(username_label);
		root.getChildren().add(username_TextField);		
		root.getChildren().add(password_label);
		root.getChildren().add(password_Field);
		root.getChildren().add(confirm_password);
		root.getChildren().add(confirm_password_Field);
		root.getChildren().add(register_button);
		
		//Declaring a new scene object
		Scene scene = new Scene(root, 500, 500);
		
		//Setting the scene of the stage and making it visible
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//Getter for the declared Pane
	public Pane getRootPane() {
		
		//Return the private final variable declared above
		return rootPane;
	}

}
