package com.mygdx.mathematicaccelerator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameOver implements Screen, InputProcessor {

	private Math game;
	private InputProcessor processor;
	private Texture mainScreen = new Texture("GO.png");
	private Texture backMenu = new Texture("backMenu.png");
	private BitmapFont speed;
	
	public GameOver (Math game)
		{
			this.game = game;
			processor = this;
			Gdx.input.setInputProcessor(processor);
			speed = new BitmapFont();
			speed.setColor(Color.RED);
		}
		
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(mainScreen,0,0);
		game.batch.draw(backMenu,650,40);
		speed.draw(game.batch,MathematicAccelerator.speedShip.toString(),300,45);
		
		//MathematicAccelerator.speed.draw(game.batch,MathematicAccelerator.speedShip.toString(),350,40);
		game.batch.end();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(screenX > 650 && screenX < 1000 
				&& screenY < (game.height - 40- 15 ) && screenY > game.height - 40 -backMenu.getHeight() - 20 )
		{
			game.getScreen().dispose();
		if(Task.startNumber == 1)
				KnowledgeScreen.musicForce.dispose();
		if(Task.startNumber == 31)
			KnowledgeScreen2.musicNeko.dispose();
		if(Task.startNumber == 61)
			KnowledgeScreen3.musicEcl.dispose();
		if(Task.startNumber == 91)
			KnowledgeScreen4.musicTev.dispose();
		if(Task.startNumber == 121)
			KnowledgeScreen5.musicFront.dispose();
		if(Task.startNumber == 151)
			KnowledgeScreen6.musicEye.dispose();
		GameMenu.music.play();
		GameMenu.musicPlayed = true;
			game.setScreen(new GameMenu(game));
			
		}
		return false;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		if(screenX > 650 && screenX < 1000 
				&& screenY < (game.height - 40- 15 ) && screenY > game.height - 40 -backMenu.getHeight() - 20 )
			{
				backMenu.dispose();
				backMenu = new Texture("backMenuRED.png");
			}
		else
		{
			backMenu.dispose();
			backMenu = new Texture("backMenu.png");
		}
		return false;
	}


	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
