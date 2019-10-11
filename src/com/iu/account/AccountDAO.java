package com.iu.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.iu.util.DBConnector;

public class AccountDAO {
	


	public int accountCreate(AccountDTO accountDTO) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		//ResultSet rs = null;
		int result = 0;

		conn = DBConnector.getConnect();
		String sql = "insert into account values (?,?,0,?)";
		st = conn.prepareStatement(sql);
		st.setString(1, accountDTO.getAccountNumber());
		st.setString(2, accountDTO.getAccountName());
		st.setString(3, accountDTO.getId());
		result = st.executeUpdate();
		return result;
	}
	
	public List<AccountDTO> accountFind(String id) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		AccountDTO accountDTO = null;
		ArrayList<AccountDTO> accountDTOs =new ArrayList<AccountDTO>();
		
		conn = DBConnector.getConnect();
		String sql = "select * from account where id = ?";
		st = conn.prepareStatement(sql);
		st.setString(1, id);
		rs = st.executeQuery();
		while(rs.next()) {
			accountDTO = new AccountDTO();
			accountDTO.setAccountNumber(rs.getString("accountNumber"));
			accountDTO.setAccountName(rs.getString("accountName"));
			accountDTO.setAccountBalance(rs.getLong("accountBalance"));
			accountDTOs.add(accountDTO);
		}
		return accountDTOs;
		
		
	}


}
