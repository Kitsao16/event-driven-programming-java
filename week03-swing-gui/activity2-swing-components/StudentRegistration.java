import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class StudentRegistration {

    private static final Color NAVY = new Color(28, 48, 77);
    private static final Color ACCENT = new Color(31, 126, 140);
    private static final Color BACKGROUND = new Color(244, 247, 250);
    private static final Color MUTED = new Color(86, 99, 114);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentRegistration::createAndShowWindow);
    }

    private static void createAndShowWindow() {
        JFrame frame = new JFrame("Student Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(createFormPanel(frame));
        frame.setMinimumSize(new Dimension(620, 560));
        frame.pack();
        frame.setSize(Math.max(frame.getWidth(), 620), Math.max(frame.getHeight(), 560));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createFormPanel(JFrame frame) {
        JPanel content = new JPanel(new BorderLayout(0, 18));
        content.setBackground(BACKGROUND);
        content.setBorder(BorderFactory.createEmptyBorder(24, 30, 24, 30));

        JLabel heading = new JLabel("Student Registration", SwingConstants.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 26));
        heading.setForeground(NAVY);
        content.add(heading, BorderLayout.NORTH);

        JPanel fields = new JPanel(new GridBagLayout());
        fields.setOpaque(false);
        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.anchor = GridBagConstraints.NORTHWEST;
        labelConstraints.insets = new Insets(8, 0, 8, 16);

        GridBagConstraints inputConstraints = new GridBagConstraints();
        inputConstraints.gridx = 1;
        inputConstraints.weightx = 1;
        inputConstraints.fill = GridBagConstraints.HORIZONTAL;
        inputConstraints.insets = new Insets(8, 0, 8, 0);

        JTextField nameField = new JTextField(22);
        JTextField admissionField = new JTextField(22);
        JComboBox<String> courseBox = new JComboBox<>(new String[]{
                "Computer Science",
                "Information Technology",
                "Business Information Technology"
        });
        JTextArea informationArea = new JTextArea(5, 22);
        informationArea.setLineWrap(true);
        informationArea.setWrapStyleWord(true);
        informationArea.setEditable(true);
        informationArea.setMargin(new Insets(8, 8, 8, 8));
        JScrollPane informationScrollPane = new JScrollPane(informationArea);
        informationScrollPane.setPreferredSize(new Dimension(300, 112));

        styleTextField(nameField);
        styleTextField(admissionField);
        styleComboBox(courseBox);

        addField(fields, labelConstraints, inputConstraints, 0,
                "Student name:", nameField);
        addField(fields, labelConstraints, inputConstraints, 1,
                "Admission number:", admissionField);
        addField(fields, labelConstraints, inputConstraints, 2,
                "Course:", courseBox);

        JLabel informationLabel = createLabel("Additional information:");
        GridBagConstraints areaLabelConstraints = copy(labelConstraints);
        areaLabelConstraints.gridy = 3;
        fields.add(informationLabel, areaLabelConstraints);
        GridBagConstraints areaConstraints = copy(inputConstraints);
        areaConstraints.gridy = 3;
        areaConstraints.fill = GridBagConstraints.BOTH;
        areaConstraints.weighty = 1;
        fields.add(informationScrollPane, areaConstraints);

        content.add(fields, BorderLayout.CENTER);

        JLabel resultLabel = new JLabel("Enter your details, then select Register.");
        resultLabel.setForeground(MUTED);

        JButton registerButton = createButton("Register", ACCENT);
        registerButton.addActionListener(event -> registerStudent(
                frame, nameField, admissionField, courseBox, resultLabel));

        JPanel actions = new JPanel(new BorderLayout(12, 0));
        actions.setOpaque(false);
        actions.add(resultLabel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(registerButton);
        actions.add(buttonPanel, BorderLayout.EAST);
        content.add(actions, BorderLayout.SOUTH);

        return content;
    }

    private static void registerStudent(JFrame frame, JTextField nameField,
                                        JTextField admissionField,
                                        JComboBox<String> courseBox,
                                        JLabel resultLabel) {
        String name = nameField.getText().trim();
        String admission = admissionField.getText().trim();
        String course = (String) courseBox.getSelectedItem();

        if (name.isEmpty() || admission.isEmpty()) {
            resultLabel.setText("Please fill in the name and admission number.");
            JOptionPane.showMessageDialog(frame,
                    "Student name and admission number are required.",
                    "Incomplete registration", JOptionPane.WARNING_MESSAGE);
            return;
        }

        resultLabel.setText("Registration successful.");
        JOptionPane.showMessageDialog(frame,
                "Name: " + name + "\nAdmission: " + admission
                        + "\nCourse: " + course,
                "Registration details", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void addField(JPanel panel, GridBagConstraints labelConstraints,
                                 GridBagConstraints inputConstraints, int row,
                                 String labelText, java.awt.Component input) {
        GridBagConstraints currentLabel = copy(labelConstraints);
        currentLabel.gridy = row;
        panel.add(createLabel(labelText), currentLabel);
        GridBagConstraints currentInput = copy(inputConstraints);
        currentInput.gridy = row;
        panel.add(input, currentInput);
    }

    private static GridBagConstraints copy(GridBagConstraints constraints) {
        return (GridBagConstraints) constraints.clone();
    }

    private static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setForeground(NAVY);
        return label;
    }

    private static void styleTextField(JTextField field) {
        field.setFont(new Font("SansSerif", Font.PLAIN, 14));
        field.setPreferredSize(new Dimension(300, 34));
        field.setMargin(new Insets(5, 8, 5, 8));
    }

    private static void styleComboBox(JComboBox<String> comboBox) {
        comboBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        comboBox.setPreferredSize(new Dimension(300, 34));
    }

    private static JButton createButton(String text, Color background) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(background);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(9, 20, 9, 20));
        return button;
    }
}
