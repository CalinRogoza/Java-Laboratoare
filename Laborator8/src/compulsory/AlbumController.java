package compulsory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumController {
    private Connection connection = Database.getInstance().getConnection();

    public void create(String name, int artistId, int releaseYear) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO albums VALUES (?,?,?,?)");
            preparedStatement.setInt(1, 1);     //deoarece am lucrat cu oracle 11g care nu suporta AUTOINCREMENT, trebuie sa dau si id-ul( dar care va fi autoincrementat cu ajutorul unui sequence)
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, artistId);
            preparedStatement.setInt(4, releaseYear);
            preparedStatement.execute();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public Album findByArtist(int artistId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM albums WHERE artist_id=(?)");
            preparedStatement.setInt(1, artistId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Album(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4));
            }
        }
        catch (SQLException exception){
            System.out.println(exception);
        }
        return null;
    }
}
