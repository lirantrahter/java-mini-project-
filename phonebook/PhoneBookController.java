package Q2;

import java.util.Map;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

// the controller for the phonebook GUI
public class PhoneBookController {
    
    @FXML private TableView<Map.Entry<String, String>> table;
    @FXML private TableColumn<Map.Entry<String, String>, String> nameCol;
    @FXML private TableColumn<Map.Entry<String, String>, String>  phoneCol;
    @FXML private TextField addName;
    @FXML private TextField addPhone;
    @FXML private TextField deleteName;
    @FXML private TextField updateName;
    @FXML private TextField updatePhone;
    @FXML private TextField searchName;
    @FXML private TextField fileNameLoad;
    @FXML private TextField fileNameSave;
    private Alert error;
    private PhoneBook phoneBook;

    // constructor. inits the phone book and creates alerts
    public PhoneBookController() {
        phoneBook = new PhoneBook();
        error = new Alert(AlertType.ERROR);
    }

    // initializer. instructs the name and phonenumber collumns how to extract the data from the phonebook
    @FXML
    private void initialize() {
        table.setPlaceholder(new Label("There are no contacts to view"));
        nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey()));
        phoneCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue()));
    }
    
    // adds a contact to the phone book
    @FXML
    private void add() {
        try {
            phoneBook.add(addName.getText(), addPhone.getText());
        } catch (DuplicateContactException | InvalidPhoneNumException e) {
            error.setContentText(e.getMessage());
            error.show();
        }
        viewPhoneBook();
        addName.setText("");
        addPhone.setText("");
    }
    
    // deletes a contact from the phone book
    @FXML
    private void delete() {
        try {
            phoneBook.delete(deleteName.getText());
        } catch (ContactNotFoundException e) {
            error.setContentText(e.getMessage());
            error.show();
        }
        viewPhoneBook();
        deleteName.setText("");
    }
    
    // updates a contact in the phone  book
    @FXML 
    private void update() {
        try {
            phoneBook.update(updateName.getText(), updatePhone.getText());
        } catch (ContactNotFoundException | InvalidPhoneNumException e) {
            error.setContentText(e.getMessage());
            error.show();
        }
        viewPhoneBook();
        updateName.setText("");
        updatePhone.setText("");
    }

    // searches for a contact and shows him in the table if he was found.
    @FXML
    private void search() {
        table.getItems().clear();
        table.getItems().addAll(phoneBook.search(searchName.getText()).entrySet());
    }

    // clears the search box and shows the phone  book with no filters
    @FXML
    private void clear() {
        searchName.setText("");
        viewPhoneBook();
    }

    // show the updated phone book in the table view
    @FXML 
    private void viewPhoneBook() {
        table.getItems().clear();
        table.getItems().addAll(phoneBook.getPhoneBook().entrySet());
    }
    
}