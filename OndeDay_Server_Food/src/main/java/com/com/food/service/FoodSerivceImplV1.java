package com.com.food.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.food.model.EATDTO;
import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;
import com.com.food.persistence.DBContract;
import com.com.food.persistence.DBInfo;

public class FoodSerivceImplV1 implements FoodInfoService {

	protected Connection dbConn;

	public FoodSerivceImplV1() {
		this.dbConn = DBContract.getDBConnection();
	}
	//데이트서버에서 식품정보를 불러옴
	
	protected List<FoodDTO> select(PreparedStatement pStr) throws SQLException{
		List<FoodDTO> fdList = new ArrayList<FoodDTO>();
		
		ResultSet rStr = pStr.executeQuery();
		
		while(rStr.next()) {
			
			FoodDTO fdDTO = new FoodDTO();
			fdDTO.setCb_name(rStr.getString(DBInfo.FOOD.cb_name));
			fdDTO.setFd_code(rStr.getString(DBInfo.FOOD.fd_code));
			fdDTO.setCp_name(rStr.getString(DBInfo.FOOD.cp_name));
			fdDTO.setFd_name(rStr.getString(DBInfo.FOOD.fd_name));
			fdDTO.setFd_order(rStr.getInt(DBInfo.FOOD.fd_order));
			fdDTO.setFd_weight(rStr.getInt(DBInfo.FOOD.fd_weight));
			fdDTO.setFd_kcal(rStr.getInt(DBInfo.FOOD.fd_kcal));
			fdDTO.setFd_dan(rStr.getInt(DBInfo.FOOD.fd_dan));
			fdDTO.setFd_gi(rStr.getInt(DBInfo.FOOD.fd_gi));
			fdDTO.setFd_tan(rStr.getInt(DBInfo.FOOD.fd_tan));
			fdDTO.setFd_dang(rStr.getInt(DBInfo.FOOD.fd_dang));
			fdList.add(fdDTO);
			
		}
		rStr.close();
		return fdList;		
	}

	@Override
	public List<FoodDTO> selectAll() {
		// TODO 전체 식품정보보기

		PreparedStatement pStr = null;
		String sql = " SELECT * FROM view_식품목록 ";

		try {
			pStr = dbConn.prepareStatement(sql);
			List<FoodDTO> fdList = this.select(pStr);
			pStr.close();
			return fdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public FoodDTO findByData(String eat_data) {
		// TODO 식품이력검색

		String sql = "SELECT VIEW view_섭취정보 ";
		sql += " WHERE ";
		sql +=  " 섭취일 ";
		sql += " LIKE '%' || ? || '%' ";
		
		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, eat_data.trim());
			// table에 저장된 데이터와 상품정보 데이터와 조인하여
			// ㄴ날짜별 섭취한 칼로리 단백질 지방 당류 등의 양을 조회해야한다
			List<FoodDTO> eaList = this.select(pStr);
			EATDTO eatDTO = null;
			if(eatDTO != null && eaList.size()>0)
				eatDTO = eaList.get(0);
			pStr.close();
			return eatDTO;
			
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String eatInsert(FoodVO foodVO) {
		// TODO 섭취량을 입력하면 서버에 저장하는 메서드
		String sql = "INSERT INTO tbl_myfoods ";
		sql += " (eat_seq, eat_date, eat_ccode, eat_order) ";
		sql += " VALUES ( EAT_SEQ.NEXTVAL ,?,?,? ) ";

		System.out.println(sql);

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, foodVO.getEat_date());
			pStr.setString(2, foodVO.getEat_ccode());
			pStr.setInt(3, foodVO.getEat_order());
			pStr.executeUpdate();
			pStr.close();
			System.out.println("업데이트완료");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<FoodDTO> findByFoodName(String fd_name) {
		// TODO 식품정보 이름으로 찾기
		
		String sql = " SELECT * FROM view_식품목록 ";
		sql += " WHERE ";
		sql += DBInfo.FOOD.fd_name ;
		sql += " Like '%' || ? || '%' ";
		
		PreparedStatement pStr = null;
		try {
			pStr =dbConn.prepareStatement(sql);
			pStr.setString(1, fd_name.trim());
			
			List<FoodDTO> fdList = this.select(pStr);
			pStr.close();
			return fdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
