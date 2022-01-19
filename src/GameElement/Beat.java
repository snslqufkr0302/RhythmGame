package GameElement;

public class Beat {

	private int time;
	private String noteName;
	
	public Beat(double d, String noteName) {
		this.time = (int) d;
		this.noteName = noteName;
	}
	
	public int getTime() {
		return time; 
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	
}
