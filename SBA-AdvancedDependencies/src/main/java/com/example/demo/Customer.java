package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class Customer {

	// Marks id as the primary key.
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String firstName;
		private String lastName;

		protected Customer() {
		}

		public Customer(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

	//Returns a formatted string representation of the Customer object.
		@Override
		public String toString() {
			return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
		}

		public Long getId() {
			return id;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}
}
