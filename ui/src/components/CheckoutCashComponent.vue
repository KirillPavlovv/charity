<template>
  <div>
    <button class="btn btn-primary w-75 text-white mt-3 mr-1" v-on:click="toggleModal()">Checkout</button>
    <transition name="modal" v-if="showCashModal" class="modal">
      <div class="modal__wrapper">
        <div class="modal-content">
          <div class="modal-header">
          </div>
          <form @submit.prevent="changeProductStock">
              <div class="form-control">

                <div class="row">
                  <label class="col">Total amount to pay: </label>
                  <label class="col"> {{ parseFloat(orderRequest.totalSum).toFixed(2) }} €</label>
                </div>
                <div class="row">
                  <label class="col" for="gotFromCustomer">Customer paid: </label>
                  <input class="col w-25" type="number" id="gotFromCustomer" v-model.trim="cashFromCustomer">
                  <button class="col btn btn-outline-success w-auto" @click="calculateAmountOfChange()">OK</button>
                </div>
                <div class="row">
                  <label class="col">Amount of change: </label>
                  <label class="col"> {{ parseFloat(amountOfChange).toFixed(2) }} €</label>
                </div>
              </div>

              <div class="row">
                <div class="col">
                  <button class="btn btn-primary w-75 text-white mt-3 mr-1" v-on:click="toggleModal()">Close</button>
                </div>
                <div class="col">
                  <button class="btn btn-primary w-75 text-white mt-3 mr-1">Checkout</button>
                </div>
              </div>
          </form>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
export default {
  name: "CheckoutCashComponent",
  props: ['orderRequest'],
  data() {
    return {
      showCashModal: false,
      cashFromCustomer: 0,
      amountOfChange: 0,
    }
  },
  mounted() {
    document.body.addEventListener('keyup', e => {
      if (e.keyCode === 27) {
        this.$emit('close')
      }
    })
  },
  methods: {
    calculateAmountOfChange(){
      this.amountOfChange = this.cashFromCustomer - this.orderRequest.totalSum;
    },
    toggleModal() {
      this.showCashModal = !this.showCashModal
    },
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
  },

}
</script>

<style scoped>
.modal-enter .modal-content,
.modal-leave-active .modal-content {
  transform: scale(1.2)
}

.modal__wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  transition: opacity .2s ease;
  right: 0;
  z-index: 998;
  background-color: rgba(00, 00, 00, .48);
}

.modal-content {
  position: relative;
  max-width: 600px;
  padding: 20px 18px;
  background-color: #fff;
  border: 1px solid #dcdfe6;
  transition: all .2s ease;
  border-radius: 8px;
  z-index: 999;
  overflow: hidden;
}

@media screen and (min-width: 900px) {
  .modal-content {
    min-width: 500px
  }
}

.modal-header {
  display: flex;
  align-self: center;
  justify-content: space-between;
  padding-bottom: 20px;
}

span {
  font-size: 24px;
}

.form-control {
  margin: 0.5rem 0;
}
.btn-outline-success{
  margin-left: 25px;
  margin-right: 25px;
}
label {
  text-align: left;
  font-weight: bold;
  display: block;
  margin-bottom: 0.5rem;
}

input {
  display: block;
  border: 1px solid #ccc;
  font: inherit;
}

input:focus {
  background-color: #f0e6fd;
  outline: none;
  border-color: #3d008d;
}
.invalid label {
  color: red;
}

.invalid input {
  border: 1px solid red;
}

</style>