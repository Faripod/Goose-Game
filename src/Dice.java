
public class Dice {
		public int result;

		

		//metodi di supporto per il lancio del dado
		private int oneDieThrow() {	
        return ((int) (Math.random()*10000) % 6)+ 1; 
		}
		
	    public   int twoDiceThrow() {
	        this.result = oneDieThrow() + oneDieThrow();
	        return result;
	    }
	    
	    public int getResult() {
			return result;
		}
	    
		public void setResult(int result) {
			
			this.result = result;
		}

		@Override
		public String toString() {
			return ("The result of the two dice is " + result+".");
		}
	    
	    
}
