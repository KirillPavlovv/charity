<template>
  <div>
    <b-button class="btn btn-primary w-75 text-white mt-3" v-on:click="showModal()">Checkout</b-button>
    <b-modal id="my-modal">Hello From My Modal!</b-modal>
  </div>
</template>

<script>
export default {
  name: "CheckoutCashComponent",
  props: ['orderRequest', 'showCashModal'],

  data() {
    return {}
  },
  methods: {
    changeProductStock() {
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
    showModal() {
      // eslint-disable-next-line vue/no-mutating-props
      this.showCashModal = true;
    },
    hideModal() {
      this.$refs['my-modal'].hide()
    },

  }
}
</script>

<style scoped>


</style>