package com.chenshinan.transaction.infra.mapper;

import com.chenshinan.transaction.domain.IssueType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author shinan.chen
 * @date 2018/8/8
 */
@Component
public interface IssueTypeMapper extends Mapper<IssueType> {
    List<IssueType> fulltextSearch(@Param("issueType") IssueType issueType, @Param("param") String param);
}
