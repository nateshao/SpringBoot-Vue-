<template>
  <div>
    <table>
      <tr>
        <td>编号</td>
        <td>图书名称</td>
        <td>作者</td>
      </tr>
      <tr v-for="item in books">
        <td>{{item.id}}</td>
        <td>{{item.name}}</td>
        <td>{{item.author}}</td>
      </tr>
    </table>
    {{msg}}
  </div>
</template>

<script>
  export default {
    name:"Book",
    data(){
      return{
        msg:"Hello Vue",
        books:[{
            id: 1 ,
            name: '千羽',
            author: '千羽的编程之路'
        },{
          id: 2 ,
          name: '千寻',
          author: 'SpringBoot-Vue 前后端分离开发'
        },{
          id: 3 ,
          name: '小明',
          author: 'SpringBoot入门到精通'
        }
        ]
      }
    },
    created() {
      const _this = this
      axios.get('http://localhost:8181/book/findAll').then(function(resp){
//        console.log(resp)
        _this.books = resp.data
//        _this.pageSize = resp.data.size
//        _this.total = resp.data.totalElements
      })
  }
  }

</script>

<style scoped="">

</style>
