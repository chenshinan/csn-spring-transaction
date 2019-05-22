package com.chenshinan.transaction.infra.mapper;

import com.chenshinan.transaction.domain.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author shinan.chen
 * @date 2018/8/8
 */
@Component
public interface ProjectMapper extends Mapper<Project> {
    void updateIssueMaxNum(@Param("projectId") Long projectId, @Param("issueMaxNum") Long issueMaxNum);
}
