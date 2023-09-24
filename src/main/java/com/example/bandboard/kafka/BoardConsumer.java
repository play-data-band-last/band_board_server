package com.example.bandboard.kafka;

import com.example.bandboard.domain.request.LikeCountUpdateRequest;
import com.example.bandboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardConsumer {
    private final BoardService boardService;

    @KafkaListener(topics = TopicConfig.board)
    public void listen(LikeCountUpdateRequest likeCountUpdateRequest) {
       boardService.likeCountUpdate(likeCountUpdateRequest);
    }

}
