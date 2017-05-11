package com.mygdx.mathematicaccelerator;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Elipse extends Rectangle
{

	private Texture texture = new Texture("elipse.png");
	
	
	
	public Elipse(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.height = texture.getHeight();
		this.width = texture.getWidth();
	}


	public Texture getTexture() {
		return texture;
	}


	public void setTexture(Texture texture) {
		this.texture = texture;
	}

}
