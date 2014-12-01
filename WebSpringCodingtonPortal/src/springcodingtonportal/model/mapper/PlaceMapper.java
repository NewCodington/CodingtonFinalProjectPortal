package springcodingtonportal.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springcodingtonportal.model.domain.Place;


public class PlaceMapper implements RowMapper<Place> {

		@Override
		public Place mapRow(ResultSet rs, int numRows) throws SQLException {
			Place event = new Place();
			
			event.setIdPlace(rs.getInt("idPlace"));
			event.setName(rs.getString("Name"));
			event.setTypePlace(rs.getInt("TypePlace"));
			//event.setImage(rs.getBlob("Image"));
			event.setAddress(rs.getString("Address"));
			event.setDescription(rs.getString("Description"));
			
			return event;
		}
	}
