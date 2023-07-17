<template>
  <div style="position: relative;width: 400px;height: 400px">
    <div style="width: 400px;height: 400px;position: absolute;top:5%;left: 61%">
      <!--      <div style="width: 50px;height: 50px;padding-bottom: 20px;padding-left: 50%">-->
      <!--        <el-image :src="form.cover" :preview-src-list="[form.cover]"-->
      <!--                  style="border-radius: 50%;"></el-image>-->
      <!--      </div>-->
      <div style="width: 50px;height: 50px;padding-bottom: 35%;padding-left: 35%">
        <el-upload
            class="avatar-uploader"
            :action="`http://localhost:9090/admin/upload`"
            :show-file-list="false"
            :on-success="handleAvatarSuccess">
<!--          <img v-if="cover" :src="require('@/assets/img/'+form.cover)" class="avatar" v-model="this.form.cover"-->
<!--          >-->
          <img v-if="form.cover" :src="form.cover" class="avatar" v-model="this.form.cover"
          >
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </div>
      <div style="margin-bottom: 15px;padding-left: 45%">
        <span>点击头像修改</span>
      </div>
      <div>
        <el-form :model="form" label-width="80px">
          <el-form-item label="账号">
            <el-input v-model="form.username" disabled></el-input>
          </el-form-item>
          <el-form-item label="电话">
            <el-input v-model="form.phone"></el-input>
          </el-form-item>
          <el-form-item label="邮箱">
            <el-input v-model="form.email"></el-input>
          </el-form-item>
          <el-form-item label="地址">
            <el-input v-model="form.address"></el-input>
          </el-form-item>
          <el-form-item style="padding-left:80px">
            <el-button type="primary" @click="submit">修改</el-button>
            <el-button @click="$router.push('/')">返回</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>

</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie";

export default {
  name: "PersonMessage",
  data() {
    return {
      cover: '',
      form: {},
      id: null
    }
  },
  created() {
    this.load()
  },
  methods: {

    load() {
      this.id = JSON.parse(Cookies.get('admin')).id
      request.get('/admin/' + this.id).then(res => {
        if (res.code === '200') {
          console.log(res.data)
          this.form = res.data
          this.cover = res.data.cover
        }
      })
    },
    handleAvatarSuccess(res) {
      this.form.cover = res.data
    },
    submit() {
      request.put('/admin/update', this.form).then(res => {
        if (res.code === '200') {
          this.$notify.success("修改成功")
          location.reload();
        }
      })
    }
  }

}
</script>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 50%;
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
  border-radius: 50%;
}
</style>