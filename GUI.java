package selfProject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sef.module14.sample.ComplexFrame;

public class GUI extends JFrame {
	static CarPark autoplacis;
	static Manager menedzeris;
	List<Employee> employeeList;
	List<Vehicle> vehicleList;
	List<Manager> managerList;
	List<Cleaner> cleanerList;
	List<Salesperson> salepersonList;
	List<Supplier> supplierList;
	JList listActions;
	JPanel centerPanel;
	JTextField nameF, surnameF, ageF, salaryF;
	JComboBox professionsBox,suppBox;
	JButton actionB;
	final String[] data = { "Hire employee", "Fire employee", "Car delivered", "Car sold", "Company info" };
	final String[] professions = { "Manager", "Salesperson", "Supplier", "Cleaner" };

	public void dataInit() {
		vehicleList = autoplacis.getAllVehicles();
		managerList = autoplacis.getManagerList();
		cleanerList = autoplacis.getCleanerList();
		salepersonList = autoplacis.getSalepersonList();
		supplierList = autoplacis.getSupplierList();
		employeeList = new ArrayList<Employee>(managerList);
		employeeList.addAll(salepersonList);
		employeeList.addAll(supplierList);
		employeeList.addAll(cleanerList);

	}

	// TODO to be replaced with JDBC if needed
	public void setUp() {
		autoplacis = new CarPark(1, "autoplacis", "Riga");
		menedzeris = new Manager(1, "Janis", "Ozols", 40, 500.00, autoplacis);
		autoplacis.addManager(menedzeris);
		menedzeris.hireEmployee(new Salesperson(2, "Nauris", "Dabra", 23, 200));
		menedzeris.hireEmployee(new Supplier(3, "Oskars", "Vacietis", 26, 300));
		menedzeris.hireEmployee(new Cleaner(4, "Janis", "Tirais", 50, 100.00));
		
		Vehicle auto1 = new SportsCar(1, "Mustangs kautkads", 50000.0, 2, 0, 250, true);
		Vehicle auto2 = new Car(2, "Honda", 20000.0, 4, 500);
		Vehicle auto3 = new SportsCar(3, "Ferrari", 200000.0, 2, 0, 300, false);
		Vehicle auto4 = new Car(4, "Honda", 20000.0, 6, 500);
		Vehicle auto5 = new SportsCar(5, "Ferrari", 200000.0, 2, 0, 300, false);
		Vehicle bike1 = new SportsBike(5, "Suzuki", 10000.0, 100, 200, "lightweight");
		Vehicle bike2 = new SportsBike(6, "Suzuki", 15000.0, 100, 200, "lghtweight");
		List<Supplier> piegadataji = autoplacis.getSupplierList();

		Supplier piegadatajs = piegadataji.get(0);

		piegadatajs.supplyCar(auto1);
		piegadatajs.supplyCar(auto2);
		piegadatajs.supplyCar(auto3);
		piegadatajs.supplyCar(auto4);
		piegadatajs.supplyCar(auto5);
		piegadatajs.supplyCar(bike1);
		piegadatajs.supplyCar(bike2);

		
	}

	public GUI() {

		setUp();
		/**
		 * Plans, vienam autoparkam Lietotajs ir gramatvedis/menedzeris var
		 * noalgot darbiniekus ierakstot veertibas var atlaist izveloties no
		 * saraksta un nospiezot pogu var paradit ka masina ir nopirkta
		 * izveloties pardeveju no saraksta, masinu no saraksta un nospiezot
		 * pogu var pievienot var pievienot auto/moci izveloties tipu no
		 * dropdown menu
		 * https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.
		 * html izmantot border layout, west ir JList ar darbibu
		 * iespejam(atlaist, peinemt darbaa, etc.
		 * https://docs.oracle.com/javase/tutorial/uiswing/components/list.html)
		 * , centrs un labaa puse ir izveelnes atteelosanai, top ir exit poga,
		 * bot ir tuks.
		 */
		// TODO Auto-generated constructor stub
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		listActions = new JList(data); // data has type Object[]
		listActions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listActions.setVisibleRowCount(-2);
		listActions.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					switch (((JList) e.getSource()).getSelectedIndex()) {
					case 0:
						pane.remove(centerPanel);
						centerPanel = new HirePanel();
						pane.add(centerPanel, BorderLayout.CENTER);
						pack();
						break;
					case 1:
						pane.remove(centerPanel);
						centerPanel = new FirePanel();
						pane.add(centerPanel, BorderLayout.CENTER);
						pack();
						
						break;
					case 2:
						pane.remove(centerPanel);
						centerPanel = new VehicleBought();
						
						pane.add(centerPanel, BorderLayout.CENTER);
						pack();
						break;
					case 3:
						
						pane.remove(centerPanel);
						centerPanel = new CarSold();
						pane.add(centerPanel, BorderLayout.CENTER);
						pack();
						break;
					case 4:
						pane.remove(centerPanel);
						
						break;
					default:
						System.out.println("Oops");

					}

				}
			}
		});

		JLabel title = new JLabel("Carpark control panel");
		title.setAlignmentX(Label.CENTER);
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		pane.add(listActions, BorderLayout.WEST);
		pane.add(new JLabel("Carpark control panel"), BorderLayout.NORTH);
		pane.add(centerPanel, BorderLayout.CENTER);
		setMinimumSize(new Dimension(400, 400));
		setLocation(720, 200);
		pack();
		setVisible(true);

	}

	public static void main(String arg[]) {
		new GUI();
	}

	class HirePanel extends JPanel {
		public HirePanel() {
			dataInit();
			nameF = new JTextField();
			surnameF = new JTextField();
			ageF = new JTextField();
			salaryF = new JTextField();
			professionsBox = new JComboBox(professions);
			actionB = new JButton("HIRE");
			actionB.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String name="", surname="";
					int age=0;
					double salary=0.00;
					try{
						name=nameF.getText();
						surname=surnameF.getText();
						salary=Double.parseDouble(salaryF.getText());
						age=Integer.parseInt(ageF.getText());
					}
					catch(Exception exc){
						exc.printStackTrace();
						
					}
					switch (professionsBox.getSelectedItem().toString()){
					case "Manager":
						menedzeris.hireEmployee(new Manager(employeeList.size()+2, name, surname, age, salary, autoplacis));
						revalidate();
						repaint();
						break;
					case "Salesperson":
						menedzeris.hireEmployee(new Salesperson(employeeList.size()+2, name, surname, age, salary));
						revalidate();
						repaint();
						break;
					case"Supplier":
						menedzeris.hireEmployee(new Supplier(employeeList.size()+2, name, surname, age, salary));
						revalidate();
						repaint();
						break;
					case "Cleaner":
						menedzeris.hireEmployee(new Cleaner(employeeList.size()+2, name, surname, age, salary));
						revalidate();
						repaint();
						break;
					
					}
				

				}

			});
			setLayout(new GridLayout(5, 3));

			add(new Label("Name"));
			add(new Label("Surname"));
			add(new Label("Age"));
			add(nameF);
			add(surnameF);
			add(ageF);
			add(new Label("Salary"));
			add(new JPanel());
			add(new Label("Profession"));
			add(salaryF);
			add(new JPanel());
			add(professionsBox);
			add(new JPanel());
			actionB.setMinimumSize(new Dimension(70, 70));
			add(actionB);
			add(new JPanel());
		

		}
	}

	class FirePanel extends JPanel {
		public FirePanel() {
			dataInit();
			String[] empList = new String[employeeList.size()];
			for (int i = 0; i < empList.length; i++) {
				empList[i] = employeeList.get(i).getName() + " " + employeeList.get(i).getSurname() + " "
						+ employeeList.get(i).getProfession();
			}
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			JComboBox employeeBox = new JComboBox(empList);
			employeeBox.setAlignmentX(Component.CENTER_ALIGNMENT);

			actionB = new JButton("FIRE");
			actionB.setAlignmentX(Component.CENTER_ALIGNMENT);
			actionB.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					menedzeris.fireEmployee(employeeList.get(employeeBox.getSelectedIndex()));
					revalidate();
					repaint();
				}

			});
			add(employeeBox);
			add(actionB);

		}
	}

	class BaseVehicle extends JPanel {
		public BaseVehicle() {
			setLayout(new GridLayout(2, 2));
			JLabel nameL = new JLabel("Name");
			JLabel priceL = new JLabel("Price");
			JTextField nameCF = new JTextField();
			JTextField priceCF = new JTextField();
			nameL.setAlignmentX(Label.CENTER_ALIGNMENT);
			priceL.setAlignmentX(Label.CENTER_ALIGNMENT);
			add(nameL);
			add(nameCF);
			add(priceL);
			add(priceCF);
		}
	}

	class BaseCar extends JPanel {
		
		public BaseCar() {
			JPanel vehicle=new JPanel();
			vehicle.setLayout(new GridLayout(2, 2));
			JLabel nameL = new JLabel("Name");
			JLabel priceL = new JLabel("Price");
			JTextField nameCF = new JTextField();
			JTextField priceCF = new JTextField();
			nameL.setAlignmentX(Label.CENTER_ALIGNMENT);
			priceL.setAlignmentX(Label.CENTER_ALIGNMENT);
			vehicle.add(nameL);
			vehicle.add(nameCF);
			vehicle.add(priceL);
			vehicle.add(priceCF);
			setLayout(new GridLayout(2, 1));
			add(vehicle);
			
			JPanel grid = new JPanel();
			grid.setLayout(new GridLayout(2, 2));
			JLabel trunkL = new JLabel("Trunk Volume");
			JLabel seatsL = new JLabel("Seats");
			JTextField	trunkF = new JTextField();
			JTextField seatsF = new JTextField();
			trunkL.setAlignmentX(Label.CENTER_ALIGNMENT);
			seatsF.setAlignmentX(Label.CENTER_ALIGNMENT);
			grid.add(trunkL);
			grid.add(trunkF);
			grid.add(seatsL);
			grid.add(seatsF);
			
			add(grid);
			actionB=new JButton("Register");
			actionB.setAlignmentX(CENTER_ALIGNMENT);
			actionB.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String name;
					Double price;
					float volume;
					int seats;
					try{
						System.out.println(seatsF.getText());
						System.out.println(priceCF.getText());
						System.out.println(nameCF.getText());
					
						price=Double.parseDouble(priceCF.getText());
						name=nameCF.getText();
						volume=Float.parseFloat(trunkF.getText());
						seats=Integer.parseInt(priceCF.getText());
						supplierList.get(suppBox.getSelectedIndex()).supplyCar(new Car(vehicleList.size()+2, name,price, seats, volume));
						System.out.println("Car");
					}
					catch(Exception exc){
						exc.printStackTrace();
						System.out.println("Shit");
						
					}
				}
			});
			add(actionB);
		}

	}

	class SportsCarPanel extends JPanel {
		public SportsCarPanel() {
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			JLabel speedL = new JLabel("Max speed");
			JLabel legalL = new JLabel("Street legal");
			JTextField speedF = new JTextField();
			String[] legality = { "Is legal", "Isn't legal" };
			JComboBox legalBox = new JComboBox(legality);
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(2, 2));
			panel.add(speedL);
			panel.add(speedF);
			panel.add(legalL);
			panel.add(legalBox);
			JPanel car = new BaseCar();
			car.remove(actionB);
			add(car);
			add(panel);
			actionB=new JButton("Register");
			actionB.setAlignmentX(CENTER_ALIGNMENT);
			add(actionB);
			
		}
	}
   class BaseSportsBike extends JPanel{
	   private final String[] possibleClassifications = { "Lightweight", "Middleweight", "Superbike" };
	   public BaseSportsBike(){
		   setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		   JPanel panel=new JPanel();
		   panel.setLayout(new GridLayout(2,3));
		   JLabel engineL=new JLabel("Engine Volume");
		   JLabel speedL=new JLabel("Max Speed");
		   JLabel classificationL=new JLabel("Class");
		   JTextField engineF=new JTextField();
		   JTextField speedF=new JTextField();
		   JComboBox classificationBox= new JComboBox(possibleClassifications);
		   panel.add(engineL);
		   panel.add(speedL);
		   panel.add(classificationL);
		   panel.add(engineF);
		   panel.add(speedF);
		   panel.add(classificationBox);
		   JPanel vehicle = new BaseVehicle();
		   vehicle.remove(actionB);
		   add(new BaseVehicle());
		   add(panel);
		   actionB=new JButton("Register");
			actionB.setAlignmentX(CENTER_ALIGNMENT);
			add(actionB);

	   }
   }
	class VehicleBought extends JPanel {
		public VehicleBought(){
			dataInit();
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			final String CAR= "Car";
			final String SCAR="Sports car";
			final String SBIKE="Sports bike";
			JPanel cards = new JPanel(new CardLayout());
			JPanel card1 = new BaseCar();
			JPanel card2 = new SportsCarPanel();
			JPanel card3 = new BaseSportsBike();
			cards.add(card1, CAR);
			cards.add(card2, SCAR);
			cards.add(card3, SBIKE);
			
			
			JPanel comboBoxPane = new JPanel(); //use FlowLayout
			String comboBoxItems[] = { "Car", "Sports car", "Sports bike"};
			String suppliers[]=new String[supplierList.size()];
			for(int i=0;i<suppliers.length;i++)
				suppliers[i]=supplierList.get(i).getName()+" "+supplierList.get(i).getName();
			JComboBox cb = new JComboBox(comboBoxItems);
			suppBox=new JComboBox(suppliers);
			suppBox.setEditable(false);
			cb.setEditable(false);
			cb.addItemListener(new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					 CardLayout cl = (CardLayout)(cards.getLayout());
					    cl.show(cards, (String)e.getItem());
				}
				
			});
			comboBoxPane.add(cb);
			comboBoxPane.add(suppBox);
			
		
    		
			add(comboBoxPane, BorderLayout.PAGE_START);
			add(cards, BorderLayout.CENTER);
    		

	}
	}

	class CarSold extends JPanel {
		public CarSold() {
			dataInit();
			String[] carList = new String[vehicleList.size()];
			for (int i = 0; i < carList.length; i++) {
				carList[i] = vehicleList.get(i).getName() + " " + vehicleList.get(i).getPrice();
			}
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			JComboBox carBox = new JComboBox(carList);
			carBox.setAlignmentX(Component.CENTER_ALIGNMENT);
			String[] salesP = new String[salepersonList.size()];
			for (int i = 0; i < salesP.length; i++) {
				salesP[i] = salepersonList.get(i).getName() + " " + salepersonList.get(i).getSurname();
			}
			JComboBox salespersonBox = new JComboBox(salesP);
			actionB = new JButton("SOLD");
			actionB.setAlignmentX(Component.CENTER_ALIGNMENT);
			salespersonBox.setAlignmentX(Component.CENTER_ALIGNMENT);
			actionB.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					salepersonList.get(salespersonBox.getSelectedIndex()).sellVehicle(vehicleList.get(carBox.getSelectedIndex()));

				}

			});
			JPanel panel1 = new JPanel();
			panel1.setLayout(new GridLayout(4, 1));
			Label sellerL = new Label("Seller");
			sellerL.setAlignment(Label.CENTER);
			Label vehicleL = new Label("Sold vehicle");
			vehicleL.setAlignment(Label.CENTER);
			panel1.add(sellerL);
			panel1.add(salespersonBox);
			panel1.add(vehicleL);
			panel1.add(carBox);

			add(panel1);
			add(actionB);
		}
	}
}
