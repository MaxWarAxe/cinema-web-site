<script setup>
import ButtonCustom from '@/components/ButtonCustom.vue'
import FilmSepLine from '@/components/FilmSepLine.vue';

let list = []
for (let i = 0; i < 20; i++) {
    list.push(0)
}
</script>

<template>
    <div class="panel">
        <RouterLink to="/admin/shows">
            <ButtonCustom class="buttonA" text="Редактировать показы" />
        </RouterLink>
        <FilmSepLine class="mb-5" />
        <RouterLink to="/admin/film">
            <ButtonCustom class="buttonA" text="Редактировать фильмы" />
        </RouterLink>
        <RouterLink to="/admin/director">
            <ButtonCustom class="buttonA" text="Редактировать режиссеров" />
        </RouterLink>
        <RouterLink to="/admin/actor">
            <ButtonCustom class="buttonA" text="Редактировать актеров" />
        </RouterLink>
        <RouterLink to="/admin/country">
            <ButtonCustom class="buttonA" text="Редактировать страны" />
        </RouterLink>
        <RouterLink to="/admin/genre">
            <ButtonCustom class="buttonA" text="Редактировать жанры" />
        </RouterLink>
        <FilmSepLine class="mb-5" />
        <RouterLink to="/admin/hall">
            <ButtonCustom class="buttonA" text="Редактировать залы" />
        </RouterLink>
        <RouterLink to="/admin/tickets">
            <ButtonCustom class="buttonA" text="Редактировать билеты" />
        </RouterLink>
        <RouterLink to="/admin/seat">
            <ButtonCustom class="buttonA" text="Редактировать места" />
        </RouterLink>


        <FilmSepLine class="mb-5" />
        <RouterLink to="/admin/account">
            <ButtonCustom class="buttonA" text="Редактировать аккаунты сотрудников" />
        </RouterLink>

    </div>
</template>


<style scoped>
.panel {
    width: 1200px;
    height: auto;
    display: inline;
    padding-top: 25px;
}

.buttonA {
    margin-right: 20px;
    margin-bottom: 20px;
}
</style>