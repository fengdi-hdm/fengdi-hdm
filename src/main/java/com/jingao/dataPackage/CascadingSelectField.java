package com.jingao.dataPackage;
/**
 * 
    * @ClassName: CascadingSelectField
    * @Description: TODO(二级级联字段)
    * @author Administrator
    * @date 2017年8月10日
    *
 */
public class CascadingSelectField {
	private String value;
	private Child child;
	/**
	 * 
	     * 创建一个新的实例 CascadingSelectField.
	     *
	     * @param parent
	     * @param child
	 */
	public CascadingSelectField(String parent,String child){
		this.value = parent;
		this.child = new Child(child);
	}
	/**
	 * 
	    * @Title: getValue
	    * @Description: TODO(获得父级字段值)
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
	    * @Description: TODO(设置父级字段值)
	    * @param @param value    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 
	    * @Title: getChild
	    * @Description: TODO(获得子字段)
	    * @param @return    参数
	    * @return Child    返回类型
	    * @throws
	 */
	public Child getChild() {
		return child;
	}
	/**
	 * 
	    * @Title: setChild
	    * @Description: TODO(设置子字段)
	    * @param @param child    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void setChild(Child child) {
		this.child = child;
	}
}
