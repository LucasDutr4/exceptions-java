package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer romNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer romNumber, Date checkIn, Date checkOut) {
		this.romNumber = romNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRomNumber() {
		return romNumber;
	}

	public void setRomNumber(Integer romNumber) {
		this.romNumber = romNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " + romNumber + ", check-in: " + sdf.format(checkIn) 
		+ ", check-out: " + sdf.format(checkOut) + ", " + duration() + " nights"; 
	}
	
}
