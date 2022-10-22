<template>
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
        <h5 v-show="productStock.quantity>0" style="color: red"> To buy: {{ productStock.quantity }}</h5>
        <p v-show="totalSum>0" style="color: red"> To pay: {{ parseFloat(totalSum).toFixed(2) }} € </p>
      </div>
    </div>
</template>

<script>
import EventBus from "@/components/event-bus";

export default {
  name: "ProductComponent",
  props: ['id', 'name', 'price', 'quantity', 'image', 'isEdible'],
  data() {
    return {

      totalSum: 0,
      quantityAfterOrder: this.quantity,
      productStock:{
        id: this.id,
        quantity: 0,
      }
    }
  },
  methods: {
    count() {
      if (this.quantityAfterOrder > 0) {
        this.productStock.quantity = this.productStock.quantity + 1;
        // eslint-disable-next-line vue/no-mutating-props
        this.quantityAfterOrder = this.quantityAfterOrder - 1;
        if (this.quantity < 0) {
          // eslint-disable-next-line vue/no-mutating-props
          this.quantity = 0
        }
        this.totalSum = this.productStock.quantity * this.price
        EventBus.$emit('payForItem', {'price': this.price, 'productStock': this.productStock})
      }
    },
  },
  mounted() {
    EventBus.$on('reset', data => {
      if (data === false){
        this.$forceUpdate()
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

.row{
  border-radius: 12px;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  margin: 1rem auto;
  max-width: 100rem;
}

</style>