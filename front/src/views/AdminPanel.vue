<script setup>
    import ButtonCustom from '@/components/ButtonCustom.vue'
    import FilmSepLine from '@/components/FilmSepLine.vue';

    let list = []
    for(let i = 0; i < 20; i++){
        list.push(0)
    }
</script>

<template>
    <div class="panel">
        <ButtonCustom class="buttonA" text="Редактировать показы"/>
        <FilmSepLine class="mb-5"/>
        <ButtonCustom class="buttonA" text="Редактировать фильмы"/>
        <ButtonCustom class="buttonA" text="Редактировать режиссеров"/>
        <ButtonCustom class="buttonA" text="Редактировать актеров"/>
        <ButtonCustom class="buttonA" text="Редактировать страны"/>
        <ButtonCustom class="buttonA" text="Редактировать жанры"/>
        <FilmSepLine class="mb-5"/>
        <ButtonCustom class="buttonA" text="Редактировать залы"/>
        <ButtonCustom class="buttonA" text="Редактировать места"/>
        <FilmSepLine class="mb-5"/>
        <ButtonCustom class="buttonA" text="Редактировать аккаунты сотрудников"/>
    </div>
</template>


<style scoped>
    .panel{
        width: 1200px;
        height: auto;
        display: inline;
        padding-top: 25px;
    }
    .buttonA{
        margin-right: 20px;
        margin-bottom: 20px;
    }
</style>