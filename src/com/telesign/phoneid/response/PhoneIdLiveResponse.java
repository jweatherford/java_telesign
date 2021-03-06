package com.telesign.phoneid.response;

import com.google.gson.Gson;


/**
 * Google GSON mapped class to represent a TeleSign JSON response to a 
 * PhoneId.live() request
 * 
 *	Copyright (c) TeleSign Corporation 2012.
 *	License: MIT
 *	Support email address "support@telesign.com"
 *	Author: jweatherford
 */
public class PhoneIdLiveResponse {
	public String reference_id;
	public String resource_uri;
	public String sub_resource;
	public Error[] errors;
	public PhoneType phone_type;
	public String signature_string;
	public Status status;
	public Numbering numbering;
	public Location location; 
	public Live live;
	
	public static class Error {
		public int code;
		public String description;
	}
	
	public static class PhoneType {
		public int code;
		public String description;
	}
	
	public static class Status {
		public String updated_on;
		public int code;
		public String description;
	}
	
	public static class Numbering {
		public OriginalNumber original;
		public CleansingNumber cleansing;
		
		public static class OriginalNumber {
			public String phone_number;
			public String complete_phone_number;
			public String country_code;
		}
	
		public static class CleansingNumber {
			public Number sms;
			public Number call;
			public static class Number {
				public String phone_number;
				public String country_code;
				public int min_length;
				public int max_length;
				public int cleansed_code;
			}
		}
	}
	
	public static class Location {
		public String county;
		public String city;
		public String state;
		public String zip;
		public Country country;
		public TimeZone time_zone;
		public Coordinates coordinates;
		public String metro_code;
		
		public static class Country {
			public String iso2;
			public String iso3;
			public String name;
		}
		
		public static class TimeZone {
			public String utc_offset_min;
			public String name;
			public String utc_offset_max;
		}
		
		public static class Coordinates {
			public double latitude;
			public double longitude;
		}
	}
	
	public static class Live {
		public String subscriber_status;
		public String device_status;
		public String roaming;
		public String roaming_country;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}