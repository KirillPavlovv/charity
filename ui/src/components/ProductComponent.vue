<template>
  <base-card>
    <a class="navbar-brand d-none d-sm-block" href="/">
    <img :src="source" alt=""></a>

    <h3> Cake: {{ name }} </h3>
    <h4> Price: {{ price }} </h4>
    <a> Quantity: {{ quantity }}</a>
  </base-card>
</template>

<script>
import BaseCard from "@/components/BaseCard";

export default {
  name: "ProductComponent",
  components: {BaseCard},
  props: ['id', 'name', 'price', 'quantity', 'image', 'isEdible'],
  data() {
    return {
      source: '../assets/image/' + this.image,
    }
  },
}
</script>

<style scoped>

</style>