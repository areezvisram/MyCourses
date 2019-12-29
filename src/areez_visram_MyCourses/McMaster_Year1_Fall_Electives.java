package areez_visram_MyCourses;

/*Name: Areez Visram
Date: Tuesday, June 11th 2018
ICS4U1 - Kosh
ISU - My Courses*/

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.collections.ChangeHelper;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

public class McMaster_Year1_Fall_Electives {
	
	//This code is used in the switching of screens
	//Declaring a rootPane variable of object type ScrollPane for screen to scroll
	private final ScrollPane rootPane;
	
	//Declaring a new root object of type ScrollPane
	ScrollPane root = new ScrollPane();
	
	//Constructor for the class - allows for switching of screens
	public McMaster_Year1_Fall_Electives() {
		
		//Declaring a new ScrollPane and Stage for this screen
		rootPane = new ScrollPane();
		Stage primaryStage = new Stage();

		//Declaring a new ImageView object of name selectedImage
		ImageView selectedImage = new ImageView();

		//Declaring the MyCourses logo image as a new image
		Image logo = new Image("/img/MyCourses Logo.png");

		//Setting the ImageView object to the just created logo image
		selectedImage.setImage(logo);

		//Setting the (x,y) location of the image on the screen
		selectedImage.setLayoutX(480);
		selectedImage.setLayoutY(5);
		
		//Declaring a new Label object for the title at top of the screen
		Label year1fall_title = new Label("YEAR 1 FALL");
		
		//Setting the style and font of the label
		year1fall_title.setStyle("-fx-font-weight: bold");
		year1fall_title.setStyle("-fx-text-fill: black");
		year1fall_title.setFont(Font.font("Franklin Gothic Heavy", 40));
		
		//Setting the (x,y) location of the label on the screen
		year1fall_title.setLayoutX(490);
		year1fall_title.setLayoutY(135);
		
		
		//Declaring a new Label object for column heading for elective courses
		Label electives = new Label("Electives");
		
		//Setting style and font of the label
		electives.setStyle("-fx-font-weight: bold");
		electives.setUnderline(true);
		electives.setStyle("-fx-text-fill: black");
		electives.setFont(Font.font("Times New Roman", 25));
		
		//Setting (x,y) location of label on the screen
		electives.setLayoutX(575);
		electives.setLayoutY(180);
		
		
		//Creating a new ArrayList to store the elective course titles
		List<Label> elective_courses1 = new ArrayList<Label>();
		
		//Declaring String variable to store data from text file
		String line;
		
		//Try-Catch block to read data from text file
		try {

			// Creating a new file reader and buffered reader
			FileReader fr = new FileReader("src/Text Files Needed/McMaster Year 1 Fall Electives.txt");
			BufferedReader br = new BufferedReader(fr);

			//While loop to read data from text file
			while ((line = br.readLine()) != null) {
				
				//Adding the data from the text file to the ArrayList
				elective_courses1.add(new Label(line));
			}
			
			//Catch Block to make sure file is read correctly
		} catch (Exception e) {
			System.out.println("Error reading file");
		}
		
		//Declaring initial y value of labels on the screen
		int y_location = 220;
		
		//For loop to loop through all the labels
		for (int i = 0; i < elective_courses1.size(); i++) {
			
			//Setting the (x,y) location of the label on the screen (y from variable)
			elective_courses1.get(i).setLayoutX(20);
			elective_courses1.get(i).setLayoutY(y_location);
			
			//Setting the style and font of the label
			elective_courses1.get(i).setStyle("-fx-font-weight: bold");
			elective_courses1.get(i).setStyle("-fx-text-fill: black");
			elective_courses1.get(i).setFont(Font.font("Cambria Math", 18));
			
			//Incrementing the y location of labels so they go down screen
			y_location = y_location + 75;
		}
		
		//ArrayList for the second set of elective courses
		List<Label> elective_courses2 = new ArrayList<Label>();
		
		//Declaring String variable to store data from text file
		String line2;
		
		//Try-Catch block to read data from text file
		try {

			// Creating a new file reader and buffered reader
			FileReader fr = new FileReader("src/Text Files Needed/McMaster Year 1 Fall Electives 2.txt");
			BufferedReader br = new BufferedReader(fr);


			//While loop to read data from text file
			while ((line2 = br.readLine()) != null) {
				//Adding the data from the text file to the ArrayList
				elective_courses2.add(new Label(line2));
			}
			
			//Catch Block to make sure file is read correctly
		} catch (Exception e) {
			System.out.println("Error reading file");
		}
		
		//Declaring initial y value of labels on the screen
		int y_location2 = 220;
		
		//For loop to loop through all the labels
		for (int i = 0; i < elective_courses2.size(); i++) {
			
			//Setting the (x,y) location of the label on the screen (y from variable)
			elective_courses2.get(i).setLayoutX(650);
			elective_courses2.get(i).setLayoutY(y_location2);
			
			//Setting the style and font of the label
			elective_courses2.get(i).setStyle("-fx-font-weight: bold");
			elective_courses2.get(i).setStyle("-fx-text-fill: black");
			elective_courses2.get(i).setFont(Font.font("Cambria Math", 18));
			
			//Incrementing the y location of labels so they go down screen
			y_location2 = y_location2 + 75;
		}
		
		
		//Declaring new ArrayLists for Button to view descriptions and Strings to display title and description
		ArrayList<Button> elective_view_description = new ArrayList<Button>();		
		ArrayList<String> elective_description = new ArrayList<String>();
		ArrayList<String> elective_title = new ArrayList<String>();
		
		//Declaring string variables to store data from text file
		String description;
		String title;
		
		//Try-Catch block to read data from file
		try {

			//Creating a new file reader and buffered reader
			FileReader fr = new FileReader("src/Text Files Needed/McMaster Year 1 Fall Elective Courses Descriptions 1.txt");
			BufferedReader br = new BufferedReader(fr);

			//While loop to read two lines at a time
			while ((title = br.readLine())!= null && (description = br.readLine()) != null)  {
				
				//Adding data from text file to correct ArrayList
				elective_description.add(description);	
				elective_title.add(title);
			} 
			
			//Catch Block to make sure data is read correctly
		}catch (Exception e) {
			System.out.println("Error reading file");
		}
		
		//Declaring the initial y value of the button 
		int view_descrip_y_location = 245;
		
		//For loop to loop through ArrayList and set properties of buttons
		for (int i = 0; i < elective_title.size(); i++) {
			
			//Declaring a new button object for user to view description of course
			Button view_description_button = new Button();
			
			//Setting the y location of the button on the screen using the variable
			view_description_button.setLayoutY(view_descrip_y_location);			
			
			//Incrementing the y variable so the buttons move down the screen
			view_descrip_y_location = view_descrip_y_location + 75;
			
			//Setting the x location of the button on the screen
			view_description_button.setLayoutX(25);
			
			//Setting the text, style and font of the buttons
			view_description_button.setText("View Description");
			view_description_button.setStyle("-fx-font-weight: bold");
			view_description_button.setStyle("-fx-text-fill: black");			
			view_description_button.setFont(Font.font("Cambria Math", 16));
			
			//Adding the button to the ArrayList of buttons to be displayed
			elective_view_description.add(view_description_button);			
			
			//Creating a new Label object for the title of the course, data taken from the ArrayList
			Label course_title = new Label(elective_title.get(i));
			
			//Setting style, font and alignment of the text of the label
			course_title.setStyle("-fx-font-weight: bold");
			course_title.setStyle("-fx-text-fill: black");
			course_title.setFont(Font.font("Cambria Math", 18));
			course_title.setTextAlignment(TextAlignment.CENTER);
			course_title.setUnderline(true);
			
			//Setting the (x,y) location of the label in the second pop-up screen
			course_title.setLayoutX(10);
			course_title.setLayoutY(5);
			
			//Creating a new Label object for the description of the course, data taken from the ArrayList
			Label course_description = new Label(elective_description.get(i));			
			
			//Setting the style, font and alignment of the text of the label
			course_description.setStyle("-fx-font-weight: bold");
			course_description.setStyle("-fx-text-fill: black");
			course_description.setFont(Font.font("Cambria Math", 18));
			
			//Setting the text to wrap at a certain width so text does not go off screen
			course_description.setWrapText(true);
			course_description.setMaxWidth(465);
			
			//Setting the (x,y) location of the label on the second pop-up screen
			course_description.setLayoutX(10);
			course_description.setLayoutY(35);
			
			//Code to be executed when the button to view description of course is clicked
			elective_view_description.get(i).setOnAction(new EventHandler<ActionEvent>(){	
				public void handle(ActionEvent event) {		
					
					//Declare new Pane, Scene and Stage for pop-up window with course description
					Pane root2 = new Pane();					
					Scene scene2 = new Scene(root2, 475, 300);
					Stage popup_Stage = new Stage();
					
					//Declaring a new button to allow the user to return to the elective list
					Button close_description = new Button ("RETURN");
					
					//Setting the style and font of the button
					close_description.setStyle("-fx-text-fill: black");
					close_description.setStyle("-fx-font-weight: bold");
					close_description.setFont(Font.font("Times New Roman", 50));
					
					//Setting the (x,y) location of the label on the second pop-up screen
					close_description.setLayoutX(200);
					close_description.setLayoutY(250);					
					
					//Code to be executed when return button is clicked
					close_description.setOnAction(new EventHandler<ActionEvent>(){	
						public void handle(ActionEvent event) {	
							
							//Close the second pop-up screen to return to elective list
							popup_Stage.close();
						}
					});
					
					//Add the buttons and labels to the second pop-up screen
					root2.getChildren().add(course_title);
					root2.getChildren().add(course_description);
					root2.getChildren().add(close_description);
					
					//Setting the scene and showing the second screen
					popup_Stage.setScene(scene2);					
					popup_Stage.show();
				}
			});
		}
		
		//Declaring new ArrayLists for Button to view descriptions and Strings to display title and description
		ArrayList<Button> elective_view_description2 = new ArrayList<Button>();		
		ArrayList<String> elective_description2 = new ArrayList<String>();
		ArrayList<String> elective_title2 = new ArrayList<String>();
		
		//Declaring string variables to store data from text file
		String description2;
		String title2;
		
		//Try-Catch block to read data from file
		try {

			//Creating a new file reader and buffered reader
			FileReader fr = new FileReader("src/Text Files Needed/McMaster Year 1 Fall Elective Courses Descriptions 2.txt");
			BufferedReader br = new BufferedReader(fr);

			//While loop to read two lines at a time
			while ((title2 = br.readLine())!= null && (description2 = br.readLine()) != null)  {
				
				//Adding data from text file to correct ArrayList
				elective_description2.add(description2);	
				elective_title2.add(title2);
			} 
			//Catch Block to make sure data is read correctly
		}catch (Exception e) {
			System.out.println("Error reading file");
		}
		
		//Declaring the initial y value of the button 
		int view_descrip_y_location2 = 245;
		
		//For loop to loop through ArrayList and set properties of buttons
		for (int i = 0; i < elective_description2.size(); i++) {
			
			//Declaring a new button object for user to view description of course
			Button view_description_button2 = new Button();
			
			//Setting the y location of the button on the screen using the variable
			view_description_button2.setLayoutY(view_descrip_y_location2);	
			
			//Incrementing the y variable so the buttons move down the screen
			view_descrip_y_location2 = view_descrip_y_location2 + 75;
			
			//Setting the x location of the button on the screen
			//Note this part is the same as part above, except this creates the list on the right side of the screen,
			//electives split into two columns on the screen
			view_description_button2.setLayoutX(650);
			
			//Setting the text, style and font of the buttons
			view_description_button2.setText("View Description");
			view_description_button2.setStyle("-fx-font-weight: bold");
			view_description_button2.setStyle("-fx-text-fill: black");			
			view_description_button2.setFont(Font.font("Cambria Math", 16));
			
			//Adding the button to the ArrayList of buttons to be displayed
			elective_view_description2.add(view_description_button2);			
			
			//Creating a new Label object for the title of the course, data taken from the ArrayList
			Label course_title2 = new Label(elective_title2.get(i));
			
			//Setting style, font and alignment of the text of the label
			course_title2.setStyle("-fx-font-weight: bold");
			course_title2.setStyle("-fx-text-fill: black");
			course_title2.setFont(Font.font("Cambria Math", 18));
			course_title2.setTextAlignment(TextAlignment.CENTER);
			course_title2.setUnderline(true);
			
			//Setting the (x,y) location of the label in the second pop-up screen
			course_title2.setLayoutX(10);
			course_title2.setLayoutY(5);
			
			//Creating a new Label object for the description of the course, data taken from the ArrayList
			Label course_description2 = new Label(elective_description2.get(i));	
			
			//Setting the style, font and alignment of the text of the label
			course_description2.setStyle("-fx-font-weight: bold");
			course_description2.setStyle("-fx-text-fill: black");
			course_description2.setFont(Font.font("Cambria Math", 18));
			
			//Setting the text to wrap at a certain width so text does not go off screen
			course_description2.setWrapText(true);
			course_description2.setMaxWidth(465);
			
			//Setting the (x,y) location of the label on the second pop-up screen
			course_description2.setLayoutX(10);
			course_description2.setLayoutY(35);
			
			//Code to be executed when the button to view description of course is clicked
			elective_view_description2.get(i).setOnAction(new EventHandler<ActionEvent>(){	
				public void handle(ActionEvent event) {	
					
					//Declare new Pane, Scene and Stage for pop-up window with course description
					Pane root2 = new Pane();					
					Scene scene2 = new Scene(root2, 475, 300);
					Stage popup_Stage = new Stage();
					
					//Declaring a new button to allow the user to return to the elective list
					Button close_description2 = new Button ("RETURN");
					
					//Setting the style and font of the button
					close_description2.setStyle("-fx-text-fill: black");
					close_description2.setStyle("-fx-font-weight: bold");
					close_description2.setFont(Font.font("Times New Roman", 50));
					
					//Setting the (x,y) location of the label on the second pop-up screen
					close_description2.setLayoutX(200);
					close_description2.setLayoutY(250);
					
					//Code to be executed when return button is clicked
					close_description2.setOnAction(new EventHandler<ActionEvent>(){	
						public void handle(ActionEvent event) {	
							//Close the second pop-up screen to return to elective list
							popup_Stage.close();
						}
					});
					
					//Add the buttons and labels to the second pop-up screen
					root2.getChildren().add(course_title2);
					root2.getChildren().add(course_description2);
					root2.getChildren().add(close_description2);
					
					//Setting the scene and showing the second screen
					popup_Stage.setScene(scene2);					
					popup_Stage.show();
				}
			});
		}

		//Declaring new ArrayLists for the Labels, Buttons and Strings used to view the times that each elective course is offered
		ArrayList<Label> choices = new ArrayList<Label>();
		ArrayList<Button> view_times = new ArrayList<Button>();
		ArrayList<String> elective_title3 = new ArrayList<String>();
		ArrayList<String> elective_course_times = new ArrayList<String>();

		//Declaring string variables to store data from text file
		String title3;
		String times;
		
		//Try-Catch Block to read data from file
		try {

			//Creating a new file reader and buffered reader
			FileReader fr = new FileReader("src/Text Files Needed/McMaster Year 1 Fall Electives Times.txt");
			BufferedReader br = new BufferedReader(fr);

			//While loop to read two lines at a time
			while ((title3 = br.readLine())!= null && (times = br.readLine()) != null) {
				
				//Adding data from text file to correct ArrayList
				elective_title3.add(title3);
				elective_course_times.add(times);
			} 
			
			//Catch Block to make sure file is read correctly
		}catch (Exception e) {
			System.out.println("Error reading file ");
		}
		
		//Declaring initial y value of the buttons
		int times_y_location = 245;
		
		//For loop to loop through ArrayList and set properties of buttons
		for (int i = 0; i < elective_title3.size(); i++) {
			
			//Declaring a new button that user will click to view the times each elective is offered
			Button view_times_button = new Button();
			
			//Declaring the y location of each button using the variable
			view_times_button.setLayoutY(times_y_location);			
			
			//Incrementing the y location variable so buttons move down the screen
			times_y_location = times_y_location + 75;
			
			//Setting x location of the buttons
			view_times_button.setLayoutX(250);
			
			//Setting the text, style and font of the buttons
			view_times_button.setText("View Times");
			view_times_button.setStyle("-fx-font-weight: bold");
			view_times_button.setStyle("-fx-text-fill: black");			
			view_times_button.setFont(Font.font("Cambria Math", 16));
			
			//Adding the button to the ArrayList of buttons to be displayed
			view_times.add(view_times_button);
			
			//Splitting the line at each comma for each different section of the course, stored in a String array
			String[] t = elective_course_times.get(i).split(",");			
			
			//Creating a new Label that will display the title of the course in the second pop-up screen
			Label course_title4 = new Label(elective_title3.get(i));
			
			//Setting the style, font and alignment of the labels
			course_title4.setStyle("-fx-font-weight: bold");
			course_title4.setStyle("-fx-text-fill: black");
			course_title4.setFont(Font.font("Cambria Math", 18));
			course_title4.setTextAlignment(TextAlignment.CENTER);
			course_title4.setUnderline(true);
			
			//Setting the (x,y) location of the labels on the second pop-up screen
			course_title4.setLayoutX(10);
			course_title4.setLayoutY(5);
			
			//Code to be executed once the button to view the course times is clicked
			view_times.get(i).setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {		
					
					//Initial y location of the course time labels is declared
					int y_location = 35;
					
					//Declaring new root, scene and stage for second pop-up screen
					Pane root2 = new Pane();					
					Scene scene2 = new Scene(root2, 650, 300);
					Stage popup_Stage = new Stage();
					
					//Declaring a new button that will allow user to return to elective list
					Button close_description3 = new Button ("RETURN");
					
					//Setting style and font of the button
					close_description3.setStyle("-fx-text-fill: black");
					close_description3.setStyle("-fx-font-weight: bold");
					close_description3.setFont(Font.font("Times New Roman", 50));
					
					//Setting the (x,y) location of the return button on the second pop-up screen
					close_description3.setLayoutX(200);
					close_description3.setLayoutY(250);		
					
					//Code to be executed when return button is clicked
					close_description3.setOnAction(new EventHandler<ActionEvent>(){	
						public void handle(ActionEvent event) {	
							
							//Close second pop-up screen to go back to elective list
							popup_Stage.close();
						}
					});
					
					//For each loop to display the course times on the second pop-up screen
					for (String s:t) {	
						
						//Declaring a new label that will display the course times 
						Label course_time = new Label();
						
						//Setting the (x,y) location of the label on the second screen (y is variable)
						course_time.setLayoutX(15);
						course_time.setLayoutY(y_location);
						
						//Incrementing the y variable so the course times move down the screen
						y_location = y_location + 50;
						
						//Setting the style and font of the label
						course_time.setStyle("-fx-font-weight: bold");
						course_time.setStyle("-fx-text-fill: black");
						course_time.setFont(Font.font("Cambria Math", 18));
						
						//Setting text of the label from the Array that stored the split strings
						course_time.setText(s);
						
						//Adding the label to the ArrayList to be displayed to the screen
						choices.add(course_time);
						
						//Adding the label to the second pop-up screen
						root2.getChildren().add(course_time);
					}	
					
					//Adding all the labels and buttons to the second pop-up screen
					root2.getChildren().add(close_description3);
					root2.getChildren().add(course_title4);
					
					//Setting the scene and displaying the second pop-up screen
					popup_Stage.setScene(scene2);					
					popup_Stage.show();

				}
			});

		}
		
		//Declaring new ArrayLists for the Labels, Buttons and Strings used to view the times that each elective course is offered
		ArrayList<Label> choices2 = new ArrayList<Label>();
		ArrayList<Button> view_times2 = new ArrayList<Button>();
		ArrayList<String> elective_title4 = new ArrayList<String>();
		ArrayList<String> elective_course_times2 = new ArrayList<String>();
		
		//Declaring string variables to store data from text file
		String title4;
		String times2;
		
		//Try-Catch Block to read data from file
		try {

			//Creating a new file reader and buffered reader
			FileReader fr = new FileReader("src/Text Files Needed/McMaster Year 1 Fall Electives Times 2.txt");
			BufferedReader br = new BufferedReader(fr);

			//While loop to read two lines at a time
			while ((title4 = br.readLine())!= null && (times2 = br.readLine()) != null)  {
				
				//Adding data from text file to correct ArrayList
				elective_title4.add(title4);
				elective_course_times2.add(times2);
			} 
			
			//Catch Block to make sure file is read correctly
		}catch (Exception e) {
			System.out.println("Error reading file ");
		}

		//Declaring initial y value of the buttons
		int times_y_location2 = 245;
		
		//For loop to loop through ArrayList and set properties of buttons
		for (int i = 0; i < elective_title4.size(); i++) {
			
			//Declaring a new button that user will click to view the times each elective is offered
			Button view_times_button = new Button();
			
			//Declaring the y location of each button using the variable
			view_times_button.setLayoutY(times_y_location2);		
			
			//Incrementing the y location variable so buttons move down the screen
			times_y_location2 = times_y_location2 + 75;
			
			//Setting x location of the buttons
			//Note this part is the same as part above, except this creates the list on the right side of the screen,
			//electives split into two columns on the screen
			view_times_button.setLayoutX(900);
			
			//Setting the text, style and font of the buttons
			view_times_button.setText("View Times");
			view_times_button.setStyle("-fx-font-weight: bold");
			view_times_button.setStyle("-fx-text-fill: black");			
			view_times_button.setFont(Font.font("Cambria Math", 16));
			
			//Adding the button to the ArrayList of buttons to be displayed
			view_times2.add(view_times_button);
			
			//Splitting the line at each comma for each different section of the course, stored in a String array
			String[] t = elective_course_times2.get(i).split(",");		
			
			//Creating a new Label that will display the title of the course in the second pop-up screen
			Label course_title5 = new Label(elective_title4.get(i));
			
			//Setting the style, font and alignment of the labels
			course_title5.setStyle("-fx-font-weight: bold");
			course_title5.setStyle("-fx-text-fill: black");
			course_title5.setFont(Font.font("Cambria Math", 18));
			course_title5.setTextAlignment(TextAlignment.CENTER);
			course_title5.setUnderline(true);
			
			//Setting the (x,y) location of the labels on the second pop-up screen
			course_title5.setLayoutX(10);
			course_title5.setLayoutY(5);
			
			//Code to be executed once the button to view the course times is clicked
			view_times2.get(i).setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {	
					
					//Initial y location of the course time labels is declared
					int y_location = 35;
					
					//Declaring new root, scene and stage for second pop-up screen
					Pane root2 = new Pane();					
					Scene scene2 = new Scene(root2, 650, 300);
					Stage popup_Stage = new Stage();
					
					//Declaring a new button that will allow user to return to elective list
					Button close_description4 = new Button ("RETURN");
					
					//Setting style and font of the button
					close_description4.setStyle("-fx-text-fill: black");
					close_description4.setStyle("-fx-font-weight: bold");
					close_description4.setFont(Font.font("Times New Roman", 50));	
					
					//Setting the (x,y) location of the return button on the second pop-up screen
					close_description4.setLayoutX(200);
					close_description4.setLayoutY(250);		
					
					//Code to be executed when return button is clicked
					close_description4.setOnAction(new EventHandler<ActionEvent>(){	
						public void handle(ActionEvent event) {	
							
							//Close second pop-up screen to go back to elective list
							popup_Stage.close();
						}
					});

					//For each loop to display the course times on the second pop-up screen
					for (String s:t) {
						
						//Declaring a new label that will display the course times 
						Label course_time2 = new Label();
						
						//Setting the (x,y) location of the label on the second screen (y is variable)
						course_time2.setLayoutX(15);
						course_time2.setLayoutY(y_location);
						
						//Incrementing the y variable so the course times move down the screen3
						y_location = y_location + 50;
						
						//Setting the style and font of the label
						course_time2.setStyle("-fx-font-weight: bold");
						course_time2.setStyle("-fx-text-fill: black");
						course_time2.setFont(Font.font("Cambria Math", 18));
						
						//Setting text of the label from the Array that stored the split strings
						course_time2.setText(s);
						
						//Adding the label to the ArrayList to be displayed to the screen
						choices2.add(course_time2);

						//Adding the label to the second pop-up screen
						root2.getChildren().add(course_time2);
					}	
					
					//Adding all the labels and buttons to the second pop-up screen
					root2.getChildren().add(close_description4);
					root2.getChildren().add(course_title5);
					
					//Setting the scene and displaying the second pop-up screen
					popup_Stage.setScene(scene2);					
					popup_Stage.show();

				}
			});

		}

		//Declaring a new button that will allow user to return to the main course selector screen
		Button return_choices = new Button ("RETURN TO COURSE SELECTION");
		
		//Setting (x,y) location of button on screen
		return_choices.setLayoutX(350);
		return_choices.setLayoutY(2600);
		
		//Setting style and font of button
		return_choices.setStyle("-fx-text-fill: black");
		return_choices.setFont(Font.font("Franklin Gothic Heavy", 27));
		
		//Code to be executed when button is clicked
		return_choices.setOnAction(new EventHandler <ActionEvent>() {
			public void handle(ActionEvent event) {
				
				//Creating a new object of the class of the screen to be shown
				McMaster_Year1_Fall m = new McMaster_Year1_Fall();
				
				//Show new screen and close current screen
				primaryStage.getScene().setRoot(m.getRootPane());
				primaryStage.close();
			}
		});
		
		
		//Declaring a new ScrollBar object to make screen scrollable
		ScrollBar sc = new ScrollBar();
		
		//Setting the orietnation of the ScrollBar as vertical
		sc.setOrientation(Orientation.VERTICAL);

		//Declaring the root and Scene for this screen
		Group root = new Group();
		Scene scene = new Scene(root, 1275, 900);
		
		//Setting various properties of the ScrollBar
		//Position on screen, minimum value, how far it goes, its colour and maximum value
		sc.setLayoutX(scene.getWidth()-sc.getWidth());
		sc.setMin(0);
		sc.setPrefHeight(2050);
		scene.setFill(Color.WHITE);
		sc.setMax(1850);
		
		//Setting the scene of this screen
		primaryStage.setScene(scene);
		
		//Adding all the objects to the screen to be displayed
		root.getChildren().add(sc);
		root.getChildren().add(electives);
		root.getChildren().add(selectedImage);
		root.getChildren().add(year1fall_title);
		root.getChildren().addAll(elective_courses1);
		root.getChildren().addAll(elective_courses2);
		root.getChildren().addAll(elective_view_description);
		root.getChildren().addAll(elective_view_description2);
		root.getChildren().addAll(view_times);
		root.getChildren().addAll(choices);
		root.getChildren().addAll(view_times2);
		root.getChildren().addAll(choices2);
		root.getChildren().add(return_choices);
		
		//Setting the value of the ScrollBar so the ScrollBar goes to the correct height
		sc.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {
				root.setLayoutY(-new_val.doubleValue());
			}
		});
		
		//Showing this screen
		primaryStage.show();

	}
	
	//Getter for rootPane - this allows the switching of screens from one to another
	public ScrollPane getRootPane() {
		return rootPane;
	}
}
