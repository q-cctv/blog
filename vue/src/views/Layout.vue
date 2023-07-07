<template>
  <div style="height: 100vh;overflow: hidden">
    <div style="display: flex">
      <div style="flex: 1">
        <el-menu :default-active="$route.path"  mode="horizontal"
                 background-color="#545c64"
                 text-color="#fff"
                 active-text-color="#ffd04b" laber-width="100">
          <el-menu-item index="1">首页</el-menu-item>
          <el-menu-item index="1">简历</el-menu-item>
          <el-menu-item index="1">博客</el-menu-item>
          <el-menu-item index="1">留言</el-menu-item>
          <el-menu-item index="1">文章</el-menu-item>
          <el-menu-item index="1"></el-menu-item>
        </el-menu>
      </div>
      <div style="width: 80px;background-color:#545c64;text-align: center;">
        <el-dropdown :hide-on-click="false" style="margin-top: 20px">
  <span class="el-dropdown-link" style="color: white;">
    管理员<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item><span style="color: black" @click="layout">退出</span></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
  </div>
    <div>
      <router-view/>
    </div>
  </div>

</template>

<script>
export default {
  name: "Layout",
  data(){
    return{

    }
  },
  methods:{
    layout(){
      this.$router.push('/login')
    }
  }
}
</script>

<style>
</style>