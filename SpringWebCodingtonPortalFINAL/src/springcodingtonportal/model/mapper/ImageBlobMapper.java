package springcodingtonportal.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springcodingtonportal.model.domain.Images;



public class ImageBlobMapper implements RowMapper<Images> {

		@Override
		public Images mapRow(ResultSet rs, int numRows) throws SQLException {
			Images outimage = new Images();
			
			// Complete the fields
			outimage.setImages(rs.getBinaryStream("image"));			
	
			return outimage;
		}
	}
