package com.thijsjuuhh.GGE.graphics;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.thijsjuuhh.GGE.GraphicsGameEngine;
import com.thijsjuuhh.GGE.Update;

public class Window {
	
	List<Render> renderers = new ArrayList<Render>();
	
	int[] pixels;
	BufferedImage img;
	Render2D render2d;
	
	private int width;
	private int height;
	private String title;

	private int scale = 1;
	
	private JFrame frame;
	
	private static boolean undecorated = false;

	public Window(int width, int height, String title, int scale) {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		render2d = new Render2D(this, width, height);
		
		this.width = width;
		this.height = height;
		this.title = title;
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setUndecorated(undecorated);
		undecorated = true;
		
		if(scale !=0) this.scale = scale;
	}

	public Window addRenderer(Render toAdd) {
		renderers.add(toAdd);
		return this;
	}
	
	public Window setVisible(boolean visible) {
		frame.setVisible(visible);
		return this;
	}

	public Window setLocation(int x, int y) {
		frame.setLocation(x, y);
		return this;
	}

	public Window setLocation(Component c) {
		frame.setLocationRelativeTo(c);
		return this;
	}

	
	public Window setResizable(boolean resizable) {
		frame.setResizable(resizable);
		return this;
	}

	public BufferStrategy getBufferStrategy() {
		return frame.getBufferStrategy();
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void addGraphicsGameEngine(GraphicsGameEngine gge) {
		Render.RH.init(gge);
		Update.UH.init(gge);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				gge.stop();
				System.exit(0);
			}
		});
	}
	
	public String getTitle() {
		return title;
	}

	public void createBufferStrategy(int numBuffers) {
		frame.createBufferStrategy(numBuffers);
	}

	public int getScale() {
		return scale;
	}
	
}
