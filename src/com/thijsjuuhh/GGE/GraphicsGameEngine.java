package com.thijsjuuhh.GGE;

import java.util.ArrayList;
import java.util.List;

import com.thijsjuuhh.GGE.graphics.RenderHandler;
import com.thijsjuuhh.GGE.graphics.Window;

public class GraphicsGameEngine implements Runnable{

	private GGE gge;
	
	private int fps, ups;
	
	private List<Window> windows = new ArrayList<Window>();
	
	private boolean init = false;
	
	private boolean running = true;
	
	private UpdateHandler UH;
	private RenderHandler RH;
	
	
	private Thread t;
	
	GraphicsGameEngine() {
	}
	
	public void add(Window w) {
		System.out.print("Trying to add: " + w.getTitle() + " With dimensions: " + w.getWidth() + " " + w.getHeight() + " ");
		windows.add(w);
		System.out.println("Succeeded!");
	}
	
	public void init(GGE gge, Window w) {
		if(init) return;
		this.gge = gge;
		w.addGraphicsGameEngine(this);
		add(w);
		
		gge.start();
		running = true;
		t = new Thread(this);
		t.start();
		init = true;
	}
	
	public void stop() {
		running = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gge.stop();
	}

	public void addUpdater(UpdateHandler UH) {
		this.UH = UH;
	}
	
	public void addRenderer(RenderHandler RH) {
		this.RH = RH;
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				ups++;
				UH.update();
				delta--;
			}
			RH.render(windows);
			fps++;
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(fps + " FPS : " + ups + " UPS");
				ups = 0;
				fps = 0;
			}
		}
	}
}
