package com.connor.gravity.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.connor.gravity.framework.GameObject;
import com.connor.gravity.framework.ObjectId;

public class Flag extends GameObject{

	public Flag(float x, float y, ObjectId id) {
		super(x, y, id);
		
	}
	
	public void tick(LinkedList<GameObject> object) {
		
	}
	
	
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, 32, 32);
		
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y,32, 32);
	}
	
	
	
	

}
