package com.pbarczewski.userFactory;
import com.pbarczewski.entity.Customer;
import com.pbarczewski.entity.RegularCustomer;
import com.pbarczewski.entity.UniqueCustomer;
import com.pbarczewski.entity.VipCustomer;


public interface CustomerFactory {
	 static Customer getInstance(String nickname, String pin) throws Exception {
		 	switch(pin) {
			case "9999":
				return new VipCustomer(nickname);
			case "0000":
				return new UniqueCustomer(nickname);
			case "":
				return new RegularCustomer(nickname);
			default:
				throw new Exception("Nie ma");
			}
		} 
	 }
