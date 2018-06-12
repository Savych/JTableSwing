import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
	private JTable table;
	private PersonModel model;
	
	public MainWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(640, 480);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 446, 429);
		getContentPane().add(scrollPane);
		
		model = new PersonModel();
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person person = new Person();
				person.setName(JOptionPane.showInputDialog("Введите имя: "));
				person.setSurname(JOptionPane.showInputDialog("Введите фамилию: "));
				Main.persons.add(person);
				table.updateUI();
			}
		});
		btnAdd.setBounds(506, 11, 89, 23);
		getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1 || Main.persons.size() == 0) { return;}
				Main.persons.remove(table.getSelectedRow());
				table.updateUI();
			}
		});
		btnRemove.setBounds(506, 45, 89, 23);
		getContentPane().add(btnRemove);
	}
}
