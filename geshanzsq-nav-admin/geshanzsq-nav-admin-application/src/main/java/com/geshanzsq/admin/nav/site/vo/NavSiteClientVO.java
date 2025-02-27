package com.geshanzsq.admin.nav.site.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 导航网站客户端
 *
 * @author geshanzsq
 * @date 2023/1/7
 */
@Data
@ApiModel("导航网站客户端")
public class NavSiteClientVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("网站 id")
    private Long id;

    @ApiModelProperty("分类 id")
    private Long categoryId;

    @ApiModelProperty("网站名称")
    private String siteName;

    @ApiModelProperty("网站图片路径")
    private String sitePath;

    @ApiModelProperty("网站描述")
    private String siteDescription;

    /**
     * 分数
     */
    @ApiModelProperty("分数")
    private Integer score;

    /**
     * 免费（1 免费，2 不免费）
     */
    @ApiModelProperty("免费")
    private Integer free;

    /**
     * 合理性（1 合理，2 不合理）
     */
    @ApiModelProperty("合理性")
    private Integer reasonable;

    @ApiModelProperty("网站地址")
    private String siteUrl;


}
