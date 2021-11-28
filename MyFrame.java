import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame {

	// All panel
	private static JPanel writePanel;
	private static JPanel showPanel;
	private static JPanel bookPanel;
	private static JPanel authorPanel;
	private static JPanel writeBookPanel;
	private static JPanel bookButtonPanel;
	private static JPanel writeAuthorPanel;
	private static JPanel authorButtonPanel;
	private static JPanel bookTitlePanel;
	private static JPanel bookNamePanel;
	private static JPanel bookPubicDayPanel;
	private static JPanel bookAuthorNicknamePanel;
	private static JPanel authorTitlePanel;
	private static JPanel authorNamePanel;
	private static JPanel authorNicknamePanel;
	private static JPanel authorBirthdayPanel;
	private static JPanel showTablePanel;
	private static JPanel showButtonPanel;
	private static JPanel showInfoMemberPanel;

	// All label
	private static JLabel bookTitleLabel;
	private static JLabel authorTitleLabel;
	private static JLabel bookNameLabel;
	private static JLabel bookPubicDayLabel;
	private static JLabel bookAuthorNicknameLabel;
	private static JLabel authorNameLabel;
	private static JLabel authorNicknameLabel;
	private static JLabel authorBirthdayLabel;
	private static JLabel sortByLabel;

	// All text field
	private static JTextField bookNameTextField;
	private static JTextField bookPublicDayTextField;
	private static JTextField bookAuthorNicknameTextField;
	private static JTextField authorNameTextField;
	private static JTextField authorNicknameTextField;
	private static JTextField authorBirthdayTextField;

	// All button
	private static JButton newBookButton;
	private static JButton saveBookButton;
	private static JButton resetBookButton;
	private static JButton newAuthorButton;
	private static JButton saveAuthorButton;
	private static JButton resetAuthorButton;
	private static JButton showBookButton;
	private static JButton showAuthorButton;

	// All table
	private static JTable showTable;
	private static JTable showAuthorTable;

	// All comboBox
	private static JComboBox sortByComboBox;

	// All scrollpane
	private static JScrollPane scrollPane;

	private static Vector bookTableTitle;
	private static Vector bookTableRecords;

	private static Vector authorTableTitle;
	private static Vector authorTableRecords;

	// All boolean variable
	boolean checkTable = false;

	// All member info
	private static String[] allMemberInfo = {
		"Nguyen Thanh Phong - 3120410396",
		"Phan Văn Bằng - 3120410060",
		"Nguyễn Võ Nhựt Hoàng - 3119410144",
	};

	private static String toString(int i) {
		String s = "" + i;
		return s;
	}

	private static void setWritePanel(JPanel thisPanel, JLabel thisLabel, JTextField thisTextField) {
		thisLabel.setBounds(10, 24, 120, 24);
		thisTextField.setBounds(140, 24, 360, 24);
		thisPanel.setLayout(null);
		thisPanel.add(thisLabel);
		thisPanel.add(thisTextField);
	}

	private static void setNewButton(JPanel thisPanel, JButton newThisButton) {
		newThisButton.setBounds(20, 312, 72, 36);
		thisPanel.add(newThisButton);
	}

	private static void setSaveButton(JPanel thisPanel, JButton thisButton) {
		thisButton.setBounds(112, 312, 72, 36);
		thisPanel.add(thisButton);
	}

	private static void setResetButton(JPanel thisPanel, JButton thisButton) {
		thisButton.setBounds(204, 312, 72, 36);
		thisPanel.add(thisButton);
	}

	private static void resetField(int checkField) {
		if (checkField == 0) {
			bookNameTextField.setText("");
			bookPublicDayTextField.setText("");
			bookAuthorNicknameTextField.setText("");
		}
		if (checkField == 1) {
			authorNicknameTextField.setText("");
			authorNameTextField.setText("");
			authorBirthdayTextField.setText("");
		}
	}

	private static void initRecord () {
		Vector record1 = new Vector();
		record1.add("Ten 1");
		record1.add("Ngay 1");
		record1.add("TG 1");

		Vector record2 = new Vector();
		record2.add("Ten 2");
		record2.add("Ngay 2");
		record2.add("TG 2");

		authorTableRecords.add(record1);
		authorTableRecords.add(record2);
	}

	MyFrame() {
		// Book field
		// Title
		bookTitleLabel = new JLabel("BOOK");
		bookTitleLabel.setForeground(Color.black);
		bookTitleLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 24));

		bookTitlePanel = new JPanel();
		bookTitlePanel.add(bookTitleLabel);

		// Name
		bookNameLabel = new JLabel("Book name:");

		bookNameTextField = new JTextField();

		bookNamePanel = new JPanel();
		bookNamePanel.setLayout(null);
		setWritePanel(bookNamePanel, bookNameLabel, bookNameTextField);

		// Public day
		bookPubicDayLabel = new JLabel("Book public day:");
		bookPubicDayLabel.setBounds(10, 24, 120, 24);

		bookPublicDayTextField = new JTextField();
		bookPublicDayTextField.setBounds(140, 24, 360, 24);

		bookPubicDayPanel = new JPanel();
		// bookPubicDayPanel.setBackground(Color.red);
		bookPubicDayPanel.setLayout(null);
		bookPubicDayPanel.add(bookPubicDayLabel);
		bookPubicDayPanel.add(bookPublicDayTextField);

		// Author nickname
		bookAuthorNicknameLabel = new JLabel("Author nickname:");
		bookAuthorNicknameLabel.setBounds(10, 24, 120, 24);

		bookAuthorNicknameTextField = new JTextField();
		bookAuthorNicknameTextField.setBounds(140, 24, 360, 24);

		bookAuthorNicknamePanel = new JPanel();
		bookAuthorNicknamePanel.setLayout(null);
		bookAuthorNicknamePanel.add(bookAuthorNicknameLabel);
		bookAuthorNicknamePanel.add(bookAuthorNicknameTextField);

		// Write book info panel
		writeBookPanel = new JPanel();
		writeBookPanel.setLayout(new GridLayout(4, 1));
		writeBookPanel.setBounds(0, 0, 683, 300);
		writeBookPanel.add(bookTitlePanel);
		writeBookPanel.add(bookNamePanel);
		writeBookPanel.add(bookPubicDayPanel);
		writeBookPanel.add(bookAuthorNicknamePanel);

		// New & save button field
		newBookButton = new JButton("New");
		newBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bookNameTextField.getText().length() == 0 || bookPublicDayTextField.getText().length() == 0 || bookAuthorNicknameTextField.getText().length() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Điền đầy đủ thông tin");
				} else {
					Vector record = new Vector();
					record.add(bookNameTextField.getText());
					record.add(bookPublicDayTextField.getText());
					record.add(bookAuthorNicknameTextField.getText());
					bookTableRecords.add(record);
					showTable.setModel(new DefaultTableModel(bookTableRecords, bookTableTitle));
					resetField(0);
					checkTable = false;
				}
			}
		});

		saveBookButton = new JButton("Save");
		saveBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkTable == true) {
					JOptionPane.showMessageDialog(rootPane, "Xin vui lòng chọn bảng sách để chỉnh sửa");
				} else {
					int selectedRecord = showTable.getSelectedRow();
					if (selectedRecord == -1) {
						JOptionPane.showMessageDialog(rootPane, "Xin vui lòng chọn dòng cần sửa");
					} else {
						Vector record = new Vector();
						record.add(bookNameTextField.getText());
						record.add(bookPublicDayTextField.getText());
						record.add(bookAuthorNicknameTextField.getText());
						bookTableRecords.set(selectedRecord, record);
						showTable.setModel(new DefaultTableModel(bookTableRecords, bookTableTitle));
						resetField(0);
					}
				}
			}
		});

		// reset book button
		resetBookButton = new JButton("Reset");
		resetBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetField(0);
			}
		});

		bookPanel = new JPanel();
		bookPanel.setLayout(null);
		bookPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		bookPanel.add(writeBookPanel);

		setNewButton(bookPanel, newBookButton);
		setSaveButton(bookPanel, saveBookButton);
		setResetButton(bookPanel, resetBookButton);


		// Author field
		// Title
		authorTitleLabel = new JLabel("AUTHOR");
		authorTitleLabel.setForeground(Color.black);
		authorTitleLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 24));

		authorTitlePanel = new JPanel();
		authorTitlePanel.add(authorTitleLabel);

		// Name
		authorNameLabel = new JLabel("Author name:");
		authorNameLabel.setBounds(10, 24, 120, 24);

		authorNameTextField = new JTextField();
		authorNameTextField.setBounds(140, 24, 360, 24);

		authorNamePanel = new JPanel();
		authorNamePanel.setLayout(null);
		authorNamePanel.add(authorNameLabel);
		authorNamePanel.add(authorNameTextField);

		// Nickname
		authorNameLabel = new JLabel("Author nickname:");

		authorNicknameTextField = new JTextField();

		authorNicknamePanel = new JPanel();
		setWritePanel(authorNicknamePanel, authorNameLabel, authorNicknameTextField);

		// Birthday
		authorBirthdayLabel = new JLabel("Author birthday:");

		authorBirthdayTextField = new JTextField();

		authorBirthdayPanel = new JPanel();
		setWritePanel(authorBirthdayPanel, authorBirthdayLabel, authorBirthdayTextField);

		// Write author info panel

		writeAuthorPanel = new JPanel();
		writeAuthorPanel.setLayout(new GridLayout(4, 1));
		writeAuthorPanel.setBounds(0, 0, 683, 300);
		writeAuthorPanel.add(authorTitlePanel);
		writeAuthorPanel.add(authorNamePanel);
		writeAuthorPanel.add(authorNicknamePanel);
		writeAuthorPanel.add(authorBirthdayPanel);

		// Author panel
		// New & save button
		newAuthorButton = new JButton("New");
		newAuthorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (authorNameTextField.getText().length() == 0 || authorNicknameTextField.getText().length() == 0 || authorBirthdayTextField.getText().length() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Điền đầy đủ thông tin");
				} else {
					Vector record = new Vector();
					record.add(authorNameTextField.getText());
					record.add(authorNicknameTextField.getText());
					record.add(authorBirthdayTextField.getText());
					authorTableRecords.add(record);
					showTable.setModel(new DefaultTableModel(authorTableRecords, authorTableTitle));
					resetField(1);
					checkTable = true;
				}
			}
		});

		saveAuthorButton = new JButton("Save");
		saveAuthorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkTable == false) {
					JOptionPane.showMessageDialog(rootPane, "Xin vui lòng chọn bảng tác giả để chỉnh sửa");
				} else {
					int selectedRecord = showTable.getSelectedRow();
					if (selectedRecord == -1) {
						JOptionPane.showMessageDialog(rootPane, "Xin vui lòng chọn dòng cần sửa");
					} else {
						Vector record = new Vector();
						record.add(authorNameTextField.getText());
						record.add(authorNicknameTextField.getText());
						record.add(authorBirthdayTextField.getText());
						authorTableRecords.set(selectedRecord, record);
						showTable.setModel(new DefaultTableModel(authorTableRecords, authorTableTitle));
						resetField(1);
					}
				}
			}
		});

		// Reset author button
		resetAuthorButton = new JButton("Reset");
		resetAuthorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetField(1);
			}
		});

		authorPanel = new JPanel();
		authorPanel.setLayout(null);
		authorPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		authorPanel.add(writeAuthorPanel);

		setNewButton(authorPanel, newAuthorButton);
		setSaveButton(authorPanel, saveAuthorButton);
		setResetButton(authorPanel, resetAuthorButton);

		writePanel = new JPanel();
		writePanel.setLayout(new GridLayout(2, 1));
		writePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		writePanel.add(bookPanel);
		writePanel.add(authorPanel);

		// Show panel
		// Show table panel
		bookTableTitle = new Vector();
		bookTableTitle.add("Name");
		bookTableTitle.add("publicDay");
		bookTableTitle.add("AuthorNickname");
		bookTableRecords = new Vector();

		authorTableTitle = new Vector();
		authorTableTitle.add("Name");
		authorTableTitle.add("AuthorNickname");
		authorTableTitle.add("Birth of day");
		authorTableRecords = new Vector();

		// initRecord();

		showTable = new JTable();

		showTable.setModel(new DefaultTableModel(bookTableRecords, bookTableTitle));

		showTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == showTable) {
					int selectedRecord = showTable.getSelectedRow();
					if (selectedRecord != -1) {
						if (bookTableRecords.size() != 0) {
							Vector bSelectedRecord = (Vector) bookTableRecords.get(selectedRecord);
							String bookName = bSelectedRecord.get(0).toString();
							String publicDay = bSelectedRecord.get(1).toString();
							String bookAuthorNickname = bSelectedRecord.get(2).toString();
							bookNameTextField.setText(bookName);
							bookPublicDayTextField.setText(publicDay);
							bookAuthorNicknameTextField.setText(bookAuthorNickname);
						}

						if (authorTableRecords.size() != 0) {
							Vector aSelectedRecord = (Vector) authorTableRecords.get(selectedRecord);
							String name = aSelectedRecord.get(0).toString();
							String authorNickname = aSelectedRecord.get(1).toString();
							String birthDay = aSelectedRecord.get(2).toString();
							authorNameTextField.setText(name);
							authorNicknameTextField.setText(authorNickname);
							authorBirthdayTextField.setText(birthDay);
						}
					}
				}
			}
			// public void mousePressed(MouseEvent e) {
			// }
			// public void mouseReleased(MouseEvent e) {
			// }
			// public void mouseEntered(MouseEvent e) {
			// }
			// public void mouseExited(MouseEvent e) {
			// }
		});

		scrollPane = new JScrollPane(showTable);
		scrollPane.setPreferredSize(new Dimension(683, 600));


		showTablePanel = new JPanel();
		showTablePanel.setBounds(0, 0, 683, 600);
		showTablePanel.setBackground(new Color(0xcccccc));
		showTablePanel.add(scrollPane);

		// Show book & author button
		showBookButton = new JButton("Show all book");
		showBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkTable = false;
				showTable.setModel(new DefaultTableModel(bookTableRecords, bookTableTitle));
			}
		});
		showBookButton.setBounds(20, 20, 140, 24);

		// show author btn
		showAuthorButton = new JButton("Show all author");
		showAuthorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkTable = true;
				showTable.setModel(new DefaultTableModel(authorTableRecords, authorTableTitle));
			}
		});

		showAuthorButton.setBounds(200, 20, 140, 24);

		sortByLabel = new JLabel("Sort by:");
		sortByLabel.setBounds(380, 20, 60, 24);

		String[] sortByOption = {
			"Author name (ascending)",
			"Book name (ascending)",
			"Book name (decrease)",
		};

		sortByComboBox = new JComboBox(sortByOption);
		sortByComboBox.setBounds(428, 20, 180, 24);

		showInfoMemberPanel = new JPanel();
		showInfoMemberPanel.setLayout(new GridLayout(3, 1));
		showInfoMemberPanel.setBounds(120, 60, 240, 56);
		showInfoMemberPanel.add(new JLabel(" " + allMemberInfo[0]));
		showInfoMemberPanel.add(new JLabel(" " + allMemberInfo[1]));
		showInfoMemberPanel.add(new JLabel(" " + allMemberInfo[2]));

		JLabel infoLabel = new JLabel("Thong tin nhom: ");
		infoLabel.setBounds(20, 40, 120, 56);

		showButtonPanel = new JPanel();
		showButtonPanel.setLayout(null);
		showButtonPanel.setBounds(0, 604, 680, 160);
		showButtonPanel.setBackground(new Color(0xcccccc));
		showButtonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		showButtonPanel.add(showBookButton);
		showButtonPanel.add(showAuthorButton);
		showButtonPanel.add(sortByLabel);
		showButtonPanel.add(sortByComboBox);
		showButtonPanel.add(showInfoMemberPanel);
		showButtonPanel.add(infoLabel);

		showPanel = new JPanel();
		showPanel.setLayout(null);
		showPanel.add(showTablePanel);
		showPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		showPanel.add(showButtonPanel);

		this.add(writePanel);
		this.add(showPanel);

		this.setSize(1366, 768);
		this.setTitle("Form");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new GridLayout(1, 2));
		this.setVisible(true);
	}
}