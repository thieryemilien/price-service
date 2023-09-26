package com.inditex.price.infrastructure.adapters.output.persistence.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>(); 
		
		  
		 Student student = new Student("123", "Baristan", "Selmy", 2024, 2);
		 Student student1 = new Student("125", "Strong", "Belwas", 2026, 2);
		 Student student2 = new Student("125", "Strong", "Belwas", 2025, 2);
		 students.add(student);
		 students.add(student1);
		 students.add(student2);

			ModelMapper mapper = new ModelMapper();
			TypeToken<List<StudentDto>> typeToken = new TypeToken<>() {
			};

			List<StudentDto> studentDtos = 
			    mapper.map(students, typeToken.getType());
			
			
			List<Student> maxValues = new ArrayList<>(
				    students.stream()
				        .collect(Collectors.groupingBy(
				            l -> l.getFirstName() + "-"+ l.getLastName(),
				            Collectors.collectingAndThen(
				                Collectors.maxBy(Comparator.comparingInt(l -> l.getYear())), 
				                Optional::get
				            )
				        ))
				        .values()
				);
			maxValues.forEach(System.out::println);
			
			List<Student> lis = students.stream()
					.filter(x->x.getYear() > 2000)
				    .collect(Collectors.toMap(
				        Student::getFirstName,
				        //Student::getLastName,
				        Function.identity(),
				        BinaryOperator.maxBy(Comparator.comparing(Student::getYear))
				        //Collectors.summingInt(Student::get)
				        //BinaryOperator.minBy(Comparator.thenComparing(Student::year))
				    
				    ))
				    //.forEach(x -> x.setCantidad(x.getCantidad() * 10 ))
				    .values()
				    .stream()
				    .peek(f -> f.setLastName(f.getLastName() + "shhhhhhhhhhhhs"))
				    
				    //.mapToInt(o->o.getCantidad()).sum();
				    .toList();
			
			
			
			
			
			
			
			
			
			
			
			
			List<Map<String, Optional<Student>>> map = students.stream()
			//Object[] map = students.stream()
					.filter(x->x.getYear() > 2000)
				    .collect(Collectors.groupingBy(Student::getFirstName,
				    		Collectors.groupingBy(Student::getLastName,
				    				Collectors.maxBy(Comparator.comparing(Student::getYear)))))
				    .values()
				    .stream()
				    //.map( x -> x.entrySet().stream().forEach(y->y.getValue().get().setCantidad(19)))
				    //.map(m -> m.entrySet().stream().map(x->x.getKey()))
				    //s.forEach(System.out::println);
				    .toList();
			
			List<Stream<Entry<String, Optional<Student>>>> lo = 
					map.stream().map(x->x.entrySet().stream().filter(y->y.getKey().equals("year"))).toList();
			
			//System.out.println(lo.get(1));
			
			
			/*
			 * List<Map<String, Optional<Student>>> result5 = map.stream()
					   .forEach(k -> k.values().stream().map(o -> o.ifPresent(list -> list.stream()
							   .flatMap(Optional::stream)))
					  .forEach(System.out::println));
					
					//.collect(Collectors.toList());
					   
			 
			//map.stream().filter(m -> m.keySet().stream());
			map.stream().orElseGet(ArrayList::new)
            .stream()
            .filter(Optional::isPresent)
            .map(Optional::get)           
            .forEach(System.out::println);
			*/
			//List<Optional<Student>> result5 = map.stream().filter(h -> h.entrySet().forEach(x -> x.getValue()));
			//map.forEach(System.out::println);
			 
			//var list = map.stream() ? List.of(maybe.get()) : List.of();
				    
			/*
			 * 
			//List<Map<String, Optional<Student>>> map = students.stream()
			List<Map<String, Optional<Student>>> map = students.stream()
				    .collect(Collectors.groupingBy(Student::getFirstName,
				    		Collectors.groupingBy(Student::getLastName,
				    				Collectors.maxBy(Comparator.comparing(Student::getYear)))))
				    .values()
				    .stream()
				    .toList();
			 * */

				//System.out.println(map);
				
				
			//System.out.println(studentDtos);
			/*
				Map<Student, Long> lista = students.stream()
		            .collect(Collectors.groupingBy(Student::getFirstName,
		            		Collectors.groupingBy(Student::getLastName,
		                    Collectors.maxBy(Comparator.comparing(Student::getYear)))))
		        .values()
		        .stream()
		        .map(Optional::get)
		        .collect(Collectors.toList());
		        */
			//lista.forEach(System.out::println);
			
			//students.stream().filter(i -> Collections.frequency(students, i.getStudentId()) ==1)
            //.collect(Collectors.toSet()).forEach(System.out::println);

	}

}
