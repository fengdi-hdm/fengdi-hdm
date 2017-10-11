package com.jingao.window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.DefaultMenuLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jingao.sqlite.DataMaker;
import com.jingao.sqlite.SqlMaker;
import com.jingao.sqlite.SqliteManager;
import com.jingao.util.ToolUtil;
import com.jingao.window.data.DataPool;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;

public class FieldConfigWindow extends JFrame implements BaseFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public FieldConfigWindow() throws Exception {
		BaseFrame.super.initFrame(this);
		BaseFrame.super.closeFrame(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String filedName = (String) table.getValueAt(table.getSelectedRow(), 0);
				// 如果从缓存中找到数据,用数据创建数据,否则新建数据
				// if (DataPool.fieldValueMap.get(filedName) != null) {
				// DefaultTableModel model = new DefaultTableModel(2, 5);
				// new ConfigValueWindow(model, filedName).setVisible(true);
				// } else {
				// //
				// }
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(14, 27, 450, 650);
		contentPane.add(scrollPane);

		DefaultTableModel td = DataPool.fieldTypeModel;

		table.setModel(td);

		JButton button = new JButton("添加");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				td.addRow(new Object[] { "", "" });
				table.setModel(td);
			}
		});
		button.setBounds(512, 35, 113, 27);
		contentPane.add(button);

		JButton button_1 = new JButton("保存");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				save(td);
			}
		});
		button_1.setBounds(512, 179, 113, 27);
		contentPane.add(button_1);

		JButton button_2 = new JButton("删除");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int[] selRowIndexs = table.getSelectedRows();// 用户所选行的序列
				for (int i = 0; i < selRowIndexs.length; i++) {
					td.removeRow(table.getSelectedRow());
					// save(td);
				}
			}
		});
		button_2.setBounds(512, 101, 113, 27);
		contentPane.add(button_2);

		JButton button_3 = new JButton("编辑映射表");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String fieldName;
				if (table.getSelectedRow() < 0) {
					fieldName = null;
				} else {
					fieldName = (String) table.getValueAt(table.getSelectedRow(), 0);
				}
				if (fieldName == null) {// 没选中
					JOptionPane.showMessageDialog(null, "请选中指定字段进行编辑");
				} else {// 选中
					DefaultTableModel model = DataPool.fieldValueModel.get(fieldName);
					if (model == null) {
						model = new DefaultTableModel(new Object[][] { { "", "" } }, new String[] { "come", "out" });
					}
					valueWindow frame = new valueWindow(model, fieldName);
					frame.setVisible(true);
				}
			}
		});
		button_3.setBounds(512, 248, 113, 27);
		contentPane.add(button_3);

	}

	private void save(DefaultTableModel td) {

		for (int i = 0; i < td.getRowCount(); i++) {
			if (td.getValueAt(i, 0) == null || td.getValueAt(i, 1) == null || td.getValueAt(i, 2) == null
					|| td.getValueAt(i, 3) == null) {
				continue;
			}
			DataPool.FieldTypeMap.put(td.getValueAt(i, 0).toString(), td.getValueAt(i, 2).toString());
		}
		System.err.println("mapsize=" + DataPool.FieldTypeMap.size());
		// 创建表或更新表
		if (true) {// 判断是否已经创建表,如果已创建,drop,创建
			SqliteManager.update("drop table fieldconfig");
			SqlMaker maker = new SqlMaker();
			String sql = maker.CreateFieldConfigTable();
			SqliteManager.update(sql);
			sql = maker.makeInsert(td, "fieldconfig");
			SqliteManager.update(sql);
		} else {
			// 创建表
		}

	}
}
