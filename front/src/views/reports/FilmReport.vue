<template>
    <div class="block p-20">
        <h class="text-white mb-10 block text-3xl">Получить отчет о прибыли фильмов за определенный период времени</h>
        <div class="block justify-items-center mb-10">
            <div class="m-10">
                <label class="text-white w-40 inline-block" for="start">Начальная дата:</label>
                <input v-model="dateStartRef" type="date" id="start" name="trip-start" value="2018-07-22"
                    min="2024-01-01" max="2025-12-31" />
            </div>
            <div class="m-10">
                <label class="text-white w-40 inline-block" for="start">Конечная дата:</label>
                <input v-model="dateEndRef" type="date" id="start" name="trip-start" value="2018-07-22" min="2024-01-01"
                    max="2025-12-31" />
            </div>
            <ButtonCustom @click="getReport" class="ml-10" text="Сформировать отчет"></ButtonCustom>
            <ButtonCustom @click="getXLSX" class="ml-10" text="Скачать в Excel"></ButtonCustom>
        </div>

        <v-data-table :items="items"></v-data-table>

    </div>
</template>

<script setup>
import ButtonCustom from '@/components/ButtonCustom.vue';
import { ref,toRaw } from 'vue'
import * as XLSX from 'xlsx';
import axios from 'axios';
import serverUrl from '@/config';

let dateStartRef = ref()
let dateEndRef = ref()

function getReport() {

    const params = new URLSearchParams({
        dateStart: dateStartRef.value,
        dateEnd: dateEndRef.value
    }).toString();

    axios({
        method: 'get',
        url: serverUrl() + '/reports/film?' + params,
        headers: {
            "Content-Type": "application/json",
        }
    })
        .then(function (response) {
            console.log(response.data);
            items.value = response.data;
        })
        .catch(function (error) {
            console.log(error);
        });
}

const items = ref()
function getXLSX() {
    let data = toRaw(items.value);

    const worksheet = XLSX.utils.json_to_sheet(data);
    const workbook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, worksheet, "Report");
    XLSX.writeFile(workbook, "Report.xlsx", { compression: true });

}
</script>

<style scoped></style>