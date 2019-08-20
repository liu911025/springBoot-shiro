package com.example.demo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class RoleVo implements Serializable {

    private Integer rid;

    private String rname;

    private String rdesc;

    private Set<ResourcesVo> resourcesVos;
}
