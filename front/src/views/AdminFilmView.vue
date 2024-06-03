<template>
    <v-data-table v-if="loaded" items-per-page="1000" :headers="headers" :items="items">
        <template v-slot:top>
            <v-toolbar flat>
                <v-toolbar-title>Таблица</v-toolbar-title>
                <v-divider class="mx-4" inset vertical></v-divider>
                <v-spacer></v-spacer>
                <v-dialog v-model="dialog" max-width="500px">
                    <template v-slot:activator="{ props }">
                        <v-btn @click="mapAndClearModelArray" class="mb-2" color="primary" dark v-bind="props">
                            Добавить
                        </v-btn>
                    </template>
                    <v-card>
                        <v-card-title>
                            <span class="text-h5">Добавить новую запись</span>
                        </v-card-title>

                        <v-card-text>
                            <v-container>
                                <v-row>
                                    <v-text-field v-model="editedItem.name" label="Название"></v-text-field>
                                </v-row>
                                <v-row>
                                    <v-date-input v-model="editedItem.film_premiere_date"
                                        label="Мировая премьера"></v-date-input>
                                </v-row>
                                <v-row>
                                    <v-select multiple v-model="editedItem.film_genres" :items="allGenres" label="Жанры"></v-select>
                                </v-row>
                                <v-row>
                                    <v-text-field v-model="editedItem.film_duration"
                                        label="Длительность"></v-text-field>
                                </v-row>
                                <v-row>
                                    <v-text-field v-model="editedItem.film_description" label="Описание"></v-text-field>
                                </v-row>
                                <v-row>
                                    <v-select multiple v-model="editedItem.film_actors" :items="allActors" label="Актеры"></v-select>
                                </v-row>
                                <v-row>
                                    <v-select multiple v-model="editedItem.film_directors" :items="allDirectors" label="Режиссеры"></v-select>
                                </v-row>
                                <v-row>
                                    <v-file-input v-model="editedItem.film_image" label="Картинка"></v-file-input>
                                </v-row>

                            </v-container>
                        </v-card-text>

                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="blue-darken-1" variant="text" @click="close">
                                Cancel
                            </v-btn>
                            <v-btn color="blue-darken-1" variant="text" @click="save">
                                Save
                            </v-btn>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
                <v-dialog v-model="dialogDelete" max-width="500px">
                    <v-card>
                        <v-card-title class="text-h5">Вы уверены, что хотите удалить?</v-card-title>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="blue-darken-1" variant="text" @click="closeDelete">Отмена</v-btn>
                            <v-btn color="blue-darken-1" variant="text" @click="deleteItemConfirm">Подтвердить</v-btn>
                            <v-spacer></v-spacer>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
            </v-toolbar>
        </template>
        <template v-slot:item.actions="{ item }">
            <v-icon class="me-2" size="small" @click="editItem(item)">
                mdi-pencil
            </v-icon>
            <v-icon size="small" @click="deleteItem(item)">
                mdi-delete
            </v-icon>
        </template>
        <template v-slot:item.film_actors="{ item }">
            <v-select chips readonly variant="underlined" :items="item.film_actors" v-model="item.film_actors"></v-select>
        </template>
        <template v-slot:item.film_directors="{ item }">
            <span>{{ item.film_directors }}</span>
        </template>

        <template v-slot:no-data>
            <v-btn color="primary" @click="initialize">
                Reset
            </v-btn>
        </template>
    </v-data-table>
</template>

<script setup>
import { ref } from 'vue'
import { useRoute } from 'vue-router';
import axios from 'axios';
import serverUrl from '@/config';

let route = useRoute()
let loaded = ref(false)
let dialog = ref(false)
let editedIndex = ref()
let dialogDelete = ref(false)
let modelArray = ref([])

let allGenres = ref(["a","b","c","d","e"])
let allActors = ref(["a","b","c","d","e"])
let allDirectors = ref(["a","b","c","d","e"])
let editedItem = ref({
    name: '',
    film_premiere_date: 2003,
    genres: ["a", "b", "c"],
    film_duration: 0,
    film_description: 0,
    film_age_rating: 0,
    film_actors: ["a", "b", "c"],
    film_directors: ["a", "b", "c"],
    film_image: "image",
})
let defaultItem = ref({
    name: 'nadssqw',
    film_genres: ["a", "b", "c"],
    film_premiere_date: 0,
    film_duration: 0,
    film_description: 0,
    film_age_rating: 0,
    film_actors: ["a", "b", "c"],
    film_directors: ["a", "b", "c"],
    film_image: "image",
})



let headers = ref([
    { title: 'Назване', key: 'name' },
    { title: "Мировая премьера", key: "film_premiere_date" },
    { title: "Жанры", key: "film_genres" },
    { title: "Длительность", key: "film_duration" },
    { title: "Описание", key: "film_description" },
    { title: "Возрастной рейтинг", key: "film_age_rating" },
    { title: "Актёры", key: "film_actors" },
    { title: "Режиссеры", key: "film_directors" },
    { title: "Превью", key: "film_image" },
    { title: 'Действия', key: 'actions', sortable: false },
])

function mapAndClearModelArray() {
    mapModelArray()
    for (let i = 0; i < modelArray.value.length; i++) {
        modelArray.value[i] = ''
    }
}

function mapModelArray() {
    let keys = Object.keys(defaultItem.value)
    console.log(keys)
    for (let i = 0; i < keys.length; i++) {
        editedItem.value[keys[i]] = modelArray.value[i]
    }
}

function mapFromItemToModelArray() {
    let keys = Object.keys(defaultItem.value)
    console.log(keys)
    for (let i = 0; i < keys.length; i++) {
        modelArray.value[i] = editedItem.value[keys[i]]
    }
}

function editItem(item) {
    editedIndex.value = items.value.indexOf(item)
    editedItem.value = Object.assign({}, item)
    dialog.value = true
    mapFromItemToModelArray()
}

function deleteItem(item) {
    editedIndex.value = items.value.indexOf(item)
    editedItem.value = Object.assign({}, item)
    dialogDelete.value = true
}


function close() {
    dialog.value = false
    editedIndex.value = -1
}

function closeDelete() {
    dialogDelete.value = false
    editedItem.value = Object.assign({}, defaultItem.value)
    editedIndex.value = -1
}

function deleteItemConfirm() {
    items.value.splice(editedIndex.value, 1)
    editedItem.value = Object.assign({}, defaultItem.value)
    closeDelete()
}

function save() {
    mapModelArray()
    if (editedIndex.value > -1) {
        Object.assign(items.value[editedIndex.value], editedItem.value)
    } else {
        items.value.push(editedItem.value)
    }
    close()
}

function initHeaders() {
    let headersStr = Object.keys(defaultItem.value)
    let headersArray = []
    for (let i = 0; i < headersStr.length; i++) {
        headersArray.push({ title: headersStr[i], key: headersStr[i] })
    }
    headersArray.push({ title: 'Actions', key: 'actions', sortable: false })
    console.log("4")
    console.log(headersArray)
    return headersArray
}

function initAfterGet() {

    defaultItem.value = items.value[0]
    loaded.value = true;
    headers.value = initHeaders()
}



function getData() {
        axios({
            method: 'get',
            url: serverUrl() + "/" + route.params.name,
            headers: {
                "Content-Type": "application/json",
            }
        })
        .then(function (response) {
            console.log(response.data);
            items.value = response.data;
            initAfterGet()
        })
        .catch(function (error) {
            console.log(error);
        });
}
//getData()
let items = ref([])

items.value.push(defaultItem.value)
items.value.push({})
loaded.value = true
</script>

<style scoped></style>