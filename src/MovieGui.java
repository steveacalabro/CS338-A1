import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;

public class MovieGui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField durationField;
	private JTextField movieTitleField;
	private JTextField releaseField;
	private JTextField ratingField;
	private JTextField directorsField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieGui frame = new MovieGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MovieGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("<-");
		button.setEnabled(false);
		button.setBounds(194, 100, 45, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("->");
		button_1.setEnabled(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(194, 134, 45, 23);
		contentPane.add(button_1);
		
		JList list = new JList();
		list.setBounds(10, 11, 174, 239);
		contentPane.add(list);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(249, 11, 175, 239);
		contentPane.add(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(10, 261, 174, 23);
		contentPane.add(btnAdd);
		
		JButton btnChange = new JButton("Change");
		btnChange.setEnabled(false);
		btnChange.setBounds(249, 261, 75, 23);
		contentPane.add(btnChange);
		
		JButton button_3 = new JButton("Remove");
		button_3.setEnabled(false);
		button_3.setBounds(349, 261, 75, 23);
		contentPane.add(button_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 295, 414, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMovieTitle = new JLabel("Movie Title: ");
		lblMovieTitle.setEnabled(false);
		lblMovieTitle.setBounds(10, 8, 58, 14);
		panel.add(lblMovieTitle);
		
		JLabel lblRating = new JLabel("Rating:");
		lblRating.setEnabled(false);
		lblRating.setBounds(167, 8, 35, 14);
		panel.add(lblRating);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setEnabled(false);
		lblDuration.setBounds(167, 66, 45, 14);
		panel.add(lblDuration);
		
		JLabel lblDirectors = new JLabel("Directors:");
		lblDirectors.setEnabled(false);
		lblDirectors.setBounds(247, 8, 47, 14);
		panel.add(lblDirectors);
		
		durationField = new JTextField();
		durationField.setEnabled(false);
		durationField.setBounds(167, 91, 70, 20);
		panel.add(durationField);
		durationField.setColumns(10);
		
		movieTitleField = new JTextField();
		movieTitleField.setEnabled(false);
		movieTitleField.setBounds(10, 33, 147, 20);
		panel.add(movieTitleField);
		movieTitleField.setColumns(10);
		
		ratingField = new JTextField();
		ratingField.setEnabled(false);
		ratingField.setBounds(167, 33, 70, 20);
		panel.add(ratingField);
		ratingField.setColumns(10);
		
		directorsField = new JTextField();
		directorsField.setEnabled(false);
		directorsField.setBounds(247, 33, 157, 20);
		panel.add(directorsField);
		directorsField.setColumns(10);
		
		JLabel lblReleaseYear = new JLabel("Release year: ");
		lblReleaseYear.setBounds(12, 66, 70, 14);
		panel.add(lblReleaseYear);
		lblReleaseYear.setEnabled(false);
		
		releaseField = new JTextField();
		releaseField.setBounds(12, 91, 145, 20);
		panel.add(releaseField);
		releaseField.setEnabled(false);
		releaseField.setColumns(10);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setEnabled(false);
		cancelBtn.setBounds(247, 90, 157, 23);
		panel.add(cancelBtn);
	}
}
