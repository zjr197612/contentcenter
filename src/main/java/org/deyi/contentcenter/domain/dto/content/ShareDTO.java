package org.deyi.contentcenter.domain.dto.content;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@ToString
public class ShareDTO {
    /**
     * id
     */
    @Id
    private Integer shareId;

    /**
     * 发布人id
     */
    private Integer userId;

    /**
     * 标题
     */
    private String shareTitle;

    /**
     * 创建时间
     */
    private Date shareCreateTime;

    /**
     * 修改时间
     */
    private Date shareUpdateTime;

    /**
     * 是否原创 0:否 1:是
     */
    private Boolean shareIsOriginal;

    /**
     * 作者
     */
    private String shareAuthor;

    /**
     * 封面
     */
    private String shareCover;

    /**
     * 概要信息
     */
    private String shareSummary;

    /**
     * 价格（需要的积分）
     */
    private Integer sharePrice;

    /**
     * 下载地址
     */
    private String shareDownloadUrl;

    /**
     * 下载数 
     */
    private Integer shareBuyCount;

    /**
     * 是否显示 0:否 1:是
     */
    private Boolean shareShowFlag;

    /**
     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
     */
    private String shareAuditStatus;

    /**
     * 审核不通过原因
     */
    private String shareReason;

    private String wxNickname;
}