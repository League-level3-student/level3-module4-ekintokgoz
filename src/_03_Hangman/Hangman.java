package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	int lives = 10;
	JLabel label = new JLabel("Lives: " + lives);
	JLabel wordLabel = new JLabel();
	String word = "";
	String hiddenWord = "";
	Stack<String> hangman = new Stack<String>();
	Boolean win = false;


	public static void main(String[] args) {		
		Hangman hangman = new Hangman();
		hangman.run();	
	}

	public void run() {
		frame.add(panel);
		panel.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);


		String numOfWords = JOptionPane.showInputDialog("Enter the number of words to guess (1-100): ");

		for(int i = 0; i < Integer.parseInt(numOfWords); i++) {
			hangman.add(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
		word = hangman.pop();
			for(int i = 0; i < word.length(); i++) {
				hiddenWord += "_";
			} 
		
		wordLabel.setText(hiddenWord);
		panel.add(wordLabel);
		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(word.contains(e.getKeyChar()+"")) {
			StringBuilder sb = new StringBuilder(hiddenWord);
			for(int i = 0; i < word.length(); i++) {
				if(word.charAt(i) == e.getKeyChar()) {
					sb.setCharAt(i, e.getKeyChar());
				}		
			}
			hiddenWord = sb.toString();
			wordLabel.setText(hiddenWord);
		}else {
			lives -= 1;
			label.setText("Lives: " + lives);
		}
		if(lives == 0) {
			JOptionPane.showMessageDialog(null, "Ran out of lives. The hidden word was: " + word);
			System.exit(0);
		}
		if(!hiddenWord.contains("_")) {
			JOptionPane.showMessageDialog(null, "You found the hidden word!");
			if(!hangman.isEmpty()) {
				word = hangman.pop();
				hiddenWord = "";
				for(int i = 0; i < word.length(); i++) {
					hiddenWord += "_";
				} wordLabel.setText(hiddenWord);
				lives = 10;
				label.setText("Lives: " + lives);
				frame.pack();
			}else {
				JOptionPane.showMessageDialog(null, "You win the game!!!!!");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
