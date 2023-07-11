<template>
  <div>
    <el-button type="primary" style="font-size: 15px">新增用户</el-button>
    <el-table
        :data="tableData"
        style="width: 100%" stripe>
      <el-table-column
          prop="id"
          label="编号"
          width="70">
      </el-table-column>
      <el-table-column
          prop="username"
          label="账号"
          width="70">
      </el-table-column>
      <el-table-column
          prop="password"
          label="密码" width="300">
      </el-table-column>
      <el-table-column
          prop="stauts"
          label="状态">
        <template v-slot="scope">
          <el-switch
              v-model="scope.row.status"
              @change="changeStatus(scope.row)"
              active-color="#13ce66"
              inactive-color="#ff4949">
          </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="230">
        <template v-slot="scope">
          <el-button slot="reference" type="primary" style="margin-left: 2px" @click="openEdit(scope.row)">编辑</el-button>
          <el-dialog title="修改用户信息" :visible.sync="dialogFormVisible">
            <el-form :model="form">
              <el-form-item label="账号" >
                <el-input v-model="form.username" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="密码" >
                <el-input v-model="form.password" autocomplete="off" disabled></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="updateUser">确 定</el-button>
            </div>
          </el-dialog>
          <el-popconfirm
              title="确定删除吗？"
              @confirm="del(scope.row.id)"
          >
            <el-button slot="reference" type="danger" style="margin-left: 2px">删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "UserRights",
  data() {
    return {
      tableData: [],
      form:{},
      dialogFormVisible:false
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      request.get('/admin/getAll').then(res => {
        if (res.code === '200') {
          this.tableData = res.data
        }
      })
    },
    changeStatus(row) {
      // JSON.parse(JSON.stringify(row))
      request.put('/admin/update', row).then(res => {
        if (res.code === '200') {
          this.$notify.success("操作成功")
          this.load()
        }
      })
    },
    del(id) {
      console.log(id)
      request.delete('/admin/delete/' + id).then(res => {
        if (res.code === '200') {
          this.$notify.success("删除成功")
          this.load()
        }
      })
    },
    openEdit(row){
      // request.get('/admin/' + id).then(res=>{
      //   this.form=res.data
      // })
      this.form=row
      this.dialogFormVisible=true
    },
    updateUser(){
      request.put('/admin/update', this.form).then(res => {
        if (res.code === '200') {
          this.$notify.success("修改成功")
          this.dialogFormVisible=false
          this.load()
        }
      })
    }
  },

}
</script>

<style scoped>

</style>