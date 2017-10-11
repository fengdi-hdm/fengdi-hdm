package com.jingao.dataBen;

import com.jingao.dataPackage.IssueType;
import com.jingao.dataPackage.Project;

public class CreateBean {
	private Project project;
	private IssueType issuetype;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public IssueType getIssuetype() {
		return issuetype;
	}

	public void setIssuetype(IssueType issuetype) {
		this.issuetype = issuetype;
	}
}
