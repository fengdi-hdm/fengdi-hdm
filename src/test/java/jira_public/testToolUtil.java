package jira_public;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import com.jingao.util.ToolUtil;

public class testToolUtil {

	@Test
	public void test() {
		HashMap map = new HashMap();
		map.put("1", "1");
		map.put("2", "2");
		System.err.println((ToolUtil.mapToArray(map)).length);
	}

}
