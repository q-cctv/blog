<template>
  <div style="position: relative">
    <div style="position: absolute;top:100px;left: 30%">
      <el-upload
          class="avatar-uploader"
          :action="`http://localhost:9090/admin/upload`"
          :show-file-list="false"
          :on-success="handleAvatarSuccess">
        <img v-if="pictur" :src="form.pictur" class="avatar" v-model="form.pictur"/>
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>
    </div>
    <div style="position: absolute;top:320px;left: 35%">
      <el-button type="primary" @click="save">提交</el-button>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Add",
  data(){
    return{
      pictur:'',
      form:{}
    }
  },
  created() {
  },
  methods:{
    save(){
      request.post('/picture/add',this.form).then(res=>{
        if(res.code==='200'){
          this.$notify.success("新增成功")
          this.$router.push('/adminLayOut/picture')

        }else {
          this.$notify.error(res.msg)
        }
      })
    },
    handleAvatarSuccess(res) {
      console.log(res)
      this.pictur=res.data
      this.form.pictur=res.data
    },
  }
}
</script>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>