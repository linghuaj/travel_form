/**
 Class          : Data
 Author         : Linghua Jin
 Description    :
 
 1. This is the class that stores all the value generated from controller
 2. Same as ComboModel, no need to add view or controller.
 3. the basic data structure is a hashtable
 4. basic function is to validate the hashtable and return a String later can print out on screen.
 
 */


package travelForm;

import java.util.Hashtable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Data{
  public Data(){
    //initialize hash - keys are in the string[] keys, values are"" 
    for (int i = 0;i < keys.length;i++){
      hash.put(keys[i], "");
    }      
    hash.put("passenger","1"); hash.put("departTime","anytime"); hash.put("returnTime","anytime"); 
    
  }
  
  /**
   * function allow hashtable to add elements,so controller can call it to update hashtable
   */
  public void addElement(String key,String value){
    hash.put(key,value);
  }
  
  /**
   * If the hashtable is incomplete or invalid , return error info.
   * Else: return the pritable string for the JOption Pane.
   */
  public String display(){
    String info = "";
    
    // check if hash has complete data, compare to initial hash value 
    for (int i = 0;i < keys.length;i++){
      if (hash.get(keys[i]).equals("")){
        return "Error: Lacking input of \""+keys[i] +"\"";       
      }
    }
    
    // check if hash has complete data, compare to initial JComboBox value
    for (int i = 2;i < keys.length;i++){
      if (hash.get(keys[i]).startsWith("select")){   
        return "Error: Lacking input of \""+keys[i] +"\"";  
      }
    }
    
    //whether input the right time
    //Convert String to date
    Date date1 = createDate(hash.get("departMonth"), hash.get("departDate"),hash.get("departYear"));
    Date date2 = createDate(hash.get("returnMonth"),hash.get("returnDate"),hash.get("returnYear"));
    
    if ((date1 == null)){
      return "Error: depart date invalid";
    }
    if ((date2 == null)){
      return "Error: return date invalid";
    }
    
    if (date1.after(date2)){
      return" Error: return date should be after depart date";
    }
    
    info += "Number of passengers: " + hash.get("passenger") + "\n"
      + "From: " + hash.get("from") + "\n"     
      + "To: " + hash.get("to") + "\n" 
      
      + "Departing: "+ hash.get("departMonth") + " "+hash.get("departDate")
      + " "+hash.get("departYear") + " "+hash.get("departTime") + "\n"
      
      + "Returning: " + hash.get("returnMonth") + " " + hash.get("returnDate")
      + " "+hash.get("returnYear") + " " + hash.get("returnTime") + "\n";
    
    
    return info;
    
  }  
  
  /**
   * pass in three strings, and convert it into standard Date object; 
   */
  public Date createDate(String m, String d, String y)
  {
    String s = m+" "+d+" "+y;
    SimpleDateFormat sdf=new SimpleDateFormat("MMMM dd yyyy");
    sdf.setLenient(false);
    try{
      return sdf.parse(s);
    }catch(ParseException e){
      return null;
    }
  }
  
  private Hashtable<String,String> hash=new Hashtable<String,String>();
  
  String[] keys = {"from","to","departMonth","departDate","departYear","returnMonth","returnDate","returnYear","returnTime","departTime","passenger"};
  
  
}