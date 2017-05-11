package com.mygdx.mathematicaccelerator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class KnowledgeScreen5 implements Screen, InputProcessor {

	private Math game;
	private InputProcessor processor;
	private Texture mainScreen = new Texture("KS5.png");
	private Texture playGame = new Texture("PLAYbutton.png");
	
	
	
	public static Music musicFront;
	
	public KnowledgeScreen5(Math game)
	{
		this.game = game;
		processor = this;
		Gdx.input.setInputProcessor(processor);
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
		game.batch.draw(playGame,750,40);
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
		if(screenX > 750 && screenX < 1000 && screenY < (game.height - 80 ) && screenY > (game.height -80 -30 ) )
		{
			game.getScreen().dispose();
			GameMenu.music.dispose();
			game.setScreen(new MathematicAccelerator(game));
			musicFront = Gdx.audio.newMusic(Gdx.files.internal("frontier.mp3"));
			if(SettingScreen.musicOn)
				musicFront.play();
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
			playGame = new Texture("PLAYbuttonRED.png");
		else
			playGame = new Texture("PLAYbutton.png");
		
		return false;
	}


	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
