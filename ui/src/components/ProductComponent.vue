<template>
  <div> {{ name }}</div>

</template>

<script>
export default {
  name: "ProductComponent",
  props: ['id', 'name', 'price', 'quantity', 'image', 'isEdible']
}
</script>

<style scoped>

</style>