package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 *
	 * Every time a key is pressed, add that character to the JLabel. It should
	 * look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last
	 * character is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is
	 * pressed, the top Character is popped  off the Stack and added back to
	 * the JLabel.
	 */

	JFrame frame = new JFrame(); 
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> characters = new Stack<Character>();

	public static void main(String[] args) {
		_02_TextUndoRedo x = new _02_TextUndoRedo();
		x.run();

	}

	public void run() {
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.pack();
		frame.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 8) {
			String text = label.getText();
			if(text.length() > 0) {
				char lastCharacter = text.charAt(text.length() - 1);
				label.setText(text.substring(0, text.length() - 1));
				characters.push(lastCharacter);
				System.out.println(characters);
			}
		}else if(e.getKeyCode() == 37) {
			if(!characters.isEmpty()) {
			char addBack = characters.pop();
			label.setText(label.getText() + addBack);
			}
		}else {
			char letter = e.getKeyChar();
			label.setText(label.getText() + letter);
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
