package hw4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
//import java.util.regex;
import javax.swing.*;

public class guessingGame implements ActionListener {
	static JTextField fi;
	
	public static void main(String[] args) {
		f = new JFrame("calculator");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
				
		}
		GuessingGame guess = new GuessingGame();
		fi = new JTextField(16);
		fi.setEditable(false);
	}
	JFrame f;
	JFrame stats;
	JPanel p1, p2;
	JTextField t1, t2;
	JTextArea  t3, l1, l2, l3;
	JButton Enter, level1, level2, level3, leaderboard, clear, back, newGame;
	String name;
	int operator, guess,level = 0, guesses = 0, max, target;
	int clueSpot = 0, clueSame = 0, counter = 0;
	int[] lvl2 = {0, 0}, input2 = {0,0};
   	int[] lvl3= {0, 0, 0}, input3 = {0, 0, 0};
   	JScrollPane sc;
	Random rand = new Random();
	guessingGame(){
		f = new JFrame("Guessing Game");
		stats = new JFrame("Leaderboard");
		p1 = new JPanel();
		p1.setLayout(new GridLayout(3,2));
		p2 = new JPanel();
		p2.setLayout(new GridLayout(3,1));
		stats.setLayout(new GridLayout(1,3));
		t1 = new JTextField("Please enter your name.");
		t2 = new JTextField();
		t3 = new JTextArea();
		sc = new JScrollPane(t3);
		l1 = new JTextArea("Level 1 Stats\n");
		l2 = new JTextArea("Level 2 Stats\n");
		l3 = new JTextArea("Level 3 Stats\n");
		Enter = new JButton("Enter");
		level1 = new JButton("Level 1");
		level2 = new JButton("Level 2");
		level3 = new JButton("Level 3");
		leaderboard = new JButton("LeaderBoard");
		clear = new JButton("Clear Display");
		back = new JButton("Go Back");
		newGame = new JButton("Start A New Game");
		t1.setEditable(false);
		t3.setEditable(false);
		l1.setEditable(false);
		l2.setEditable(false);
		l3.setEditable(false);
		p1.add(newGame);
		p2.add(t1);
		p2.add(t2);
		p2.add(sc);
		p1.add(Enter);
		p1.add(level1);
		p1.add(level2);
		p1.add(level3);
		p1.add(leaderboard);
		p1.add(clear);
		p2.setSize(500, 200);
		stats.add(l1);
		stats.add(l2);
		stats.add(l3);
		stats.add(back);
		f.add(p1, BorderLayout.SOUTH);
		f.add(p2);
		f.setVisible(true);
		f.setSize(500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stats.setSize(500, 500);
		level1.addActionListener(this);
		level2.addActionListener(this);
		level3.addActionListener(this);
		Enter.addActionListener(this);
		leaderboard.addActionListener(this);
		clear.addActionListener(this);
		newGame.addActionListener(this);
		back.addActionListener(this);
	}
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == level1){
				if(name == null){
					t1.setText("Please enter your name first");
				}else{
					t1.setText("Enter in a max value.");
					operator = 1;
					level = 1;
				}
			}
			if(e.getSource()== level2){
				if(name == null){
					t1.setText("Please enter your name first");
				}else{
					t1.setText("Enter in a guess(Two Digits)");
					level = 2;
					for( int i = 0;  i <= lvl2.length - 1; i++){
						lvl2[i] = rand.nextInt(10);
					}
					//t3.append(""+ lvl2[0] + lvl2[1]);					
				}
			}
			if(e.getSource()== level3){
				if(name == null){
					t1.setText("Please enter your name first");
				}else{	
					
					t1.setText("Enter in a guess(Three Digits)");
					level = 3;
					for(int i = 0; i <= lvl3.length - 1; i++){
						lvl3[i] = rand.nextInt(10);
					}
					//t3.append("" + lvl3[0] + lvl3[1] + lvl3[2]);
				}
			}
			if(e.getSource() == leaderboard){
				stats.setVisible(true);
			}															
			if(e.getSource()== Enter){
				switch(level){
				case 0:
					if((!t2.getText().equals("")) && (t2.getText() != null ) && t2.getText().matches("^[a-zA-Z]*$")){
						name = t2.getText();
						t2.setText(null);
						t1.setText("Please choose a difficulty");					
					} else {
						t1.setText("Please enter in a valid name(Alphabet only)");
					}
				case 1:
					switch(operator){
					case 1: 
							max = Integer.parseInt(t2.getText());
							operator = 2;
							t1.setText("Enter in your guess.");
							target = rand.nextInt(max + 1);
							t2.setText("");
							break;
					case 2:
						guess = Integer.parseInt(t2.getText());
						if(guess == target){
							guesses += 1;
							t3.append("\n" + guess + " Correct you took " + guesses + " guesses.");

							l1.append(name + ", " + guesses +"\n");
							break;
						}else if(guess < target){
							t3.append("\n" + guess + " Incorrect, guess to low ");
							guesses += 1;
							t2.setText("");
							break;
						}else if (guess > target){
							t3.append("\n" + guess + " Incorrect, guess to high");
							guesses += 1;
							t2.setText("");
							break;
						}
				}
				break;
				case 2:
						try{
							Integer.parseInt(t2.getText());
						}
						catch(NumberFormatException a){
							t1.setText("Enter in a valid two digit number.");
							break;
						}
						guess = Integer.parseInt(t2.getText());
						input2[0] = (guess / 10);
						input2[1] = (guess % 10);
						clueSame = 0;
						clueSpot = 0;
						if((lvl2[0] == input2[0]) && (lvl2[1] == input2[1])){
							guesses +=1 ;
							t3.append("\n Correct it took " + guesses + " guesses.");
							l2.append(name + ", " + guesses +"\n");
							break;
						}else{
							guesses += 1;
							for(int i  : input2){
								if( i == lvl2[0]){
									if( counter == 0){
										clueSpot+= 1;
									}
									clueSame +=1;
								}else if (i == lvl2[1]){
									if(counter == 1){
										clueSpot += 1;
									}
									clueSame +=1;
									}
								counter +=1;
								}
							}
							t3.append("\n (" + clueSame + ", " + clueSpot + ")");
							t2.setText("");
							counter = 0;
							break;
						
				
				case 3:
					try{
						Integer.parseInt(t2.getText());
					
					}
					catch(NumberFormatException a){
						t1.setText("Enter in a valid two digit number.");
						break;
					}
					guess = Integer.parseInt(t2.getText());
					input3[0] = guess / 100;
					guess = guess % 100;
					input3[1] = guess /10;
					input3[2] = guess %10;
					clueSame = 0;
					clueSpot = 0;
					if((lvl3[0] == input3[0]) && (lvl3[1] == input3[1]) && (lvl3[2] == input3[2])){
						guesses +=1 ;
						t3.append("\n Correct it took " + guesses + " guesses.");
						l3.append(name + ", " + guesses +"\n");
						break;
						
					}else{
						guesses += 1;
						for(int i  : input3){
							if( i == lvl3[0]){
								if( counter == 0){
									clueSpot+= 1;
								}
								clueSame +=1;

							}else if(i == lvl3[1]){
								if(counter == 1){
									clueSpot += 1;
								}
								clueSame +=1;
							} else if (i == lvl3[2]){
								if(counter == 2){
									clueSpot += 1;
								}
								clueSame +=1;
							}
							counter +=1;
							}
						}
						t3.append("\n (" + clueSame + ", " + clueSpot + ")");
						t2.setText("");
						counter = 0;
						break;
					}
				
				}
				
					
				
					
					
			
			
			if(e.getSource()== clear){
				t3.setText("");
			}
			if(e.getSource() == newGame){
				name = null;
				guesses = 0;
				level = 0;
				operator = 0;
				t2.setText("");
				t3.setText("");
				t1.setText("Please Enter your name");
				lvl2[0] = 0;
				lvl2[1] = 1;
				lvl3[0] = 0;
				lvl3[1] = 0;
				lvl3[2] = 0;
			}
			
			if(e.getSource() == back){
				stats.setVisible(false);
			}
		}
}
