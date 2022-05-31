package com.kyp.arguniverse.domain;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {
    private String title;
    private int fireCount;
    private int viewCount;
    private int postID;
    private String content;


}
