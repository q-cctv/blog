<template>
  <div style="position: relative;height: 100vh;overflow: hidden">
    <div style="width: 300px;height: 400px;text-align: center;
    position: absolute;top:10%;left: 30%;background-color: white;font-weight: bold;padding:50px">
      <div style="margin-bottom: 50px">
        <span style="font-size: 30px;">注册</span>
      </div>
      <el-form :model="form" status-icon :rules="rules" ref="ruleForm" label-width="80px" class="demo-ruleForm">
        <el-form-item label="账号" prop="username">
          <el-input type="text" v-model="form.username" autocomplete="off" style="width: 200px" @click="yy"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="text" v-model="form.password" autocomplete="off" style="width: 200px"></el-input>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input type="text" v-model="form.phone" autocomplete="off" style="width: 200px"></el-input>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input type="text" v-model="form.address" autocomplete="off" style="width: 200px"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input type="text" v-model="form.email" autocomplete="off" style="width: 200px"></el-input>
        </el-form-item>
        <el-form-item label-width="100">
          <el-button type="primary" @click="registerSave">提交</el-button>
          <el-button @click="reset">重置</el-button>
          <el-button @click="$router.push('/login')">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Register",
  data() {
    return {
      form: {},
      rules: {
        username: [
          {required: true, message: '请输入账号', trigger: 'blur'},
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
        ],
      }
    }
  },
  created() {

  },
  methods: {
    reset() {
      this.form = {}
    },
    registerSave() {
      this.$refs['ruleForm'].validate((valid) => {
        if (valid) {
          request.post('/admin/register', this.form).then(res => {
            if (res.code === '200') {
              this.$notify.success("注册成功")
            }else {
              this.$notify.error(res.msg)
            }
          })
        } else {
          this.$notify.error("请填写完整在提交")
        }
      });

    }
  }
}
</script>

<style scoped>

</style>