package com.dkd.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.bean.BeanUtil;
import com.dkd.common.constant.DkdContants;
import com.dkd.common.utils.DateUtils;
import com.dkd.common.utils.uuid.UUIDUtils;
import com.dkd.manage.domain.Channel;
import com.dkd.manage.domain.Node;
import com.dkd.manage.domain.VmType;
import com.dkd.manage.service.IChannelService;
import com.dkd.manage.service.INodeService;
import com.dkd.manage.service.IVmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.VendingMachineMapper;
import com.dkd.manage.domain.VendingMachine;
import com.dkd.manage.service.IVendingMachineService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 设备管理Service业务层处理
 * 
 * @author Ruochen
 * @date 2024-09-24
 */
@Service
public class VendingMachineServiceImpl implements IVendingMachineService 
{
    @Autowired
    private VendingMachineMapper vendingMachineMapper;

    @Autowired
    private IVmTypeService typeService;

    @Autowired
    private INodeService nodeService;

    @Autowired
    private IChannelService channelService;

    /**
     * 查询设备管理
     * 
     * @param id 设备管理主键
     * @return 设备管理
     */
    @Override
    public VendingMachine selectVendingMachineById(Long id)
    {
        return vendingMachineMapper.selectVendingMachineById(id);
    }

    /**
     * 查询设备管理列表
     * 
     * @param vendingMachine 设备管理
     * @return 设备管理
     */
    @Override
    public List<VendingMachine> selectVendingMachineList(VendingMachine vendingMachine)
    {
        return vendingMachineMapper.selectVendingMachineList(vendingMachine);
    }

    /**
     * 新增设备管理
     * 
     * @param vendingMachine 设备管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertVendingMachine(VendingMachine vendingMachine)
    {

        //新增设备
        String innerCode = UUIDUtils.getUUID();
        vendingMachine.setInnerCode(innerCode);

        VmType vmType = typeService.selectVmTypeById(vendingMachine.getVmTypeId());
        vendingMachine.setChannelMaxCapacity(vmType.getChannelMaxCapacity());

        Node node = nodeService.selectNodeById(vendingMachine.getVmTypeId());
        BeanUtil.copyProperties(node, vendingMachine,"id");
        vendingMachine.setAddr(node.getAddress());

        vendingMachine.setVmStatus(DkdContants.VM_STATUS_NODEPLOY);

        vendingMachine.setCreateTime(DateUtils.getNowDate());
        vendingMachine.setUpdateTime(DateUtils.getNowDate());


        int result = vendingMachineMapper.insertVendingMachine(vendingMachine);

        //新增货道
        List<Channel> channelList = new ArrayList<>();

        for (int i = 0; i <= vmType.getVmRow(); i++) {
            for (int j = 0; j <= vmType.getVmCol(); j++) {
                Channel channel = new Channel();
                channel.setChannelCode(i+"-"+j);
                channel.setVmId(vendingMachine.getId());
                channel.setInnerCode(vendingMachine.getInnerCode());
                channel.setMaxCapacity(vendingMachine.getChannelMaxCapacity());
                channel.setCreateTime(DateUtils.getNowDate());
                channel.setUpdateTime(DateUtils.getNowDate());
                channelList.add(channel);

            }
        }
        channelService.batchInsertChannels(channelList);
        return result;

    }

    /**
     * 修改设备管理
     * 
     * @param vendingMachine 设备管理
     * @return 结果
     */
    @Override
    public int updateVendingMachine(VendingMachine vendingMachine)
    {
        //查询点位表，补充区域点位合作商等信息
        if(vendingMachine.getNodeId()!=null){
            Node node = nodeService.selectNodeById(vendingMachine.getNodeId());
            BeanUtil.copyProperties(node, vendingMachine,"id");//商圈类型，区域，合作商
            vendingMachine.setAddr(node.getAddress());//设备地址
        }

        vendingMachine.setUpdateTime(DateUtils.getNowDate());//更新时间
        return vendingMachineMapper.updateVendingMachine(vendingMachine);
    }

    /**
     * 批量删除设备管理
     * 
     * @param ids 需要删除的设备管理主键
     * @return 结果
     */
    @Override
    public int deleteVendingMachineByIds(Long[] ids)
    {
        return vendingMachineMapper.deleteVendingMachineByIds(ids);
    }

    /**
     * 删除设备管理信息
     * 
     * @param id 设备管理主键
     * @return 结果
     */
    @Override
    public int deleteVendingMachineById(Long id)
    {
        return vendingMachineMapper.deleteVendingMachineById(id);
    }

    /**
     * 根据设备编号查询设备信息
     *
     * @param innerCode
     * @return VendingMachine
     */
    @Override
    public VendingMachine selectVendingMachineByInnerCode(String innerCode) {
        return vendingMachineMapper.selectVendingMachineByInnerCode(innerCode);
    }
}
