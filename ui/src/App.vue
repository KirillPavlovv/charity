<template>
  <div id="app">
    <nav>
      <TheHeader></TheHeader>
    </nav>
    <router-view/>
  </div>
</template>

<script>

import TheHeader from "@/components/layout/TheHeader";
export default {
  name: 'App',
  components: {
    TheHeader
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}
</style>
