package kr.co.trinity.vo;

public class Customer {
	private String userId;
	private String password;
	private String userName;
	private int age;
	private String email;
	private String role;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String userId, String password, String userName, int age,
			String email, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.age = age;
		this.email = email;
		this.role=role;
	}
	
	public Customer(String userId, String password, String userName, int age,
			String email) {
		this(userId, password, userName, age, email, "user");
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", password=" + password
				+ ", userName=" + userName + ", age=" + age + ", email="
				+ email + "]";
	}

}
