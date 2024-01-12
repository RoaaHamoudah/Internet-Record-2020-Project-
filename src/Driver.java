
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Driver extends Application {

	static Alert alert = new Alert(AlertType.WARNING);

	static Internet2020RecordList listObj = new Internet2020RecordList();
	static FileChooser fc = new FileChooser();
	static File file;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane upperGP = new GridPane();
		upperGP.setHgap(15);
		upperGP.setVgap(15);
		upperGP.setPadding(new Insets(10, 10, 10, 10));

		Label loadFile = new Label("Load File:");
		Label selectOption = new Label("Select Option:");
		Button loadBtn = new Button("Load");

		upperGP.add(loadFile, 0, 0);
		upperGP.add(selectOption, 0, 1);
		upperGP.add(loadBtn, 1, 0);

		ToggleGroup tg = new ToggleGroup();
		RadioButton insertRB = new RadioButton("Insert");
		RadioButton deleteRB = new RadioButton("Delete");
		RadioButton searchRB = new RadioButton("Search");
		RadioButton displayRB = new RadioButton("Display");
		tg.getToggles().addAll(insertRB, deleteRB, searchRB, displayRB);

		HBox hb = new HBox(10);
		hb.getChildren().addAll(insertRB, deleteRB, searchRB, displayRB);
		upperGP.add(hb, 1, 1);

		Label countryNameL = new Label("Country Name:");
		Label percentageOfInternetUsersL = new Label("percentage Of Internet Users:");

		TextField countryNameTF = new TextField();
		TextField percentageOfInternetUsersTF = new TextField();

		Button insertBtn = new Button("Insert");
		Button deleteBtn = new Button("Delete");
		Button searchBtn = new Button("Search");
		Button displayBtn = new Button("Display");

		Label printRes = new Label();
		printRes.setFont(new Font("New Arial", 15));
		printRes.setTextFill(Color.BLUE);

		GridPane lowerGP = new GridPane();
		lowerGP.setVgap(15);
		lowerGP.setHgap(15);
		lowerGP.setPadding(new Insets(10, 10, 10, 10));

		TableView<Internet2020Record> tv = new TableView<>();
		TableColumn<Internet2020Record, String> country_name_clm = new TableColumn<>("Country name");
		country_name_clm.setCellValueFactory(new PropertyValueFactory("countryName"));

		TableColumn<Internet2020Record, String> percentage_Of_Internet_Users_clm = new TableColumn<>(
				"percentage Of Internet Users");
		percentage_Of_Internet_Users_clm.setCellValueFactory(new PropertyValueFactory("percentageOfInternetUsers"));

		tv.getColumns().addAll(country_name_clm, percentage_Of_Internet_Users_clm);
		tv.setColumnResizePolicy(tv.CONSTRAINED_RESIZE_POLICY);

		Label specificPercentageL = new Label("Enter the specific percentage:");
		TextField specificPercentageTF = new TextField();

		BorderPane BPane = new BorderPane();
		BPane.setCenter(lowerGP);

		alert.setTitle("Warning");
		alert.setHeaderText("This is a warning");

		Button backBtn = new Button("Back");

		loadBtn.setOnAction(e -> {
			if (readInternetFile()) {
				printRes.setText("File loaded successfully!");
			} else {
				alert.setContentText("Select a file.");
				alert.showAndWait();
			}
		});

		insertBtn.setOnAction(e -> {
			String countryName = countryNameTF.getText().trim();
			double percentageOfInternetUsers = Double.parseDouble(percentageOfInternetUsersTF.getText().trim());
			if (listObj.insertCountry(new Internet2020Record(countryName, percentageOfInternetUsers))) {

				printRes.setTextFill(Color.BLUE);
				printRes.setText("Successfully added record.");
				updateDataFile();
				countryNameTF.clear();
				percentageOfInternetUsersTF.clear();
			} else {
				countryNameTF.clear();
				percentageOfInternetUsersTF.clear();
				alert.setContentText("Record already exits.");
				alert.showAndWait();
			}
		});

		deleteBtn.setOnAction(e -> {
			String countryName = countryNameTF.getText().trim();
			if (listObj.deleteCountry(countryName)) {
				printRes.setTextFill(Color.BLUE);
				printRes.setText("Successfully delete record.");
				updateDataFile();
				countryNameTF.clear();
			} else {
				countryNameTF.clear();
				alert.setContentText("Record not found.");
				alert.showAndWait();
			}
		});

		searchBtn.setOnAction(e -> {
			String countryName = countryNameTF.getText().trim();
			Internet2020Record record = listObj.search(countryName);
			if (record != null) {
				double percentageOfInternetUsers = record.getPercentageOfInternetUsers();
				String percentageOfInternetUsersText = String.valueOf(percentageOfInternetUsers);
				percentageOfInternetUsersTF.setText(percentageOfInternetUsersText);
			} else {
				percentageOfInternetUsersTF.setText("");
				alert.setContentText("Record not found.");
				alert.showAndWait();
			}
		});

		displayBtn.setOnAction(e -> {
			try {
				double specificPercentage = Double.parseDouble(specificPercentageTF.getText().trim());

				tv.getItems().clear();
				Internet2020Record[] records = listObj.display(specificPercentage);

				if (records != null) {
					tv.getItems().setAll(records);
					lowerGP.getChildren().clear();
					BPane.setCenter(tv);

				}
				upperGP.add(backBtn, 4, 1);
			} catch (Exception e1) {

			}
		});

		insertRB.setOnAction(e -> {
			lowerGP.getChildren().clear();
			BPane.getChildren().clear();
			printRes.setText("");

			percentageOfInternetUsersTF.setEditable(true);

			lowerGP.add(countryNameL, 0, 0);
			lowerGP.add(percentageOfInternetUsersL, 0, 1);
			countryNameTF.clear();
			percentageOfInternetUsersTF.clear();
			lowerGP.add(countryNameTF, 1, 0);
			lowerGP.add(percentageOfInternetUsersTF, 1, 1);
			lowerGP.add(printRes, 1, 4);
			lowerGP.add(insertBtn, 1, 2);
			BPane.getChildren().add(lowerGP);
		});

		deleteRB.setOnAction(e -> {
			lowerGP.getChildren().clear();
			BPane.getChildren().clear();
			printRes.setText("");
			countryNameTF.clear();
			percentageOfInternetUsersTF.clear();

			lowerGP.add(countryNameL, 0, 0);
			lowerGP.add(countryNameTF, 1, 0);
			lowerGP.add(printRes, 1, 3);
			lowerGP.add(deleteBtn, 1, 2);
			BPane.getChildren().add(lowerGP);

		});

		searchRB.setOnAction(e -> {
			lowerGP.getChildren().clear();
			BPane.getChildren().clear();
			printRes.setText("");
			countryNameTF.clear();
			percentageOfInternetUsersTF.clear();

			percentageOfInternetUsersTF.setEditable(false);
			lowerGP.add(countryNameL, 0, 0);
			lowerGP.add(percentageOfInternetUsersL, 0, 1);
			lowerGP.add(countryNameTF, 1, 0);
			lowerGP.add(percentageOfInternetUsersTF, 1, 1);
			lowerGP.add(printRes, 1, 4);
			lowerGP.add(searchBtn, 1, 2);
			BPane.getChildren().add(lowerGP);
		});

		displayRB.setOnAction(e -> {
			lowerGP.getChildren().clear();
			BPane.getChildren().clear();
			printRes.setText("");
			specificPercentageTF.clear();

			lowerGP.add(specificPercentageL, 0, 0);
			lowerGP.add(specificPercentageTF, 1, 0);
			lowerGP.add(displayBtn, 1, 2);
			BPane.getChildren().add(lowerGP);
		});

		backBtn.setOnAction(e -> {
			lowerGP.getChildren().clear();
			BPane.getChildren().clear();
			printRes.setText("");
			specificPercentageTF.clear();
			lowerGP.add(specificPercentageL, 0, 0);
			lowerGP.add(specificPercentageTF, 1, 0);
			lowerGP.add(displayBtn, 1, 2);
			BPane.getChildren().add(lowerGP);

		});

		VBox mainLayout = new VBox(upperGP, BPane);
		mainLayout.setSpacing(15);
		mainLayout.setPadding(new Insets(15));
		Scene scene = new Scene(mainLayout, 550, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Internet 2020 Record");
		primaryStage.show();

	}

	// uploadAndReadRecord method to upload a record from the file and read it.
	public void uploadAndReadRecord(String line) {
		String[] arr = line.split(",");
		if (arr.length != 2)
			return;
		String countryName = arr[0].trim();
		double percentageOfInternetUsers = Double.parseDouble(arr[1].trim());
		Internet2020Record record = new Internet2020Record(countryName, percentageOfInternetUsers);
		listObj.insertCountry(record);

	}

	// readInternetFile method to read the chooser file.
	public boolean readInternetFile() {
		file = fc.showOpenDialog(null);
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				uploadAndReadRecord(line);
			}

		} catch (Exception e1) {
			System.out.println("File not found");
			return false;
		}

		return true;
	}

	// update Data File method to update the chooser file after adding and deleting
	// operations.
	public boolean updateDataFile() {
		try {
			PrintWriter write = new PrintWriter(file);
			for (int i = 0; i < listObj.list.length; i++) {
				if (listObj.list[i] != null && listObj.list[i].getCountryName() != null) {
					write.println(listObj.list[i]);
				}
			}

			write.close();
			System.out.println("Data file updated successfully.");
		} catch (IOException e) {
			System.out.println("Error: Failed to update data file.");
			return false;
		}

		return true;

	}
}