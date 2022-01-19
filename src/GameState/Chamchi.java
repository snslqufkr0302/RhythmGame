package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import GameElement.Beat;
import GameElement.EffectAnimation;
import GameElement.InterfaceBackground;
import GameElement.Note;
import GameElement.ResultBackground;
import GameEnvironment.Music;

public class Chamchi extends GameState
                   implements Runnable {

	// 배경, 음악, 비트
	private InterfaceBackground bg;
	private Music gameMusic;
	private Beat[] beats = null;
	
	// 노트 배열
	private ArrayList<Note> notes = new ArrayList<Note>();
	
	// 게임 스레드
	private Thread game;
	
	// 점수, 콤보
	private int score;
	private int combo;
	
	// effect motion
	private EffectAnimation effect;
	
	// 곡 시작시간
	private int startTime;
	
	// result 화면 여부
	private boolean displayResult;
	private boolean showingResult;
	private ResultBackground rbg;
	
	// 게임 도중 exit
	private boolean exit;
	
	// beat
	private Music beatSound;
	
	public Chamchi(GameStateManager gsm) {
		this.gsm = gsm;
		
		init();
	}
	
	@Override
	public void init() {
		
		// 점수 초기화
		score = 0; combo = 0;
		
		// 결과 화면
		displayResult = false;
		showingResult = false;
		rbg = new ResultBackground();
		
		// 배경 
		bg = new InterfaceBackground("/image/Chamchi.png");
		
		// 악보 세팅
		setBeat();
		
		// 게임 음악
		gameMusic = new Music("Chamchi.mp3", false);
		gameMusic.start();
		
		// effect
		effect = new EffectAnimation();
		
		// 게임 시작
		game = new Thread(this);
		game.start();
		
		// exit
		exit = false;
		
		// beat
		beatSound = new Music("beat.mp3", false);
		
	}
	
	public void setBeat() {
		startTime = 1000; 
		// 처음 비트가 떨어지는 시간
		int gap = (int)(60.0 / 360 * 1000);/* 박자 계산용 ex) 1/8박자 = 125/1000 */
		beats = new Beat[] {
				new Beat(startTime + gap * 4.1, "S"),
				new Beat(startTime + gap * 8.51, "J"), //참치
				new Beat(startTime + gap * 11.92, "S"),
				new Beat(startTime + gap * 12.92, "D"),
				new Beat(startTime + gap * 13.92 , "F"),
				new Beat(startTime + gap * 15.86, "S"), 
				new Beat(startTime + gap * 20.27 , "J"), // 요리로 참치 
				new Beat(startTime + gap * 23.68, "J"),
				new Beat(startTime + gap * 24.68, "K"),             
				new Beat(startTime + gap * 25.68, "L"),
				new Beat(startTime + gap * 27.62, "S"), 
				new Beat(startTime + gap * 32.03, "J"),//조리로 참치
				new Beat(startTime + gap * 34.44, "F"),
				new Beat(startTime + gap * 35.44, "J"),
				new Beat(startTime + gap * 36.44, "D"),
				new Beat(startTime + gap * 37.44, "K"), 
				new Beat(startTime + gap * 39.28, "Space"),
				new Beat(startTime + gap * 42.22, "Space"),
				new Beat(startTime + gap * 45.16, "Space"),//이건 맛의 대참치
				new Beat(startTime + gap * 50.79, "D"),
				new Beat(startTime + gap * 54.7, "K"), // 참치
				new Beat(startTime + gap * 57.51, "S"),
				new Beat(startTime + gap * 58.51, "D"),
				new Beat(startTime + gap * 59.51, "F"),
				new Beat(startTime + gap * 61.05, "D"),
				new Beat(startTime + gap * 64.4, "K"),//삼추쌈밥으로 참치
				new Beat(startTime + gap * 67.67, "J"),
				new Beat(startTime + gap * 68.67, "K"), 
				new Beat(startTime + gap * 69.67, "L"), 
				new Beat(startTime + gap * 71.21, "D"),
				new Beat(startTime + gap * 75.02, "K"),   //샐러드로 참치           
				new Beat(startTime + gap * 77.03, "F"),  //+0.2
				new Beat(startTime + gap * 78.03, "J"),  
				new Beat(startTime + gap * 79.03, "D"),
				new Beat(startTime + gap * 80.03, "K"),  
				new Beat(startTime + gap * 81.57, "Space"),
				new Beat(startTime + gap * 84.11, "Space"), 
				new Beat(startTime + gap * 87.65, "Space"), //이건 맛의 대참치 ..
				new Beat(startTime + gap * 92.93, "F"),
				new Beat(startTime + gap * 97.04, "L"),//참치 +1
				new Beat(startTime + gap * 100.15, "S"),
				new Beat(startTime + gap * 101.15, "D"),
				new Beat(startTime + gap * 102.15, "F"),
				new Beat(startTime + gap * 103.89, "F"), 
				new Beat(startTime + gap * 108, "L"), //볶음밥으로 참치            
				new Beat(startTime + gap * 111.11, "J"),
				new Beat(startTime + gap * 112.11, "K"), 
				new Beat(startTime + gap * 113.11, "L"),
				new Beat(startTime + gap * 114.85, "F"),
				new Beat(startTime + gap * 118.96, "L"),//샌드위치로 참치
				new Beat(startTime + gap * 122.07, "D"),
				new Beat(startTime + gap * 123.07, "K"),  
				new Beat(startTime + gap * 124.07, "F"),
				new Beat(startTime + gap * 125.07, "J"),
				new Beat(startTime + gap * 126.81, "Space"),
				new Beat(startTime + gap * 129.55, "Space"),
				new Beat(startTime + gap * 132.29, "Space"), //이건 맛의 대참치 +1
				new Beat(startTime + gap * 136.77, "S"),
				new Beat(startTime + gap * 140.88, "L"),//참치
				new Beat(startTime + gap * 143.99, "S"),
				new Beat(startTime + gap * 144.99, "D"),
				new Beat(startTime + gap * 145.99, "F"), 
				new Beat(startTime + gap * 147.73, "S"),
				new Beat(startTime + gap * 151.84, "L"), //미역국으로 참치
				new Beat(startTime + gap * 160, "S"), 
				new Beat(startTime + gap * 162.74, "L"),
				new Beat(startTime + gap * 165.48, "D"),              
				new Beat(startTime + gap * 168.22, "K"),
				new Beat(startTime + gap * 170.96, "F"),  
				new Beat(startTime + gap * 173.7, "J"),
				new Beat(startTime + gap * 176.44, "Space"), //언제까지 이노래를 부를 샘이야
				new Beat(startTime + gap * 185, "S"), 
				new Beat(startTime + gap * 185, "J"), 
				new Beat(startTime + gap * 190.48, "D"), 
				new Beat(startTime + gap * 190.48, "K"), 
				new Beat(startTime + gap * 195.96, "F"),
				new Beat(startTime + gap * 195.96, "L"), 
				new Beat(startTime + gap * 201.44, "Space"), // 헤이헤이
				new Beat(startTime + gap * 211, "S"), 
				new Beat(startTime + gap * 212, "L"),
				new Beat(startTime + gap * 213, "D"), 
				new Beat(startTime + gap * 214, "K"),
				new Beat(startTime + gap * 215.74, "Space"), 
				new Beat(startTime + gap * 218.48, "Space"), 
				new Beat(startTime + gap * 221.22, "Space"), // 이건 맛의 대참치 -
		};
	}
	
	@Override
	public void update() {
		
		// note 위치
		for (int i = 0; i < notes.size(); i++) {
			Note note = notes.get(i);
			note.update();
			if(note.isProceeded() == false ) {
				notes.remove(i);
				i--;
			}
		}
		
		// effect
		effect.update();
		
		// result
		if(displayResult) {
			if(!showingResult) {
				showingResult = true;
				rbg.playBgm();
				rbg.takeMusicTitle("조정석, 손나은  -  동원참치");
				rbg.takeScore(score);
				rbg.writeScore();
			}
			rbg.update();
		}
		
	}

	@Override
	public void draw(Graphics2D g) {
		
		// 배경, 인터페이스 그래픽
		bg.draw(g);
		
		// 곡이름 그래픽
		g.setColor(Color.WHITE);
		g.setRenderingHint(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("경기천년제목 Light", Font.BOLD, 30));
		g.drawString("조정석, 손나은 - 동원참치", 20, 700);
		
		// 점수판, 난이도 그래픽
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("경기천년제목 Light", Font.BOLD, 30));
		g.drawString(String.valueOf(score), 600, 700);
		g.drawString("Normal", 1100, 700);
		
		// 각 노트 그래픽
		for (int i = 0; i < notes.size(); i++) {
			Note note = notes.get(i);
			note.draw(g);
		}
		
		// effect
		effect.draw(g);
		
		// result
		if(displayResult) {
			rbg.draw(g);
		}
		
	}

	@Override
	public void keyPressed(int k) {
		
		if(k == KeyEvent.VK_ESCAPE) {
			
			exit = true;
			
			// 음악 종료
			gameMusic.close();
			rbg.closeBgm();
			
			// 게임 종료
			for (int i = 0; i < notes.size(); i++) {
				Note note = notes.get(i);
				note.setProceeded(false);
			}
			game.interrupt();
			
			// 화면 이동
			gsm.setStateInit(GameStateManager.MENUSTATE);
			gsm.setState(GameStateManager.MENUSTATE); 
			
		}
		
		// 게임 시작
		if(!displayResult) {
			
			beatSound = new Music("beat.mp3", false);
			beatSound.start();
			
			if (k == KeyEvent.VK_S) {
				judge("S");
				bg.pressS();
			} 
			else if (k == KeyEvent.VK_D) {
				judge("D");
				bg.pressD();
			} 
			else if (k == KeyEvent.VK_F) {
				judge("F");
				bg.pressF();
			} 
			else if (k == KeyEvent.VK_SPACE) {
				judge("Space");
				bg.pressSpace();
			} 
			else if (k == KeyEvent.VK_J) {
				judge("J");
				bg.pressJ();
			} 
			else if (k == KeyEvent.VK_K) {
				judge("K");
				bg.pressK();
			} 
			else if (k == KeyEvent.VK_L) {
				judge("L");
				bg.pressL();
			}
		}
		
		else if(displayResult) {
			if(k == KeyEvent.VK_ENTER && rbg.getNextGame()) {
				gsm.setStateInit(GameStateManager.MENUSTATE);
				gsm.setState(GameStateManager.MENUSTATE); 
			}
			
		}
		
	}

	@Override
	public void keyReleased(int k) {
		if (k == KeyEvent.VK_S) bg.releaseS();
		else if (k == KeyEvent.VK_D) bg.releaseD();
		else if (k == KeyEvent.VK_F) bg.releaseF();
		else if (k == KeyEvent.VK_SPACE) bg.releaseSpace();
		else if (k == KeyEvent.VK_J) bg.releaseJ();
		else if (k == KeyEvent.VK_K) bg.releaseK();
		else if (k == KeyEvent.VK_L) bg.releaseL();
	}

	// 순차탐색을 돌며 해당 노트 판단 
	public void judge(String input)
	{
		for (int i = 0; i < notes.size(); i++) {
			Note note = notes.get(i);
			if(input.equals(note.getNoteType()))
			{
				if (note.judge().equals("Miss")) {
					combo = 0;
				}
				if (note.judge().equals("Perfect")){
					effect.setCombo("Perfect", combo); 
					effect.setPosition(note.getNoteType());
					effect.setEffect(); 
					combo++;
					score += 80 + combo * 5;
				}
				if (note.judge().equals("Great")){
					effect.setCombo("Great", combo); 
					effect.setPosition(note.getNoteType());
					effect.setEffect(); 
					combo++;
					score += 80 + combo * 5;
				}
				if (note.judge().equals("Good")){
					effect.setCombo("Good", combo); 
					effect.setPosition(note.getNoteType());
					effect.setEffect(); 
					combo++;
					score += 80 + combo * 5;
				}
				break;
			}
		}
	}
	
	
	@Override
	public void run() {
		
		int i =0;

		// 악보가 끝날 때까지 run
			while (i < beats.length && !game.isInterrupted()) {

				// 해당 비트가 drop할 시간이 됐을 때 노트 생성
				if (beats[i].getTime() <= gameMusic.getTime()) {
					Note note = new Note(beats[i].getNoteName());
					notes.add(note);
					i++;
				}
			}
			
		// ESC버튼 누르지 않았다면
		if (!exit) {
			// result 화면
			try {
				Thread.sleep(5000);
			} catch (Exception e) {e.printStackTrace();}
			rbg.calRank();
			displayResult = true;
		}

	}
	

}
