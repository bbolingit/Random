

//Importing necessary classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.lang.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;

public class MortgageCalc extends JFrame implements DocumentListener {

  JTextField payment = new JTextField();
  JTextField rate = new JTextField();
  JTextField principle = new JTextField();
  JTextField paymentPeriod = new JTextField();
  String[] compoundLengths = {"Yearly", "Quarterly", "Monthly", "Daily", "Continuously"};
  JComboBox compoundTime = new JComboBox(compoundLengths);

  public MortgageCalc() {
	
	super("Payment Calculator");
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);

	payment.setEditable(false);
	JLabel principleLabel = new JLabel("Principle:");
	JLabel rateLabel = new JLabel("Rate:");
	JLabel paymentLabel = new JLabel("Payment:");
	rate.getDocument().addDocumentListener(this);
	JLabel paymentLength = new JLabel("Payment Length in Months");
	JLabel compoundLabel = new JLabel("Compounding Interval");
	paymentPeriod.getDocument().addDocumentListener(this);
	compoundTime.setSelectedIndex(0);
	JPanel pane = new JPanel(new GridLayout(0, 2));
	pane.add(principleLabel);
	pane.add(principle);
	pane.add(rateLabel);
	pane.add(rate);
	pane.add(paymentLength);
	pane.add(paymentPeriod);
	pane.add(compoundLabel);
	pane.add(compoundTime);
	pane.add(paymentLabel);
	pane.add(payment);
	add(pane);
  }


  @Override
  public void changedUpdate(DocumentEvent e){
	calcPayment();
  }
	
  @Override
  public void removeUpdate(DocumentEvent e){
	calcPayment();
  }

  @Override
  public void insertUpdate(DocumentEvent e){
	calcPayment();
  }

  private void calcPayment(){
	float principleAmount = checkInput(principle, 100000000);
	float rateAmount = checkInput(rate, 100);
	float paymentLength = checkInput(paymentPeriod, 1000);
	String compoundType = compoundTime.getSelectedItem();
	double compoundFreq = 0;
	if(compoundType.equals("Yearly")) compoundFreq = 1;
	else if(compoundType.equals("Quarterly")) compoundFreq = 4;
	else if(compoundType.equals("Monthly")) compoundFreq = 12;
	else if(compoundType.equals("Daily")) compoundFreq = 365;
	else if(compoundType.equals("Continuously")) compoundFreq = 1;
	
	double monthlyPayment = (principleAmount * rateAmount) / (1); 
	payment.setText(Double.toString(monthlyPayment));
  }

  private float checkInput(JTextField givenField, int limit){

	try{
		//checks to see if a valid float is in the text field
		//and sets the border to black if valid
		float n = Float.parseFloat(givenField.getText());
		if((n < 0) || (n > limit)) throw new NumberFormatException();
		Border outLine = BorderFactory.createLineBorder(Color.black, 1);
		givenField.setBorder(outLine);
		return n;
	} catch (NullPointerException nothing){
	} catch (NumberFormatException notANumber){

		//sets the border to red if an invalid input exception is thrown
		Border outLine = BorderFactory.createLineBorder(Color.red, 1);
		givenField.setBorder(outLine);
	}
  }

  //main method which creates the class and displays it
  public static void main (String args[]){
	MortgageCalc example = new MortgageCalc();
	example.pack();
  	example.setVisible(true);
  }
}
