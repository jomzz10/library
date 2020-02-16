package com.bcs.library.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@ApiModel
@Entity(name = "bookcategory")
public class BookCategoryModel {

    @ApiModelProperty
    @Id
    private Long id;

    @ApiModelProperty
    private String name;

    @ApiModelProperty
    private String description;
}
