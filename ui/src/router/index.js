import Vue from 'vue'
import VueRouter from 'vue-router'
import ProductsView from "@/views/ProductsView";
import ItemsInsertView from "@/views/ItemsInsertView";

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
        path: '/insert-items',
        name: 'insertion',
        component: ItemsInsertView
    },

]

const router = new VueRouter({
    routes,
    // mode: 'history'
})

export default router
