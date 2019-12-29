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
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class McMaster_Year1_Fall {
	//This code is used in the switching of screens
	//Declaring a rootPane variable of object type Pane
	private final Pane rootPane;
	
	//Declaring a new root object of type Pane
	Pane root = new Pane();

	//Constructor for the class - allows for switching of screens
	public McMaster_Year1_Fall() {
		
		//Declaring a new BorderPane and Stage for the screen
		rootPane = new BorderPane();
		Stage primaryStage = new Stage();
		
		//Setting the title of the screen
		primaryStage.setTitle("McMaster Software Engineering Year 1 Fall");
		
		//Declaring a new ImageView object of name selectedImage
		ImageView selectedImage = new ImageView();		

		//Declaring the MyCourses logo image as a new image
		Image logo = new Image("/img/MyCourses Logo.png");	

		//Setting the ImageView object to the just created logo image
		selectedImage.setImage(logo);

		//Setting the (x,y) location of the image on the screen
		selectedImage.setLayoutX(315);
		selectedImage.setLayoutY(5);

		//Declaring a new Label object for the title at top of the screen
		Label year1fall_title = new Label("YEAR 1 FALL");
		
		//Setting the style and font of the text of the label
		year1fall_title.setStyle("-fx-font-weight: bold");
		year1fall_title.setStyle("-fx-text-fill: black");
		year1fall_title.setFont(Font.font("Franklin Gothic Heavy", 40));
		
		//Setting the (x,y) location of the label on the screen
		year1fall_title.setLayoutX(325);
		year1fall_title.setLayoutY(135);
		
		//Declaring a new Label object for the column heading for the required courses
		Label required_courses = new Label ("Required Courses");
		
		//Setting the style and font of the text of the label
		required_courses.setStyle("-fx-font-weight: bold");
		required_courses.setUnderline(true);
		required_courses.setStyle("-fx-text-fill: black");
		required_courses.setFont(Font.font("Times New Roman", 25));
		
		//Setting the (x,y) location of the label on the screen
		required_courses.setLayoutX(120);
		required_courses.setLayoutY(200);
		
		//Declaring a new Label object for the column heading for the elective courses
		Label electives = new Label ("Electives");
		
		//Setting the style and font of the text of the label
		electives.setStyle("-fx-font-weight: bold");
		electives.setUnderline(true);
		electives.setStyle("-fx-text-fill: black");
		electives.setFont(Font.font("Times New Roman", 25));
		
		//Setting the (x,y) location of the label on the screen
		electives.setLayoutX(650);
		electives.setLayoutY(200);
		
		//Declaring two new Label objects used in the elective courses column
		//Used to tell user how to view electives
		Label elective_descrip1 = new Label();
		Label elective_descrip2 = new Label();

		//Creating an array of Label objects made up of the declared labels
		final Label[] elective_description = new Label[]{elective_descrip1, elective_descrip2};
		
		//Using a for loop to set various properties of the labels
		for (int i = 0; i < elective_description.length; i++) {
			
			//Setting the style and font of the text of the labels
			elective_description[i].setStyle("-fx-font-weight: bold");
			elective_description[i].setStyle("-fx-text-fill: black");
			elective_description[i].setFont(Font.font("Cambria Math", 18));
			
			//Setting the x location of both labels
			//Set in for loop because it is the same value for both labels
			elective_description[i].setLayoutX(520);
		}
		
		//Setting the text of the individual labels
		//As well as setting the y values of both labels as they are different
		elective_description[0].setText("You will be taking one elective in this semester.");
		elective_description[0].setLayoutY(250);
		elective_description[1].setText("Click below to view the list of available electives:");
		elective_description[1].setLayoutY(285);
		
		//Declaring 4 new Label objects for the 4 required courses
		Label course1 = new Label();
		Label course2 = new Label();
		Label course3 = new Label();
		Label course4 = new Label();
		
		//Creating an array of Label objects composed of the pre-declared labels
		final Label[] year1_fall_courses = new Label[]{course1, course2, course3, course4};
		
		//String variable to store text from text file
		String line;
		
		//Try-Catch block to read text file
		//This file reads in the titles of the required courses to be printed to the screen in the form of labels
		try {

			//Creating a new file reader and buffered reader
			FileReader fr = new FileReader("src/Text Files Needed/McMaster Year 1 Fall Courses.txt");
			BufferedReader br = new BufferedReader(fr);
			
			//Declaring an integer that will be incremented each time a line is read
			//Used to move through the array
			int i = 0;

			//While loop to read in the data
			while ((line = br.readLine()) != null)  {
				
				//Assigning the line in the text file to the correct position in the array
				year1_fall_courses[i].setText(line);
				
				//Increment the array index variable
				i++;
			} 
			
		//Catch block to make sure file is read correctly	
		}catch (Exception e) {
			System.out.println("Error reading file");
		}
		
		//Declaring two new String arrays to store the course title and description
		//This will be used when the user wants to view the description of a course
		final String[] year1_fall_courses_descriptions = new String[4];
		final String[] year1_fall_courses_title = new String[4];
		
		//Declaring variables to store lines from text file
		String description;
		String title;
		
		//Try-Catch block to read data from text file
		try {

			//Creating a new file reader and buffered reader
			FileReader fr = new FileReader("src/Text Files Needed/McMaster Year 1 Fall Courses Descriptions.txt");
			BufferedReader br = new BufferedReader(fr);
			
			//Declaring an integer that will be incremented to loop through array
			int i = 0;

			//While loop to read two lines at a time
			while ((title = br.readLine())!= null && (description = br.readLine()) != null) {
				
				//Assigning the data from the text file to the corresponding position in the two arrays
				year1_fall_courses_descriptions[i] = description;		
				year1_fall_courses_title[i] = title;
				
				//Increment the index variable to go to next position in the arrays 
				i++;
			} 
			
		//Catch block to make sure file is read correctly
		}catch (Exception e) {
			System.out.println("Error reading file");
		}
		
		//Declaring an initial location for the y variable 
		int y_location = 250;
		
		//For loop to loop through and set properties of the array
		for (int i = 0; i < year1_fall_courses.length; i++) {
			
			//Setting the y location of the title using the variable that will be incremented each time the loop runs through
			year1_fall_courses[i].setLayoutY(y_location);			
			
			//Incrementing the y location by 100 so the title moves down the screen
			y_location = y_location + 100;
			
			//Setting the x location of the variable on the screen
			year1_fall_courses[i].setLayoutX(10);
			
			//Setting the style and font of the text of the label
			year1_fall_courses[i].setStyle("-fx-font-weight: bold");
			year1_fall_courses[i].setStyle("-fx-text-fill: black");
			year1_fall_courses[i].setFont(Font.font("Cambria Math", 18));	

		}
		
		//Declaring 4 button objects that will be used to allow user to view description of each course
		Button view_descrip1 = new Button("View Description");
		Button view_descrip2 = new Button("View Description");
		Button view_descrip3 = new Button("View Description");
		Button view_descrip4 = new Button("View Description");
		
		//Declaring an array of button objects using the just created buttons
		final Button[] view_description = new Button[] {view_descrip1, view_descrip2, view_descrip3, view_descrip4};
		
		//Declaring the initial y position of the button
		int view_descrip_y_location = 275;
		
		//For loop to loop through and set properties of the buttons
		for (int i = 0; i < view_description.length; i++) {	
			
			//Setting the y location of the button using the variable
			view_description[i].setLayoutY(view_descrip_y_location);
			
			//Incrementing the y variable to move the button down the screen
			view_descrip_y_location = view_descrip_y_location + 100;
			
			//Setting the x location of the buttons on the screen
			view_description[i].setLayoutX(25);
			
			//Setting the style and font of the text of the buttons
			view_description[i].setStyle("-fx-font-weight: bold");
			view_description[i].setStyle("-fx-text-fill: black");
			view_description[i].setFont(Font.font("Cambria Math", 16));
			
			//Creating a new label with the String from the text file that was stored in the array
			Label course_title = new Label(year1_fall_courses_title[i]);
			
			//Setting the style, font and positioning of the label
			course_title.setStyle("-fx-font-weight: bold");
			course_title.setStyle("-fx-text-fill: black");
			course_title.setFont(Font.font("Cambria Math", 18));
			course_title.setTextAlignment(TextAlignment.CENTER);
			course_title.setUnderline(true);
			
			//Setting the (x,y) location of the label in the second pop-up screen
			course_title.setLayoutX(10);
			course_title.setLayoutY(5);
			
			//Creating a new label with the String from the text file that was stored in the array
			Label course_description = new Label(year1_fall_courses_descriptions[i]);
			
			//Setting the style and font of the label
			course_description.setStyle("-fx-font-weight: bold");
			course_description.setStyle("-fx-text-fill: black");
			course_description.setFont(Font.font("Cambria Math", 18));
			course_description.setWrapText(true);
			
			//Setting the width of the label so the text will wrap if it exceeds
			course_description.setMaxWidth(290);
			
			//Setting the (x,y) location of the label in the second pop-up screen
			course_description.setLayoutX(10);
			course_description.setLayoutY(35);
			
			//Code to be executed when the description button is clicked
			view_description[i].setOnAction(new EventHandler<ActionEvent>(){	
				public void handle(ActionEvent event) {		
					
					//Declaring a new root, stage and scene for the new screen that will appear when the button is clicked
					Pane root2 = new Pane();					
					Scene scene2 = new Scene(root2, 300, 300);
					Stage popup_Stage = new Stage();
					
					//Declaring a new button object that will allow user to return to course list
					Button close_description = new Button ("RETURN");
					
					//Setting style and font of the button
					close_description.setStyle("-fx-text-fill: black");
					close_description.setStyle("-fx-font-weight: bold");
					close_description.setFont(Font.font("Times New Roman", 50));
					
					//Setting the (x,y) location of the button on the second pop-up screen
					close_description.setLayoutX(100);
					close_description.setLayoutY(250);	
					
					//Code to be executed when return button is clicked
					close_description.setOnAction(new EventHandler<ActionEvent>(){	
						public void handle(ActionEvent event) {	
							
							//Close the second screen to return to elective list
						popup_Stage.close();
						}
					});
					
					//Adding all the labels and buttons to the second screen
					root2.getChildren().add(course_title);
					root2.getChildren().add(course_description);
					root2.getChildren().add(close_description);
					
					//Setting the stage and showing the second screen
					popup_Stage.setScene(scene2);					
					popup_Stage.show();
				}
			});
		}
		
		//Declaring variables to read data from the text file
		String title2;
		String times;
		
		//Declaring two new String arrays to store data read in from text file
		String[] course_titles = new String[4];
		String[] course_times = new String[4];
		
		//Creating an ArrayList to store the various times available for each course
		ArrayList<Label> choices = new ArrayList<Label>();
		
		//Declaring an integer that will be incremented to loop through the array
		int x = 0;
		
		//Try-Catch block to read data from text file
		try {

			//Creating a new file reader and buffered reader
			FileReader fr = new FileReader("src/Text Files Needed/McMaster Year 1 Fall Course Times.txt");
			BufferedReader br = new BufferedReader(fr);

			//While loop to read two lines at a time
			while ((title2 = br.readLine())!= null && (times = br.readLine()) != null)  {
				
				//Assigning the data from the text file to the correct spot in the arrays
				course_titles[x] = title2;
				course_times[x] = times;
				
				//Incrementing the index variable to move to the next position in the array
				x++;
			} 
			
			//Catch Block to make sure text file is read correctly
		}catch (Exception e) {
			System.out.println("Error reading file");
		}
		
		//Declaring 4 new buttons to allow user to view the times that each course is offered
		Button view_times1 = new Button("View Times");
		Button view_times2 = new Button("View Times");
		Button view_times3 = new Button("View Times");
		Button view_times4 = new Button("View Times");
		
		//Declaring a new array of type Button composed of the just created buttons
		final Button[] view_times = new Button[] {view_times1, view_times2, view_times3, view_times4};
		
		//Declaring an initial y location for the buttons
		int view_times_y_location = 275;
		
		//For loop to loop through and set properties of the buttons
		for (int i = 0; i < view_times.length; i++) {
			
			//Setting the y location of the button using the variable
			view_times[i].setLayoutY(view_times_y_location);		
			
			//Incrementing the y variable to move the buttons down the screen
			view_times_y_location = view_times_y_location + 100;
			
			//Setting the x location of the buttons
			view_times[i].setLayoutX(200);
			
			//Setting the style and font of the buttons
			view_times[i].setStyle("-fx-font-weight: bold");
			view_times[i].setStyle("-fx-text-fill: black");
			view_times[i].setFont(Font.font("Cambria Math", 16));
			
			//Splitting the string from the array into the various times the course is offered
			String [] t = course_times[i].split(",");
			
			//Creating a new Label object to display the title of the course in the second pop-up screen
			Label course_title4 = new Label(course_titles[i]);
			
			//Setting style and font of the label
			course_title4.setStyle("-fx-font-weight: bold");
			course_title4.setStyle("-fx-text-fill: black");
			course_title4.setFont(Font.font("Cambria Math", 18));
			course_title4.setTextAlignment(TextAlignment.CENTER);
			course_title4.setUnderline(true);
			
			//Setting the (x,y) location of the label in the second pop-up screen
			course_title4.setLayoutX(10);
			course_title4.setLayoutY(5);
			
			//Code that will execute when the buttons are clicked
			view_times[i].setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					
					//Declaring the initial y location for the course times
					int y_location = 35;
					
					//Declaring a new Pane, Scene and Stage for the second pop-up screen
					Pane root2 = new Pane();					
					Scene scene2 = new Scene(root2, 650, 300);
					Stage popup_Stage = new Stage();
					
					//Creating a button to allow user to return to the course list
					Button close_description3 = new Button ("RETURN");
					
					//Setting style and font of the button
					close_description3.setStyle("-fx-text-fill: black");
					close_description3.setStyle("-fx-font-weight: bold");
					close_description3.setFont(Font.font("Times New Roman", 50));
					
					//Setting the (x,y) location of the button on the second pop-up screen
					close_description3.setLayoutX(200);
					close_description3.setLayoutY(250);					
					
					//Code to be executed when return button is clicked
					close_description3.setOnAction(new EventHandler<ActionEvent>(){	
						public void handle(ActionEvent event) {	
							
							//Pop-up screen is closed so user is returned to course list
							popup_Stage.close();
						}
					});

					//For each loop to display the various times of the course on the screen
					for (String s:t) {
						
						//Declaring a new label to show the course times
						Label course_time = new Label();
						
						//Setting the (x,y) location of the course time label on the screen
						course_time.setLayoutX(15);
						course_time.setLayoutY(y_location);
						
						//Setting the style, font, and text of the label
						course_time.setStyle("-fx-font-weight: bold");
						course_time.setStyle("-fx-text-fill: black");
						course_time.setFont(Font.font("Cambria Math", 18));
						course_time.setText(s);
						
						//Incrementing the y variable so the course times appear down the screen
						y_location = y_location + 50;
						
						//Add the label to the ArrayList of labels
						choices.add(course_time);
						
						//Display the label onto the screen
						root2.getChildren().add(course_time);
					}	
					
					//Display all the labels and buttons on the screen
					root2.getChildren().add(close_description3);
					root2.getChildren().add(course_title4);
					
					//Setting the scene for the second window and showing the second window with the course times
					popup_Stage.setScene(scene2);					
					popup_Stage.show();
				}
			});
		}	
		
		//Declaring a new button for the user to view all the electives available
		Button view_electives = new Button("VIEW ELECTIVES");
		
		//Setting the style and font of the text of the button
		view_electives.setStyle("-fx-font-weight: bold");
		view_electives.setStyle("-fx-text-fill: black");
		view_electives.setFont(Font.font("Cambria Math", 25));
		
		//Setting the (x,y) location of the button on the screen
		view_electives.setLayoutX(600);
		view_electives.setLayoutY(325);
		
		//Code to be executed when button is clicked
		view_electives.setOnAction(new EventHandler<ActionEvent>(){	
			public void handle(ActionEvent event) {	
				
				//Declaring a new object for the class that will appear
				McMaster_Year1_Fall_Electives m = new McMaster_Year1_Fall_Electives();
				
				//Go to the new screen and close the current one
				primaryStage.getScene().setRoot(m.getRootPane());
				primaryStage.close();
			}
		});
		
		//Declaring the scene for this screen
		Scene scene = new Scene(root, 900, 900);
		
		//Setting the colour of the background of the screen
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		//Adding all the objects to the screen
		root.getChildren().add(selectedImage);
		root.getChildren().add(year1fall_title);
		root.getChildren().add(required_courses);
		root.getChildren().add(electives);
		root.getChildren().addAll(elective_description);
		root.getChildren().addAll(year1_fall_courses);
		root.getChildren().addAll(view_description);
		root.getChildren().addAll(view_times);
		root.getChildren().add(view_electives);
		root.getChildren().addAll(choices);
		
		//Setting the scene and showing the screen
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//Getter for rootPane - this allows the switching of screens from one to another
	public Pane getRootPane() {
		return rootPane;
	}
}
