<template>
  <base-card>
    <div class="row">
      <div class="col">
        <img :src=image class="img-thumbnail rounded mx-auto d-block" style="width: 150px; height: 150px;">
      </div>
      <div class="col">
        <h3> Cake: {{ name }} </h3>
        <h4> Price: {{ price }} </h4>
        <a> Quantity: {{ quantity }}</a>
      </div>
    </div>
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
      // source: '../assets/image/'+this.image,
    }
  },
}
</script>

<style scoped>

</style>