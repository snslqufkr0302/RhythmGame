package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;


public class RankingState extends GameState {
	
	public RankingState(GameStateManager gsm) {
		// TODO Auto-generated constructor stub
		this.gsm = gsm;
		

		JFrame f= new JFrame("·©Å·");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setSize(500,500);
		f.setVisible(true);
	}
		public static void main(String[] args) throws IOException {
			FileReader reader = new FileReader("C:\\Users\\82106\\eclipse-workspace\\RhythmGame\\RhythmGame\\ScoreLog.txt");
			int ch;
			while ((ch = reader.read()) != -1) {
			System.out.print((char) ch);
		}
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
		
		
		
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
