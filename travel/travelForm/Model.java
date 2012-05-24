/**
 Class          : Model
 Author         : Linghua Jin
 Description    :
 
 1. create all the strings that needs to build JComboBox.
 2. no need to add view or controller here, it's not going to manipulate the data from view or controller
 unless it needs to notify the view;
 
 */


package travelForm;

import java.text.DateFormatSymbols;

public class Model{
  private final int DATE_TOTAL=32;
  private final int PASSENGER_TOTAL=10;
  private final int MONTH_TOTAL=13;
  
  public Model(){
    setDate();
    setPassenger(); 
    setMonth();
  }
  
//  public void addView(View v){ 
//    view=v;
//  }
  
  private void setDate(){
    date[0] = "select date";
    for (int i = 1;i < DATE_TOTAL;i++){     
      date[i] = Integer.toString(i);
    }
  }
  
  private void setPassenger(){
    for (int i = 0;i<PASSENGER_TOTAL;i++){
      passenger[i] = Integer.toString(i + 1);
    }
  }
  
  private void setMonth(){
    month[0] = "select month";
    for (int i = 1;i < MONTH_TOTAL;i++){      
      month[i]=new DateFormatSymbols().getMonths()[i - 1];
    }    
  }
  
  //Accessors
  public String[] getYear(){
    return year;
  }
  public String[] getMonth(){
    return month;
  }
  public String[] getDate(){
    return date;
  }
  
  public String[] getTime(){
    return time;
  }
  
  public String[] getPassenger(){
    return passenger;
  }
  
  
  //Instance variable
  
  private String[] year      = {"select year","2011","2012"};
  private String[] month     = new String[MONTH_TOTAL];
  private String[] date      = new String[DATE_TOTAL];
  private String[] time      = {"anytime","noon","morning","evening","night"};
  private String[] passenger = new String[PASSENGER_TOTAL];
}