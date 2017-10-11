package com.jingao.window.data;

import javax.swing.table.DefaultTableModel;

import com.jingao.base.Operator;
import com.jingao.sqlite.DataMaker;
import com.jingao.util.ToolUtil;

public class FieldValueManager implements Operator {

	@Override
	public void init() throws Exception {

		DefaultTableModel td = new DefaultTableModel(new DataMaker().getFiledConfigModel("select * from fieldconfig"),
				new String[] { "\u5B57\u6BB5\u540D", "\u5B57\u6BB5\u7C7B\u578B", "jira\u5B57\u6BB5",
						"jira\u5B57\u6BB5\u7C7B\u578B" });
		DataPool.fieldTypeModel = td; // 将数据缓存
		for (int i = 0; i < td.getRowCount(); i++) {
			if (td.getValueAt(i, 0) == null || td.getValueAt(i, 1) == null || td.getValueAt(i, 2) == null
					|| td.getValueAt(i, 3) == null) {
				continue;
			}
			DataPool.FieldTypeMap.put(td.getValueAt(i, 0).toString(), td.getValueAt(i, 2).toString());
		}
		if (td != null) {
			for (int row = 0; row < td.getRowCount(); row++) {
				String fieldName = (String) td.getValueAt(row, 0);
				DefaultTableModel model = new DataMaker().getFieldValueModel(fieldName);
				if (model != null) {
					DataPool.fieldValueModel.put(fieldName, model);
					DataPool.fieldValueMap.put(fieldName, ToolUtil.modelToMap(model));
				}
			}

		}
	}

}
