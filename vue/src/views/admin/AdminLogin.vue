<template>
  <div style="position: relative;height: 100vh">
    <div style="width: 300px;height: 260px;text-align: center;
    position: absolute;top:25%;left: 30%;background-color: white;font-weight: bold;padding:50px" >
      <div style="margin-bottom: 50px">
        <span style="font-size: 30px;">后台登录</span>
      </div>
      <el-form :model="form" status-icon :rules="rules" ref="ruleForm" label-width="80px" class="demo-ruleForm">
        <el-form-item label="账号" prop="username">
          <el-input type="text" v-model="form.username" autocomplete="off" style="width: 200px"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="text" v-model="form.password" autocomplete="off" style="width: 200px"></el-input>
        </el-form-item>
        <el-form-item label-width="100">
          <el-button type="primary" @click="login" >登录</el-button>
          <el-button @click="reset">重置</el-button>
          <el-button @click="$router.push('/register')">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>

</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie"
export default {
  name: "AdminLogin",
  data(){
    return{
      form:{},
      rules: {
        username: [
          {required: true, message: '请输入账号', trigger: 'blur'},
        ],
      }
    }
  },
  methods:{
    reset(){
      this.form={}
    },
    login(){
      this.$refs['ruleForm'].validate((valid) => {
        if (valid) {
          request.post('/adminLogin/login',this.form).then(res=>{
            if(res.code==='200'){
              Cookies.set('admin',JSON.stringify(res.data))
              this.$router.push('/adminLayOut')
              console.log(res.data)
              this.$notify.success("登录成功")
            }else {
              this.$notify.error(res.msg)
            }
          })
        } else {
          this.$notify.error("请输入账号在登录")
        }
      });

    }
  }
}
</script>