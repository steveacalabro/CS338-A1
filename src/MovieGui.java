import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
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

import java.util.ArrayList;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MovieGui extends JFrame {

	private static MovieListActions ma;
	
	private JPanel contentPane;
	private JTextField durationField;
	private JTextField movieTitleField;
	private JTextField releaseField;
	private JTextField ratingField;
	private JTextField directorsField;
	private JTable table;
	private JLabel movieTitleLbl;
	private JLabel ratingLbl;
	private JLabel durationLbl;
	private JLabel directorsLbl;
	private JLabel yearLbl;
	private JButton cancelBtn;
	private JLabel lblEdit;
	private JList list;
	private JButton rightBtn;
	private JButton leftBtn;
	private JButton btnAdd;
	private JButton btnChange;
	private JButton removeBtn;
	
	private int selectedList = -1;
	private int selectedTable = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ma = new MovieListActions();
		ma.addMovieList("The Martian", 2015, "PG-13", 141, "Ridley Scott");
		ma.addMovieTable("Inside Out", 2015, "PG", 94, "Pete Doctor and Ronnie del Carmen");
		
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
		setTitle("Movie Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//List Stuff
		ArrayList<Movie> movieList = ma.getMovieList();
		DefaultListModel listModel = new DefaultListModel();
		
		for(int i = 0; i < movieList.size(); i ++) {
			Movie m = movieList.get(i);
			listModel.addElement(m.movieTitle() + ", " + m.year() + ", " + m.rating() + ", " + m.duration() + ", " + m.directors());
		}
		
		list = new JList(listModel);
		list.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				table.clearSelection();
			}
		});
		list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	leftBtn.setEnabled(false);
                	rightBtn.setEnabled(true);
                	btnAdd.setEnabled(true);
                	btnChange.setEnabled(true);
                	removeBtn.setEnabled(true);
                	selectedTable = table.getSelectionModel().getMinSelectionIndex();
                	selectedList = list.getSelectedIndex();
                	//label.setText(list.getSelectedValue().toString());
                }
            }
        });
		list.setBounds(10, 11, 299, 239);
		contentPane.add(list);
		
		//Table Stuff
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(374, 11, 300, 239);
		contentPane.add(scrollPane);
		
		ArrayList<Movie> movieTable = ma.getMovieTable();
		Object[][] tableData = new Object[movieTable.size()][5];
		
		for(int i = 0; i < movieTable.size(); i ++) {
			Movie m = movieTable.get(i);
			tableData[i][0] = m.movieTitle();
			tableData[i][1] = m.year();
			tableData[i][2] = m.rating();
			tableData[i][3] = m.duration();
			tableData[i][4] = m.directors();
		}
		
		String[] colNames = {"Title", "Year", "Rating", "Duration", "Director(s)"};
		
		DefaultTableModel dtm = new DefaultTableModel(tableData, colNames);
		table = new JTable(dtm) {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				list.clearSelection();
				selectedTable = table.getSelectionModel().getMinSelectionIndex();
            	selectedList = list.getSelectedIndex();
			}
		});
	    table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	leftBtn.setEnabled(true);
            	rightBtn.setEnabled(false);
            	btnAdd.setEnabled(true);
            	btnChange.setEnabled(true);
            	removeBtn.setEnabled(true);
	        }
	    });
	    scrollPane.setViewportView(table);
		
	    leftBtn = new JButton("<-");
		leftBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Movie m = movieTable.get(selectedTable);
				movieList.add(m);
				
				listModel.addElement(m.movieTitle() + ", " + m.year() + ", " + m.rating() + ", " + m.duration() + ", " + m.directors());
				
				movieTable.remove(selectedTable);
				dtm.removeRow(selectedTable);
			}
		});
		leftBtn.setEnabled(false);
		leftBtn.setBounds(319, 109, 45, 23);
		contentPane.add(leftBtn);
		
		rightBtn = new JButton("->");
		rightBtn.setEnabled(false);
		rightBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Movie m = movieList.get(selectedList);
				
				movieTable.add(m);
				Object[] newMovie = {m.movieTitle(), m.year(), m.rating(), m.duration(), m.directors()};
				dtm.addRow(newMovie);
	
				movieList.remove(selectedList);
				listModel.remove(selectedList);
			}
		});
		rightBtn.setBounds(319, 143, 45, 23);
		contentPane.add(rightBtn);
		
		JPanel panel = new JPanel();
		panel.setBounds(260, 282, 414, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		movieTitleLbl = new JLabel("Movie Title: ");
		movieTitleLbl.setEnabled(false);
		movieTitleLbl.setBounds(10, 8, 58, 14);
		panel.add(movieTitleLbl);
		
		ratingLbl = new JLabel("Rating:");
		ratingLbl.setEnabled(false);
		ratingLbl.setBounds(167, 8, 35, 14);
		panel.add(ratingLbl);
		
		durationLbl = new JLabel("Duration:");
		durationLbl.setEnabled(false);
		durationLbl.setBounds(167, 66, 45, 14);
		panel.add(durationLbl);
		
		directorsLbl = new JLabel("Directors:");
		directorsLbl.setEnabled(false);
		directorsLbl.setBounds(247, 8, 47, 14);
		panel.add(directorsLbl);
		
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
		
		yearLbl = new JLabel("Release year: ");
		yearLbl.setBounds(12, 66, 70, 14);
		panel.add(yearLbl);
		yearLbl.setEnabled(false);
		
		releaseField = new JTextField();
		releaseField.setBounds(12, 91, 145, 20);
		panel.add(releaseField);
		releaseField.setEnabled(false);
		releaseField.setColumns(10);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnChange.getText() == "Save") {
					btnChange.setText("Change");
				}
				toggleFields();
			}
		});
		cancelBtn.setEnabled(false);
		cancelBtn.setBounds(247, 90, 157, 23);
		panel.add(cancelBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 282, 240, 135);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnAdd = new JButton("Add Movie");
		btnAdd.setBounds(10, 5, 220, 23);
		panel_1.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAdd.getText() == "Add Movie") {
					btnAdd.setText("Save");
					toggleFields();
				} else {
					//This is when the new movie is Saved
					btnAdd.setText("Add Movie");
					
					if(validateData() == true) {
						Movie m = new Movie(movieTitleField.getText(), releaseField.getText(), ratingField.getText(), durationField.getText(), directorsField.getText());
						movieList.add(m);
						listModel.addElement(m.movieTitle() + ", " + m.year() + ", " + m.rating() + ", " + m.duration() + ", " + m.directors());
						
						movieTitleField.setText("");
						durationField.setText("");
						releaseField.setText("");
						ratingField.setText("");
						directorsField.setText("");
						toggleFields();
					}
				}
			}
		});
		
		btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnChange.getText() == "Change") {
					btnChange.setText("Save");
					toggleFields();
					
					if(selectedList == -1) {
						Movie m = movieTable.get(selectedTable);
						
						//Gotta fill those fileds first
						movieTitleField.setText(m.movieTitle());
						durationField.setText(Integer.toString(m.duration()));
						releaseField.setText(Integer.toString(m.year()));
						ratingField.setText(m.rating());
						directorsField.setText(m.directors());
					} else {
						Movie m = movieList.get(selectedList);
						
						//Gotta fill those fileds first
						movieTitleField.setText(m.movieTitle());
						durationField.setText(Integer.toString(m.duration()));
						releaseField.setText(Integer.toString(m.year()));
						ratingField.setText(m.rating());
						directorsField.setText(m.directors());
					}
				} else {
					//Saving the new Data
					btnChange.setText("Change");
					
					if(selectedList == -1) {
						//Add to table
						if(validateData() == true) {
							Movie m = movieTable.get(selectedTable);
							m.movieTitle(movieTitleField.getText());
							m.year(releaseField.getText());
							m.rating(ratingField.getText());
							m.duration(durationField.getText());
							m.directors(directorsField.getText());
							
							movieTable.set(selectedTable, m);
							dtm.setValueAt(m.movieTitle(), selectedTable, 0);
							dtm.setValueAt(m.year(), selectedTable, 1);
							dtm.setValueAt(m.rating(), selectedTable, 2);
							dtm.setValueAt(m.duration(), selectedTable, 3);
							dtm.setValueAt(m.directors(), selectedTable, 4);
							
							movieTitleField.setText("");
							durationField.setText("");
							releaseField.setText("");
							ratingField.setText("");
							directorsField.setText("");
							toggleFields();
						}
					} else {
						//Add to list
						if(validateData() == true) {
							Movie m = movieList.get(selectedList);
							m.movieTitle(movieTitleField.getText());
							m.year(releaseField.getText());
							m.rating(ratingField.getText());
							m.duration(durationField.getText());
							m.directors(directorsField.getText());
							
							movieList.set(selectedList, m);
							listModel.setElementAt(m.movieTitle() + ", " + m.year() + ", " + m.rating() + ", " + m.duration() + ", " + m.directors(), selectedList);
							
							movieTitleField.setText("");
							durationField.setText("");
							releaseField.setText("");
							ratingField.setText("");
							directorsField.setText("");
							toggleFields();
						}
					}
				}
			}
		});
		btnChange.setBounds(10, 55, 220, 23);
		panel_1.add(btnChange);
		btnChange.setEnabled(false);
		
		removeBtn = new JButton("Remove");
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedList == -1) {
					movieTable.remove(selectedTable);
					dtm.removeRow(selectedTable);
					
					removeBtn.setEnabled(false);
					btnChange.setEnabled(false);
				} else {
					movieList.remove(selectedList);
					listModel.remove(selectedList);
					
					removeBtn.setEnabled(false);
					btnChange.setEnabled(false);
				}
			}
		});
		removeBtn.setBounds(10, 89, 220, 23);
		panel_1.add(removeBtn);
		removeBtn.setEnabled(false);
		
		JLabel lblActions = new JLabel("Actions");
		lblActions.setBounds(10, 261, 46, 14);
		contentPane.add(lblActions);
		
		lblEdit = new JLabel("Edit");
		lblEdit.setEnabled(false);
		lblEdit.setBounds(260, 261, 46, 14);
		contentPane.add(lblEdit);
	}
	
	public void toggleFields() {
		if(movieTitleField.isEnabled()) {
			durationField.setEnabled(false);
			movieTitleField.setEnabled(false);
			releaseField.setEnabled(false);
			ratingField.setEnabled(false);
			directorsField.setEnabled(false);
			movieTitleLbl.setEnabled(false);
			ratingLbl.setEnabled(false);
			durationLbl.setEnabled(false);
			directorsLbl.setEnabled(false);
			yearLbl.setEnabled(false);
			cancelBtn.setEnabled(false);
			lblEdit.setEnabled(false);
		} else {
			durationField.setEnabled(true);
			movieTitleField.setEnabled(true);
			releaseField.setEnabled(true);
			ratingField.setEnabled(true);
			directorsField.setEnabled(true);
			movieTitleLbl.setEnabled(true);
			ratingLbl.setEnabled(true);
			durationLbl.setEnabled(true);
			directorsLbl.setEnabled(true);
			yearLbl.setEnabled(true);
			cancelBtn.setEnabled(true);
			lblEdit.setEnabled(true);
		}
	}
	
	public boolean validateData() {
		String finalWarning = "Please enter";
		String warning = "";
		int count = 0;
		boolean status = true;
		
		if(movieTitleField.getText() == "" || movieTitleField.getText().isEmpty()) {
			warning+= "a movie Title";
			count++;
			status = false;
		}
		if(durationField.getText() == "" || durationField.getText().isEmpty()) {
			if(count > 0) {
				warning+= ", ";
			}
			warning+= "a duration";
			count++;
			status = false;
		}				
		if(releaseField.getText() == "" || releaseField.getText().isEmpty()) {
			if(count > 0) {
				warning+= ", ";
			}
			warning+= "a release year";
			count++;
			status = false;
		}
		if(ratingField.getText() == "" || ratingField.getText().isEmpty()) {
			if(count > 0) {
				warning+= ", ";
			}
			warning+= "a rating";
			count++;
			status = false;
		}
		if(directorsField.getText() == "" || directorsField.getText().isEmpty()) {
			if(count > 0) {
				warning+= ", ";
			}
			warning+= "(a) director(s)";
			count++;
			status = false;
		}
		
		if(count > 1) {
			finalWarning = finalWarning + ", ";
		} 
		
		if(status == false) {
			finalWarning= finalWarning + warning;
			JOptionPane.showMessageDialog(null, finalWarning);
		}
		
		return status;
	}
}
