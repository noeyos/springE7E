package com.ddit.spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ddit.spring.vo.TestVO;

@Mapper
public interface TestMapper {
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

