package com.mmontsheng.library.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorDTO extends CrudDTO{

    @NotNull(message = "Author name is required")
    private String name;
    
    @NotNull(message = "Author surname is required")
    private String surname;
}
