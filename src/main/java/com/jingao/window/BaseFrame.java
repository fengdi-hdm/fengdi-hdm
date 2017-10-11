package com.jingao.window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.jingao.window.data.DataPool;

/**
 * 
 * @ClassName: BaseFrame
 * @Description: TODO(定义窗口的基本接口)
 * @author Fengdi
 * @date 2017年8月24日
 *
 */
public interface BaseFrame {
	public default void closeFrame(JFrame self) {
		self.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				DataPool.framSet.remove(self.getClass().getSimpleName());
			}
		});
	
	}

	public default void initFrame(JFrame self){
		DataPool.framSet.add(self.getClass().getSimpleName());
	}
}
