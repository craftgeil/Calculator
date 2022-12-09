import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class myFrame extends JFrame implements ActionListener {

	static String getSourceNumber = "0", firstNumber = "0", secondNumber = "0";

	static String operator = "";
	static double result = 0;
	static int firstOrSecond = 1;
	
	public JLabel guiNumbersLabel, numbersXoperators;
	public JPanel userInputPanel;
	

	myFrame() {

		guiNumbersLabel = new JLabel();
		guiNumbersLabel.setText("0");
		guiNumbersLabel.setHorizontalAlignment(JLabel.RIGHT);
		guiNumbersLabel.setVerticalAlignment(JLabel.CENTER);
		guiNumbersLabel.setBounds(-5, 30, 315, 100);
		guiNumbersLabel.setForeground(Color.white);
		guiNumbersLabel.setFont(new Font("Arial", Font.PLAIN, 50));

		numbersXoperators = new JLabel();
		numbersXoperators.setText("0");
		numbersXoperators.setHorizontalAlignment(JLabel.RIGHT);
		numbersXoperators.setBounds(-10, -15, 315, 100);
		numbersXoperators.setForeground(Color.gray);
		numbersXoperators.setFont(new Font("Arial", Font.PLAIN, 20));

		userInputPanel = new JPanel();
		userInputPanel.setBackground(Color.black);
		userInputPanel.setBounds(0, 160, 315, 300);
		userInputPanel.setLayout(new GridLayout(6, 4, 3, 3));

		allButtons.knopf();
		addToJPanel();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(330, 500);
		frame.getContentPane().setBackground(new Color(32, 32, 32));
		frame.setTitle("Rechner");

		// ImageIcon image = new ImageIcon(
			//	"C:\\Users\\andre_zmypf6d\\Documents\\Java (Projekte)\\Eclipse\\Taschenrechner\\src\\Taschenrechner.png");
		// frame.setIconImage(image.getImage());

		frame.setVisible(true);
		frame.add(userInputPanel);
		frame.add(guiNumbersLabel);
		frame.add(numbersXoperators);
		frame.setResizable(false);
		// frame.setAlwaysOnTop(true);
	}

	public void addToJPanel() {
		userInputPanel.add(allButtons.einfachNIX[0]);
		userInputPanel.add(allButtons.einfachNIX[1]);
		userInputPanel.add(allButtons.operators[7]); // C
		userInputPanel.add(allButtons.operators[6]); // back
		userInputPanel.add(allButtons.einfachNIX[2]);
		userInputPanel.add(allButtons.einfachNIX[3]);
		userInputPanel.add(allButtons.einfachNIX[4]);
		userInputPanel.add(allButtons.operators[3]); // divide
		userInputPanel.add(allButtons.numbers[7]);
		userInputPanel.add(allButtons.numbers[8]);
		userInputPanel.add(allButtons.numbers[9]);
		userInputPanel.add(allButtons.operators[2]); // multiply
		userInputPanel.add(allButtons.numbers[4]);
		userInputPanel.add(allButtons.numbers[5]);
		userInputPanel.add(allButtons.numbers[6]);
		userInputPanel.add(allButtons.operators[1]); // minus
		userInputPanel.add(allButtons.numbers[1]);
		userInputPanel.add(allButtons.numbers[2]);
		userInputPanel.add(allButtons.numbers[3]);
		userInputPanel.add(allButtons.operators[0]); // plus
		userInputPanel.add(allButtons.einfachNIX[5]);
		userInputPanel.add(allButtons.numbers[0]);
		userInputPanel.add(allButtons.operators[5]); // comma
		userInputPanel.add(allButtons.operators[4]); // equals

		for (int i = 0; i < allButtons.operators.length; i++) {
			allButtons.operators[i].addActionListener(this);
		}

		for (int i = 0; i < allButtons.numbers.length; i++) {
			allButtons.numbers[i].addActionListener(this);
		}
	}

	public void addToResult() {
		firstNumber = Double.toString(result);
		secondNumber = "0";
		getSourceNumber = "0";
		result = 0;
		operator = ("");
		firstOrSecond = 2;
		setEnabledNumberButtons(true);
	}
	
	public void setEnabledNumberButtons(boolean b) {
		for (int i = 0; i < allButtons.numbers.length; i++) {
			allButtons.numbers[i].setEnabled(b);
		}
	}
	


	public void result() {

		switch (operator) {
		case "+":
			result = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
			break;

		case "-":
			result = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
			break;

		case "×":
			result = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
			break;

		case "÷":
			result = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
			break;
		}
		
		setEnabledNumberButtons(false);
		System.out.println("Ergebnis: "+result);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// -------------------------------------operators-------------------------------------

		if (e.getSource() == allButtons.operators[7]) {
			firstNumber = "0";
			result = 0;
			secondNumber = "0";
			operator = ("");
			getSourceNumber = "0";
			firstOrSecond = 1;
		}

		if (e.getSource() == allButtons.operators[0]) {

			if (!secondNumber.equals("0")) {
				result();
			}

			if (result != 0) {
				addToResult();
				operator = ("+");
			} else {
				operator = "+";
				firstOrSecond = 2;
				getSourceNumber = "0";
			}
		}
		if (e.getSource() == allButtons.operators[1]) {

			if (!secondNumber.equals("0")) {
				result();
			}

			if (result != 0) {
				addToResult();
				operator = ("-");
			} else {
				operator = "-";
				firstOrSecond = 2;
				getSourceNumber = "0";
			}
		}
		if (e.getSource() == allButtons.operators[2]) {

			if (!secondNumber.equals("0")) {
				result();
			}

			if (result != 0) {
				addToResult();
				operator = ("×");
			} else {
				operator = "×";
				firstOrSecond = 2;
				getSourceNumber = "0";
			}
		}
		if (e.getSource() == allButtons.operators[3]) {

			if (!secondNumber.equals("0")) {
				result();
			}

			if (result != 0) {
				addToResult();
				operator = ("÷");
			} else {
				operator = "÷";
				firstOrSecond = 2;
				getSourceNumber = "0";
			}
		}

		// equals
		if (e.getSource() == allButtons.operators[4]) {
			result();
		}

		// -------------------------------------getSourceNumber-------------------------------------

		// ------,------
		if (e.getSource() == allButtons.operators[5]) {
			if (!getSourceNumber.equals("0")) {
				getSourceNumber = getSourceNumber + ".";
			}
		}

		// ------back------
		if (e.getSource() == allButtons.operators[6]) {
			getSourceNumber = getSourceNumber.substring(0, getSourceNumber.length() - 1);
			if (getSourceNumber.length() == 0) {
				getSourceNumber = "0";
			}
		}

		// ------e.getSource ALL Numbers------
		for (int i = 0; i < allButtons.numbers.length; i++) {
			if (e.getSource() == allButtons.numbers[i]) {
				if (getSourceNumber.equals(String.valueOf(i))) {
					if (getSourceNumber.equals("0"))
						getSourceNumber = "";
					else
						getSourceNumber = String.valueOf(i);
				} else if (getSourceNumber.equals("0"))
					getSourceNumber = "";
				getSourceNumber = getSourceNumber + String.valueOf(i);
			}
		}

		if (firstOrSecond == 1) {
			firstNumber = getSourceNumber;
		}
		if (firstOrSecond == 2) {
			secondNumber = getSourceNumber;
		}

		// --------------------------------------------

		System.out.println("Erste Nummer: "+firstNumber);
		numbersXoperators.setText(firstNumber);
		guiNumbersLabel.setText(getSourceNumber);

		System.out.println("Zweite Nummer: "+secondNumber);
		numbersXoperators.setText(firstNumber + " " + operator + " " + secondNumber);

		// bei zb 3-3 ist es immernoch 3
		if (result != 0) {
			if (Double.toString(result).contains(".0")) {
				guiNumbersLabel.setText(String.valueOf((int) result));
				numbersXoperators.setText(firstNumber + " " + operator + " " + secondNumber + " = " + (int) result);
			} else {
				guiNumbersLabel.setText(Double.toString(result));
				numbersXoperators.setText(firstNumber + " " + operator + " " + secondNumber + " = " + result);
			}

		}

	}

}
