package hw4;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//NOTES

public class calc extends JFrame implements ActionListener{
	static JFrame f;
	
	static JTextField fi;
	
	String s0, s1, s2;
	
	public calc(){
		s0 = "";
		s1 ="";
		s2 ="";
	}
	public static void main(String args[]) {
		f = new JFrame("calculator");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		calc c = new calc();
		
		fi = new JTextField(16);
		fi.setEditable(false);
		
		JButton bsqrt,b0,bper,b1,b2,b3,b4,b5,b6,b7,b8,b9,badd,bsub,bdiv,bmult,bsqu,be,beq,beq1,bsign;
		b0 = new JButton("0"); 
	    b1 = new JButton("1"); 
	    b2 = new JButton("2"); 
	    b3 = new JButton("3"); 
	    b4 = new JButton("4"); 
	    b5 = new JButton("5"); 
	    b6 = new JButton("6"); 
	    b7 = new JButton("7"); 
	    b8 = new JButton("8"); 
	    b9 = new JButton("9"); 
	    beq1 =new JButton("=");
	    bsign = new JButton("+/-");
	    badd = new JButton("+"); 
	    bsub = new JButton("-"); 
	    bdiv = new JButton("/"); 
	    bmult = new JButton("*"); 
	    beq = new JButton("AC"); 
	    bsqu = new JButton("^");    
	    be = new JButton(".");
	    bper = new JButton("%");
	    bsqrt = new JButton("@");
	    
	    JPanel p = new JPanel();
	    
	    bmult.addActionListener(c);
	    bdiv.addActionListener(c); 
        bsub.addActionListener(c); 
        bsqu.addActionListener(c); 
        badd.addActionListener(c); 
        b9.addActionListener(c); 
        b8.addActionListener(c); 
        b7.addActionListener(c); 
        b6.addActionListener(c); 
        b5.addActionListener(c); 
        b4.addActionListener(c); 
        b3.addActionListener(c); 
        b2.addActionListener(c); 
        b1.addActionListener(c); 
        b0.addActionListener(c); 
        be.addActionListener(c); 
        beq.addActionListener(c); 
        beq1.addActionListener(c); 
        bsign.addActionListener(c); 
        bper.addActionListener(c); 
        bsqrt.addActionListener(c); 
        
        p.add(fi); 
        p.add(badd);
        p.add(bsub);
        p.add(bmult);
        p.add(bdiv);
        p.add(bsqu);
        p.add(bsqrt);
        p.add(bper);
        p.add(bsign);
        p.add(b1); 
        p.add(b2); 
        p.add(b3); 
        p.add(b4); 
        p.add(b5); 
        p.add(b6);  
        p.add(b7); 
        p.add(b8); 
        p.add(b9);   
        p.add(b0); 
        p.add(be);
        p.add(beq); 
        p.add(beq1); 
		
        p.setBackground(Color.gray);
        
        f.add(p);
        f.setSize(210,250);
        f.show();
        
	}
	public void actionPerformed(ActionEvent e) {
		
		//s equals one action at a time as a string. every button is equivalent to the 
		//s string value.
		String s = e.getActionCommand();
		
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9' || s.charAt(0) =='.') ) {
			if (!s1.contentEquals(""))
				s2 = s2+s;
			
			else if (fi.getText().contains("=")) {
				s1=s2="";
				s0=s;
			}
			else if (s2.contentEquals("")){
				s0 = s0 +s;
			
			}
			fi.setText(s0 +s1 +s2);
			
			
			
		
		}
		else if (s.charAt(0) == 'A' && s.charAt(1) == 'C') {
			s0 = s1 = s2 = "";
		} else if (s.charAt(0) == '=') {
			double answer = 0;

			// for the advanced math
			EvaluateExpression program = new EvaluateExpression();
			ArrayList<String> postfixList = new ArrayList<String>();
			ArrayList<String> postfixList2 = new ArrayList<String>();

			if (s1.contentEquals("+")) {
				answer = (Double.parseDouble(s0) + Double.parseDouble(s2));
			} else if (s1.contentEquals("-")) {
				answer = (Double.parseDouble(s0) - Double.parseDouble(s2));
			} else if (s1.contentEquals("/")) {
				answer = (Double.parseDouble(s0) / Double.parseDouble(s2));
			} else if (s1.contentEquals("*")) {
				answer = (Double.parseDouble(s0) * Double.parseDouble(s2));
			} else if (s1.contentEquals("^")) {
				postfixList = program.infix2Postfix(s0 + "^" + s2);
				answer = program.evaluatePostfix(postfixList);
			} else if (s1.contentEquals("+/-"))
				answer = Double.parseDouble(s0) * -1;
			else if (s1.contentEquals("@")) {
				postfixList2 = program.infix2Postfix(s0 + "@" + s2);
				answer = program.evaluatePostfix(postfixList2);
			} else if (s1.contentEquals("%")) {
				answer = Double.parseDouble(s0) / 100;
			}
			fi.setText(s0 + s1 + s2 + "=" + answer);
			s0 = Double.toString(answer);
			s1 = s2 = "";
	}
	else {
		if (s1.equals("") || s2.contentEquals(""))
			s1 = s;
		else {
			double answer;
			
			if (s1.equals("+")) 
                answer = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
            else if (s1.equals("-")) 
                answer = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
            else if (s1.equals("/")) 
                answer = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
            else
                answer = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
			
			s0 = Double.toString(answer);
			s1 = s;
			s2 = "";
			
		}
		fi.setText(s0+s1+s2);
	}
}
	}