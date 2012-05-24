/**
 Class          : Application
 Author         : Linghua Jin
 Description    :
 
 1. create Model, Data, Controller, View object;
 2. build and connect components in the travelForm package; 
 3. setup the dependence of classes;
 4. draw the view;
 
 */


import travelForm.*;

public class Application
{
 public static void main(String[] args)
 {

   Model      model      = new Model();
   Data       data       = new Data();
   Controller controller = new Controller();
   View       view       = new View();

   //set dependence of the classes in package; 
   controller.addData(data);
   view.addModel(model);
  //view.addData(data);
   view.addController(controller);
   
   //draw the view 
   view.build();
   
 }
}