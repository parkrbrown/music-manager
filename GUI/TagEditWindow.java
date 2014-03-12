package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import mp3agic.ID3v1Tag;
import ProgramControl.MainController;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class TagEditWindow extends JFrame implements ActionListener {

    private JMenuBar MenuBar;
    private JMenu File, Edit, View, Help;
    private JTextArea CurrentDirectory;
    private JLabel CurDir;
    private JButton Browse, Cancel, Confirm;
    private JCheckBox Artist, Album, Genre;
    private JTextArea TArtist, TAlbum;  //TGenre replaced by GenreSelection
    private JComboBox GenreSelection;
    private int SelectedGenre;

    public TagEditWindow() {
        this.setLayout(null);

        //Declares each element needed for the Main Menu
        this.MenuBar = new JMenuBar();
        this.File = new JMenu("File");
        this.Edit = new JMenu("Edit");
        this.View = new JMenu("View");
        this.Help = new JMenu("Help");

        this.CurrentDirectory = new JTextArea(MainController.CurrentDirectory.toString());
        this.CurrentDirectory.setEditable(false);
        this.Browse = new JButton("Change...");
        this.CurDir = new JLabel("Current Directory:");

        this.Artist = new JCheckBox("Artist");
        this.Album = new JCheckBox("Album");
        this.Genre = new JCheckBox("Genre");

        this.TArtist = new JTextArea();
        TArtist.setEditable(false);
        this.TAlbum = new JTextArea();
        TAlbum.setEditable(false);
        this.GenreSelection = new JComboBox(mp3agic.ID3v1Genres.GENRES);
        GenreSelection.setEditable(false);

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
        this.CurrentDirectory.setBounds(15, 25, 325, 18);
        this.Browse.setBounds(350, 20, 90, 25);
        this.CurDir.setBounds(15, 5, 325, 15);

        this.Artist.setBounds(15, 75, 65, 35);
        this.Album.setBounds(15, 125, 65, 35);
        this.Genre.setBounds(15, 175, 65, 35);

        this.TArtist.setBounds(85, 82, 150, 20);
        this.TAlbum.setBounds(85, 132, 150, 20);
        this.GenreSelection.setBounds(85, 182, 150, 20);

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
        this.add(GenreSelection);

        this.add(Cancel);
        this.add(Confirm);

        //Sets the window title, size, default for closing & sets it to open in the middle of the screen
        this.setTitle("Tag Edit");
        this.setSize(475, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox GenreSelection = (JComboBox) e.getSource();
            SelectedGenre = GenreSelection.getSelectedIndex();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Browse) {
            int Location = MainController.FileChooser.showOpenDialog(MainController.ReferenceFrame);
            if (Location == JFileChooser.APPROVE_OPTION) {
                MainController.CurrentDirectory = MainController.FileChooser.getSelectedFile();
            }

            this.CurrentDirectory.setText(MainController.CurrentDirectory.toString());
        } else if (e.getSource() == Cancel) {
            MainController.TEW.setVisible(false);
            MainController.MainMenu.setEnabled(true);
        } else if (e.getSource() == Confirm) {
            if (Artist.isSelected() && Artist.getText() == null) {
                int UserChoice = JOptionPane.showConfirmDialog(MainController.ReferenceFrame, "You left the Artist Tag selected and blank;\nthis will erase the Artist tag for all selected files!\nAre you sure you want to do this?");
//                if(UserChoice)
            } else if (Album.isSelected() && Album.getText() == null) {
                //TODO Prompt user to fill in or de-select fields
            } else {
                MainController.TE.updateTags();
                //TODO Set main menu visible and hide this menu??
            }

        } else if (e.getSource() == Artist) {
            if (TArtist.isEditable()) {
                TArtist.setEditable(false);
            } else {
                TArtist.setEditable(true);
            }
        } else if (e.getSource() == Album) {
            if (TAlbum.isEditable()) {
                TAlbum.setEditable(false);
            } else {
                TAlbum.setEditable(true);
            }
        } else if (e.getSource() == Genre) {
            if (GenreSelection.isEditable()) {
                GenreSelection.setEditable(false);
            } else {
                GenreSelection.setEditable(true);
            }
        }
    }

    public boolean isArtistSelected() {
        if (Artist.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlbumSelected() {
        if (Album.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGenreSelected() {
        if (Genre.isSelected()) {
            return true;
        } else {
            return false;
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

    public String getTArtist() {
        return TArtist.getText();
    }

    public String getTAlbum() {
        return TAlbum.getText();
    }

    public int getSelectedGenre() {
        return SelectedGenre;
    }
}
