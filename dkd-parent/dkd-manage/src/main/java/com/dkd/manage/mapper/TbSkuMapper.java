package com.dkd.manage.mapper;

import java.util.List;
import com.dkd.manage.domain.TbSku;

/**
 * 商品管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-09-25
 */
public interface TbSkuMapper 
{
    /**
     * 查询商品管理
     * 
     * @param skuId 商品管理主键
     * @return 商品管理
     */
    public TbSku selectTbSkuBySkuId(Long skuId);

    /**
     * 查询商品管理列表
     * 
     * @param tbSku 商品管理
     * @return 商品管理集合
     */
    public List<TbSku> selectTbSkuList(TbSku tbSku);

    /**
     * 新增商品管理
     * 
     * @param tbSku 商品管理
     * @return 结果
     */
    public int insertTbSku(TbSku tbSku);

    /**
     * 修改商品管理
     * 
     * @param tbSku 商品管理
     * @return 结果
     */
    public int updateTbSku(TbSku tbSku);

    /**
     * 删除商品管理
     * 
     * @param skuId 商品管理主键
     * @return 结果
     */
    public int deleteTbSkuBySkuId(Long skuId);

    /**
     * 批量删除商品管理
     * 
     * @param skuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbSkuBySkuIds(Long[] skuIds);


    /**
     * 批量新增商品管理
     *
     * @param list
     * @return 结果
     */
    int insertSkus(List<TbSku> list);
}
