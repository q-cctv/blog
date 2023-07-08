import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from "@/views/Layout";
import Cookies from "js-cookie";
Vue.use(VueRouter)

const routes = [
    {
        path: '/login',
        name: 'Login',
        component: () => import('@/views/login/Login')
    },
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
                path: '/home',
                name: 'Home',
                component: () => import('@/views/home/Home')
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
    if (to.path === '/login'|| to.path==='/register') {
        next()
    }
    const admin = Cookies.get('admin')
    if (!admin && to.path !== '/login'&& to.path !== '/register') {
        return next('/login')
    }
    next()
})
export default router
