package com.ddit.spring.service;

import com.ddit.spring.vo.TestVO;

import java.util.List;

public interface TestService {
    // Get List
    List<TestVO> listTest();
    // Get One
    TestVO getTest(TestVO testVO);
    // insert
    int  insertTest(TestVO testVO);
    // update
    int  updateTest(TestVO testVO);
    // delete
    int  deleteTest(TestVO testVO);
}
