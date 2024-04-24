<template>
    <div class="panel">
        <ButtonCustom class="buttonA" text="Отчет о прибыли фильмов за промежуток времени"/>
        <FilmSepLine class="mb-5"/>
        <ButtonCustom class="buttonA" text="Отчет о прибыли показов с выбором фильма и промежутка времени"/>
        <FilmSepLine class="mb-5"/>
        <ButtonCustom class="buttonA" text="Отчет о загруженности залов за промежуток времени"/>
    </div>
</template>

<script setup>
    import ButtonCustom from '@/components/ButtonCustom.vue'
    import FilmSepLine from '@/components/FilmSepLine.vue';
</script>

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