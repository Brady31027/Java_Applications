import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CaesarCipherGUI extends JPanel {
	private JTextField textInput;
	private JTextField textOutput;
	private JTextField tfKey;
	
	private void encode( String input, int key) {
		String output = "";

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if ( c >= 'A' && c <= 'Z') {
				c = (char)(c + key);
				if (c > 'Z') c -= 26;
				else if (c < 'A') c += 26;
			}
			else if (c >= 'a' && c <= 'z') {
				c = (char)(c + key);
				if (c > 'z') c -= 26;
				else if (c < 'a') c += 26;
			}
			output += c;
		}
		
		textOutput.setText(output);
	}
	
	public CaesarCipherGUI() {
		setLayout(null);
		
		textInput = new JTextField();
		textInput.setBounds(21, 21, 408, 89);
		add(textInput);
		textInput.setColumns(10);
		
		textOutput = new JTextField();
		textOutput.setBounds(21, 190, 408, 89);
		add(textOutput);
		textOutput.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Key:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(31, 131, 46, 26);
		add(lblNewLabel);
		
		tfKey = new JTextField();
		tfKey.setBounds(84, 128, 93, 32);
		add(tfKey);
		tfKey.setColumns(10);
		
		JButton btnEncode = new JButton("Encode");
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int key = 0;
				try {
					key = Integer.parseInt(tfKey.getText());
				}catch (Exception e){
					return;
				}
				String input = textInput.getText(); 
				encode(input, key);
			}
		});
		btnEncode.setBounds(288, 127, 141, 35);
		add(btnEncode);
		setPreferredSize( new Dimension(450, 320));
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Caesar Cipher GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add( new CaesarCipherGUI());
		frame.pack();
		frame.setVisible(true);

	}
}
