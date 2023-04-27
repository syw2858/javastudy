
public class SubscriberInfo {
	String name, id, password;
	String phoneNo, address;

	SubscriberInfo() {} //생성자 식별의 기준은 파라미터
	SubscriberInfo(String name, String id, String password) { //생성자 이름 앞에는 return값 정의 안됨
		this.name = name; 
		this.id = id; 
		this.password = password; 
	}
	SubscriberInfo(String name, String id, String password, String phoneNo, String address) {
		this(name, id, password); 
		this.phoneNo = phoneNo;
		this.address = address;
	}
	void changePassword(String password) {
		this.password = password; 
	}
	void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	void setAddress(String address) {
		this.address = address;
	}
	
}
