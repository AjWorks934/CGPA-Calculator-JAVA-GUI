import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GPAApp1 {

    private JFrame frame;
    private JTextField numSubjectsField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public GPAApp1() {
        frame = new JFrame("GPA Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        createUI();

        frame.setVisible(true);
    }

    private void createUI() {
        JLabel numSubjectsLabel = new JLabel("Enter the number of subjects:");
        frame.add(numSubjectsLabel);

        numSubjectsField = new JTextField(5);
        frame.add(numSubjectsField);

        calculateButton = new JButton("Calculate GPA");
        frame.add(calculateButton);

        resultLabel = new JLabel();
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGPA();
            }
        });
    }

    private void calculateGPA() {
        try {
            int numSubjects = Integer.parseInt(numSubjectsField.getText());

            if (numSubjects <= 0) {
                showError("Number of subjects must be greater than 0.");
                return;
            }

            double totalCredits = 0.0;
            double totalGradePoints = 0.0;

            for (int i = 1; i <= numSubjects; i++) {
                int credits = getInput1("Enter credits for subject " + i + ":", "Invalid credits input");
                if (credits < 0) {
                    return; // Exit if input is invalid
                }
                totalCredits += credits;

                double gradePoint = getInput("Enter grade out of 10 for subject " + i + ":", "Invalid score input");
                if (gradePoint < 0 || gradePoint > 10) {
                    showError("Grade must be between 0 and 10.");
                    return;
                }
                totalGradePoints += gradePoint * credits;
            }

            int numPrevSemesters = getInput1("Enter the number of previous semesters:", "Invalid input for semesters");
            if (numPrevSemesters < 0 || numPrevSemesters > 10) {
                return; // Exit if input is invalid
            }

            int totalPrevCredits = 0;
            double totalPrevGradePoints = 0.0;

            for (int i = 1; i <= numPrevSemesters; i++) {
                double sgpa = getInput("Enter SGPA for previous semester " + i + ":", "Invalid SGPA input");
                if (sgpa < 0 || sgpa > 10) {
                    showError("SGPA must be between 0 and 10.");
                    return;
                }

                int prevCredits = getInput1("Enter total credits for previous semester " + i + ":", "Invalid credits input");
                if (prevCredits < 0) {
                    return; // Exit if input is invalid
                }
                totalPrevCredits += prevCredits;

                totalPrevGradePoints += sgpa * prevCredits;
            }

            double cgpa = (totalGradePoints + totalPrevGradePoints) / (totalCredits + totalPrevCredits);

            resultLabel.setText("Your GPA is: " + cgpa);

            int option = JOptionPane.showConfirmDialog(frame, "Do you want to calculate GPA again?", "Calculate GPA",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                resetInputs();
            } else {
                showExit("Thank you for using the GPA Calculator");
                System.exit(0);
            }

        } catch (NumberFormatException ex) {
            showError("Invalid input. Please enter numeric values.");
        }
    }

    private double getInput(String message, String errorMessage) {
        try {
            return Double.parseDouble(JOptionPane.showInputDialog(message));
        } catch (NumberFormatException e) {
            showError(errorMessage);
            return -1;
        }
    }
    private int getInput1(String message, String errorMessage) {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(message));
        } catch (NumberFormatException e) {
            showError(errorMessage);
            return -1;
        }
    }

    private void resetInputs() {
        numSubjectsField.setText("");
        resultLabel.setText("");
    }

    private void showError(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
    private void showExit(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Exit", JOptionPane.PLAIN_MESSAGE);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GPAApp1::new);
    }
}
