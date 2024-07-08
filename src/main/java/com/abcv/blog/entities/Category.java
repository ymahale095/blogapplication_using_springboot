package com.abcv.blog.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name="categories")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer category_id;
@Column(name="title",length = 100,nullable = false)
    private String categoryTitle;

   @Column(name = "decription")
    private String categoryDecreption;
}
