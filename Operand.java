import java.util.Stack;

public class Operand implements OperandIf {
    Stack<Double> st;
    private StringBuffer sb = new StringBuffer();

    public Operand(Stack<Double> st) {
        this.st = st;
    }

    
    public void addDigit(char digit) {
        this.sb.append(digit);
        RpnCalculatorGui.display.setText((this.sb).toString());
        
    }

    public void deleteLastDigit() {
        if (this.sb.length() > 0) {
            this.sb.deleteCharAt(this.sb.length() - 1);
            RpnCalculatorGui.display.setText((this.sb).toString());
            
        }

    }
    
    public void clearentry() {
    	
    	if (this.sb.length() > 0) {
            this.sb.delete(0, this.sb.length());
            RpnCalculatorGui.display.setText((this.sb).toString());
    	}    
    	
    }

    public void reset() {
        this.sb.setLength(0);
        this.st.removeAllElements();
        RpnCalculatorGui.display.setText((this.sb).toString());
    }

    public void complete() {
        if (this.sb.length() > 0) {
            this.st.push(Double.parseDouble(this.sb.toString()));
            RpnCalculatorGui.display.setText((this.sb).toString());
            this.sb.delete(0, this.sb.length());
        }

    }

   
}
