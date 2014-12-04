package springcodingtonportal.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.jdbc.core.RowMapper;

import springcodingtonportal.model.domain.Event;


public class EventMapper implements RowMapper<Event> {

		@Override
		public Event mapRow(ResultSet rs, int numRows) throws SQLException {
			Event event = new Event();
			
			// Complete the fields
			event.setEventId(rs.getInt("idEvent"));
			event.setName(rs.getString("Name"));
			event.setDescription(rs.getString("Description"));
			event.setPlace(rs.getInt("Place"));
			try {
				event.setDate_event(rs.getDate("Date_event"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			event.setStartTime(rs.getString("StartTime"));
			event.setDuration(rs.getString("Duration"));
			event.setEventType(rs.getString("Event_type"));
			event.setSeatsAvailable(rs.getInt("Seats_available"));
			
			return event;
		}
	}
