<template>
    <div class="card cursor-pointer h-96 w-fit inline-block rounded-3xl relative">
        <img class="film_img rounded-3xl" src="@/assets/images/example.png" alt="">
        <div class="rect rounded-bl-3xl rounded-br-3xl pt-5">
            <div class="text-white text-center text-lg mb-10">
                {{ film_name }}
            </div>
            <div class="text-white text-center text-lg genres">Драма, боевик</div>
        </div>
    </div>
</template>

<script setup>
const props = defineProps({
    film_name: String,
})
</script>

<style scoped>
.film_img {
    height: 100%;
}

.rect {
    position: absolute;
    width: 100%;
    height: 20%;
    top: 80%;
    background-color: rgba(0, 0, 0, 0.8);

    transition: 0.2s;
}

.card {
    transition: 0.2s;
    overflow: hidden;
    white-space: nowrap;
}

.card:hover {
    .rect {
        top: 60%;
        height: 40%;
    }
}

img {
    pointer-events: none;
}

.card:active {

    transform: scale(0.9);
}
</style>