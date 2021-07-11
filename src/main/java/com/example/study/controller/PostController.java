package com.example.study.controller;

import com.example.study.model.SearchParam;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

  // json, xml, multipart, text-plain ...
  // @PostMapping(value = "/postMethod", produces = {"application-json"})
  // 어떤 형식의 데이터를 받을지 produces 에 지정해줄 수 있음

  // Rest 개념에서는 주로 create 할 때 사용
  @PostMapping("/postMethod")
  public SearchParam postMethod(@RequestBody SearchParam searchParam) {
    return searchParam;
  }

  // Rest 개념에서는 주로 update(혹은 create) 할 때 사용
  @PutMapping("/user")
  public void put() {
  }

  // Rest 개념에서는 주로 update 할 때 사용
  @PatchMapping("/user")
  public void patch() {
  }
}
