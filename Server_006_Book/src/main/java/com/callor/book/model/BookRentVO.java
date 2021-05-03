package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookRentVO {
	
	
	private String br_seq;//number
	private String br_sdate;//	varchar2(10 byte)
	private String br_isbn;//char(13 byte)
	private String br_bcode;//	char(5 byte)
	private String br_edate;//	varchar2(10 byte)
	private String br_price;//	number
}
