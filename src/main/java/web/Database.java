package web;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.springframework.boot.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import entity.*;

@RestController
class Database {

	@Value("${my.jdbc.driver}")
	String driver;
	@Value("${my.jdbc.server}")
	String server;
	@Value("${my.jdbc.user}")
	String user;
	@Value("${my.jdbc.password}")
	String password;

	@RequestMapping("/data")
	List readData() {
		String connection = server + "&user=" + user + "&password=" + password;
		String sql = "select * from users";
		ArrayList<User> list = new ArrayList<User>();
		try {
			Class.forName(driver).newInstance();
			Connection cn = DriverManager.getConnection(connection);
			PreparedStatement ps = cn.prepareStatement(sql);
			// ps.setString(1, "user@codestar.work");
			ResultSet rs = ps.executeQuery();
			// ResultSetMetaData md = rs.getMetaData();
			// int count = md.getColumnCount();
			// for (int i = 1; i <= count; i++) result += md.getColumnName(i);

			while (rs.next()) {
				Long id         = rs.getLong("id");
				String email    = rs.getString("email");
				String name     = rs.getString("name");
				User user = new User(id, name, email);
				list.add(user);
			}
			rs.close();
			ps.close();
			cn.close();
		} catch (Exception e) {}
		return list;
	}

}
