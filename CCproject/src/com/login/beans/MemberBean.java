package com.login.beans;

public class MemberBean {
	 // 아이디, 비밀번호, 주소, 전화를 담을 프로퍼티(맴버변수)
    // 프로퍼티에 직접 접근할 수 없게 private를 사용한다.
    private String id;
    private String pw;
    private String name;
    private String gender;
    private String email;
    
    /* 데이터를 가져오거나(get), 세팅하는(set)
    *  기능을 하는 메서드를 만든다.
    *  - 데이터를 가져오는 경우 - get메서드
    *  - 데이터를 세팅하는 경우 - set메서드
    */
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public String getGender() {
    	return gender;
    }
    public void setGender(String gender) {
    	this.gender = gender;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   
}
