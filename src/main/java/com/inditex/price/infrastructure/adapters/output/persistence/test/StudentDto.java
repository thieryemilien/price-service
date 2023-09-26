package com.inditex.price.infrastructure.adapters.output.persistence.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
  private String studentId;
  private String firstName;
  private String lastName;
  private int year;

  
}