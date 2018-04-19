package by.htp.carparking.dao;

import by.htp.carparking.dao.impl.CarDaoDBImpl;

public class DAO {
	
	private DAO() {}
	
	private static DAO instance;
	
	public final CarDaoDBImpl carDAO = new CarDaoDBImpl();
	
	public static DAO getDAO(){
        if (instance == null){
            synchronized (DAO.class){
                if (instance == null){
                    instance = new DAO();
                }
            }
        }
        return instance;
    }

}