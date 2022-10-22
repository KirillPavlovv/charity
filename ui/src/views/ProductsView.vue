<template>
  <section v-show="products.length>0">
    <base-card class="controls">
      <ul>
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
      Total amount: {{ parseFloat(amountToPay).toFixed(2) }} €
    </base-card>
    <base-card>
      <div class="row">
        <div class="col">
          <button class="btn btn-primary w-50 text-white mt-3 mr-1" v-on:click="getProducts">Reset</button>
        </div>
        <div class="col">
          <button class="btn btn-primary w-50 text-white mt-3">Checkout</button>
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
      products: [],
      errorMessage: null,
      amountToPay: 0,
    }
  },

  methods: {
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

  },
  mounted() {
    this.getProducts();
    EventBus.$on('payForItem', data => {
      console.log(data)
      this.amountToPay = this.amountToPay + data
    })
  },
}
</script>

<style scoped>
button{

}

</style>