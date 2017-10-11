package com.jingao.window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jingao.sqlite.SqlMaker;
import com.jingao.sqlite.SqliteManager;
import com.jingao.util.ToolUtil;
import com.jingao.window.data.DataPool;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class valueWindow extends JFrame implements BaseFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public valueWindow(DefaultTableModel model, String fieldName) {
		BaseFrame.super.initFrame(this);
		BaseFrame.super.closeFrame(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 61, 306, 181);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);

		JLabel label = new JLabel("编辑字段:" + fieldName);
		label.setBounds(14, 13, 72, 18);
		contentPane.add(label);

		JButton button = new JButton("插入");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((DefaultTableModel) (table.getModel())).addRow(new Object[] { "", "" });
			}
		});
		button.setBounds(318, 64, 113, 27);
		contentPane.add(button);

		JButton button_1 = new JButton("保存");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SqlMaker maker = new SqlMaker();
				String sql;
				if (DataPool.fieldValueModel.get(fieldName) != null) {
					sql = maker.UpdateFieldMapping((DefaultTableModel) table.getModel(), fieldName);
				} else {
					sql = maker.CreateFieldMapping(fieldName);
					sql = sql + ";" + maker.makeInsert((DefaultTableModel) table.getModel(), fieldName);
					// 数据加入缓存
					DataPool.fieldValueModel.put(fieldName, (DefaultTableModel) table.getModel());
				}
				SqliteManager.updateBatch(sql);
			}
		});
		button_1.setBounds(318, 215, 113, 27);
		contentPane.add(button_1);

		JButton button_2 = new JButton("删除");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = table.getSelectedRow();
				if (select < 0) {
					JOptionPane.showMessageDialog(null, "请选中需要删除的行");
					return;
				}
				String fineldName = (String) table.getModel().getValueAt(select, 0);
				((DefaultTableModel) (table.getModel())).removeRow(select);
				DataPool.fieldValueModel.remove(fineldName);
			}
		});
		button_2.setBounds(318, 117, 113, 27);
		contentPane.add(button_2);
	}
}
