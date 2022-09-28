package com.altice.alticcisequence.dto;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AlticciSequenceDto {

	@Min(value = 0, message = "The input value must be zero or a natural number")
	private Long alticciSequenceValue;
}
