/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Nicholas Smarsh
 */

package ucf.assignments;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.time.LocalDate;

public class mainMenuController extends Application{
    //start up for program
    @Override
    public void start(Stage primaryStage) throws Exception {
        //launches the mainMenu gui
        FXMLLoader mainMenuFxmlLoader = new FXMLLoader(App.class.getResource("mainMenu_gui_AS4.fxml"));
        Scene scene = new Scene(mainMenuFxmlLoader.load(), 600, 400);
        primaryStage.setTitle("Todo List Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    //initial buttons and thingies in the main menu gui
    @FXML
    private Menu menuBar;

    @FXML
    private MenuItem Open;

    @FXML
    private MenuItem delete;

    @FXML
    private MenuItem edit;

    @FXML
    private Menu newTodo;

    @FXML
    private MenuItem save;

    @FXML
    private MenuItem saveAll;

    @FXML
    private TableView todoTable = new TableView();

    //when the button is clicked
    @FXML
    void newTodoCreateClicked(ActionEvent event) throws Exception {
        //this is what runs when the newTodo is clicked
        FXMLLoader createTodoFxmlLoader = new FXMLLoader(App.class.getResource("createNewTodo_gui_AS4.fxml"));
        Scene newTodoScene = new Scene(createTodoFxmlLoader.load(), 600, 400);
        Stage newTodoCreatorStage = new Stage();
        newTodoCreatorStage.setScene(newTodoScene);
        newTodoCreatorStage.show();

    }
        //things for when newTodoCreate is clicked
        @FXML
        private Button createTodoButton;

        @FXML
        private DatePicker createTodoDate;

        @FXML
        private TextArea createTodoDescription;

        @FXML
        private TextField createTodoName;

        @FXML
        void createTodoButtonClicked(ActionEvent event) throws IOException {
            //get data from the createNewTodo gui
            String newTodoName = createTodoName.getText();
            String newTodoDesc = createTodoDescription.getText();
            LocalDate newTodoDate = createTodoDate.getValue();

            //now paste this data into a todoList class
            todoList temp = new todoList();
            temp.date = newTodoDate;
            temp.name = newTodoName;
            temp.todoListDescription = newTodoDesc;

            //TEST
            System.out.println(temp.date +"\n");
            System.out.println(temp.name +"\n");
            System.out.println(temp.todoListDescription +"\n");

            //now present this todoList into the mainMenu Gui
            addNewTodoList(temp);

            //close the input window

        }

    //add the data from the todoList temp to the mainMenu gui
    @FXML
    private TableColumn<todoList, LocalDate> dueDate;
    @FXML
    private TableColumn<todoList, String> todoName;
    @FXML
    private TableColumn<todoList, String> todoDescription;

    @FXML
    void addNewTodoList(todoList temp) {
      // dueDate.setText(String.valueOf(temp.date));
    }

}

