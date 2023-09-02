package com.ddit.spring.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@ToString
public class MyTestVO {
    private String name;
    private int age;
    private List<String> friends;
    private MultipartFile testFile;
}
