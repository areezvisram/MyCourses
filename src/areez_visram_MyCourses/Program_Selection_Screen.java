package areez_visram_MyCourses;

/*Name: Areez Visram
Date: Tuesday, June 11th 2018
ICS4U1 - Kosh
ISU - My Courses*/

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.collections.ChangeHelper;

import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Program_Selection_Screen {
	
	//This code is used in the switching of screens
	//Declaring a rootPane variable of object type Pane
	private final Pane rootPane;
	
	//Declaring a new root object of type Pane
	Pane root = new Pane();
	
	//Constructor for the class - allows for switching of screens
	public Program_Selection_Screen() {
		
		//Declaring a new BorderPane and Stage for the screen
		rootPane = new BorderPane();
		Stage primaryStage = new Stage();
		
		//Setting the title of the screen
		primaryStage.setTitle("Program Selection");

		//Declaring a new ImageView object of name selectedImage
		ImageView selectedImage = new ImageView();		

		//Declaring the MyCourses logo image as a new image
		Image logo = new Image("/img/MyCourses Logo.png");	

		//Setting the ImageView object to the just created logo image
		selectedImage.setImage(logo);

		//Setting the (x,y) location of the image on the screen
		selectedImage.setLayoutX(125);
		selectedImage.setLayoutY(15);

		//Declaring a new ImageView object for the McMaster Engineering picture
		ImageView Mac_Eng_Image = new ImageView();
		Image Mac_Eng = new Image("/img/mcmaster engineering.jpg");
		Mac_Eng_Image.setImage(Mac_Eng);
		
		//Declaring a new ImageView object for the Schulich IBBA picture
		ImageView Schulich_IBBA_Image = new ImageView();
		Image Schulich_IBBA = new Image("/img/schulich ibba.jpg");
		Schulich_IBBA_Image.setImage(Schulich_IBBA);

		//Declaring a new font to be used for the intro screen
		Font introfont = new Font("Times New Roman", 19);
		
		//Declaring a new Label object to tell user to select a program from drop down list
		Label choose_program = new Label ("Please choose the program you would like to view courses for:");
		
		//Setting the style and font of the text of the label
		choose_program.setStyle("-fx-font-weight: bold");
		choose_program.setStyle("-fx-text-fill: black");
		choose_program.setFont(introfont);

		//Setting the (x,y) location of the label on the screen
		choose_program.setLayoutX(10);
		choose_program.setLayoutY(160);	

		//Creating a new ImageView that will appear based on what program is selected from the list
		ImageView program_image = new ImageView();

		//Declaring a new array to store the images that will appear for each program in the drop down list
		final Image[] program_images = new Image[] {Mac_Eng, Schulich_IBBA};

		//Creating a drop down choice box for the program selection
		final ChoiceBox<String> programs = new ChoiceBox<String>(FXCollections.observableArrayList(
				//Setting the options for the choices in the drop down list
				"McMaster Software Engineering", "York Schulich International Business Administration")
				);
		
		//Setting the picture of the previously declared ImageView based on the choice selected in the drop down menu
		//Picture is loaded into ImageView from previously declared array of images
		programs.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number>
		ov,
		Number old_val, Number new_val) -> {
			program_image.setImage(program_images[new_val.intValue()]);
			
		});
			
		//Setting the (x,y) locations of the image that will appear when a choice is selected
		programs.setLayoutX(100);
		programs.setLayoutY(200);
		program_image.setLayoutX(160);
		program_image.setLayoutY(300);

		//Creating a new button object for the user to go to next screen after choosing program from drop down meny
		Button submit_button = new Button("SUBMIT");
		
		//Setting the style and font of the text of the button
		submit_button.setStyle("-fx-font-weight: bold");
		submit_button.setStyle("-fx-text-fill: black");
		submit_button.setFont(Font.font("Franklin Gothic Heavy", 27));

		//Setting the (x,y) location of the label on the screen
		submit_button.setLayoutX(180);
		submit_button.setLayoutY(240);
		
		
		//Declaring the actions that will execute when the submit button is clicked by the user
		submit_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				
				//This code will execute if the user has chosen McMaster Software Engineering as the program they want to view courses for
				if (programs.getValue().equals("McMaster Software Engineering")) {
					
					//The selector screen will hide and the user will be taken to the McMaster courses screen
					primaryStage.hide();
					McMaster_Year1_Fall m = new McMaster_Year1_Fall();
					primaryStage.getScene().setRoot(m.getRootPane());
					
					//This code will execute if the user has chosen Schulich IBBA as the program they want to view courses for
				} else if (programs.getValue().equals("York Schulich International Business Administration")) {
					
					//Create a new pane, scene and stage for the error message
					Pane root2 = new Pane();
					Scene scene2 = new Scene(root2, 450, 50);
					Stage popup_Stage = new Stage();

					//Declare a label that will tell the user that this information is not available and to check back in future updates
					Label check_update = new Label("Not Currently Available. Check Back In Future Updates.");

					//Setting font and style of the error message text
					check_update.setStyle("-fx-font-weight: bold");
					check_update.setStyle("-fx-text-fill: black");
					check_update.setFont(Font.font("Times New Roman", 18));

					//Setting the (x,y) location of the label in the error message
					check_update.setLayoutX(20);
					check_update.setLayoutY(15);

					//Setting the second scene, showing the message, and adding the label to the screen
					popup_Stage.setScene(scene2);
					popup_Stage.show();
					root2.getChildren().add(check_update);

					//PauseTransition to make the message pop up for 3 seconds before disappearing 
					PauseTransition wait = new PauseTransition(Duration.seconds(3));
					wait.setOnFinished((e) -> {

						//Close the message after three seconds 
						popup_Stage.close();

						//Play for three seconds each time code runs through
						wait.playFromStart();
					});

					//Play the message
					wait.play();
					
					//This code will execute if the user tries to progress without choosing a program
				} else {
					//Create a new pane, scene and stage for the error message
					Pane root2 = new Pane();
					Scene scene2 = new Scene(root2, 450, 50);
					Stage popup_Stage = new Stage();

					//Declare a label that will tell the user to choose a program before progressing
					Label check_update = new Label("Please Select A Program Before Advancing.");

					//Setting font and style of the error message text
					check_update.setStyle("-fx-font-weight: bold");
					check_update.setStyle("-fx-text-fill: black");
					check_update.setFont(Font.font("Times New Roman", 18));

					//Setting the (x,y) location of the label in the error message
					check_update.setLayoutX(20);
					check_update.setLayoutY(15);

					//Setting the second scene, showing the message, and adding the label to the screen
					popup_Stage.setScene(scene2);
					popup_Stage.show();
					root2.getChildren().add(check_update);

					//PauseTransition to make the message pop up for 3 seconds before disappearing 
					PauseTransition wait = new PauseTransition(Duration.seconds(3));
					wait.setOnFinished((e) -> {

						//Close the message after three seconds 
						popup_Stage.close();

						//Play for three seconds each time code runs through
						wait.playFromStart();
					});

					//Play the message
					wait.play();
				}

			}
		});

		//Setting the colour of the background of the screen
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		//Adding all the images to the screen
		root.getChildren().add(selectedImage);
		root.getChildren().add(choose_program);
		root.getChildren().add(programs);
		root.getChildren().add(program_image);
		root.getChildren().add(submit_button);
		
		//Declaring a new scene object
		Scene scene = new Scene(root, 500, 500);
		
		//Setting the scene and showing the screen so it appears
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//Getter for rootPane - this allows the switching of screens from one to another
	public Pane getRootPane() {
		return rootPane;
	}
}

