package com.kyp.arguniverse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "post_detail")
public class Post_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;

    private String post_content;
}
