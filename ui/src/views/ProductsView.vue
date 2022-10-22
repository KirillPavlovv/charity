<template>
  <section v-show="products.length>0">
    <base-card class="controls">
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
    </base-card>
    <base-card>
      Total amount: {{ parseFloat(orderRequest.totalSum).toFixed(2) }} €
    </base-card>
    <base-card>
      <div class="row">
        <div class="col">
          <button class="btn btn-primary w-75 text-white mt-3 mr-1" v-on:click="resetComponent">Reset</button>
        </div>
        <div class="col">
          <button class="btn btn-primary w-75 text-white mt-3" v-on:click="changeProductStock()">Checkout</button>
        </div>
      </div>
    </base-card>
  </section>

</template>

<script>

import ProductComponent from "@/components/ProductComponent";
import BaseCard from "@/components/BaseCard";
import EventBus from "@/components/event-bus";

export default {
  name: "ProductsView",
  components: {BaseCard, ProductComponent},

  data() {
    return {
      productKey: 0,
      products: [],
      errorMessage: null,
      isReset: false,
      orderRequest: {
        userId: '68d94a7c-f387-47cc-abea-17fbe3e9dac8',
        totalSum: 0,
        soldProducts: new Set(),
      }
    }
  },

  methods: {

    resetComponent() {
      this.productKey += 1;
      this.orderRequest.totalSum = 0
    },

    getProducts: async function () {
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

    changeProductStock(){
      console.log(this.orderRequest)
      fetch('orders', {
        credentials: "include",
        method: 'PUT',
        body: JSON.stringify(this.orderRequest),
        headers: {
          'Content-Type': 'application/json'
        }
      })
          .then(response => response.json())
          .then(data => {
            this.errorMessage = data.title;
          })
          .catch(error => console.error(error));
    },
  },

  mounted() {
    this.getProducts();
    EventBus.$on('payForItem', data => {
      this.orderRequest.totalSum = this.orderRequest.totalSum + data.price;
      this.orderRequest.soldProducts.add((data.productStock));
    })
  },
}
</script>

<style scoped>
button {

}

</style>