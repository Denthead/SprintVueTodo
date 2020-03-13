package com.otka.springbootvue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Todo {
    
    @Id @GeneratedValue
    private Long id;
    
    @NonNull
    private String title;
    
    private Boolean completed = false;
    
}
