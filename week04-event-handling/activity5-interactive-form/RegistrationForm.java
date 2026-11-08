import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serial;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class RegistrationForm extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final Color NAVY = new Color(20, 45, 78);
    private static final Color FORM_BACKGROUND = new Color(245, 247, 250);
    private static final Color SUBMIT_GREEN = new Color(35, 130, 75);
    private static final Color EXIT_RED = new Color(180, 55, 55);
    private static final Color STATUS_DEFAULT = new Color(70, 78, 88);

    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private JRadioButton otherRadio;
    private ButtonGroup genderGroup;
    private JCheckBox sportsCheck;
    private JCheckBox musicCheck;
    private JCheckBox readingCheck;
    private JComboBox<String> countryBox;
    private JTextArea commentsArea;
    private JLabel statusLabel;
    private JButton submitButton;
    private JButton clearButton;
    private JButton exitButton;

    public RegistrationForm() {
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new Dimension(620, 560));
        setSize(700, 620);
        setLocationRelativeTo(null);

        initializeComponents();
        buildForm();
        registerEventHandlers();
    }

    private void initializeComponents() {
        nameField = new JTextField(28);
        emailField = new JTextField(28);
        passwordField = new JPasswordField(28);

        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        otherRadio = new JRadioButton("Other");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);

        sportsCheck = new JCheckBox("Sports");
        musicCheck = new JCheckBox("Music");
        readingCheck = new JCheckBox("Reading");

        countryBox = new JComboBox<>(new String[]{"Kenya", "Tanzania", "Uganda", "Rwanda"});
        commentsArea = new JTextArea(5, 28);
        commentsArea.setLineWrap(true);
        commentsArea.setWrapStyleWord(true);

        statusLabel = new JLabel("Status: Ready");
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");
    }

    private void buildForm() {
        setLayout(new BorderLayout(0, 0));
        add(createHeader(), BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(FORM_BACKGROUND);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(18, 30, 12, 30));
        contentPanel.add(createFormPanel(), BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);

        add(createBottomPanel(), BorderLayout.SOUTH);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(NAVY);
        header.setBorder(BorderFactory.createEmptyBorder(20, 28, 18, 28));

        JLabel titleLabel = new JLabel("Registration Form");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        header.add(titleLabel, BorderLayout.NORTH);

        JLabel subtitle = new JLabel("Create your registration profile");
        subtitle.setForeground(new Color(215, 225, 238));
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 14));
        header.add(subtitle, BorderLayout.SOUTH);
        return header;
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 232)),
                BorderFactory.createEmptyBorder(18, 20, 18, 20)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 8, 7, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addRow(formPanel, gbc, 0, "Full Name:", nameField);
        addRow(formPanel, gbc, 1, "Email:", emailField);
        addRow(formPanel, gbc, 2, "Password:", passwordField);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        genderPanel.setOpaque(false);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        genderPanel.add(otherRadio);
        addRow(formPanel, gbc, 3, "Gender:", genderPanel);

        JPanel interestsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        interestsPanel.setOpaque(false);
        interestsPanel.add(sportsCheck);
        interestsPanel.add(musicCheck);
        interestsPanel.add(readingCheck);
        addRow(formPanel, gbc, 4, "Interests:", interestsPanel);

        addRow(formPanel, gbc, 5, "Country:", countryBox);
        addRow(formPanel, gbc, 6, "Comments:", new JScrollPane(commentsArea));
        return formPanel;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new BorderLayout(0, 8));
        bottomPanel.setBackground(FORM_BACKGROUND);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(8, 30, 18, 30));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        buttonPanel.setOpaque(false);
        styleButton(submitButton, SUBMIT_GREEN);
        styleButton(clearButton, new Color(100, 110, 122));
        styleButton(exitButton, EXIT_RED);
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        statusLabel.setForeground(STATUS_DEFAULT);
        statusLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bottomPanel.add(statusLabel, BorderLayout.SOUTH);
        return bottomPanel;
    }

    private void styleButton(JButton button, Color background) {
        button.setForeground(Color.WHITE);
        button.setBackground(background);
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 13));
        button.setBorder(BorderFactory.createEmptyBorder(9, 22, 9, 22));
    }

    private void registerEventHandlers() {
        submitButton.addActionListener(e -> submitForm());
        clearButton.addActionListener(e -> clearForm());
        exitButton.addActionListener(e -> confirmExit());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmExit();
            }
        });
    }

    private void submitForm() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        char[] password = passwordField.getPassword();

        if (name.isEmpty()) {
            showError("Full name is required.");
            return;
        }
        if (email.isEmpty()) {
            showError("Email is required.");
            return;
        }
        if (!email.contains("@")) {
            showError("Email must contain @.");
            return;
        }
        if (password.length < 6) {
            showError("Password must contain at least six characters.");
            return;
        }

        String gender = "Not specified";
        if (maleRadio.isSelected()) {
            gender = "Male";
        } else if (femaleRadio.isSelected()) {
            gender = "Female";
        } else if (otherRadio.isSelected()) {
            gender = "Other";
        }

        StringBuilder interests = new StringBuilder();
        addInterest(interests, sportsCheck);
        addInterest(interests, musicCheck);
        addInterest(interests, readingCheck);
        String selectedInterests = interests.length() == 0 ? "None" : interests.toString();
        String comments = commentsArea.getText().trim();
        if (comments.isEmpty()) {
            comments = "None";
        }

        String summary = String.format(
                "Registration successful!%n%nName: %s%nEmail: %s%nGender: %s%n"
                        + "Interests: %s%nCountry: %s%nComments: %s",
                name, email, gender, selectedInterests, countryBox.getSelectedItem(), comments);
        JOptionPane.showMessageDialog(this, summary, "Registration Summary",
                JOptionPane.INFORMATION_MESSAGE);
        updateStatus("Status: Registration successful.", SUBMIT_GREEN);
    }

    private void addInterest(StringBuilder interests, JCheckBox checkBox) {
        if (checkBox.isSelected()) {
            if (interests.length() > 0) {
                interests.append(", ");
            }
            interests.append(checkBox.getText());
        }
    }

    private void clearForm() {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        genderGroup.clearSelection();
        sportsCheck.setSelected(false);
        musicCheck.setSelected(false);
        readingCheck.setSelected(false);
        countryBox.setSelectedIndex(0);
        commentsArea.setText("");
        updateStatus("Status: Form cleared.", STATUS_DEFAULT);
    }

    private void confirmExit() {
        int answer = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to exit?", "Confirm Exit",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    private void showError(String message) {
        updateStatus("Error: " + message, EXIT_RED);
        JOptionPane.showMessageDialog(this, message, "Validation Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private void updateStatus(String message, Color color) {
        statusLabel.setText(message);
        statusLabel.setForeground(color);
    }

    private void addRow(JPanel panel, GridBagConstraints gbc,
                        int row, String label, Component component) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        JLabel fieldLabel = new JLabel(label);
        fieldLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        panel.add(fieldLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(component, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm().setVisible(true));
    }
}
