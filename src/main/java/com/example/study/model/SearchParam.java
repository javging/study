package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchParam {
  private String account;
  private String email;
  private int page;

  // {"account": "abcd", "email":"study@gmail.com", "page":1}

  // public String getAccount() {
  // return account;
  // }

  // public void setAccount(String account) {
  // this.account = account;
  // }

  // public String getEmail() {
  // return email;
  // }

  // public void setEmail(String email) {
  // this.email = email;
  // }

  // public int getPage() {
  // return page;
  // }

  // public void setPage(int page) {
  // this.page = page;
  // }

}
