package com.inditex.price.infrastructure.adapters.output.persistence.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomMapper {

	//@Autowired
	//private ModelMapper modelMapper;
	
	public <S, T> List<T> convertList(List<S> source, Class<T> targetClass) {
		ModelMapper modelMapper = new ModelMapper();
		return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	
	
}
