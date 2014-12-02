package springcodingtonportal.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springcodingtonportal.model.domain.Place;


public class PlaceMapper implements RowMapper<Place> {

		@Override
		public Place mapRow(ResultSet rs, int numRows) throws SQLException {
			Place place = new Place();
			
			place.setIdPlace(rs.getInt("idPlace"));
			place.setName(rs.getString("Name"));
			place.setTypePlace(rs.getInt("TypePlace"));
			//place.setImage(rs.getBlob("Image"));
			place.setAddress(rs.getString("Address"));
			place.setDescription(rs.getString("Description"));
			
			return place;
		}
	}
