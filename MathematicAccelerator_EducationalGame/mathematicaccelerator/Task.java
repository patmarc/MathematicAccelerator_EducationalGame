package com.mygdx.mathematicaccelerator;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Task {
	public String fullNamePath;
	public Texture texture, textureElipseTrue, textureElipseFalse1,textureElipseFalse2;
	private Integer number;
	Integer num;
	Integer num2;
	public static Integer startNumber; // numer ustawiany podczas wyboru poziomu
	
	public Task()
	{
		LotteryTask();
	}
		
	public Task LotteryTask (){   				// funkcja losuje numer rownania z okreslonego zakresu  
		String choice = "rownanie";				//przez wybranie odpowiedniego poziomu w LevelScreen
		String extention = ".png";
		Random generator = new Random();
		number = generator.nextInt(30)+startNumber; // losowanie numeru zadania z przedzia³u np 1-30 
		String fullNamePict = choice + extention; 	// wybrano poziom 1
		this.fullNamePath = choice + number.toString() +"/";
		texture = new Texture (fullNamePath + fullNamePict);
		LotteryElipseTexture();
		return this;
	}
	
	public void LotteryElipseTexture() 		
	{
		textureElipseTrue = new Texture(fullNamePath +"o.png"); // prawid³owa odpowiedz jest okreœlona zawsze t¹ sam¹ nazw¹ 
		
		do{
		Random generator = new Random();
		num = generator.nextInt(30)+ startNumber;
		//Gdx.app.log("MyTag", num.toString());
		
		}while(num == number);
		textureElipseFalse1 = new Texture("elipses/" + num.toString() +".png"); // ustawienie fa³szywej odpowiedzi
		
		do{
			Random generator = new Random();
			num2 = generator.nextInt(30)+ startNumber; // losowanie numeru fa³szywej odpowiedzi
			
			}while(num2 == number || num2 == num);
		textureElipseFalse2 = new Texture("elipses/" + num2.toString() +".png"); // ustwienie tekstury dla elipsy fa³szywej
		
	}
	
	
	
	
}
