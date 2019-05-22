package com.chenshinan.transaction.infra.utils;

import com.chenshinan.transaction.infra.config.ApplicationContextHelper;
import com.chenshinan.transaction.infra.mapper.ProjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author shinan.chen
 * @since 2019/5/22
 */
public class IssueNumUtil {
    private static final Map<Long, AtomicLong> issueNumMap = new HashMap<>();

    public static Long getNewIssueNum(Long projeceId) {
        AtomicLong atomicLong = issueNumMap.get(projeceId);
        if (atomicLong == null) {
            synchronized (IssueNumUtil.class) {
                atomicLong = issueNumMap.get(projeceId);
                if (atomicLong == null) {
                    ProjectMapper projectMapper = ApplicationContextHelper.getSpringFactory().getBean(ProjectMapper.class);
                    Long issueNum = projectMapper.selectByPrimaryKey(projeceId).getIssueMaxNum();
                    atomicLong = new AtomicLong(issueNum);
                    issueNumMap.put(projeceId, atomicLong);
                }
            }
        }
        return atomicLong.incrementAndGet();
    }
}
