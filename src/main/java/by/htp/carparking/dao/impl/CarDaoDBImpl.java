package by.htp.carparking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.carparking.dao.CarDao;
import by.htp.carparking.dao.util.DBConnectionHelper;
import by.htp.carparking.domain.Car;

public class CarDaoDBImpl implements CarDao {

	private static final Logger logger = LogManager.getLogger();

	String readAllSql = "SELECT * from car ;";

	public CarDaoDBImpl() {

	}

	@Override
	public void create(Car entity) {

		Connection conn = DBConnectionHelper.connect();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("INSERT INTO car (Brand, Model) VALUES (?,?)");
			ps.setString(1, "brand1");
			ps.setString(2, "model1");
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("Exceprion", e);
		} finally {
			if (ps != null) {
				try {
					conn.close();
					ps.close();
				} catch (SQLException e) {
					logger.error("Exceprion", e);
				}
			}
		}

	}

	@Override
	public Car read(int id) {
		Connection conn = DBConnectionHelper.connect();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("SELECT * FROM `car` WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return new Car(rs.getInt("ID"), rs.getString("Brand"), rs.getString("Model"));
			else
				throw new IllegalArgumentException();
		} catch (SQLException e) {
			logger.error("Exceprion", e);
		} finally {
			if (ps != null) {
				try {
					conn.close();
					ps.close();
				} catch (SQLException e) {
					logger.error("Exceprion", e);
				}
			}
		}
		return null;
	}

	@Override
	public List<Car> readAll() {
		List<Car> list = new ArrayList<>();
		Connection conn = DBConnectionHelper.connect();
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(readAllSql);
			while (rs.next()) {
				Car car = new Car(rs.getInt("ID"), rs.getString("Brand"), rs.getString("Model"));
				list.add(car);
			}
		} catch (SQLException e) {
			logger.error("Exceprion", e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("Exceprion", e);
			}
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
