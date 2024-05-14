<template>
    <div>
        <input  :placeholder="defaultText" class="bg-slate-900 p-2 text-cyan-50 border-solid border-white border-2 rounded-lg" :type="type">
    </div>
</template>

<script setup>
    const props = defineProps({
        defaultText : String,
        type : String
    })
</script>

<style scoped>
    input:focus{
        animation-name: focus;
        animation-duration:1s;
    }
    @keyframes focus {
        0%, 10% {transform: scale(1);}
        10%,20% {transform: scale(1.1);}
        80%,100%{transform: scale(1);}
    }
    input:hover{
        filter: brightness(1.2);
    }
</style>