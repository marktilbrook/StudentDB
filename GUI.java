import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener
{
    private StudentList studentList;

    //component declaration
    private JButton bAddStudent, bRemoveStudent,bPrintStudents, bClearText;
    private JLabel jlblFirstName, jlblLastName, jlblUniversity, jlblSubject;
    private JTextField jtfFirstName, jtfLastName, jtfUniversity, jtfSubject;
    private JTextArea jtaArea;
    private JScrollPane scroller;

    private JPanel buttonPanel,addPanel, outputPanel;

    //constructor
    public GUI(String title) throws HeadlessException
    {
        super(title);


        studentList = new StudentList();

        makeFrame();
        showFrame();
    }

    //this is the functionality for all the buttons
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //todo if its this button do this
        String item = e.getActionCommand();

        if (item.equals("Add Student"))
        {
            //checking if any fields are empty
            if (jtfFirstName.getText().equals(" ") || jtfLastName.getText().equals(" ") || jtfUniversity.getText().equals(" ")
            || jtfSubject.getText().equals(" "))
            {
                jtaArea.setText("ONE OR MORE FIELDS ARE BLANK, TRY AGAIN!");
            }
            else
            {
                //create a new student and add to list
                // 1. Declare a local variable to hold user decision
                int decision = 0;

                // Ask user to confirm customer information
                decision = JOptionPane.showConfirmDialog(null,
                        "Add this customer to list?",
                        "Confirm Customer Information",
                        JOptionPane.YES_NO_OPTION);

                if (decision == JOptionPane.YES_OPTION)
                {
                    studentList.addStudent(new StudentUser(jtfFirstName.getText(), jtfLastName.getText(),
                            jtfUniversity.getText(), jtfSubject.getText()));

                    //report that the student has been added
                    jtaArea.setText("Student: " + jtfFirstName + " " + jtfLastName + "  Added to db!");

                    clearTextFields();
                }
            }
        }
        else if (item.equals("Remove Student"))
        {
            //todo remove student functionality
        }
        else if (item.equals("Print Students"))
        {
            studentList.printAllStudents();
        }
        else if (item.equals("Clear Text"))
        {
            System.out.println("CLEAR TEXT!");
            clearTextFields();
            jtaArea.setText(" ");
        }
    }

    //--------------------------------------------------
    //helper methods follow to set up the GUI
    private void clearTextFields()
    {
        jtfFirstName.setText(" ");
        jtfLastName.setText(" ");
        jtfUniversity.setText(" ");
        jtfSubject.setText(" ");
    }

    private void makeFrame()
    {
        setLayout(new BorderLayout());

        createButtonPanel();
        add(buttonPanel, BorderLayout.WEST);

        createAddPanel();
        add(addPanel, BorderLayout.NORTH);

        createOutputPanel();
        add(outputPanel, BorderLayout.CENTER);


    }

    private void showFrame()
    {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void createButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,0,10,15));
        buttonPanel.setBorder(BorderFactory.createBevelBorder(2));
        createButtons();
        addActionListeners();

        buttonPanel.add(bAddStudent);
        buttonPanel.add(bRemoveStudent);
        buttonPanel.add(bPrintStudents);
        buttonPanel.add(bClearText);
    }

    private void createButtons()
    {
        bAddStudent = new JButton("Add Student");
        bRemoveStudent = new JButton("Remove Student");
        bPrintStudents = new JButton("Print Students");
        bClearText = new JButton("Clear Text");

    }

    private void addActionListeners()
    {
        bAddStudent.addActionListener(this);
        bRemoveStudent.addActionListener(this);
        bPrintStudents.addActionListener(this);
        bClearText.addActionListener(this);
    }

    private void createAddPanel()
    {
        addPanel = new JPanel();
        addPanel.setLayout(new GridLayout(0,4));

        jlblFirstName = new JLabel("First Name: ");
        jlblFirstName.setHorizontalAlignment(JLabel.LEFT);
        jlblLastName = new JLabel("Last Name: ");
        jlblLastName.setHorizontalAlignment(JLabel.LEFT);
        jlblUniversity = new JLabel("University: ");
        jlblUniversity.setHorizontalAlignment(JLabel.LEFT);
        jlblSubject = new JLabel("Subject: ");
        jlblSubject.setHorizontalAlignment(JLabel.LEFT);

        jtfFirstName = new JTextField();
        jtfLastName = new JTextField();
        jtfUniversity = new JTextField();
        jtfSubject = new JTextField();

        addPanel.add(jlblFirstName);
        addPanel.add(jlblLastName);
        addPanel.add(jlblUniversity);
        addPanel.add(jlblSubject);

        addPanel.add(jtfFirstName);
        addPanel.add(jtfLastName);
        addPanel.add(jtfUniversity);
        addPanel.add(jtfSubject);

    }

    private void createOutputPanel()
    {
        outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        jtaArea = new JTextArea(30,30);
        jtaArea.setEditable(false);
        scroller = new JScrollPane(jtaArea);
        outputPanel.add(scroller);
    }
}
