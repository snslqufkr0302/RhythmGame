package GameElement;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Main.Game;


public class Note {
	
	// note image
	private BufferedImage noteBasicImage;
	
	// note ��ǥ
	private int x;
	private int y = 580 - 
			(1000 / Game.SLEEP_TIME * Game.NOTE_SPEED);
			                 

	// note type, proceeded
	private String noteType;
	private boolean proceeded = true;
	

	public Note(String noteType) {
		
		this.noteType = noteType;
	
		init();
	}

	public void init() {
		
		try {
			noteBasicImage = ImageIO.read(
					getClass().getResourceAsStream(
							"/image/noteBasic.png"
							));
		} catch (Exception e) {	e.printStackTrace(); };	
		
		if (noteType.equals("S")) x = 228;
		else if (noteType.equals("D")) x = 332;
		else if (noteType.equals("F")) x = 436;
		else if (noteType.equals("Space")) x = 540;
		else if (noteType.equals("J")) x = 744;
		else if (noteType.equals("K")) x = 848;
		else if (noteType.equals("L")) x = 952;
		
	}

	public void update() {
		y += Game.NOTE_SPEED;
		if (y > 620) 
			close();
	}
	
	public void draw(Graphics2D g) {
		if (!noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
		} else {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}


	public String judge() {
	/*	
		if (y >= 535) {
			System.out.println("Miss");
			close();
			return "Miss";
		} else */
		 
		if (y >= 625) {
			System.out.println("Miss2");
			close();
			return "Miss";
		}
		/* else if (y >= 620) {
			System.out.println("Good2");
			close();
			return "Good";
		}
		else if (y >= 610) {
			System.out.println("Great2");
			close();
			return "Great";
		}
		else if (y >= 590) {
			System.out.println("Perfect");
			close();
			return "Perfect";
		} */
		else if (y >= 560) {
			System.out.println("Great");
			close();
			return "Great";
		}
		else if (y >= 570) {
			System.out.println("Good");
			close();
			return "Good";
		}
		
		 
		return "Miss";
	}
	
	public void close() { proceeded = false;}
	public int getY() { return y; }
	public String getNoteType() { return noteType; }
	public void setProceeded(boolean proceeded) { this.proceeded = proceeded; }
	public boolean isProceeded() { return proceeded; }
	
}
