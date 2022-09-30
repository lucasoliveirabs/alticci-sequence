package com.altice.alticcisequence.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altice.alticcisequence.dto.AlticciSequenceDto;
import com.altice.alticcisequence.service.AlticciSequenceService;

@RestController
@RequestMapping("/alticci")
public class AlticciSequenceController {

	@Autowired
	private AlticciSequenceService alticciSequenceService;
	@Autowired
	private AlticciSequenceDto alticciSequenceDto;

	@GetMapping("/{n}")
	public ResponseEntity<Object> getAlticciSequenceValue(@PathVariable Long n) {

		if(this.alticciSequenceDto.isAlticciSequenceIndexValid(n)){
			this.alticciSequenceDto.setAlticciSequenceIndex(n);
			return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.maxAge(100, TimeUnit.SECONDS)).body(
					this.alticciSequenceService.getAlticciSequenceValue(alticciSequenceDto.getAlticciSequenceIndex()));
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("The input value must be zero or a natural number.");
		}
	}
}
