package by.htp.carparking.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import by.htp.carparking.dao.OrderDao;
import by.htp.carparking.dao.util.DBConnectionHelper;
import by.htp.carparking.domain.Order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderDaoDBImpl implements OrderDao {

	private static final Logger logger = LogManager.getLogger();

	public OrderDaoDBImpl() {

	}

	@Override
	public void create(Order entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Order read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Order entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertNewOrder(int userId, int carId, Date dateStart, Date dateEnd) {

		Connection conn = DBConnectionHelper.connect();
		PreparedStatement ps = null;
		try {
			ps = conn
					.prepareStatement("INSERT INTO orders (user_id, car_id, dateStart, dateEnd) VALUES (?,?,?,?)");
			ps.setInt(1, userId);
			ps.setInt(2, carId);
			ps.setDate(3, dateStart);
			ps.setDate(4, dateEnd);
			ps.executeUpdate();
			logger.info("The order was added");

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Exceprion", e);
		} finally {
			if (ps != null) {
				try {
					conn.close();
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
					logger.error("Exceprion", e);
				}
			}
		}

	}

}
