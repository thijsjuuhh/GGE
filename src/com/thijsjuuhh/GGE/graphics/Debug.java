package com.thijsjuuhh.GGE.graphics;

public class Debug extends Window implements Render{

	public Debug(int width, int height, String title, int scale) {
		super(width, height, title, scale);
		addRenderer(this);
	}

	public void render(Render2D render) {
		
	}
	
}
