package ProgramControl;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import GUI.FileFormatSelectionWindow;
import GUI.MainMenu;
import GUI.OrganizationStyleSelectionWindow;
import GUI.TagEditWindow;

/**
 * The MainController
 */
public class MainController {

    //File Designation variables for Program
    public static File CurrentDirectory = new File("Libraries\\Music");
    public static JFileChooser FileChooser = new JFileChooser();
    /*TODO Probably need a different class for limiting files*/
    public static FileNameExtensionFilter FileFilter = new FileNameExtensionFilter("MP3 Music Files", "mp3");

    //GUI Windows for Program
    public static MainMenu MainMenu = new MainMenu();
    public static OrganizationStyleSelectionWindow OSSW = new OrganizationStyleSelectionWindow();
    public static FileFormatSelectionWindow FFSW = new FileFormatSelectionWindow();
    public static TagEditWindow TEW = new TagEditWindow();
    public static JFrame ReferenceFrame = new JFrame();

    //File Controllers for Program
    public static FileController FileController = new FileController();
    public static FilenameFormatter FNF = new FilenameFormatter();
    public static FileOrganizer FO = new FileOrganizer();
    public static TagEditor TE = new TagEditor();

    public static void main(String[] args) {
        FileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        MainMenu.setVisible(true);
    }
}
