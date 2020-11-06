package com.solution.smart.windmill.api.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Windmill Smart Solution")
@RestController
@RequestMapping("/solution")
public class WindMillSolutionController {
	
	private static final Logger log = LoggerFactory.getLogger(WindMillSolutionController.class);
	
	private static final String INVALID_INPUT = "Invalid Request, Please enter correct input";
	
	@ApiOperation("Api to accept list of strings and return the longest string from it")
	@PostMapping(value = "/addInput")
	public ResponseEntity<?> addAndFetchValue(
			@RequestBody @ApiParam(value = "Input to be add") List<String> listInput) {

		if (listInput.isEmpty()) {
			log.warn(INVALID_INPUT+" : {}",listInput);
			return new ResponseEntity<>(INVALID_INPUT, HttpStatus.BAD_REQUEST);
		} else {
			log.debug("@@@ Total count of input string is: {}",listInput.size());
			Optional<String> maxString =  listInput.stream().max(Comparator.comparingInt(String::length));
			return new ResponseEntity<>(maxString.get(), HttpStatus.OK);
		}
	}
	
	@ApiOperation("Api to accept list of strings and return the string having length less than 10")
	@DeleteMapping(value = "/input")
	public ResponseEntity<?> removeValue(
			@RequestBody @ApiParam(value = "Input to be Delete") List<String> listInput) {

		if (listInput.isEmpty()) {
			log.warn(INVALID_INPUT+" : {}",listInput);
			return new ResponseEntity<>(Arrays.asList(INVALID_INPUT), HttpStatus.BAD_REQUEST);
		} else {
			log.debug("@@@ Total count of input string is: {}",listInput.size());
			List<String> result= listInput.stream().filter(x->x.length()<10).collect(Collectors.toList());
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}

}
