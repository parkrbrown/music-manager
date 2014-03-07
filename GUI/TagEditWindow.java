package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

import ProgramControl.MainController;

@SuppressWarnings("serial")
public class TagEditWindow extends JFrame implements ActionListener
{
	private JMenuBar MenuBar;
	private JMenu File, Edit, View, Help;
    private JTextArea CurrentDirectory;
    private JLabel CurDir;
    private JButton Browse, Cancel, Confirm;
    private JCheckBox Artist, Album, Genre;
    private JTextArea TArtist, TAlbum, TGenre;
    
    public TagEditWindow()
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
    	
    	this.Artist = new JCheckBox("Artist");
    	this.Album = new JCheckBox("Album");
    	this.Genre = new JCheckBox("Genre");
    	
    	this.TArtist = new JTextArea();
    	this.TAlbum = new JTextArea();
    	this.TGenre = new JTextArea();
    	
    	this.Cancel = new JButton("Cancel");
    	this.Confirm = new JButton("Confirm");
    	
    	
    	
    	//Adds the Action Listener to each element that requires one
    	this.Browse.addActionListener(this);
    	
    	this.Artist.addActionListener(this);
    	this.Album.addActionListener(this);
    	this.Genre.addActionListener(this);
    	
    	this.Confirm.addActionListener(this);
    	this.Cancel.addActionListener(this);
    	
    	
    	
    	//Sets the location for each element
    	this.CurrentDirectory.setBounds(15, 25, 325, 25);
    	this.Browse.setBounds(350, 25, 90, 25);
    	this.CurDir.setBounds(15, 5, 325, 15);
    	
    	this.Artist.setBounds(15, 75, 65, 35);
    	this.Album.setBounds(15, 125, 65, 35);
    	this.Genre.setBounds(15, 175, 65, 35);
    	
    	this.TArtist.setBounds(85, 82, 150, 20);
    	this.TAlbum.setBounds(85, 132, 150, 20);
    	this.TGenre.setBounds(85, 182, 150, 20);
    	
    	this.Cancel.setBounds(280, 222, 85, 35);
    	this.Confirm.setBounds(370, 222, 85, 35);
    	
    	
    	
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
    	
    	this.add(Artist);
    	this.add(Album);
    	this.add(Genre);
    	
    	this.add(TArtist);
    	this.add(TAlbum);
    	this.add(TGenre);
    	
    	this.add(Cancel);
    	this.add(Confirm);
    	
    	
    	//Sets the window title, size, default for closing & sets it to open in the middle of the screen
		this.setTitle("Tag Edit");
		this.setSize(475, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		else if(e.getSource() == Cancel)
		{
			MainController.TEW.setVisible(false);
			MainController.MainMenu.setEnabled(true);
		}
		
		else if(e.getSource() == Confirm)
		{
			
		}
		
		else if(e.getSource() == Artist)
		{
			//TODO
		}
		
		else if(e.getSource() == Album)
		{
			//TODO
		}
		
		else if(e.getSource() == Genre)
		{
			//TODO
		}
	}
	
	

	public JCheckBox getArtist() {
		return Artist;
	}

	public JCheckBox getAlbum() {
		return Album;
	}

	public JCheckBox getGenre() {
		return Genre;
	}

	public JTextArea getTArtist() {
		return TArtist;
	}

	public JTextArea getTAlbum() {
		return TAlbum;
	}

	public JTextArea getTGenre() {
		return TGenre;
	}

	public void setArtist(JCheckBox artist) {
		Artist = artist;
	}

	public void setAlbum(JCheckBox album) {
		Album = album;
	}

	public void setGenre(JCheckBox genre) {
		Genre = genre;
	}

	public void setTArtist(JTextArea tArtist) {
		TArtist = tArtist;
	}

	public void setTAlbum(JTextArea tAlbum) {
		TAlbum = tAlbum;
	}

	public void setTGenre(JTextArea tGenre) {
		TGenre = tGenre;
	}
}