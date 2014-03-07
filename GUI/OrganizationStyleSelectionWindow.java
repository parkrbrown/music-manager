package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ProgramControl.MainController;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class OrganizationStyleSelectionWindow extends JFrame implements ActionListener
{
	private JMenuBar MenuBar;
	private JMenu File, Edit, View, Help;
    private JTextArea CurrentDirectory;
    private JLabel CurDir;
    private JButton Browse, Add, Remove, Up, Down, Return;
    private JList Order, Exclude;
    private String OrderSelectedItem, ExcludeSelectedItem;
    
    public OrganizationStyleSelectionWindow()
    {
    	this.setLayout(null);
    	
    	
    	//Declares each element needed for the Main Menu
    	this.MenuBar = new JMenuBar();
    	this.File = new JMenu("File");
    	this.Edit = new JMenu("Edit");
    	this.View = new JMenu("View");
    	this.Help = new JMenu("Help");
    	
    	this.CurrentDirectory = new JTextArea(MainController.CurrentDirectory.toString());
    	this.Browse = new JButton("Change...");
    	this.CurDir = new JLabel("Current Directory:");
    	
    	this.Add = new JButton("Add");
    	this.Remove = new JButton("Remove");
    	this.Up = new JButton("Move Up");
    	this.Down = new JButton("Move Down");
    	
    	this.Return = new JButton("<html><center>Return To Main Menu</center></html>");
    	
    	
    	//TODO Add options
    	String[] Options = {/*TODO Tester*/"Hi", "Bye", "Guten Tag", "Bis Dann", "Wie Heist Du?", "So la-la", "Auf Wiedershen!"};
    	this.Order = new JList();
    	this.Exclude = new JList(Options);
    	
    	
    	
    	//Adds the Action Listener to each element that requires one
    	this.Browse.addActionListener(this);
    	this.Add.addActionListener(this);
    	this.Remove.addActionListener(this);
    	this.Up.addActionListener(this);
    	this.Down.addActionListener(this);
    	
    	this.Return.addActionListener(this);
    	
    	
    	
    	//Adds the List Listener to each list
    	this.Order.addListSelectionListener(new ListSelectionListener()
    	{
    		@Override
    		public void valueChanged(ListSelectionEvent e)
    		{
    			if(!e.getValueIsAdjusting())
    			{
    				OrderSelectedItem = (String)Order.getSelectedValue();
    			}
    		}
    	});
    	
    	this.Exclude.addListSelectionListener(new ListSelectionListener()
    	{
    		@Override
    		public void valueChanged(ListSelectionEvent e)
    		{
    			if(!e.getValueIsAdjusting())
    			{
    				ExcludeSelectedItem = (String)Order.getSelectedValue();
    			}
    		}
    	});
    	
    	
    	
    	//Sets the location for each element
    	this.CurrentDirectory.setBounds(15, 25, 520, 25);
    	this.Browse.setBounds(550, 25, 90, 25);
    	this.CurDir.setBounds(15, 5, 325, 15);
    	
    	this.Order.setBounds(15, 65, 250, 225);
    	this.Exclude.setBounds(385, 65, 250, 225);
    	
    	this.Add.setBounds(275, 65, 100, 40);
    	this.Remove.setBounds(275, 115, 100, 40);
    	this.Up.setBounds(275, 165, 100, 40);
    	this.Down.setBounds(275, 215, 100, 40);
    	
    	this.Return.setBounds(275, 295, 100, 65);
    	
    	
    	
    	//Adds each Menu Bar element to the Menu Bar
    	this.MenuBar.add(this.File);
    	this.MenuBar.add(this.Edit);
    	this.MenuBar.add(this.View);
    	this.MenuBar.add(this.Help);
    	
    	
    	//Adds each element to the Window
    	this.add(MenuBar);
    	
    	this.add(CurrentDirectory);
    	this.add(Browse);
    	this.add(CurDir);
    	
    	this.add(Order);
    	this.add(Exclude);
    	
    	this.add(Add);
    	this.add(Remove);
    	this.add(Up);
    	this.add(Down);
    	
    	this.add(Return);
    	
    	
    	
    	//Sets the window title, size, default for closing & sets it to open in the middle of the screen
		this.setTitle("Organization Style Selection");
		this.setSize(665, 400);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
    }

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == Browse)
		{
			int SaveResponse = MainController.FileChooser.showSaveDialog(MainController.ReferenceFrame);
			if(SaveResponse == JFileChooser.APPROVE_OPTION)
			{
				MainController.CurrentDirectory = MainController.FileChooser.getSelectedFile();
			}
			
			this.CurDir.setText(MainController.CurrentDirectory.toString());
		}
		
		else if(e.getSource() == Add)
		{
			//TODO
		}
		
		else if(e.getSource() == Remove)
		{
			//TODO
		}
		
		else if(e.getSource() == Up)
		{
			//TODO
		}
		
		else if(e.getSource() == Down)
		{
			//TODO
		}
		
		else if(e.getSource() == Return)
		{
			MainController.OSSW.setVisible(false);
			MainController.MainMenu.setEnabled(true);
		}
	}
	
	
	
	public ArrayList<String> getOrganizationOrder()
	{
		ArrayList<String> ItemsInOrder = new ArrayList<String>();
		int i = 0;
		while(((String.valueOf(Order.getComponent(i)) != null) || ((String.valueOf(Order.getComponent(i)) != ""))))
		{
			ItemsInOrder.add(String.valueOf(Order.getComponent(i)));
			i++;
		}
		return ItemsInOrder;
	}
}