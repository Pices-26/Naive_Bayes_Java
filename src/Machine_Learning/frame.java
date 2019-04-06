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

public class frame {
	//declaring variables
	public JFrame f;
	public int[] temp = {0,0,1}; //temperature
	public int[] ache = {0}; //ache
	public int[] ST = {1,1,1}; //sore throat
	public int[] temp_ache = {0,0,0,0,1}; //temperature and ache
	public int[] temp_ST = {0}; //temperature and soar throat
	public int[] ache_ST = {1,1,1}; //ache and soar throat
	public int[] all = {0,0,0}; //all symptoms
	
	public void gui()
	{
		//creating frame
		f = new JFrame("Machine Learning");
		f.setBackground(Color.LIGHT_GRAY);
		f.setVisible(true);
		f.setSize(798,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.setLocationRelativeTo(null);  
		//adding a title
		JLabel lblTitle = new JLabel("Tonsillitis Probability Checker");
		lblTitle.setBounds(265, 42, 249, 23);
		f.getContentPane().add(lblTitle);
		//adding pnel around the comboBox
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Choose what applies to you", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(232, 173, 311, 61);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		//adding comboBox
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(6, 25, 299, 29);
		comboBox.addItem("Temperature");
		comboBox.addItem("Ache");
		comboBox.addItem("Sore Throat");
		comboBox.addItem("Temp and Ache");
		comboBox.addItem("Temp and Soar Throat");
		comboBox.addItem("Ache and Soar Throat");
		comboBox.addItem("All of the Symptoms");
		comboBox.setSelectedIndex(0);
		panel.add(comboBox);
		// Bottom label 1
		JLabel lblTakeIntoConsideration = new JLabel("Take into consideration that this is not 100% correct. \r\n");
		lblTakeIntoConsideration.setForeground(Color.RED);
		lblTakeIntoConsideration.setBackground(Color.WHITE);
		lblTakeIntoConsideration.setBounds(138, 325, 565, 61);
		f.getContentPane().add(lblTakeIntoConsideration);
		//bottom label 2
		JLabel lblProbabilityWillIncrease = new JLabel("Probability will increase as we will get more data");
		lblProbabilityWillIncrease.setForeground(Color.RED);
		lblProbabilityWillIncrease.setBounds(164, 394, 527, 23);
		f.getContentPane().add(lblProbabilityWillIncrease);
		//adding the button for submission of user option
		JButton btnSubmit = new JButton("Submit");
		//listener for the submission button
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//getting the choice
				Object contents = comboBox.getSelectedItem();
				if(contents == "Temperature")
				{
					result(temp);
				}
				else if(contents == "Ache")
				{
					result(ache);
				}
				else if(contents == "Sore Throat")
				{
					result(ST);
				}
				else if(contents == "Temp and Ache")
				{
					result(temp_ache);
				}
				else if(contents == "Temp and Soar Throat")
				{
					result(temp_ST);
				}
				else if(contents == "Ache and Soar Throat")
				{
					result(ache_ST);
				}
				else
				{
					result(all);
				}
			
			}
		});
		
		btnSubmit.setBounds(316, 247, 131, 31);
		f.getContentPane().add(btnSubmit);
	}
	public frame() {
		gui();
	}
	
	public static void result(int[] array) {
		int s_counter = 0; //sick counter
		float probability = 0; //float because when we will get more data then we can be more accurate
		
		for(int i = 0; i < array.length; i++)
		{
		    if(array[i] == 1)
		    {
		    	s_counter = s_counter + 1;//adding how many people are sick
		    }
		}
		probability =  (s_counter * 100 /array.length); //dividing by the amount of people in the array and * 100 to get the % 
		 //displaying out the probability
		String string = "probability";
		string = String.format("probability %.3f", probability) ;
		JOptionPane.showMessageDialog(null, string + "%");
	}
}
//for each variable put it over the total and multiply it by all

// m = total
// n = amount in each section
// get all the combinations
// multiply together