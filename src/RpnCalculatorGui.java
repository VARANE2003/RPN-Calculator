import java.awt.*;

import java.awt.event.*;
import java.util.Stack;


public class RpnCalculatorGui extends Frame {
   
	private Button button0;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;

	static TextField display;
	 
	public Button buttonPlus;
	public Button buttonDiv;
	public Button buttonEnter;
	public Button buttonBackSpace;
	public Button buttonReset;
	public Button buttonResultPresenter;
	private Button buttonMin;
	private Button buttonMul; 
	private Button buttonDot;
	private Button buttonCE;
	
	static Stack<Double> st = new Stack<Double>();
	static Operand op = new Operand(st);    //ðáñáôçñù ðùò ðñåðåé íá áñ÷éêïðïéçèïõí óå áõôï ôï óçìåéï ôá st,op êáé ï÷é ìåóá óôïí constructor!!
	
	static OperatorsHandler add;
	static OperatorsHandler div;
    static OperatorsHandler eq;
	static OperatorsHandler sub;
	static OperatorsHandler mul;

	static RpnCalculatorGui cg;
	
	
	
	public static void main(String[] args) {
		
		
		cg = new RpnCalculatorGui("RPN Calculator", op );	
		
		
	}
	
	
	public RpnCalculatorGui(String title, OperandIf op) {
		
	        
		super(title);
		
		
		add = new OperatorsHandler("+", st);
		sub = new OperatorsHandler("-", st);
		div = new OperatorsHandler("/", st);
		mul = new OperatorsHandler("*", st);
		
		eq = new OperatorsHandler("=", st);
		
		this.setLayout(null);
		this.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		this.setBackground(Color.blue);
		
		
		
		button0 = createButton("0", 64, 265, 35, 28, "Arial", Color.blue, null);
		button1 = createButton("1", 64, 232, 35, 28, "Arial", Color.blue, null);
		button2 = createButton("2", 100, 232, 35, 28, "Arial", Color.blue, null);
		button3 = createButton("3", 136, 232, 35, 28, "Arial", Color.blue, null);
		button4 = createButton("4", 64, 196, 35, 28, "Arial", Color.blue, null);
		button5 = createButton("5", 100, 196, 35, 28, "Arial", Color.blue, null);
		button6 = createButton("6", 136, 196, 35, 28, "Arial", Color.blue, null);
		button7 = createButton("7", 64, 160, 35, 28, "Arial", Color.blue, null);
		button8 = createButton("8", 100, 160, 35, 28, "Arial", Color.blue, null);
		button9 = createButton("9", 136, 160, 35, 28, "Arial", Color.blue, null);
		buttonResultPresenter = createButton("=", 175, 265, 35, 28, "Arial", Color.blue, Color.cyan);
		buttonEnter = createButton("ENTER", 208, 90, 56, 28, "Arial", Color.white, Color.red);
		buttonBackSpace = createButton("BackSpace", 100, 125, 73, 28, "Arial", Color.blue, Color.yellow);
		buttonDot = createButton(".", 136, 265, 35, 28, "Arial", Color.blue, null);
	    buttonReset = createButton("C", 64, 125, 35, 28, "Arial", Color.blue, Color.yellow);
		buttonPlus = createButton("+", 175, 232, 35, 28, "Arial", Color.blue, Color.cyan); 
		buttonMin = createButton("-", 175, 196, 35, 28, "Arial", Color.blue, Color.cyan);
		buttonDiv = createButton("/", 175, 160, 35, 28, "Arial", Color.blue, Color.cyan);
		buttonMul = createButton("*", 175, 125, 35, 28, "Arial", Color.blue, Color.cyan);
		buttonCE = createButton("CE",28, 125, 35, 28, "Arial", Color.blue, Color.yellow);
		
		
/*		
		button0 = new Button("0");
		button0.setBounds(64, 265, 35, 28);
		button0.setFont(new Font("TimesRoman", Font.PLAIN, 14));
	    button0.setForeground(Color.blue);
	    button0.addActionListener(new Button0Handler());
	    this.add(button0);
	    
	    this.button1 = new Button("1");
        this.button1.setBounds(64, 232, 35, 28);
        this.button1.setFont(new Font("Arial", 0, 14));
        this.button1.setForeground(Color.blue);
        this.button1.addActionListener(new Button1Handler());
        this.add(this.button1);
        
        this.button2 = new Button("2");
        this.button2.setBounds(100, 232, 35, 28);
        this.button2.setFont(new Font("Arial", 0, 14));
        this.button2.setForeground(Color.blue);
        this.button2.addActionListener(new Button2Handler());
        this.add(this.button2);
        
        this.button3 = new Button("3");
        this.button3.setBounds(136, 232, 35, 28);
        this.button3.setFont(new Font("Arial", 0, 14));
        this.button3.setForeground(Color.blue);
        this.button3.addActionListener(new Button3Handler());
        this.add(this.button3);
		
        this.button4 = new Button("4");
        this.button4.setBounds(64, 196, 35, 28);
        this.button4.setFont(new Font("Arial", 0, 14));
        this.button4.setForeground(Color.blue);
        this.button4.addActionListener(new Button4Handler());
        this.add(this.button4);
        
        this.button5 = new Button("5");
        this.button5.setBounds(100, 196, 35, 28);
        this.button5.setFont(new Font("Arial", 0, 14));
        this.button5.setForeground(Color.blue);
        this.button5.addActionListener(new Button5Handler());
        this.add(this.button5);
        
        this.button6 = new Button("6");
        this.button6.setBounds(136, 196, 35, 28);
        this.button6.setFont(new Font("Arial", 0, 14));
        this.button6.setForeground(Color.blue);
        this.button6.addActionListener(new Button6Handler());
        this.add(this.button6);
        
        this.button7 = new Button("7");
        this.button7.setBounds(64, 160, 35, 28);
        this.button7.setFont(new Font("Arial", 0, 14));
        this.button7.setForeground(Color.blue);
        this.button7.addActionListener(new Button7Handler());
        this.add(this.button7);
        
        this.button8 = new Button("8");
        this.button8.setBounds(100, 160, 35, 28);
        this.button8.setFont(new Font("Arial", 0, 14));
        this.button8.setForeground(Color.blue);
        this.button8.addActionListener(new Button8Handler());
        this.add(this.button8);
        
        this.button9 = new Button("9");
        this.button9.setBounds(136, 160, 35, 28);
        this.button9.setFont(new Font("Arial", 0, 14));
        this.button9.setForeground(Color.blue);
        this.button9.addActionListener(new Button9Handler());
        this.add(this.button9);
       
        this.buttonEnter = new Button("ENTER");
        this.buttonEnter.setFont(new Font("Arial", 0, 14));
        this.buttonEnter.setBackground(Color.red);
        this.buttonEnter.setForeground(Color.white);
        this.buttonEnter.setBounds(208, 90, 56, 28);
        this.buttonEnter.addActionListener(new ButtonEnterHandler());
        this.add(this.buttonEnter);
        
        this.buttonPlus = new Button("+");
        this.buttonPlus.setBounds(175, 232, 35, 28);
        this.buttonPlus.setFont(new Font("Arial", 0, 14));
        this.buttonPlus.setForeground(Color.blue);
        this.buttonPlus.addActionListener(new ButtonPlusHandler());
        this.add(this.buttonPlus);
        
        this.buttonDiv = new Button("/");
        this.buttonDiv.setBounds(175, 160, 35, 28);
        this.buttonDiv.setFont(new Font("Arial", 0, 14));
        this.buttonDiv.setForeground(Color.blue);
        this.buttonDiv.addActionListener(new ButtonDivHandler());
        this.add(this.buttonDiv);
        
        this.buttonMin = new Button("-");
        this.buttonMin.setBounds(175, 196, 35, 28);
        this.buttonMin.setFont(new Font("Arial", 0, 14));
        this.buttonMin.setForeground(Color.blue);
        this.buttonMin.addActionListener(new ButtonMinusHandler());
        this.add(this.buttonMin);
        
        
        this.buttonMul = new Button("*");
        this.buttonMul.setBounds(175, 125, 35, 28);
        this.buttonMul.setFont(new Font("Arial", 0, 14));
        this.buttonMul.setForeground(Color.blue);
        this.buttonMul.addActionListener(new ButtonMulHandler());
        this.add(this.buttonMul);
        
        
        this.buttonResultPresenter = new Button("=");
        this.buttonResultPresenter.setBounds(175, 265, 35, 28);
        this.buttonResultPresenter.setFont(new Font("Arial", 0, 14));
        this.buttonResultPresenter.setForeground(Color.blue);
        this.buttonResultPresenter.addActionListener(new ButtonResultPresenterHandler());
        this.add(this.buttonResultPresenter);
        
        this.buttonDot = new Button(".");
        this.buttonDot.setBounds(136, 265, 35, 28);
        this.buttonDot.setFont(new Font("Arial", 0, 14));
        this.buttonDot.setForeground(Color.blue);
        this.buttonDot.addActionListener(new ButtonDotHandler());
        this.add(this.buttonDot);
*/
		
		
	    display = new TextField("");
	    display.setEditable(false);
	    display.setBounds(13, 55, 257, 30);
	    this.add(display);
	    
	    
	    this.setSize(283, 320);
	    this.setLocation(40, 80);
	    this.setVisible(true);
	    this.setResizable(false);
	    this.addWindowListener(new CloseWindowAndExit());
	   
	}	
	





private Button createButton(String string, int i, int j, int k, int l, String font, Color foregroundcolor, Color bgcolor) {
	
	 var button = new Button(string);
     button.setBounds(i, j, k, l);
     button.setFont(new Font(font, Font.PLAIN, 14));
     button.setForeground(foregroundcolor);
     button.setBackground(bgcolor);
     button.addActionListener(new ButtonHandler(string));
     this.add(button);
     return button;
	
}


class CloseWindowAndExit extends WindowAdapter{
	
	public void windowClosing(WindowEvent closeWindowAndExit) {
		
		System.exit(0);
	}
	
	
}
}
