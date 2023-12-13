package hotel;

public class Suite extends Room {

	public Suite(int roomNumber) {
		this.setNumber(roomNumber);
		this.setNumberOfBeds(4);
		this.setHasMinibar(true);
		this.setRoomType(RoomType.SUITE);
	}
	
	public Suite(int roomNumber, int numberOfBeds, boolean isEmpty, boolean hasMinibar){
		this.setNumber(roomNumber);
		this.setNumberOfBeds(numberOfBeds);
		this.setEmpty(isEmpty);
		this.setHasMinibar(hasMinibar);
		this.setRoomType(RoomType.SUITE);
	}

}
