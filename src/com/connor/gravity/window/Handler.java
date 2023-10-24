package com.connor.gravity.window;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.connor.gravity.framework.GameObject;
import com.connor.gravity.framework.ObjectId;
import com.connor.gravity.objects.Block;
import com.connor.gravity.objects.Flag;
import com.connor.gravity.objects.Player;


public class Handler 
{

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	
	private Camera cam;
	
	private BufferedImage level2 = null;
	private BufferedImage level3 = null;
	private BufferedImage level4 = null;
	private BufferedImage level5 = null;
	private BufferedImage level6 = null;
	private BufferedImage level7 = null;
	private BufferedImage level8 = null;
	
	
	public Handler(Camera cam){
		this.cam = cam;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		level2 = loader.loadImage("/level2.png"); //Loading the level
		level3 = loader.loadImage("/level3.png"); //Loading the level
		level4 = loader.loadImage("/level4.png"); //Loading the level
		level5 = loader.loadImage("/level5.png"); //Loading the level
		level6 = loader.loadImage("/level6.png"); //Loading the level
		level7 = loader.loadImage("/level7.png"); //Loading the level
		level8 = loader.loadImage("/level8.png"); //Loading the level
	}
	
	public void tick()
	{
		for(int i = 0; i < object.size(); i++)
		{
			tempObject = object.get(i);
			
			tempObject.tick(object);
		}
	}
		
		public void render(Graphics g) {
			for(int i = 0; i < object.size(); i++)
			{
				tempObject = object.get(i);
			
				tempObject.render(g);
			}
	}
		
		public void LoadImageLevel(BufferedImage image){
			int w = image.getWidth();
			int h = image.getHeight();
			
			System.out.println("wdith, height: " + w + " " + h);
			
			for(int xx = 0; xx < h; xx++){
				for(int yy = 0; yy < w; yy++){
					int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 0 && green == 255 & blue == 0) addObject(new Block(xx*32, yy*32, 1, ObjectId.Block));
				if(red == 150 && green == 75 & blue == 0) addObject(new Block(xx*32, yy*32, 0, ObjectId.Block));
				if(red == 255 && green == 0 & blue == 0) addObject(new Block(xx*32, yy*32, 3, ObjectId.Block));
				if(red == 195 && green == 195 & blue == 195) addObject(new Block(xx*32, yy*32, 2, ObjectId.Block));
				if(red == 251 && green == 255 & blue == 33) addObject(new Flag(xx*32, yy*32, ObjectId.Flag));
				if(red == 0 && green == 0 & blue == 255) addObject(new Player(xx*32, yy*32, this, cam, ObjectId.Player));
				}
			}
		}
		
		public void switchLevel(){
			clearLevel();
			cam.setX(0);
			
			
			switch(Game.LEVEL)
			{
			case 1:
				LoadImageLevel(level2);
				break;
			case 2:
				LoadImageLevel(level3);
				break;
			case 3:
				LoadImageLevel(level4);
				break;
			case 4:
				LoadImageLevel(level5);
				break;
			case 5:
				LoadImageLevel(level6);
				break;
			case 6:
				LoadImageLevel(level7);
				break;
			case 7:
				LoadImageLevel(level8);
				break;
			}
			Game.LEVEL++;
			
		}

		
		
		private void clearLevel(){
			object.clear();
		}
		
		public void addObject(GameObject object) {
			this.object.add(object);
		}
		public void removeObject(GameObject object) {
			this.object.remove(object);
		}
		
	
		
			
		}
	

