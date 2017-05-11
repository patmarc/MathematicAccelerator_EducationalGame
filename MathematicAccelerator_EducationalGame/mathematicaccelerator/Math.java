package com.mygdx.mathematicaccelerator;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Math extends Game
{
	public final int width = 1024;
	public final int height = 768;
	public SpriteBatch batch;

	@Override
	public void create() 
	{
		this.batch = new SpriteBatch();
		this.setScreen(new GameMenu(this));
		
	}
	@Override
	public void render()
	{
		super.render();
	}
	

}
