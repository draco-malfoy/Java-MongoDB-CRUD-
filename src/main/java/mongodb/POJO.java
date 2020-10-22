package mongodb;

public class POJO {
	private String name;
	private String rollNo;
	private Character gender;
	private String branch;

	public POJO(String name, String rollNo, Character gender, String branch) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.gender = gender;
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
