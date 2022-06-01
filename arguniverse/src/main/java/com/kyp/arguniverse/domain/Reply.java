package com.kyp.arguniverse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reply")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rid;

    @ManyToOne
    @JoinColumn(name = "cid")
    Comment comment;

    @ManyToOne
    @JoinColumn(name = "uid")
    User user;

    private int group;
    private int level;
    private int order;
    private String reply_content;
    private int r_like;
    private int r_dislike;
}
