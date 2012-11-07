metispro-common
===============

<p>

This project is inteded to contain low level common classes used across Metispro features and fuctionality.

</p>

<p>

## Functional Components

	1. Registration
	2. Reservations
	3. Scheduling
	4. Memberships
	5. On-line Reservations
	6. Offsite backup and recovery


## Data Model

### Registration
	
	* Program
		* type (Class, League)  - String
		* name - String
		* description - String
		* session - Session
		* fee  - Double
		* account - String
		* signUpDeadline - java.util.Date
	* Session
		* name - String
		* beginDate - java.util.Date
		* endDate   - java.util.Date
	* Registration
		* program - Program
		* registrantName - String
		* registrantPhone - String
		* registrantAddr - String
		* size - String
		* age - int
		* memberId - long
		* amountPaid - Double
		* transferNum - int
	* School
	* Participant
		* name
		* address
		* phone
		* size
		* age
		* grade
		* balance
		* scholarship
		* membershipNum
	* Teacher
