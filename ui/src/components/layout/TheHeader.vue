<template>
  <header>
    <nav style="padding: 20px">
      <router-link to="/"> Products </router-link>
    </nav>
  </header>
</template>

<script>
export default {
  name: "TheHeader"
}
</script>

<style scoped>

@media screen and (min-width: 900px) {
  router-link {
    min-width: 500px
  }
}
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