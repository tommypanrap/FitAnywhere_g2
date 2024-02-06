package com.sub.model;

import java.util.*;
import java.sql.*;

public class SubJDBCDAO implements SubDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/fitanywhere?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";

//	方便調整SQL指令
	private static final String INSERT_STMT = 
		"INSERT INTO subscribe (su_id,u_id,coach_id,sub_status) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT su_id,u_id,coach_id,sub_status FROM subscribe order by su_id";
	private static final String GET_ONE_STMT = 
		"SELECT su_id,u_id,coach_id,sub_status FROM subscribe where su_id = ?";
//	private static final String DELETE = 
//		"DELETE FROM subscribe where su_id = ?";
	private static final String UPDATE = "UPDATE subscribe SET coach_id=?, sub_status=? WHERE su_id=? AND u_id=?";
	@Override
	public void insert(SubVO subVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, subVO.getSuId());
			pstmt.setInt(2, subVO.getuId());
			pstmt.setInt(3, subVO.getCoachId());
			pstmt.setInt(4, subVO.getSubStatus());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
//
	@Override
	public void update(SubVO subVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, subVO.getSuId());
			pstmt.setInt(2, subVO.getuId());
			pstmt.setInt(3, subVO.getCoachId());
			pstmt.setInt(4, subVO.getSubStatus());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

//	@Override
//	public void delete(Integer suId) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(DELETE);
//
//			pstmt.setInt(1, suId);
//
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}
//
	@Override
	public SubVO findByPrimaryKey(Integer suId) {

		SubVO subVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, suId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				subVO = new SubVO();
				subVO.setSuId(rs.getInt("su_id"));
				subVO.setuId(rs.getInt("u_id"));
				subVO.setCoachId(rs.getInt("coach_id"));
				subVO.setSubStatus(rs.getInt("sub_status"));

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return subVO;
	}

	@Override
	public List<SubVO> getAll() {
		List<SubVO> list = new ArrayList<SubVO>();
		SubVO subVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				subVO = new SubVO();
				subVO.setSuId(rs.getInt("su_id"));
				subVO.setuId(rs.getInt("u_id"));
				subVO.setCoachId(rs.getInt("coach_id"));
				subVO.setSubStatus(rs.getInt("sub_status"));
				list.add(subVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		SubJDBCDAO dao = new SubJDBCDAO();

		// �s�W
//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEname("�d�ç�1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptno(10);
//		dao.insert(empVO1);

		// �ק�
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("�d�ç�2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptno(20);
//		dao.update(empVO2);

		// �R��
//		dao.delete(2);

		// �d��
		SubVO empVO3 = dao.findByPrimaryKey(1);
		System.out.print(empVO3.getSuId() + ",");
		System.out.print(empVO3.getuId() + ",");
		System.out.print(empVO3.getCoachId() + ",");
		System.out.print(empVO3.getSubStatus() + ",");
		System.out.println("---------------------");

		// �d��
		List<SubVO> list = dao.getAll();
		for (SubVO aSub : list) {
			System.out.print(aSub.getSuId() + ",");
			System.out.print(aSub.getuId() + ",");
			System.out.print(aSub.getCoachId() + ",");
			System.out.print(aSub.getSubStatus() + ",");
			System.out.println();
		}
	}
	@Override
	public void delete(Integer su_id) {
		// TODO Auto-generated method stub
		
	}
}