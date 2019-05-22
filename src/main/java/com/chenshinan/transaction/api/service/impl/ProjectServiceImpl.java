package com.chenshinan.transaction.api.service.impl;

import com.chenshinan.transaction.api.service.ProjectService;
import com.chenshinan.transaction.infra.mapper.ProjectMapper;
import com.chenshinan.transaction.infra.utils.IssueNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shinan.chen
 * @Date 2019/5/22
 */
@Component
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public void testCas() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Long issueNum = IssueNumUtil.getNewIssueNum(1L);
                projectMapper.updateIssueMaxNum(1L, issueNum);
                System.out.println("现在issueNum是：" + issueNum);
            }).start();
        }
    }
}
