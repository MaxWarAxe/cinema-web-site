<template>
    <div ref="htelem" class="block p-20">
        <h class="text-white mb-10 block text-3xl">Получить отчет о загруженности залов за определенный период времени
        </h>
        <div class="block justify-items-center mb-10">
            <div class="m-10">
                <label class="text-white w-40 inline-block" for="start">Начальная дата:</label>
                <input v-model="dateStartRef" type="date" id="start" value="2018-07-22" min="2024-01-01"
                    max="2025-12-31" />
            </div>
            <div class="m-10">
                <label class="text-white w-40 inline-block" for="start">Конечная дата:</label>
                <input v-model="dateEndRef" type="date" id="start" value="2018-07-22" min="2024-01-01"
                    max="2025-12-31" />
            </div>
            <ButtonCustom @click="getReport" class="ml-10" text="Сформировать отчет"></ButtonCustom>
            <ButtonCustom @click="getPDF" class="ml-10" text="Скачать в PDF"></ButtonCustom>
        </div>

        <v-data-table id="html2pdf" :items="items"></v-data-table>

    </div>
</template>

<script setup>
import ButtonCustom from '@/components/ButtonCustom.vue';
import axios from 'axios';
import serverUrl from '@/config';
import jsPDF from 'jspdf';

import { ref } from 'vue'

let dateStartRef = ref()
let dateEndRef = ref()

function getReport() {

    const params = new URLSearchParams({
        dateStart: dateStartRef.value,
        dateEnd: dateEndRef.value
    }).toString();

    axios({
        method: 'get',
        url: serverUrl() + '/reports/occupancy?' + params,
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
const htelem = ref()
function getPDF() {
    const doc = new jsPDF('p', 'pt', 'A4')
    doc.html(htelem.value).save("отчет")
}

const items = ref()
</script>

<style scoped></style>