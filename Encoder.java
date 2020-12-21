/**
 * Program that encodes a given string.
 *
 * @author Tobias Ephron
 * @version Dec. 21, 2020
 */

import java.util.*;

public class Encoder{

	String[] alph = {"a","b","c","d","e","f",
					 "g","h","i","j","k","l",
					 "m","n","o","p","q","r",
					 "s","t","u","v","w","x","y","z"};
	private String[] alphKey = {"y","w","z","e","o","u",
										"c","g","m","k","a","x",
										"l","v","p","i","s","d",
										"q","j","f","t","b","n","h","r"};

	public Encoder(){
		this.alph = alph;
		this.alphKey = alphKey;
	}

	public static void main(String[] args){
		Encoder e = new Encoder();
		String input = "";

		// e.printArr(e.alph);
		// e.printArr(e.alphKey);

		input = e.getInput();
		System.out.println("");

		String encoded = e.encode(input);
		System.out.println("Your message encoded:");
		System.out.println(encoded);
	}

	public String getInput(){
		Scanner s = new Scanner(System.in);
		System.out.println("What would you like to encode?");
		return s.nextLine();
	}

	public String encode(String message){
		String eMessage = "";
		for(int i=0;i<message.length();i++){
			try{
				if(message.substring(i,i+1).equals(" ")) eMessage += " ";
				else{
					eMessage += this.alphKey[this.indexOf(this.alph,message.substring(i,i+1))];
				}
			} catch(ArrayIndexOutOfBoundsException e){
				return "Not a valid input";
			}
		}
		return eMessage;
	}

	public void printArr(String[] arr){
		System.out.println("");
		System.out.print("[");
		for(int i=0;i<arr.length-1;i++){
			System.out.print(arr[i] + ",");
		}
		System.out.print(arr[arr.length-1] + "]");
		System.out.println("");
	}

	public int indexOf(String[] arr, String x){
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals(x)) return i;
		}
		return -1;
	}
}