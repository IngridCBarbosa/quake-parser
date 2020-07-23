package com.desafio.quake.parser.DTO;

import java.io.Serializable;
import java.util.List;

public class ResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Object> allRecords;
	private MetaDTO meta;
	
	public List<Object> getAllRecords() {
		return allRecords;
	}
	public void setAllRecords(List<Object> list) {
		this.allRecords = list;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
	
	
}
