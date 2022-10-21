<template>
  <section v-show="products.length>0">
    <base-card>
      <div class="controls"></div>
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
  </section>
</template>

<script>

import baseCard from "@/components/BaseCard";
import ProductComponent from "@/components/ProductComponent";
export default {
  name: "ProductsView",
  components: {ProductComponent, baseCard},

  data() {
    return {
      products: [],
      errorMessage: null,
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
    }
  },
  mounted() {
    this.getProducts();
  },
}
</script>

<style scoped>

</style>