import java.util.Arrays;

public class Sezax_Examinee {

	public static void main(String[] args) {
		// Test.
		System.out.print(PokerHand("S8D3HQS3CQ"));
	}
	
	// Function PokerHand.
	public static String PokerHand(String str) {
		
		// Check length of string input has 5 cards (size = 10).
		if(str.length()!= 10) {
			return "Error input!";
		}
		
		// Array rank of cards.
		char[] rank = new char[5];
		// Array frequency of cards.
		int[] fre  = new int[5];
		
		// Select digits in String input add to the rank array.
		try {
			for(int i = 0; i < rank.length; i++) {
				rank[i] = (char)str.charAt(i*2 + 1);
			}
		} catch (Exception e) {
			System.out.print("Error input!");
		}
		
		// Sort rank array.
		Arrays.sort(rank);
		
		// Temporary variable to count frequency.
		int count = 0;
		
		// Count the frequency.
		for(int i = 0; i < rank.length ; i++) {
			count ++;
			
			// Check is the last element.
			if(i == rank.length-1) {
				fre[i-1] = count;
				break;
			}
			
			if(rank[i +1] != rank[i]) {
				fre[i] = count;
				count = 0;
			}
		}
        
        // Can not have 5 the same cards in a rank.
        if( countDigis(fre, 5) > 0) {
        	return "Error input!";
        }
        
        // 4 cards out of 5 has the same Rank.
        if( countDigis(fre, 4) > 0) {
        	return "4C";
        }
        
        // 5 cards include One pair and Three cards. 
        if( countDigis(fre, 3) > 0 && countDigis(fre, 2) > 0) {
        	return "FH";
        }
        
        // 3 cards out of 5 have the same Rank.
        if( countDigis(fre, 3) > 0) {
        	return "3C";
        }
        
        // 5 cards include 2 pairs.
        if( countDigis(fre, 2) > 1) {
        	return "2P";
        }
        
        // 2 cards out of 5 have the same rank.
        if( countDigis(fre, 2) > 0) {
        	return "1P";
        }
        
		return "";
	}
	
	// Function count the number of a digit in array.
	public static int countDigis(int arr[], int digit) {
		int count = 0;
		for( int i = 0; i < arr.length; i++) {
			if( arr[i] == digit) {
				count ++;
			}
		}
		return count;
	}
}
