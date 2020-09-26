public class Employee implements DepartmentConstants, Displayable {

	private int department;
	private String firstName;
	private String lastName;

	public Employee(int department, String lastName, String firstName) {
		this.department = department;
		this.lastName = lastName;
		this.firstName = firstName;
	}

//	@Override
//	public String getDisplayText() {
//		if (this.department == ADMIN) {
//			return firstName + " " + lastName + " (Admin)";
//		} else if (this.department == EDITORIAL) {
//			return firstName + " " + lastName + " (Editorial)";
//		} else if (this.department == MARKETING) {
//			return firstName + " " + lastName + " (Marketing)";
//		} else {
//			return "Unknown";
//		}

	@Override
	public String toString() {
		if (this.department == ADMIN) {
			return firstName + " " + lastName + " (Admin)";
		} else if (this.department == EDITORIAL) {
			return firstName + " " + lastName + " (Editorial)";
		} else if (this.department == MARKETING) {
			return firstName + " " + lastName + " (Marketing)";
		} else {
			return "Unknown";
		}
	}

}