package hotel;

public class Room {

	private int number;
	private boolean isEmpty;
	private int numberOfBeds;
	private boolean hasMinibar;
	private RoomType roomType;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public boolean hasMinibar() {
		return hasMinibar;
	}

	public void setHasMinibar(boolean hasMinibar) {
		this.hasMinibar = hasMinibar;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "Room Number: " + this.getNumber() + "   Number of Beds: " + this.getNumberOfBeds() + "   Has minibar: "
				+ ((this.hasMinibar() == true) ? "Yes" : "No") + "   Available: "
				+ ((this.isEmpty() == true) ? "Yes" : "No") + "   Room Type: " + this.getRoomType();
	}
	
}
