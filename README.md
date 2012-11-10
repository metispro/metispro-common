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
		* id - long
		* type (Class, League)  - String
		* name - String
		* description - String
		* session - Session
		* fee  - Double
		* account - String
		* signUpDeadline - java.util.Date
		
	* Session
		* id - long
		* name - String
		* beginDate - java.util.Date
		* endDate   - java.util.Date
		
	* Registration
		* id - long
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
		* id - long
		* name - String
		* addressLine1 - String
		* addressLine2 - String
		* city - String
		* state - String
		* zipcode - int
		
	* Participant
		* firstName - String
		* lastName - String
		* addressLine1 - String
		* addressLine2 - String
		* city - String
		* state - String
		* zipcode - int
		* phone - int
		* size - String
		* age - int
		* grade - String
		* balance - Double
		* scholarship (Y,N) - String
		* membershipId
		
	* ProgramLeader
		* id - long
		* type (Teacher, Coach, Director) - String
		* firstName - String
		* lastName - String
		* phone - int
		* addressLine1 - String
		* addressLine2 - String
		* city - String
		* state - String
		* zipcode - int

### General Ledger
	* Account
	* AccountsReceivable
	* AccountsPayable

### Reservations
	* Facility
		* id - long
		* type - String
		* name - String
		* description - String
		
	* Equipment
		* id - long
		* type - String
		* name - String
		* description - String

### Scheduling

### Memberships
	* Member
		* id - long
		* firstName - String
		* lastName - String
		* middleName - String
		* dateOfBirth - String
		* resAddressLine1 - String
		* resAddressLine2 - String
		* resCity - String
		* resState - String
		* resZipcode - int
		* resPhone - int
		* busAddressLine1 - String
		* busAddressLine2 - String
		* busCity - String
		* busState - String
		* busZipcode - int
		* busPhone - int
		* startDate - Date
		* expirationDate - Date
		* familyId - long
		
	* MembershipApplication
		* id - long
		* firstName - String
		* lastName - String
		* middleName - String
		* dateOfBirth - String
		* resAddressLine1 - String
		* resAddressLine2 - String
		* resCity - String
		* resState - String
		* resZipcode - int
		* resPhone - int
		* busAddressLine1 - String
		* busAddressLine2 - String
		* busCity - String
		* busState - String
		* busZipcode - int
		* busPhone - int
		* applicationDate - Date
		* familyId - long
		
	*ServiceApplication
		* id - long
		* membershipApplication - MembershipApplication
		* service - Service
		
	* Service
		* id - long
		* type - String
		* name - String
		* description - String

### Core