package com.cisco.la.common;

public class Util {
	public static String getDaysSentence(long delta){
		if(delta>0){
			long days = delta/(1000 * 60 * 60 * 24);
			if(days>1)
				return  String.format("is %d days away", days) ;
			else if(days==1)
				return "is 1 day away";
			else
				return "will start right now";
		}else{
			long days = Math.abs(delta)/(1000 * 60 * 60 * 24);
			if(days>1)
				return String.format("started %d days ago", days);
			else if(days == 1)
				return "started 1 day ago";
			else 
				return "started just now";
		}
	}
}
