package com.kyp.arguniverse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;

    @ManyToOne
    @JoinColumn(name = "pid")
    Post post;

    @ManyToOne
    @JoinColumn(name = "uid")
    User user;

    private int group;
    private int level;
    private int order;
    private String co_content;
    private int c_like;
    private int c_dislike;

}
