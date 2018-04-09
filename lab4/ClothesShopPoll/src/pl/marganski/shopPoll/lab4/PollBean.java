package pl.marganski.shopPoll.lab4;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlSelectOneRadio;

@SessionScoped
@ManagedBean
public class PollBean {

	private int number;
	private String name, email, age, sex, degree, womenHeight, menHeight, quest1, quest2, quest5, quest6, quest7,
			quest8;

	private List<String> quest3, quest4M, quest4W;
	private List<String> degrees;

	private boolean subviewM, subviewW;
	private HtmlSelectOneRadio selectOneRadio;

	public PollBean() {
		degrees = new ArrayList<String>();
		degrees.add("Podstawowe");
		degrees.add("Gimnazjalne");
		degrees.add("Zasadnicze");
		degrees.add("Œrednie");
		degrees.add("Wy¿sze");
		this.subviewM = false;
		this.subviewW = false;
	}

	public void renderAdditionalQuestions() {
		if ("Male".equals(getSelectOneRadio().getValue().toString())) {
			subviewM = true;
			subviewW = false;
		} else {
			subviewM = false;
			subviewW = true;
		}
	}

	public String sendData() {
		return "summary.xhtml";
	}

	public void increment() {
		number++;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getWomenHeight() {
		return womenHeight;
	}

	public void setWomenHeight(String womenHeight) {
		this.womenHeight = womenHeight;
	}

	public String getMenHeight() {
		return menHeight;
	}

	public void setMenHeight(String menHeight) {
		this.menHeight = menHeight;
	}

	public String getQuest1() {
		return quest1;
	}

	public void setQuest1(String quest1) {
		this.quest1 = quest1;
	}

	public String getQuest2() {
		return quest2;
	}

	public void setQuest2(String quest2) {
		this.quest2 = quest2;
	}

	public String getQuest5() {
		return quest5;
	}

	public void setQuest5(String quest5) {
		this.quest5 = quest5;
	}

	public String getQuest6() {
		return quest6;
	}

	public void setQuest6(String quest6) {
		this.quest6 = quest6;
	}

	public String getQuest7() {
		return quest7;
	}

	public void setQuest7(String quest7) {
		this.quest7 = quest7;
	}

	public String getQuest8() {
		return quest8;
	}

	public void setQuest8(String quest8) {
		this.quest8 = quest8;
	}

	public List<String> getQuest3() {
		return quest3;
	}

	public void setQuest3(List<String> quest3) {
		this.quest3 = quest3;
	}

	public List<String> getQuest4M() {
		return quest4M;
	}

	public void setQuest4M(List<String> quest4m) {
		quest4M = quest4m;
	}

	public List<String> getQuest4W() {
		return quest4W;
	}

	public void setQuest4W(List<String> quest4w) {
		quest4W = quest4w;
	}

	public List<String> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<String> degrees) {
		this.degrees = degrees;
	}

	public boolean isSubviewM() {
		return subviewM;
	}

	public void setSubviewM(boolean subviewM) {
		this.subviewM = subviewM;
	}

	public boolean isSubviewW() {
		return subviewW;
	}

	public void setSubviewW(boolean subviewW) {
		this.subviewW = subviewW;
	}

	public HtmlSelectOneRadio getSelectOneRadio() {
		return selectOneRadio;
	}

	public void setSelectOneRadio(HtmlSelectOneRadio selectOneRadio) {
		this.selectOneRadio = selectOneRadio;
	}

}
