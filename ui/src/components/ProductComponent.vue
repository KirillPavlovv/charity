<template>
  <base-card>
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
  props: ['id', 'name', 'price', 'quantity', 'image', 'isEdible']
}
</script>

<style scoped>

</style>