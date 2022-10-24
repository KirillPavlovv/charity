import Vue from 'vue'
import VueRouter from 'vue-router'
import ProductsView from "@/views/ProductsView";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        redirect: '/products'
    },
    {
        path: '/products',
        name: 'products',
        component: ProductsView
    },
]

const router = new VueRouter({
    routes,
    // mode: 'history'
})

export default router
