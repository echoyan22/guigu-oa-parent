package com.atguigu.auth;

import com.atguigu.auth.mapper.SysRoleMapper;
import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMpDemo1 {

    @Autowired
    private SysRoleMapper mapper;
    @Test
    public void selectAll(){
        List<SysRole> sysRoles = mapper.selectList(null);
        System.out.println(sysRoles);
    }

    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("echo");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");

        int rows = mapper.insert(sysRole);
        System.out.println(rows);
        System.out.println(sysRole);
    }

    @Test
    public void update(){
        SysRole sysRole = new SysRole();
        sysRole.setId(1L);
        sysRole.setRoleName("角色管理员1");
        int result = mapper.updateById(sysRole);
        System.out.println(result);
    }

    @Test
    public void testDeleteById(){
        int result = mapper.deleteById(2L);
        System.out.println(result);
    }

    @Test
    public void testQuery(){
//        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
//        wrapper.eq("role_name","echo");

        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleName,"echo");

        List<SysRole> sysRoles = mapper.selectList(wrapper);
        System.out.println(sysRoles);
    }
}
