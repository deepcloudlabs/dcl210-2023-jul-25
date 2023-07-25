package com.example;

@SuppressWarnings("unused")
public class Exercise3 {

	public static void main(String[] args) {
		// Text Block """ """
		String jack = "{ fullname: \"jack bauer\", identity: \"11111111110\"} ";
		String kate = """
				   { 
				      fullname: "kate austen",
				      identity: "11111111120"
				   }
				   """.toUpperCase().concat( 
				   """ 
				   		
				   	"""
				 );
		String select = """
				SELECT CODE,NAME,POPULATION,SURFACEAREA
				FROM COUNTRY
				WHERE CONTINENT="ASIA"
				LIMIT 10,10 
				""";
		
	}

}
