package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnector;

public class AccountInfoDAO {
	public String AccountCheck(String yourAcNum) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String name = null;
		conn = DBConnector.getConnect();
		String sql = "select name from member where id = (select id from account where accountNumber = ?)";
		st = conn.prepareStatement(sql);
		st.setString(1, yourAcNum);
		rs = st.executeQuery();
		if (rs.next())
			name = rs.getString("name");
		return name;

	}

	public int income(int deposit, String yourAcNum, String myAcNum) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;

		conn = DBConnector.getConnect();
	/*	String sql = "update account set accountbalance = accountbalance + ? where accountnumber = ? ";
		st = conn.prepareStatement(sql);
		st.setInt(1, deposit);
		st.setString(2, yourAcNum);
		result = st.executeUpdate();
		sql = "update account set accountbalance = accountbalance - ? where accountnumber = ? ";
		st = conn.prepareStatement(sql);
		st.setInt(1, deposit);
		st.setString(2, myAcNum);
		result = st.executeUpdate();*/
		
		String sql = "insert into accountInfo values(trade_seq.nextval,?,?,?,?,sysdate)";
		st = conn.prepareStatement(sql);
		return result;
	}
}
