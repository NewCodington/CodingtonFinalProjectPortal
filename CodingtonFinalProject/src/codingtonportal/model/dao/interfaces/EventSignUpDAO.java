package codingtonportal.model.dao.interfaces;

import java.io.IOException;

import codingtonportal.model.domain.Event;

public interface EventSignUpDAO {
	public boolean insertEvent(Event event) throws IOException, ClassNotFoundException;
	public boolean deleteEvent(Event event) throws IOException, ClassNotFoundException;
	public boolean updateEvent(Event event) throws IOException, ClassNotFoundException;
}
