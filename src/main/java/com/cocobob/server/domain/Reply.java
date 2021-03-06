package com.cocobob.server.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Data
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reply_id")
    private long rno;

    @Column(nullable = false)
    private String username;

    public void setBoard(Board board) {
        this.board = board;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Board board;

    public Reply(ReplyRequestDto requestDto){
        this.content = requestDto.getContent();
    }

    public Reply(String content){
        this.content = content;
    }

}
