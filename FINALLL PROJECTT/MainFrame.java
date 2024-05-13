package a9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.File;


public class MainFrame extends JFrame {
    private JTextField txtName, txtDate, txtDuration, txtDistance, txtWeight, txtHeight, txtReps;
    private JComboBox<String> exerciseTypeDropdown;
    private JTextArea displayArea;
    private JButton btnAddExercise, btnSave;
    private ArrayList<Exercise> exercises = new ArrayList<>();
    private JMenuItem loginItem, logoutItem, saveItem, aboutItem, exitItem;


    public MainFrame() {
        createUI();
        setupActions();
        setFieldsEnabled(false); 
        loginItem.setEnabled(true);
        logoutItem.setEnabled(false);
        saveItem.setEnabled(false);
       
    }


    private void createUI() {
        setTitle("Exercise Tracker");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Menu setup
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");

        loginItem = new JMenuItem("Log in");
        logoutItem = new JMenuItem("Log out");
        logoutItem.setEnabled(false); //difficult but I got it
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit"); // runs good now 

        fileMenu.add(loginItem);
        fileMenu.add(logoutItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        JMenu helpMenu = new JMenu("Help");
        aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);
        menuBar.add(helpMenu);     
        // (0,2,5,5) works now
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        exerciseTypeDropdown = new JComboBox<>(new String[]{"Run/Walk", "Weightlifting", "Rock Climbing"});
        txtName = new JTextField();
        txtDate = new JTextField();
        txtDuration = new JTextField();
        txtDistance = new JTextField();
        txtWeight = new JTextField();
        txtHeight = new JTextField();
        txtReps = new JTextField();
        btnAddExercise = new JButton("Add Exercise");
        btnSave = new JButton("Save");
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);

        // Add components
        inputPanel.add(new JLabel("Exercise Type:"));
        inputPanel.add(exerciseTypeDropdown);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(txtName);
        inputPanel.add(new JLabel("Date (MM/DD/YYYY):"));
        inputPanel.add(txtDate);
        inputPanel.add(new JLabel("Duration (minutes):"));
        inputPanel.add(txtDuration);
        inputPanel.add(new JLabel("Distance (miles):"));
        inputPanel.add(txtDistance);
        inputPanel.add(new JLabel("Weight Lifted (lbs):"));
        inputPanel.add(txtWeight);
        inputPanel.add(new JLabel("Wall Height (ft):"));
        inputPanel.add(txtHeight);
        inputPanel.add(new JLabel("Repetitions:"));
        inputPanel.add(txtReps);
        inputPanel.add(btnAddExercise);
        inputPanel.add(btnSave);

        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(displayArea), BorderLayout.CENTER);
        
        // instantiated before this call
        setFieldsEnabled(false);  // disabled until login

        // Now you should safely call updateFieldVisibility
        updateFieldVisibility();
    }
    private void showAboutDialog() {
        String aboutText = "Exercise Tracker \n" +
                           "Developed by: Kevin Bellman\n" +
                           "This application allows users to track different types of exercises such as running, weightlifting, and rock climbing.";
        JOptionPane.showMessageDialog(this, aboutText, "About Exercise Tracker", JOptionPane.INFORMATION_MESSAGE);
    }


    private void setupActions() {
        btnAddExercise.addActionListener(e -> addExercise());
        btnSave.addActionListener(e -> saveExercises());
        saveItem.addActionListener(e -> saveExercises());
        loginItem.addActionListener(e -> showLoginDialog());
        logoutItem.addActionListener(e -> {
            setFieldsEnabled(false);
            loginItem.setEnabled(true);
            logoutItem.setEnabled(false);
            saveItem.setEnabled(false);
            displayArea.setText(""); // clear
        });


        exitItem.addActionListener(e -> System.exit(0)); // closes the application

        exerciseTypeDropdown.addActionListener(e -> updateFieldVisibility());
        aboutItem.addActionListener(e -> showAboutDialog());
    }


    private void updateFieldVisibility() {
        String selectedType = (String) exerciseTypeDropdown.getSelectedItem();
        switch (selectedType) {
            case "Run/Walk":
                txtDistance.setEnabled(true);
                txtWeight.setEnabled(false);
                txtHeight.setEnabled(false);
                txtReps.setEnabled(false);
                break;
            case "Weightlifting":
                txtDistance.setEnabled(false);
                txtWeight.setEnabled(true);
                txtHeight.setEnabled(false);
                txtReps.setEnabled(false);
                break;
            case "Rock Climbing":
                txtDistance.setEnabled(false);
                txtWeight.setEnabled(false);
                txtHeight.setEnabled(true);
                txtReps.setEnabled(true);
                break;
        }
        //regardless of selection enable 
        txtName.setEnabled(true);
        txtDate.setEnabled(true);
        txtDuration.setEnabled(true);
        btnAddExercise.setEnabled(true);
        btnSave.setEnabled(true);
    }


    private void setFieldsEnabled(boolean enabled) {
        // Disable all fields initially
        txtName.setEnabled(false);
        txtDate.setEnabled(false);
        txtDuration.setEnabled(false);
        txtDistance.setEnabled(false);
        txtWeight.setEnabled(false);
        txtHeight.setEnabled(false);
        txtReps.setEnabled(false);
        btnAddExercise.setEnabled(false);
        btnSave.setEnabled(false);

        // dropdown if  enabledis true
        exerciseTypeDropdown.setEnabled(enabled);

        // Menu items for the programm
        logoutItem.setEnabled(enabled);
        loginItem.setEnabled(!enabled);
        saveItem.setEnabled(enabled);

        if (enabled) {
            // this was diffuclt but i got it
            exerciseTypeDropdown.addActionListener(e -> updateFieldVisibility());
        }
    }




    private void addExercise() {
        try {
            String type = (String) exerciseTypeDropdown.getSelectedItem();
            String name = txtName.getText().trim();
            String date = txtDate.getText().trim();
            int duration = validateIntInput(txtDuration.getText(), "Duration");

            Exercise exercise = null;
            switch (type) {
                case "Run/Walk":
                    double distance = validateDoubleInput(txtDistance.getText(), "Distance");
                    exercise = new RunWalk(name, date, duration, distance);
                    break;
                case "Weightlifting":
                    double weight = validateDoubleInput(txtWeight.getText(), "Weight");
                    exercise = new WeightLifting(name, date, duration, weight);
                    break;
                case "Rock Climbing":
                    double height = validateDoubleInput(txtHeight.getText(), "Height");
                    int reps = validateIntInput(txtReps.getText(), "Repetitions");
                    exercise = new RockClimbing(name, date, duration, height, reps);
                    break;
            }

            exercises.add(exercise);
            displayArea.append(exercise.toStringCustomInfo() + "\n");  // Got it
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private int validateIntInput(String input, String fieldName) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid integer for " + fieldName + ".");
        }
    }

    private double validateDoubleInput(String input, String fieldName) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
        try {
            return Double.parseDouble(input.trim());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid number for " + fieldName + ".");
        }
    }


    private void saveExercises() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Exercises");
        fileChooser.setApproveButtonText("Save");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // Start directory 

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                // method that takes a file path as String
                if (ExerciseWriter.writeToFile(fileToSave.getPath(), exercises)) {
                    JOptionPane.showMessageDialog(this, "Exercises saved successfully to " + fileToSave.getPath(), "Save Successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to save exercises.", "Save Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error saving exercises: " + ex.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private void showLoginDialog() {
        LoginFrame login = LoginFrame.getInstance(this);
        login.setVisible(true);
        login.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (login.isLoggedIn()) {
                    setFieldsEnabled(true);
                    loginItem.setEnabled(false);
                    logoutItem.setEnabled(true);
                    saveItem.setEnabled(true);
                } else {
                    System.exit(0);  
                }
            }
        });
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
