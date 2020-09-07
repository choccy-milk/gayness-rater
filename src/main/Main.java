package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main
{
	public static void main(String[] args)
	{
		new Main();
	}
	
	public Main()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame("Yes");
		frame.setVisible(false);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(null); // who the FUCK uses these?
		
		JButton button = new JButton("Cool Button");
		button.setBounds(50, 50, 150, 60);
		button.setFocusable(false);
		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String s = JOptionPane.showInputDialog("On a scale of 1 to 10, how gay are you?", "Yes");
				
				if(s == null)
				{
					return;
				}
				
				if(s.equalsIgnoreCase("yes"))
				{
					JOptionPane.showMessageDialog(null, "Woah, that's pretty gay bro");
				}
				else
				{
					try
					{
						int nr = Integer.parseInt(s);
						JOptionPane.showMessageDialog(null, String.format("%s? Not bad bro.", nr));
					}
					catch(NumberFormatException e2)
					{
						JOptionPane.showConfirmDialog(null, "Enter a number you fucking dumbass", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		panel.add(button);
		
		frame.add(panel);
		frame.setVisible(true);
	}
}