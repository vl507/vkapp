package com.my.vk;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Users {
	private List<User> response;

	@JsonProperty("response")
	public List<User> getUsers() {
		return response;
	}

	public void setUsers(List<User> users) {
		this.response = users;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(response.toArray());
	}
	
	public static class User {
		
		public static class Country {
			private long id;
			private String title;
			
			public long getId() {
				return id;
			}
			public void setId(long id) {
				this.id = id;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			
			@Override
			public String toString() {
				return "Countrty: [title=" + this.title + "]";
			}

		}
		
		public static class City {
			private long id;
			private String title;
			
			public long getId() {
				return id;
			}
			public void setId(long id) {
				this.id = id;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			
			@Override
			public String toString() {
				return "Countrty: [title=" + this.title + "]";
			}

		}
		
		private long id;
		private String firstName, lastName, bdate;
		private City city;
		private Country country;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getBdate() {
			return bdate;
		}
		public void setBdate(String bdate) {
			this.bdate = bdate;
		}
		public City getCity() {
			return city;
		}
		public void setCity(City city) {
			this.city = city;
		}
		public Country getCountry() {
			return country;
		}
		public void setCountry(Country country) {
			this.country = country;
		}
		@JsonProperty("first_name")
		public String getFirstName() {
			return firstName;
		}
		public void setFirst_Name(String firstName) {
			this.firstName = firstName;
		}
		@JsonProperty("last_name")
		public String getLastName() {
			return lastName;
		}
		public void setLast_Name(String lastName) {
			this.lastName = lastName;
		}
		
		@Override
		public String toString() {
			return "User: [id=" + this.id + ", first name=" + this.firstName + 
					", last name=" + this.lastName + ", bdate=" + this.bdate +
					", city=" + this.city + ", country=" + this.country + "]";
		}

	}

}
