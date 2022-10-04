package com.altice.alticcisequence.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altice.alticcisequence.dto.AlticciSequenceDto;
import com.altice.alticcisequence.service.AlticciSequenceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags="Sequence values")
@RequestMapping("/alticci")
public class AlticciSequenceController {

	@Autowired
	private AlticciSequenceService alticciSequenceService;
	@Autowired
	private AlticciSequenceDto alticciSequenceDto;

	@ApiOperation("Get Alticci sequence value by index")
	@GetMapping("/{n}")
	public ResponseEntity<Object> getAlticciSequenceValue(@ApiParam(value="Required sequence index") @PathVariable Long n) {
		
		if(this.alticciSequenceDto.isAlticciSequenceIndexValid(n)){
			this.alticciSequenceDto.setAlticciSequenceIndex(n);
			return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS)).body(
					this.alticciSequenceService.getAlticciSequenceValue(alticciSequenceDto.getAlticciSequenceIndex()));
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("The input value must be zero or a natural number.");
		}
	}
}
