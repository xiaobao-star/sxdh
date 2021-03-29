package com.tydh.sxdh.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EasyuiTreeData
{
    private String id;
    private String text;
    private String parentId;
    private List<EasyuiTreeData> children;
}
