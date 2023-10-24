package com.connor.gravity.framework;

import java.awt.image.BufferedImage;

import com.connor.gravity.window.BufferedImageLoader;

public class Texture {

	SpriteSheet bs, ps;
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	
	public BufferedImage[] block = new BufferedImage[4];
	public BufferedImage[] player = new BufferedImage[1];
	
	
	public Texture() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			block_sheet = loader.loadImage("/block_sheet.png");
			player_sheet = loader.loadImage("/player_sheet.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		
		getTextures();
		
	}
	
	private void getTextures(){
		block[0] = bs.grabImage(1, 1, 32, 32); //dirt block
		block[1] = bs.grabImage(2, 1, 32, 32); //grass block
		block[2] = bs.grabImage(4, 1, 32, 32); //stone block
		block[3] = bs.grabImage(1, 2, 32, 32); //red block
		
		player[0] = ps.grabImage(1, 1, 32, 32); //idle frame for player
		
	}
	
}
