package com.connor.gravity.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.connor.gravity.window.Handler;

public class KeyInput extends KeyAdapter
{
	Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int Key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player)
			{
				if(Key == KeyEvent.VK_D) tempObject.setVelX(7);
				if(Key == KeyEvent.VK_A) tempObject.setVelX(-7);
				if(Key == KeyEvent.VK_SPACE && !tempObject.isJumping())
				{
					tempObject.setJumping(true);
					tempObject.setVelY(-10);
				}
			}
		}
		
		
		if(Key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}
		
		public void KeyReleased(KeyEvent e) {
			int Key = e.getKeyCode();
			
			for(int i = 0; i < handler.object.size(); i++)
			{
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getId() == ObjectId.Player)
				{
					if(Key == KeyEvent.VK_D) tempObject.setVelX(0);
					if(Key == KeyEvent.VK_A) tempObject.setVelX(0);
			}
		}
	}
}
