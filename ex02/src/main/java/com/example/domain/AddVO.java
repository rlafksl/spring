package com.example.domain;

public class AddVO {

	private int ano;
	private String name;
	private String addr;
	private String tel;
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "AddVO [ano=" + ano + ", name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}
	
}
