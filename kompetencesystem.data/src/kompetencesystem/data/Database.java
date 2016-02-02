package kompetencesystem.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kompetencesystem.domæne.Medarbejder;

public class Database {

	DataAccess dataaccess = new DataAccess();
	ObservableList<Medarbejder> datars = FXCollections.observableArrayList();

	public ObservableList<Medarbejder> refresh(List<String> kompetence) {
		datars.clear();
		try {

			String sql = "SELECT navn, email, afdeling FROM medarbejder  ";

			for (int i = 0; i < kompetence.size(); i++) {
				sql = sql + " JOIN medarbejderKompetence k" + i + " ON medarbejder.email = k" + i + ".email AND k" + i
						+ ".kompetencenavn = ?";
			}
			PreparedStatement prep = dataaccess.getConnection().prepareStatement(sql);

			for (int i = 0; i < kompetence.size(); i++) {
				prep.setString(i + 1, kompetence.get(i));
			}

			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				datars.add(new Medarbejder(rs.getString("navn"), rs.getString("email"), rs.getString("afdeling")));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		}
		return datars;
	}

}
