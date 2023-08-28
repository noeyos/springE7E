package com.ddit.spring.service;

import com.ddit.spring.mapper.TestMapper;
import com.ddit.spring.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<TestVO> listTest() {
        return testMapper.listTest();
    }

    @Override
    public TestVO getTest(TestVO testVO) {
        return testMapper.getTest(testVO);
    }

    @Override
    public int insertTest(TestVO testVO) {
        return testMapper.insertTest(testVO);
    }

    @Override
    public int updateTest(TestVO testVO) {
        return testMapper.updateTest(testVO);
    }

    @Override
    public int deleteTest(TestVO testVO) {
        return testMapper.deleteTest(testVO);
    }
}
