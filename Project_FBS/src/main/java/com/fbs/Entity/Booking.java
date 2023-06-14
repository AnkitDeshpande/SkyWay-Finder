package com.fbs.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BOOKING_ID")
	private int bookingId;

	@Column(name="BOOKING_DATE")
	private Timestamp bookingDate;

	@Column(name="BOOKING_NUMBER")
	private String bookingNumber;

	@Column(name="SEAT_CLASS")
	private String seatClass;

	@Column(name="SEATS_BOOKED")
	private int seatsBooked;

	@Column(name="TOTAL_COST")
	private int totalCost;

	@Temporal(TemporalType.DATE)
	@Column(name="TRAVEL_DATE")
	private Date travelDate;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="BOOKING_DONE_BY")
	private Person person;

	//bi-directional many-to-one association to FlightMaster
	@ManyToOne
	@JoinColumn(name="FLIGHT_MASTER_ID")
	private Flight flightMaster;

	//bi-directional many-to-one association to Passenger
	@OneToMany(mappedBy="booking")
	private List<Passenger> passengers;

	public Booking() {
	}

	public int getBookingId() {
		return this.bookingId;
	}

	public Booking(Timestamp bookingDate, String bookingNumber, String seatClass, int seatsBooked,
			int totalCost, Date travelDate, Person person, Flight flightMaster, List<Passenger> passengers) {
		super();
		this.bookingDate = bookingDate;
		this.bookingNumber = bookingNumber;
		this.seatClass = seatClass;
		this.seatsBooked = seatsBooked;
		this.totalCost = totalCost;
		this.travelDate = travelDate;
		this.person = person;
		this.flightMaster = flightMaster;
		this.passengers = passengers;
	}
	
	public Timestamp getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingNumber() {
		return this.bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public String getSeatClass() {
		return this.seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public int getSeatsBooked() {
		return this.seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public int getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public Date getTravelDate() {
		return this.travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Flight getFlightMaster() {
		return this.flightMaster;
	}

	public void setFlightMaster(Flight flightMaster) {
		this.flightMaster = flightMaster;
	}

	public List<Passenger> getPassengers() {
		return this.passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Passenger addPassenger(Passenger passenger) {
		getPassengers().add(passenger);
		passenger.setBooking(this);

		return passenger;
	}

	public Passenger removePassenger(Passenger passenger) {
		getPassengers().remove(passenger);
		passenger.setBooking(null);

		return passenger;
	}

}
