<script setup>
    import AdminButton from '@/components/AdminButton.vue'
    
    let list = []
    for(let i = 0; i < 20; i++){
        list.push(0)
    }
</script>

<template>
    <div class="panel">
        <AdminButton v-for="n in 20"/>
    </div>
</template>


<style scoped>
    .panel{
        width: 1200px;
        height: auto;
        display: inline;
        padding-top: 25px;
    }
</style>