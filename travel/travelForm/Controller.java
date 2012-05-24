/** 
 Class          : Controller
 Author         : Linghua Jin
 Description    :
 
 1. create JButton, JTextField, JComboxBox, attach listener in the function, so each time
    an object is created through View, it is attached a listener;  
 2. Store the value into Data Model; Only needs to add Data Model.
 3. Combo Model is not directly used here, View is not directly used here; so no needed to add them
 
 */

package travelForm;

import javax.swing.   *; //for the components like JButton
import java.awt.event.*; //for the listeners

public class Controller
{ 
  public Controller(){
  }
  
  // set function for the application to add dependance.
  public void addData(Data d)
  {
    data = d;            
    // d is passed in, so later can modify d.
  }
  
  // build components
  JLabel getLabel(String s)
  {
    return new JLabel(s);
  }
  
  /**
   * build a JComboBox
   * input:String Array contains the items to select; 
   * input:String key1 is the name of the combobox, so later can modify the corresponding Data data value.
   * */
  JComboBox getComboBox(String[] s,String key)
  {
    final JComboBox cb = new JComboBox(s);
    final String keyFinal = key;
    
    cb.addItemListener(new ItemListener(){
      @Override
      public void itemStateChanged(ItemEvent e){
        if ((e.getItemSelectable() == cb) &&
            (e.getStateChange() == ItemEvent.SELECTED)){
          String choice = e.getItem().toString();
          // each time choose from combo list, add the pair into hash table
          data.addElement(keyFinal, choice);
        }
      }
    });
    return cb;
  }
  
  JTextField getTextField(int fieldSize, String key)
  {
    final JTextField txt = new JTextField(fieldSize);
    final String keyFinal = key;
    
    txt.addFocusListener(new FocusListener(){
      @Override
      public void focusGained(FocusEvent e)
      {}
      
      // get the text when focus is changed
      @Override
      public void focusLost(FocusEvent e)
      {
        String text=txt.getText();
        data.addElement(keyFinal, text);
        
      }});
    return txt;
  }
  
  /**
   * add listener to JButton "submit".
   * when JButton is pressed, show the JOptional Pane info
   */
  
  JButton getButton(String btnLabel)
  {
    final JButton btn = new JButton(btnLabel);
    
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        
        //if submit button is pressed, show the message, the info. is storged in Data object. 
        JOptionPane.showMessageDialog(null, data.display());
        
      }});
    
    return btn;
  }
  
  
  //instance variable 
  private Data  data;
}