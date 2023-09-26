package com.inditex.price.infrastructure.adapters.output.persistence.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
  private String studentId;
  private String firstName;
  private String lastName;
  private int year;  
  private int cantidad;
  
}
