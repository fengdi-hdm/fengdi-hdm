package com.jingao.dataPackage;

/**
 * 
    * @ClassName: IssueType
    * @Description: TODO(问题类型)
    * @author Administrator
    * @date 2017年8月10日
    *
 */
public class IssueType {
	private String id;
	
	/**
	 * 
	     * 创建一个新的实例 IssueType.
	     *
	     * @param id
	 */
	public IssueType(String id){
		this.id = id;
	}

	/**
	 * 
	    * @Title: getId
	    * @Description: TODO(获得问题类型id)
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
	    * @Description: TODO(设置问题类型id)
	    * @param @param id    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void setId(String id) {
		this.id = id;
	}
}
