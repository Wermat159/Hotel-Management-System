package hotel;

public class Staff extends Person {

	private StaffRank staffRank;
	private double salary;

	public Staff(String name, StaffRank staffRank, double salary) {
		this.setName(name);
		this.staffRank = staffRank;
		this.salary = salary;
	}

	public Staff() {
	}

	public StaffRank getStaffRank() {
		return staffRank;
	}

	public void setStaffRank(StaffRank staffRank) {
		this.staffRank = staffRank;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
