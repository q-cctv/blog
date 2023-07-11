import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from "@/views/Layout";
import AdminLayOut from "@/views/AdminLayOut"
import Cookies from "js-cookie";

Vue.use(VueRouter)

const routes = [
    {
        path: '/login',
        name: 'Login',
        component: () => import('@/views/login/Login')
    },
    {
        path: '/adminLogin',
        name: 'adminLogin',
        component: () => import('@/views/admin/AdminLogin')
    },
    {
        path: '/adminLayOut/',
        name: 'AdminLayOut',
        component: AdminLayOut,
        redirect: '/adminLayOut/adminHome',
        children: [
            {
                path: 'adminHome',
                name: 'AdminHome',
                component: () => import('@/views/admin/home/AdminHome')
            },
            {
                path: 'userRights',
                name: 'UserRights',
                component: () => import('@/views/admin/UserRights')
            },
        ]
    },

    //前台
    {
        path: '/register',
        name: 'Register',
        component: () => import('@/views/register/Register')
    },
    {
        path: '/',
        name: 'Layout',
        component: Layout,
        redirect: '/home',
        children: [
            {
                path: 'home',
                name: 'Home',
                component: () => import('@/views/home/Home')
            },
            {
                path: 'personMessage',
                name: 'PersonMessage',
                component: () => import('@/views/login/PersonMessage')
            },
        ]
    },
    {
        path: '/*',
        name: '404',
        component: () => import('@/views/404')
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})
router.beforeEach((to, form, next) => {
    if (to.path === '/login' || to.path === '/register') {
        next()
    }
    const admin = Cookies.get('admin')
    if (!admin && to.path !== '/login' && to.path !== '/register') {
        return next('/login')
    }
    next()
})
export default router
