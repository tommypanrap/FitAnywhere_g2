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
	String userid = "root";
	String password = "123456";

	@Override
	public void insert(UserVO userVo) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(
					"insert into user(u_id,mood_id,u_nickname,u_name,u_mail,u_password,u_phone,u_verified,u_coach,u_gender,u_age,u_headshot,u_birth,u_status,u_intro)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, userVo.getuId());
			pstmt.setInt(2, userVo.getmoodId());
			pstmt.setString(3, userVo.getuNickname());
			pstmt.setString(4, userVo.getuName());
			pstmt.setString(5, userVo.getuMail());
			pstmt.setString(6, userVo.getuPassword());
			pstmt.setString(7, userVo.getuPhone());
			pstmt.setInt(8, userVo.getuVerified());
			pstmt.setInt(9, userVo.getuCoach());
			pstmt.setString(10, userVo.getuGender());
			pstmt.setInt(11, userVo.getuAge());
			pstmt.setBytes(12, userVo.getuHeadshot());
			pstmt.setDate(13, userVo.getuBirth());
			pstmt.setInt(14, userVo.getuStatus());
			pstmt.setString(15, userVo.getcIntro());

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
	public void update(UserVO userVo) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement("update user set mood_id = ? ,u_nickname = ? ,u_name = ? ,u_mail = ? ,u_password = ? ,u_phone = ? ,u_verified = ? ,u_coach = ? ,u_gender = ? ,u_age = ? ,u_headshot = ? ,u_birth = ? ,u_status = ? ,u_intro = ? where u_id = ?");

			pstmt.setInt(1, userVo.getmoodId());
			pstmt.setString(2, userVo.getuNickname());
			pstmt.setString(3, userVo.getuName());
			pstmt.setString(4, userVo.getuMail());
			pstmt.setString(5, userVo.getuPassword());
			pstmt.setString(6, userVo.getuPhone());
			pstmt.setInt(7, userVo.getuVerified());
			pstmt.setInt(8, userVo.getuCoach());
			pstmt.setString(9, userVo.getuGender());
			pstmt.setInt(10, userVo.getuAge());
			pstmt.setBytes(11, userVo.getuHeadshot());
			pstmt.setDate(12, userVo.getuBirth());
			pstmt.setInt(13, userVo.getuStatus());
			pstmt.setString(14, userVo.getcIntro());
			pstmt.setInt(15, userVo.getuId());

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
		UserVO userVo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement("select u_id,mood_id,u_nickname,u_name,u_mail,u_password,u_phone,u_verified,u_coach,u_gender,u_age,u_headshot,u_birth,u_status,u_intro from user order by u_id");
			rs = pstmt.executeQuery();

			while(rs.next()) {
				userVo = new UserVO();
				userVo.setuId(rs.getInt("u_id"));
				userVo.setmoodId(rs.getInt("mood_id"));
				userVo.setuNickname(rs.getString("u_nickname"));
				userVo.setuName(rs.getString("u_name"));
				userVo.setuMail(rs.getString("u_mail"));
				userVo.setuPassword(rs.getString("u_password"));
				userVo.setuPhone(rs.getString("u_phone"));
				userVo.setuVerified(rs.getInt("u_verified"));
				userVo.setuCoach(rs.getInt("u_coach"));
				userVo.setuGender(rs.getString("u_gender"));
				userVo.setuAge(rs.getInt("u_age"));
				userVo.setuHeadshot(rs.getBytes("u_headshot"));
				userVo.setuBirth(rs.getDate("u_birth"));
				userVo.setuStatus(rs.getInt("u_status"));
				userVo.setcIntro(rs.getString("u_intro"));
				list.add(userVo);

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
		UserVO userVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, userid, password);
			pstmt=con.prepareStatement("select u_id,mood_id,u_nickname,u_name,u_mail,u_password,u_phone,u_verified,u_coach,u_gender,u_age,u_headshot,u_birth,u_status,u_intro from user where u_id=?");
			pstmt.setInt(1, uId);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				userVo = new UserVO();
				userVo.setuId(rs.getInt("u_id"));
				userVo.setmoodId(rs.getInt("mood_id"));
				userVo.setuNickname(rs.getString("u_nickname"));
				userVo.setuName(rs.getString("u_name"));
				userVo.setuMail(rs.getString("u_mail"));
				userVo.setuPassword(rs.getString("u_password"));
				userVo.setuPhone(rs.getString("u_phone"));
				userVo.setuVerified(rs.getInt("u_verified"));
				userVo.setuCoach(rs.getInt("u_coach"));
				userVo.setuGender(rs.getString("u_gender"));
				userVo.setuAge(rs.getInt("u_age"));
				userVo.setuHeadshot(rs.getBytes("u_headshot"));
				userVo.setuBirth(rs.getDate("u_birth"));
				userVo.setuStatus(rs.getInt("u_status"));
				userVo.setcIntro(rs.getString("u_intro"));
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

		return userVo;
	}

	@Override
	public void delete(Integer uId) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;


		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
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
