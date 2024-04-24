<script setup>
import Header from './components/Header.vue';
import FilmList from './views/FilmList.vue';
</script>

<template>

  <Header></Header>
  <main>
    <RouterView/>
  </main>

</template>

<style scoped>
  main {
    width: 100%;
    height: 1000px;
    display: flex;
    justify-content: center;

  }
</style>
