import java.sql.*;

public class GetDataFromDB {
    //Заменить на нужные данные
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/" +
            "javaDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //Логин и пароль от сервера
    static final String USER_NAME = "root";
    static final String PASSWORD = "admin1";

    public static void main(String[] args) {
        Connection con = null;
        Statement statement = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
             statement = con.createStatement();
            // Получаем все записи из базы по таблице users
            String SQLrequestForDB = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(SQLrequestForDB);
            // Выводим полученные данные в консоль.
            while(resultSet.next()) {
                String name = resultSet.getString(2);
                System.out.println(name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
