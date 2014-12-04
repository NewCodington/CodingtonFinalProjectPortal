package springcodingtonportal.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springcodingtonportal.model.domain.RegionPlace;


public class RegionPlaceMapper implements RowMapper<RegionPlace> {

		@Override
		public RegionPlace mapRow(ResultSet rs, int numRows) throws SQLException {
			RegionPlace regionPlace = new RegionPlace();
			
			// Complete the fields
			regionPlace.setIdRegionPlace(rs.getInt("idRegionPlace"));
			regionPlace.setName(rs.getString("Name"));
			regionPlace.setDescription(rs.getString("Description"));
			
			return regionPlace;
		}
	}
