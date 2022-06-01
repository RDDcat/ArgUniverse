package com.kyp.arguniverse.domain;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;

    @ManyToOne
    @JoinColumn(name = "uid")
    User user;

    private int fire_count;
    private int view_count;
    private String preview;
    private String title;
    private int p_like;
    private int p_dislike;

}
