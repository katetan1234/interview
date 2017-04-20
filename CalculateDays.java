/**
 * Takeing two dates (as strings in ISO format (yyyy-mm-dd)  ) as input and return the difference between those 2 dates in terms of days.
 * The difference of year is 365 days, and the different month is 30 days.
 * Add the consideration of if the input matches the standard of format.
 * And if the date matches the standard of date like value of month cannot exceed 12.
 *
 * @author: Hengjin Tan
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class CalculateDays {
	private int day=2;
	private int month=1;
	private int year=0;
	private int formatLength=3;
	private Set<Integer> bigMonth=new HashSet<Integer>();
	private Set<Integer> smallMonth=new HashSet<Integer>();

	private int getPeriodInDays(String dayStart,String dayEnd) throws Exception{
		if(dayStart==null||dayEnd.length()==0||dayStart==null||dayEnd.length()==0)
			return 0;
		int diff=0;
		String[] dateStart=dayStart.split("-");
		String[] dateEnd=dayEnd.split("-");
		if(dateStart.length!=formatLength||dateEnd.length!=formatLength){
			throw new Exception("The input format should (yyyy-mm-dd)!");
		}
		for(int i=0;i<dateStart.length;i++){
			int startNum=Integer.parseInt(dateStart[i]);
			int endNum=Integer.parseInt(dateEnd[i]);
			switch(i){
			case 0: 
				diff+=(endNum-startNum)*365;
				break;
			case 1:
				if(endNum>12||startNum>12)
					throw new Exception("The input of month should be less then 12!");
				diff+=(endNum-startNum)*30;
				break;
			case 2:
				if(!validDay(dateStart)||!validDay(dateEnd))
					throw new Exception("The input of day is wrong.");
				diff+=endNum-startNum;
				break;
			default:
				throw new Exception();
			}
		}
		return diff; 
	}
	
	private void initialSet(){
		// adding the big month to bigMonth set
		bigMonth.add(1);
		bigMonth.add(3);
		bigMonth.add(5);
		bigMonth.add(7);
		bigMonth.add(8);
		bigMonth.add(10);
		bigMonth.add(12);

		// add the small month to smallMonth set
		smallMonth.add(4);
		smallMonth.add(6);
		smallMonth.add(9);
		smallMonth.add(11);
	}
	
	private boolean validDay(String[] date){
		if(bigMonth.contains(date[month])&&Integer.parseInt(date[day])>=31)
			return false;
		if(smallMonth.contains(date[month])&&Integer.parseInt(date[day])>=30)
			return false;		
		int dateYear=Integer.parseInt(date[year]);
		if(judgeYear(dateYear)&&Integer.parseInt(date[day])>=29){
			return false;
		}
		if(!judgeYear(dateYear)&&Integer.parseInt(date[day])>=28){
			return false;
		}
		return true;
	}
	 private boolean judgeYear(int year) {
	        if(year%4==0&&year%100!=0) {
	        	return true;
	        }else if(year%400==0) {
	            return true;
	        }else
	            return false;
	    }

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CalculateDays day = new CalculateDays();
		Scanner keybroad=new Scanner(System.in);
		String input=keybroad.nextLine();
		while(!input.equals("quit")){
			String[] inputStr=input.split(" ");
			System.out.print("The input is:");
			System.out.println(inputStr[0]+" "+inputStr[1]);
			System.out.print("The result is:");
			try {
				System.out.println(day.getPeriodInDays(inputStr[0],inputStr[1]));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			input=keybroad.nextLine();
		}
	}

}
