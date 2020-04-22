package org.deyi.contentcenter.domain.dto.user;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    /**
     * Id
     */
    private Integer userId;

    /**
     * 微信id
     */
    private String wxId;

    /**
     * 微信昵称
     */
    private String wxNickname;

    /**
     * 角色
     */
    private String userRoles;

    /**
     * 头像地址
     */
    private String userAvatarUrl;

    /**
     * 创建时间
     */
    private Date userCreateTime;

    /**
     * 修改时间
     */
    private Date userUpdateTime;

    /**
     * 积分
     */
    private Integer userBonus;
}