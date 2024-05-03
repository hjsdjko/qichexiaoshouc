package com.entity.model;

import com.entity.QicheShijiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 汽车试驾预定
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QicheShijiaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 编号
     */
    private String qicheShijiaOrderUuidNumber;


    /**
     * 汽车
     */
    private Integer qicheId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qicheShijiaOrderTime;


    /**
     * 预定审核
     */
    private Integer qicheShijiaOrderYesnoTypes;


    /**
     * 审核结果
     */
    private String qicheShijiaOrderYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：编号
	 */
    public String getQicheShijiaOrderUuidNumber() {
        return qicheShijiaOrderUuidNumber;
    }


    /**
	 * 设置：编号
	 */
    public void setQicheShijiaOrderUuidNumber(String qicheShijiaOrderUuidNumber) {
        this.qicheShijiaOrderUuidNumber = qicheShijiaOrderUuidNumber;
    }
    /**
	 * 获取：汽车
	 */
    public Integer getQicheId() {
        return qicheId;
    }


    /**
	 * 设置：汽车
	 */
    public void setQicheId(Integer qicheId) {
        this.qicheId = qicheId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预定时间
	 */
    public Date getQicheShijiaOrderTime() {
        return qicheShijiaOrderTime;
    }


    /**
	 * 设置：预定时间
	 */
    public void setQicheShijiaOrderTime(Date qicheShijiaOrderTime) {
        this.qicheShijiaOrderTime = qicheShijiaOrderTime;
    }
    /**
	 * 获取：预定审核
	 */
    public Integer getQicheShijiaOrderYesnoTypes() {
        return qicheShijiaOrderYesnoTypes;
    }


    /**
	 * 设置：预定审核
	 */
    public void setQicheShijiaOrderYesnoTypes(Integer qicheShijiaOrderYesnoTypes) {
        this.qicheShijiaOrderYesnoTypes = qicheShijiaOrderYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getQicheShijiaOrderYesnoText() {
        return qicheShijiaOrderYesnoText;
    }


    /**
	 * 设置：审核结果
	 */
    public void setQicheShijiaOrderYesnoText(String qicheShijiaOrderYesnoText) {
        this.qicheShijiaOrderYesnoText = qicheShijiaOrderYesnoText;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
