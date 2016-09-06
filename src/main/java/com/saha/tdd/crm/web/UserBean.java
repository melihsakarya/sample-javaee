package com.saha.tdd.crm.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.saha.tdd.crm.entity.User;
import com.saha.tdd.crm.service.UserService;

@Named
@SessionScoped
public class UserBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private List<User> userList;
	
	@Inject UserService userService;
	
	public void save() throws Exception{
		boolean rtn = userService.save(user);
		if(rtn){
			user = new User();
			updateList();
			addMessage("Kayit basari ile yapildi..");
		}
		else{
			addMessage("Kayit yapilamadi..");
		}
	}
	
	public void addMessage(String mesaj){
		try {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mesaj));
		} catch (Exception e) {
		}
	}
	
	public void remove(User user) throws Exception{
		boolean sonuc = userService.remove(user);
		if(sonuc){
			addMessage("Silme basari ile yapildi...");
			updateList();
		}
		else{
			addMessage("Silme yapilamadi...");
		}
		
	}
	
	public void select(User user){
		this.user = user;
	}
	
	public void update() throws Exception{
		boolean rtn = userService.update(user);
		if(rtn){
			addMessage("Duzenleme basari ile yapildi...");
			updateList();
		}
		else{
			addMessage("Duzenleme isleminde hata olustu...");
		}
		this.user = new User();
	}
	
	@PostConstruct
	public void updateList(){
		setUserList(userService.list());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	
	
	
}
