package java_bsc.oop1;

//절차지향 방식
public class MusicPlayerMain4 {
	public static void main(String args[]) {
		MusicPlayer player = new MusicPlayer();

		player.on();
		player.volumeUp();
		player.volumeUp();
		player.volumeDown();
		player.showStatus();
		player.off();
		
	}
}
