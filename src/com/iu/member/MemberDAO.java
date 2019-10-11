package com.iu.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnector;

public class MemberDAO {

	public int memberJoin(MemberDTO memberDTO) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;
		conn = DBConnector.getConnect();
		String sql = "insert into member values (?,?,?,?,?)";
		st = conn.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		result = st.executeUpdate();

		st.close();
		conn.close();
		return result;
	}

	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		conn = DBConnector.getConnect();
		String sql = "select * from member where id = ? and pw = ?";
		st = conn.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		rs = st.executeQuery();
		if (rs.next()) {
			memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString("id"));
			memberDTO.setName(rs.getString("name"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));
		} else
			memberDTO = null;
		rs.close();
		st.close();
		conn.close();
		return memberDTO;

	}
}
