<script setup>
import FilmCard from '@/components/FilmCard.vue';
import FilmSepLine from '@/components/FilmSepLine.vue';
import DayButton from '@/components/DayButton.vue';
import { useRouter, useRoute } from 'vue-router';
import axios from 'axios';
import { ref, watch } from 'vue'


let date = new Date()
let dateList = ref([])
let router = useRouter()
let route = useRoute()
for (let i = 0; i < 7; i++) {
    let newDate = new Date(date)
    newDate.setDate(newDate.getDate() + i)
    dateList.value.push(newDate)
}
let filmList = ref()

watch(() => route.params.date, (newDate, oldDate) => {
    getShows()
})

function getShows() {
    axios({
        method: 'get',
        url: 'http://localhost:8080/shows/' + router.currentRoute.value.params.date,
        headers: {
            "Content-Type": "application/json",
        }
    })
        .then(function (response) {
            let obj = response.data;
            obj = Object.groupBy(obj, ({ filmId }) => filmId)
            filmList.value = Object.entries(obj)
            console.log(Object.entries(obj))
        })
        .catch(function (error) {
            console.log(error);
        });
}
getShows()

</script>

<template>

    <div class="film_list">
        <div class="mb-5 overflow-x-auto overflow-y-hidden whitespace-nowrap">
            <RouterLink v-for="day in dateList" :to="day.toLocaleDateString('en-CA')">
                <DayButton class="mr-7" :date="day" />
            </RouterLink>

        </div>
        <FilmSepLine class="mb-10" />
        <div v-for="film in filmList">
            <FilmCard :film-id="film[0]" />
            <FilmSepLine class="mb-10" />
        </div>

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