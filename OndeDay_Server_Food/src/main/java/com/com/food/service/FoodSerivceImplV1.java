package com.com.food.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;
import com.com.food.persistence.DBContract;

public class FoodSerivceImplV1 implements FoodInfoService {

	protected Connection dbConn;

	public FoodSerivceImplV1() {
		this.dbConn = DBContract.getDBConnection();
	}

	@Override
	public List<FoodVO> selectAll() {
		// TODO 전체 섭취정보 보기

		PreparedStatement pStr = null;
		String sql = " SELECT * FROM tbl_myfoods; ";

		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet result = pStr.executeQuery();
			List<FoodVO> foodList = new ArrayList<FoodVO>();

			while (result.next()) {

				FoodVO foodVO = new FoodVO();
				foodVO.setEat_seq(result.getString("eat_seq"));
				foodVO.setEat_date(result.getString("eat_date"));
				foodVO.setEat_ccode(result.getString("eat_ccode"));
				foodVO.setEat_order(result.getInt("eat_order"));
				foodList.add(foodVO);
				System.out.println(foodVO.toString());

			}
			 
	
			pStr.close();
			
			return foodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public FoodDTO select(String 상품명) {
		// TODO 식품정보검색

		String sql = "SELECT VIEW view_상품정보 ";
		sql += " WHRER 명 = ? ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, 상품명.trim());
			ResultSet result = pStr.executeQuery();
			// table에 저장된 데이터와 상품정보 데이터와 조인하여
			// ㄴ날짜별 섭취한 칼로리 단백질 지방 당류 등의 양을 조회해야한다

			if (result.next()) {
				FoodDTO foodDTO = new FoodDTO();
				foodDTO.setFd_code(result.getString("CB_name"));
				foodDTO.setFd_name(result.getString("상품명"));
				foodDTO.setFd_order(result.getInt("회당제공량"));
				foodDTO.setFd_weight(result.getInt("총내용량"));
				foodDTO.setFd_kcal(result.getInt("칼로리"));
				foodDTO.setFd_dan(result.getInt("단백질"));
				foodDTO.setFd_gi(result.getInt("지방"));
				foodDTO.setFd_tan(result.getInt("탄수화물"));
				foodDTO.setFd_dang(result.getInt("당"));
				return foodDTO;

			} else {
				return null;
			}

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

}
