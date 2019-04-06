package Machine_Learning;

public class Calculation {
	
	/*
	 * Declaring variables
	 * For each element that turned out to be sick - 1
	 * For each element that turned out to not be sick - 0
	 * 
	 * e.g person has normal temp and he was sick - 1 goes into temp_normal
	 * e.g person has normal temp and he was healthy - 0 goes into temp_normal
	 */
	
	public int[] temp_normal = {1,1,1,1,1,0,1,1};
	public int[] temp_cool = {0,0,1,0,0};
	public int[] temp_hot = {1,0,0,0,0};
	public int[] ache_yes = {1,0,0,0,1,1,0,0,0,0,1};
	public int[] ache_no = {0,1,1,1,0,1,1};
	public int[] st_yes = {0,1,0,1,1,1,1,0,1,1};
	public int[] st_no = {1,0,0,1,0,0,0,0};
	public Object cont_temp;
	public Object cont_ache;
	public Object cont_st;
	
	
	public float Calculation(Object cont_temp, Object cont_ache, Object cont_st)
	{
		this.cont_temp = cont_temp;
		this.cont_ache = cont_ache;
		this.cont_st = cont_st;

		//getting total amount of people in a data set
		float U = temp_normal.length + temp_cool.length + temp_hot.length; 
		float sick_normal = 0;
		float sick_cool = 0;
		float sick_hot = 0;
		float vartemp = 0;
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
		float sick_total = sick_normal + sick_cool + sick_hot;
		//getting temperature for naive bayes
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
		float sick_yes = 0;
		float sick_no = 0;
		float varache = 0;
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
		float sick_total1 = sick_yes + sick_no;
		//getting ache for naive bayes
		if(cont_ache == "Yes")
		{
			varache = ((sick_yes /sick_total1)*(sick_total1 / U))/(ache_yes.length / U);
		}
		if(cont_ache == "No")
		{
			varache = ((sick_no /sick_total1)*(sick_total1 / U))/(ache_no.length / U);
		}

		//getting values for Sore Throat
		float sick_yes1 = 0;
		float sick_no1 = 0;
		float varst = 0;
		for(int i = 0;i < st_yes.length;i++)
		{
			if(st_yes[i] == 1)
			{
				sick_yes1+=1;
			}
		}
		for(int i = 0;i < st_no.length;i++)
		{
			if(st_no[i] == 1)
			{
				sick_no1+=1;
			}
		}
		float sick_total2 = sick_yes1 + sick_no1;
		//getting temperature for sore throat
		if(cont_st == "Yes")
		{
			varst = ((sick_yes1/ sick_total2)*(sick_total2 / U))/(st_yes.length / U);
		}
		if(cont_st == "No")
		{
			varst = ((sick_no1/ sick_total2)*(sick_total2/ U))/(st_no.length / U);
		}
		
		
		float result = vartemp * varache * varst;
		result = result * 100;
		//System.out.println(result + "%");
		return result;
		
	}
}
