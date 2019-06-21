package com.login.beans;

public class MemberBean {
	 // ���̵�, ��й�ȣ, �ּ�, ��ȭ�� ���� ������Ƽ(�ɹ�����)
    // ������Ƽ�� ���� ������ �� ���� private�� ����Ѵ�.
    private String id;
    private String pw;
    private String name;
    private String gender;
    private String email;
    private String college;
	private String hometown;
	private String age;
	private String height;	
	private String interesting;
	private String character;
	private int key;
    public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getInteresting() {
		return interesting;
	}
	public void setInteresting(String interesting) {
		this.interesting = interesting;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	/* �����͸� �������ų�(get), �����ϴ�(set)
    *  ����� �ϴ� �޼��带 �����.
    *  - �����͸� �������� ��� - get�޼���
    *  - �����͸� �����ϴ� ��� - set�޼���
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
