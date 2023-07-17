<template>
  <div>
    <el-button type="primary" style="font-size: 15px" @click="$router.push('/adminLayOut/add')">新增图片</el-button>
    <el-table
        :data="tableData"
        style="width: 100%" stripe>
      <el-table-column
          prop="id"
          label="编号"
          width="90">
      </el-table-column>
      <el-table-column
          prop="pictur"
          label="图片名称"
          width="210">
      </el-table-column>
      <el-table-column
          prop="pictur"
          label="图片路径"
          width="130">
        <template v-slot="scope">
          <el-image :src="scope.row.pictur" :preview-src-list="[scope.row.pictur]"></el-image>
        </template>
      </el-table-column>
      <el-table-column
          style="margin-left: 20px"
          prop="stauts"
          label="状态"
          width="130">
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
          <el-dialog title="修改图片" :visible.sync="dialogFormVisible">
            <el-form :model="form">
              <el-form-item label="图片" >
                <el-input v-model="form.pictur" autocomplete="off"></el-input>
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
      request.get('/picture/list').then(res => {
        if (res.code === '200') {
          console.log(res.data)
          this.tableData = res.data
        }
      })
    },
    changeStatus(row) {
      // JSON.parse(JSON.stringify(row))
      request.put('/picture/update', row).then(res => {
        if (res.code === '200') {
          this.$notify.success("操作成功")
          this.load()
        }
      })
    },
    del(id) {
      console.log(id)
      request.delete('/picture/delete/' + id).then(res => {
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

<style >
.el-switch__core{
  margin: 1px;
}
.el-table th.el-table__cell>.cell{
  margin-left: 43px;
}
.el-table .cell{
  margin-left: 43px;
}
</style>