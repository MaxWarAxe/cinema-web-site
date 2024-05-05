<script setup>
import FilmCard from '@/components/FilmCard.vue';
import FilmSepLine from '@/components/FilmSepLine.vue';
</script>

<template>
    <div class="film_list">
        <FilmCard />
        <FilmSepLine />
    </div>
</template>


<style scoped>
.film_list {
    width: 1200px;
    height: auto;
    display: inline;
    padding-top: 25px;
}
</style>