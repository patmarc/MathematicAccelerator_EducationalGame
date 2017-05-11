package com.mygdx.mathematicaccelerator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class GameObject extends Rectangle {
	
	private Texture texture;
	
	public GameObject(Texture texture){
		this.texture = texture;
	}
	
	public Texture getTexture() {
		return texture;
	}
	

}
