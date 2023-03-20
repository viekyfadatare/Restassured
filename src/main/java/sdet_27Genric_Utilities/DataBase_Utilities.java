package sdet_27Genric_Utilities;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * This class Contains database utilities
 * 
 * @author admin
 *
 */
public class DataBase_Utilities {

	Connection con = null;

	// Step 1 registroe the databse
	// Step 2 get Connection with DB
	// Step 3 issue Create Statement
	// Step 4 Execute Query
	// Step 5 Close Connection

	public void connectDB() throws Throwable {

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IConstant.dbUrl, IConstant.dbUsername, IConstant.dbPassword);

	}

	/**
	 * this method is used to execute query and return data present in data base
	 * 
	 * @param query
	 * @param colomunIndex
	 * @param expData
	 * @return 
	 * @throws Throwable
	 */

	public String executeQueryAndgetData(String query, int colomunIndex, String expData) throws Throwable {
		boolean flag = false;

		ResultSet result = con.createStatement().executeQuery(query);

		while (result.next()) {
			String value = result.getString(colomunIndex);
			if (value.equalsIgnoreCase(expData)) {

				flag = true;
				break;
			}

		}
		if (flag) {
			System.out.println(expData+"  === data Is verified===");
			return expData; 
		}
		else {
			System.out.println(" dat is not present  " );
			return "";
		}
	}

	/**
	 * This methos is used to close the connection
	 * 
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		con.close();
	}

}
