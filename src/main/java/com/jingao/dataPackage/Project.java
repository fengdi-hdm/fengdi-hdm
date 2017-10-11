package com.jingao.dataPackage;

/**
 * 
    * @ClassName: Project
    * @Description: TODO(项目)
    * @author Administrator
    * @date 2017年8月10日
    *
 */
public class Project {
	private String id;

	/**
	 * 
	     * 创建一个新的实例 Project.
	     *
	     * @param id
	 */
	public Project(String id){
		this.id = id;
	}
	
	/**
	 * 
	    * @Title: getId
	    * @Description: TODO(获得项目id)
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
	    * @Description: TODO(设置项目id)
	    * @param @param id    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void setId(String id) {
		this.id = id;
	}
}
