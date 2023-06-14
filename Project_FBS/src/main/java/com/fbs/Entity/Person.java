package com.fbs.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PERSON_ID")
	private int personId;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name="FIRST_NAME")
	private String firstName;

	private String gender;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="MIDDLE_NAME")
	private String middleName;

	@Column(name="MOBILE_NUMBER")
	private long mobileNumber;

	@Column(name="PASSPORT_NUMBER")
	private String passportNumber;

	@Column(name="PASSWORD_")
	private String password;

	private String title;

	//bi-directional many-to-one association to AddressDetail
	@OneToMany(mappedBy="person")
	private Set<AddressDetail> addressDetails;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="person")
	private Set<Booking> bookings;

	public Person() {
	}

	public int getPersonId() {
		return this.personId;
	}

	public Person(Date dateOfBirth, String emailAddress, String firstName, String gender, String lastName,
			String middleName, long mobileNumber, String passportNumber, String password, String title,
			Set<AddressDetail> addressDetails, Set<Booking> bookings) {
		super();
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.middleName = middleName;
		this.mobileNumber = mobileNumber;
		this.passportNumber = passportNumber;
		this.password = password;
		this.title = title;
		this.addressDetails = addressDetails;
		this.bookings = bookings;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public long getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassportNumber() {
		return this.passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<AddressDetail> getAddressDetails() {
		return this.addressDetails;
	}

	public void setAddressDetails(Set<AddressDetail> addressDetails) {
		this.addressDetails = addressDetails;
	}

	public AddressDetail addAddressDetail(AddressDetail addressDetail) {
		getAddressDetails().add(addressDetail);
		addressDetail.setPerson(this);

		return addressDetail;
	}

	public AddressDetail removeAddressDetail(AddressDetail addressDetail) {
		getAddressDetails().remove(addressDetail);
		addressDetail.setPerson(null);

		return addressDetail;
	}

	public Set<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setPerson(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setPerson(null);

		return booking;
	}
}
