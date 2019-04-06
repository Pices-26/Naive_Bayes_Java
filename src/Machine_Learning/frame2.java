package Machine_Learning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frame2 {
	public JFrame f;
	
	public void gui()
	{
		//creating frame
		f = new JFrame("Naive Bayes");
		f.setBackground(Color.LIGHT_GRAY);
		f.setVisible(true);
		f.setSize(798,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);  
		f.getContentPane().setLayout(null);
		
		//title on top
		JLabel lblTitle = new JLabel("Tonsillitis Checker");
		lblTitle.setBounds(286, 30, 167, 23);
		f.getContentPane().add(lblTitle);
		
		
		//Temperature Select Box
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setBounds(158, 109, 122, 23);
		f.getContentPane().add(lblTemperature);
		
		//Ache Select Box
		JLabel lblAches = new JLabel("Aches");
		lblAches.setBounds(158, 187, 56, 23);
		f.getContentPane().add(lblAches);
		
		//Sore Throat SelectBox
		JLabel lblSoreThroat = new JLabel("Sore Throat");
		lblSoreThroat.setBounds(158, 279, 105, 23);
		f.getContentPane().add(lblSoreThroat);
		
		//Button that checks for result
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(298, 360, 131, 31);
		
		f.getContentPane().add(btnCheck);
		JComboBox tempbox = new JComboBox();
		tempbox.setBounds(492, 106, 128, 29);
		f.getContentPane().add(tempbox);
		tempbox.addItem("Normal");
		tempbox.addItem("Cool");
		tempbox.addItem("Hot");
		JComboBox achebox = new JComboBox();
		achebox.setBounds(492, 184, 128, 29);
		f.getContentPane().add(achebox);
		achebox.addItem("Yes");
		achebox.addItem("No");
		JComboBox stbox = new JComboBox();
		stbox.setBounds(492, 276, 122, 29);
		f.getContentPane().add(stbox);
		stbox.addItem("Yes");
		stbox.addItem("No");
		btnCheck.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Object cont_st = stbox.getSelectedItem();
				Object cont_ache = achebox.getSelectedItem();
				Object cont_temp = tempbox.getSelectedItem();
				// caling a method in another class
				Calculation c = new Calculation();
				float result = c.Calculation(cont_temp, cont_ache, cont_st);
				// percentage result in console
				System.out.println(result);
				if(result > 50.00)
				{
					JOptionPane.showMessageDialog(null, "More than 50% chance of having Tonsillitis");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Less than 50% chance of having Tonsillitis");
				}
			}
		});
		
	}
	public frame2() {
		gui();
	}
}