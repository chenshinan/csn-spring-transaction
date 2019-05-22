package com.chenshinan.transaction.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shinan.chen
 * @date 2019/5/22
 */
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Mysql")
    private Long projectId;

    private String projectCode;
    private Long issueMaxNum;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Long getIssueMaxNum() {
        return issueMaxNum;
    }

    public void setIssueMaxNum(Long issueMaxNum) {
        this.issueMaxNum = issueMaxNum;
    }
}
