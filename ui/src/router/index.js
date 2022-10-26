import Vue from 'vue'
import VueRouter from 'vue-router'
import ProductsView from "@/views/ProductsView";
import InsertView from "@/views/InsertView";

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
    {
        path: '/insert',
        name: 'insert',
        component: InsertView
    },
]

const router = new VueRouter({
    routes,
    mode: 'history'
})

export default router
