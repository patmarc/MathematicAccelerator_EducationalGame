package com.mygdx.mathematicaccelerator;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * @author Patrycja Marchewka
 *
 */
public class MathematicAccelerator implements Screen, InputProcessor{ /** g³ówna gra */
	
	public SpriteBatch batch;
	private Texture ship,speedImg, damageImg, gap, pause, star;
	private GameObject objShip;
	private BitmapFont speed, damage;
	private Integer damageShip, stateShip1 =0, stateShip2 =0, licznik =0, change = 0 ;
	public static Integer speedShip;
	//private Integer randomX, randomY;
	private List<Elipse> elipseOBJ ;
	private Elipse elipseCol1, elipseCol2, elipseColTrue;
	private Texture problem;
	private Task task;
	private Integer number;
	private Boolean notMove; 
	public static Boolean paused;
	public final int MathWidth = 1024;
	public final int MathHeight = 768;
	private InputProcessor proc = this;
	private Math game;
	public static Boolean backGame = false;
	
	
	
	int speedHelper = 1;
	int y1,y2,y3,y4,y5,y6,y7,y8,y9,y10;
	
	/**
	 * @param game
	 */
	/**
	 * @param game
	 */
	/**
	 * @param game
	 */
	public MathematicAccelerator(Math game)				/**pocz¹tkowa inicjalizacja zmiennych */
	{
		this.game = game;
		proc = this;
		Gdx.input.setInputProcessor(proc);
		batch = new SpriteBatch();	
		// download photo
		ship = new Texture("ship2.png");
		speedImg = new Texture("speed1.png");
		damageImg = new Texture("damage.png");
		pause = new Texture ("pause.png");
		gap = new Texture ("gap.png");
		star = new Texture ("star.png");
		notMove = false;
		paused = false;
		
		
		
		//task = new Task();
		//problem = task.texture;
		
		//elipsy
		elipseOBJ = new ArrayList<Elipse>();		/** tworzenie elips jako lista */
		elipseOBJ.add(new Elipse(20, 480));
		elipseOBJ.add(new Elipse(280,480));
		elipseOBJ.add(new Elipse(540,480));	
		
		setElipse();
		
		
		//fonts
		speed = new BitmapFont();		/**ustawienie koloru czcionki prêdkoœci i uszkodzeñ */
		speed.setColor(Color.RED);
		damage = new BitmapFont();
		damage.setColor(Color.RED);
		
		
		objShip = new GameObject(ship);		/** parametry statku i tworzenie */
		objShip.x = 320;
		objShip.y = 50;
		objShip.width = 150;//objShip.getTexture().getWidth();
		objShip.height = 150;//objShip.getTexture().getHeight();
		speedShip = 100;
		damageShip = 0;
		
	}
	


	private void StarGenerator() {		/** tworzenie t³a aby mo¿na by³o dostrzec poruszanie siê */
		
		Random generator = new Random();
		if(y1 < 0)
			y1 = generator.nextInt(700);
		Random generator2 = new Random(); 
		if(y2 < 0)
			y2 = generator2.nextInt(700);
		Random generator3 = new Random();
		if(y3 < 0)
			y3 = generator3.nextInt(700);
		Random generator4 = new Random(); 
		if(y4 < 0)
			y4 = generator4.nextInt(700);
		Random generator5 = new Random();
		if(y5 < 0)
			y5 = generator5.nextInt(700);
		Random generator6 = new Random();
		if(y6 < 0)
			y6 = generator6.nextInt(700);
		Random generator7 = new Random();
		if(y7 < 0)
			y7 = generator7.nextInt(700);
		Random generator8 = new Random(); 
		if(y8 < 0)
			y8 = generator8.nextInt(700);
		Random generator9 = new Random();
		if(y9 < 0)
			y9 = generator9.nextInt(700);
		Random generator10 = new Random(); 
		if(y10 < 0)
			y10 = generator10.nextInt(700);
		
		
	}
	

	private void setElipse(){		// funkcja ustawia elipsy jedn¹ z prawid³ow¹ odpowiedzi¹
		task = new Task();			//  i dwie z fa³szywymi odpowiedziami
		problem = task.texture;
		Random generator = new Random(); 
		number = generator.nextInt(3);
		elipseOBJ.get(number).setTexture(task.textureElipseTrue);
		if (number == 0)
		{
			elipseOBJ.get(1).setTexture(task.textureElipseFalse1);
			elipseOBJ.get(2).setTexture(task.textureElipseFalse2);
			elipseCol1 = elipseOBJ.get(1);
			elipseCol2 = elipseOBJ.get(2);
			elipseColTrue = elipseOBJ.get(0);
		}
		
		if (number == 1)
		{
			elipseOBJ.get(0).setTexture(task.textureElipseFalse1);
			elipseOBJ.get(2).setTexture(task.textureElipseFalse2);
			elipseCol1 = elipseOBJ.get(0);
			elipseCol2 = elipseOBJ.get(2);
			elipseColTrue = elipseOBJ.get(1);
		}
		
		if (number == 2)
		{
			elipseOBJ.get(1).setTexture(task.textureElipseFalse1);
			elipseOBJ.get(0).setTexture(task.textureElipseFalse2);	
			elipseCol1 = elipseOBJ.get(1);
			elipseCol2 = elipseOBJ.get(0);
			elipseColTrue = elipseOBJ.get(2);
		}
	}
	public void create() {
		
		
	}

	@Override
	public void render(float delta) {
		if(paused)
		{
			
		}
		else
			update();

		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		//elipsy + statek 
		batch.draw(objShip.getTexture(), objShip.x, objShip.y,150,150 );
		batch.draw(elipseOBJ.get(0).getTexture(), elipseOBJ.get(0).x, elipseOBJ.get(0).y);
		batch.draw(elipseOBJ.get(1).getTexture(), elipseOBJ.get(1).x, elipseOBJ.get(1).y);
		batch.draw(elipseOBJ.get(2).getTexture(), elipseOBJ.get(2).x, elipseOBJ.get(2).y);
		batch.draw(elipseOBJ.get(0).getTexture(), elipseOBJ.get(0).x, elipseOBJ.get(0).y);
		batch.draw(problem, 0,650, 800, 100);
		
		// rysowanie t³a poruszaj¹cego siê 
		StarGenerator();
		batch.draw(star, 30, y1);
		batch.draw(star, 80, y2);
		batch.draw(star, 130, y3);
		batch.draw(star, 180, y4);
		batch.draw(star, 230, y5);
		batch.draw(star, 280, y6);
		batch.draw(star, 330, y7);
		batch.draw(star, 380, y8);
		batch.draw(star, 560, y9);
		batch.draw(star, 470, y10);
		batch.draw(star, 44, y1+10);
		batch.draw(star, 590, y2+50);
		batch.draw(star, 355, y3+30);
		batch.draw(star, 680, y4+36);
		batch.draw(star, 645, y5+34);
		batch.draw(star, 610, y6+49);
		batch.draw(star, 590, y7+34);
		batch.draw(star, 480, y8+23);
		batch.draw(star, 420, y9+30);
		batch.draw(star, 399, y10+28);	
		batch.draw(star, 44, y1+150);
		batch.draw(star, 590, y2+150);
		batch.draw(star, 680, y4+150);
		batch.draw(star, 645, y5+150);
		batch.draw(star, 610, y6+150);
		batch.draw(star, 590, y7+150);
		batch.draw(star, 480, y8+150);
		batch.draw(star, 420, y9+150);
		batch.draw(star, 399, y10+150);
		
		
		// panel po prawej
		batch.draw(speedImg,860,420);
		batch.draw(damageImg,845,220);
		batch.draw(gap, 805,0);
		batch.draw(pause, 825,580);
		//wartosci na panelu po prawej
		speed.draw(batch,speedShip.toString(),905,400);
		damage.draw(batch,damageShip.toString(),910,200);
		batch.end();
	}

	private void update() {
		
		if (speedShip > 150)
			speedHelper = speedShip/150;
		//obs³uga klawiatury - poruszanie statkiem
		if (Gdx.input.isKeyJustPressed(Keys.A) && notMove == false) {
			if(objShip.x == 320)				// 120 320 580
				objShip.x = 80;
			if(objShip.x == 585)
				objShip.x = 320;
		}
		if (Gdx.input.isKeyJustPressed(Keys.D) && notMove == false) {
			if(objShip.x == 320)
				objShip.x = 585;
			if(objShip.x == 80)
				objShip.x = 320;
		}
		//poruszanie elipsami
		elipseOBJ.get(0).y -=1 * speedHelper;
		elipseOBJ.get(1).y -=1 * speedHelper;
		elipseOBJ.get(2).y -=1 * speedHelper;
		
		if(elipseOBJ.get(0).y < -150 & change == 0)		// zmiana pytania
			{
			setElipse();
			change = 1;
			}
		
		
		if(elipseOBJ.get(0).y < -450)
			{
			elipseOBJ.get(0).y = 650;
			change = 0;
			}
		if(elipseOBJ.get(1).y < -450)
			elipseOBJ.get(1).y = 650;
		if(elipseOBJ.get(2).y < -450)
			elipseOBJ.get(2).y = 650;
		
		//zmiana stanu licznika prêdkoœci
		
		licznik +=1;
		if(licznik == 10 )
		{
			speedShip += 1;
			licznik =0;
		}
		
		// pierwsza kolizja
		if(objShip.overlaps(elipseCol1)){ // nabieranie uszkodzen
			stateShip1 =1;
			notMove = true;
		}
		if(objShip.overlaps(elipseCol1) == false){
			if(stateShip1==1)
			damageShip+=1;
			stateShip1 =0;
		}
		
		//druga kolizja
		if(objShip.overlaps(elipseCol2)){ // nabieranie uszkodzen
			stateShip2 =1;
			notMove = true;
			
		}
		if(objShip.overlaps(elipseCol2) == false){ 
			if(stateShip2==1)
			damageShip+=1;
			stateShip2 =0;
			
		}
		
		if(damageShip== 3)		//zakoñzenie gry podczas zdobycia trzech uszkodzeñ
		{

			game.setScreen(new GameOver(game));
		}
			
		
		if (objShip.overlaps(elipseColTrue)) // kolizja wykrywana aby statek siê nie porusza³
			notMove = true;
		
		// aby statek siê nie porusza³ podczas przekraczanie elipsy
		if(stateShip2 == 0 &&  stateShip1 == 0 && objShip.overlaps(elipseColTrue) == false)
			notMove = false;
		
		// poruszanie t³em, wraz ze zmian¹ prêdkoœci
		y1 -=1 * speedHelper;
		y2 -=1 * speedHelper;
		y3 -=1 * speedHelper;
		y4 -=1 * speedHelper;
		y5 -=1 * speedHelper;
		y6 -=1 * speedHelper;
		y7 -=1 * speedHelper;
		y8 -=1 * speedHelper;
		y9 -=1 * speedHelper;
		y10 -=1 * speedHelper;
		StarGenerator();
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		ship.dispose();
		speed.dispose();
		damage.dispose();
	}



	@Override
	public void show() {
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
	// pauzowanie gry gdy zmienna paused = true gra przestaje byæ aktualizowana
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(screenX > 890 && screenX < 950 && screenY < (768 - 605 ) && screenY > (768 - 605-65 ) && paused == false )
			{
			paused = true;
			//game.setScreen(new PauseScreen(game));
			}
		
		else
			if(screenX > 890 && screenX < 950 && screenY < (768 - 605 ) && screenY > (768 - 605 -65 ) && paused == true )
				paused = false;
		
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
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
