/**
 Class          : View
 Author         : Linghua Jin
 Description    :
 
 1. create the window;
 2. draw all the components;
 3. needs info. from Model, Controller
 
 */


package travelForm;

import javax.swing.*;
import java.awt.GridLayout;

public class View extends JFrame{
  //declaration in  code to supply the version UID.
  //else serializable class does not declare a static final serialVersionUID field
  private static final long serialVersionUID = 1L; 
  
  public View(){
  }
  
  public void addController(Controller c)
  {
    controller = c;
  }
  
  public void addModel(Model m)
  {
    model = m;
  }
  
//  public void addData(Data d)
//  {data = d;}
  
  public void build(){
    
    setSize(500,250);
    setTitle("Travel Form");
    
    // generate 5 panels, each contains on line;
    JPanel pnMain = new JPanel(new GridLayout(5,1));
    JPanel pn1 = new JPanel();
    JPanel pn2 = new JPanel();
    JPanel pn3 = new JPanel();
    JPanel pn4 = new JPanel();
    JPanel pn5 = new JPanel();
    
    JTextField txt1 = controller.getTextField(25,"from");
    JTextField txt2 = controller.getTextField(25,"to");
    
    JComboBox cb10 = controller.getComboBox(model.getMonth(),"departMonth");
    JComboBox cb11 = controller.getComboBox(model.getDate(),"departDate");
    JComboBox cb12 = controller.getComboBox(model.getYear(),"departYear");
    JComboBox cb13 = controller.getComboBox(model.getTime(),"departTime");
    
    JComboBox cb20 = controller.getComboBox(model.getMonth(),"returnMonth");
    JComboBox cb21 = controller.getComboBox(model.getDate(),"returnDate");
    JComboBox cb22 = controller.getComboBox(model.getYear(),"returnYear");
    JComboBox cb23 = controller.getComboBox(model.getTime(),"returnTime");
    
    JComboBox cb30 = controller.getComboBox(model.getPassenger(),"passenger");
    
    //add components to sepearte panels
    pn1.add(controller.getLabel("From:")); pn1.add(txt1); 
    pn2.add(controller.getLabel("To:")); pn2.add(txt2); 
    pn3.add(controller.getLabel("Departure:")); pn3.add(cb10); pn3.add(cb11); pn3.add(cb12); pn3.add(cb13);
    pn4.add(controller.getLabel("Return:")); pn4.add(cb20); pn4.add(cb21); pn4.add(cb22); pn4.add(cb23);
    pn5.add(controller.getLabel("Passenger:")); pn5.add(cb30); pn5.add(controller.getButton("Submit"));
    
    // add sub panels to the main panel
    pnMain.add(pn1); pnMain.add(pn2); pnMain.add(pn3); pnMain.add(pn4); pnMain.add(pn5);
    add(pnMain);
    
    setVisible(true);
    
  }
  
//  void update(){
//    repaint();
//  }
  
  // view needs to be manipulated by both model and controller 
  private Controller controller;  
  private Model model; 
  
}