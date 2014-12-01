package springcodingtonportal.utils;

import org.apache.log4j.Logger;


public class Exceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8500734602112482570L;
	
	//LOGGER to handle custom exceptions
	private static Logger log = Logger.getLogger(Exceptions.class);
	
	public Exceptions(String message, Throwable object)
	{
		super(message,object);
		log.info("Exception Message is :"+message);
	}
}
