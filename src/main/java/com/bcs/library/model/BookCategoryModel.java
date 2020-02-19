package com.bcs.library.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@ApiModel
@Entity(name = "book_category")
public class BookCategoryModel extends DateModel{

    @ApiModelProperty
    @Id
    private Long id;

    @ApiModelProperty
    private String name;

    @ApiModelProperty
    private String description;

    private Boolean deleted;

    @OneToOne(mappedBy = "bookCategory")
    private BookCategoriesMappingModel bookCategoriesMapping;

}
