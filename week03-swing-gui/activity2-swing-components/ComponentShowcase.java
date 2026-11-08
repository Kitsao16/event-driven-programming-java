import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
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
import java.awt.GridLayout;
import java.awt.Insets;

public class ComponentShowcase {

    private static final Color NAVY = new Color(28, 48, 77);
    private static final Color ACCENT = new Color(31, 126, 140);
    private static final Color BACKGROUND = new Color(244, 247, 250);
    private static final Color BORDER = new Color(210, 218, 228);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ComponentShowcase::createAndShowWindow);
    }

    private static void createAndShowWindow() {
        JFrame frame = new JFrame("Swing Component Showcase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(createShowcasePanel());
        frame.setMinimumSize(new Dimension(700, 620));
        frame.pack();
        frame.setSize(Math.max(frame.getWidth(), 700), Math.max(frame.getHeight(), 620));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createShowcasePanel() {
        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.setBackground(BACKGROUND);
        outerPanel.setBorder(BorderFactory.createEmptyBorder(20, 28, 20, 28));

        // The guide's required eight-row structure.
        JPanel rows = new JPanel(new GridLayout(8, 1, 10, 10));
        rows.setOpaque(false);
        rows.add(createHeadingRow());
        rows.add(createUsernameRow());
        rows.add(createPasswordRow());
        rows.add(createCheckboxRow());
        rows.add(createRadioButtonRow());
        rows.add(createCountryRow());
        rows.add(createCommentsRow());
        rows.add(createButtonRow());
        outerPanel.add(rows, BorderLayout.CENTER);
        return outerPanel;
    }

    private static JPanel createHeadingRow() {
        JPanel panel = createRow(new FlowLayout(FlowLayout.CENTER));
        JLabel heading = new JLabel("Swing Components Showcase", SwingConstants.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 26));
        heading.setForeground(NAVY);
        panel.add(heading);
        return panel;
    }

    private static JPanel createUsernameRow() {
        JPanel panel = createRow(new FlowLayout(FlowLayout.LEFT, 16, 8));
        panel.add(createLabel("Username:"));
        JTextField usernameField = new JTextField(24);
        styleTextField(usernameField);
        panel.add(usernameField);
        return panel;
    }

    private static JPanel createPasswordRow() {
        JPanel panel = createRow(new FlowLayout(FlowLayout.LEFT, 16, 8));
        panel.add(createLabel("Password:"));
        JPasswordField passwordField = new JPasswordField(24);
        styleTextField(passwordField);
        panel.add(passwordField);
        return panel;
    }

    private static JPanel createCheckboxRow() {
        JPanel panel = createRow(new FlowLayout(FlowLayout.LEFT, 16, 8));
        panel.add(createLabel("Interests:"));
        JCheckBox eventsCheckBox = new JCheckBox("Event-driven programming");
        JCheckBox designCheckBox = new JCheckBox("GUI design");
        styleCheckBox(eventsCheckBox);
        styleCheckBox(designCheckBox);
        panel.add(eventsCheckBox);
        panel.add(designCheckBox);
        return panel;
    }

    private static JPanel createRadioButtonRow() {
        JPanel panel = createRow(new FlowLayout(FlowLayout.LEFT, 16, 8));
        panel.add(createLabel("Study mode:"));
        JRadioButton fullTimeRadioButton = new JRadioButton("Full-time");
        JRadioButton partTimeRadioButton = new JRadioButton("Part-time");
        JRadioButton onlineRadioButton = new JRadioButton("Online");
        ButtonGroup studyModeGroup = new ButtonGroup();
        studyModeGroup.add(fullTimeRadioButton);
        studyModeGroup.add(partTimeRadioButton);
        studyModeGroup.add(onlineRadioButton);
        styleRadioButton(fullTimeRadioButton);
        styleRadioButton(partTimeRadioButton);
        styleRadioButton(onlineRadioButton);
        fullTimeRadioButton.setSelected(true);
        panel.add(fullTimeRadioButton);
        panel.add(partTimeRadioButton);
        panel.add(onlineRadioButton);
        return panel;
    }

    private static JPanel createCountryRow() {
        JPanel panel = createRow(new FlowLayout(FlowLayout.LEFT, 16, 8));
        panel.add(createLabel("Country:"));
        JComboBox<String> countryComboBox = new JComboBox<>(
                new String[]{"Kenya", "Tanzania", "Uganda", "Rwanda"});
        countryComboBox.addItem("Ethiopia");
        countryComboBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        countryComboBox.setPreferredSize(new Dimension(250, 34));
        panel.add(countryComboBox);
        return panel;
    }

    private static JPanel createCommentsRow() {
        JPanel commentsPanel = new JPanel(new BorderLayout(0, 6));
        commentsPanel.setBackground(Color.WHITE);
        commentsPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)));

        JLabel commentsLabel = createLabel("Comments:");
        commentsPanel.add(commentsLabel, BorderLayout.NORTH);

        JTextArea commentsArea = new JTextArea(
                "Type additional comments here...", 3, 35);
        commentsArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        commentsArea.setLineWrap(true);
        commentsArea.setWrapStyleWord(true);
        commentsArea.setEditable(true);
        commentsArea.setMargin(new Insets(8, 8, 8, 8));
        JScrollPane commentsScrollPane = new JScrollPane(commentsArea);
        commentsScrollPane.setPreferredSize(new Dimension(500, 94));
        commentsPanel.add(commentsScrollPane, BorderLayout.CENTER);
        return commentsPanel;
    }

    private static JPanel createButtonRow() {
        JPanel panel = createRow(new FlowLayout(FlowLayout.RIGHT, 12, 8));
        JButton submitButton = createButton("Submit", ACCENT);
        JButton cancelButton = createButton("Cancel", NAVY);
        // Button actions are intentionally omitted; interactions are covered in Week 4.
        panel.add(submitButton);
        panel.add(cancelButton);
        return panel;
    }

    private static JPanel createRow(FlowLayout layout) {
        JPanel panel = new JPanel(layout);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        return panel;
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

    private static void styleCheckBox(JCheckBox checkBox) {
        checkBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        checkBox.setBackground(Color.WHITE);
        checkBox.setForeground(NAVY);
    }

    private static void styleRadioButton(JRadioButton radioButton) {
        radioButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        radioButton.setBackground(Color.WHITE);
        radioButton.setForeground(NAVY);
    }

    private static JButton createButton(String text, Color background) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(background);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(9, 22, 9, 22));
        return button;
    }
}
