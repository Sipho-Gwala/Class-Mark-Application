import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class ClassMarks extends JPanel{
	private static final long serialVersionUID = 1L;
	private JList<String> assessmentsList;
	private JList<String> marksList;
	private JTextArea classMarksArea;
	private double test1Mark, test2Mark, test3Mark, assign1Mark, assign2Mark, pracMark;
	
	public ClassMarks(){
		// setTitle("Class Marks Application");
	    setSize(400, 500);
	    
	    JPanel panel = new JPanel(new GridLayout(4,1));	    
	    
	    //set the list of assessments
	    DefaultListModel<String> assessments = new DefaultListModel<String>();
	    assessments.addElement("Test 1");
	    assessments.addElement("Test 2");
	    assessments.addElement("Test 3");
	    assessments.addElement("Assignment 1");
	    assessments.addElement("Assignment 2");
	    assessments.addElement("Practical");
	    assessmentsList = new JList<String>(assessments);
	    
       //set the list of marks
	    DefaultListModel<String> mark = new DefaultListModel<String>();
	    for(int i=1;i<=100;i+=1){
	      mark.addElement(String.valueOf(i));
	    }
	    marksList = new JList<String>(mark);
	    JLabel lblMarks = new JLabel("Marks:");
	    
	    JPanel dataLabelPanel = new JPanel(new GridLayout(1,2, 100, 0));
	    JLabel lblAssessments = new JLabel("Assessments: ");
	    dataLabelPanel.add(lblAssessments);
	    dataLabelPanel.add(lblMarks);
	    
	    JPanel dataPanel = new JPanel(new GridLayout(1,2, 100, 0));    
	    dataPanel.add(new JScrollPane(assessmentsList));
	    dataPanel.add(new JScrollPane(marksList));
	    
	    JPanel classMarksAreaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    classMarksArea = new JTextArea(10, 25);
	    classMarksAreaPanel.add(classMarksArea);
	    
       //set the buttons
	    JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
	    JButton btnSubmit = new JButton("Submit");
	    btnSubmit.addMouseListener(new SubmitButtonHandler());
       JButton btnExit = new JButton("Exit");
	    btnExit.addMouseListener(new ExitButtonHandler());
	    JButton classMark = new JButton("Class MARK");
	    classMark.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				classMarksArea.append("-----------------------------------------"+"\n");
				double summative = 0.25*(test1Mark + test2Mark) + (0.30*test3Mark);
				double formative = 0.80*((assign1Mark + assign1Mark)/2) + 0.20*(pracMark);
				double mark = summative + 0.20*(formative);
				classMarksArea.append("YOUR CLASS MARK IS : "+mark+"%");

			}
	    	
	    });
         
	    btnPanel.add(btnSubmit);
	    btnPanel.add(classMark);
	    btnPanel.add(btnExit);
	    
	    panel.add(dataLabelPanel);
	    panel.add(dataPanel);
	    panel.add(classMarksAreaPanel);
	    panel.add(btnPanel)	;
	    this.add(panel);
	}
	
	public class SubmitButtonHandler extends MouseAdapter {
	       public void mouseClicked(MouseEvent e) {
	         String assessment = assessmentsList.getSelectedValue();
	         double mark = Double.parseDouble(marksList.getSelectedValue());
	         
	         if(assessment.equals("Test 1")) 
	        	 test1Mark=mark;
	         else if(assessment.equals("Test 2")) 
	        	 test2Mark=mark;
	         else if(assessment.equals("Test 3")) 
	        	 test3Mark=mark;
	         else if(assessment.equals("Assignment 1")) 
	        	 assign1Mark=mark;
	         else if(assessment.equals("Assignment 2")) 
	        	 assign2Mark=mark;
	         else if(assessment.equals("Practical")) 
	        	 pracMark=mark;
	         
	         
	         classMarksArea.append(assessment+" mark is: "+mark+"\n"); 	         
	      }
	}
  
  public class ExitButtonHandler extends MouseAdapter{
	      public void mouseClicked(MouseEvent e) {
	        System.exit(0);
	     }
	}
}
