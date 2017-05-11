package com.mygdx.mathematicaccelerator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class KnowledgeScreen2 implements Screen, InputProcessor {

	private Math game;
	private InputProcessor processor;
	private Texture mainScreen = new Texture("KS2.png");
	private Texture playGame = new Texture("PLAYbutton.png");
	private Texture alwaysPict = new Texture("clear.png");
	private Texture alwaysPictBig = new Texture("clear.png");
	private Texture alwaysPictRed = new Texture("clear.png");
	private Texture letsGoPict = new Texture("clear.png");
	
	
	
	public static Music musicNeko;
	
	public KnowledgeScreen2(Math game)
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
		game.batch.draw(letsGoPict,350,25);
		game.batch.draw(alwaysPict,550,580);
		game.batch.draw(alwaysPictBig,680,430);
		game.batch.draw(alwaysPictRed,530,380);
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
			musicNeko = Gdx.audio.newMusic(Gdx.files.internal("return.mp3"));
			if(SettingScreen.musicOn)
				musicNeko.play();
		}
		if(screenX > 80 && screenX < 95 && screenY < (game.height - 555 ) && screenY > (game.height -555 -30 ) )
			alwaysPict = new Texture ("always.png");
		
		if(screenX > 141 && screenX < 177 && screenY < (game.height - 555 ) && screenY > (game.height -555 -30 ) )
			alwaysPictBig = new Texture ("alwaysBIG.png");
		
		if(screenX > 333 && screenX < 369 && screenY < (game.height - 555 ) && screenY > (game.height -555 -30 ) )
			alwaysPictRed = new Texture ("alwaysRED.png");
		if(screenX > 613 && screenX < 618 && screenY < (game.height - 235 ) && screenY > (game.height -235 -30 ) )
		{
			letsGoPict = new Texture("Lwhite.png");
			letsGoPict = new Texture("Lred.png");
			letsGoPict = new Texture("Lpink.png");
			letsGoPict = new Texture("Lorange.png");
			letsGoPict = new Texture("Lyellow.png");
			letsGoPict = new Texture("Lblue.png");
			letsGoPict = new Texture("clear.png");
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
		
		if(screenX > 613 && screenX < 618 && screenY < (game.height - 235 ) && screenY > (game.height -235 -30 ) )
			{
				letsGoPict = new Texture("Lwhite.png");
				letsGoPict = new Texture("Lred.png");
				//letsGoPict = new Texture("Lpink.png");
				//letsGoPict = new Texture("Lorange.png");
				//letsGoPict = new Texture("Lyellow.png");
				//letsGoPict = new Texture("Lblue.png");
				//letsGoPict = new Texture("clear.png");
			}
		return false;
	}


	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
