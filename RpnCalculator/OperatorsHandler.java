import java.util.EmptyStackException;
import java.util.Stack;

public class OperatorsHandler {
	Stack<Double> st;
	private String str;
	
	public OperatorsHandler(String str, Stack<Double> st){
		this.st = st;
		this.str = str;
		
	}
	
	
	public void operate() {
		
		if(str.equals("+")) {
			
		try {
		 this.st.push((Double)this.st.pop() + (Double)this.st.pop());
	     RpnCalculatorGui.display.setText(str);
		}	
		catch(EmptyStackException e){
			RpnCalculatorGui.display.setText("Please enter one or more numbers.");	
		}
			
		}
		
		if(str.equals("-")) {
			try {
			 Double d = (Double)this.st.pop();
		     this.st.push((Double)this.st.pop() - d);
		     RpnCalculatorGui.display.setText("-");
			}
			catch(EmptyStackException e) {
				RpnCalculatorGui.display.setText("Stack empty.Please enter one or more numbers.");
				
			}
		}
		
		if(str.equals("/")) {
			
			try {
			Double d = (Double)this.st.pop();
	        if (d != 0.0D) {
	            this.st.push((Double)this.st.pop() / d);
	            RpnCalculatorGui.display.setText("/");
	        }
			}
	        catch(EmptyStackException e){
	        	RpnCalculatorGui.display.setText("Stack empty.Please enter one or more numbers.");
	        		
	        }
	        
		}
	        
	        
	    if(str.equals("*")) {
	    	
	    	try {
	    	this.st.push((Double)this.st.pop() * (Double)this.st.pop());
	        RpnCalculatorGui.display.setText("*");
	    	}
	    	catch(EmptyStackException e) {
	    		RpnCalculatorGui.display.setText("Stack empty.Please enter one or more numbers.");
	    		
	    	}
	    }
	    
	    if(str.equals("=")) {
	    	try {
	    	 String str = ((Double)this.st.pop()).toString();
	         RpnCalculatorGui.display.setText(str);
	    	}
	    	catch(EmptyStackException e) {	
	    		RpnCalculatorGui.display.setText("Stack empty.Please enter one or more numbers.");
	    		
	    	}
	    	
	    }
	    
	   
		
	}
        
		
}
