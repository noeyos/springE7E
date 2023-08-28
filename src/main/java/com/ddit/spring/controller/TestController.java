package com.ddit.spring.controller;

import com.ddit.spring.service.TestService;
import com.ddit.spring.vo.TestVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController // ResponseBody와 controller의 합작
public class TestController {

    @Autowired  // 서비스를 호출하기 위함
    private TestService testService;

    @GetMapping("/rest/test")
    public List<TestVO> getList() {
        return testService.listTest();
    }

    @GetMapping("/rest/test/{num}")
    public TestVO getTest(@PathVariable int num) {
        TestVO testVO = new TestVO();
        testVO.setTestNum(num);
        return testService.getTest(testVO);
    }

//    @PostMapping("/rest/test")
//    public String insertTest(@RequestBody TestVO testVO) {
//                            //@RequestBody는 json 문자열 올 때만
//        return Integer.toString(testService.insertTest(testVO));
//    }

    @PostMapping("/rest/test")
    public String insertHam(TestVO testVO) throws IOException {

        String testFile = "/kmerong/" + testVO.getTestFile2().getOriginalFilename();
        testVO.setTestFile(testFile);
        String savePath = "/Users/soyeonlee/Dev/test-folder/upload/" + testVO.getTestFile2().getOriginalFilename();
        testVO.getTestFile2().transferTo(new File(savePath));

        log.debug("testVO: " + testVO);

        return Integer.toString(testService.insertTest(testVO));
    }

    @PutMapping("/rest/test")
    public String updateTest(@RequestBody TestVO testVO) {
        return Integer.toString(testService.updateTest(testVO));
    }



    @DeleteMapping("/rest/test/{num}")
    public String deleteTest(@PathVariable int num) {
        TestVO testVO = new TestVO();
        testVO.setTestNum(num);
        return Integer.toString(testService.deleteTest(testVO));
    }

    @PostMapping("/rest/test2")
    public String insertFile(MultipartFile myFile) throws IOException {
                            // RequestBody 붙이지 않는다.
                            // html에서 formData에 먹인 이름으로 매개변수명 지정
        log.debug("originalName : {}", myFile.getOriginalFilename());
        log.debug("fileSize : {}", String.valueOf(myFile.getSize()));
        // 디버그는 문자열이기 때문에, size 받아온 건 숫자열이여서 string으로 바꿔줘야 함

        // 물리적 파일 저장 디렉토리
        String savePath = "/Users/soyeonlee/Dev/test-folder/upload/" + myFile.getOriginalFilename();
        myFile.transferTo(new File(savePath));

        // savePath에 해당하는 웹 경로
        String webURL = "/kmerong/" + myFile.getOriginalFilename();

        return webURL;
    }

}
