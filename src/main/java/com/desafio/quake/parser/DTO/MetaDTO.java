package com.desafio.quake.parser.DTO;

import java.io.Serializable;

public class MetaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer offset;
	private Integer recordCount;
	private Integer limit;
	private Long records;
	
	public MetaDTO(Integer offset, Integer recordCount, Integer limit, Long records) {
		this.offset = offset;
		this.recordCount = recordCount;
		this.limit = limit;
		this.records = records;
	}
	
	public MetaDTO() {}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Long getRecords() {
		return records;
	}

	public void setRecords(Long records) {
		this.records = records;
	}
	
	
	
}
