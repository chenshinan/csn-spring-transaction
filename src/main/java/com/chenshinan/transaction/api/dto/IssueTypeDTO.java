package com.chenshinan.transaction.api.dto;

import javax.validation.constraints.NotNull;

/**
 * @author shinan.chen
 * @date 2018/8/8
 */
public class IssueTypeDTO {
    private Long id;

    @NotNull(message = "error.name.null")
    private String name;
    private String icon;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
