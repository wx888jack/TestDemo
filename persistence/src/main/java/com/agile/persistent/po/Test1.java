package com.agile.persistent.po;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Test1 {
    @Id
    private Integer id;

    private String name;

    private String pass;

    private String adress;

    @Column(name = "is_detele")
    private String isDetele;

    @Column(name = "craeteTime")
    private Date craetetime;

    @Column(name = "updateTime")
    private Date updatetime;
}