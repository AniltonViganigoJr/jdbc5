package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DB.getConnection();
			preparedStatement = conn.prepareStatement(
					"DELETE FROM seller "
				   +"WHERE "
				   +"BaseSalary = ?"
					);
			preparedStatement.setDouble(1, 4800.00);
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(preparedStatement);
			DB.closeConnection();
		}
	}
}