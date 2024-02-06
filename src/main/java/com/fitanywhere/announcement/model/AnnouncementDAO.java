package com.fitanywhere.announcement.model;

import java.util.*;

import org.springframework.context.ApplicationContext;

import java.sql.*;

public class AnnouncementDAO implements AnnouncementDAO_interface{
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/fitanywhere?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";
	
	private static final String INSERT_STMT = 
			"INSERT INTO announcement(cr_id, an_date, an_edit_date, an_title, an_content) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT an_id, cr_id, an_date, an_edit_date, an_title, an_content FROM announcement order by an_id";
		private static final String GET_ONE_STMT = 
			"SELECT an_id, cr_id, an_date, an_edit_date, an_title, an_content FROM announcement where an_id = ?";
		private static final String DELETE = 
			"DELETE FROM announcement where an_id = ?";
		private static final String UPDATE = 
			"UPDATE announcement set  cr_id=?, an_date=?, an_edit_date=?, an_title=?, an_content=? where an_id = ?";

	@Override
	public void insert(AnnouncementVO announcementVO) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
//			pstmt.setInt(1, announcementVO.getAnId());
//			pstmt.setInt(2, announcementVO.getCrId());
//			pstmt.setDate(3, announcementVO.getAnDate());
//			pstmt.setDate(4, announcementVO.getAnEditDate());
//			pstmt.setString(5, announcementVO.getAnTitle());
//			pstmt.setString(6, announcementVO.getAnContent());
			
//			pstmt.setInt(1, announcementVO.getAnId());
			pstmt.setInt(1, announcementVO.getCrId());
			pstmt.setDate(2, announcementVO.getAnDate());
			pstmt.setDate(3, announcementVO.getAnEditDate());
			pstmt.setString(4, announcementVO.getAnTitle());
			pstmt.setString(5, announcementVO.getAnContent());
			
			pstmt.executeUpdate();
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
			
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
		if(con != null) {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}

	@Override
	public void update(AnnouncementVO announcementVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, announcementVO.getCrId());
			pstmt.setDate(2, announcementVO.getAnDate());
			pstmt.setDate(3, announcementVO.getAnEditDate());
			pstmt.setString(4, announcementVO.getAnTitle());
			pstmt.setString(5, announcementVO.getAnContent());
			pstmt.setInt(6, announcementVO.getAnId());
			
			pstmt.executeUpdate();
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
			
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
		if(con != null) {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}

	@Override
	public void delete(Integer anId) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, anId);
			
			pstmt.executeUpdate();
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
			
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
		if(con != null) {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}

	@Override
	public AnnouncementVO findByPrimaryKey(Integer anId) {
		// TODO Auto-generated method stub
		
		AnnouncementVO announcementVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, anId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				announcementVO = new AnnouncementVO();
				announcementVO.setAnId(rs.getInt("an_id"));
				announcementVO.setCrId(rs.getInt("cr_id"));
				announcementVO.setAnDate(rs.getDate("an_date"));
				announcementVO.setAnEditDate(rs.getDate("an_edit_date"));
				announcementVO.setAnTitle(rs.getString("an_title"));
				announcementVO.setAnContent(rs.getString("an_content"));
			}
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return announcementVO;
	}

	@Override
	public List<AnnouncementVO> getAll() {
		// TODO Auto-generated method stub
		List<AnnouncementVO> list = new ArrayList<AnnouncementVO>();
		AnnouncementVO announcementVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				announcementVO = new AnnouncementVO();
				announcementVO.setAnId(rs.getInt("an_id"));
				announcementVO.setCrId(rs.getInt("cr_id"));
				announcementVO.setAnDate(rs.getDate("an_date"));
				announcementVO.setAnEditDate(rs.getDate("an_edit_date"));
				announcementVO.setAnTitle(rs.getString("an_title"));
				announcementVO.setAnContent(rs.getString("an_content"));
				list.add(announcementVO);
			}
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
}

