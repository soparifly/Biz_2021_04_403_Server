package com.callor.guest.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.guest.config.DBInfo;
import com.callor.guest.config.MySQLConnection;
import com.callor.guest.model.GuestBookVO;
import com.callor.guest.service.GuestBookService;

public class GuestBookServiceImplV1 implements GuestBookService {
	protected Connection dbConn;

	public GuestBookServiceImplV1() {
		dbConn = MySQLConnection.getConnection();

	}

	protected List<GuestBookVO> select(PreparedStatement pStr) throws SQLException {
		List<GuestBookVO> gbList = new ArrayList<GuestBookVO>();
		ResultSet rSet = pStr.executeQuery();
		while (rSet.next()) {

			GuestBookVO gbVO = new GuestBookVO();
			gbVO.setGb_seq(rSet.getLong(DBInfo.gb_seq));
			gbVO.setGb_date(rSet.getString(DBInfo.gb_date));
			gbVO.setGb_time(rSet.getString(DBInfo.gb_time));
			gbVO.setGb_writer(rSet.getString(DBInfo.gb_writer));
			gbVO.setGb_email(rSet.getString(DBInfo.gb_email));
			gbVO.setGb_password(rSet.getString(DBInfo.gb_password));
			gbVO.setGb_content(rSet.getString(DBInfo.gb_content));
			gbList.add(gbVO);

		}
		System.out.println(gbList.toString());
		return gbList;

	}

	@Override
	public List<GuestBookVO> selectAll() {
		String sql = "SELECT * FROM tbl_guest_book ";
		sql += " ORDER BY gb_date DESC, gb_time DESC ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			List<GuestBookVO> gbList = this.select(pStr);
			pStr.close();
			System.out.println(gbList.toString());

			return gbList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public GuestBookVO findById(Long seq) {
		// TODO Auto-generated method stub

		String sql = " SELECT * FROM tbl_guest_book ";
		sql += "WHERE gb_seq = ? ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
			List<GuestBookVO> gbList = this.select(pStr);
			pStr.close();
			if (gbList != null && gbList.size() > 0) {
				System.out.println(gbList.toString());
				return gbList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<GuestBookVO> findByWriter(String gb_writer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuestBookVO> findByDate(String gb_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuestBookVO> findByContent(String gb_text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(GuestBookVO gbVO) {
		String sql = " INSERT INTO tbl_guest_book ";
		sql += "(";
		sql += "gb_date, ";
		sql += "gb_time, ";
		sql += "gb_writer, ";
		sql += "gb_email, ";
		sql += "gb_password, ";
		sql += "gb_content) ";

		sql += " VALUES( ?,?,?,?,?,? ) ";

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, gbVO.getGb_date());
			pStr.setString(2, gbVO.getGb_time());
			pStr.setString(3, gbVO.getGb_writer());
			pStr.setString(4, gbVO.getGb_email());
			pStr.setString(5, gbVO.getGb_password());
			pStr.setString(6, gbVO.getGb_content());

			return pStr.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public Integer update(GuestBookVO gbVO) {
		String sql = " UPDATE tbl_guest_book SET ";
		sql += "gb_date =? , ";
		sql += "gb_time =? , ";
		sql += "gb_writer =? , ";
		sql += "gb_email =? , ";
		sql += "gb_password =? , ";
		sql += "gb_content =? ";
		
		sql += "WHERE gb_seq = ? ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, gbVO.getGb_date());
			pStr.setString(2, gbVO.getGb_time());
			pStr.setString(3, gbVO.getGb_writer());
			pStr.setString(4, gbVO.getGb_email());
			pStr.setString(5, gbVO.getGb_password());
			pStr.setString(6, gbVO.getGb_content());
			pStr.setLong(7, gbVO.getGb_seq());
			
			return pStr.executeUpdate();
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		}

	@Override
	public Integer delete(Long seq) {
		String sql = "DELETE FROM tbl_guest_book ";
		sql += " WHERE gb_seq = ? ";
		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
			pStr.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
