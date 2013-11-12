package com.epam.reutska.citygame.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CityDBReader implements IReader<String> {

	private String url ;
	private String name ;
	private String password;

	public CityDBReader(String url, String name, String password) {
		this.url = url;
		this.name = name;
		this.password = password;
	}

	@Override
	public void write(Set<String> value) throws DataSourceException {

		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO cities(city) " + "VALUES ");
		int i = 0;
		for (String city : value) {
			sb.append("(?)");
			if (i != value.size() - 1)
				sb.append(",");
			i++;
		}
		try (Connection connection = DriverManager.getConnection(url, name,
				password);
				java.sql.PreparedStatement prst = connection
						.prepareStatement(sb.toString())) {
			int index = 1;
			for (String string : value) {
				prst.setString(index, string);
				index++;
			}
			prst.executeUpdate();
		} catch (SQLException e) {
			throw new DataSourceException(e);
		}

	}

	@Override
	public Set<String> read() throws DataSourceException {
		Set<String> set = new HashSet<String>();

		try (Connection connection = DriverManager.getConnection(url, name,
				password); java.sql.Statement st = connection.createStatement()) {
			String query1 = "select*from cities";
			ResultSet rs1 = st.executeQuery(query1);
			while (rs1.next()) {
				set.add(rs1.getString(2));
			}
		} catch (SQLException e) {
			throw new DataSourceException(e);
		}
		return set;

	}
}
