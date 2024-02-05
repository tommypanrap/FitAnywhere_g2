package com.fitanywhere.opinion.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.fitanywhere.defaultfuction.DatabaseManager;

public class OpinionDAOImpl implements OpinionDAO {

	@Override
	public String getNickNameByUserID(int userID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		String nickName = null;

		try {
			// 建立資料庫連線
			con = DatabaseManager.getConnection();

			// 準備
			String sql = "SELECT u_nickname FROM user WHERE u_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userID);

			// 執行
			rs = pstmt.executeQuery();

			// 提取結果
			if (rs.next()) {
				nickName = rs.getString("u_nickname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 關閉資源
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return nickName;
	}

	@Override
	public void createOpinion(OpinionVO opinion) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 建立資料庫連線
			con = DatabaseManager.getConnection();

			// 準備 SQL 插入語句
			String sql = "INSERT INTO opinion (u_id, op_title, op_content, op_send_time, op_status) VALUES (?, ?, ?, ?, 0)";
			pstmt = con.prepareStatement(sql);

			// 設定參數
			pstmt.setInt(1, opinion.getUserId());
			pstmt.setString(2, opinion.getOpTitle());
			pstmt.setString(3, opinion.getOpContent());
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());
			calendar.set(Calendar.MILLISECOND, 0); // 設置毫秒為0
			Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
			pstmt.setTimestamp(4, timestamp);
//			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis())); // 使用當下時間
			// 目前暫定新建意見都是opStatus = 0
//			pstmt.setInt(5, opinion.getOpStatus());

			// 執行
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 關閉資源
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public int countOpinionsByUserID(int userID) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int count = 0;

	    try {
	        con = DatabaseManager.getConnection();
	        String sql = "SELECT COUNT(*) AS total FROM opinion WHERE u_id = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, userID);

	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            count = rs.getInt("total");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
			// 關閉資源
	    	try {
	            if (rs != null)
	                rs.close();
	            if (pstmt != null)
	                pstmt.close();
	            if (con != null)
	                con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return count;
	}
	
	@Override
	public List<OpinionVO> getAllOpinionsByUserID(int userID, int pageNo, int pageSize) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<OpinionVO> opinions = new ArrayList<>();

	    try {
	        con = DatabaseManager.getConnection();
	        String sql = "SELECT op_id, op_title, op_status, op_send_time FROM opinion WHERE u_id = ? ORDER BY op_id DESC LIMIT ?, ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, userID);
	        pstmt.setInt(2, (pageNo - 1) * pageSize);
	        pstmt.setInt(3, pageSize);

	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            OpinionVO opinion = new OpinionVO();
	            opinion.setOpId(rs.getInt("op_id"));
	            opinion.setOpTitle(rs.getString("op_title"));
	            opinion.setOpStatus(rs.getInt("op_status"));
	            opinion.setOpSendTime(rs.getTimestamp("op_send_time"));

	            opinions.add(opinion);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {

			// 關閉資源
	    	try {
	            if (rs != null)
	                rs.close();
	            if (pstmt != null)
	                pstmt.close();
	            if (con != null)
	                con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return opinions;
	}

//	@Override
//	public List<OpinionVO> getAllOpinionsByUserID(int userID) {
//	    Connection con = null;
//	    PreparedStatement pstmt = null;
//	    ResultSet rs = null;
//	    List<OpinionVO> opinions = new ArrayList<>();
//
//	    try {
//	        // 建立資料庫連線
//	        con = DatabaseManager.getConnection();
//
//	        // 準備 SQL 查詢語句，根據 op_id 降序排列
//	        String sql = "SELECT op_id, op_title, op_status, op_send_time FROM opinion WHERE u_id = ? ORDER BY op_id DESC";
//	        pstmt = con.prepareStatement(sql);
//	        pstmt.setInt(1, userID);
//
//	        // 執行 SQL 查詢
//	        rs = pstmt.executeQuery();
//
//	        while (rs.next()) {
//	            OpinionVO opinion = new OpinionVO();
//	            opinion.setOpId(rs.getInt("op_id"));
//	            opinion.setOpTitle(rs.getString("op_title"));
//	            opinion.setOpStatus(rs.getInt("op_status"));
//	            opinion.setOpSendTime(rs.getTimestamp("op_send_time"));
//
//	            opinions.add(opinion);
//	        }
//
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	        // 關閉資源
//	        try {
//	            if (rs != null)
//	                rs.close();
//	            if (pstmt != null)
//	                pstmt.close();
//	            if (con != null)
//	                con.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//	    return opinions;
//	}


	@Override
	public void replyToOpinion(int opinionID, String replyContent) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 建立資料庫連線
			con = DatabaseManager.getConnection();

			// 準備
			String sql = "UPDATE opinion SET op_reply_content = ?, op_reply_time = ? WHERE op_id = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, replyContent);
			pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis())); // 使用當下時間
			pstmt.setInt(3, opinionID);

			// 執行
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 關閉資源
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public OpinionVO getOpinionDetails(int opinionID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OpinionVO opinion = null;

		try {
			// 建立資料庫連線
			con = DatabaseManager.getConnection();

			// 準備
			String sql = "SELECT u_id, op_title, op_content, op_send_time, op_reply_content, op_reply_time, op_status FROM opinion WHERE op_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, opinionID);

			// 執行
			rs = pstmt.executeQuery();

			if (rs.next()) {
				opinion = new OpinionVO();
				opinion.setUserId(rs.getInt("u_id"));
				opinion.setOpTitle(rs.getString("op_title"));
				opinion.setOpContent(rs.getString("op_content"));
				opinion.setOpSendTime(rs.getTimestamp("op_send_time"));
				opinion.setOpReplyContent(rs.getString("op_reply_content"));
				opinion.setOpReplyTime(rs.getTimestamp("op_reply_time"));
				opinion.setOpStatus(rs.getInt("op_status"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 關閉資源
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return opinion;
	}

}
