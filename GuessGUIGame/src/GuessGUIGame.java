import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessGUIGame extends JFrame {
	
	private JTextField tfGuess;
	private JLabel lbHint;
	private JButton btnGuess;
	private int target;
	
	public GuessGUIGame() {
		setTitle("JFrame Practice");
		getContentPane().setLayout(null);
		
		JLabel lblGussingGame = new JLabel("Guessing Game");
		lblGussingGame.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblGussingGame.setForeground(Color.GRAY);
		lblGussingGame.setBounds(33, 0, 424, 51);
		lblGussingGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblGussingGame);
		
		JPanel panel = new JPanel();
		panel.setBounds(13, 72, 474, 42);
		getContentPane().add(panel);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		panel.add(lblGuessANumber);
		
		tfGuess = new JTextField();
		tfGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		panel.add(tfGuess);
		tfGuess.setColumns(5);
		
		btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBounds(177, 126, 141, 35);
		getContentPane().add(btnGuess);
		
		lbHint = new JLabel("Enter  a number above and click Guess!");
		lbHint.setHorizontalAlignment(SwingConstants.CENTER);
		lbHint.setBounds(21, 182, 454, 26);
		getContentPane().add(lbHint);
	}

	public void checkGuess() {
		String guessText = tfGuess.getText();
		
		if (guessText.length() == 0){
			lbHint.setText("You must enter a number first");
			return;
		}
		
		String message = "";
		int guess = 0;
		try {
			guess = Integer.parseInt(guessText);
		}catch (Exception e){
			lbHint.setText("Please enter a valid number");
			return;
		}
		
		if (guess < target){
			message = guess + "is too low";
		}
		else if (guess > target){
			message = guess + " is too high";
		}
		else {
			message = guess + " is correct";
			newGame();
		}
		
		lbHint.setText(message);
	}
	
	public void newGame(){
		target = (int)(Math.random() * 100 + 1);
		tfGuess.setText("");
	}
	
	public static void main(String[] args) {
		
		GuessGUIGame game = new GuessGUIGame();
		game.newGame();
		game.setSize(new Dimension(520, 300));
		game.setVisible(true);

	}
}
