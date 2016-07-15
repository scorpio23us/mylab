package com.retailer.pricingservice.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.retailer.pricingservice.ProductPrice;

@Path("/pricing")
public class PricingService {

	@POST
	@Path("/getprice")
	@Produces(MediaType.TEXT_PLAIN)
	public String getPriceOfProduct(String barcodeid) throws Exception {
		ProductPrice price = new ProductPrice();
		return (price.getPrice(Integer.parseInt(barcodeid))).toPlainString();
	}

	public static void main(String[] args) {
	    //this variable holds XOR of all the elements which have appeared "only" once.
	    int ones = 0 ;
	    //this variable holds XOR of all the elements which have appeared "only" twice.
	    int twos = 0 ;
	    int not_threes ;
	    int arr[] = {2, 10, 10, 3, 1, 1, 10, 1, 3, 3};

	    for( int x : arr ) {

	        twos |= ones & x ; //add it to twos if it exists in ones
	        ones ^= x ; //if it exists in ones, remove, otherwise, add it
	        // Next 3 lines of code just converts the common 1's between "ones" and "twos" to zero.

	        //if x is in ones and twos, dont add it to Threes.
	        not_threes = ~(ones & twos) ;
	        ones &= not_threes ;//remove x from ones
	        twos &= not_threes ;//remove x from twos
	    }

	    //System.out.println(ones);
	    //findUnique();
        System.out.println(isPrimeNumber(1221));
	    //System.out.println(fibonacci(8));
	    //System.out.println(gcd(24,32));
	    
    }	
	
	static int gcd(int a, int b) {
	  if(a == 0 || b == 0) 
		  return a + b;
	  return gcd(b, a%b);
	}

	static boolean isPrimeNumber(int number){
        for(int i=2; i<=number/2; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

	public static int fibonacci(int number){ 
		if(number == 1 || number == 2) {
			return 1; 
		} 
		return fibonacci(number-1) + fibonacci(number - 2); 
	}

	static void findUnique() {

		HashMap<Integer, Integer> hm = new HashMap<>();

		int arr[] = {10, 10, 23, 1, 10, 3, 10, 1, 1, 2, 3, 3};

	    for( int x : arr ) {
	    	if(hm.containsKey(x)) {
	    		hm.put(x, (hm.get(x) + 1) );
	    	} else {
	    	    hm.put(x, 1);
	    	}
	    	System.out.println(x+" = "+hm.get(x)+" = "+hm.size());
	    }
	}
}
