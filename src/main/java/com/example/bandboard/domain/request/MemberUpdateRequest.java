package com.example.bandboard.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberUpdateRequest {
    private String memberName;
    private String memberImage;
    private Long memberId;
}
