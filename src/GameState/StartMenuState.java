package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;



public class StartMenuState extends GameState{
	
	
	private BufferedImage image;
	private int angle; 
	
	public StartMenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		init();
	}

	@Override
	public void init() {
		try {
			image = ImageIO.read(
					getClass().getResourceAsStream(
							"/image/introBackground.jpg")
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update() {
		angle += 3;
	}
	
	@Override
	public void draw(Graphics2D g) {
		
		// background
		g.drawImage(image, 0, 0, null);
		
		// title
		g.setColor(Color.ORANGE);
		g.setFont(new Font(
				"���õ������V Bold", 
				Font.PLAIN, 
				100));
		g.drawString("CM�� ���� ����", 280, 300);
		
		// flash info
		double alpha = 255 * Math.sin(angle * Math.PI / 180);	
		if (angle >= 175) angle = 0;
		g.setFont(new Font(
				"���õ������ Light", 
				Font.PLAIN, 
				50));
		g.setColor(new Color(255, 255, 255, (int)alpha));
		g.drawString(
				"Press space bar to continue",
				340, 580);
		
		// version info
		g.setColor(Color.white);
		g.setFont(new Font(
				"���õ������ Medium", 
				Font.PLAIN, 
				35));
		g.drawString("1.0.2", 610,670);
	
	}

	
	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_SPACE) 
			gsm.setState(GameStateManager.MENUSTATE);
	}
	
	@Override
	public void keyReleased(int k) {}

}
