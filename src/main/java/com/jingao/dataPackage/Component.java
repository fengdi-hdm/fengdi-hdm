package com.jingao.dataPackage;

/**
 * 
    * @ClassName: Component
    * @Description: TODO(jira系统模块字段)
    * @author Administrator
    * @date 2017年8月10日
    *
 */
public class Component {
	private String id;

	/**
	 * 
	     * 创建一个新的实例 Component.
	     *
	     * @param id
	 */
	public Component(String id) {
		this.id = id;
	}

	/**
	 * 
	    * @Title: getId
	    * @Description: TODO(获得模块id)
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	    * @Title: setId
	    * @Description: TODO(设置模块id)
	    * @param @param id    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void setId(String id) {
		this.id = id;
	}
}
