package com.dao;

import com.entity.QicheShijiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QicheShijiaView;

/**
 * 汽车试驾预定 Dao 接口
 *
 * @author 
 */
public interface QicheShijiaDao extends BaseMapper<QicheShijiaEntity> {

   List<QicheShijiaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
