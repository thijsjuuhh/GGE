package com.thijsjuuhh.GGE.graphics;

public class Sprite {

	private int width, height;
	public int[] pixels;

	public Sprite(Spritesheet sheet, int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int y1 = 0; y1 < height; y1++)
			for (int x1 = 0; x1 < width; x1++)
				pixels[x1 + y1 * width] = sheet.pixels[(x1 + x) + (y1 + y) * sheet.getWidth()];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
