package hello.hellospirng.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//@Column(name = "컬럼명") // 컬럼명이 다를경우 해당 문법으로 매핑 가능
	private String name;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
