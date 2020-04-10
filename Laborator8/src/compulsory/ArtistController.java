package compulsory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistController {
    private Connection connection = Database.getInstance().getConnection();

    public void create(String name, String country) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO artists VALUES (?,?,?)");
            preparedStatement.setInt(1, 1);     //deoarece am lucrat cu oracle 11g care nu suporta AUTOINCREMENT, trebuie sa dau si id-ul( dar care va fi autoincrementat cu ajutorul unui sequence)
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, country);
            preparedStatement.execute();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public Artist findByName(String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM artists WHERE NAME=(?)");
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Artist(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return null;
    }
}
