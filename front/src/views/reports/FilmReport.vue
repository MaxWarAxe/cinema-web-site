<template>
    <div class="block p-20">
        <h class="text-white mb-10 block text-3xl">Получить отчет о прибыли фильмов за определенный период времени</h>
        <div class="block justify-items-center mb-10">
            <div class="m-10">
                <label class="text-white w-40 inline-block" for="start">Начальная дата:</label>
                <input type="date" id="start" name="trip-start" value="2018-07-22" min="2024-01-01" max="2025-12-31" />
            </div>
            <div class="m-10">
                <label class="text-white w-40 inline-block" for="start">Конечная дата:</label>
                <input type="date" id="start" name="trip-start" value="2018-07-22" min="2024-01-01" max="2025-12-31" />
            </div>
            <ButtonCustom class="ml-10" text="Сформировать отчет"></ButtonCustom>
            <ButtonCustom class="ml-10" text="Скачать в PDF"></ButtonCustom>
        </div>
        
        <v-data-table :items="items"></v-data-table>
        
    </div>
</template>

<script setup>
import ButtonCustom from '@/components/ButtonCustom.vue';
const items = [
    {
      name: 'African Elephant',
      species: 'Loxodonta africana',
      diet: 'Herbivore',
      habitat: 'Savanna, Forests',
    },
]
</script>

<style scoped>

</style>