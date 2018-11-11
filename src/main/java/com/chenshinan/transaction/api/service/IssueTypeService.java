package com.chenshinan.transaction.api.service;

import com.chenshinan.transaction.api.dto.IssueTypeDTO;

import java.util.List;

/**
 * @author shinan.chen
 * @Date 2018/8/8
 */
public interface IssueTypeService {

    IssueTypeDTO queryById(Long issueTypeId);

    IssueTypeDTO create(IssueTypeDTO issueTypeDTO);

    IssueTypeDTO clone(Long cloneId);
}
