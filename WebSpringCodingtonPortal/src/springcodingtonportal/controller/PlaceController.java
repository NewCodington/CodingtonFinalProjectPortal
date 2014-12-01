package springcodingtonportal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class PlaceController {
	@Autowired
	private ApplicationContext appContext;
	
	private static Logger log = Logger.getLogger(PlaceController.class);
}
