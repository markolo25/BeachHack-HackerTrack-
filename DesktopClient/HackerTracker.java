/*
 * Self-reported productivity timer
 * By: Jenny Wong
 */

import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;
import java.io.*;

public class HackerTracker extends Application
{

    // Fill colors for GUI
    private static final Color COLOR_EMPTY = Color.rgb(238, 228, 2);
    private static final Color COLOR_2 = Color.rgb(255, 202, 195); 

    private static final int FONT_SIZE = 35;
    private static final int BIG_FONT_SIZE = 45;

    private ArrayList<HTTimer> timers = new ArrayList<HTTimer>();


/* Method Name: start
 * Purpose: Create graphical user interface. Overrides start in Application 
 *          interface.
 * Parameters: Stage primaryStage - JavaFX stage
 * Return: void
 */
    @Override
    public void start(Stage primaryStage)
    {

        // Create a grid pane to to hold everything & add to scrollpane so we
        // can scroll if needed
        GridPane pane = new GridPane();
        ScrollPane scroll = new ScrollPane(pane);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        pane.setStyle("-fx-background-color: gold;"); // Background color
        pane.setHgap(10); // Horizontal gap
        pane.setVgap(10); // Vertical gap
        pane.setPadding(new Insets(10, 10, 10, 10));

        // Create and add title
        Label nameLabel = new Label("HackerTracker");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD,
                FontPosture.ITALIC, 15));
        pane.add(nameLabel, 0, 0);

        // Add first timer
        int num_timers = 1;
        Text name = new Text("Sample");
        Text txt = new Text("0:00");
        Button startButton = new Button("Go");
        Button stopButton = new Button("Stop");
        pane.add( name, 0, 1 );
        pane.add( txt, 1, 1 );
        pane.add( startButton, 2, 1);
        pane.add( stopButton, 3, 1);
        timers.add(new HTTimer(0));


        // Add a timer button and text field
        Button addTimer = new Button("+");
        TextField timerName = new TextField();
        pane.add( addTimer, 2, num_timers +1);
        pane.add( timerName, 0, num_timers+1);

        // Create and register add timer button handler
        addTimer.setOnAction(e -> {


            int row = pane.getRowIndex(addTimer);

            String timerText = timerName.getText();
            
            pane.getChildren().remove(addTimer);
            pane.getChildren().remove(timerName);

            Text txtname = new Text(timerText);
            Text txttime = new Text("0:00");
            Button start = new Button("Go");
            Button stop = new Button("Stop");

            pane.add( txtname, 0, row );
            pane.add( txttime, 1, row );
            pane.add( start, 2, row );
            pane.add( stop, 3, row );

            row++;
            pane.add( addTimer, 2, row );
            pane.add( timerName, 0, row );

        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(scroll);
        primaryStage.setTitle("Hacker Tracker Timer"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        scroll.requestFocus();
    }


 }
