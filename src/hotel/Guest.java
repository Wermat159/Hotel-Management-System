package hotel;

public class Guest extends Person {

	private String arrivalDate; // YYYY-MM-DD
	private String leaveDate;
	private int roomNumber;
	private String address;
	private String contactNo;
	private Room room;
	private double invoice;

	public Guest() {
	}

	Guest(String name, String arrivalDate) {
		this.setName(name);
		this.arrivalDate = arrivalDate; // YYYY-MM-DD
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public int getRoomNumber(Room room) {
		return room.getNumber();
	}

	public void setRoomNumber(Room room) {
		this.roomNumber = room.getNumber();
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public double getInvoice() {
		return invoice;
	}

	public void setInvoice(double invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "ID: " + this.getId() + "   Name:" + this.getName() + "   Address:" + this.getAddress()
				+ "   Contact No:" + this.getContactNo() + "   Room Number:" + this.getRoomNumber() + "   Room Type: "
				+ this.getRoom().getRoomType() + "   Arrival Date:" + this.getArrivalDate() + "   Leave Date:"
				+ this.getLeaveDate() + "   Invoice:" + this.getInvoice();
	}

}
