package com.solution.smart.windmill.api.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WindMillSolutionService {

	private static final Logger log = LoggerFactory.getLogger(WindMillSolutionService.class);

	public String addAndFetchValue(List<String> listInput) {
//Optional<String> maxString =  listInput.stream().max(Comparator.comparingInt(String::length));
		log.debug("@@@ Total count of input string is: {}", listInput.size());
		Optional<String> result = listInput.stream().filter(x -> x.contains("aa")).findAny();
		if (!result.isPresent()) {
			log.debug("@@@ No String found having 'aa': {}", listInput);
			return null;
		} else {
			return result.get();
		}

	}
}
