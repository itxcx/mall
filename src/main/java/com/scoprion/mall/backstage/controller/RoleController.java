package com.scoprion.mall.backstage.controller;

import com.alibaba.fastjson.JSONObject;
import com.scoprion.mall.backstage.service.role.RoleService;
import com.scoprion.mall.domain.SysMenu;
import com.scoprion.mall.domain.SysRole;
import com.scoprion.result.BaseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ycj
 * @version V1.0 <角色控制器>
 * @date 2017-11-21 16:36
 */
@RestController
@RequestMapping("/backstage/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 角色列表
     *
     * @param pageNo
     * @param pageSize
     * @param searchKey
     * @return
     */
    @ApiOperation("角色列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResult findByCondition(Integer pageNo, Integer pageSize, String searchKey) {
        return roleService.findByCondition(pageNo, pageSize, searchKey);
    }

    /**
     * 角色添加
     *
     * @param sysRole
     * @return
     */
    @ApiOperation("角色添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody SysRole sysRole) {
        return roleService.add(sysRole);
    }

    /**
     * 角色修改
     *
     * @param sysRole
     * @return
     */
    @ApiOperation("角色修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public BaseResult modify(@RequestBody SysRole sysRole) {
        return roleService.modify(sysRole);
    }

    /**
     * 角色详情
     *
     * @param id
     * @return
     */
    @ApiOperation("角色详情")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public BaseResult findById(Long id) {
        return roleService.findById(id);
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @ApiOperation("删除角色")
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public BaseResult deleteById(Long id) {
        return roleService.deleteById(id);
    }

    /**
     * 为角色分配菜单
     *
     * @param jsonObject
     * @return
     */
    @ApiOperation("角色分配菜单")
    @RequestMapping(value = "/allocatedMenus", method = RequestMethod.POST)
    public BaseResult allocatedMenus(@RequestBody JSONObject jsonObject) {
        Long roleId = jsonObject.getLong("roleId");
        List<Long> menusId = jsonObject.getJSONArray("menusId").toJavaList(Long.class);
        return roleService.allocationMenu(roleId, menusId);
    }

    /**
     * 用户分配角色
     *
     * @param userId
     * @param roleId
     * @return
     */
    @ApiOperation("用户分配角色")
    @RequestMapping(value = "/bindRole", method = RequestMethod.POST)
    public BaseResult bindRole(Long userId, Long roleId) {
        return roleService.bindRole(userId, roleId);
    }

}