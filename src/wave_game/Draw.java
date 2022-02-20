package wave_game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Draw extends JPanel {	
	// player set
	private Player player = null;
	public void setPlayer(Player _p) { player = _p; }
	
	// bullet set
	private List<Bullet> bullet_list = new ArrayList<Bullet>();
	public void setBullet(Bullet _b) { bullet_list.add(_b); }
	
	// wall
	private List<Wall> wall_list = new ArrayList<Wall>();
	public void setWall(Wall _w) { wall_list.add(_w); }
	
	// enemy set
	private List<Enemy> enemy_list = new ArrayList<Enemy>();
	public void setEnemy(Enemy _e) { enemy_list.add(_e); }
	
	public void paintComponent(Graphics _g) {
		super.paintComponent(_g);
		//Graphics2D g2d = (Graphics2D)_g;
		//AffineTransform at = g2d.getTransform();
		
		// player
		player.draw(_g);
		
		// bullet
		for(Bullet b:bullet_list) {
			b.draw(_g);
		}
		
		// wall
		for(Wall w:wall_list) {
			w.draw(_g);
		}
		
		// enemy
		for(Enemy e:enemy_list) {
			e.draw(_g);
		}
	}
}