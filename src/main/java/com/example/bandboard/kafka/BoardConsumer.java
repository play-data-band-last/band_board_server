package com.example.bandboard.kafka;

import com.example.bandboard.domain.request.LikeCountUpdateRequest;
import com.example.bandboard.domain.request.MemberUpdateRequest;
import com.example.bandboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.DltHandler;
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

    @KafkaListener(topics = TopicConfig.memberUpdate)
    public void updateBoardMember(MemberUpdateRequest memberUpdateRequest) throws Exception {
        boardService.updateBoardMember(memberUpdateRequest);
    }

    @DltHandler
    public void processDltMessage(String dltMessage) {
        // DLT 토픽에서 메시지를 처리합니다. (예: 로깅 또는 추가 조사)
        System.out.println("DLT에서 메시지 수신: " + dltMessage);
    }

}
