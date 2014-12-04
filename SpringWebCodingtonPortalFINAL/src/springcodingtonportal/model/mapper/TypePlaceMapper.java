package springcodingtonportal.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springcodingtonportal.model.domain.TypePlace;


public class TypePlaceMapper implements RowMapper<TypePlace> {

		@Override
		public TypePlace mapRow(ResultSet rs, int numRows) throws SQLException {
			TypePlace typePlace = new TypePlace();
			
			// Complete the fields
			typePlace.setIdTypePlace(rs.getInt("idTypePlace"));
			typePlace.setName(rs.getString("Name"));
			typePlace.setDescription(rs.getString("Description"));
			
			return typePlace;
		}
	}
