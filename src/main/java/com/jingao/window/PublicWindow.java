package com.jingao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.DefaultMenuLayout;
import javax.swing.table.TableModel;

import com.jingao.Config.ConfigDataPool;
import com.jingao.base.Operator;
import com.jingao.sqlite.DataMaker;
import com.jingao.util.ToolUtil;
import com.jingao.window.data.DataPool;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JButton;

public class PublicWindow extends JFrame implements Operator {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublicWindow frame = new PublicWindow();
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
	public PublicWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(14, 13, 631, 498);
		contentPane.add(tabbedPane);

		//HashMap<String,Integer> nameIndex = ToolUtil.getIndexByName(ConfigDataPool.config.keySet());
		for (String configName : ConfigDataPool.config.keySet()) {
			JTable table = new JTable();
			table.setModel(new DataMaker().getConfigModel(configName));
			JScrollPane scrollPane = new JScrollPane(table);
			tabbedPane.addTab(configName, null, scrollPane, "");
			tabbedPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					DefaultTableModel t = new DataMaker().getConfigModel(configName);
					table.setModel(t);
				}
			});
			

		}

		JButton button = new JButton("字段配置");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.err.println("gggggggg");
				if (DataPool.framSet.contains(FieldConfigWindow.class.getSimpleName())) {
					System.err.println("已经初始化过");
					// return;
				}
				try {
					new FieldConfigWindow().setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(655, 58, 113, 27);
		contentPane.add(button);
	}
}
