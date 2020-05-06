package org.cap.util;

import org.cap.exception.*;

public class MovieValidation {


	public static void validateId(int id) {
		String str=Integer.toString(id);
		if(str.length()<4)
			throw new IncorrectArgumentException("Id cannot be less than 1");

		else {
			if(str.charAt(0)!='3')
				throw new IncorrectArgumentException("Id should start with 3");
		}
	}

}