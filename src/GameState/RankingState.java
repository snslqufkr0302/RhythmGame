package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import GameEnvironment.Music;
import GameEnvironment.Track;
public class RankingState extends GameState {
	// image
		private BufferedImage imageMenuBackground; 
		private BufferedImage imageClickNote;
		private BufferedImage imageBasicNote;
		private BufferedImage imageGrayStar;
		private BufferedImage imageYellowStar;
		private BufferedImage imageMenu;

	public RankingState(GameStateManager gsm) {
		// TODO Auto-generated constructor stub
		this.gsm = gsm;
		try {
			imageMenuBackground = ImageIO.read(
					getClass().getResourceAsStream(
							"/image/menuBackground.jpg")
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		init();
	}

	public static void main(String[] args) {
		
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		
		// background
		g.drawImage(imageMenuBackground, 0, 0, null);
		
		
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		if(k == KeyEvent.VK_Y) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
