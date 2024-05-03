package com.entity.model;

import com.entity.QicheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 汽车
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QicheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 汽车名称
     */
    private String qicheName;


    /**
     * 汽车照片
     */
    private String qichePhoto;


    /**
     * 汽车类型
     */
    private Integer qicheTypes;


    /**
     * 汽车库存
     */
    private Integer qicheKucunNumber;


    /**
     * 汽车原价
     */
    private Double qicheOldMoney;


    /**
     * 现价
     */
    private Double qicheNewMoney;


    /**
     * 点击次数
     */
    private Integer qicheClicknum;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer qicheDelete;


    /**
     * 汽车简介
     */
    private String qicheContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：汽车名称
	 */
    public String getQicheName() {
        return qicheName;
    }


    /**
	 * 设置：汽车名称
	 */
    public void setQicheName(String qicheName) {
        this.qicheName = qicheName;
    }
    /**
	 * 获取：汽车照片
	 */
    public String getQichePhoto() {
        return qichePhoto;
    }


    /**
	 * 设置：汽车照片
	 */
    public void setQichePhoto(String qichePhoto) {
        this.qichePhoto = qichePhoto;
    }
    /**
	 * 获取：汽车类型
	 */
    public Integer getQicheTypes() {
        return qicheTypes;
    }


    /**
	 * 设置：汽车类型
	 */
    public void setQicheTypes(Integer qicheTypes) {
        this.qicheTypes = qicheTypes;
    }
    /**
	 * 获取：汽车库存
	 */
    public Integer getQicheKucunNumber() {
        return qicheKucunNumber;
    }


    /**
	 * 设置：汽车库存
	 */
    public void setQicheKucunNumber(Integer qicheKucunNumber) {
        this.qicheKucunNumber = qicheKucunNumber;
    }
    /**
	 * 获取：汽车原价
	 */
    public Double getQicheOldMoney() {
        return qicheOldMoney;
    }


    /**
	 * 设置：汽车原价
	 */
    public void setQicheOldMoney(Double qicheOldMoney) {
        this.qicheOldMoney = qicheOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getQicheNewMoney() {
        return qicheNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setQicheNewMoney(Double qicheNewMoney) {
        this.qicheNewMoney = qicheNewMoney;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getQicheClicknum() {
        return qicheClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setQicheClicknum(Integer qicheClicknum) {
        this.qicheClicknum = qicheClicknum;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getQicheDelete() {
        return qicheDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setQicheDelete(Integer qicheDelete) {
        this.qicheDelete = qicheDelete;
    }
    /**
	 * 获取：汽车简介
	 */
    public String getQicheContent() {
        return qicheContent;
    }


    /**
	 * 设置：汽车简介
	 */
    public void setQicheContent(String qicheContent) {
        this.qicheContent = qicheContent;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
