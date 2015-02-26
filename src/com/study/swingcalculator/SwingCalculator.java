package com.study.swingcalculator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SwingCalculator extends JFrame {

	private Container c = getContentPane();
	private JButton[] btn = new JButton[16]; // �迭�� ��ư����
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JTextArea textarea = new JTextArea();

	public SwingCalculator() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("��Ģ���� ����");
		setLocation(100, 300);
		setVisible(true);
		setResizable(false);
		setSize(305, 385);
		init_GUI();
		init_KeyListener();
	}

	public void init_GUI() {

		Font font1 = new Font("���", Font.BOLD, 20);
		Font font2 = new Font("���", 0, 15);

		btn[0] = new JButton("+");
		btn[0].setFont(font1);

		btn[1] = new JButton("-");
		btn[1].setFont(font1);

		btn[2] = new JButton("��");
		btn[2].setFont(font1);

		btn[3] = new JButton("��");
		btn[3].setFont(font1);

		btn[4] = new JButton("=");
		btn[4].setFont(font1);

		btn[5] = new JButton("C");
		btn[5].setFont(font1);
		btn[5].setForeground(Color.blue);

		for (int i = 6; i < btn.length; i++) {
			String setNum = Integer.toString(i - 5);
			if (i == 15) {
				btn[i] = new JButton("0");
				btn[i].setFont(font1);
			} else {
				btn[i] = new JButton(setNum);
				btn[i].setFont(font1);
			}
		}

		// ���α׷� ����� JTextArea�� ��Ŀ��
		textarea.requestFocus();
		textarea.setSize(30, 14);
		textarea.setFont(font2);
		// setHorizontalAlignment(JTextField.RIGHT);
		// ���̾ƿ� ����
		panel1.setLayout(new GridLayout(1, 6));
		panel2.setLayout(new GridLayout(4, 3));
		c.setLayout(null);

		textarea.setBounds(0, 0, 300, 30);
		panel1.setBounds(0, 30, 300, 80);
		panel2.setBounds(0, 110, 300, 250);

		// �����̳ʿ� ����
		c.add(textarea);
		c.add(panel1);
		c.add(panel2);

		// �гο� ����
		for (int i = 0; i < 6; i++) {
			panel1.add(btn[i]);
		}
		for (int i = 6; i < btn.length; i++) {
			panel2.add(btn[i]);
		}

	}

	// ������ �ʱ�ȭ
	public void init_KeyListener() {

		btn[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("+");
				textarea.requestFocus();
			}
		});
		btn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("-");
				textarea.requestFocus();
			}
		});
		btn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("*");
				textarea.requestFocus();
			}
		});
		btn[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("/");
				textarea.requestFocus();
			}
		});
		btn[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operation();
				textarea.requestFocus();
			}
		});
		btn[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.setText("");
				textarea.requestFocus();
			}
		});
		btn[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("1");
				textarea.requestFocus();
			}
		});

		btn[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("2");
				textarea.requestFocus();
			}
		});
		btn[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("3");
				textarea.requestFocus();
			}
		});
		btn[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("4");
				textarea.requestFocus();
			}
		});
		btn[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("5");
				textarea.requestFocus();
			}
		});
		btn[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("6");
				textarea.requestFocus();
			}
		});
		btn[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("7");
				textarea.requestFocus();
			}
		});
		btn[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("8");
				textarea.requestFocus();
			}
		});
		btn[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("9");
				textarea.requestFocus();
			}
		});
		btn[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textarea.append("0");
				textarea.requestFocus();
			}
		});

	}

	// ���� �޼ҵ� ("=" Ŭ��)
	public void operation() {
		String opr = textarea.getText();
		String operation = "";
		int first = 0;
		int second = 0;

		for (int i = 0; i < opr.length(); i++) {
			String s = String.valueOf(opr.charAt(i));
			if (s.equals("+") || s.equals("-") || s.equals("*")
					|| s.equals("/")) {

				String _first = "";
				String _second = "";
				operation = s;

				int len = i;

				for (int j = 0; j < len; j++) {
					_first += (opr.charAt(j) + "");
				}
				for (int j = len + 1; j < opr.length(); j++) {
					_second += (opr.charAt(j) + "");
				}

				first = Integer.parseInt(_first);
				second = Integer.parseInt(_second);
			}
		}
		if (operation.equals("+")) {
			textarea.setText(Integer.toString(first + second));
		}
		if (operation.equals("-")) {
			textarea.setText(Integer.toString(first - second));
		}
		if (operation.equals("/")) {
			textarea.setText(Integer.toString(first / second));
		}
		if (operation.equals("*")) {
			textarea.setText(Integer.toString(first * second));
		}
	}

	// ȣ��
	public static void main(String[] args) {
		SwingCalculator mc = new SwingCalculator();
	}
}
