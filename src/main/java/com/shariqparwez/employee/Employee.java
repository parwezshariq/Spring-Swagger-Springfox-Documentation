package com.shariqparwez.employee;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ApiModelProperty(value="first and last name")
    public String name;
    public String title;

    // @ApiModelProperty overrides default bean validator,
    // thus @NotNull will not be part of swagger document. (No red asterisk mark)
    // Use required field to mark required in swagger document. (red asterisk mark)
    //@ApiModelProperty(value = "Description about department")
    @ApiModelProperty(value = "Description about department", required = true)
    @NotNull
    public String department;

    protected Employee() {
    }

    public Employee(String name, String title, String department) {
        this.name = name;
        this.title = title;
        this.department = department;
    }
}
