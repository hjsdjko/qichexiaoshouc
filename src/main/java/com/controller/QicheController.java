
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 汽车
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qiche")
public class QicheController {
    private static final Logger logger = LoggerFactory.getLogger(QicheController.class);

    @Autowired
    private QicheService qicheService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("qicheDeleteStart",1);params.put("qicheDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = qicheService.queryPage(params);

        //字典表数据转换
        List<QicheView> list =(List<QicheView>)page.getList();
        for(QicheView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QicheEntity qiche = qicheService.selectById(id);
        if(qiche !=null){
            //entity转view
            QicheView view = new QicheView();
            BeanUtils.copyProperties( qiche , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody QicheEntity qiche, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qiche:{}",this.getClass().getName(),qiche.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<QicheEntity> queryWrapper = new EntityWrapper<QicheEntity>()
            .eq("qiche_name", qiche.getQicheName())
            .eq("qiche_types", qiche.getQicheTypes())
            .eq("qiche_kucun_number", qiche.getQicheKucunNumber())
            .eq("qiche_clicknum", qiche.getQicheClicknum())
            .eq("shangxia_types", qiche.getShangxiaTypes())
            .eq("qiche_delete", qiche.getQicheDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QicheEntity qicheEntity = qicheService.selectOne(queryWrapper);
        if(qicheEntity==null){
            qiche.setQicheClicknum(1);
            qiche.setShangxiaTypes(1);
            qiche.setQicheDelete(1);
            qiche.setCreateTime(new Date());
            qicheService.insert(qiche);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QicheEntity qiche, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,qiche:{}",this.getClass().getName(),qiche.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<QicheEntity> queryWrapper = new EntityWrapper<QicheEntity>()
            .notIn("id",qiche.getId())
            .andNew()
            .eq("qiche_name", qiche.getQicheName())
            .eq("qiche_types", qiche.getQicheTypes())
            .eq("qiche_kucun_number", qiche.getQicheKucunNumber())
            .eq("qiche_clicknum", qiche.getQicheClicknum())
            .eq("shangxia_types", qiche.getShangxiaTypes())
            .eq("qiche_delete", qiche.getQicheDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QicheEntity qicheEntity = qicheService.selectOne(queryWrapper);
        if("".equals(qiche.getQichePhoto()) || "null".equals(qiche.getQichePhoto())){
                qiche.setQichePhoto(null);
        }
        if(qicheEntity==null){
            qicheService.updateById(qiche);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<QicheEntity> list = new ArrayList<>();
        for(Integer id:ids){
            QicheEntity qicheEntity = new QicheEntity();
            qicheEntity.setId(id);
            qicheEntity.setQicheDelete(2);
            list.add(qicheEntity);
        }
        if(list != null && list.size() >0){
            qicheService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<QicheEntity> qicheList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            QicheEntity qicheEntity = new QicheEntity();
//                            qicheEntity.setQicheName(data.get(0));                    //汽车名称 要改的
//                            qicheEntity.setQichePhoto("");//详情和图片
//                            qicheEntity.setQicheTypes(Integer.valueOf(data.get(0)));   //汽车类型 要改的
//                            qicheEntity.setQicheKucunNumber(Integer.valueOf(data.get(0)));   //汽车库存 要改的
//                            qicheEntity.setQicheOldMoney(data.get(0));                    //汽车原价 要改的
//                            qicheEntity.setQicheNewMoney(data.get(0));                    //现价 要改的
//                            qicheEntity.setQicheClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            qicheEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            qicheEntity.setQicheDelete(1);//逻辑删除字段
//                            qicheEntity.setQicheContent("");//详情和图片
//                            qicheEntity.setCreateTime(date);//时间
                            qicheList.add(qicheEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        qicheService.insertBatch(qicheList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = qicheService.queryPage(params);

        //字典表数据转换
        List<QicheView> list =(List<QicheView>)page.getList();
        for(QicheView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QicheEntity qiche = qicheService.selectById(id);
            if(qiche !=null){

                //点击数量加1
                qiche.setQicheClicknum(qiche.getQicheClicknum()+1);
                qicheService.updateById(qiche);

                //entity转view
                QicheView view = new QicheView();
                BeanUtils.copyProperties( qiche , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody QicheEntity qiche, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,qiche:{}",this.getClass().getName(),qiche.toString());
        Wrapper<QicheEntity> queryWrapper = new EntityWrapper<QicheEntity>()
            .eq("qiche_name", qiche.getQicheName())
            .eq("qiche_types", qiche.getQicheTypes())
            .eq("qiche_kucun_number", qiche.getQicheKucunNumber())
            .eq("qiche_clicknum", qiche.getQicheClicknum())
            .eq("shangxia_types", qiche.getShangxiaTypes())
            .eq("qiche_delete", qiche.getQicheDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QicheEntity qicheEntity = qicheService.selectOne(queryWrapper);
        if(qicheEntity==null){
            qiche.setQicheDelete(1);
            qiche.setCreateTime(new Date());
        qicheService.insert(qiche);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
