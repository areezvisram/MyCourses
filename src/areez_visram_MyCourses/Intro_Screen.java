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
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.io.BufferedReader;
import java.io.FileReader;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Intro_Screen extends Application {
	//Declaring a new Pane object of name root
	Pane root = new Pane();

	//Variable Declaration
	String username;
	String password;
	boolean logincheck = false;

	public static void main(String[] args) {	
		//Launch the JavaFX Application from the main method
		launch(args);
	}

	public void start (Stage primaryStage) {

		//Setting the title of the window to the name of the application
		primaryStage.setTitle("MyCourses");

		//Declaring a new ImageView object of name selectedImage
		ImageView selectedImage = new ImageView();		

		//Declaring the MyCourses logo image as a new image
		Image logo = new Image("/img/MyCourses Logo.png");	

		//Setting the ImageView object to the just created logo image
		selectedImage.setImage(logo);

		//Setting the (x,y) location of the image on the screen
		selectedImage.setLayoutX(125);
		selectedImage.setLayoutY(0);

		//Declaring a new font to be used for the intro screen
		Font introfont = new Font("Times New Roman", 25);

		//Declaring a new Label object for username
		Label username_label = new Label("Username:");

		//Setting the style and font of the text of the label
		username_label.setStyle("-fx-font-weight: bold");
		username_label.setStyle("-fx-text-fill: black");
		username_label.setFont(introfont);

		//Setting the (x,y) location of the label on the screen
		username_label.setLayoutX(25);
		username_label.setLayoutY(160);	

		//Declaring a new label object for the password
		Label password_label = new Label("Password:");

		//Setting the style and font of the text of the label
		password_label.setStyle("-fx-font-weight: bold");
		password_label.setStyle("-fx-text-fill: black");
		password_label.setFont(introfont);

		//Setting the (x,y) location of the label on the screen
		password_label.setLayoutX(25);
		password_label.setLayoutY(220);

		//Declaring a new TextField object for user input for username
		TextField username_TextField = new TextField();

		//Setting the style and font of the text in the TextField
		username_TextField.setStyle("-fx-text-fill: black");
		username_TextField.setStyle("-fx-font-weight: none");
		username_TextField.setFont(introfont);

		//Setting the (x,y) location of the TextField on the screen
		username_TextField.setLayoutX(145);
		username_TextField.setLayoutY(150);

		//Declaring a new Password Field object for the field for the password
		PasswordField password_field = new PasswordField();

		//Setting the style and font of the text in the password field
		password_field.setStyle("-fx-text-fill: black");
		password_field.setStyle("-fx-font-weight: none");
		password_field.setFont(introfont);

		//Setting the (x,y) location of the password field
		password_field.setLayoutX(145);
		password_field.setLayoutY(210);

		//Declaring a new button object for the login
		Button submit_button = new Button("LOGIN");

		//Setting the style and font of the button
		submit_button.setStyle("-fx-text-fill: black");
		submit_button.setFont(Font.font("Franklin Gothic Heavy", 27));	

		//Setting the (x,y) location of the button
		submit_button.setLayoutX(185);
		submit_button.setLayoutY(268);

		//Setting up code to be executed once the login button is pressed
		submit_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				//Assigning the text from the two text fields to their individual variables
				username = username_TextField.getText();
				password = password_field.getText();

				//Declaring two variables for the lines of the text file
				String line;
				String line2;

				//Try catch block for reading the text file
				try {
					

					//Creating a new file reader and buffered reader
					FileReader fr = new FileReader("Accounts.txt");
					BufferedReader br = new BufferedReader(fr);					

					//While loop to read two lines at a time
					while ((line = br.readLine()) != null && (line2 = br.readLine()) != null) {

						//If the entered username and password match a registered account in the text file
						if ((username.equals(line)) && (password.equals(line2))) {
							
							//Hide the login screen
							primaryStage.hide();
							

							//Go to the Program Selection screen
							Program_Selection_Screen p = new Program_Selection_Screen();
							primaryStage.getScene().setRoot(p.getRootPane());
							primaryStage.hide();
							logincheck = true;
							break;

							//If the entered username and password do not match a registered account in the text file
						} 						
					}
					if (logincheck == false) {
						//Create a new pane, scene and stage for the pop up
						Pane root2 = new Pane();
						Scene scene2 = new Scene(root2, 285, 50);
						Stage popup_Stage = new Stage();

						//Declare a label that will tell the user their login failed in the popup
						Label loginfailed = new Label("Login Failed. Please Try Again");

						//Setting font and style of the popup
						loginfailed.setStyle("-fx-font-weight: bold");
						loginfailed.setStyle("-fx-text-fill: black");
						loginfailed.setFont(Font.font("Times New Roman", 18));

						//Setting the (x,y) location of the label in the popup
						loginfailed.setLayoutX(20);
						loginfailed.setLayoutY(15);

						//Setting the popup scene, showing the popup, and adding the label to the popup
						popup_Stage.setScene(scene2);
						popup_Stage.show();
						root2.getChildren().add(loginfailed);

						//PauseTransition to make the popup pop up for 3 seconds before disappearing 
						PauseTransition wait = new PauseTransition(Duration.seconds(3));
						wait.setOnFinished((e) -> {

							//Close the popup after three seconds 
							popup_Stage.close();

							//Play for three seconds each time code runs through
							wait.playFromStart();
						});

						//Play the popup
						wait.play();
					}
					//Close the text file
					br.close();

					//Checking to make sure file is read correctly
				} catch (Exception e) {
					System.out.println("Error reading file");
				}
			}
		}			
				);

		//Declaring a new label object to register for an account
		Label account_register = new Label("Don't have a MyCourses account? Register for one now.");		

		//Setting the style and font of the register account label
		account_register.setStyle("-fx-font-weight: bold");
		account_register.setStyle("-fx-text-fill: black");
		account_register.setFont(Font.font("Times New Roman", 20));

		//Setting the (x,y) location of the register account label on the screen
		account_register.setLayoutX(25);
		account_register.setLayoutY(330);


		//Declaring a new button object to take user to register screen
		Button register_button = new Button ("REGISTER");

		//Setting style and font of the register button
		register_button.setStyle("-fx-text-fill: black");
		register_button.setFont(Font.font("Franklin Gothic Heavy", 27));		

		//Setting the (x,y) location of the button on the screen
		register_button.setLayoutX(165);
		register_button.setLayoutY(370);

		//Code to be executed when button is clicked
		register_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				//Close login screen
				primaryStage.hide();

				//Go to screen to register for an account
				Register_Screen r = new Register_Screen();
				primaryStage.getScene().setRoot(r.getRootPane());
			}			
		});

		//Setting the color of the screen
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		//Adding all the objects to the screen so they appear 
		root.getChildren().add(selectedImage);
		root.getChildren().add(username_label);
		root.getChildren().add(username_TextField);
		root.getChildren().add(password_label);
		root.getChildren().add(password_field);
		root.getChildren().add(submit_button);
		root.getChildren().add(account_register);
		root.getChildren().add(register_button);

		//Creating the main scene for the login screen
		Scene scene = new Scene(root, 500, 500);

		//Setting the scene for the login screen and showing it so it is displayed
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}