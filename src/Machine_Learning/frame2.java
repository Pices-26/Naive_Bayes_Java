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
	/*
	 * Declaring variables
	 * For each element that turned out to be sick - 1
	 * For each element that turned out to not be sick - 0
	 * 
	 * e.g person has normal temp and he was sick - 1 goes into temp_normal
	 * e.g person has normal temp and he was healthy - 0 goes into temp_normal
	 */
	public JFrame f;
	public int[] temp_normal = {1,1,1,1,1,0,1,1};
	public int[] temp_cool = {0,0,1,0,0};
	public int[] temp_hot = {1,0,0,0,0};
	public int[] ache_yes = {1,0,0,0,1,1,0,0,0,0,1};
	public int[] ache_no = {0,1,1,1,0,1,1};
	public int[] st_yes = {0,1,0,1,1,1,1,0,1,1};
	public int[] st_no = {1,0,0,1,0,0,0,0};
	
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
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(341, 32, 82, 23);
		f.getContentPane().add(lblTitle);
		
		
		//Temperature Select Box
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setBounds(158, 109, 122, 23);
		f.getContentPane().add(lblTemperature);
		JComboBox tempbox = new JComboBox();
		tempbox.setBounds(492, 106, 128, 29);
		f.getContentPane().add(tempbox);
		tempbox.addItem("Normal");
		tempbox.addItem("Cool");
		tempbox.addItem("Hot");
		
		//Ache Select Box
		JLabel lblAches = new JLabel("Aches");
		lblAches.setBounds(158, 187, 56, 23);
		f.getContentPane().add(lblAches);
		JComboBox achebox = new JComboBox();
		achebox.setBounds(492, 184, 128, 29);
		f.getContentPane().add(achebox);
		achebox.addItem("Yes");
		achebox.addItem("No");
		
		//Sore Throat SelectBox
		JLabel lblSoreThroat = new JLabel("Sore Throat");
		lblSoreThroat.setBounds(158, 279, 105, 23);
		f.getContentPane().add(lblSoreThroat);
		JComboBox stbox = new JComboBox();
		stbox.setBounds(492, 276, 122, 29);
		f.getContentPane().add(stbox);
		stbox.addItem("Yes");
		stbox.addItem("No");
		
		//Button that checks for result
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//getting total amount of people in a data set
				int U = temp_normal.length + temp_cool.length + temp_hot.length; 
				//getting values for temperature
				Object cont_temp = tempbox.getSelectedItem();
				int sick_normal = 0;
				int sick_cool = 0;
				int sick_hot = 0;
				float vartemp;
				//getting number of sick people for all temps
				for(int i = 0;i < temp_normal.length;i++)
				{
					if(temp_normal[i] == 1)
					{
						sick_normal+=1;
					}
				}
				for(int i = 0;i < temp_cool.length;i++)
				{
					if(temp_cool[i] == 1)
					{
						sick_cool+=1;
					}
				}
				for(int i = 0;i < temp_hot.length;i++)
				{
					if(temp_hot[i] == 1)
					{
						sick_hot+=1;
					}
				}
				int sick_total = sick_normal + sick_cool + sick_hot;
				
				if(cont_temp == "Normal")
				{

					vartemp = ((sick_normal / sick_total)*(sick_total / U)) / (temp_normal.length / U);
				}
				if(cont_temp == "Cool")
				{
					vartemp = ((sick_cool / sick_total)*(sick_total / U)) / (temp_cool.length / U);
				}
				if(cont_temp == "Hot")
				{
					vartemp = ((sick_hot / sick_total)*(sick_total / U)) / (temp_hot.length / U);
				}
				
				//getting values for Ache
				Object cont_ache = achebox.getSelectedItem();
				int sick_yes = 0;
				int sick_no = 0;
				float varache;
				for(int i = 0;i < ache_yes.length;i++)
				{
					if(ache_yes[i] == 1)
					{
						sick_yes+=1;
					}
				}
				for(int i = 0;i < ache_no.length;i++)
				{
					if(temp_normal[i] == 1)
					{
						sick_no+=1;
					}
				}
				int sick_total1 = sick_yes + sick_no;
				
				if(cont_ache == "Yes")
				{
					varache = ((sick_yes /sick_total1)*(sick_total1 / U))/(ache_yes.length / U);
				}
				if(cont_ache == "No")
				{
					varache = ((sick_no /sick_total1)*(sick_total1 / U))/(ache_no.length / U);
				}
				//getting values for Sore Throat
				Object cont_st = stbox.getSelectedItem();
				int sick_yes1 = 0;
				int sick_no1 = 0;
				float varst;
				for(int i = 0;i < st_yes.length;i++)
				{
					if(temp_normal[i] == 1)
					{
						sick_yes1+=1;
					}
				}
				for(int i = 0;i < st_no.length;i++)
				{
					if(temp_normal[i] == 1)
					{
						sick_no1+=1;
					}
				}
				int sick_total2 = sick_yes1 + sick_no1;
				if(cont_st == "Yes")
				{
					varst = ((sick_yes1/ sick_total2)*(sick_total2 / U))/(st_yes.length / U);
				}
				if(cont_st == "No")
				{
					varst = ((sick_no1/ sick_total2)*(sick_total2/ U))/(st_no.length / U);
				}
				float result = vartemp * varache * varst;
			}
			
		});
		btnCheck.setBounds(298, 360, 131, 31);
		f.getContentPane().add(btnCheck);
		
	}
	public frame2() {
		gui();
	}
}