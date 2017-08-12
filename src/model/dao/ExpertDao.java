package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import datasource.Database;
import model.dto.Expert;

public class ExpertDao {

	public boolean createExpert(Expert expert) {
		
		Connection conn=null;
		PreparedStatement pstm=null;
		String sql="INSERT INTO tb_expert("
				+ "name,"
				+ "gender,"
				+ "skill,"
				+ "country,"
				+ "personal_info)"
				+ "values(?,?,?,?,?)";
		try {
			conn=Database.getConnection();
			pstm=conn.prepareStatement(sql);
			
			pstm.setString(1, expert.getName());
			pstm.setString(2, expert.getGender());
			pstm.setString(3, expert.getSkill());
			pstm.setString(4, expert.getCountry());
			pstm.setString(5, expert.getPersonalInfo());
			
			int effectedRow=pstm.executeUpdate();
			if(effectedRow>0) return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return false;
	}
	
	public List<Expert> getExerts() {
			
			Connection conn=null;
			Statement stm=null;
			ResultSet rs=null;
			List<Expert> list=new ArrayList<>();
			String sql="SELECT * FROM tb_expert;";
			try {
				conn=Database.getConnection();
				stm=conn.createStatement();
				rs=stm.executeQuery(sql);
				while(rs.next()){
					list.add(new Expert(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("gender"),
							rs.getString("skill"),
							rs.getString("country"),
							rs.getString("personal_info")
							));
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					stm.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
			return list;
	}
	
}
