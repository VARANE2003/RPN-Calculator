
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonHandler implements ActionListener {
    private String s;
	public ButtonHandler(String s) {
		this.s = s;
    }

    public void actionPerformed(ActionEvent pushingButton) {
        
        //Cases of "+", "-", "/", "*", "=", "ENTER", "BACKSPACE", "C", "CE", "."(dot)
        
        if(s.equals("+"))
       	 RpnCalculatorGui.add.operate();
       
        if(s.equals("-"))
       	 RpnCalculatorGui.sub.operate();
       
        if(s.equals("/"))
       	 RpnCalculatorGui.div.operate();
        
        if(s.equals("*"))
       	 RpnCalculatorGui.mul.operate();
        
        if(s.equals("="))
        	RpnCalculatorGui.eq.operate();
        
        if(s.equals("ENTER"))
         try {
       	 RpnCalculatorGui.op.complete();
         }
        catch(NumberFormatException n){
        	RpnCalculatorGui.display.setText("Multiple points not permitted");
        }
       
        if(s.equals("BackSpace"))
       	 RpnCalculatorGui.op.deleteLastDigit();
       
        if(s.equals("C"))
       	 RpnCalculatorGui.op.reset();
        

        if(s.equals("CE"))
          	 RpnCalculatorGui.op.clearentry();
        

        if(s.equals("."))
       	 RpnCalculatorGui.op.addDigit(s.charAt(0));
       
        
        //Case of a number  
        
        if(Character.isDigit(s.charAt(0)))
        	RpnCalculatorGui.op.addDigit(s.charAt(0));
        	
    }
}
