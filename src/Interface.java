import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface {
	private JFrame theFrame;
	private JPanel thePanel;
	
	private JTextField screen;
	private JButton AC, C, negative, plus, minus, multiply, divide, equal, point;
	private JButton one, two, three, four, five, six, seven, eight, nine, zero;
	
	private String current = "";
	private String previous = "";
	private String operator = "";
	private int step = 0;
	
	public Interface(){
		createFrame();
		initUI();
		useDefaultPanel();
	}

	private void createFrame() {
		theFrame = new JFrame("Calculator");
		theFrame.setSize(300, 300);
		theFrame.setResizable(true);
		theFrame.setLocationRelativeTo(null);		
	}

	private void initUI() {
		setUP();		
	}

	private void setUP() {
		thePanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		NumberFormat pf = new DecimalFormat("##########.##########");
		
		JTextField screen = new JTextField("0");
		Font font1 = new Font("SansSerif", Font.BOLD, 30);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 4;
		gbc.gridx = 0;
		gbc.gridy = 0;
		screen.enable(false);
		screen.setFont(font1);
		screen.setHorizontalAlignment(JTextField.RIGHT);
		thePanel.add(screen, gbc);
		
		JButton AC = new JButton("AC");
		gbc.gridwidth = 1;
		gbc.ipady = 10;
		gbc.gridx = 0;
		gbc.gridy = 1;
		AC.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				current = "";
				previous = "";
				operator = "";
				screen.setText("0");
			}
		});
		thePanel.add(AC, gbc);
		
		JButton C = new JButton("C");
		gbc.gridx = 1;
		gbc.gridy = 1;
		C.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				current = "";
				screen.setText("0");
			}
		});
		thePanel.add(C, gbc);
		
		JButton negative = new JButton("+/-");
		gbc.gridx = 2;
		gbc.gridy = 1;
		negative.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(previous);
				if(!current.equals("")){
					if(Double.parseDouble(current) > 0){
						current = "-" + screen.getText();
					}else if(Double.parseDouble(current) < 0){
						current = screen.getText().substring(1);
					}
					screen.setText(pf.format(Double.parseDouble(current)));
				}else if(screen.getText().equals(pf.format(Double.parseDouble(previous)))){
					if(Double.parseDouble(previous) > 0){
						previous = "-" + screen.getText();
					}else if(Double.parseDouble(previous) < 0){
						previous = screen.getText().substring(1);
					}
					screen.setText(pf.format(Double.parseDouble(previous)));
				}
			}
		});
		thePanel.add(negative, gbc);
		
		JButton divide = new JButton("÷");
		gbc.gridx = 3;
		gbc.gridy = 1;
		divide.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(operator.equals("")){
					previous = current;
					screen.setText(pf.format(Double.parseDouble(previous)));
					current = "";
				}else if(operator.equals("divide")){
					previous = Double.toString(Double.parseDouble(previous) / Double.parseDouble(current));
					screen.setText(pf.format(Double.parseDouble(previous)));
					current = "";
				}
				operator = "divide";
			}
		});
		thePanel.add(divide, gbc);
		
		JButton seven = new JButton("7");
		gbc.gridx = 0;
		gbc.gridy = 2;
		seven.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				current = Insert(current, "7");
				screen.setText(pf.format(Double.parseDouble(current)));
			}
		});
		thePanel.add(seven, gbc);
		
		JButton eight = new JButton("8");
		gbc.gridx = 1;
		gbc.gridy = 2;
		eight.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				current = Insert(current, "8");
				screen.setText(pf.format(Double.parseDouble(current)));
			}
		});
		thePanel.add(eight, gbc);
		
		JButton nine = new JButton("9");
		gbc.gridx = 2;
		gbc.gridy = 2;
		nine.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				current = Insert(current, "9");
				screen.setText(pf.format(Double.parseDouble(current)));
			}
		});
		thePanel.add(nine, gbc);
		
		JButton multiply = new JButton("x");
		gbc.gridx = 3;
		gbc.gridy = 2;
		multiply.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(operator.equals("")){
					previous = current;
					screen.setText(pf.format(Double.parseDouble(previous)));
					current = "";
				}else if(operator.equals("multiply")){
					previous = Double.toString(Double.parseDouble(previous) * Double.parseDouble(current));
					screen.setText(pf.format(Double.parseDouble(previous)));
					current = "";
				}
				operator = "multiply";
			}
		});
		thePanel.add(multiply, gbc);
		
		JButton four = new JButton("4");
		gbc.gridx = 0;
		gbc.gridy = 3;
		four.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				current = Insert(current, "4");
				screen.setText(pf.format(Double.parseDouble(current)));
			}
		});
		thePanel.add(four, gbc);
		
		JButton five = new JButton("5");
		gbc.gridx = 1;
		gbc.gridy = 3;
		five.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				current = Insert(current, "5");
				screen.setText(pf.format(Double.parseDouble(current)));
			}
		});
		thePanel.add(five, gbc);
		
		JButton six = new JButton("6");
		gbc.gridx = 2;
		gbc.gridy = 3;
		six.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				current = Insert(current, "6");
				screen.setText(pf.format(Double.parseDouble(current)));
			}
		});
		thePanel.add(six, gbc);
		
		JButton minus = new JButton("-");
		gbc.gridx = 3;
		gbc.gridy = 3;
		minus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(operator.equals("")){
					previous = current;
					screen.setText(pf.format(Double.parseDouble(previous)));
					current = "";
				}else if(operator.equals("minus")){
					previous = Double.toString(Double.parseDouble(previous) - Double.parseDouble(current));
					screen.setText(pf.format(Double.parseDouble(previous)));
					current = "";
				}
				operator = "minus";
			}
		});
		thePanel.add(minus, gbc);
		
		JButton one = new JButton("1");
		gbc.gridx = 0;
		gbc.gridy = 4;
		one.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				current = Insert(current, "1");
				screen.setText(pf.format(Double.parseDouble(current)));
			}
		});
		thePanel.add(one, gbc);
		
		JButton two = new JButton("2");
		gbc.gridx = 1;
		gbc.gridy = 4;
		two.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				current = Insert(current, "2");
				screen.setText(pf.format(Double.parseDouble(current)));
			}
		});
		thePanel.add(two, gbc);
		
		JButton three = new JButton("3");
		gbc.gridx = 2;
		gbc.gridy = 4;
		three.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				current = Insert(current, "3");
				screen.setText(pf.format(Double.parseDouble(current)));
			}
		});
		thePanel.add(three, gbc);
		
		JButton plus = new JButton("+");
		gbc.gridx = 3;
		gbc.gridy = 4;
		plus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(operator.equals("")){
					previous = current;
					screen.setText(pf.format(Double.parseDouble(previous)));
					current = "";
				}else if(operator.equals("plus")){
					previous = Double.toString(Double.parseDouble(previous) + Double.parseDouble(current));
					screen.setText(pf.format(Double.parseDouble(previous)));
					current = "";
				}
				operator = "plus";
			}
		});
		thePanel.add(plus, gbc);
		
		JButton zero = new JButton("0");
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 5;
		zero.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!current.equals("0")){
					current = Insert(current, "0");
					screen.setText(current);
				}
			}
		});
		thePanel.add(zero, gbc);
		
		JButton point = new JButton(".");
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 5;
		point.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(screen.getText().indexOf(".") < 0){
					if(current.equals("")){
						current = "0";
					}
					current = Insert(screen.getText(), ".");
					screen.setText(current);
				}
			}
		});
		thePanel.add(point, gbc);
		
		JButton equal = new JButton("=");
		gbc.gridx = 3;
		gbc.gridy = 5;
		equal.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(operator){
				case "plus":
					previous = Double.toString(Double.parseDouble(previous) + Double.parseDouble(current));
					screen.setText(pf.format(Double.parseDouble(previous)));
					current = "";
					break;
				case "minus":
					previous = Double.toString(Double.parseDouble(previous) - Double.parseDouble(current));
					screen.setText(pf.format(Double.parseDouble(previous)));
					current = "";
					break;
				case "multiply":
					previous = Double.toString(Double.parseDouble(previous) * Double.parseDouble(current));
					screen.setText(pf.format(Double.parseDouble(previous)));
					current = "";
					break;
				case "divide":
					previous = Double.toString(Double.parseDouble(previous) / Double.parseDouble(current));
					screen.setText(pf.format(Double.parseDouble(previous)));
					current = "";
					break;
				}
				System.out.println(current);
				System.out.println(previous);
				System.out.println(operator);
			}
		});
		thePanel.add(equal, gbc);
	}
	
	private void useDefaultPanel() {
		theFrame.setContentPane(thePanel);
		theFrame.setVisible(true);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private String Insert(String current, String insert){
		current = current + insert;
		return current;
	}
}
