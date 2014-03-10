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
public class FileFormatSelectionWindow extends JFrame implements ActionListener
{
	private JMenuBar MenuBar;
	private JMenu File, Edit, View, Help;
    private JTextArea CurrentDirectory;
    private JLabel CurDir;
    private JButton Browse, Add, Remove, Up, Down, Return;
    private JList Sort, Ignore;
    private String SortSelectedItem, IgnoreSelectedItem;
    
    //TODO Make a done button; require JCheck title to always be selected
    //TODO Make an example string of how the file format will look once the user has selected their preferences. i.e. "Sample Output: 'album-artist-song title.mp3'"
    
    public FileFormatSelectionWindow()
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
    	String[] Options = {/*TODO Tester*/"Album", "Artist", "Genre", "Year", "Song Title"};
    	this.Sort = new JList();
    	this.Ignore = new JList(Options);
    	
    	
    	
    	//Adds the Action Listener to each element that requires one
    	this.Browse.addActionListener(this);
    	this.Add.addActionListener(this);
    	this.Remove.addActionListener(this);
    	this.Up.addActionListener(this);
    	this.Down.addActionListener(this);
    	
    	this.Return.addActionListener(this);
    	
    	
    	
    	//Adds the List Listener to each list
    	this.Sort.addListSelectionListener(new ListSelectionListener()
    	{
    		@Override
    		public void valueChanged(ListSelectionEvent e)
    		{
    			if(!e.getValueIsAdjusting())
    			{
    				SortSelectedItem = (String)Sort.getSelectedValue();
    			}
    		}
    	});
    	
    	this.Ignore.addListSelectionListener(new ListSelectionListener()
    	{
    		@Override
    		public void valueChanged(ListSelectionEvent e)
    		{
    			if(!e.getValueIsAdjusting())
    			{
    				IgnoreSelectedItem = (String)Ignore.getSelectedValue();
    			}
    		}
    	});
    	
    	
    	
    	//Sets the location for each element
    	this.CurrentDirectory.setBounds(15, 25, 520, 25);
    	this.Browse.setBounds(550, 25, 90, 25);
    	this.CurDir.setBounds(15, 5, 325, 15);
    	
    	this.Sort.setBounds(15, 65, 250, 225);
    	this.Ignore.setBounds(385, 65, 250, 225);
    	
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
    	
    	this.add(Sort);
    	this.add(Ignore);
    	
    	this.add(Add);
    	this.add(Remove);
    	this.add(Up);
    	this.add(Down);
    	
    	this.add(Return);
    	
    	
    	
    	//Sets the window title, size, default for closing & sets it to open in the middle of the screen
		this.setTitle("File Format Selection");
		this.setSize(665, 400);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
    }

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == Browse)
		{
			int Location = MainController.FileChooser.showOpenDialog(MainController.ReferenceFrame);
			if(Location == JFileChooser.APPROVE_OPTION)
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
			MainController.FFSW.setVisible(false);
			MainController.MainMenu.setEnabled(true);
		}
	}
	
	
	public ArrayList<String> getFormatOrder()
	{
		ArrayList<String> ItemsInOrder = new ArrayList<String>();
		int i = 0;
		while(((String.valueOf(Sort.getComponent(i)) != null) || ((String.valueOf(Sort.getComponent(i)) != ""))))
		{
			ItemsInOrder.add(String.valueOf(Sort.getComponent(i)));
			i++;
		}
		return ItemsInOrder;
	}
}