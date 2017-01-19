package de.hhbk.iho.Rennwagen_V3;

import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class Main extends Application
{
	private static int id_sequence = 0;
	private Scene scene;
	private GridPane grid = new GridPane();
	
	private Text headline = new Text("Rennwagen V3");
	
	private TextField txtModell = new TextField();
	private TextField txtHersteller = new TextField();
	private TextField txtLeistung = new TextField();
	private TextField txtHubraum = new TextField();
	private TextField txtMaximalerTankinhalt = new TextField();
	private TextField txtAktuellerTankinhalt = new TextField();
	
	private Label lblIdOutput = new Label("");
	private Label lblId = new Label("ID");
	private Label lblModell = new Label("Modell");
	private Label lblHersteller = new Label("Hersteller");
	private Label lblLeistung = new Label("Leistung");
	private Label lblHubraum = new Label("Hubraum");
	private Label lblMaximalerTankinhalt = new Label("Maximaler Tankinhalt");
	private Label lblAktuellerTankinhalt= new Label("Aktueller Tankinhalt");
	
	private Button btnSpeichern = new Button("Speichern");
	private Button btnEnde = new Button("Ende");
	
	private ObservableList<Rennwagen> items = FXCollections.observableArrayList();
	private ListView<Rennwagen> listView = new ListView<>();
	private Rennwagen rennwagen;
	
    public static void main( String[] args )
    {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {

		listView.setItems(this.items);
		listView.setOnMouseClicked(event -> this.onEdit(event));
		
		
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(15, 15, 45, 15));
		grid.setHgap(15);
		grid.setVgap(10);
		
		headline.setId("headline");
		
		grid.add(headline, 0, 0);
		grid.add(lblId, 0, 2);
		grid.add(lblIdOutput, 1, 2);
		grid.add(lblModell, 0, 3);
		grid.add(txtModell, 1, 3);
		grid.add(lblHersteller, 0, 4);
		grid.add(txtHersteller, 1, 4);
		grid.add(lblLeistung, 0, 5);
		grid.add(txtLeistung, 1, 5);
		grid.add(lblHubraum, 0, 6);
		grid.add(txtHubraum, 1, 6);
		grid.add(lblMaximalerTankinhalt, 0, 7);
		grid.add(txtMaximalerTankinhalt, 1, 7);
		grid.add(lblAktuellerTankinhalt, 0, 8);
		grid.add(txtAktuellerTankinhalt, 1, 8);
		grid.add(btnSpeichern, 0, 9);
		grid.add(btnEnde, 1, 9);
		grid.add(listView, 0, 10, 2, 1);
	
		btnSpeichern.setOnAction(event -> this.onSave(event));
		btnEnde.setOnAction(event -> this.onEnd(event));
		
		this.scene = new Scene(grid, 400, 500);
		scene.getStylesheets().add(this.getClass().getResource("Main.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Rennwagen V3");
		primaryStage.show();
	}
	
	private void onSave(ActionEvent event) {
		try {
			List<TextField> fieldList = grid.getChildren()
					.stream()
					.filter(p -> p instanceof TextField)
					.map(p -> (TextField) p)
					.collect(Collectors.toList());
			
			for (TextField field : fieldList) {
				if (field.getText().trim().equals("")) {
					throw new Exception();
				}
			}
			
			this.rennwagen.setModell(txtModell.getText());
			this.rennwagen.setHersteller(txtHersteller.getText());
			this.rennwagen.setLeistung(Double.parseDouble(this.txtLeistung.getText()));
			this.rennwagen.setHubraum(Double.parseDouble(this.txtHubraum.getText()));
			this.rennwagen.setMaximalerTankinhalt(Double.parseDouble(this.txtMaximalerTankinhalt.getText()));
			this.rennwagen.setAktuellerTankinhalt(Double.parseDouble(this.txtAktuellerTankinhalt.getText()));
			this.items.add(this.rennwagen);
			
			this.clearFields();
			this.listView.getSelectionModel().clearSelection();
			
		} catch (Exception e) {
			this.showAlert(AlertType.ERROR, "Bitte füllen Sie alle Felder aus."
					+ "\nBeachten Sie, dass die Felder Leistung, Hubraum,"
					+ "\nmaximaler Tankinhalt und aktueller Tankinhalt numerische Felder sind.");
		}
		
	}
	
	private void onEnd(ActionEvent event) {
		
		
	}
	
	private void clearFields() {
		List<TextField> fieldList = grid.getChildren()
				.stream()
				.filter(p -> p instanceof TextField)
				.map(p -> (TextField) p)
				.collect(Collectors.toList());
		
		for (TextField field : fieldList) {
			field.clear();
		}
		lblIdOutput.setText("");
	}
	
	private void onEdit(MouseEvent event) {
		this.rennwagen = listView.getSelectionModel().getSelectedItem();
		this.displayRennwagen();
	}
	
	private void displayRennwagen() {
		lblIdOutput.setText(this.rennwagen.getId() + "");
		txtModell.setText(this.rennwagen.getModell());
		txtHersteller.setText(this.rennwagen.getHersteller());
		txtLeistung.setText(this.rennwagen.getLeistung().toString());
		txtHubraum.setText(this.rennwagen.getHubraum().toString());
		txtMaximalerTankinhalt.setText(this.rennwagen.getMaximalerTankinhalt().toString());
		txtAktuellerTankinhalt.setText(this.rennwagen.getAktuellerTankinhalt().toString());
	}
	
	private void showAlert(AlertType alertType, String contentText) {
		Alert alert = new Alert(alertType);
		alert.setTitle("Rennwagen V3");
		alert.setContentText(contentText);
		alert.showAndWait();
	}
}
