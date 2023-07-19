<template>
  <div class="block">
    <el-carousel height="600px" interval="1000">
      <el-carousel-item v-for="item in form" :key="item.id">
        <el-image :src="item.pictur"></el-image>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Home",
  data(){
    return{
      form:[]
    }
  },
  created() {
    this.load()
  },
  methods:{
    load() {
      request.get('/picture/listStatus').then(res => {
        if (res.code === '200') {
          console.log(res.data)
          this.form = res.data
        }
      })
    },
  }
}
</script>

<style>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>