package com.example.study.controller;

import com.example.study.model.SearchParam;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class GetController {
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // localhost:8080/api/getMethod
    public String getRequest() {
        return "Hi, getMethod!";
    }

    @GetMapping("/getParameter") // localhost:8080/api/getParameter?id=1234&password=abcd
    // public String getParameter(String id, String password) { // @annotation 없어도
    // 되긴 함,,
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
        // request 주소창에 이름과 함수안에서 변수이름 다르게 지정할 수 있음,,
        String password = "abcd";

        System.out.println(id);
        System.out.println(pwd);
        System.out.println(password);

        return id + pwd;
    }

    // localhost:8080/api/multiParameter?account=1234&email=study@gmail.com&page=1
    @GetMapping("/multiParameter")
    // public String multiParameter(@RequestParam String account,
    // @RequestParam String email,
    // @RequestParam int page) {
    // 이런식으로 param개수가 많아지면 그걸 일일이 다 받아오도록 적어주는게 힘들 수 있음,,
    // 그럴 때 객체로도 받을 수 있음.

    // public String multiParameter(SearchParam searchParam) {
    public SearchParam multiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());
        // return "aaa";

        // json 형태로 내보내고 싶으면 그냥 객체 리턴하면 됨. spring boot에서 알아서 해줌
        // {"account": "abcd", "email":"study@gmail.com", "page":1}
        return searchParam;
    }
}
