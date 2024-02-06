package com.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3307/fitanywhere?serverTimezone=Asia/Taipei";
	String userId = "root";
	String password = "123456";

	@Override
	public void insert(UserVO userVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userId, password);
			pstmt = con.prepareStatement(
					"insert into user(u_id,mood_id,u_nickname,u_name,u_mail,u_password,u_phone,u_verified,u_coach,u_gender,u_age,u_headshot,u_birth,u_status,c_intro)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, userVO.getuId());
			pstmt.setInt(2, userVO.getmoodId());
			pstmt.setString(3, userVO.getuNickname());
			pstmt.setString(4, userVO.getuName());
			pstmt.setString(5, userVO.getuMail());
			pstmt.setString(6, userVO.getuPassword());
			pstmt.setString(7, userVO.getuPhone());
			pstmt.setInt(8, userVO.getuVerified());
			pstmt.setInt(9, userVO.getuCoach());
			pstmt.setString(10, userVO.getuGender());
			pstmt.setInt(11, userVO.getuAge());
			pstmt.setBytes(12, userVO.getuHeadshot());
			pstmt.setDate(13, userVO.getuBirth());
			pstmt.setInt(14, userVO.getuStatus());
			pstmt.setString(15, userVO.getcIntro());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	public void update(UserVO userVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userId, password);
			pstmt = con.prepareStatement("update user set mood_id = ? ,u_nickname = ? ,u_name = ? ,u_mail = ? ,u_password = ? ,u_phone = ? ,u_verified = ? ,u_coach = ? ,u_gender = ? ,u_age = ? ,u_headshot = ? ,u_birth = ? ,u_status = ? ,c_intro = ? where u_id = ?");

			pstmt.setInt(1, userVO.getmoodId());
			pstmt.setString(2, userVO.getuNickname());
			pstmt.setString(3, userVO.getuName());
			pstmt.setString(4, userVO.getuMail());
			pstmt.setString(5, userVO.getuPassword());
			pstmt.setString(6, userVO.getuPhone());
			pstmt.setInt(7, userVO.getuVerified());
			pstmt.setInt(8, userVO.getuCoach());
			pstmt.setString(9, userVO.getuGender());
			pstmt.setInt(10, userVO.getuAge());
			pstmt.setBytes(11, userVO.getuHeadshot());
			pstmt.setDate(12, userVO.getuBirth());
			pstmt.setInt(13, userVO.getuStatus());
			pstmt.setString(14, userVO.getcIntro());
			pstmt.setInt(15, userVO.getuId());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	public List<UserVO> getAll() {
		// TODO Auto-generated method stub
		List<UserVO> list = new ArrayList<>();
		UserVO userVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userId, password);
			pstmt = con.prepareStatement("select u_id,mood_id,u_nickname,u_name,u_mail,u_password,u_phone,u_verified,u_coach,u_gender,u_age,u_headshot,u_birth,u_status,c_intro from user order by u_id");
			rs = pstmt.executeQuery();

			while(rs.next()) {
				userVO = new UserVO();
				userVO.setuId(rs.getInt("u_id"));
				userVO.setmoodId(rs.getInt("mood_id"));
				userVO.setuNickname(rs.getString("u_nickname"));
				userVO.setuName(rs.getString("u_name"));
				userVO.setuMail(rs.getString("u_mail"));
				userVO.setuPassword(rs.getString("u_password"));
				userVO.setuPhone(rs.getString("u_phone"));
				userVO.setuVerified(rs.getInt("u_verified"));
				userVO.setuCoach(rs.getInt("u_coach"));
				userVO.setuGender(rs.getString("u_gender"));
				userVO.setuAge(rs.getInt("u_age"));
				userVO.setuHeadshot(rs.getBytes("u_headshot"));
				userVO.setuBirth(rs.getDate("u_birth"));
				userVO.setuStatus(rs.getInt("u_status"));
				userVO.setcIntro(rs.getString("c_intro"));
				list.add(userVO);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	public UserVO findByPrimaryKey(Integer uId) {
		// TODO Auto-generated method stub
		UserVO userVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, userId, password);
			pstmt=con.prepareStatement("select u_id,mood_id,u_nickname,u_name,u_mail,u_password,u_phone,u_verified,u_coach,u_gender,u_age,u_headshot,u_birth,u_status,c_intro from user where u_id=?");
			pstmt.setInt(1, uId);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				userVO = new UserVO();
				userVO.setuId(rs.getInt("u_id"));
				userVO.setmoodId(rs.getInt("mood_id"));
				userVO.setuNickname(rs.getString("u_nickname"));
				userVO.setuName(rs.getString("u_name"));
				userVO.setuMail(rs.getString("u_mail"));
				userVO.setuPassword(rs.getString("u_password"));
				userVO.setuPhone(rs.getString("u_phone"));
				userVO.setuVerified(rs.getInt("u_verified"));
				userVO.setuCoach(rs.getInt("u_coach"));
				userVO.setuGender(rs.getString("u_gender"));
				userVO.setuAge(rs.getInt("u_age"));
				userVO.setuHeadshot(rs.getBytes("u_headshot"));
				userVO.setuBirth(rs.getDate("u_birth"));
				userVO.setuStatus(rs.getInt("u_status"));
				userVO.setcIntro(rs.getString("c_intro"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		return userVO;
	}

	@Override
	public void delete(Integer uId) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;


		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userId, password);
			pstmt = con.prepareStatement("delete from user where u_id = ?");

			pstmt.setInt(1, uId);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}
