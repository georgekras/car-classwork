package by.htp.carparking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.carparking.dao.CarDao;
import by.htp.carparking.dao.util.DBConnectionHelper;
import by.htp.carparking.domain.Car;

public class CarDaoDBImpl implements CarDao {

	public CarDaoDBImpl() {

	}

	@Override
	public void create(Car entity) {

		Connection conn = DBConnectionHelper.connect();

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("INSERT INTO car (brand, model) VALUES (?,?)");

			ps.setString(1, "brand1");
			ps.setString(2, "model1");

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public Car read(int id) {
		try (Connection connection = DBConnectionHelper.connect()) {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM `car` WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return new Car(rs.getInt("ID"), rs.getString("Brand"), rs.getString("Model"));
			else throw new IllegalArgumentException();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Car> readAll(){
		List<Car> list = new ArrayList<>();
		Connection connection = DBConnectionHelper.connect();
		Statement statement;
		try {
			statement = connection.createStatement();

		String sql = "SELECT * from car ;";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Car car = new Car(rs.getInt("ID"), rs.getString("Brand"), rs.getString("Model"));
			list.add(car);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public void update(Car entity) {

	}

	@Override
	public void delete(int id) {

	}

}
