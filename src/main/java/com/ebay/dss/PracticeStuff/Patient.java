package com.ebay.dss.PracticeStuff;

public class Patient {

	int Age;
	String gender;
	Patient(){

	}
	Patient(int pa_age, String pa_gender){
		this.Age = pa_age;
		this.gender = pa_gender;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 5;
		Patient[] pe = new Patient[5];
		Patient temp = new Patient(10,"Female");
		pe[0] = temp;
		Patient temp1 = new Patient(14,"Male");
		pe[1] = temp1;
		Patient temp2 = new Patient(135,"Female");
		pe[2] = temp2;
		
	}
	
	

}
