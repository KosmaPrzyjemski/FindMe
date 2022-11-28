package main;

import processing.core.PApplet;
import vueprocessing.FindMe;

public class Main {

	public static void main(String[] args){
		String[] processingArgs = {"FindMe"};
		FindMe mySketch = new FindMe();
		PApplet.runSketch(processingArgs, mySketch);
	}

}
