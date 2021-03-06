import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CaesarCipherGUI extends JPanel {
	private JTextField textInput;
	private JTextField textOutput;
	private JTextField tfKey;
	
	private void encode() {
		
		String input = textInput.getText();
		String output = "";
		int key = 0;
		try {
			key = Integer.parseInt(tfKey.getText());
		}catch (Exception e){
			return;
		}
        
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if ( c >= 'A' && c <= 'Z') {
				c = (char)(c + key);
				while (c > 'Z') c -= 26;
				while (c < 'A') c += 26;
			}
			else if (c >= 'a' && c <= 'z') {
				c = (char)(c + key);
				while (c > 'z') c -= 26;
				while (c < 'a') c += 26;
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
		textOutput.setBounds(21, 199, 408, 89);
		add(textOutput);
		textOutput.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Key:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(214, 131, 46, 26);
		add(lblNewLabel);
		
		tfKey = new JTextField();
		tfKey.setBounds(264, 128, 58, 32);
		add(tfKey);
		tfKey.setColumns(10);
		
		JButton btnEncode = new JButton("Encode");
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				encode();
			}
		});
		btnEncode.setBounds(328, 127, 101, 35);
		add(btnEncode);
		setPreferredSize( new Dimension(450, 320));
		
		JSlider sliderKey = new JSlider();
		sliderKey.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				tfKey.setText("" + sliderKey.getValue());
				encode();
			}
		});
		sliderKey.setPaintTicks(true);
		sliderKey.setSnapToTicks(true);
		sliderKey.setPaintLabels(true);
		sliderKey.setMajorTickSpacing(13);
		sliderKey.setMinorTickSpacing(1);
		sliderKey.setValue(0);
		sliderKey.setMinimum(-13);
		sliderKey.setMaximum(13);
		sliderKey.setBounds(21, 119, 193, 64);
		add(sliderKey);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Caesar Cipher GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add( new CaesarCipherGUI());
		frame.pack();
		frame.setVisible(true);

	}
}
