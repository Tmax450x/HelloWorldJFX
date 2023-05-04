package helper;

import com.mysql.cj.protocol.Resultset;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class FruitsQuery {

    public static int insert(String fruitName, int colorId) throws Exception{

        String sql = "INSERT INTO FRUITS(Fruit_Name, Color_ID) VALUES(?, ?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, fruitName);
        ps.setInt(2, colorId);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;

    }

    public static int update(int fruitID, String FruitName) throws SQLException {

        String sql = "UPDATE FRUITS SET Fruit_Name = ? WHERE Fruit_Id = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, FruitName);
        ps.setInt(2, fruitID);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;

    }

    public static int delete(int fruitID) throws SQLException {

        String sql = "DELETE FROM FRUITS WHERE Fruit_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, fruitID);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

    public static void select() throws SQLException {

        String sql = "SELECT * FROM FRUITS";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            int fruitID = rs.getInt("Fruit_ID");
            String fruitName = rs.getString("Fruit_Name");
            System.out.print(fruitID + " | " );
            System.out.print(fruitName + "\n");

        }

    }

    public static void select(int colorID) throws SQLException {

        String sql = "SELECT * FROM FRUITS WHERE Color_Id = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1,colorID);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            int fruitID = rs.getInt("Fruit_ID");
            String fruitName = rs.getString("Fruit_Name");
            int colorIdFK = rs.getInt("Color_Id");
            System.out.print(fruitID + " | " );
            System.out.print(fruitName + " | " );
            System.out.print(colorIdFK + "\n");

        }

    }

}
