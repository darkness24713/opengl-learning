package com.training.opengl;

public class Game {

	public static void main(String[] ASD){
		Renderer rend = new Renderer(500,500,"test");
		rend.loop();
		rend.freeWindow();
	}
	
}
