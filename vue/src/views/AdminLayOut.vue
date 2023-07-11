<template>
  <div style="display: flex">
    <div style="width: 200px;height: 100vh">
      <div style="height: 50px;width: 200px;background-color: cornflowerblue"><span style="font-size: 30px;">后台管理系统</span></div>
      <el-menu
          :default-active="$route.path" router
          class="el-menu-vertical-demo"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
        <el-menu-item index="AdminHome">
          <i class="el-icon-menu"></i>
          <span slot="title">首页</span>
        </el-menu-item>
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>用户管理</span>
          </template>
          <el-menu-item-group>
            <template slot="title">用户权限</template>
            <el-menu-item index="UserRights">用户权限</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </div>
    <div style="flex: 1;background-color: white;position: relative;">
      <div style="display: flex;background-color: #545c64">
        <div style="flex: 1;"></div>
        <div style="text-align: right;width: 100px">
          <img src="@/assets/logo.png" style="width: 40px;height: 40px;">
        </div>
      </div>
      <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: "AdminLayOut"
}
</script>

.el-aside {
background-color: #D3DCE6;
color: #333;
text-align: center;
line-height: 200px;
}

.el-main {
background-color: #E9EEF3;
color: #333;
text-align: center;
line-height: 160px;
}