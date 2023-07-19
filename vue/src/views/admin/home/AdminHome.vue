<template>
  <div style="display: flex">
    <div style="width: 130px;height: 80px;background-color: #409eff;margin-top: 30px;margin-left:15px;font-size: 20px;position: relative">
      <span style="position: absolute;top:25px;left: 10px">用户统计：{{ userCount }}</span>
    </div>
    <div style="width: 130px;height: 80px;background-color: #409eff;margin-top: 30px;margin-left:15px;font-size: 20px;position: relative">
      <span style="position: absolute;top:25px;left: 10px">图片统计：{{ pictureCount }}</span></div>
    <div style="width: 180px;height: 80px;background-color: #409eff;margin-top: 30px;margin-left:15px;font-size: 20px;position: relative">
      <span style="position: absolute;top:25px;left: 10px">禁用图片统计：{{ disabledPictureCount }}</span></div>
    <div style="width: 130px;height: 80px;background-color: #409eff;margin-top: 30px;margin-left:15px;"></div>
  </div>
</template>
<script>
import request from "@/utils/request";

export default {
  name: "AdminHome",
  data() {
    return {
      userCount: '',
      pictureCount: '',
      usePictureCount:'',
      disabledPictureCount:''
    }
  },
  created() {
    request.get('/admin/getAll').then(res => {
      if (res.code === '200') {
        console.log(res.data.length)
        this.userCount = res.data.length
      }
    }),
        request.get('/picture/list').then(res => {
          if (res.code === '200') {
            console.log(res.data.length)
            this.pictureCount = res.data.length
          }
        }),
        request.get('/picture/listStatus').then(res => {
          if (res.code === '200') {

            this.usePictureCount = res.data.length
            this.disabledPictureCount=Math.abs(this.pictureCount - this.usePictureCount)
            console.log(this.disabledPictureCount)
          }
        })
  },
  methods: {}
}

</script>

<style>

</style>