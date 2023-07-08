<template>
  <div style="height: 100vh;overflow: hidden">
    <div style="display: flex">
      <div style="flex: 1">
        <el-menu :default-active="$route.path" mode="horizontal"
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
      <div style="width: 130px;background-color:#545c64;text-align: center;position: relative">
        <el-image :src="admin.cover" :preview-src-list="[admin.cover]"
                  style="width: 40px;height: 40px;position: absolute;left: 35px;border-radius: 50%"></el-image>
        <el-dropdown :hide-on-click="false" style="margin-top: 39px">
  <span class="el-dropdown-link" style="color: white;">
    {{ admin.username }}<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item><span style="color: black" @click="changePass">修改密码</span></el-dropdown-item>
            <el-dropdown-item><span style="color: black" @click="layout">退出</span></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <el-dialog title="修改密码" :visible.sync="dialogFormVisible">
          <el-form :model="form">
            <el-form-item label="密码" prop="newPass">
              <el-input v-model="form.newPass" autocomplete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="passSave">确 定</el-button>
          </div>
        </el-dialog>
      </div>
    </div>
    <div>
      <router-view/>
    </div>
  </div>

</template>

<script>
import Cookies from "js-cookie";
import request from "@/utils/request";

export default {
  name: "Layout",
  data() {
    return {
      admin: JSON.parse(Cookies.get('admin')),
      id: null,
      form: {},
      dialogFormVisible: false
    }
  },
  created() {

  },
  methods: {
    layout() {
      Cookies.remove("admin")
      this.$router.push('/login')

    },
    changePass() {
      this.dialogFormVisible = true
      this.form = this.admin
    },
    passSave() {
      request.post('/admin/updatePass', this.form).then(res => {
        if (res.code === '200') {
          this.$notify.success("修改成功")
          this.dialogFormVisible = false
        }
      })
    }
  }
}
</script>

<style>
</style>