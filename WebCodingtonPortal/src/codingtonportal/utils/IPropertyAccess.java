package codingtonportal.utils;

import java.io.IOException;


public interface IPropertyAccess {
	public abstract String getProperty(String property) throws IOException;
	public abstract String getConstant(String constant) throws IOException;
}
