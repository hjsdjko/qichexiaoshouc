package com.entity.model;

import com.entity.QicheOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 汽车订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QicheOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String qicheOrderUuidNumber;


    /**
     * 收货地址
     */
    private Integer addressId;


    /**
     * 汽车
     */
    private Integer qicheId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 购买数量
     */
    private Integer buyNumber;


    /**
     * 实付价格
     */
    private Double qicheOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer qicheOrderTypes;


    /**
     * 支付类型
     */
    private Integer qicheOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
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
	 * 获取：订单号
	 */
    public String getQicheOrderUuidNumber() {
        return qicheOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setQicheOrderUuidNumber(String qicheOrderUuidNumber) {
        this.qicheOrderUuidNumber = qicheOrderUuidNumber;
    }
    /**
	 * 获取：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 设置：收货地址
	 */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：购买数量
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getQicheOrderTruePrice() {
        return qicheOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setQicheOrderTruePrice(Double qicheOrderTruePrice) {
        this.qicheOrderTruePrice = qicheOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getQicheOrderTypes() {
        return qicheOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setQicheOrderTypes(Integer qicheOrderTypes) {
        this.qicheOrderTypes = qicheOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getQicheOrderPaymentTypes() {
        return qicheOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setQicheOrderPaymentTypes(Integer qicheOrderPaymentTypes) {
        this.qicheOrderPaymentTypes = qicheOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
