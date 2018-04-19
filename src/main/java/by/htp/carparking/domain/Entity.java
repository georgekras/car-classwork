package by.htp.carparking.domain;

import java.io.Serializable;

public abstract class Entity implements Serializable {

	private static final long serialVersionUID = -966558700808733981L;
	
	private int id;

	public Entity() {
		super();
	}

	public Entity(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
