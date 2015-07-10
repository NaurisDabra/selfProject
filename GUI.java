package selfProject;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sef.module14.sample.ComplexFrame;

public class GUI extends JFrame implements ActionListener{
	private List<CarPark> carPark=new ArrayList<CarPark>();
	private JButton addButton;
	
	JTextField IDInput, nameInput, addressInput, mNameInput, mSurnameInput, mAgeInput, mSalaryInput;
	JLabel IDLabel, nameLabel, addressLabel, mNameLabel, mSurnameLabel, mAgeLabel, mSalaryLabel, textLabel;
	public GUI() {
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(2,3));
	
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,2));
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,3));
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(1,1));
		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(1,1));
		JPanel panel6 = new JPanel();
		panel6.setLayout(new GridLayout(1,1));
		IDLabel =new JLabel("ID");
		nameLabel =new JLabel("Name");
		addressLabel =new JLabel("Address");
		mNameLabel =new JLabel("Manager name");
		mSurnameLabel =new JLabel("Manager surname");
		mAgeLabel =new JLabel("Manager age");
		mSalaryLabel =new JLabel("Manager salary");
		IDInput = new JTextField();
		nameInput = new JTextField();
		addressInput = new JTextField();
		mNameInput = new JTextField();
		mSurnameInput = new JTextField();
		mAgeInput = new JTextField();
		mSalaryInput = new JTextField();
		panel1.add(IDLabel);
		panel1.add(nameLabel);
		panel1.add(IDInput);
		panel1.add(nameInput);
		
		panel2.add(addressLabel);
		panel2.add(mNameLabel);
		panel2.add(addressInput);
		panel2.add(mNameInput);
		
		panel3.add(mSurnameLabel);
		panel3.add(mAgeLabel);
		panel3.add(mSalaryLabel);
		panel3.add(mSurnameInput);
		panel3.add(mAgeInput);
		panel3.add(mSalaryInput);
		
		addButton=new JButton("Pievienot");
		addButton.addActionListener(this);
		panel4.add(addButton);
		textLabel = new JLabel("");
		
		panel5.add(textLabel);
		
		//panel6.add(nameInput);
		
		//panel1.add
		//panel4.add(addButton);
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		pane.add(panel4);
		pane.add(panel5);
		pane.add(panel6);
		setLocation(200,300);
		setSize(1200,300);
		setResizable(false);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == addButton){
			System.out.println("called");
			if(!IDInput.getText().isEmpty()&& !nameInput.getText().isEmpty()&& !addressInput.getText().isEmpty()&& !mNameInput.getText().isEmpty()&& !mSurnameInput.getText().isEmpty()&& !mAgeInput.getText().isEmpty()&& !mSalaryInput.getText().isEmpty()){
				try{
				carPark.add(new CarPark(Integer.parseInt(IDInput.getText()), nameInput.getText(), addressInput.getText(), new Manager(1,mNameInput.getText(), mSurnameInput.getText(), Integer.parseInt(mAgeInput.getText()), Double.parseDouble(mSalaryInput.getText()))));
		textLabel.setText(String.valueOf(carPark.size()));}
				catch(Exception e){
					textLabel.setText("Nepareizi dati");
				}
		}
		else textLabel.setText("Nav aizpilditi visi lauki");
		
	}
	}
	public static void main(String arg[]){
		new GUI();
	}
	

}
