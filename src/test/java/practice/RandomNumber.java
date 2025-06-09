package practice;

import java.security.SecureRandom;
import java.util.ArrayList;

public class RandomNumber {

	public static void main(String[] args) 
	{
//		System.out.println(Math.random());
//		
//	
//		
//		int lowerBound = 1;
//        int upperBound = 101; // Exclusive upper bound
//        int randomInt = 1 + (int) (Math.random() * (101 - 1));
//        int randomInt1 = (int) (Math.random() * (101));
//        System.out.println(randomInt1);
		
//		
//		
//		SecureRandom rand = new SecureRandom();
//		
//        int upperbound = 1000;
//        int int_random1 = rand.nextInt(upperbound);
//		System.out.println(int_random1);
//		
	//***************************************************************	
//		SecureRandom random = new SecureRandom();
//
//	    int max=50;
//	    int min =1;
//
//	    System.out.println(random.nextInt(max-min+1)+min);
		
//   // find the string out of the 10 string randomly
//        
//        ArrayList <String> jackpotList = new ArrayList();
//        jackpotList.add("A");
//        jackpotList.add("B");
//        jackpotList.add("C");
//        jackpotList.add("D");
//        jackpotList.add("E");
//        jackpotList.add("F");
//        jackpotList.add("G");
//        jackpotList.add("H");
//        jackpotList.add("I");
//        jackpotList.add("J");
//        
//        int lowerlimit =0;
//        int upperlimit = jackpotList.size();
//        
//        int random  = 0+(int)(Math.random()*(upperlimit-lowerlimit));
//        System.out.println(jackpotList.get(random));
        
// find the string out of the 10 string randomly-  jackpot lottery
        
        ArrayList <String> jackpotList = new ArrayList();
        jackpotList.add("A");
        jackpotList.add("B");
        jackpotList.add("C");
        jackpotList.add("D");
        jackpotList.add("E");
        jackpotList.add("F");
        jackpotList.add("G");
        jackpotList.add("H");
        jackpotList.add("I");
        jackpotList.add("J");
        
        int min =0;
        int max = jackpotList.size();
        
        SecureRandom rand = new SecureRandom();
        
        int random  = (rand.nextInt(max-min+1)+min);
        System.out.println(random);
        
        System.out.println(jackpotList.get(random));
        
	}

}
