package kompetencesystem.præsentation;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kompetencesystem.data.DataAccess;
import kompetencesystem.data.Database;
import kompetencesystem.domæne.Medarbejder;

public class Gui implements Initializable {

	@FXML
	private TextField txtnavn, txtafdeling, txtemail;

	@SuppressWarnings("rawtypes")
	@FXML
	private TableView TableView;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn viewNavn, viewEmail, viewAfdeling;
	@FXML
	private Group analyse, design, programering, afdeling;

	Database dbs = new Database();

	public void marker() {

		List<String> kompetence = new ArrayList<>();
		ObservableList<Node> boxes = analyse.getChildren();
		for (Node n : boxes) {
			CheckBox c = (CheckBox) n;
			if (c.isSelected()) {
				kompetence.add(c.getText());

			}
		}

		boxes = afdeling.getChildren();
		for (Node n : boxes) {
			CheckBox c = (CheckBox) n;
			if (c.isSelected()) {
				kompetence.add(c.getText());
			}
		}

		boxes = design.getChildren();
		for (Node n : boxes) {
			CheckBox c = (CheckBox) n;
			if (c.isSelected()) {
				kompetence.add(c.getText());

			}
		}
		boxes = programering.getChildren();
		for (Node n : boxes) {
			CheckBox c = (CheckBox) n;
			if (c.isSelected()) {
				kompetence.add(c.getText());

			}
		}

		ObservableList<Medarbejder> updateretList = dbs.refresh(kompetence);
		putInTable(updateretList);
	}

	ResultSet rs;

	DataAccess dataaccess = new DataAccess();
	Database db = new Database();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize(URL url, ResourceBundle rb) {

		ObservableList<Medarbejder> data = FXCollections.observableArrayList();

		try {
			Connection con = dataaccess.getConnection();

			PreparedStatement prep = con
					.prepareStatement("SELECT MEDARBEJDER.NAVN, EMAIL, MEDARBEJDER.AFDELING  FROM MEDARBEJDER");

			rs = prep.executeQuery();

			while (rs.next()) {

				data.add(new Medarbejder(rs.getString("navn"), rs.getString("email"), rs.getString("afdeling")));

			}

			viewNavn.setCellValueFactory(new PropertyValueFactory("navn"));
			viewEmail.setCellValueFactory(new PropertyValueFactory("email"));
			viewAfdeling.setCellValueFactory(new PropertyValueFactory("afdeling"));

			TableView.setItems(null);
			TableView.setItems(data);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		}

	}

	public void putInTable(ObservableList<Medarbejder> datars) {

		viewNavn.setCellValueFactory(new PropertyValueFactory("navn"));
		viewEmail.setCellValueFactory(new PropertyValueFactory("email"));
		viewAfdeling.setCellValueFactory(new PropertyValueFactory("afdeling"));

		TableView.setItems(null);
		TableView.setItems(datars);
	}
}
