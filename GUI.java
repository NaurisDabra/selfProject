package selfProject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sef.module14.sample.ComplexFrame;

public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9030761986750170413L;
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
	JComboBox professionsBox, suppBox;
	JButton actionB;
	final String[] data = { "Hire employee", "Fire employee", "Employee list", "Car delivered", "Car sold", "Car list", "Company info" };
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
		menedzeris=managerList.get(0);

	}

	// TODO to be replaced with JDBC if needed
	public void setUp() {
		autoplacis = new CarPark(1, "autoplacis", "Riga");
		menedzeris = new Manager(1, "Janis", "Ozols", 40, 500.00, autoplacis);
		autoplacis.setManager(menedzeris);
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
		dataInit();
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
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		listActions = new JList(data); // data has type Object[]
		listActions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listActions.setVisibleRowCount(-2);
		listActions.setMinimumSize(new Dimension(150, 400));
		listActions.setPreferredSize(new Dimension(150, 400));
		listActions.setFont(new Font("Serif", Font.PLAIN, 16));
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
						centerPanel = new EmployeeListPanel();
						pane.add(centerPanel, BorderLayout.CENTER);
						pack();
						break;
					case 3:
						pane.remove(centerPanel);
						centerPanel = new VehicleBought();

						pane.add(centerPanel, BorderLayout.CENTER);
						pack();
						break;
					case 4:

						pane.remove(centerPanel);
						centerPanel = new CarSold();
						pane.add(centerPanel, BorderLayout.CENTER);
						pack();
						break;
					case 5:
						pane.remove(centerPanel);
						centerPanel = new CarListPanel();
						pane.add(centerPanel, BorderLayout.CENTER);
						pack();
						break;
					case 6:
						pane.remove(centerPanel);
						centerPanel = new InfoPanel();
						pane.add(centerPanel, BorderLayout.CENTER);
						pack();
						break;
					default:
						System.out.println("Oops");

					}

				}
			}
		});

		JLabel title = new JLabel("Carpark control panel");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setFont(new Font("Serif", Font.PLAIN, 18));
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		pane.add(listActions, BorderLayout.WEST);
		pane.add(title, BorderLayout.NORTH);
		pane.add(centerPanel, BorderLayout.CENTER);
		setMinimumSize(new Dimension(400, 400));
		setLocation(720, 200);
		pack();
		setVisible(true);

	}

	public static void main(String arg[]) {
		new GUI();
	}

	public static String convertToMultiline(String orig) {
		return "<html>" + orig.replaceAll("\n", "<br>")+"</html>";
	}

	class InfoPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3472043302845663500L;

		public InfoPanel() {
			setLayout(new GridLayout(1, 1));
			dataInit();
			String texts =autoplacis.toString();
			JTextArea info = new JTextArea(texts);
			info.setLineWrap(true);
			info.setEditable(false);
			// info.setPreferredSize(centerPanel.getSize());
			JScrollPane scroller = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //info.setPreferredSize(new Dimension(20, 110));
			setPreferredSize(new Dimension(450, 110));
			scroller.setPreferredSize(new Dimension((int) centerPanel.getSize().getWidth(),200));
			add(scroller);

			

		}
	}
class EmployeeListPanel extends JPanel{
	public EmployeeListPanel(){
		setLayout(new GridLayout(1, 1));
		dataInit();
		String texts =autoplacis.printEmployees();
		JTextArea info = new JTextArea(texts);
		info.setLineWrap(true);
		info.setEditable(false);
		// info.setPreferredSize(centerPanel.getSize());
		JScrollPane scroller = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    //info.setPreferredSize(new Dimension(20, 110));
		setPreferredSize(new Dimension(450, 110));
		scroller.setPreferredSize(new Dimension((int) centerPanel.getSize().getWidth(),200));
		add(scroller);
	}
	
}
class CarListPanel extends JPanel{
	public CarListPanel(){
		setLayout(new GridLayout(1, 1));
		dataInit();
		String texts =autoplacis.printVehicles();
		JTextArea info = new JTextArea(texts);
		info.setLineWrap(true);
		info.setEditable(false);
		// info.setPreferredSize(centerPanel.getSize());
		JScrollPane scroller = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    //info.setPreferredSize(new Dimension(20, 110));
		setPreferredSize(new Dimension(450, 110));
		scroller.setPreferredSize(new Dimension((int) centerPanel.getSize().getWidth(),200));
		add(scroller);
	}
}
	class HirePanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3284055168868495160L;

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
					String name = "", surname = "";
					int age = 0;
					double salary = 0.00;
					try {
						name = nameF.getText();
						surname = surnameF.getText();
						salary = Double.parseDouble(salaryF.getText());
						age = Integer.parseInt(ageF.getText());
					} catch (Exception exc) {
						exc.printStackTrace();
						JOptionPane.showMessageDialog(getContentPane(), "Incorrect input data");

					}
					switch (professionsBox.getSelectedItem().toString()) {
					case "Manager":
						menedzeris.hireEmployee(
								new Manager(employeeList.size() + 2, name, surname, age, salary, autoplacis));
						JOptionPane.showMessageDialog(getContentPane(), "Manager hired");
						break;
					case "Salesperson":
						menedzeris.hireEmployee(new Salesperson(employeeList.size() + 2, name, surname, age, salary));
						JOptionPane.showMessageDialog(getContentPane(), "Salesperson hired");
						break;
					case "Supplier":
						menedzeris.hireEmployee(new Supplier(employeeList.size() + 2, name, surname, age, salary));
						JOptionPane.showMessageDialog(getContentPane(), "Supplier hired");
						break;
					case "Cleaner":
						menedzeris.hireEmployee(new Cleaner(employeeList.size() + 2, name, surname, age, salary));
						JOptionPane.showMessageDialog(getContentPane(), "Cleaner hired");
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
		/**
		 * 
		 */
		private static final long serialVersionUID = 7491925401004026271L;

		public FirePanel() {
			dataInit();
			String[] empList = new String[employeeList.size()];
			for (int i = 0; i < empList.length; i++) {
				empList[i] = employeeList.get(i).getName() + " " + employeeList.get(i).getSurname() + " "
						+ employeeList.get(i).getProfession();
			}
			setLayout(new GridLayout(5, 1));
			JComboBox employeeBox = new JComboBox(empList);
			employeeBox.setAlignmentX(Component.CENTER_ALIGNMENT);
			JPanel panel = new JPanel();
			actionB = new JButton("FIRE");
			actionB.setAlignmentX(Component.CENTER_ALIGNMENT);
			actionB.setPreferredSize(new Dimension(120, 30));
			actionB.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					int index=employeeBox.getSelectedIndex(),size=0;
					Employee employee=employeeList.get(index);
					String prof=employee.getProfession();
					for(Employee emp: employeeList)
						if(emp.getProfession()==prof)
							size++;
					if(size>1){
					menedzeris.fireEmployee(employee);
					dataInit();
					employeeBox.removeItem(employeeBox.getSelectedItem());
					JOptionPane.showMessageDialog(getContentPane(), "Employee fired");
					repaint();
					revalidate();}
					else JOptionPane.showMessageDialog(getContentPane(), "Can't fire last employee of this profession");
					
					
				}

			});
			add(new JPanel());
			add(new JPanel());

			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(employeeBox);
			panel.add(actionB);
			add(panel);
			add(new JPanel());
			add(new JPanel());

		}
	}

	class BaseVehicle extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8308353125659384293L;

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

		/**
		 * 
		 */
		private static final long serialVersionUID = -4670792200826933311L;

		public BaseCar() {
			JPanel vehicle = new JPanel();
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
			setLayout(new GridLayout(3, 1));
			add(vehicle);

			JPanel grid = new JPanel();
			grid.setLayout(new GridLayout(2, 2));
			JLabel trunkL = new JLabel("Trunk Volume");
			JLabel seatsL = new JLabel("Seats");
			JTextField trunkF = new JTextField();
			JTextField seatsF = new JTextField();
			trunkL.setAlignmentX(Label.CENTER_ALIGNMENT);
			seatsF.setAlignmentX(Label.CENTER_ALIGNMENT);
			grid.add(trunkL);
			grid.add(trunkF);
			grid.add(seatsL);
			grid.add(seatsF);

			add(grid);

			actionB = new JButton("Register");
			actionB.setAlignmentX(CENTER_ALIGNMENT);
			actionB.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String name;
					Double price;
					float volume;
					int seats;
					try {

						price = Double.parseDouble(priceCF.getText());
						name = nameCF.getText();
						volume = Float.parseFloat(trunkF.getText());
						seats = Integer.parseInt(priceCF.getText());
						supplierList.get(suppBox.getSelectedIndex())
								.supplyCar(new Car(vehicleList.size() + 2, name, price, seats, volume));
						JOptionPane.showMessageDialog(getContentPane(), "Car added");
					} catch (Exception exc) {
						exc.printStackTrace();
						JOptionPane.showMessageDialog(getContentPane(), "Incorrect input data.");

					}
				}
			});
			JPanel buttonP = new JPanel();
			buttonP.setLayout(new FlowLayout());
			buttonP.add(actionB);
			add(buttonP);
		}

	}

	class SportsCarPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5052959313653659340L;

		public SportsCarPanel() {
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

			JPanel vehicle = new JPanel();
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

			JPanel grid = new JPanel();
			grid.setLayout(new GridLayout(2, 2));
			JLabel trunkL = new JLabel("Trunk Volume");
			JLabel seatsL = new JLabel("Seats");
			JTextField trunkF = new JTextField();
			JTextField seatsF = new JTextField();
			trunkL.setAlignmentX(Label.CENTER_ALIGNMENT);
			seatsF.setAlignmentX(Label.CENTER_ALIGNMENT);
			grid.add(trunkL);
			grid.add(trunkF);
			grid.add(seatsL);
			grid.add(seatsF);
			JPanel baseCar = new JPanel();
			baseCar.setLayout(new GridLayout(2, 1));
			baseCar.add(vehicle);
			baseCar.add(grid);
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

			// baseCar.remove(actionB);
			add(baseCar);
			add(panel);
			actionB = new JButton("Register");
			actionB.setAlignmentX(CENTER_ALIGNMENT);
			actionB.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String name;
					Double price;
					float volume;
					int seats, speed;
					boolean legal = false;
					try {

						price = Double.parseDouble(priceCF.getText());
						name = nameCF.getText();
						volume = Float.parseFloat(trunkF.getText());
						seats = Integer.parseInt(priceCF.getText());
						speed = Integer.parseInt(speedF.getText());
						if (legalBox.getSelectedIndex() == 0)
							legal = true;
						if (legalBox.getSelectedIndex() == 1)
							legal = false;

						supplierList.get(suppBox.getSelectedIndex()).supplyCar(
								new SportsCar(vehicleList.size() + 2, name, price, seats, volume, speed, legal));
						JOptionPane.showMessageDialog(getContentPane(), "Car added");
					} catch (Exception exc) {
						exc.printStackTrace();
						JOptionPane.showMessageDialog(getContentPane(), "Incorrect input data.");

					}
				}
			});
			add(actionB);

		}
	}

	class BaseSportsBike extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2080176734667890912L;
		private final String[] possibleClassifications = { "Lightweight", "Middleweight", "Superbike" };

		public BaseSportsBike() {

			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			JPanel vehicle = new JPanel();
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

			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(2, 3));
			JLabel engineL = new JLabel("Engine Volume");
			JLabel speedL = new JLabel("Max Speed");
			JLabel classificationL = new JLabel("Class");
			JTextField engineF = new JTextField();
			JTextField speedF = new JTextField();
			JComboBox classificationBox = new JComboBox(possibleClassifications);
			panel.add(engineL);
			panel.add(speedL);
			panel.add(classificationL);
			panel.add(engineF);
			panel.add(speedF);
			panel.add(classificationBox);
			vehicle.remove(actionB);
			add(vehicle);
			add(panel);
			actionB = new JButton("Register");
			actionB.setAlignmentX(CENTER_ALIGNMENT);
			actionB.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String name;
					Double price;
					int volume, speed;
					String classification;
					try {

						price = Double.parseDouble(priceCF.getText());
						name = nameCF.getText();
						speed = Integer.parseInt(speedF.getText());
						volume = Integer.parseInt(engineF.getText());
						classification = classificationBox.getSelectedItem().toString();
						supplierList.get(suppBox.getSelectedIndex()).supplyCar(
								new SportsBike(vehicleList.size() + 2, name, price, volume, speed, classification));
						JOptionPane.showMessageDialog(getContentPane(), "Bike added");
					} catch (Exception exc) {
						exc.printStackTrace();
						JOptionPane.showMessageDialog(getContentPane(), "Incorrect input data.");

					}
				}
			});
			add(actionB);

		}
	}

	class VehicleBought extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1436662458156782238L;

		public VehicleBought() {
			dataInit();
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			final String CAR = "Car";
			final String SCAR = "Sports car";
			final String SBIKE = "Sports bike";
			JPanel cards = new JPanel(new CardLayout());
			JPanel card1 = new BaseCar();
			JPanel card2 = new SportsCarPanel();
			JPanel card3 = new BaseSportsBike();
			cards.add(card1, CAR);
			cards.add(card2, SCAR);
			cards.add(card3, SBIKE);

			JPanel comboBoxPane = new JPanel(); // use FlowLayout
			String comboBoxItems[] = { "Car", "Sports car", "Sports bike" };
			String suppliers[] = new String[supplierList.size()];
			for (int i = 0; i < suppliers.length; i++)
				suppliers[i] = supplierList.get(i).getName() + " " + supplierList.get(i).getSurname();
			JComboBox cb = new JComboBox(comboBoxItems);
			suppBox = new JComboBox(suppliers);
			suppBox.setEditable(false);
			cb.setEditable(false);
			cb.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					CardLayout cl = (CardLayout) (cards.getLayout());
					cl.show(cards, (String) e.getItem());
				}

			});
			comboBoxPane.add(cb);
			comboBoxPane.add(suppBox);

			add(comboBoxPane, BorderLayout.PAGE_START);
			add(cards, BorderLayout.CENTER);

		}
	}

	class CarSold extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4791224124125206360L;

		public CarSold() {
			dataInit();
			String[] carList = new String[vehicleList.size()];
			for (int i = 0; i < carList.length; i++) {
				carList[i] = vehicleList.get(i).getName() + " " + vehicleList.get(i).getPrice();
			}
			setLayout(new GridLayout(2, 1));
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
					salepersonList.get(salespersonBox.getSelectedIndex())
							.sellVehicle(vehicleList.get(carBox.getSelectedIndex()));
					dataInit();
					JOptionPane.showMessageDialog(getContentPane(), "Car sold");
					carBox.removeItem(carBox.getSelectedItem());
					if(carBox.getItemCount()<1)
						actionB.setEnabled(false);
					repaint();
					revalidate();

				}

			});
			JPanel panel1 = new JPanel();
			panel1.setLayout(new GridLayout(6, 1));
			Label sellerL = new Label("Seller");
			sellerL.setAlignment(Label.CENTER);
			Label vehicleL = new Label("Sold vehicle");
			vehicleL.setAlignment(Label.CENTER);
			panel1.add(new JPanel());
			panel1.add(sellerL);
			panel1.add(salespersonBox);
			panel1.add(vehicleL);
			panel1.add(carBox);
			panel1.add(new JPanel());

			add(panel1);
			JPanel buttonP = new JPanel();
			buttonP.setLayout(new GridLayout(5, 3));
			for (int i = 0; i < 15; i++) {
				if (i == 1)
					buttonP.add(actionB);
				else
					buttonP.add(new JPanel());
			}

			add(buttonP);

		}
	}
}
