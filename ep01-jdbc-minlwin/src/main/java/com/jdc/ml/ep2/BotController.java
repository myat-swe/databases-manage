package com.jdc.ml.ep2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BotController{

	private Robbot rob;
	Scanner sc;

	BotController(){
		rob = new Robbot();
		sc  = new Scanner(System.in);	}

	public static void main(String[] args) {
		var cont = new BotController();
		cont.doBusiness();
	}
	
	public void doBusiness(){
		System.out.println("============================");
		System.out.println("=====Welcome Mr Robbot======");
		System.out.println("============================");
		System.out.println();

		while(true){
			System.out.print("You > ");
			String message = sc.nextLine();

			if("Exit".equalsIgnoreCase(message)){
				break;
			}

			String result = rob.talk(message);
			System.out.printf("Bot > %s%n%n", result);
		}
		System.out.println("Thank You");
	}
}
class Robbot{
	private Map<String, String> dictionary;
	private String question;
	private String message;

	Robbot(){
		dictionary = new HashMap<>();
		dictionary.put("name", "Mr Bot");
		question = null;
	}

	public String talk(String message){
		
		if(null != question){
			dictionary.put("question", "message");
			question = null;
			return "Thank for teaching";
		} 


		String value = dictionary.get(message.toLowerCase());

		if(null != value){
			return value;
		}

		this.question = message.toLowerCase();
//		this.message = message.toLowerCase();

		return "I have no Idea. Please Teach ME";
	}
}
