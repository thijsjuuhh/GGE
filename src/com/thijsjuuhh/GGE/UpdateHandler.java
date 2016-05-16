package com.thijsjuuhh.GGE;

import java.util.ArrayList;
import java.util.List;

public class UpdateHandler {

	private List<Update> toUpdate = new ArrayList<Update>();;

	UpdateHandler() {
	}

	public void add(Update update) {
		toUpdate.add(update);
	}

	public void update() {
		for (Update u : toUpdate)
			u.update();
	}

	public void init(GraphicsGameEngine gge) {
		gge.addUpdater(this);
	}

}
