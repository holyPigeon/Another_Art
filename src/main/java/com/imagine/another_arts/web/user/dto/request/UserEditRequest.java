package com.imagine.another_arts.web.user.dto.request;

import com.imagine.another_arts.domain.user.service.dto.request.UserEditRequestDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEditRequest {
    @ApiModelProperty(value = "사용자 이름", example = "name")
    private String name;

    @ApiModelProperty(value = "사용자 닉네임", example = "nickname")
    private String nickname;

    @ApiModelProperty(value = "사용자 재학중인 학교명", example = "경기대학교")
    private String schoolName;

    @ApiModelProperty(value = "사용자 전화번호", example = "01099999999")
    private String phoneNumber;

    @ApiModelProperty(value = "사용자 주소", example = "수원")
    private String address;

    public UserEditRequestDto toServiceDto() {
        return new UserEditRequestDto(
                this.name,
                this.nickname,
                this.schoolName,
                this.phoneNumber,
                this.address
        );
    }
}
