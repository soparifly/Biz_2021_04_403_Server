package com.callor.book.Service;

import java.util.List;

import com.callor.book.model.BuyerDTO;
import com.callor.book.model.BuyerVO;

/*
 * tbl_buyer νμ΄λΈμ CRUD 
 */
public interface BuyerService {

	
	public List<BuyerDTO> selectAll(String bu_code);
	
	public BuyerDTO findById(String bu_tel);
	public List<BuyerDTO> findByName(String bu_name);
	public List<BuyerDTO> findByTel(String bu_tel);
	
	public int insert(BuyerVO buyerVO);
	public int update(BuyerVO buyerVO);
	public int delete(BuyerVO buyerVO);
	
	
}
