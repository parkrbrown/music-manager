package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ProgramControl.MainController;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class OrganizationStyleSelectionWindow extends JFrame implements ActionListener {

    private JMenuBar MenuBar;
    private JMenu File, Edit, View, Help;
    private JTextArea CurrentDirectory;
    private JLabel CurDir;
    private JButton Browse, Add, Remove, Up, Down, Return, Go;
    private JList Order, Exclude;
    private ArrayList<String> OrderItems, ExcludeItems;

    public OrganizationStyleSelectionWindow() {
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

        this.Add = new JButton("Add");
        this.Remove = new JButton("Remove");
        this.Up = new JButton("Move Up");
        this.Down = new JButton("Move Down");

        this.Return = new JButton("<html><center>Return To Main Menu</center></html>");
        this.Go = new JButton("<html><center>Organize MP3s</center></htm>");

        String[] Options = {/*TODO Tester*/"Album", "Artist", "Genre", "Year"};
        this.Order = new JList();
        this.Exclude = new JList(Options);

        this.ExcludeItems = new ArrayList<>();
        this.OrderItems = new ArrayList<>();
        this.ExcludeItems.add("Album");
        this.ExcludeItems.add("Artist");
        this.ExcludeItems.add("Genre");
        this.ExcludeItems.add("Year");

        this.Order = new JList(OrderItems.toArray());
        this.Exclude = new JList(ExcludeItems.toArray());

        //Adds the Action Listener to each element that requires one
        this.Browse.addActionListener(this);
        this.Add.addActionListener(this);
        this.Remove.addActionListener(this);
        this.Up.addActionListener(this);
        this.Down.addActionListener(this);

        this.Return.addActionListener(this);
        this.Go.addActionListener(this);

        //Adds the List Listener to each list
        this.Order.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
//    				OrderSelectedItem = Order.getSelectedIndex();
                }
            }
        });

        this.Exclude.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
//    				ExcludeSelectedItem = Exclude.getSelectedIndex();
                }
            }
        });

        //Sets the location for each element
        this.CurrentDirectory.setBounds(15, 25, 520, 18);
        this.Browse.setBounds(550, 20, 90, 25);
        this.CurDir.setBounds(15, 5, 325, 15);

        this.Order.setBounds(15, 65, 250, 225);
        this.Exclude.setBounds(385, 65, 250, 225);

        this.Add.setBounds(275, 65, 100, 40);
        this.Remove.setBounds(275, 115, 100, 40);
        this.Up.setBounds(275, 165, 100, 40);
        this.Down.setBounds(275, 215, 100, 40);

        this.Return.setBounds(425, 295, 100, 60);
        this.Go.setBounds(535, 295, 100, 60);

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
        this.add(Go);

        //Sets the window title, size, default for closing & sets it to open in the middle of the screen
        this.setTitle("Organization Style Selection");
        this.setSize(665, 400);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public ArrayList<String> getOrganizationOrder() {
        ArrayList<String> ItemsInOrder = new ArrayList<String>();
        ListModel Temp = Order.getModel();
		for(int j = 0; j < Temp.getSize(); j++)
		{
			ItemsInOrder.add((String) Temp.getElementAt(j));
		}
		return ItemsInOrder;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Browse) {
            int Location = MainController.FileChooser.showOpenDialog(MainController.ReferenceFrame);
            if (Location == JFileChooser.APPROVE_OPTION) {
                MainController.CurrentDirectory = MainController.FileChooser.getSelectedFile();
            }

            this.CurrentDirectory.setText(MainController.CurrentDirectory.toString());
        } else if (e.getSource() == Add) {
            OrderItems.add((String) Exclude.getSelectedValue());
            ExcludeItems.remove(Exclude.getSelectedIndex());

            this.remove(Order);
            this.remove(Exclude);

            this.Order = new JList(OrderItems.toArray());
            this.Exclude = new JList(ExcludeItems.toArray());

            this.Order.setBounds(15, 65, 250, 225);
            this.Exclude.setBounds(385, 65, 250, 225);
            this.add(Order);
            this.add(Exclude);

            MainController.OSSW.setVisible(false);
            MainController.OSSW.setVisible(true);
        } else if (e.getSource() == Remove) {
            ExcludeItems.add((String) Order.getSelectedValue());
            OrderItems.remove(Order.getSelectedIndex());

            this.remove(Order);
            this.remove(Exclude);

            this.Order = new JList(OrderItems.toArray());
            this.Exclude = new JList(ExcludeItems.toArray());

            this.Order.setBounds(15, 65, 250, 225);
            this.Exclude.setBounds(385, 65, 250, 225);
            this.add(Order);
            this.add(Exclude);

            MainController.OSSW.setVisible(false);
            MainController.OSSW.setVisible(true);
        } else if (e.getSource() == Up) {
            Collections.swap(OrderItems, Order.getSelectedIndex(), (Order.getSelectedIndex() - 1));

            this.remove(Order);

            this.Order = new JList(OrderItems.toArray());

            this.Order.setBounds(15, 65, 250, 225);
            this.add(Order);

            MainController.OSSW.setVisible(false);
            MainController.OSSW.setVisible(true);
        } else if (e.getSource() == Down) {
            Collections.swap(OrderItems, Order.getSelectedIndex(), (Order.getSelectedIndex() + 1));

            this.remove(Order);

            this.Order = new JList(OrderItems.toArray());

            this.Order.setBounds(15, 65, 250, 225);
            this.add(Order);

            MainController.OSSW.setVisible(false);
            MainController.OSSW.setVisible(true);
        } else if (e.getSource() == Return) {
            MainController.MainMenu.setEnabled(true);
            MainController.OSSW.setVisible(false);
        } else if (e.getSource() == Go) {
            MainController.FO.Organize();
            MainController.MainMenu.setEnabled(true);
            MainController.OSSW.setVisible(false);
        }
    }
}
