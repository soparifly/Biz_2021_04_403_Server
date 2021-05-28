package com.callor.todo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.callor.todo.config.DBContract;
import com.callor.todo.config.DBInfo;
import com.callor.todo.service.TodoService;

public class TodoServiceImplV1 implements TodoService {

	
	protected static final Logger log 
	=LoggerFactory.getLogger("TD Service");
	
	protected Connection dbConn;

	
	protected List<Map<String,Object>> select(ResultSet rSet) throws SQLException {
		//meta데이터 getter 
		ResultSetMetaData md = rSet.getMetaData();
		
		//Select 된 컬럼갯수 getter 
		int colums = md.getColumnCount();
		
		//저장할 List<VO 데이터 생성
		//ResultSet에 담겨있는 table 데이터를
		// List<VO>로 변환
		List<Map<String, Object>> tdList = new ArrayList<Map<String,Object>>();
		
		//ResultSet에 담긴 데이터에서 
		//한 레코드씩 읽어서 VO에 담고, List에 추가하는 코드
		while(rSet.next()) {
			//VO생성하기
			// 맵중에서 가장빠른 처리 가가능함 hashmap
			Map<String,Object> tdVO = new HashMap<String, Object>();
			//컬럼 갯수만큼 반복문 실행
			for(int index = 0; index < colums; index++) {
				
				//메타 데이터에서 index컬럼명 getter
				// index 위치의 컬럼명 Getter
				// 일반적으로 여기서는 1부터 시작함
				String colName = md.getColumnName(index + 1);
				
				//ResultSet으로 부터 
				// 컬럼의 index 위치에 저장된 데이터 (실제 데이터)
				// Getter
				Object objData = rSet.getObject(index + 1);
				//key: colName, value:ObjData인 
				// Map데이터를 tdVO에 추가하기 
				tdVO.put(colName, objData);
			}//end for
			tdList.add(tdVO);
		}//end while
		log.debug("TDLIST {}", tdList.toString());
		return tdList;
	}//end select
	public TodoServiceImplV1() {
		// TODO Auto-generated constructor stub
		dbConn = DBContract.getDbConn();

	}

	@Override
	public List<Map<String, Object>> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_tdlist ";
//		완료되지않은 (td_edate값이 없는 ) 데이터를 우선보이고 
//		 생성된 Insert된 순서로 보여라
//		미완료된 TODO가 먼저 출력되는 효과를 보여준다
		sql +=" ORDER BY td_edate, td_sdate, td_stime ";
		
		log.debug("SQL : {}" , sql);
		
		PreparedStatement pStr = null;
		try {
			
			pStr = dbConn.prepareStatement(sql);
			ResultSet rSet = pStr.executeQuery();
			
			List<Map<String,Object>> tdList =this.select(rSet);
					
			rSet.close();
			pStr.close();
			return tdList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public Map<String, Object> findById(Long seq) {
		// TODO Auto-generated method stub

	
		String sql =" SLECT * FRM tbl_tdlist ";
		sql += " WHERE td_sseq = ? ";
		
		PreparedStatement pStr = null;
		
		
				try {
					pStr = dbConn.prepareStatement(sql);
					pStr.setObject(1, seq);
					
					ResultSet rSet = pStr.executeQuery(); 
					List<Map<String, Object>> tdList
					= this.select(rSet);
					
					rSet.close();
					pStr.close();
					if(tdList != null && tdList.size()>0) {
						return tdList.get(0);
						
					}
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
		
		
	}

	@Override
	public Integer insert(Map<String, Object> vo) {
		
		
		log.debug(vo.toString());
		
		
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_tdlist( ";
		sql += "td_sdate,";
		sql += "td_stime,";
		sql += "td_doit) ";
		sql += " VALUES(?,?,?) ";
		
		log.debug("SQL {} " , sql);
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setObject(1, vo.get(DBInfo.td_sdate));
			pStr.setObject(2, vo.get(DBInfo.td_stime));
			pStr.setObject(3, vo.get(DBInfo.td_doit));

			Integer ret = pStr.executeUpdate();
			
			pStr.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Integer update(Map<String, Object> vo) {
		
		String sql = " UPDATE tbl_tdlist SET " ;
		sql += String.format(" %s = ? ,", DBInfo.td_sdate );
		sql += String.format(" %s = ? ,", DBInfo.td_sdate );
		sql += String.format(" %s = ? ,", DBInfo.td_doit );
		sql += String.format(" %s = ? ,", DBInfo.td_edate );
		sql += String.format(" WHERE %s = ? ", DBInfo.td_sseq );
		sql += String.format(" %s = ? ", DBInfo.td_etime );

		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setObject(1, vo.get(DBInfo.td_sdate));
			pStr.setObject(2, vo.get(DBInfo.td_stime));
			pStr.setObject(3, vo.get(DBInfo.td_doit));
			pStr.setObject(4, vo.get(DBInfo.td_edate));
			pStr.setObject(5, vo.get(DBInfo.td_etime));
			pStr.setObject(6, vo.get(DBInfo.td_sseq));
			
			Integer req = pStr.executeUpdate();
			pStr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Integer delete(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unused")
	private void viewSelect(ResultSet rSet) throws SQLException {
		/*
		 * ResultSet 으로  DB로 부터 수신한 데이터에서
		 * 메타데이터(DB의 정보를 가지고있는 동적데이터)를 활용하여 List<VO>에 값 셋팅하기 
		 * import java.sql.ResultSetMetaData
		 * import는 보통 I가 붙어잇는 인터페이스를 불러온다
		 */
		ResultSetMetaData md = rSet.getMetaData();
		
		//select 된 table의 컬럼 정보 추출
		//1. 칼럼이 몇개인가
		int colums = md.getColumnCount();
		
		//2.칼럼의 이름들을 나열하라
		System.out.println("=".repeat(40));
		for(int i = 0 ; i < colums; i++) {
			System.out.print(md.getColumnName(i+1)+"\t");
		}
		System.out.println("\n" + "-".repeat(40));
		/*
		 * rSet에는 select table의 결과가 모두 저장되어 있다
		 * 데이터와 메타데이터가 모두 포함되어있다.
		 * rSet 객체의 next() 메서드를 한번 호출하면
		 * 결과 table 의 첫번째 레코드를 읽을수 있도록 준비해준다 
		 * 이어서 next() method를 계속해서 호출하면 한줄씩 순서대로 읽을 수 있도록 준비해둔다
		 * 만약 더이상 읽을 데이터가 없으면 false를 리턴한다/
		 * 그래서 while 반복문을 사용하여 select된 데이터를 순서대로 추출 할 수 있도록 한다
		 */
		while(rSet.next()) {
			
			for (int i =0; i<colums; i++) {
				System.out.print(rSet.getObject(i+1)+"\t");
			}
			System.out.println();
		}
		System.out.println("=".repeat(40));

	}
}
