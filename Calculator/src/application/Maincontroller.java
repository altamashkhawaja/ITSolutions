package application;

import javafx.scene.control.Label;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Maincontroller {
	
	@FXML
	private Label result;
	private long number1 = 0;
	private String operator = "";
	private boolean start = true;
	Modal model = new Modal();
	
	@FXML
	public void processNumbers(ActionEvent event)
	{
		if(start)
		{
			result.setText("");
			start = false;
		}
		
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText()+ value);
		
	}
	
    @FXML
	public void processOperators(ActionEvent event)
	{
       String value = ((Button)event.getSource()).getText();
        
       if(!value.equals("="))
       {
    	   if(!operator.isEmpty())
    		   return;
    	   operator = value;
    	   try {
    	   number1 = Long.parseLong(result.getText());
    	   result.setText("");
    	   }catch(NumberFormatException ex)
    	   {
    		   ex.printStackTrace();
    	   }
    	   
    	   
       }
       else
       {
    	   if(operator.isEmpty())
    		   return;
    	   try
    	   {
    	   long number2 =  Long.parseLong(result.getText());
    	 float output =   model.calculate(number1,number2, operator);
    	 result.setText(String.valueOf(output));
    	 operator = "";
    	 start = true;
    	   }catch(NumberFormatException ex)
    	  
    	   {
    		   ex.printStackTrace();
    	   }
    	   
       }
       
		
	}
}
