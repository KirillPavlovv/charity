<template>
  <section v-show="products.length>0">

    <ul :key="productKey">
      <product-component v-for="product in products"
                         :key="product.id"
                         :id="product.id"
                         :name="product.name"
                         :price="product.price"
                         :quantity="product.quantity"
                         :image="product.image"
                         :is-edible="product.isEdible"
      ></product-component>
    </ul>
    <base-card>
      <h4> Total amount: {{ parseFloat(orderRequest.totalSum).toFixed(2) }} € </h4>
      <div class="row">
        <div class="col">
          <button class="btn btn-primary w-75 text-white mt-3 mr-1" v-on:click="resetComponent">Reset</button>
        </div>
        <div class="col">
          <checkout-cash-component
              :key="orderRequest.id"
              :order-request="orderRequest"
          ></checkout-cash-component>
        </div>
      </div>
    </base-card>
  </section>

</template>

<script>

import ProductComponent from "@/components/ProductComponent";
import BaseCard from "@/components/BaseCard";
import EventBus from "@/components/event-bus";
import CheckoutCashComponent from "@/components/CheckoutCashComponent";

export default {
  name: "ProductsView",
  components: {BaseCard, ProductComponent, CheckoutCashComponent},

  data() {
    return {
      productKey: 0,
      products: [],
      errorMessage: null,
      isReset: false,
      orderRequest: {
        userId: 'dce2d43e-cfc5-4297-a7e2-bd80535b5cca',
        totalSum: 0,
        soldProducts: [],
      },
    }
  },

  methods: {
    resetComponent() {
      this.getProducts()
      this.productKey += 1;
      this.orderRequest.totalSum = 0
    },

    getProducts: async function(){
      await fetch('products', {
        credentials: "include",
        method: 'GET',
      })
          .then(response => response.json())
          .then(data => {
            this.products = data;
            this.errorMessage = data.title;
          })
          .catch(error => console.error(error));
    },
  },

  mounted() {
    this.getProducts();
    EventBus.$on('orderSubmitted', () => {
      this.$forceUpdate()
      this.resetComponent()

    })
    EventBus.$on('payForItem', data => {
      this.orderRequest.totalSum = this.orderRequest.totalSum + data.price;
      this.orderRequest.soldProducts.push((data.productsStock));
    })
  },
}
</script>

<style scoped>
ul {
  padding-left: 1px;
}

</style>