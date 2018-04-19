package by.htp.carparking.web.action;

import org.springframework.web.context.WebApplicationContext;

public final class ActionManagerContext {

	private ActionManagerContext() {

	}

	public static BaseAction getAction(String action, WebApplicationContext webApplicationContext) {
		return (BaseAction) webApplicationContext.getBean(action);
	}

}
