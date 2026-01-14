package gson;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 3287943927434L;

	private String kaptCode;
	private String kaptName;
	private String bjdCode;
	private String as1;
	private String as2;
	private String as3;
	private String as4;

	public Item() {
	}

	public Item(String kaptCode, String kaptName, String bjdCode, String as1, String as2, String as3, String as4) {
		super();
		this.kaptCode = kaptCode;
		this.kaptName = kaptName;
		this.bjdCode = bjdCode;
		this.as1 = as1;
		this.as2 = as2;
		this.as3 = as3;
		this.as4 = as4;
	}

	public String getKaptCode() {
		return kaptCode;
	}

	public void setKaptCode(String kaptCode) {
		this.kaptCode = kaptCode;
	}

	public String getKaptName() {
		return kaptName;
	}

	public void setKaptName(String kaptName) {
		this.kaptName = kaptName;
	}

	public String getBjdCode() {
		return bjdCode;
	}

	public void setBjdCode(String bjdCode) {
		this.bjdCode = bjdCode;
	}

	public String getAs1() {
		return as1;
	}

	public void setAs1(String as1) {
		this.as1 = as1;
	}

	public String getAs2() {
		return as2;
	}

	public void setAs2(String as2) {
		this.as2 = as2;
	}

	public String getAs3() {
		return as3;
	}

	public void setAs3(String as3) {
		this.as3 = as3;
	}

	public String getAs4() {
		return as4;
	}

	public void setAs4(String as4) {
		this.as4 = as4;
	}

	@Override
	public String toString() {
		return "Item [kaptCode=" + kaptCode + ", kaptName=" + kaptName + ", bjdCode=" + bjdCode + ", as1=" + as1
				+ ", as2=" + as2 + ", as3=" + as3 + ", as4=" + as4 + "]";
	}

}
