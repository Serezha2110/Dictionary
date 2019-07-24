package sample;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static sample.Const.*;


class DatabaseHandler extends Configs {

    static Connection Conn() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            if (!connection.isClosed())
                System.out.println("available");
            if (connection.isClosed())
                System.out.println("closed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Sure...1?");
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.out.println("Sure...2?");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("Sure...3?");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("Sure...4?");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Sure...5?");
        }
        return connection;
    }

    void insert(String words_ru, String words_en) {

        String insert = "INSERT INTO " + WORDS_TABLE + " (" + WORD_RU + "," + WORD_EN + ") " + "VALUES(?,?) ";

        try {
            PreparedStatement prStI = Conn().prepareStatement(insert);
            prStI.setString(1, words_ru);
            prStI.setString(2, words_en);

            prStI.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void update(String words_ru, String words_en) {


        String update = "UPDATE " + WORDS_TABLE + " SET " + WORD_RU + "= ? , "
                + Const.WORD_EN + "= ? WHERE " + WORD_RU + "= ? OR "
                + Const.WORD_EN + "= ?";

        try {
            PreparedStatement prStU = Conn().prepareStatement(update);
            prStU.setString(1, words_ru);
            prStU.setString(2, words_en);
            prStU.setString(3, words_ru);
            prStU.setString(4, words_en);

            prStU.executeUpdate();
            Conn().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}