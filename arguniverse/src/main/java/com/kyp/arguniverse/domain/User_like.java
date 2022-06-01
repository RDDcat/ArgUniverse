package com.kyp.arguniverse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_like")
public class User_like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uid;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "pid")
    private Collection<Post> post;

    @Column(name="is_fire", columnDefinition = "TINYINT", length=1)
    private int is_fire;
}
