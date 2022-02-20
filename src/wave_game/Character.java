package wave_game;

import java.awt.Graphics;

public interface Character {
	public abstract void init();
	public abstract void draw(Graphics _g);
	
	// getter
	public int getX();
	public int getY();
	public int getHp();
	
	// setter
	public void setX(int _x);
	public void setY(int _y);
	public void setHp(int _h);
}