package org.deyi.contentcenter.domain.entity.content;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@Table(name = "share")
public class Share {
    /**
     * id
     */
    @Id
    @Column(name = "share_id")
    private Integer shareId;

    /**
     * 发布人id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 标题
     */
    @Column(name = "share_title")
    private String shareTitle;

    /**
     * 创建时间
     */
    @Column(name = "share_create_time")
    private Date shareCreateTime;

    /**
     * 修改时间
     */
    @Column(name = "share_update_time")
    private Date shareUpdateTime;

    /**
     * 是否原创 0:否 1:是
     */
    @Column(name = "share_is_original")
    private Boolean shareIsOriginal;

    /**
     * 作者
     */
    @Column(name = "share_author")
    private String shareAuthor;

    /**
     * 封面
     */
    @Column(name = "share_cover")
    private String shareCover;

    /**
     * 概要信息
     */
    @Column(name = "share_summary")
    private String shareSummary;

    /**
     * 价格（需要的积分）
     */
    @Column(name = "share_price")
    private Integer sharePrice;

    /**
     * 下载地址
     */
    @Column(name = "share_download_url")
    private String shareDownloadUrl;

    /**
     * 下载数 
     */
    @Column(name = "share_buy_count")
    private Integer shareBuyCount;

    /**
     * 是否显示 0:否 1:是
     */
    @Column(name = "share_show_flag")
    private Boolean shareShowFlag;

    /**
     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
     */
    @Column(name = "share_audit_status")
    private String shareAuditStatus;

    /**
     * 审核不通过原因
     */
    @Column(name = "share_reason")
    private String shareReason;
}