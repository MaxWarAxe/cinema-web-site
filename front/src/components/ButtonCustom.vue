<script setup>
    const props = defineProps({
        text : String,
    })
</script>

<template>
    <button class="p-2 bg-slate-900 text-cyan-50 border-solid border-white border-2 rounded-xl">{{ text }}</button>
</template>


<style scoped>
    button{
        transition: 0.2s;
    }
    button:hover{
        transform: scale(1.1);
    }
    button:active{
        transform: scale(0.9);
    }
</style>