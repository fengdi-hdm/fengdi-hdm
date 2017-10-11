package com.jingao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.border.CompoundBorder;

public class ConfigValueWindow extends JFrame implements BaseFrame {

	private JPanel contentPane;
	private JButton button;
	private JButton button_1;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ConfigValueWindow(AbstractTableModel model,String fieldName) {
		BaseFrame.super.initFrame(this);
		BaseFrame.super.closeFrame(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 638, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblNewLabel = new JLabel("编辑字段"+fieldName);
		lblNewLabel.setBounds(0, 13, 483, 59);
		contentPane.add(lblNewLabel);
		if (true) {
			model = new DefaultTableModel(
					new String[][] { { "1", "1" }, { null, null }, { null, null }, { null, null }},
					new String[] { "keyn", "value" });
			System.err.println("herer");
		}

		button = new JButton("保存");
		button.setBounds(493, 258, 113, 27);
		contentPane.add(button);
		
		button_1 = new JButton("添加记录");
		button_1.setBounds(493, 63, 113, 27);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.err.println("添加记录"); 
//				DefaultTableModel m = ((DefaultTableModel) table.getModel());
//				m.addRow(new Object[] { "1", "1" });
//				table.setModel(m);
//				table.setBounds(14, 277, 447, -171);
			}
		});
		contentPane.add(button_1);
		
		
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 282, 438, -194);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
	}
}
