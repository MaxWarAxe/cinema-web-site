<template>
    <div>

    </div>
</template>

<script setup>
    import axios from 'axios'
    
    axios.get('http://localhost:8080/films')
    .then(function (response) {
        console.log(response);
    })
    .catch(function (error) {
        console.log(error);
    });
    console.log("123")
</script>   

<style scoped></style>