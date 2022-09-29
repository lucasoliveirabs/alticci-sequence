package com.altice.alticcisequence.dto;

import org.springframework.stereotype.Component;

@Component
public class AlticciSequenceDto {

	private Long alticciSequenceIndex;

	public Long getAlticciSequenceIndex() {
		return this.alticciSequenceIndex;
	}
	
	public void setAlticciSequenceIndex(Long pAlticciSequenceIndex) {
		this.alticciSequenceIndex = pAlticciSequenceIndex;
	}
	
	public boolean isAlticciSequenceIndexValid(Long pAlticciSequenceIndex) {
		return (pAlticciSequenceIndex >= 0);
	}
}
