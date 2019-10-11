package com.iu.accountinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class AccountInfoDAO {

	public long getAccountBalance(String accountNumber) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		long result = 0;

		conn = DBConnector.getConnect();
		String sql = "select * from account where accountnumber = ?";
		st = conn.prepareStatement(sql);
		st.setString(1, accountNumber);
		rs = st.executeQuery();
		if (rs.next())
			result = rs.getInt("accountbalance");
		rs.close();
		st.close();
		conn.close();
		return result;
	}
	public int updateBalance(AccountInfoDTO accountInfoDTO) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;

		conn = DBConnector.getConnect();
		String sql = "update account set accountbalance = ? where accountnumber = ? ";
		st = conn.prepareStatement(sql);
		st.setLong(1, accountInfoDTO.getAccountbalance());
		st.setString(2, accountInfoDTO.getAccountNumber());
		result = st.executeUpdate();
		st.close();
		conn.close();
		return result;
	}

	public int Remittance(int deposit, String yourAcNum, String myAcNum) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;

		conn = DBConnector.getConnect();
		String sql = "update account set accountbalance = accountbalance + ? where accountnumber = ? ";
		st = conn.prepareStatement(sql);
		st.setInt(1, deposit);
		st.setString(2, yourAcNum);
		st.executeUpdate();
		sql = "update account set accountbalance = accountbalance - ? where accountnumber = ? ";
		st = conn.prepareStatement(sql);
		st.setInt(1, deposit);
		st.setString(2, myAcNum);
		result = st.executeUpdate();
		st.close();
		conn.close();
		return result;
	}

	public ArrayList<AccountInfoDTO> incomeselect(String acNum) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<AccountInfoDTO> accountInfoDTOs = new ArrayList<AccountInfoDTO>();

		conn = DBConnector.getConnect();
		String sql = "select * from accountInfo where accountnumber = ? order by tradenumber asc";
		st = conn.prepareStatement(sql);
		st.setString(1, acNum);
		rs = st.executeQuery();
		while (rs.next()) {
			AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
			accountInfoDTO.setTradeNumber(rs.getLong("tradeNumber"));
			accountInfoDTO.setAccountNumber(rs.getString("accountNumber"));
			accountInfoDTO.setIncome(rs.getInt("income"));
			accountInfoDTO.setTradedate(rs.getDate("tradeDate"));
			accountInfoDTO.setAccountbalance(rs.getInt("accountBalance"));
			accountInfoDTO.setIncomeKind(rs.getInt("incomeKind"));
			accountInfoDTOs.add(accountInfoDTO);
		}
		rs.close();
		st.close();
		conn.close();
		return accountInfoDTOs;
	}

	public int income(AccountInfoDTO accountInfoDTO) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;

		conn = DBConnector.getConnect();
		String sql = "insert into accountInfo values(trade_seq.nextval,?,?,?,?,sysdate)";
		st = conn.prepareStatement(sql);
		st.setString(1, accountInfoDTO.getAccountNumber());
		st.setLong(2, accountInfoDTO.getIncome());
		st.setLong(3, accountInfoDTO.getAccountbalance());
		st.setInt(4, accountInfoDTO.getIncomeKind());
		result = st.executeUpdate();
		return result;
	}
}
