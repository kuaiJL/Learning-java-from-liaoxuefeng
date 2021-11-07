package Z_jdbc.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Jdbc_connect {
    static final String jdbcUrl = "jdbc:mysql://localhost/bishe?useSSL=false&characterEncoding=utf8";
    static final String jdbcUsername = "Kuai";
    static final String jdbcPassword = "134679";

    public static void main(String[] args) throws SQLException {
        List<User> users = queryUsers();
        users.forEach(System.out::println);
    }

    static List<User> queryUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn
                    .prepareStatement("SELECT * FROM users WHERE user_id=? AND user_name=?")) {
                ps.setInt(1, 3); // 第一个参数grade=?
                ps.setString(2, "rafa"); // 第二个参数score=?
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        users.add(extractRow(rs));
                    }
                }
            }
        }
        return users;
    }

    static User extractRow(ResultSet rs) throws SQLException {
        var user = new User();
        user.setId(rs.getInt("user_id"));
        user.setName(rs.getString("user_name"));
        user.setMail(rs.getString("user_pubKey"));
        return user;
    }
}
