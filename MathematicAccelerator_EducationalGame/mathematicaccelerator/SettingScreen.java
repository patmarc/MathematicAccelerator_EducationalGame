package com.mygdx.mathematicaccelerator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class SettingScreen implements Screen, InputProcessor{

	private Math game;
	private InputProcessor processor;
	private Texture mainScreen = new Texture("SETT.png");
	private Texture onOffButton = new Texture("OnOffRED.png");
	private Texture backGame = new Texture("BACKbutton.png");
	public static Boolean musicOn = true;
	
	public SettingScreen (Math game)
	{
		this.game = game;
		processor = this;
		Gdx.input.setInputProcessor(processor);
		if(GameMenu.musicPlayed == false)
			onOffButton = new Texture("OnOff.png");
			
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
		game.batch.draw(onOffButton,360,580);
		game.batch.draw(backGame,750,40);
		game.batch.end();
		
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
		if(screenX > 465 && screenX < 530 && screenY < (game.height - 612 ) && screenY > (game.height -612 -25 ) )
			{
				onOffButton = new Texture("OnOff.png");
				if(GameMenu.musicPlayed == true)
					{
					GameMenu.music.dispose();
					GameMenu.musicPlayed = false;
					}
				musicOn = false;
			}
		if(screenX > 390 && screenX < 450 && screenY < (game.height - 612 ) && screenY > (game.height -612 -25 ) )
			{
				onOffButton = new Texture("OnOffRED.png");
				if(GameMenu.musicPlayed == false )
					{
					GameMenu.music.play();
					GameMenu.musicPlayed = true;
					}
				musicOn = true;
			
			}
		
		if(screenX > 750 && screenX < 1000 && screenY < (game.height - 80 ) && screenY > (game.height -80 -30 ) )
		{
			game.getScreen().dispose();
			GameMenu.back = true;
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
		if(screenX > 750 && screenX < 1000 && screenY < (game.height - 80 ) && screenY > (game.height -80 -30 ) )
			{
				backGame.dispose();
				backGame = new Texture("BACKbuttonRED.png");
			}
		else
		{
			backGame.dispose();
			backGame = new Texture("BACKbutton.png");
		}
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
