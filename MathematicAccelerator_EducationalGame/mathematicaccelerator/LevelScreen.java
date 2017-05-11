package com.mygdx.mathematicaccelerator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class LevelScreen implements Screen, InputProcessor {

	private Math game;
	private InputProcessor processor;
	private Texture level1 = new Texture("LEVEL1button.png");
	private Texture level2 = new Texture("LEVEL2button.png");
	private Texture level3 = new Texture("LEVEL3button.png");
	private Texture level4 = new Texture("LEVEL4button.png");
	private Texture level5 = new Texture("LEVEL5button.png");
	private Texture level6 = new Texture("LEVEL6button.png");
	
	public LevelScreen(Math game)
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
		game.batch.draw(level1, game.width/2 - level1.getWidth()/2,600);
		game.batch.draw(level2, game.width/2 - level2.getWidth()/2,530);
		game.batch.draw(level3, game.width/2 - level3.getWidth()/2,460);
		game.batch.draw(level4, game.width/2 - level4.getWidth()/2,390);
		game.batch.draw(level5, game.width/2 - level5.getWidth()/2,320);
		game.batch.draw(level6, game.width/2 - level6.getWidth()/2,250);
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
		if(screenX > (game.width/2 - level1.getWidth()/2) && screenX < (game.width/2 - level1.getWidth()/2 + level1.getWidth()) 
				 && screenY < (game.height - 600- 15 ) && screenY > game.height - 600 -level1.getHeight() - 20 )
		{
				Task.startNumber = 1;
				game.getScreen().dispose();
				game.setScreen(new KnowledgeScreen(game));
		}
		if(screenX > (game.width/2 - level2.getWidth()/2) && screenX < (game.width/2 - level2.getWidth()/2 + level2.getWidth()) 
				 && screenY < (game.height - 530- 15 ) && screenY > game.height - 530 -level2.getHeight() - 20 )
		{
				Task.startNumber = 31;
				game.getScreen().dispose();
				game.setScreen(new KnowledgeScreen2(game));
		}
		if(screenX > (game.width/2 - level3.getWidth()/2) && screenX < (game.width/2 - level3.getWidth()/2 + level3.getWidth()) 
				 && screenY < (game.height - 460- 15 ) && screenY > game.height - 460 -level3.getHeight() - 20 )
		{
				Task.startNumber = 61;
				game.getScreen().dispose();
				game.setScreen(new KnowledgeScreen3(game));
		}
		if(screenX > (game.width/2 - level4.getWidth()/2) && screenX < (game.width/2 - level4.getWidth()/2 + level4.getWidth()) 
				 && screenY < (game.height - 390- 15 ) && screenY > game.height - 390 -level4.getHeight() - 20 )
		{
				Task.startNumber = 91;
				game.getScreen().dispose();
				game.setScreen(new KnowledgeScreen4(game));
		}
		if(screenX > (game.width/2 - level5.getWidth()/2) && screenX < (game.width/2 - level5.getWidth()/2 + level5.getWidth()) 
				 && screenY < (game.height - 320- 15 ) && screenY > game.height - 320 -level5.getHeight() - 20 )
		{
				Task.startNumber = 121;
				game.getScreen().dispose();
				game.setScreen(new KnowledgeScreen5(game));
		}
		if(screenX > (game.width/2 - level6.getWidth()/2) && screenX < (game.width/2 - level6.getWidth()/2 + level6.getWidth()) 
				 && screenY < (game.height - 250- 15 ) && screenY > game.height - 250 -level6.getHeight() - 20 )
		{
				Task.startNumber = 151;
				game.getScreen().dispose();
				game.setScreen(new KnowledgeScreen6(game));
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
		// level 1 
		if(screenX > (game.width/2 - level1.getWidth()/2) && screenX < (game.width/2 - level1.getWidth()/2 + level1.getWidth()) 
				 && screenY < (game.height - 600- 15 ) && screenY > game.height - 600 -level1.getHeight() - 20 )
				level1 = new Texture("LEVEL1buttonRED.png");
			else
				level1 = new Texture("LEVEL1button.png");
		
		// level 2
		if(screenX > (game.width/2 - level2.getWidth()/2) && screenX < (game.width/2 - level2.getWidth()/2 + level2.getWidth()) 
				 && screenY < (game.height - 530- 15 ) && screenY > game.height - 530 -level2.getHeight() - 20 )
				level2 = new Texture("LEVEL2buttonRED.png");
			else
				level2 = new Texture("LEVEL2button.png");
		// level 3
		if(screenX > (game.width/2 - level3.getWidth()/2) && screenX < (game.width/2 - level3.getWidth()/2 + level3.getWidth()) 
				 && screenY < (game.height - 460- 15 ) && screenY > game.height - 460 -level3.getHeight() - 20 )
				level3 = new Texture("LEVEL3buttonRED.png");
			else
				level3 = new Texture("LEVEL3button.png");
		
		// level 4
		if(screenX > (game.width/2 - level4.getWidth()/2) && screenX < (game.width/2 - level4.getWidth()/2 + level4.getWidth()) 
				 && screenY < (game.height - 390- 15 ) && screenY > game.height - 390 -level4.getHeight() - 20 )
				level4 = new Texture("LEVEL4buttonRED.png");
			else
				level4 = new Texture("LEVEL4button.png");
		
		// level 5
		if(screenX > (game.width/2 - level5.getWidth()/2) && screenX < (game.width/2 - level5.getWidth()/2 + level5.getWidth()) 
				 && screenY < (game.height - 320- 15 ) && screenY > game.height - 320 -level5.getHeight() - 20 )
				level5 = new Texture("LEVEL5buttonRED.png");
			else
				level5 = new Texture("LEVEL5button.png");
		
		// level 6
		if(screenX > (game.width/2 - level6.getWidth()/2) && screenX < (game.width/2 - level6.getWidth()/2 + level6.getWidth()) 
				 && screenY < (game.height - 25- 15 ) && screenY > game.height - 250 -level6.getHeight() - 20 )
				level6 = new Texture("LEVEL6buttonRED.png");
			else
				level6 = new Texture("LEVEL6button.png");		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
