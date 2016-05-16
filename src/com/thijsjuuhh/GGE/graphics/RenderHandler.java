package com.thijsjuuhh.GGE.graphics;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.List;

import com.thijsjuuhh.GGE.GraphicsGameEngine;

public class RenderHandler {
	
	RenderHandler() {
	}

	public void render(List<Window> windows) {
		for (int i = 0; i < windows.size(); i++) {
			Window w = windows.get(i);
			BufferStrategy bs = w.getBufferStrategy();
			if(bs == null) {
				w.createBufferStrategy(3);
				return;
			}
			
			for (int k = 0; k < w.renderers.size(); k++){
				Render r = w.renderers.get(k);
				r.render(w.render2d);				
			}

			for(int j = 0; j < w.pixels.length; j++) 
				w.pixels[j] = w.render2d.pixels[j];
			
			Graphics g = bs.getDrawGraphics();
			g.drawImage(w.img, 0, 0, w.getWidth() * w.getScale(), w.getHeight() * w.getScale(), null);
			g.dispose();
			bs.show();
			
		}
			
	}

	public void init(GraphicsGameEngine gge) {
		gge.addRenderer(this);
	}

}
