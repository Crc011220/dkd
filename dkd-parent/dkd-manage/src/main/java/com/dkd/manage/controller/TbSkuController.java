package com.dkd.manage.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dkd.common.annotation.Log;
import com.dkd.common.core.controller.BaseController;
import com.dkd.common.core.domain.AjaxResult;
import com.dkd.common.enums.BusinessType;
import com.dkd.manage.domain.TbSku;
import com.dkd.manage.service.ITbSkuService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商品管理Controller
 * 
 * @author ruoyi
 * @date 2024-09-25
 */
@RestController
@RequestMapping("/manage/sku")
public class TbSkuController extends BaseController
{
    @Autowired
    private ITbSkuService tbSkuService;

    /**
     * 查询商品管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:sku:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbSku tbSku)
    {
        startPage();
        List<TbSku> list = tbSkuService.selectTbSkuList(tbSku);
        return getDataTable(list);
    }

    /**
     * 导出商品管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:sku:export')")
    @Log(title = "商品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbSku tbSku)
    {
        List<TbSku> list = tbSkuService.selectTbSkuList(tbSku);
        ExcelUtil<TbSku> util = new ExcelUtil<TbSku>(TbSku.class);
        util.exportEasyExcel(response, list, "商品管理数据");
    }


    /**
     * 导入商品管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:sku:add')")
    @Log(title = "商品管理", businessType = BusinessType.IMPORT)
    @PostMapping("/import")
    public AjaxResult excelImport(MultipartFile file) throws Exception {
        ExcelUtil<TbSku> util = new ExcelUtil<TbSku>(TbSku.class);
        List<TbSku> list = util.importEasyExcel(file.getInputStream());
        return toAjax(tbSkuService.insertSkus(list));
    }

    /**
     * 获取商品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:sku:query')")
    @GetMapping(value = "/{skuId}")
    public AjaxResult getInfo(@PathVariable("skuId") Long skuId)
    {
        return success(tbSkuService.selectTbSkuBySkuId(skuId));
    }

    /**
     * 新增商品管理
     */
    @PreAuthorize("@ss.hasPermi('manage:sku:add')")
    @Log(title = "商品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbSku tbSku)
    {
        return toAjax(tbSkuService.insertTbSku(tbSku));
    }

    /**
     * 修改商品管理
     */
    @PreAuthorize("@ss.hasPermi('manage:sku:edit')")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbSku tbSku)
    {
        return toAjax(tbSkuService.updateTbSku(tbSku));
    }

    /**
     * 删除商品管理
     */
    @PreAuthorize("@ss.hasPermi('manage:sku:remove')")
    @Log(title = "商品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{skuIds}")
    public AjaxResult remove(@PathVariable Long[] skuIds)
    {
        return toAjax(tbSkuService.deleteTbSkuBySkuIds(skuIds));
    }


}
