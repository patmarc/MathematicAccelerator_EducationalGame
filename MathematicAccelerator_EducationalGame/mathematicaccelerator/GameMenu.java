package com.mygdx.mathematicaccelerator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class GameMenu implements Screen, InputProcessor 
// poprzez korzystanie z interfejsów konieczne jest dodanie wszystkich funkcji dlatego niektóre s¹ nieu¿ywane 
{
	private Math game;
	private Texture newGame = new Texture("NEWGAMEbutton.png");
	private Texture exitGame = new Texture("EXITbutton.png");
	private Texture settingsGame = new Texture("SETTINGSbutton.png");
	private Texture helpGame = new Texture("HELPbutton.png");
	private Texture mainText = new Texture("MAmain.png");
	private InputProcessor processor;
	public static Music music;
	public static Boolean back = false;
	public static Boolean musicPlayed = false;

	public GameMenu(Math game)
	{
		this.game = game;
		processor = this;
		Gdx.input.setInputProcessor(processor);
		music = Gdx.audio.newMusic(Gdx.files.internal("smile.mp3"));
		//if(back ==true  && musicPlayed == false)
			//musicPlayed = true;
		
		if(SettingScreen.musicOn == true && musicPlayed == false)
			{
				music.play();
				musicPlayed = true;
			}
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		game.batch.draw(mainText, game.width/2 - mainText.getWidth()/2,500);
		game.batch.draw(newGame, game.width/2 - newGame.getWidth()/2,400);
		game.batch.draw(exitGame, game.width/2 - exitGame.getWidth()/2,190);
		game.batch.draw(settingsGame, game.width/2 - settingsGame.getWidth()/2,330);
		game.batch.draw(helpGame, game.width/2 - helpGame.getWidth()/2,260);
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
	//wybranie odpowiedniej pozycji w menu g³ównym i przejœcie do nastêpnego ekranu
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(screenX > (game.width/2 - newGame.getWidth()/2) && screenX < (game.width/2 - newGame.getWidth()/2 + newGame.getWidth()) 
					 && screenY < (game.height - 400- 15 ) && screenY > game.height - 400 -newGame.getHeight() - 20 )
		{
			game.getScreen().dispose();
			game.setScreen(new LevelScreen(game));
		}
		if(screenX > (game.width/2 - settingsGame.getWidth()/2) && screenX < (game.width/2 - settingsGame.getWidth()/2 + newGame.getWidth()) 
				 && screenY < (game.height - 330- 15 ) && screenY > game.height - 330 -settingsGame.getHeight() - 20 )
		{
			game.getScreen().dispose();
			game.setScreen(new SettingScreen(game));
		}
		
		if(screenX > (game.width/2 - settingsGame.getWidth()/2) && screenX < (game.width/2 - settingsGame.getWidth()/2 + newGame.getWidth()) 
				 && screenY < (game.height - 260- 15 ) && screenY > game.height - 260 -settingsGame.getHeight() - 20 )
		{
			game.getScreen().dispose();
			game.setScreen(new HelpScreen(game));
		}
		
		if(screenX > (game.width/2 - exitGame.getWidth()/2) && screenX < (game.width/2 - exitGame.getWidth()/2 + exitGame.getWidth()) 
				 && screenY < (game.height - 190- 15 ) && screenY > game.height - 190 -exitGame.getHeight() - 20 )
		{
			game.getScreen().dispose();
			System.exit(0);
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
		// new game button
		if(screenX > (game.width/2 - newGame.getWidth()/2) && screenX < (game.width/2 - newGame.getWidth()/2 + newGame.getWidth()) 
				 && screenY < (game.height - 400- 15 ) && screenY > game.height - 400 -newGame.getHeight() - 20 )
				{
					newGame.dispose(); // usuwanie poprzedniego obrazka aby nie zape³nia³a siê pamiêc
					newGame = new Texture("NEWGAMEbuttonRED.png"); // zmiana koloru napisu aby wiedzieæ kiedy siê najedzie myszk¹ na przycisk
				}
			else
			{
				newGame.dispose();
				newGame = new Texture("NEWGAMEbutton.png");
			}
				
		// settings button
		if(screenX > (game.width/2 - settingsGame.getWidth()/2) && screenX < (game.width/2 - settingsGame.getWidth()/2 + settingsGame.getWidth()) 
				 && screenY < (game.height - 330- 15 ) && screenY > game.height - 330 -settingsGame.getHeight() - 20 )
				{
					settingsGame.dispose();
					settingsGame = new Texture("SETTINGSbuttonRED.png");
				}
			else
			{
				settingsGame.dispose();
				settingsGame = new Texture("SETTINGSbutton.png");
			}
				
		// help button
		if(screenX > (game.width/2 - helpGame.getWidth()/2) && screenX < (game.width/2 - helpGame.getWidth()/2 + helpGame.getWidth()) 
				 && screenY < (game.height - 260- 15 ) && screenY > game.height - 260 -helpGame.getHeight() - 20 )
				{
					helpGame.dispose();
					helpGame = new Texture("HELPbuttonRED.png");
				}
			else
			{
				helpGame.dispose();
				helpGame = new Texture("HELPbutton.png");	
			}
					
		
		// exit button
		if(screenX > (game.width/2 - exitGame.getWidth()/2) && screenX < (game.width/2 - exitGame.getWidth()/2 + exitGame.getWidth()) 
				 && screenY < (game.height - 190- 15 ) && screenY > game.height - 190 -exitGame.getHeight() - 20 )
				{
					exitGame.dispose();
					exitGame = new Texture("EXITbuttonRED.png");
				}
			else
			{
				exitGame.dispose();
				exitGame = new Texture("EXITbutton.png");
			}		
		
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
