package hotel;

public class Singleroom extends Room{

	public Singleroom(int roomNumber) {
		this.setNumber(roomNumber);
		this.setNumberOfBeds(1);
		this.setHasMinibar(false);
		this.setRoomType(RoomType.SINGLEROOM);
	}
	
	public Singleroom(int roomNumber, int numberOfBeds, boolean isEmpty, boolean hasMinibar) {
		this.setNumber(roomNumber);
		this.setNumberOfBeds(numberOfBeds);
		this.setEmpty(isEmpty);
		this.setHasMinibar(hasMinibar);
		this.setRoomType(RoomType.SINGLEROOM);
	}
	
}
