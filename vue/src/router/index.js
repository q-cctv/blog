import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from "@/views/Layout";
Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: ()=>import('@/views/login/Login')
  },
  {
    path: '/register',
    name: 'Register',
    component: ()=>import('@/views/register/Register')
  },
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect:'/home',
    children:[
      {
        path: '/home',
        name: 'Home',
        component: ()=>import('@/views/home/Home')
      },
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
