<template>
  <base-card>
    <h4>Click Update to insert charity goods from file "goods.txt"</h4>
    <div class="col">
      <button class="btn btn-primary w-75 text-white mt-3 mr-1" v-on:click="updateGoodsQuantities">Update</button>
    </div>
  </base-card>
</template>

<script>
import BaseCard from "@/components/BaseCard";

export default {
  name: "InsertView",
  components: {BaseCard},
  methods: {
    updateGoodsQuantities() {
      fetch('update-quantities', {
        credentials: "include",
        method: 'GET',
      })
          .then(response => response.json())
          .then(data => {
            this.errorMessage = data.title;
          })
          .catch(error => console.error(error));
    },
  },
}
</script>

<style scoped>

</style>