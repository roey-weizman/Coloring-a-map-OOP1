
public class NumberPartition {

	
    /*
	* Check if a characteristic string defines a partition 
    * of the numbers 1...n  such that:
    * (1) both sides are of equal length
    * (2) both sides are of equal sum
    * (3) both sides have equal sums of squared elements.
    * returns false if arguments are null / "incorrect"
	*/
    public static boolean isNumberPartition(int n, String s){
        boolean ans=true;
	       if((s ==null)||(n!=s.length())||(s.length()<2)||n<1)		///checking if the input is correct.
	    	   ans=false;
	       for(int j=0;(j<s.length())&&ans;j++){					///checks if the string contains zeros and ones only.
	    	   if((s.charAt(j)!='0')&&(s.charAt(j)!='1'))
	    		   ans=false;
	       }
	       int cnt0=0;int cnt1=0; int sum0=0; int sum1=0; int squreSum0=0;int squreSum1=0;
	       for(int i=1;(i<=s.length())&&ans;i++){					//loop that counts the tree conditions of characteristic string
	    	   if(s.charAt(i-1)=='0'){
	    		   cnt0=cnt0+1;										///sums the number of zero's in the string.
	    		   sum0=sum0+i;										///sums the index's number of zero's in the string.
	    		   squreSum0=squreSum0+i*i;							///sums the square of the index's number of zero in the string.
	    	   }
	    	   if(s.charAt(i-1)=='1'){
	    		   cnt1=cnt1+1;										///sums the number of one's in the string.
	    		   sum1=sum1+i;										///sums the index's number of one's in the string.
	    		   squreSum1=squreSum1+i*i;							///sums the square of the index's number of one's in the string.
	    	   }
	       }
	       if((cnt0!=cnt1||sum0!=sum1||squreSum0!=squreSum1)&&ans) //checks if the conditions are correct
	    	   ans=false;
	       
	       return ans;
	    }
	// Restart an empty string in the matching size.
    public static void numberPartition(int n){
    	if (n > 0) {
			numberPartition(n,"");
		}
    }
	
	// Recursively filling the string with one's and zero's and printing the true strings.
    private static void numberPartition(int n, String acc){
        if(acc.length()==n){
        	if(isNumberPartition(n, acc)==true){
        		System.out.println(acc);
        	}
        }
        else{
        	numberPartition(n, acc+"0");			///Recursively filling the string with zero's.
        	numberPartition(n, acc+"1");			///Recursively filling the string with one's.
        }
    }
}
