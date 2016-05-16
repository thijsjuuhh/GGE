package com.thijsjuuhh.GGE.graphics;

public class Render2D {

	public final Window w;
	private final int width, height;
	int[] pixels;

	Render2D(Window w, int width, int height) {
		this.w = w;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void renderSprite(int xP, int yP, Sprite s) {
		for (int y = 0; y < s.getHeight(); y++) {
			int yPix = y + yP;
			for (int x = 0; x < s.getWidth(); x++) {
				int xPix = x + xP;
				if (!isWithinFrame(xPix, yPix))
					continue;
				int pix = s.pixels[x + y * s.getWidth()];
				if (pix != 0xffff00ff)
					pixels[xPix + yPix * width] = pix;
			}
		}
	}

	private boolean isWithinFrame(int xPix, int yPix) {
		return xPix >= 0 && xPix < width && yPix >= 0 && yPix < height;
	}

	public void fillBackground(int col) {
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = col;
	}

}
