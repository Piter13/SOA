package pl.marganski.shopPoll.lab4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlSelectOneRadio;

@SessionScoped
@ManagedBean
public class PollBean {
	
	private String name, email, age, sex, degree, womenHeight, menHeight,
				   quest1, quest2, quest5, quest6, quest7, quest8;
	private int number;

	private List<String> quest3, quest4M, quest4W;
	private Map<String, String> degrees;
	
	private boolean subviewM, subviewW;
    private HtmlSelectOneRadio selectOneRadio;
	
	public PollBean() {
		degrees = new HashMap<String, String>();
		degrees.put("Podstawowe", "Podstawowe");
		degrees.put("Gimnazjalne", "Gimnazjalne");
		degrees.put("Zasadnicze", "Zasadnicze");
		degrees.put("Œrednie", "Œrednie");
		degrees.put("Wy¿sze", "Wy¿sze");
		this.subviewM = false;
        this.subviewW = false;
	}
		
	public Map<String, String> getDegrees() {
		return degrees;
	}

	public void setDegrees(Map<String, String> degrees) {
		this.degrees = degrees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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

	public void renderAdditionalQuestions(){
        if ("Male".equals(getSelectOneRadio().getValue().toString())){
            subviewM = true;
            subviewW = false;
        }
        else {
            subviewM = false;
            subviewW = true;
        }
    }
	
	public String sendData(){
        return "summary.xhtml";
    }
	 
    public int getNumber() {
        return number;
    }
 
    public void increment() {
        number++;
    }
	
}
