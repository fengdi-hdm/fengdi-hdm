package com.jingao.dataPackage;
/**
 * 
    * @ClassName: Select
    * @Description: TODO(下拉列表)
    * @author Administrator
    * @date 2017年8月10日
    *
 */
public class Select {
	private String id;
	
	/**
	 * 
	     * 创建一个新的实例 Select.
	     *
	     * @param id
	 */
	public Select(String id){
		this.id = id;
	}
/**
 * 
    * @Title: getId
    * @Description: TODO(获得下拉列表的id)
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
    * @Description: TODO(设置下拉列表值)
    * @param @param id    参数
    * @return void    返回类型
    * @throws
 */
	public void setId(String id) {
		this.id = id;
	}
}
