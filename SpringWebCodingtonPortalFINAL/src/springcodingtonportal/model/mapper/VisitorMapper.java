package springcodingtonportal.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import springcodingtonportal.model.domain.Visitor;


public class VisitorMapper implements RowMapper<Visitor> {

		@Override
		public Visitor mapRow(ResultSet rs, int numRows) throws SQLException {
			Visitor visitor = new Visitor();
			
			visitor.setIdVisitor(rs.getInt("idVisitor"));
			visitor.setFirstName(rs.getString("First_name"));
			visitor.setLastName(rs.getString("Last_name"));
			visitor.setDni(rs.getString("DNI"));
			visitor.setEmail(rs.getString("Email"));
			visitor.setPhoneNumber(rs.getString("Phone_number"));
			visitor.setAddress(rs.getString("Address"));
			visitor.setUserName(rs.getString("Username"));
			visitor.setPassword(rs.getString("Password"));
			visitor.setAdmin(rs.getBoolean("isAdmin"));
			
			return visitor;
		}
	}
