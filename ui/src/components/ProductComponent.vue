<template>
  <base-card>
    <div class="row">
      <div class="col">
        <button @click="count()">
          <img :src=image class="bg-image img-thumbnail rounded mx-auto d-block" style="width: 150px; height: 150px;"
               :class="{mask: quantityAfterOrder<=0}" alt="photo">
        </button>

      </div>
      <div class="col">
        <h3> Cake: {{ name }} </h3>
        <h4> Price: {{ price }} €</h4>
        <p> Quantity: {{ quantityAfterOrder }}</p>
        <h5 v-show="productsStock.quantity>0" style="color: red"> To buy: {{ productsStock.quantity }}</h5>
        <p v-show="totalSum>0" style="color: red"> To pay: {{ parseFloat(totalSum).toFixed(2) }} € </p>
      </div>
    </div>
  </base-card>
</template>

<script>
import EventBus from "@/components/event-bus";
import BaseCard from "@/components/BaseCard";

export default {
  name: "ProductComponent",
  components: {BaseCard},
  props: ['id', 'name', 'price', 'quantity', 'image', 'isEdible'],
  data() {
    return {

      totalSum: 0,
      quantityAfterOrder: this.quantity,
      productsStock:{
        id: this.id,
        quantity: 0,
      }
    }
  },
  methods: {
    count() {
      if (this.quantityAfterOrder > 0) {
        this.productsStock.quantity = this.productsStock.quantity + 1;
        this.quantityAfterOrder = this.quantityAfterOrder - 1;
        if (this.quantity < 0) {
          this.quantity = 0
        }
        this.totalSum = this.productsStock.quantity * this.price
        EventBus.$emit('payForItem', {'price': this.price, 'productsStock': this.productsStock})
      }
    },
  },
  mounted() {
    EventBus.$on('reset', data => {
      if (data === false){
        this.$forceUpdate();
      }
    });
  }
}
</script>

<style scoped>
button {
  padding: 0;
  background-color: #ffffff;
  border: 1px solid #ffffff;
}

.mask {
  opacity: 0.4;
  filter: alpha(opacity=40); /* msie */
  background-color: #000;
}

</style>