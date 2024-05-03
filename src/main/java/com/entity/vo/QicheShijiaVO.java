package com.entity.vo;

import com.entity.QicheShijiaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 汽车试驾预定
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qiche_shijia")
public class QicheShijiaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 编号
     */

    @TableField(value = "qiche_shijia_order_uuid_number")
    private String qicheShijiaOrderUuidNumber;


    /**
     * 汽车
     */

    @TableField(value = "qiche_id")
    private Integer qicheId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qiche_shijia_order_time")
    private Date qicheShijiaOrderTime;


    /**
     * 预定审核
     */

    @TableField(value = "qiche_shijia_order_yesno_types")
    private Integer qicheShijiaOrderYesnoTypes;


    /**
     * 审核结果
     */

    @TableField(value = "qiche_shijia_order_yesno_text")
    private String qicheShijiaOrderYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：编号
	 */
    public String getQicheShijiaOrderUuidNumber() {
        return qicheShijiaOrderUuidNumber;
    }


    /**
	 * 获取：编号
	 */

    public void setQicheShijiaOrderUuidNumber(String qicheShijiaOrderUuidNumber) {
        this.qicheShijiaOrderUuidNumber = qicheShijiaOrderUuidNumber;
    }
    /**
	 * 设置：汽车
	 */
    public Integer getQicheId() {
        return qicheId;
    }


    /**
	 * 获取：汽车
	 */

    public void setQicheId(Integer qicheId) {
        this.qicheId = qicheId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预定时间
	 */
    public Date getQicheShijiaOrderTime() {
        return qicheShijiaOrderTime;
    }


    /**
	 * 获取：预定时间
	 */

    public void setQicheShijiaOrderTime(Date qicheShijiaOrderTime) {
        this.qicheShijiaOrderTime = qicheShijiaOrderTime;
    }
    /**
	 * 设置：预定审核
	 */
    public Integer getQicheShijiaOrderYesnoTypes() {
        return qicheShijiaOrderYesnoTypes;
    }


    /**
	 * 获取：预定审核
	 */

    public void setQicheShijiaOrderYesnoTypes(Integer qicheShijiaOrderYesnoTypes) {
        this.qicheShijiaOrderYesnoTypes = qicheShijiaOrderYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getQicheShijiaOrderYesnoText() {
        return qicheShijiaOrderYesnoText;
    }


    /**
	 * 获取：审核结果
	 */

    public void setQicheShijiaOrderYesnoText(String qicheShijiaOrderYesnoText) {
        this.qicheShijiaOrderYesnoText = qicheShijiaOrderYesnoText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
