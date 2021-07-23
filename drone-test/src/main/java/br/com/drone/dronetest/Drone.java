package br.com.drone.dronetest;




public  class Drone  {
    
	public static String changePosition(String str) {
      
		
		Integer count1 	= 0;
		Integer count1a = 0;
	    Integer count2 	= 0;
	    Integer count2a = 0;
	    Integer countX  = 0;
	   	char contChar;
	   
			 for(int x=0; x<str.length(); x++) {
				 
				 //Localiza os caracteres e obtem a coordenada
		        contChar =str.charAt(x);
		        
		        
		        //Se for Norte
		        if(contChar=='N') {
		        	count1++;
		        }
		            
		       
		       //Se for Leste
		        if(contChar=='L') {
		        	count2++;
		        }
		        
		        
		        
		        if (contChar=='X') {
		       
		        	if(count1==3) {
		        		count1a= countX-2;
		        	}
		        	
		        	if(count2==3) {
		        		count2a= countX-1;
		        	}
		        }
			 }	
	    //Se a quantidade de caracteres for igual a 6		 
		if(str.length()==6)	{
			return count1+","+count2;
		}else {
			return count1a+","+count2a;
			
			
		}
			 
   
	}
         
}
