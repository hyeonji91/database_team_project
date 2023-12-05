package utile;

public class UserStruct {
	private String user_id, name, password, birth, gender, phone_number, address;
	
	public UserStruct(String user_id, String name, String password, String birth, String gender, String phone_number, String address){
		this.user_id=user_id;
		this.name=name;
		this.password=password;
		this.birth=birth;
		this.gender=gender;
		this.phone_number=phone_number;
		this.address=address;
	}

	public String getUser_id() {
		return user_id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getBirth() {
		return birth;
	}
	public String getGender() {
		return gender;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public String getAddress() {
		return address;
	}
}