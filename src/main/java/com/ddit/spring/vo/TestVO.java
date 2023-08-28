package com.ddit.spring.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class TestVO {
    private int testNum;
    private String testName;
    private String testContent;
    private String testFile;
    private MultipartFile testFile2;
}
