import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class allButtons {

	static JButton zero, one, two, three, four, five, six, seven, eight, nine;
	static JButton plus, minus, multiply, divide, equals, comma, back, C;
	static JButton einfachNIX0, einfachNIX1, einfachNIX2, einfachNIX3, einfachNIX4, einfachNIX5;

	static JButton[] numbers = { zero, one, two, three, four, five, six, seven, eight, nine };
	static JButton[] operators = { plus, minus, multiply, divide, equals, comma, back, C };
	static JButton[] einfachNIX = { einfachNIX0, einfachNIX1, einfachNIX2, einfachNIX3, einfachNIX4, einfachNIX5 };

	static void knopf() {

		// ------------numbers------------------
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new JButton();
			numbers[i].setText(String.valueOf(i));
			numbers[i].setBackground(new Color(59, 59, 59));
			numbers[i].setBorder(new LineBorder(new Color(59, 59, 59)));
			numbers[i].setForeground(Color.WHITE);
			numbers[i].setFocusPainted(false);
			numbers[i].setFont(new Font("Arial", Font.PLAIN, 20));
		}

		// ------------operators------------------
		for (int i = 0; i < operators.length; i++) {
			operators[i] = new JButton();
			operators[i].setBackground(new Color(50, 50, 50));
			operators[i].setBorder(new LineBorder(new Color(50, 50, 50)));
			operators[i].setForeground(Color.WHITE);
			operators[i].setFocusPainted(false);
			operators[i].setFont(new Font("Arial", Font.PLAIN, 20));
		}

		// ------------custom texts------------------
		operators[4].setText("=");
		operators[4].setBackground(new Color(69, 229, 50));
		operators[0].setText("+");
		operators[1].setText("-");
		operators[2].setText("×");
		operators[3].setText("÷");
		operators[5].setText(",");
		operators[6].setText("←");
		operators[7].setText("C");

		// ------------coming soon------------------
		for (int i = 0; i < einfachNIX.length; i++) {
			einfachNIX[i] = new JButton();
			einfachNIX[i].setText("");
			einfachNIX[i].setBackground(new Color(50, 50, 50));
			einfachNIX[i].setBorder(new LineBorder(new Color(50, 50, 50)));
			einfachNIX[i].setForeground(Color.BLACK);
			einfachNIX[i].setFocusPainted(false);
			einfachNIX[i].setFont(new Font("Arial", Font.PLAIN, 20));
		}
	}
}
