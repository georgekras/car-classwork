package by.htp.carparking.web.action;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.util.HashMap;
import java.util.Map;

import by.htp.carparking.web.action.impl.CarListViewAction;
import by.htp.carparking.web.action.impl.OrderCarAction;
import by.htp.carparking.web.action.impl.ReturnCarAction;

public final class ActionManager {

	private static Map<String, BaseAction> actions;
	
	static {
		actions = new HashMap<>();
		actions.put(ACTION_NAME_VIEW_CAR_LIST, new CarListViewAction());
		actions.put(ACTION_NAME_ORDER_CAR, new OrderCarAction());
		actions.put(ACTION_NAME_RETURN_CAR, new ReturnCarAction());
	}
	
	private ActionManager(){	
	}
	
	public static BaseAction getAction(String action){
		return actions.get(action);
	}
}
