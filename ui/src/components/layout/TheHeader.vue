<template>
  <header>
    <nav>
      <router-link to="/"> Products </router-link>
      <router-link to="/insert-items">Insert items</router-link>
    </nav>
  </header>
</template>

<script>
export default {
  name: "TheHeader"
}
</script>

<style scoped>
header {
  width: 100%;
  height: 5rem;
  background-color: #5f327a;
  display: flex;
  justify-content: center;
  align-items: center;
}

header a {
  text-decoration: none;
  color: #ffffff;
  display: inline-block;
  padding: 0.75rem 1.5rem;
  border: 1px solid transparent;
}

a:active,
a:hover,
h1 {
  margin: 0;
}

h1 a {
  color: white;
  margin: 0;
}

h1 a:hover,
h1 a:active,
header nav {
  width: 90%;
  margin: auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

li {
  margin: 0 0.5rem;
}
</style>