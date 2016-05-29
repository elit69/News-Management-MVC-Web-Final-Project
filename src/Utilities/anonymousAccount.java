package Utilities;

import java.util.Random;

import Model.DTO.User;

public class anonymousAccount {
	private String p1="CHETRA";
	private String p2="ELITE";
	private String p3="sarin";
	private String p4="SAMBO";
	private String p5="channa";
	private int num = 39218;
	public anonymousAccount(){}
	public String generateUserName(){
		Random r = new Random();

	    String alphabet = p1+p2+p3+p3+p5;
	    for (int i = 0; i < 15; i++) {
	        System.out.print(alphabet.charAt(r.nextInt(alphabet.length())));
	    }
		
		return null;
	}
	public int generateUserID(){
		Random rn = new Random();
		int n = 0 - 39218 + 1;
		int i = rn.nextInt() % n;
		int randomNum =  10 + i;
		return randomNum;
	}
	/*public static void main(String[] args) {
		User u=new User();
		u.setUser_id(new anonymousAccount().generateUserID());
		u.setUser_name(new anonymousAccount().generateUserName());
		System.out.println(u.getUser_name()+"--"+u.getUser_id());
	}*/
}
