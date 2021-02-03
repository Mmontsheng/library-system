package com.mmontsheng.library.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO extends CrudDTO {

    @NotNull(message = "Book title is required")
    private String title;

    @NotNull(message = "Book summary is required")
    private String summary;

    @NotNull(message = "Book image is required")
    private String image;

    @NotNull(message = "Book year is required")
    private Integer year;

    @NotNull(message = "Book isbn is required")
    private Integer isbn;

    private String author;
    
    @NotNull(message = "Book author is required")
    private String authorId;

    private String category;
    
    @NotNull(message = "Book category is required")
    private String categoryId;
}
