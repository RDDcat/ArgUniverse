package com.kyp.arguniverse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
