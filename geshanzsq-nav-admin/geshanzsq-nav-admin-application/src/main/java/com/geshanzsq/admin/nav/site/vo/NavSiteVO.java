package com.geshanzsq.admin.nav.site.vo;

import com.geshanzsq.common.core.web.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 导航网站
 *
 * @author geshanzsq
 * @date 2022/11/20
 */
@Data
@ApiModel("导航网站")
public class NavSiteVO extends BaseVO implements Serializable {

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

    @ApiModelProperty("网站地址")
    private String siteUrl;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("点击量")
    private Integer clickCount;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 免费（1 免费，2 不免费）
     */
    private Integer free;

    /**
     * 合理性（1 合理，2 不合理）
     */
    private Integer reasonable;

    @ApiModelProperty("状态（1 正常，2 停用）")
    private Integer status;

    @ApiModelProperty("分类名称")
    private String categoryName;

}
