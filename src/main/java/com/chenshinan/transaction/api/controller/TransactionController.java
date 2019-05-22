package com.chenshinan.transaction.api.controller;

import com.chenshinan.transaction.api.dto.IssueTypeDTO;
import com.chenshinan.transaction.api.service.IssueTypeService;
import com.chenshinan.transaction.api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author shinan.chen
 * @date 2018/11/07
 */
@RestController
@RequestMapping(value = "transaction")
public class TransactionController {

    @Autowired
    private IssueTypeService issueTypeService;
    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/queryById")
    public ResponseEntity<IssueTypeDTO> queryById(@RequestParam("id") Long id) {
        return new ResponseEntity<>(issueTypeService.queryById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<IssueTypeDTO> create(@RequestBody @Valid IssueTypeDTO issueTypeDTO) {
        return new ResponseEntity<>(issueTypeService.create(issueTypeDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/clone")
    public ResponseEntity<IssueTypeDTO> clone(@RequestParam("clone_id") Long cloneId) {
        return new ResponseEntity<>(issueTypeService.clone(cloneId), HttpStatus.OK);
    }

    @GetMapping(value = "/testCas")
    public ResponseEntity testCas() {
        projectService.testCas();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
