package com.altice.alticcisequence.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class AlticciSequenceService {

	private ConcurrentHashMap<Long, Long> alticciSequenceCache = new ConcurrentHashMap<>();

	public long getAlticciSequenceValue(Long inputValue) {

		if (inputValue == 0) {
			return 0L;
		} else if (inputValue == 1 || inputValue == 2) {
			return 1L;
		} else if (this.alticciSequenceCache.containsKey(inputValue)) {
			return this.alticciSequenceCache.get(inputValue);
		} else {
			long alticciSequenceValue = this.getAlticciSequenceValue(inputValue - 3)
					+ this.getAlticciSequenceValue(inputValue - 2);
			this.alticciSequenceCache.put(inputValue, alticciSequenceValue);
			return alticciSequenceValue;
		}
	}
}