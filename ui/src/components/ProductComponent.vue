<template>
  <base-card>
    <div class="row">
      <div class="col">
        <button id="button" @click="count()">
          <img :src=image class="bg-image img-thumbnail rounded mx-auto d-block" style="width: 150px; height: 150px;"
               :class="{mask: quantity<=0}" alt="photo">
        </button>

      </div>
      <div class="col">
        <h3> Cake: {{ name }} </h3>
        <h4> Price: {{ price }} </h4>
        <a> Quantity: {{ quantity }}</a>
        <h5 v-show="itemsToBuy>0" style="color: red"> To buy: {{ itemsToBuy }}</h5>
        <a v-show="totalSum>0" style="color: red"> To pay: {{ totalSum }}</a>
      </div>
    </div>
  </base-card>
</template>

<script>
import BaseCard from "@/components/BaseCard";
import EventBus from "@/components/event-bus";

export default {
  name: "ProductComponent",
  components: {BaseCard},
  props: ['id', 'name', 'price', 'quantity', 'image', 'isEdible'],
  data() {
    return {
      itemsToBuy: 0,
      totalSum: 0,
      quantityAfterOrder: this.quantity,
    }
  },
  methods: {
    count() {
      if (this.quantity > 0) {
        this.itemsToBuy = this.itemsToBuy + 1;
        // eslint-disable-next-line vue/no-mutating-props
        this.quantity = this.quantity - 1;
        if (this.quantity < 0) {
          // eslint-disable-next-line vue/no-mutating-props
          this.quantity = 0
        }

        this.totalSum = this.itemsToBuy * this.price
      }
      EventBus.$emit('payForItem', this.totalSum)
    },
  }
}
</script>

<style scoped>
#button {
  border: white;
  padding: 0;
}

.mask {
  opacity: 0.4;
  filter: alpha(opacity=40); /* msie */
  background-color: #000;
}

</style>