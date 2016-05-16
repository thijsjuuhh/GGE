package com.thijsjuuhh.GGE.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	private String path;
	private int width, height;
	public int[] pixels;

	public Spritesheet(String path) {
		this.path = path;
		try {
			System.out.print("Trying to load: " + path + " ");
			BufferedImage img = ImageIO.read(Spritesheet.class.getResource("/" + path));
			width = img.getWidth();
			height = img.getHeight();
			pixels = new int[width * height];
			img.getRGB(0, 0, width, height, pixels, 0, width);
			System.out.println("Succeeded!");
		} catch (IOException e) {
			System.err.println("FAILED!");
			e.printStackTrace();
		}

	}

	public String getPath() {
		return path;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
