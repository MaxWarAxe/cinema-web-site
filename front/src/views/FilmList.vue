<script setup>

import FilmButton from '@/components/FilmButton.vue';
import { ref, watch } from 'vue'
import axios from 'axios'

const film_model = {
    name: ""
}

const film_list = ref()
let loaded = ref(false)
axios({
    method: 'get',
    url: 'http://localhost:8080/films',
    headers: {
        "Content-Type": "application/json",
    }
})
    .then(function (response) {
        console.log(response.data);
        film_list.value = response.data;
        console.log(film_list.value)
    })
    .catch(function (error) {
        console.log(error);
    });



</script>

<template>
    <div class="panel">
        <FilmButton class="mr-11 mb-11" v-for="film in film_list" :film_name="film.name" />
    </div>
</template>

<style scoped>
.panel {
    width: 1200px;
    height: auto;
    display: inline;
    padding-top: 25px;
}
</style>