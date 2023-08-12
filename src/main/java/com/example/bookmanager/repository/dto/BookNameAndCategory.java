package com.example.bookmanager.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookNameAndCategory {
    private String name;
    private String category;
}
