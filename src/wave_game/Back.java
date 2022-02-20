package wave_game;

import java.util.ArrayList;
import java.util.List;

public class Back implements Runnable {
	// thread
	Thread thread = null;
	
	// enemy list
	private List<Enemy> enemy_list = new ArrayList<Enemy>();
	static final int ENEMY_MAX = 1;
	
	// window set
	private Window window = null;
	public void setWindow(Window _w) { window = _w; }
	
	// player set
	private Player player = null;
	public void setPlayer(Player _p) { player = _p; }
	
	// wall
	private List<Wall> wall_list = new ArrayList<Wall>();
	public void setWall(Wall _w) { wall_list.add(_w); }
	
	// draw set
	private Draw draw = null;
	public void setDraw(Draw _d) { draw = _d; }
	
	// thread start
	synchronized void startLoop() {
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
			
			// enemy
			for(int i = 0; i < ENEMY_MAX; i++) {
				enemy_list.add(new Enemy());
				
				enemy_list.get(i).init();
				
				// to draw
				draw.setEnemy(enemy_list.get(i));
				
				// to window
				window.setEnemy(enemy_list.get(i));
			}
		}
	}
	
	// thread stop
	synchronized void stopLoop() {
		if(thread != null) {
			thread = null;
		}
	}
	
	// main loop
	public void run() {
		System.out.println("back thread...");
		
		while(thread != null) {
			try {
				Thread.sleep(25);
				
				// enemy
				for(Enemy e:enemy_list) {
					e.move(player, wall_list);
					e.collision(player, wall_list);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
