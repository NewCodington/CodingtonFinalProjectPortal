package codingtonportal.model.services;

import java.io.IOException;

import codingtonportal.model.dao.interfaces.EventSignUpDAO;

public class EventSignUpImpl implements EventSignUpDAO {

	@Override
	public boolean registerForNewEvent(int idVisitor, int idEvent)
			throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unregisterForEvent(int idVisitor, int idEvent)
			throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchEvent(String Search) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean viewEvent() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return false;
	}

}
