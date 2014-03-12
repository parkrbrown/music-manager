package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

import ProgramControl.MainController;

@SuppressWarnings("serial")
public class MainMenu extends JFrame implements ActionListener {

    private JMenuBar MenuBar;
    private JMenu File, Edit, View, Help;
    private JTextArea CurrentDirectory;
    private JLabel CurDir;
    private JButton Browse, Format, EditTags, Organize, Quit;

    public MainMenu() {
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

        this.Format = new JButton("<html><center>Format MP3 FileNames</center></html>");
        this.EditTags = new JButton("<html><center>Edit ID3 Tags</center></html>");
        this.Organize = new JButton("<html><center>Organize Music Collection</center></html>");
        this.Quit = new JButton("Quit");

        //Adds the Action Listener to each element that requires one
        this.Browse.addActionListener(this);
        this.Format.addActionListener(this);
        this.EditTags.addActionListener(this);
        this.Organize.addActionListener(this);
        this.Quit.addActionListener(this);

        //Sets the location for each element
        this.CurrentDirectory.setBounds(15, 25, 325, 18);
        this.Browse.setBounds(350, 20, 90, 25);
        this.CurDir.setBounds(15, 5, 325, 15);

        this.Format.setBounds(15, 75, 150, 75);
        this.EditTags.setBounds(15, 175, 150, 75);
        this.Organize.setBounds(200, 75, 150, 75);
        this.Quit.setBounds(200, 175, 150, 75);

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

        this.add(Format);
        this.add(EditTags);
        this.add(Organize);
        this.add(Quit);

        //Sets the window title, size, default for closing & sets it to open in the middle of the screen
        this.setTitle("MainMenu");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Browse) {
            int Location = MainController.FileChooser.showOpenDialog(MainController.ReferenceFrame);
            if (Location == JFileChooser.APPROVE_OPTION) {
                MainController.CurrentDirectory = MainController.FileChooser.getSelectedFile();
            }

            this.CurrentDirectory.setText(MainController.CurrentDirectory.toString());
        } else if (e.getSource() == Format) {
            MainController.MainMenu.setEnabled(false);
            MainController.FFSW = new FileFormatSelectionWindow();
            MainController.FFSW.setVisible(true);
        } else if (e.getSource() == EditTags) {
            MainController.MainMenu.setEnabled(false);
            MainController.TEW = new TagEditWindow();
            MainController.TEW.setVisible(true);
        } else if (e.getSource() == Organize) {
            MainController.MainMenu.setEnabled(false);
            MainController.OSSW = new OrganizationStyleSelectionWindow();
            MainController.OSSW.setVisible(true);
        } else if (e.getSource() == Quit) {
            System.exit(0);
        }
    }
}
