package com.chenshinan.transaction.api.service.impl;

import com.chenshinan.transaction.api.dto.IssueTypeDTO;
import com.chenshinan.transaction.api.service.IssueTypeService;
import com.chenshinan.transaction.domain.IssueType;
import com.chenshinan.transaction.infra.exception.CsnException;
import com.chenshinan.transaction.infra.mapper.IssueTypeMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author shinan.chen
 * @Date 2018/8/8
 */
@Component
public class IssueTypeTransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IssueTypeTransactionService.class);

    @Autowired
    private IssueTypeMapper issueTypeMapper;
    @Autowired
    private PlatformTransactionManager transactionManager;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
    public IssueTypeDTO queryById(Long issueTypeId) {
        IssueType issueType = issueTypeMapper.selectByPrimaryKey(issueTypeId);
        if (issueType != null) {
            return modelMapper.map(issueType, IssueTypeDTO.class);
        }else{
            throw new CsnException("error.queryById.notFound");
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public IssueTypeDTO create(IssueTypeDTO issueTypeDTO) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        //事物隔离级别：开启新事务
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        //获得事务状态
        TransactionStatus transactionStatus = transactionManager.getTransaction(def);
        IssueType issueType = modelMapper.map(issueTypeDTO, IssueType.class);
        try {
            if (issueTypeMapper.insert(issueType) != 1) {
                throw new CsnException("error.issueType.create");
            }
            transactionManager.commit(transactionStatus);
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            e.printStackTrace();
            throw new CsnException("error.issueType.create");
        }
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return queryById(issueType.getId());
    }
}
