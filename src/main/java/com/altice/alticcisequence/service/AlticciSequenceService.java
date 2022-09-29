package com.altice.alticcisequence.service;

import org.springframework.stereotype.Service;

import com.altice.alticcisequence.exceptions.InvalidAlticciSequenceIndexException;

@Service
public class AlticciSequenceService {

	public long getAlticciSequenceValue(Long inputValue) throws Exception {

		if (inputValue < 0) {
			throw new InvalidAlticciSequenceIndexException();
		} else {
			if (inputValue == 0) {
				return 0L;
			} else if (inputValue == 1 || inputValue == 2) {
				return 1L;
			}
		}
		return this.getAlticciSequenceValue(inputValue - 3) + this.getAlticciSequenceValue(inputValue - 2);
	}
}
