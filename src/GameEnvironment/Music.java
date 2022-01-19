package GameEnvironment;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;


import javazoom.jl.player.Player;

public class Music extends Thread{

	// music player
	private Player player;
	private boolean isloop; /* �� ���� ����ϴ°� or ���� �ݺ��ΰ� */
	
	// music file ó��
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isloop) {
		
		try {
			this.isloop = isloop;
			file = new File(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/* ���� ���� ������ ��ġ ��ȯ */
	public int getTime()
	{
		if(player == null)
			return 0;
		return player.getPosition(); /* 3��¥�� ����- > 0:10��� 10000��ȯ */
	}
	
	public void close()
	{
		try {
			isloop = false;
			player.close();
			this.interrupt(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void run()
	{
		try {
			do {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis); /* ���ۿ� ���� */
				player = new Player(bis); /* �ش� ���� ������ ���� */
				player.play();
			} while (isloop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
