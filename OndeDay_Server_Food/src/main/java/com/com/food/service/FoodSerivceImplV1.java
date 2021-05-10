package com.com.food.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;
import com.com.food.persistence.DBContract;

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
			fdDTO.setEat_seq(rStr.getLong("seq"));
			fdDTO.setEat_date(rStr.getString("eat_date"));
			fdDTO.setFd_name(rStr.getString("fd_name"));
			fdDTO.setFd_order(rStr.getInt("fd_order"));
			fdDTO.setFd_weight(rStr.getInt("fd_weight"));
			fdDTO.setFd_kcal(rStr.getInt("fd_kcal"));
			fdDTO.setFd_dan(rStr.getInt("fd_dan"));
			fdDTO.setFd_gi(rStr.getInt("fd_gi"));
			fdDTO.setFd_tan(rStr.getInt("fd_tan"));
			fdDTO.setFd_dang(rStr.getInt("fd_dang"));
			fdList.add(fdDTO);
			
		}
				return null;		
	}

	@Override
	public List<FoodDTO> selectAll() {
		// TODO 전체 섭취정보 보기

		PreparedStatement pStr = null;
		String sql = " SELECT * FROM tbl_myfoods; ";

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
		// TODO 식품정보검색

		String sql = "SELECT VIEW view_섭취정보 ";
		sql += " WHRER 섭취날짜 = ? ";
		
		
		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, eat_data.trim());
			// table에 저장된 데이터와 상품정보 데이터와 조인하여
			// ㄴ날짜별 섭취한 칼로리 단백질 지방 당류 등의 양을 조회해야한다
			List<FoodDTO> fdList = this.select(pStr);
			FoodDTO fdDTO = null;
			if(fdDTO != null && fdList.size()>0)
				fdDTO = fdList.get(0);
			pStr.close();
			return fdDTO;
			
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
		sql += " VALUES ( ?//seq하나씩 증가하는 명령어,?,?,? ) ";

		System.out.println(sql);

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, foodVO.getEat_seq());
			pStr.setString(2, foodVO.getEat_date());
			pStr.setString(3, foodVO.getEat_ccode());
			pStr.setInt(4, foodVO.getEat_order());
			pStr.executeUpdate();
			pStr.close();
			System.out.println("업데이트완료");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<FoodDTO> findByFoodName(String name) {
		// TODO 식품정보 이름으로 찾기
		
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE 식품명 Like '%' || ? || '%' ";;
		
		PreparedStatement pStr = null;
		try {
			pStr =dbConn.prepareStatement(sql);
			pStr.setString(1, name);
			
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
