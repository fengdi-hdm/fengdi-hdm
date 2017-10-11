package com.jingao.dataPackage;

/**
 * 
    * @ClassName: Child
    * @Description: TODO(二级级联子字段)
    * @author Administrator
    * @date 2017年8月10日
    *
 */
public class Child {

	private String value;

	/**
	 * 
	     * 创建一个新的实例 Child.
	     *
	     * @param value
	 */
	public Child(String value) {
		this.value = value;
	}
/**
 * 
    * @Title: getValue
    * @Description: TODO(获得二级级联子字段值)
    * @param @return    参数
    * @return String    返回类型
    * @throws
 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	    * @Title: setValue
	    * @Description: TODO(设置二级级联子字段值)
	    * @param @param value    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
