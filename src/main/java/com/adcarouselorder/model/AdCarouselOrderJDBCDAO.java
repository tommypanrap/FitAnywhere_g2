package com.adcarouselorder.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class AdCarouselOrderJDBCDAO implements AdCarouselOrderDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/fitanywhere?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO ad_carousel_order "
	        + "(adc_id, ad_id, u_id, cr_id, adc_start_date, adc_end_date, adc_total_price, adc_update_pic, adc_status, adc_order_enddate) "
	        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT adc_id, ad_id, u_id, cr_id, adc_start_date, adc_end_date, adc_total_price, adc_update_pic, adc_status, adc_order_enddate FROM ad_carousel_order";

	private static final String GET_ONE_STMT = "SELECT adc_id, ad_id, u_id, cr_id, adc_start_date, adc_end_date, adc_total_price, adc_update_pic, adc_status, adc_order_enddate FROM ad_carousel_order WHERE adc_id = ?";

	private static final String DELETE = "DELETE FROM ad_carousel_order WHERE adc_id = ?";

	private static final String UPDATE = "UPDATE ad_carousel_order set ad_id = ?,u_id = ? , cr_id = ?, adc_start_date = ?,  adc_end_date = ?, adc_total_price = ?, adc_update_pic = ?, adc_status = ?, adc_order_enddate = ? WHERE adc_id = ?";

	@Override
	public void insert(AdCarouselOrderVO adCarouselOrderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

		 	pstmt.setNull(1, adCarouselOrderVO.getAdcId()); 
	        pstmt.setInt(2, adCarouselOrderVO.getAdId());
	        pstmt.setInt(3, adCarouselOrderVO.getuId());
	        pstmt.setInt(4, adCarouselOrderVO.getCrId());
	        pstmt.setTimestamp(5, adCarouselOrderVO.getAdcStartDate());
	        pstmt.setTimestamp(6, adCarouselOrderVO.getAdcEndDate());
	        pstmt.setInt(7, adCarouselOrderVO.getAdcTotalPrice());

	        if (adCarouselOrderVO.getAdcUpdatePic() != null) {
	            pstmt.setBytes(8, adCarouselOrderVO.getAdcUpdatePic());
	        } else {
	            pstmt.setNull(8, Types.BLOB);
	        }

	        pstmt.setInt(9, adCarouselOrderVO.getAdcStatus());
	        pstmt.setTimestamp(10, adCarouselOrderVO.getAdcOrderEnddate());

	        pstmt.executeUpdate();
	        
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(AdCarouselOrderVO adCarouselOrderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

		 	pstmt.setNull(1, adCarouselOrderVO.getAdcId()); 
	        pstmt.setInt(2, adCarouselOrderVO.getAdId());
	        pstmt.setInt(3, adCarouselOrderVO.getuId());
	        pstmt.setInt(4, adCarouselOrderVO.getCrId());
	        pstmt.setTimestamp(5, adCarouselOrderVO.getAdcStartDate());
	        pstmt.setTimestamp(6, adCarouselOrderVO.getAdcEndDate());
	        pstmt.setInt(7, adCarouselOrderVO.getAdcTotalPrice());

	        if (adCarouselOrderVO.getAdcUpdatePic() != null) {
	            pstmt.setBytes(8, adCarouselOrderVO.getAdcUpdatePic());
	        } else {
	            pstmt.setNull(8, Types.BLOB);
	        }

	        pstmt.setInt(9, adCarouselOrderVO.getAdcStatus());
	        pstmt.setTimestamp(10, adCarouselOrderVO.getAdcOrderEnddate());

	        pstmt.executeUpdate();
	        
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer adcId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, adcId);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public AdCarouselOrderVO findByPrimaryKey(Integer adcId) {

		AdCarouselOrderVO adCarouselOrderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, adcId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				adCarouselOrderVO = new AdCarouselOrderVO();
				adCarouselOrderVO.setAdcId(rs.getInt("adc_id"));
				adCarouselOrderVO.setAdId(rs.getInt("ad_id"));
				adCarouselOrderVO.setuId(rs.getInt("u_id"));
				adCarouselOrderVO.setCrId(rs.getInt("cr_id"));
				adCarouselOrderVO.setAdcStartDate(rs.getTimestamp("adc_start_date"));
				adCarouselOrderVO.setAdcEndDate(rs.getTimestamp("adc_end_date"));
				adCarouselOrderVO.setAdcTotalPrice(rs.getInt("adc_total_price"));
				adCarouselOrderVO.setAdcUpdatePic(rs.getBytes("adc_update_pic"));
				adCarouselOrderVO.setAdcStatus(rs.getInt("adc_status"));
				adCarouselOrderVO.setAdcOrderEnddate(rs.getTimestamp("adc_order_enddate"));

			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return adCarouselOrderVO;

	}

	@Override
	public List<AdCarouselOrderVO> getAll() {
		List<AdCarouselOrderVO> list = new ArrayList<AdCarouselOrderVO>();
		AdCarouselOrderVO adCarouselOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				adCarouselOrderVO = new AdCarouselOrderVO();
				adCarouselOrderVO.setAdcId(rs.getInt("adc_id"));
				adCarouselOrderVO.setAdId(rs.getInt("ad_id"));
				adCarouselOrderVO.setuId(rs.getInt("u_id"));
				adCarouselOrderVO.setCrId(rs.getInt("cr_id"));
				adCarouselOrderVO.setAdcStartDate(rs.getTimestamp("adc_start_date"));
				adCarouselOrderVO.setAdcEndDate(rs.getTimestamp("adc_end_date"));
				adCarouselOrderVO.setAdcTotalPrice(rs.getInt("adc_total_price"));
				adCarouselOrderVO.setAdcUpdatePic(rs.getBytes("adc_update_pic"));
				adCarouselOrderVO.setAdcStatus(rs.getInt("adc_status"));
				adCarouselOrderVO.setAdcOrderEnddate(rs.getTimestamp("adc_order_enddate"));
				list.add(adCarouselOrderVO);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return list;
	}
}
