package springcodingtonportal.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springcodingtonportal.model.domain.EventSign;


public class EventSignUpMapper implements RowMapper<EventSign> {

		@Override
		public EventSign mapRow(ResultSet rs, int numRows) throws SQLException {
			EventSign eventSign = new EventSign();
			
			// Complete the fields
			eventSign.setId(rs.getInt("idEventRegistration"));
			eventSign.setIdEvent(rs.getInt("idEventR"));
			eventSign.setIdVisitor(rs.getInt("idVisitorR"));
			
			return eventSign;
		}
	}
